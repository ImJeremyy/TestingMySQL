DROP DATABASE IF EXISTS `sql_economy`;
CREATE DATABASE `sql_economy`;
USE `sql_economy`;

CREATE TABLE `players` (
	`uuid` VARCHAR(16) NOT NULL PRIMARY KEY AUTO_INCREMENT, -- unique user id (player.getUniqueId().toString())
    `name` VARCHAR(16) NOT NULL
	);
    
CREATE TABLE `accounts` (
	`uuid` VARCHAR(16) NOT NULL PRIMARY KEY, -- owner
    `balance` DECIMAL NOT NULL
	);
    
