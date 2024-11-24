package controller;

import Model.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class BookController {

    private Connection connection;

    public BookController(Connection connection) {
        this.connection = connection;
    }

    public void addBook(Book book) throws Exception {
        if (book.getTitle().isEmpty() || book.getAuthor().isEmpty() || book.getGenre().isEmpty()) {
            throw new Exception("All fields must be filled!");
        }

        String sql = "INSERT INTO books (title, author, genre, yearPublished) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getGenre());

            // Convert java.util.Date to java.sql.Date
            if (book.getPublishedYear() != null) {
                statement.setDate(4, new java.sql.Date(book.getPublishedYear().getTime())); // convert to sql.Date
            } else {
                statement.setNull(4, java.sql.Types.DATE); // Handle if the date is null
            }

            statement.executeUpdate();
        }
    }

    public void updateBook(Book book) throws Exception {
        if (book.getBookID() == 0) {
            throw new Exception("No book selected for update!");
        }

        String sql = "UPDATE books SET title=?, author=?, genre=?, yearPublished=? WHERE bookID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getGenre());

            // Convert java.util.Date to java.sql.Date for publishedYear
            if (book.getPublishedYear() != null) {
                statement.setDate(4, new java.sql.Date(book.getPublishedYear().getTime())); // Convert to sql.Date
            } else {
                statement.setNull(4, java.sql.Types.DATE); // Handle null value
            }

            statement.setInt(5, book.getBookID());
            statement.executeUpdate();
        }
    }

    public void deleteBook(int bookID) throws Exception {
        if (bookID == 0) {
            throw new Exception("No book selected for deletion!");
        }

        String sql = "DELETE FROM books WHERE bookID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bookID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error deleting book: " + e.getMessage());
        }
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Book book = new Book();
                book.setBookID(resultSet.getInt("bookID"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setGenre(resultSet.getString("genre"));

                // Convert java.sql.Date back to java.util.Date
                java.sql.Date sqlDate = resultSet.getDate("yearPublished");
                if (sqlDate != null) {
                    book.setPublishedYear(new java.util.Date(sqlDate.getTime()));
                }

                books.add(book);
            }
        }
        return books;
    }
    
     // Method to search books based on title, author, and genre
    public List<Book> searchBooks(String title, String author, String genre) throws SQLException {
        List<Book> books = new ArrayList<>();
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
                    Book book = new Book();
                    book.setBookID(resultSet.getInt("bookID"));
                    book.setTitle(resultSet.getString("title"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setGenre(resultSet.getString("genre"));
                    book.setPublishedYear(resultSet.getDate("yearPublished"));
                    books.add(book);
                }
            }
        }
        return books;
    }
}
