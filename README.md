Student Management CLI App

This is a simple Student Management CLI (Command Line Interface) application built with Java and MySQL. It allows you to perform basic CRUD operations (Create, Read, Update, Delete) on student records.

Prerequisites

Java 17 or higher

MySQL Server

JDBC Driver

Spring Boot (if using Spring)

Setup

1. Create the Database Schema

Before running the app, set up the MySQL database using the provided createSchema.sql file:

-- createSchema.sql
CREATE DATABASE student_tracker;

USE student_tracker;

CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100)
);

Run this script in your MySQL client to create the necessary database and table.

CRUD Operations

2. CREATE Method

Run the CLI Main App to create the database values entry:

createMultipleStudents(studentDAO);

NOTE: Run this only the first time to avoid duplicate records.

This will create 3 sample students. You can check if the records were created successfully by running this MySQL query:

USE student_tracker;

SELECT * FROM student_tracker.student;

3. READ Method

To read and fetch a student’s details, use the following method:

showStudent(studentDAO);

This will fetch a student by their ID and print their details.

4. UPDATE Method

To update an existing student’s details, call the following method:

updateStudent(studentDAO);

Make sure the student ID you want to update exists in the database.

5. DELETE Method

To delete an existing student, run the CLI with only the following method:

deleteStudent(studentDAO);

Or use SQL queries like these:

To delete student records by a range of IDs:

DELETE FROM student WHERE id BETWEEN 1 AND 3;

Or to delete specific student IDs:

DELETE FROM student WHERE id IN (1, 2, 3);

If you’ve deleted records and want the auto-increment ID to restart from 1:

ALTER TABLE student AUTO_INCREMENT = 1;

Note: If using IntelliJ, clear caches after running the above command if needed.

