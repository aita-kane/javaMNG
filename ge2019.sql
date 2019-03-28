-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 28, 2019 at 06:19 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ge2019`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Id` int(11) NOT NULL,
  `UsrName` varchar(20) NOT NULL,
  `NomComplet` varchar(100) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Contact` varchar(100) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Status` tinyint(1) NOT NULL DEFAULT '1',
  `Date` date NOT NULL,
  `CreatorId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Id`, `UsrName`, `NomComplet`, `Email`, `Contact`, `Password`, `Status`, `Date`, `CreatorId`) VALUES
(4, 'aitakane', 'Aïta Coura Kane', 'akane@gmail.com', '777688787', 'mypass', 1, '2019-03-07', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `userpermission`
--

CREATE TABLE `userpermission` (
  `Id` int(11) NOT NULL,
  `AddProduit` tinyint(1) DEFAULT NULL,
  `AddFrs` tinyint(1) DEFAULT NULL,
  `AddCategorie` tinyint(1) DEFAULT NULL,
  `AddSousCategorie` tinyint(1) DEFAULT NULL,
  `AddClient` tinyint(1) DEFAULT NULL,
  `UpdateProduit` tinyint(1) DEFAULT NULL,
  `UpdateFrs` tinyint(1) DEFAULT NULL,
  `UpdateCategorie` tinyint(1) DEFAULT NULL,
  `UpdateSousCategorie` tinyint(1) DEFAULT NULL,
  `UpdateClient` tinyint(1) DEFAULT NULL,
  `EmployeGestion` tinyint(1) DEFAULT NULL,
  `UserId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id` (`Id`);

--
-- Indexes for table `userpermission`
--
ALTER TABLE `userpermission`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id` (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `userpermission`
--
ALTER TABLE `userpermission`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
