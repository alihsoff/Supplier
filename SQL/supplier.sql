-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 28, 2020 at 10:12 AM
-- Server version: 5.7.17-log
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `supplier`
--

-- --------------------------------------------------------

--
-- Table structure for table `t_buyer`
--

CREATE TABLE `t_buyer` (
  `B_ID` int(5) NOT NULL,
  `B_NAME` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `t_goods`
--

CREATE TABLE `t_goods` (
  `G_ID` int(3) NOT NULL,
  `G_NAME` varchar(255) DEFAULT NULL,
  `G_QTY` int(5) DEFAULT NULL,
  `G_COST` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_goods`
--

INSERT INTO `t_goods` (`G_ID`, `G_NAME`, `G_QTY`, `G_COST`) VALUES
(3, 'Xiaomi', 250, '90.00'),
(4, 'Acer', 100, '1070.00'),
(5, 'iPhone X', 25, '70.00');

-- --------------------------------------------------------

--
-- Table structure for table `t_order`
--

CREATE TABLE `t_order` (
  `O_ID` int(5) NOT NULL,
  `O_G_ID` int(5) NOT NULL,
  `O_B_ID` int(5) NOT NULL,
  `qty` int(3) NOT NULL,
  `O_SUCCESS` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_order`
--

INSERT INTO `t_order` (`O_ID`, `O_G_ID`, `O_B_ID`, `qty`, `O_SUCCESS`) VALUES
(74, 5, 1, 75, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_buyer`
--
ALTER TABLE `t_buyer`
  ADD PRIMARY KEY (`B_ID`);

--
-- Indexes for table `t_goods`
--
ALTER TABLE `t_goods`
  ADD PRIMARY KEY (`G_ID`);

--
-- Indexes for table `t_order`
--
ALTER TABLE `t_order`
  ADD PRIMARY KEY (`O_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `t_buyer`
--
ALTER TABLE `t_buyer`
  MODIFY `B_ID` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `t_goods`
--
ALTER TABLE `t_goods`
  MODIFY `G_ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `t_order`
--
ALTER TABLE `t_order`
  MODIFY `O_ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
