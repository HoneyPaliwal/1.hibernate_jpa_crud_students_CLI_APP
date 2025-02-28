1. Create The Schema in MySQL - using the file createSchema.sql
2. CREATE Method - Run the CLI Main App to create the DB values entry -
    //NOTE - Run this only at first time to create the students in the DB
       createMultipleStudents(studentDAO);

3. Above method will create the 3 students, check the DB if the students are created or not.
4. Read Method - Run the CLI with only below method to get any student details
        showStudent(studentDAO);

5. Update Method - To update the existing student Run the CLI with only below method
        updateStudent(studentDAO);

6. Delete Method