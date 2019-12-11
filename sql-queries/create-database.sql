DROP DATABASE IF EXISTS `sql_economy`;
CREATE DATABASE `sql_economy`;
USE `sql_economy`;

CREATE TABLE `players` (
	`uuid` VARCHAR(16) NOT NULL PRIMARY KEY, -- unique user id (player.getUniqueId().toString())
	`name` VARCHAR(16) NOT NULL,
	`joined_timestamp` TIMESTAMP NOT NULL DEFAULT(CURRENT_TIMESTAMP),
	`bio` VARCHAR(64) NULL
	);
    
CREATE TABLE `accounts` (
	`account_id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`uuid` VARCHAR(16) NOT NULL, -- owner
	`balance` DECIMAL NOT NULL DEFAULT(0)
	);
    
