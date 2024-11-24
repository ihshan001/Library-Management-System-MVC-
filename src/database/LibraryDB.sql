CREATE DATABASE IF NOT EXISTS LibraryDB;
USE LibraryDB;

CREATE TABLE IF NOT EXISTS Members (
    memberID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    contactInfo VARCHAR(255),
    cardNumber VARCHAR(50),
    expirationDate DATE
);

CREATE TABLE IF NOT EXISTS Books (
    bookID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    yearPublished INT
);
