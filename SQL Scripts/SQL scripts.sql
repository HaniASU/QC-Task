-- Create the Users table
CREATE TABLE IF NOT EXISTS Users (
    ID INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Type VARCHAR(20) NOT NULL CHECK (Type IN ('employee', 'manager'))
);

-- Sample records
INSERT INTO Users (ID, Name, Type) VALUES (1, 'John', 'manager');
INSERT INTO Users (ID, Name, Type) VALUES (2, 'Doe', 'manager');
INSERT INTO Users (ID, Name, Type) VALUES (3, 'Ahmed', 'employee');
INSERT INTO Users (ID, Name, Type) VALUES (4, 'Mohamed', 'employee');

-- SELECT QUERIES
SELECT * FROM Users;
SELECT * FROM Users WHERE Type = 'manager'; -- Select only managers
SELECT * FROM Users WHERE Type <> 'manager'; -- Select only employees
SELECT * FROM Users WHERE Name LIKE 'A%'; -- Select any name starting with 'A'
SELECT * FROM Users ORDER BY Name ASC; -- Order by name ascending

SELECT * FROM Users   --Select all Users for employees whose names start with "Mo" or for managers with ID ≥ 2
WHERE (Type = 'employee' AND Name LIKE 'Mo%')
   OR  (Type = 'manager' AND ID >= 2);

SELECT COUNT(*) FROM Users; -- Count total users

-- INSERT another employee
INSERT INTO Users (ID, Name, Type) VALUES (5, 'Hany', 'employee');
SELECT * FROM Users;

-- UPDATE a specific user's type
UPDATE Users SET Type = 'manager' WHERE ID = 3; -- Update user type of specific user using ID 
SELECT * FROM Users;       --check th e updated table

UPDATE Users SET Name = 'Mohamed Ali' WHERE Type = 'employee' AND Name LIKE 'Mo%';     -- Update names of employees whose names start with 'Mo'
SELECT * FROM Users;      --check th e updated table

UPDATE Users -- Update Type to 'manager' for users with IDs 3–105 whose names start with 'Mo'
SET Type = CASE
             WHEN Name LIKE 'Mo%' THEN 'manager'
             ELSE Type
           END
WHERE ID BETWEEN 3 AND 105;


-- DELETE QUERIES
DELETE FROM Users WHERE ID = 1;  -- Delete user with ID 1
SELECT * FROM Users;

DELETE FROM Users WHERE Type = 'employee'; -- Delete all employees
SELECT * FROM Users;
