-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 08, 2015 at 05:08 AM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `company`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `EmployeeID` int(11) NOT NULL,
  `EmployeeName` varchar(255) NOT NULL,
  `Rank` varchar(255) NOT NULL,
  `Department` varchar(255) NOT NULL,
  `Branch` varchar(255) NOT NULL,
  `JoiningDate` varchar(255) NOT NULL,
  `Salary` int(20) NOT NULL DEFAULT '0',
  `BirthDate` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Phone` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  PRIMARY KEY (`EmployeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmployeeID`, `EmployeeName`, `Rank`, `Department`, `Branch`, `JoiningDate`, `Salary`, `BirthDate`, `Address`, `Phone`, `Email`) VALUES
(1, 'ffef', 'ere2r', 'reqr', 'hangama', '5 March, 1952', 42524, '4 March, 1952', 'qweqe', 'wewe', 'wewe'),
(2, 'fwefw', 'wewe', 'fefer', 'gondogol', '5 October, 2014', 64532, '25 July, 1996', '1e12e', '1e414', 'q3e2e'),
(3, 'qwrqwe', 'sqwe', 'qdqw', 'London', '14 August, 2013', 34344, '2 January, 2006', 'qqe', 'qr13r31', 'q3r13e'),
(4, 'qweqwe', 'qdqw', 'qwewqe', 'London', '27 July, 2012', 64532, '17 June, 2015', 'wrtwrt', 'rwtwt', 'rgege'),
(6, 'rgrgr', 'rgwrgw', 'grgwrg', 'London', '26 October, 1958', 66666, '15 October, 1979', 'ewfwr', 'ewfwef', 'wrgfsg'),
(7, 'dfeaf', 'srtwet', 'rwtwt', 'London', '23 July, 2014', 75643, '15 Sepetember, 1999', 'gwefw', 'gfsdf', 'geafqe'),
(8, 'eefafsdsdf', 'zdfdf', 'afasd', 'London', '28 October, 2014', 56784, '23 August, 1956', 'ararq', 'rwarwE', 'vvfbfd'),
(9, 'eserfzdvzd', 'czdfzsdsa', 'zdfdza', 'London', '21 Sepetember, 2012', 78545, '15 August, 1987', 'ssfs', 'srgsrt', 'rtwrt'),
(10, 'dhgkhd', 'faefeq', 'wtwew', 'London', '27 November, 2002', 63463, '24 November, 2013', 'dfaef', 'dafafdda', 'afwE'),
(11, 'xfdzf', 'dgdsf', 'gdhdgh', 'Washington D. C.', '17 October, 2015', 56743, '27 July, 2005', 'cxbdxg', 'sdgzdf', 'zdfzd'),
(13, 'sdgs', 'rgr', 'tdhteh', 'Washington D.C.', '23 November, 2014', 56784, '26 October, 2006', 'erq', 'rgtw44', 'rgw'),
(17, 'rdrtdrtyre', 'dryrwt', 'dger', 'Washington D.C.', '17 May, 2006', 86456, '15 May, 1956', 'earq3r', 'wetw4r', 'srgwrt'),
(18, 'etwtr', 'rtdyret', 'erye35t', 'Washington D.C.', '27 October, 1984', 78964, '20 December, 1952', 'ewfq3r', 'fsgsd', 'srgwr'),
(19, 'wrgrwt', 'srfgrwf', 'dsgwg', 'Washington D.C.', '21 October, 1990', 65422, '17 July, 1953', 'qwrer', 'arqe', 'rq424dfdf'),
(21, 'gegtby', 'rgbreg', 'yreyh45', 'Beijing', '31 October, 1977', 67545, '27 August, 2014', 'reth45hyh', 'ythyth', 'erghtegt'),
(22, 'sdfweref', 'wereqr', 'werwer', 'Beijing', '25 October, 2000', 87645, '18 August, 2013', 'srgrwt', 'rst', 'rstwtr'),
(23, 'waqeq', 'aerqr', 'qrq3e', 'Beijing', '10 November, 1992', 75633, '15 August, 1985', 'dwqe', 'aerq3r', 'eqrqer'),
(24, 'wetrwe', 'wrtw', 'sfg', 'Beijing', '15 May, 1999', 42525, '', 'earqr1', 'er3q', 'sdgw'),
(25, 'dfesr', 'rt4w', 'dgr', 'Beijing', '13 August, 1972', 46443, '20 August, 2005', 'arq', 'xfgsg', 'ftw4'),
(26, 'thtrhe', 'dhdt', 'fghte', 'Beijing', '15 July, 2000', 46432, '4 December, 2011', 'srgwer', 'sgsg', 'ethyte'),
(27, 'zdfw', 'dgherg', 'etheh', 'Beijing', '18 August, 1976', 54747, '', 'sdtwet', 'rtuthe', 'dghey'),
(28, 'sfgsg', 'dghegh', 'dbdg', 'Beijing', '21 November, 2002', 46245, '7 June, 1983', 'sgsert1', 'dfbsrg', 'dfhrsg'),
(30, 'dfwef', 'ehert', 'rgtrwgf', 'Beijing', '17 October, 2007', 76543, '19 July, 1999', 'fsgwrg', 'dfhry', 'rthtehd'),
(31, 'drgrg', 'rydr', 'tey', 'Moscow', '23 July, 2013', 52636, '24 November, 1994', 'rgwgrw', 'dfhdrty', 'dthdy3'),
(32, 'earq', 'wt24', 'rstw', 'Moscow', '16 November, 2000', 56789, '15 May, 1994', 'werq3rwrtw', 'wrtwt', 'et4wt'),
(33, 'rtwrt', 'fdgfdg', 'geg', 'Moscow', '8 November, 2014', 33532, '23 July, 1987', 'heyyryy', 'teyeyyht', 'fge'),
(34, 'rt4wt4t', 'hetg', 'dher', 'Moscow', '24 October, 1991', 56783, '13 August, 1993', 'tw4t44', 'srgast', 'srgrwg'),
(35, 'gwgrt', 'xbfsgrwtg', 'rgwrt', 'Moscow', '22 August, 2013', 87329, '15 April, 2000', 'rwtw4t', 'rgrwt', 'ergwat'),
(36, 'tututu', '', '', 'Moscow', '7 November, 2015', 35612, '11 June, 1991', 'qetqr', 'argat', 'rgq42t'),
(37, 'sehg35t', 'hesg', 'ethewy', 'Moscow', '21 May, 2014', 56435, '9 March, 1985', 'wrtwet', 'rgr', 'rtwart'),
(38, 'rtwet', 'ge5t', 'tege', 'Moscow', '6 April, 1976', 34522, '18 July, 1967', 'ry3tt5', 'wwer', 'eg34trt'),
(39, 'eqfqer', 'ewfeqfeq', 'wgwrg', 'Moscow', '23 May, 2003', 67543, '23 November, 1987', 'rwgwet', 'gwrt', 'rgwr'),
(40, 'fdhrd', 'srdhesrt', 'ethtsy', 'Moscow', '13 August, 2003', 36364, '19 August, 1992', 'taegrw', 'sethhesty', 'shth4s5'),
(43, 'eghagteheg', 'dgbsdgh', 'ehetgh', 'Paris', '24 July, 2011', 36354, '20 June, 1992', 'rh4w4y4', '4tyw4y', 'they'),
(44, 'eg3te', 'egherg', 'rghtewg', 'Paris', '23 May, 1983', 62525, '21 November, 2009', 'dfgerg', 'esye', 'estgesrg'),
(45, 'ergw4g', 'dhetge', 'sgwrg', 'Paris', '18 August, 1986', 75894, '29 June, 2002', 'rwtw4t', 'gargs', 'wragwat'),
(46, 'rgwart', 'dffdget', 'hwgdg', 'Paris', '24 October, 1999', 61234, '4 August, 1951', 'wd', 'wed', 'sDsdD'),
(47, 'vfsggrw', 'fsvsg', 'egerg', 'Paris', '7 August, 1988', 22452, '21 October, 1997', 'ferag', 'dbeg', 'dgbedg'),
(48, 'etherg', 'ghrsth', 'gdhetg', 'Paris', '18 June, 2005', 46480, '9 November, 1953', 'ethetg', 'ghetwgh', 'ethetg'),
(49, 'rgt', 'egaeg', 'fgerg', 'Paris', '21 October, 1951', 25556, '4 August, 1978', 'ryh4s4y', 'ethah', 'srthesth'),
(50, 'esthh4', 'rsthrtsh', 'rtshrth', 'Paris', '7 August, 1956', 43567, '31 October, 2013', 'ege5tg', 'eg3rg', 'eg3rt3er'),
(51, 'ryjr6u', 'fjryh', 'yjrdyu', 'Berlin', '20 August, 1994', 42512, '20 August, 1953', 'r35t', 'etgr3t', 'etgertg'),
(52, 'ru4ru4', 'ryjhrsh', 'rsysy', 'Berlin', '16 August, 2014', 78569, '20 August, 1984', 'gheth', 'sgestg', 'shestg'),
(53, 'dhdh', 'thteh', 'hgh', 'Berlin', '18 June, 1987', 78934, '14 May, 1974', 'rhrth', 'rhrsth', 'rhrth'),
(54, 'rsthsry', 'rghrh', 'hthytey', 'Berlin', '20 October, 1999', 78905, '14 October, 1983', 'eger', 'egerg', 'egerg'),
(55, 'gsh', 'ghsth', 'trheth', 'Berlin', '17 October, 1998', 23456, '15 November, 1978', 'rhrsth', 'htrhrtsh', 'ndnh'),
(56, 'etgeg', 'eert', 'ergerg', 'Berlin', '17 June, 1987', 46362, '11 October, 1983', 'wwef', 'dvdsv', 'sdvwdv'),
(57, 'geg', 'bseg', 'gbsdg', 'Berlin', '13 December, 1973', 53245, '17 August, 1985', 'earg', 'eerg', 'erwfrw'),
(58, 'ergerg', 'ettg', 'beg', 'Berlin', '26 June, 1988', 25252, '12 August, 2004', 'gwfwf', 'wrgwr', 'rwgwr'),
(59, 'rtuyr', 'ffyr', 'rtyrtuf', 'Berlin', '14 August, 1982', 78940, '8 August, 1978', 'e5y5y', 'esrger', 'eger'),
(60, 'thrsehg', 'deg', 'destg', 'Berlin', '14 May, 1981', 76543, '16 October, 1975', 'fthtdh', 'dhdh', 'rhrth'),
(61, 'rgrtt', 'heg', 'dgbdgh', 'Rome', '23 June, 1983', 87456, '15 October, 1977', 'rwgw4t4t', 'rgwrgw', 'wrgwrg'),
(63, 'egertrw', 'dgfg', 'bdg', 'Rome', '13 August, 1984', 56783, '11 November, 1993', 'rwtw4t', 'gwrt', 'rgrwtwrt'),
(64, 'dghdth', 'ghh', 'gdghet', 'Rome', '7 October, 1986', 89342, '13 May, 1979', 'ergrwt', 'ergrwg', 'ergearg'),
(65, 'estg', 'htehest', 'gdhdhd', 'Rome', '15 October, 2008', 43567, '21 October, 1984', 'fgsfag', 'fsgwrg', 'rgwrag'),
(66, 'wfarr', 'gwrf', 'rwgwrf', 'Rome', '21 August, 1988', 45678, '17 July, 1992', 'regerqg', 'rgwragf', 'ffgrwa'),
(67, 'rgrt', 'bdh', 'ghseth', 'Rome', '18 February, 2014', 34256, '19 August, 1971', 'fgwargw', 'rgwrg', 'rgwrg'),
(68, 'grhty', 'hhtbt', 'truuju', 'Rome', '22 August, 2007', 43567, '18 October, 1997', 'hyhrth', 'rthnn', 'tnrtn'),
(69, 'ttuju6j', 'hrnryj', 'rnruyj', 'Rome', '3 November, 1991', 45634, '25 August, 1968', 'rb5ygh45h', 'rer4yh', 'uh56h'),
(70, 'fntrjhj', 'hjtrj', 'jrtjutu', 'Rome', '6 October, 1991', 56643, '7 July, 1971', 'rg4rgw', 'argrwg', 'etgg35q'),
(71, 'wq4t', 'wf24r', 'wrrt', 'Zurich', '6 August, 1990', 23144, '16 October, 1974', 'wrt4wt', 'wrgrwt', 'rgwrt'),
(72, 'ethtehe', 'hetht', 'heth', 'Zurich', '14 June, 1996', 89045, '23 November, 2002', '34t245', 'wrgw4t', 'wrgwt'),
(73, 'hsey', 'thewy', 'hw4y', 'Zurich', '7 June, 1995', 78993, '23 October, 2014', 'rwf24f', 'wrfwef', 'wrf2qef'),
(74, 'sfwf', 'fgwrf', 'fber', 'Zurich', '16 June, 1979', 67854, '11 December, 1978', 'rgag', 'etearty', 'etye5y53t'),
(75, 'afgrawrg', 'agwarg', 'aegerag', 'Zurich', '16 November, 1991', 78943, '16 October, 1980', 'wefwer', 'wefw', 'werfwef'),
(78, 'awrgwat', 'efgarg', 'erg', 'Zurich', '16 August, 1977', 78994, '21 May, 1985', 'etqteg', 'egg33g', 'egrag'),
(79, 'eg35t', 'dfgdg', 'dg3gq3', 'Zurich', '15 August, 1974', 45367, '24 August, 2002', 'rsthsy', 'rsthsh', 'thwe'),
(81, 'stehesh', 'dhesh', 'rhetshh', 'Brussels', '16 August, 1990', 78644, '12 March, 1986', 'jytjr', 'sdf', 'svs'),
(82, 'eteryt', 'dheg', 'dghdfg', 'Brussels', '26 August, 1995', 36363, '20 October, 2007', 'rytu', 'rtyesy', 'ey5e'),
(83, 'hdesh', 'hseth', 'rthtsrh', 'Brussels', '17 August, 2006', 34175, '18 August, 1991', 'ergerg', 'dgrg', 'grger'),
(84, 'fefeeq', 'dfwef', 'afwer', 'Brussels', '14 June, 1996', 45673, '7 August, 1979', 'rrqr', 'wf2rf', 'eRQ'),
(85, 'ggdhs', 'dthdh', 'thesth', 'Brussels', '10 May, 2011', 23456, '17 November, 1979', 'teywy', 'srthyes', 'w5y'),
(86, 'ergwrt', 'rtwqt', 'egawt', 'Brussels', '14 August, 1981', 65432, '1 December, 1974', 'sgweaf', 'gwartg', 'rgwarg'),
(87, 'ssggs', 'rgwg', 'fgsg', 'Brussels', '16 July, 1970', 47432, '16 December, 1992', 'gsgef', 'fgtdsh', 'jdfty'),
(88, 'egag', 'fszg', 'fxghtgh', 'Brussels', '13 November, 1989', 65436, '18 August, 1977', 'ergw', 'teeqg', 'dhsd'),
(90, 'dtgeargt', 'dgdfg', 'xfgsf', 'Brussels', '13 October, 1976', 68433, '3 January, 1951', 'dthsey', 'fdy', 'fhrty'),
(92, 'yfjdru', 'yjyfjh', 'jsdvgs', 'Madrid', '7 August, 1952', 56342, '4 December, 1979', 'rgrwt', 'dthyewy', 'tyhey');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
