ALTER TABLE user CHANGE COLUMN id userid int;

CREATE TABLE Account(
accountNumber INT PRIMARY KEY UNIQUE,
balance INT UNIQUE NOT NULL,
userId  INT
);
ALTER TABLE Account
ADD CONSTRAINT fk_account_user
FOREIGN KEY (userId)
REFERENCES user(userid);

ALTER TABLE Account
MODIFY userid INT NOT NULL;

CREATE TABLE Transactions(
transactionid INT PRIMARY KEY UNIQUE,
accountnumber INT NOT NULL,
transactionDate DATETIME NOT NULL,
transactionDescription VARCHAR(150)
);

ALTER TABLE Transactions
ADD CONSTRAINT fk_transactions_account
FOREIGN KEY (accountnumber)
REFERENCES Account (accountNumber);