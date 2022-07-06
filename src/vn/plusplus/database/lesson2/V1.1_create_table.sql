#Create table
CREATE TABLE IF NOT EXISTS student (
	mssv VARCHAR(20) NOT NULL,
    `name` VARCHAR(45) NULL,
    age INT NULL,
    `status` INT NOT NULL DEFAULT 0
);