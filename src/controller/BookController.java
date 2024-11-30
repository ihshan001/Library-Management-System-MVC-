package controller;

import Model.Book;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rojeru_san.complementos.RSTableMetro;
import rojerusan.RSMetroTextPlaceHolder;

public class BookController {

    private Connection connection;
    private RSMetroTextPlaceHolder txtTitle, txtAuthor, txtGenre, txtTitleSearch, txtAuthorSearch, txtGenreSearch;
    private RSTableMetro tblBook;
    private JDateChooser yearPublished;

    //Consatructor for SearchBook
    public BookController(Connection connection, RSMetroTextPlaceHolder txtTitleSearch,
            RSMetroTextPlaceHolder txtAuthorSearch, RSMetroTextPlaceHolder txtGenreSearch,RSTableMetro tblBook) {
        this.connection = connection;
        this.txtTitleSearch = txtTitleSearch;
        this.txtAuthorSearch = txtAuthorSearch;
        this.txtGenreSearch = txtGenreSearch;
        this.tblBook = tblBook;
    }

    // Constructor for initializing components
    public BookController(Connection connection, RSMetroTextPlaceHolder txtTitle, RSMetroTextPlaceHolder txtAuthor, 
            RSMetroTextPlaceHolder txtGenre, RSTableMetro tblBook, JDateChooser yearPublished) {
        this.connection = connection;
        this.txtTitle = txtTitle;
        this.txtAuthor = txtAuthor;
        this.txtGenre = txtGenre;
        this.tblBook = tblBook;
        this.yearPublished = yearPublished;
    }

    // Load all books into the table
    public void loadBook() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblBook.getModel();
            model.setRowCount(0); // Clear existing rows

            String sql = "SELECT * FROM books";
            try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    model.addRow(new Object[]{
                        resultSet.getInt("bookID"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("genre"),
                        resultSet.getDate("yearPublished")
                    });
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading books: " + e.getMessage());
        }
    }

    // Add a new book
    public void addBook() {
        try {
            String title = txtTitle.getText();
            String author = txtAuthor.getText();
            String genre = txtGenre.getText();
            Date publishedYear = yearPublished.getDate();

            if (title.isEmpty() || author.isEmpty() || genre.isEmpty() || publishedYear == null) {
                JOptionPane.showMessageDialog(null, "All fields must be filled!");
                return;
            }

            String sql = "INSERT INTO books (title, author, genre, yearPublished) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, title);
                statement.setString(2, author);
                statement.setString(3, genre);
                statement.setDate(4, new java.sql.Date(publishedYear.getTime()));

                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Book added successfully!");
                loadBook();
                clearBookFields();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding book: " + e.getMessage());
        }
    }

    // Update a selected book
    public void updateBook() {
        try {
            int selectedRow = tblBook.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "No book selected for update!");
                return;
            }

            int bookID = Integer.parseInt(tblBook.getValueAt(selectedRow, 0).toString());
            String title = txtTitle.getText();
            String author = txtAuthor.getText();
            String genre = txtGenre.getText();
            Date publishedYear = yearPublished.getDate();

            if (title.isEmpty() || author.isEmpty() || genre.isEmpty() || publishedYear == null) {
                JOptionPane.showMessageDialog(null, "All fields must be filled!");
                return;
            }

            String sql = "UPDATE books SET title=?, author=?, genre=?, yearPublished=? WHERE bookID=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, title);
                statement.setString(2, author);
                statement.setString(3, genre);
                statement.setDate(4, new java.sql.Date(publishedYear.getTime()));
                statement.setInt(5, bookID);

                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Book updated successfully!");
                loadBook();
                clearBookFields();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating book: " + e.getMessage());
        }
    }

    // Delete a selected book
    public void deleteBook() {
        try {
            int selectedRow = tblBook.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "No book selected for deletion!");
                return;
            }

            int bookID = Integer.parseInt(tblBook.getValueAt(selectedRow, 0).toString());
            String sql = "DELETE FROM books WHERE bookID=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, bookID);
                statement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Book deleted successfully!");
                loadBook();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting book: " + e.getMessage());
        }
    }

    // Clear the input fields
    public void clearBookFields() {
        txtTitle.setText("");
        txtAuthor.setText("");
        txtGenre.setText("");
        yearPublished.setDate(null);
    }

    // Handle table row selection
    public void tblBook() {
        try {
            int selectedRow = tblBook.getSelectedRow();
            if (selectedRow < 0) {
                return;
            }

            txtTitle.setText(tblBook.getValueAt(selectedRow, 1).toString());
            txtAuthor.setText(tblBook.getValueAt(selectedRow, 2).toString());
            txtGenre.setText(tblBook.getValueAt(selectedRow, 3).toString());
            yearPublished.setDate((Date) tblBook.getValueAt(selectedRow, 4));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error selecting book: " + e.getMessage());
        }
    }

    // Method to search books by title, author, or genre
    public void searchBook() {
        String title = txtTitleSearch.getText().trim();
        String author = txtAuthorSearch.getText().trim();
        String genre = txtGenreSearch.getText().trim();

        // Validate search inputs
        if (title.isEmpty() && author.isEmpty() && genre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter at least one search criteria!");
            return;
        }

        try {
            DefaultTableModel model = (DefaultTableModel) tblBook.getModel();
            model.setRowCount(0); // Clear existing rows

            StringBuilder sql = new StringBuilder("SELECT * FROM books WHERE 1=1");
            if (!title.isEmpty()) {
                sql.append(" AND title LIKE ?");
            }
            if (!author.isEmpty()) {
                sql.append(" AND author LIKE ?");
            }
            if (!genre.isEmpty()) {
                sql.append(" AND genre LIKE ?");
            }

            try (PreparedStatement statement = connection.prepareStatement(sql.toString())) {
                int index = 1;
                if (!title.isEmpty()) {
                    statement.setString(index++, "%" + title + "%");
                }
                if (!author.isEmpty()) {
                    statement.setString(index++, "%" + author + "%");
                }
                if (!genre.isEmpty()) {
                    statement.setString(index++, "%" + genre + "%");
                }

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        model.addRow(new Object[]{
                            resultSet.getInt("bookID"),
                            resultSet.getString("title"),
                            resultSet.getString("author"),
                            resultSet.getString("genre"),
                            resultSet.getDate("yearPublished")
                        });
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error searching books: " + e.getMessage());
        }
    }

    // Method to reset search filters
    public void resetSearch() {
        txtTitleSearch.setText("");
        txtAuthorSearch.setText("");
        txtGenreSearch.setText("");
    }

}
