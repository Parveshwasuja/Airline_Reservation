-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 03, 2018 at 08:13 AM
-- Server version: 5.5.20
-- PHP Version: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `flightreservation`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `bookingmaster`
--

CREATE TABLE IF NOT EXISTS `bookingmaster` (
  `booking_no` int(11) NOT NULL,
  `booking_date` date NOT NULL,
  `dep_date` date NOT NULL,
  `a_code` varchar(7) NOT NULL,
  `source` varchar(25) NOT NULL,
  `destination` varchar(25) NOT NULL,
  `eco_tickets` int(11) NOT NULL,
  `buis_tickets` int(11) NOT NULL,
  `charge_per_ticket` double NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`booking_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookingmaster`
--

INSERT INTO `bookingmaster` (`booking_no`, `booking_date`, `dep_date`, `a_code`, `source`, `destination`, `eco_tickets`, `buis_tickets`, `charge_per_ticket`, `total`) VALUES
(1, '2018-07-27', '2018-10-02', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(2, '2018-07-27', '2018-07-29', 'A101', 'Delhi', 'Mumbai', 2, 0, 9000, 18000),
(3, '2018-07-27', '2018-07-30', 'A101', 'Delhi', 'Mumbai', 0, 1, 18000, 18000),
(10, '2018-07-27', '2018-10-02', 'A101', 'Delhi', 'Mumbai', 1, 0, 6000, 6000),
(11, '2018-07-27', '2018-09-25', 'A101', 'Delhi', 'Mumbai', 1, 0, 0, 0),
(12, '2018-07-27', '2018-09-25', 'A101', 'Delhi', 'Mumbai', 1, 0, 0, 0),
(13, '2018-07-27', '2018-09-25', 'A101', 'Delhi', 'Mumbai', 4, 0, 0, 0),
(14, '2018-07-28', '2018-08-29', 'A101', 'Delhi', 'Mumbai', 2, 0, 9000, 18000),
(15, '2018-07-28', '2018-08-27', 'A105', 'Delhi', 'Mumbai', 0, 3, 0, 0),
(16, '2018-07-28', '2018-08-06', 'A105', 'Delhi', 'Mumbai', 0, 4, 16000, 64000),
(17, '2018-07-28', '2018-08-06', 'A105', 'Delhi', 'Mumbai', 0, 5, 16000, 80000),
(18, '2018-07-28', '2018-09-25', 'A105', 'Delhi', 'Mumbai', 11, 0, 0, 0),
(19, '2018-07-28', '2018-09-25', 'A105', 'Delhi', 'Mumbai', 11, 0, 0, 0),
(20, '2018-07-28', '2018-09-25', 'A101', 'Delhi', 'Mumbai', 1, 0, 0, 0),
(21, '2018-07-28', '2018-09-25', 'A101', 'Delhi', 'Mumbai', 1, 0, 0, 0),
(22, '2018-07-28', '2018-09-25', 'A101', 'Delhi', 'Mumbai', 1, 0, 0, 0),
(23, '2018-07-28', '2018-09-25', 'A101', 'Delhi', 'Mumbai', 1, 0, 6000, 6000),
(24, '2018-07-28', '2018-09-25', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(25, '2018-07-28', '2018-09-25', 'A101', 'Delhi', 'Mumbai', 1, 0, 6000, 6000),
(26, '2018-07-28', '2018-09-25', 'A101', 'Delhi', 'Mumbai', 1, 0, 6000, 6000),
(27, '2018-07-28', '2018-09-25', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(28, '2018-07-28', '2018-09-25', 'A101', 'Delhi', 'Mumbai', 4, 0, 6000, 24000),
(29, '2018-07-28', '2018-09-25', 'A101', 'Delhi', 'Mumbai', 10, 0, 6000, 60000),
(30, '2018-07-28', '2018-09-28', 'A101', 'Delhi', 'Mumbai', 5, 0, 6000, 30000),
(31, '2018-07-28', '2018-12-26', 'A105', 'Delhi', 'Mumbai', 0, 11, 12000, 132000),
(32, '2018-07-28', '2018-12-21', 'A105', 'Delhi', 'Mumbai', 0, 5, 12000, 60000),
(33, '2018-07-28', '2018-12-21', 'A105', 'Delhi', 'Mumbai', 0, 3, 12000, 36000),
(34, '2018-07-31', '2018-12-23', 'A105', 'Delhi', 'Mumbai', 4, 0, 6000, 24000),
(35, '2018-07-31', '2018-12-23', 'A112', 'Chennai', 'Chandigarh', 3, 0, 9500, 28500),
(36, '2018-07-31', '2018-12-23', 'A113', 'Chennai', 'Chandigarh', 1, 0, 9200, 9200),
(37, '2018-07-31', '2018-12-24', 'A110', 'Chennai', 'Kolkata', 1, 0, 8000, 8000),
(38, '2018-07-31', '2018-12-23', 'A112', 'Chennai', 'Chandigarh', 1, 0, 9500, 9500),
(39, '2018-08-02', '2019-04-01', 'A101', 'Delhi', 'Mumbai', 0, 1, 12000, 12000),
(40, '2018-08-02', '2019-02-01', 'A101', 'Delhi', 'Mumbai', 1, 0, 6000, 6000),
(41, '2018-08-02', '2019-12-02', 'A101', 'Delhi', 'Mumbai', 0, 2, 12000, 24000),
(42, '2018-08-02', '2019-04-01', 'A101', 'Delhi', 'Mumbai', 0, 2, 12000, 24000),
(43, '2018-08-02', '2019-12-12', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(44, '2018-08-02', '2019-12-12', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(45, '2018-08-02', '2019-12-12', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(46, '2018-08-02', '2019-12-12', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(47, '2018-08-02', '2019-12-12', 'A105', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(48, '2018-08-03', '2019-02-01', 'A105', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(49, '2018-08-03', '2019-02-01', 'A101', 'Delhi', 'Mumbai', 0, 2, 12000, 24000),
(50, '2018-08-03', '2019-03-01', 'A101', 'Delhi', 'Mumbai', 0, 2, 12000, 24000),
(51, '2018-08-03', '2019-04-01', 'A101', 'Delhi', 'Mumbai', 0, 2, 12000, 24000),
(52, '2018-08-03', '2019-03-02', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(53, '2018-08-03', '2019-03-02', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(54, '2018-08-03', '2020-04-02', 'A101', 'Delhi', 'Mumbai', 1, 0, 6000, 6000),
(55, '2018-08-03', '2020-05-02', 'A101', 'Delhi', 'Mumbai', 0, 1, 12000, 12000),
(56, '2018-08-03', '2019-04-02', 'A101', 'Delhi', 'Mumbai', 1, 0, 6000, 6000),
(57, '2018-08-03', '2019-03-02', 'A101', 'Delhi', 'Mumbai', 1, 0, 6000, 6000),
(58, '2018-08-03', '2019-03-01', 'A101', 'Delhi', 'Mumbai', 1, 0, 6000, 6000),
(59, '2018-08-03', '2019-05-01', 'A101', 'Delhi', 'Mumbai', 1, 0, 6000, 6000),
(60, '2018-08-03', '2019-03-01', 'A101', 'Delhi', 'Mumbai', 0, 2, 12000, 24000),
(61, '2018-08-03', '2019-02-12', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(62, '2018-08-03', '2019-04-02', 'A101', 'Delhi', 'Mumbai', 0, 2, 12000, 24000),
(63, '2018-08-03', '2019-03-02', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(64, '2018-08-03', '2019-02-01', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(65, '2018-08-03', '2019-02-01', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(66, '2018-08-03', '2019-05-02', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(67, '2018-08-03', '2019-03-02', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(68, '2018-08-03', '2019-03-12', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(69, '2018-08-03', '2019-04-02', 'A101', 'Delhi', 'Mumbai', 2, 0, 6000, 12000),
(70, '2018-08-03', '2019-11-12', 'A110', 'Chennai', 'Kolkata', 0, 2, 16000, 32000);

-- --------------------------------------------------------

--
-- Table structure for table `bookingtransaction`
--

CREATE TABLE IF NOT EXISTS `bookingtransaction` (
  `b_no` int(11) NOT NULL,
  `t_no` int(11) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `age` int(11) NOT NULL,
  `type` varchar(10) NOT NULL,
  `gender` varchar(7) NOT NULL,
  `aadhar` varchar(15) NOT NULL,
  PRIMARY KEY (`t_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookingtransaction`
--

INSERT INTO `bookingtransaction` (`b_no`, `t_no`, `fname`, `lname`, `contact`, `email`, `age`, `type`, `gender`, `aadhar`) VALUES
(41, 1, 'pqr', 'devi', '7041414141', 'pokuf@.', 24, 'Adult', 'Female', '123456789123'),
(42, 2, 'pqr', 'devi', '9995599955', 'kjhjhf@.', 24, 'Adult', 'Female', '123456789123'),
(44, 3, 'pqr', 'dev', '9995599955', 'gfhd@.', 23, 'Adult', 'Male', '123456789012'),
(59, 4, 'gjhgj', 'gfhgfhg', '9874561231', 'rohit@gmail.com', 24, 'Adult', 'Male', '123456789123'),
(63, 5, 'hagaf', 'hagaf', '9874561231', 'rohit@.', 24, 'Adult', 'Male', '123456789123'),
(64, 6, 'ccd', 'jhgj', '9874561231', 'hfhghfgh@.', 25, 'Adult', 'Male', '123456789123'),
(64, 7, 'jhgjf', 'fdfgfdg', '9874561231', 'huyj@.', 24, 'Adult', 'Male', '123456789123'),
(65, 8, 'hgffh', 'gfhgf', '9898989898', 'jfgf@.', 10, 'Adult', 'Male', '321656123456'),
(65, 9, 'gfhg', 'hhf', '9874561231', 'fygff@.', 25, 'Adult', 'Male', '123456789123'),
(67, 10, 'hgfh', 'gfdgfd', '1234567890', 'hghghg@.', 12, 'Adult', 'Male', '123456789123'),
(67, 11, 'fdgfd', 'fgfss', '1234567891', 'hghdhd@.', 15, 'Adult', 'Male', '123456789123'),
(69, 12, 'hgfh', 'hdgfdg', '9874561231', 'hggjff@.', 24, 'Adult', 'Male', '123456789123'),
(69, 13, 'fhg', 'hdhd', '9874561231', 'gfhgfh@.', 25, 'Adult', 'Male', '123456789123'),
(70, 14, 'jhghgj', 'hgfhfg', '9874561231', 'hggjfhg@.', 11, 'Adult', 'Male', '123456789123'),
(70, 15, 'hfhf', 'dfdgdf', '1245789456', 'hfhgfh@.', 26, 'Adult', 'Female', '123456789123');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `fname` varchar(30) NOT NULL,
  `add` varchar(100) NOT NULL,
  `phno` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `gender` varchar(7) NOT NULL,
  `userid` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `jdate` date NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`fname`, `add`, `phno`, `email`, `gender`, `userid`, `password`, `jdate`) VALUES
('Rahul Wasuja', 'Lajpat Nagar,Fatehabad', '9467022143', 'rahulwasuja@gmail.com', 'male', 'rahulwasuja', 'rahul143', '2018-07-21'),
('Saksham Wasuja', 'Lajpat Nagar,Delhi', '7015915143', 'sakshamwasuja@gmail.com', 'male', 'sakshamwasuja', 'p6SQz', '2018-07-21');

-- --------------------------------------------------------

--
-- Table structure for table `fleetinfo`
--

CREATE TABLE IF NOT EXISTS `fleetinfo` (
  `a_code` varchar(7) NOT NULL,
  `a_name` varchar(20) NOT NULL,
  `ecoseats` int(11) NOT NULL,
  `buisnessseats` int(11) NOT NULL,
  `weighteco` int(11) NOT NULL,
  `weightbuisness` int(11) NOT NULL,
  `status` varchar(2) NOT NULL,
  PRIMARY KEY (`a_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fleetinfo`
--

INSERT INTO `fleetinfo` (`a_code`, `a_name`, `ecoseats`, `buisnessseats`, `weighteco`, `weightbuisness`, `status`) VALUES
('A101', 'param-a1', 50, 40, 800, 600, 'n'),
('A102', 'param-a2', 70, 50, 1500, 1100, 'n'),
('A103', 'param-a3', 85, 65, 2000, 1500, 'n'),
('A104', 'param-a4', 110, 75, 3000, 2200, 'n'),
('A105', 'param-a5', 55, 35, 900, 800, 'n'),
('A106', 'param-a6', 65, 45, 1200, 1100, 'n'),
('A107', 'param-a7', 75, 56, 2500, 3500, 'n'),
('A108', 'param-a8', 77, 67, 3000, 4000, 'n'),
('A109', 'param-a9', 80, 70, 3500, 5000, 'n'),
('A110', 'param-a10', 61, 52, 2000, 2400, 'n'),
('A111', 'param-a11', 66, 54, 2200, 2800, 'n'),
('A112', 'param-a12', 69, 55, 2500, 3200, 'n'),
('A113', 'param-a13', 59, 44, 1800, 2300, 'n'),
('A114', 'param-a114', 63, 50, 2300, 2600, 'y'),
('A115', 'param-a15', 68, 53, 2700, 3300, 'y');

-- --------------------------------------------------------

--
-- Table structure for table `flightbookinginfo`
--

CREATE TABLE IF NOT EXISTS `flightbookinginfo` (
  `a_code` varchar(7) NOT NULL,
  `departuredate` date NOT NULL,
  `r_code` varchar(7) NOT NULL,
  `a_eco_seats` int(11) NOT NULL,
  `a_buis_seats` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flightbookinginfo`
--

INSERT INTO `flightbookinginfo` (`a_code`, `departuredate`, `r_code`, `a_eco_seats`, `a_buis_seats`) VALUES
('A101', '2018-10-02', '1', 50, 40),
('A101', '2018-08-29', '1', 50, 40),
('A105', '2018-08-27', '1', 50, 40),
('A105', '2018-08-06', '1', 50, 40),
('A105', '2018-09-25', '1', 50, 40),
('A101', '2018-09-25', '1', 50, 40),
('A101', '2018-09-28', '1', 50, 40),
('A105', '2018-12-26', '1', 50, 40),
('A105', '2018-12-21', '1', 50, 40),
('A105', '2018-12-23', '1', 50, 40),
('A112', '2018-12-23', '6', 50, 40),
('A113', '2018-12-23', '6', 50, 40),
('A110', '2018-12-24', '5', 50, 40),
('A112', '2018-12-24', '6', 50, 40),
('A101', '2018-12-12', '1', 50, 40),
('A105', '2018-12-13', '1', 50, 40),
('A101', '2019-01-01', '1', 50, 40),
('A101', '2020-02-01', '1', 50, 40),
('A105', '2021-01-01', '1', 50, 40),
('A105', '2022-01-01', '1', 50, 40),
('A105', '2019-04-01', '1', 50, 40),
('A105', '2019-05-01', '1', 50, 40),
('A105', '2019-06-01', '1', 50, 40),
('A101', '2019-04-01', '1', 50, 36),
('A101', '2019-02-01', '1', 46, 38),
('A101', '2019-12-02', '1', 50, 40),
('A101', '2019-03-01', '1', 49, 36),
('A101', '2019-12-12', '1', 42, 40),
('A105', '2019-12-12', '1', 53, 35),
('A105', '2019-02-01', '1', 53, 35),
('A105', '2019-03-01', '1', 55, 35),
('A101', '2019-03-02', '1', 41, 40),
('A101', '2020-04-02', '1', 49, 40),
('A101', '2020-05-02', '1', 50, 39),
('A101', '2019-04-02', '1', 47, 38),
('A101', '2019-05-01', '1', 49, 40),
('A101', '2019-02-12', '1', 48, 40),
('A101', '2019-05-02', '1', 48, 40),
('A101', '2019-03-12', '1', 48, 40),
('A110', '2019-11-12', '5', 61, 50);

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE IF NOT EXISTS `route` (
  `r_code` varchar(7) NOT NULL,
  `a_code` varchar(7) NOT NULL,
  `source` varchar(25) NOT NULL,
  `destination` varchar(25) NOT NULL,
  `baseprice` int(11) NOT NULL,
  `distance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`r_code`, `a_code`, `source`, `destination`, `baseprice`, `distance`) VALUES
('1', 'A101', 'Delhi', 'Mumbai', 6000, 1400),
('2', 'A102', 'Delhi', 'Chennai', 9000, 2200),
('3', 'A103', 'Delhi', 'Jaipur', 3500, 500),
('4', 'A104', 'Delhi', 'Chandigarh', 4000, 400),
('1', 'A105', 'Delhi', 'mumbai', 6000, 1500),
('1', 'A106', 'Delhi', 'Mumbai', 6700, 1400),
('2', 'A107', 'Delhi', 'Chennai', 9500, 3600),
('3', 'A108', 'Delhi', 'Jaipur', 3000, 500),
('4', 'A109', 'Delhi', 'Chandigarh', 3200, 475),
('5', 'A110', 'Chennai', 'Kolkata', 8000, 1673),
('5', 'A111', 'Chennai', 'Kolkata', 8500, 1673),
('6', 'A112', 'Chennai', 'Chandigarh', 9500, 2460),
('6', 'A113', 'Chennai', 'Chandigarh', 9200, 2460);

-- --------------------------------------------------------

--
-- Table structure for table `routemaster`
--

CREATE TABLE IF NOT EXISTS `routemaster` (
  `r_code` varchar(7) NOT NULL,
  `source` varchar(25) NOT NULL,
  `destination` varchar(25) NOT NULL,
  PRIMARY KEY (`r_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `routemaster`
--

INSERT INTO `routemaster` (`r_code`, `source`, `destination`) VALUES
('1', 'Delhi', 'Mumbai'),
('10', 'Srinagar', 'Mumbai'),
('2', 'Delhi', 'Chennai'),
('3', 'Delhi', 'Jaipur'),
('4', 'Delhi', 'Chandigarh'),
('5', 'Chennai', 'Kolkata'),
('6', 'Chennai', 'Chandigarh'),
('7', 'Mumbai', 'Chandigarh'),
('8', 'Ahemdabad', 'Mumbai'),
('9', 'kolkata', 'chandigarh');

-- --------------------------------------------------------

--
-- Table structure for table `timing`
--

CREATE TABLE IF NOT EXISTS `timing` (
  `a_code` varchar(7) NOT NULL,
  `r_code` varchar(7) NOT NULL,
  `departure` varchar(7) NOT NULL,
  `arrival` varchar(7) NOT NULL,
  `j_hours` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `timing`
--

INSERT INTO `timing` (`a_code`, `r_code`, `departure`, `arrival`, `j_hours`) VALUES
('A101', '1', '09:10', '11:34', '02:24'),
('A105', '1', '07:00', '09:00', '02:00'),
('A113', '6', '10:30', '13:30', '03:00'),
('A112', '6', '11:45', '14:45', '03:00'),
('A111', '5', '10:55', '13:20', '02:25'),
('A110', '5', '10:57', '13:24', '02:27');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
