USE sql_economy;

INSERT INTO `players` (`uuid`, `name`) VALUES ('123-456', 'MarkIsCool');
INSERT INTO `players` (`uuid`, `name`) VALUES ('123-129', 'DimSumPotato');

INSERT INTO `accounts` (`uuid`) VALUES ('123-456');

DELETE FROM `players` WHERE `name` = 'DimSumPotato';

CREATE TABLE `accounts_backup` SELECT * FROM accounts;

DROP TABLE `accounts_backup`;