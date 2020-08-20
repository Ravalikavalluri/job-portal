create database job_portal;

use job_portal;

CREATE TABLE `user_details` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) DEFAULT NULL,
  `lastName` varchar(20) DEFAULT NULL,
  `emailID` varchar(30) DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `phoneNo` varchar(15) DEFAULT NULL,
  `dob` varchar(20) DEFAULT NULL,
  `cgpa` float DEFAULT NULL,
  `exp` int DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `bio` text,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `applied_jobs` (
  `applicationID` int NOT NULL AUTO_INCREMENT,
  `emailID` varchar(30) DEFAULT NULL,
  `companyName` varchar(20) DEFAULT NULL,
  `jobtitle` varchar(30) DEFAULT NULL,
  `jobdesc` varchar(200) DEFAULT NULL,
  `pay` varchar(50) DEFAULT NULL,
  `jobID` int DEFAULT NULL,
  `companyID` int DEFAULT NULL,
  PRIMARY KEY (`applicationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `company_details` (
  `companyID` int NOT NULL,
  `companyName` varchar(20) DEFAULT NULL,
  `jobtitle` varchar(30) DEFAULT NULL,
  `jobdesc` varchar(200) DEFAULT NULL,
  `pay` varchar(30) DEFAULT NULL,
  `jobID` int NOT NULL,
  PRIMARY KEY (`companyID`,`jobID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO company_details (companyID, companyName, jobtitle, jobdesc, pay,jobID )
VALUES (1, MICROSOFT, ‘.NET Developer’,’Contributing in all phases of the development lifecycle and writing well designed, testable, efficient code.’ , 7000 ,  1324 );


