-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2024 at 07:31 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `librarydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminID` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `contactno` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminID`, `name`, `address`, `contactno`, `username`, `password`) VALUES
(1, 'Ihshan Ahamed', '', '', 'shan', '1234'),
(2, 'Ihshan Ahamed', '', '', 'shan', '1234'),
(3, 'Steve roger', 'unknown,Uk', '0887633443', 'steve', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `bookID` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `yearPublished` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`bookID`, `title`, `author`, `genre`, `yearPublished`) VALUES
(1, 'Harry Potter and the Philosopher\'s Stone', 'J.K. Rowling', 'Fantasy, Adventure', '1997-06-26'),
(2, 'Harry Potter and the Chamber of Secrets', 'J.K. Rowling', 'Fantasy, Adventure', '1998-07-02'),
(3, 'Harry Potter and the Prisoner of Azkaban', 'J.K. Rowling', 'Fantasy, Adventure', '1999-07-08'),
(4, 'Harry Potter and the Goblet of Fire', 'J.K. Rowling', 'Fantasy, Adventure', '2000-07-08'),
(5, 'Harry Potter and the Order of the Phoenix', 'J.K. Rowling', 'Fantasy, Adventure', '2003-06-21'),
(6, 'Harry Potter and the Half-Blood Prince', 'J.K. Rowling', 'Fantasy, Adventure', '2005-07-16'),
(7, 'Harry Potter and the Deathly Hallows', 'J.K. Rowling', 'Fantasy, Adventure', '2007-07-21'),
(8, 'The Lion, the Witch and the Wardrobe', 'C.S. Lewis', 'Fantasy, Adventure', '1950-10-16'),
(9, 'Prince Caspian', 'C.S. Lewis', 'Fantasy, Adventure', '1951-10-15'),
(10, 'The Voyage of the Dawn Treader', 'C.S. Lewis', 'Fantasy, Adventure', '1952-09-15'),
(11, 'The Silver Chair', 'C.S. Lewis', 'Fantasy, Adventure', '1953-09-07'),
(12, 'The Horse and His Boy', 'C.S. Lewis', 'Fantasy, Adventure', '1954-09-06'),
(13, 'The Magician\'s Nephew', 'C.S. Lewis', 'Fantasy, Adventure', '1955-05-02'),
(14, 'The Last Battle', 'C.S. Lewis', 'Fantasy, Adventure', '1956-09-04'),
(15, 'The Fellowship of the Ring', 'J.R.R. Tolkien', 'Fantasy, Adventure', '1954-07-29'),
(16, 'The Two Towers', 'J.R.R. Tolkien', 'Fantasy, Adventure', '1954-11-11'),
(17, 'The Return of the King', 'J.R.R. Tolkien', 'Fantasy, Adventure', '1955-10-20'),
(18, 'The Hobbit', 'J.R.R. Tolkien', 'Fantasy, Adventure', '1937-09-21'),
(19, 'Percy Jackson and the Lightning Thief', 'Rick Riordan', 'Fantasy, Adventure', '2005-06-28'),
(20, 'Percy Jackson and the Sea of Monsters', 'Rick Riordan', 'Fantasy, Adventure', '2006-05-03'),
(21, 'Percy Jackson and the Titan\'s Curse', 'Rick Riordan', 'Fantasy, Adventure', '2007-05-01'),
(22, 'Percy Jackson and the Battle of the Labyrinth', 'Rick Riordan', 'Fantasy, Adventure', '2008-05-06'),
(23, 'Percy Jackson and the Last Olympian', 'Rick Riordan', 'Fantasy, Adventure', '2009-05-05'),
(24, 'Dune', 'Frank Herbert', 'Science Fiction', '1965-08-01'),
(25, 'Dune Messiah', 'Frank Herbert', 'Science Fiction', '1969-10-01'),
(26, 'Children of Dune', 'Frank Herbert', 'Science Fiction', '1976-04-01'),
(27, 'Foundation', 'Isaac Asimov', 'Science Fiction', '1951-05-01'),
(28, 'Foundation and Empire', 'Isaac Asimov', 'Science Fiction', '1952-06-01'),
(29, 'Second Foundation', 'Isaac Asimov', 'Science Fiction', '1953-09-01'),
(30, 'Jurassic Park', 'Michael Crichton', 'Science Fiction, Adventure', '1990-11-20'),
(31, 'The Andromeda Strain', 'Michael Crichton', 'Science Fiction, Thriller', '1969-05-12'),
(32, 'Ready Player One', 'Ernest Cline', 'Science Fiction, Adventure', '2011-08-16'),
(33, 'The Martian', 'Andy Weir', 'Science Fiction, Adventure', '2014-02-11'),
(34, 'Ender\'s Game', 'Orson Scott Card', 'Science Fiction, Adventure', '1985-01-15'),
(35, 'The Da Vinci Code', 'Dan Brown', 'Thriller, Mystery', '2003-03-18'),
(36, 'Angels and Demons', 'Dan Brown', 'Thriller, Mystery', '2000-05-03'),
(37, 'Inferno', 'Dan Brown', 'Thriller, Mystery', '2013-05-14'),
(38, 'The Girl with the Dragon Tattoo', 'Stieg Larsson', 'Crime, Thriller', '2005-08-24'),
(39, 'Gone Girl', 'Gillian Flynn', 'Thriller, Mystery', '2012-06-05'),
(40, 'The Silent Patient', 'Alex Michaelides', 'Thriller, Mystery', '2019-02-05'),
(41, 'The Girl on the Train', 'Paula Hawkins', 'Thriller, Mystery', '2015-01-13'),
(42, 'The Hunger Games', 'Suzanne Collins', 'Dystopian, Adventure', '2008-09-14'),
(43, 'Catching Fire', 'Suzanne Collins', 'Dystopian, Adventure', '2009-09-01'),
(44, 'Mockingjay', 'Suzanne Collins', 'Dystopian, Adventure', '2010-08-24'),
(45, 'Divergent', 'Veronica Roth', 'Dystopian, Adventure', '2011-04-25'),
(46, 'Insurgent', 'Veronica Roth', 'Dystopian, Adventure', '2012-05-01'),
(47, 'Allegiant', 'Veronica Roth', 'Dystopian, Adventure', '2013-10-22'),
(48, 'The Maze Runner', 'James Dashner', 'Dystopian, Adventure', '2009-10-06'),
(49, 'The Scorch Trials', 'James Dashner', 'Dystopian, Adventure', '2010-10-12'),
(50, 'The Death Cure', 'James Dashner', 'Dystopian, Adventure', '2011-10-11'),
(51, 'Sherlock Holmes: A Study in Scarlet', 'Arthur Conan Doyle', 'Mystery', '1887-11-01'),
(52, 'The Hound of the Baskervilles', 'Arthur Conan Doyle', 'Mystery', '1902-04-01'),
(53, 'Murder on the Orient Express', 'Agatha Christie', 'Mystery, Thriller', '1934-01-01'),
(54, 'And Then There Were None', 'Agatha Christie', 'Mystery, Thriller', '1939-01-01'),
(55, 'Dracula', 'Bram Stoker', 'Horror', '1897-05-26'),
(56, 'Frankenstein', 'Mary Shelley', 'Horror', '1818-01-01'),
(57, 'The Shining', 'Stephen King', 'Horror, Thriller', '1977-01-28'),
(58, 'It', 'Stephen King', 'Horror, Thriller', '1986-09-15'),
(59, 'Pride and Prejudice', 'Jane Austen', 'Classic, Romance', '1813-01-28'),
(60, 'To Kill a Mockingbird', 'Harper Lee', 'Classic, Drama', '1960-07-11'),
(61, '1984', 'George Orwell', 'Classic, Dystopian', '1949-06-08'),
(62, 'Animal Farm', 'George Orwell', 'Classic, Satire', '1945-08-17'),
(63, 'The Notebook', 'Nicholas Sparks', 'Romance', '1996-10-01'),
(64, 'Me Before You', 'Jojo Moyes', 'Romance, Drama', '2012-01-05'),
(65, 'Outlander', 'Diana Gabaldon', 'Romance, Fantasy', '1991-06-01'),
(66, 'Sapiens: A Brief History of Humankind', 'Yuval Noah Harari', 'Non-Fiction, History', '2011-09-04'),
(67, 'Educated', 'Tara Westover', 'Non-Fiction, Memoir', '2018-02-18'),
(68, 'Treasure Island', 'Robert Louis Stevenson', 'Adventure, Classic', '1883-11-14'),
(69, 'Robinson Crusoe', 'Daniel Defoe', 'Adventure, Classic', '1719-04-25'),
(70, 'The Three Musketeers', 'Alexandre Dumas', 'Adventure, Historical Fiction', '1844-03-01'),
(71, 'All the Light We Cannot See', 'Anthony Doerr', 'Historical Fiction, Drama', '2014-05-06'),
(72, 'The Book Thief', 'Markus Zusak', 'Historical Fiction, Drama', '2005-03-14'),
(73, 'Circe', 'Madeline Miller', 'Fantasy, Mythology', '2018-04-10'),
(74, 'The Song of Achilles', 'Madeline Miller', 'Fantasy, Mythology', '2011-09-20'),
(75, 'American Gods', 'Neil Gaiman', 'Fantasy, Mythology', '2001-06-19'),
(76, 'Norse Mythology', 'Neil Gaiman', 'Fantasy, Mythology', '2017-02-07'),
(77, 'The Bourne Identity', 'Robert Ludlum', 'Action, Thriller', '1980-02-04'),
(78, 'The Hunt for Red October', 'Tom Clancy', 'Action, Thriller', '1984-10-01'),
(79, 'Casino Royale', 'Ian Fleming', 'Action, Spy Fiction', '1953-04-13'),
(80, 'The Spy Who Came in from the Cold', 'John le Carré', 'Action, Spy Fiction', '1963-09-01'),
(81, 'A Man Called Ove', 'Fredrik Backman', 'Contemporary Fiction', '2012-07-27'),
(82, 'Where the Crawdads Sing', 'Delia Owens', 'Contemporary Fiction, Mystery', '2018-08-14'),
(83, 'The Midnight Library', 'Matt Haig', 'Contemporary Fiction, Fantasy', '2020-08-13'),
(84, 'Charlotte\'s Web', 'E.B. White', 'Children, Classic', '1952-10-15'),
(85, 'Matilda', 'Roald Dahl', 'Children, Fantasy', '1988-10-01'),
(86, 'Charlie and the Chocolate Factory', 'Roald Dahl', 'Children, Fantasy', '1964-01-17'),
(87, 'The Tale of Peter Rabbit', 'Beatrix Potter', 'Children, Classic', '1902-10-16'),
(88, 'Neuromancer', 'William Gibson', 'Science Fiction, Cyberpunk', '1984-07-01'),
(89, 'Snow Crash', 'Neal Stephenson', 'Science Fiction, Cyberpunk', '1992-06-01'),
(90, 'Fahrenheit 451', 'Ray Bradbury', 'Science Fiction, Dystopian', '1953-10-19'),
(91, 'Brave New World', 'Aldous Huxley', 'Science Fiction, Dystopian', '1932-08-31'),
(92, 'The Haunting of Hill House', 'Shirley Jackson', 'Horror, Mystery', '1959-10-16'),
(93, 'Pet Sematary', 'Stephen King', 'Horror', '1983-11-14'),
(94, 'The Exorcist', 'William Peter Blatty', 'Horror', '1971-06-04'),
(95, 'The Alchemist', 'Paulo Coelho', 'Inspirational, Fiction', '1988-10-01'),
(96, 'Atomic Habits', 'James Clear', 'Self-Help, Non-Fiction', '2018-10-16'),
(97, 'The Power of Now', 'Eckhart Tolle', 'Self-Help, Spiritual', '1997-10-06'),
(98, 'Think and Grow Rich', 'Napoleon Hill', 'Self-Help, Business', '1937-01-01'),
(99, 'Steve Jobs', 'Walter Isaacson', 'Biography, Non-Fiction', '2011-10-24'),
(100, 'The Diary of a Young Girl', 'Anne Frank', 'Biography, Memoir', '1947-06-25'),
(101, 'Long Walk to Freedom', 'Nelson Mandela', 'Biography, Memoir', '1994-11-01'),
(102, 'Becoming', 'Michelle Obama', 'Memoir, Non-Fiction', '2018-11-13'),
(103, 'Maus', 'Art Spiegelman', 'Graphic Novel, Historical', '1986-09-01'),
(104, 'Watchmen', 'Alan Moore', 'Graphic Novel, Superhero', '1986-09-01'),
(105, 'Batman: The Killing Joke', 'Alan Moore', 'Graphic Novel, Superhero', '1988-03-29'),
(106, 'Persepolis', 'Marjane Satrapi', 'Graphic Novel, Memoir', '2000-10-01'),
(107, 'The Iliad', 'Homer', 'Poetry, Classic', '0750-01-01'),
(108, 'The Odyssey', 'Homer', 'Poetry, Classic', '0725-01-01'),
(109, 'Leaves of Grass', 'Walt Whitman', 'Poetry', '1855-07-04'),
(110, 'The Raven', 'Edgar Allan Poe', 'Poetry, Gothic', '1845-01-29'),
(111, 'Eleanor & Park', 'Rainbow Rowell', 'Young Adult, Romance', '2013-02-26'),
(112, 'The Fault in Our Stars', 'John Green', 'Young Adult, Romance', '2012-01-10'),
(113, 'Paper Towns', 'John Green', 'Young Adult, Mystery', '2008-10-16'),
(114, 'If I Stay', 'Gayle Forman', 'Young Adult, Drama', '2009-04-02'),
(115, 'Catch-22', 'Joseph Heller', 'Satire, Classic', '1961-10-10'),
(116, 'Good Omens', 'Neil Gaiman and Terry Pratchett', 'Comedy, Fantasy', '1990-05-01'),
(117, 'Hitchhiker\'s Guide to the Galaxy', 'Douglas Adams', 'Comedy, Science Fiction', '1979-10-12'),
(118, 'A Confederacy of Dunces', 'John Kennedy Toole', 'Comedy, Satire', '1980-01-01'),
(119, 'The Road', 'Cormac McCarthy', 'Dystopian, Drama', '2006-09-26'),
(120, 'Life of Pi', 'Yann Martel', 'Adventure, Drama', '2001-09-11'),
(121, 'The Kite Runner', 'Khaled Hosseini', 'Drama, Historical Fiction', '2003-05-29'),
(122, 'A Thousand Splendid Suns', 'Khaled Hosseini', 'Drama, Historical Fiction', '2007-05-22'),
(123, 'The Giver', 'Lois Lowry', 'Dystopian, Young Adult', '1993-04-26'),
(124, 'Coraline', 'Neil Gaiman', 'Fantasy, Horror', '2002-08-04'),
(125, 'Stardust', 'Neil Gaiman', 'Fantasy, Adventure', '1999-02-01');

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `memberID` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `contactNo` varchar(255) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `cardNumber` varchar(50) DEFAULT NULL,
  `expiryDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`memberID`, `name`, `contactNo`, `address`, `password`, `cardNumber`, `expiryDate`) VALUES
(1, 'Steve Roger', '065455323', 'Unknown Street, Uk', '1234', '001', '2025-11-23'),
(2, 'shan', '078544445', 'kandy', '1234', '002', '2025-11-24');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminID`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`bookID`);

--
-- Indexes for table `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`memberID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `adminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `bookID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=126;

--
-- AUTO_INCREMENT for table `members`
--
ALTER TABLE `members`
  MODIFY `memberID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
