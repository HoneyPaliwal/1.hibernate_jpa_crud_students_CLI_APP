use student_tracker;

SELECT * FROM student_tracker.student;

#Delete ids in range
#Delete From student WHERE id between 4 and 6;

#Delete Specific ids
#DELETE FROM student WHERE id IN (1, 2, 3);

#Change the Ids to again start from 1 auto increment
#Cleab the caches of Intellij after running the below command if needed
#ALTER TABLE student AUTO_INCREMENT = 1;