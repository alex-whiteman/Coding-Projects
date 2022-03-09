-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 09, 2022 at 04:20 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `books db`
--

-- --------------------------------------------------------

--
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
CREATE TABLE IF NOT EXISTS `authors` (
  `ID` varchar(5) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authors`
--

INSERT INTO `authors` (`ID`, `Name`) VALUES
('A1111', 'Paul Deitel'),
('A2222', 'John Ulman'),
('A3333', 'Johny Scott'),
('A4444', 'Scott Davis'),
('A5555', 'Norman Finkelstein'),
('A6666', 'Tom Davis');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
CREATE TABLE IF NOT EXISTS `books` (
  `ID` varchar(5) NOT NULL,
  `Title` varchar(60) DEFAULT NULL,
  `Category` varchar(32) DEFAULT NULL,
  `ISBN` varchar(20) DEFAULT NULL,
  `Price` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`ID`, `Title`, `Category`, `ISBN`, `Price`) VALUES
('B1111', 'PHP with MySQL \r\nProgramming', 'Programming', '0132575677', '198.89'),
('B2222', 'Visual Basic \r\n2015 How to Program', 'Programming', '0132152134', '124.00'),
('B3333', 'Visual C# \r\n2015', 'Programming', '0132151421', '107.80'),
('B4444', 'Java \r\nProgramming', 'Programming', '0132575663', '123.00'),
('B5555', 'C++ How to \r\nProgram', 'Programming', '0132662361', NULL),
('B6666', 'C How to \r\nProgram', 'Programming', '0136123562', NULL),
('B7777', 'Internet & World Wide \r\nWeb How to Program', 'Programming', '0132151006', NULL),
('B8888', 'Operating \r\nSystems', 'Operating Systems', '0131828274', '80.50'),
('15', 'Cheese', 'Programming', '4321', '21.00'),
('65', 'pickle', 'cheese', '4', '2.00');

-- --------------------------------------------------------

--
-- Table structure for table `books_authors`
--

DROP TABLE IF EXISTS `books_authors`;
CREATE TABLE IF NOT EXISTS `books_authors` (
  `BID` varchar(5) NOT NULL,
  `AID` varchar(5) NOT NULL,
  PRIMARY KEY (`BID`,`AID`),
  KEY `AID` (`AID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books_authors`
--

INSERT INTO `books_authors` (`BID`, `AID`) VALUES
('15', 'A1111'),
('65', 'A4444'),
('B1111', 'A1111'),
('B1111', 'A6666'),
('B2222', 'A1111'),
('B3333', 'A3333'),
('B4444', 'A6666'),
('B5555', 'A2222'),
('B6666', 'A3333'),
('B7777', 'A1111'),
('B7777', 'A4444'),
('B8888', 'A5555');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
