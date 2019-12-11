# Database Notes:
Contains two tables "players" and "accounts"

# Players
uuid (Unique User Identification) Varchar(16) NOT NULL PRIMARY KEY
name (in game username) VARCHAR(16) NOT NULL
joined_timestamp (time stamp of when they joined) TIMESTAMP NOT NULL DEFAULT(CURRENT_TIMESTAMP),
bio (basic user notes) VARCHAR(64) NULL

# Accounts
account_id (auto incremented value) INT(11)
uuid (unique user identification) VARCHAR(16) NOT NULL,
balance (amount of money) DECIMAL NOT NULL DEFAULT(0)