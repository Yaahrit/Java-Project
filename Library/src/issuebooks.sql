
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE TABLE IF NOT EXISTS `issuebooks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookcallno` varchar(50) NOT NULL,
  `studentid` int(11) NOT NULL,
  `studentname` varchar(50) NOT NULL,
  `studentcontact` varchar(20) NOT NULL,
  `issueddate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

INSERT INTO `issuebooks` 
(`id`, `bookcallno`, `studentid`, `studentname`, `studentcontact`, `issueddate`) VALUES
(1, 'A@4', 123, 'John Doe', '1234567890', '2022-01-01 12:30:00'),
(2, 'G@12', 456, 'Alice Smith', '9876543210', '2022-01-02 13:45:00'),
(3, 'D@4', 789, 'Bob Johnson', '5551212121', '2022-01-03 15:00:00'),
(4, 'E@6', 101, 'Eva Brown', '7778889999', '2022-01-04 16:15:00'),
(5, 'F@7', 202, 'Frank White', '3334445555', '2022-01-05 17:30:00'),
(6, 'H@13', 303, 'Grace Davis', '6667778888', '2022-01-06 18:45:00'),
(7, 'I@14', 404, 'Henry Lee', '9990001111', '2022-01-07 20:00:00'),
(8, 'J@15', 505, 'Ivy Chen', '2223334444', '2022-01-08 21:15:00'),
(9, 'K@16', 606, 'Jack Wang', '8889990000', '2022-01-09 22:30:00'),
(10, 'M@18', 707, 'Karen Liu', '1112223333', '2022-01-10 09:45:00'),
(11, 'N@19', 808, 'Leo Kim', '4445556666', '2022-01-11 11:00:00'),
(12, 'O@20', 909, 'Mia Johnson', '7778889999', '2022-01-12 12:15:00'),
(13, 'P@21', 111, 'Nathan Davis', '2223334444', '2022-01-13 13:30:00'),
(14, 'Q@22', 222, 'Olivia Smith', '5556667777', '2022-01-14 14:45:00'),
(15, 'R@23', 333, 'Peter Brown', '8889990000', '2022-01-15 16:00:00'),
(16, 'S@24', 444, 'Quinn Taylor', '1112223333', '2022-01-16 17:15:00'),
(17, 'T@25', 555, 'Rachel Chen', '4445556666', '2022-01-17 18:30:00'),
(18, 'U@26', 666, 'Samuel Lee', '7778889999', '2022-01-18 19:45:00'),
(19, 'V@27', 777, 'Taylor Kim', '2223334444', '2022-01-19 21:00:00'),
(20, 'W@28', 888, 'Uma Johnson', '5556667777', '2022-01-20 22:15:00'),
(21, 'V@21', 999, 'Vicky Brown', '8889990000', '2022-01-21 09:30:00'),
(22, 'W@22', 111, 'Will Smith', '1112223333', '2022-01-22 10:45:00'),
(23, 'X@23', 222, 'Xander Taylor', '4445556666', '2022-01-23 12:00:00'),
(24, 'Y@24', 333, 'Yasmine Chen', '7778889999', '2022-01-24 13:15:00'),
(25, 'Z@25', 444, 'Zack Lee', '2223334444', '2022-01-25 14:30:00'),
(26, 'AA@26', 555, 'Amy Johnson', '5556667777', '2022-01-26 15:45:00'),
(27, 'BB@27', 666, 'Ben Brown', '8889990000', '2022-01-27 17:00:00'),
(28, 'CC@28', 777, 'Carrie Smith', '1112223333', '2022-01-28 18:15:00'),
(29, 'DD@29', 888, 'David Taylor', '4445556666', '2022-01-29 19:30:00'),
(30, 'EE@30', 999, 'Emily Chen', '7778889999', '2022-01-30 20:45:00');

