-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 17, 2019 at 10:23 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `b03`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('19-345', '4422', '1'),
('18-654', '4455', '1'),
('17-342', '4455', '1'),
('17-343', '4455', '1'),
('16-457', '9988', '1'),
('15-462', '5544', '1'),
('15-459', '2233', '1'),
('12-356', '3399', '0'),
('17-564', '5577', '1'),
('12-354', '3398', '0'),
('12-353', '3396', '0'),
('123', '14324724', '1');

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

CREATE TABLE `owner` (
  `Name` varchar(20) DEFAULT NULL,
  `ownerId` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`Name`, `ownerId`) VALUES
(' Hiya', '12-356'),
('murad abdullah', '12-354'),
('sabbir Mia', '12-353');

-- --------------------------------------------------------

--
-- Table structure for table `renterbalance`
--

CREATE TABLE `renterbalance` (
  `renterbalanceId` varchar(10) NOT NULL,
  `electricitybill` int(50) DEFAULT NULL,
  `waterbill` int(50) DEFAULT NULL,
  `gasbill` int(50) DEFAULT NULL,
  `homeservicebill` int(50) DEFAULT NULL,
  `houserent` int(50) DEFAULT NULL,
  `penalty` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `renterbalance`
--

INSERT INTO `renterbalance` (`renterbalanceId`, `electricitybill`, `waterbill`, `gasbill`, `homeservicebill`, `houserent`, `penalty`) VALUES
('122356', 5000, 200, 300, 400, 500, 600),
('12345', 2000, 10, 50, 60, 70, 2),
('14-365', 1500, 400, 900, 500, 25000, 2000),
('15-459', 1400, 400, 900, 500, 30000, 3),
('15-462', 2000, 509, 900, 500, 35000, 4000),
('16-457', 3000, 500, 900, 500, 40000, 4000),
('17-342', 2200, 500, 900, 500, 20000, 2000),
('17-343', 2500, 500, 900, 500, 30000, 3000),
('17-348', 2500, 5, 900, 500, 25000, 2000),
('17-564', 3000, 500, 900, 500, 30000, 3000),
('18-654', 2500, 500, 900, 500, 30000, 3000),
('19-345', 2000, 500, 900, 500, 20000, 2000);

-- --------------------------------------------------------

--
-- Table structure for table `renterinfo`
--

CREATE TABLE `renterinfo` (
  `renterId` varchar(10) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `occupation` varchar(12) DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `phone_number` int(15) DEFAULT NULL,
  `NID` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `renterinfo`
--

INSERT INTO `renterinfo` (`renterId`, `name`, `occupation`, `Address`, `phone_number`, `NID`) VALUES
('12', 'k', 'jn', 'kk', 15, '45'),
('123', 'md', 'dc', 'dqc', 1556, '54646'),
('125', 'murad', 'avab', 'bvah', 141616, '44515'),
('1253', 'kamal', 'jamal', 'rahim', 5565, '13233456456'),
('145', 'jamak', 'kamak', 'hamak', 12345678, '545455'),
('15-459', 'Judi Salim', 'Professor', 'Kuratoli', 1514596778, '55647821'),
('15-462', 'Din Islam', 'Singer', 'Orlando', 1988597545, '66545132'),
('16-457', 'Raiyan Rafi', 'Pilot', 'Comilla', 1846360725, '33654219'),
('17-342', 'Md Sabbir Hossain', 'Doctor', 'Demra', 1879275554, '2147856'),
('17-343', 'Md Abdullah Al Murad', 'Teacher', 'Basabo', 1521216707, '235465'),
('17-564', 'AKM Kalam', 'Engineer', 'Milta', 1517140996, '226548'),
('18-654', 'Mustafizur Rahman', 'Cricketer', 'Mirpara', 1862274339, '2234456'),
('19-345', 'Jorina Akter', 'Doctor', 'Noakhali', 1527360554, '2345687'),
('4454', '4654', '45464', '4666', 5454, '544');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD UNIQUE KEY `userId` (`userId`);

--
-- Indexes for table `owner`
--
ALTER TABLE `owner`
  ADD UNIQUE KEY `userId` (`ownerId`);

--
-- Indexes for table `renterbalance`
--
ALTER TABLE `renterbalance`
  ADD PRIMARY KEY (`renterbalanceId`);

--
-- Indexes for table `renterinfo`
--
ALTER TABLE `renterinfo`
  ADD PRIMARY KEY (`renterId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
