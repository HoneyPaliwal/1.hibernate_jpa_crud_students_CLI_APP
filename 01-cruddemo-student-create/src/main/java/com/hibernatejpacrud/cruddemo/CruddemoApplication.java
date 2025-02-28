package com.hibernatejpacrud.cruddemo;

import com.hibernatejpacrud.cruddemo.dao.StudentDAO;
import com.hibernatejpacrud.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			//createMultipleStudents(studentDAO); //Run this only at first time to create the students in the DB
			//readStudent(studentDAO);
			//updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 10;

		//check whether student with this id exists in the db or not
		if(studentDAO.readStudent(id)!=null){
			studentDAO.delete(id);
			System.out.println("Student with id : " + id + " deleted success.");
		} else {
			System.out.println("Student with the id : " + id + " does not exist in the DB.");
		}

	}

	private void updateStudent(StudentDAO studentDAO) {

		//find the student with id 2 to update it
		int id=2 ;

		//check whether student with this id exists in the db or not
		if(studentDAO.readStudent(id)!=null){

			Student existingStudent = studentDAO.readStudent(id);

			//existing values
			System.out.println("ExistingStudent is => " + existingStudent);

			//setting values and calling merge to update student
			existingStudent.setFirstName("poonam");
			existingStudent.setLastName("sharma");
			existingStudent.setEmail("poonamsharma@gmail.com ");

			studentDAO.updateStudent(existingStudent);

			//calling again to check the new values
			Student UpdatedStudentValues = studentDAO.readStudent(id);
			System.out.println("New Student is => " + UpdatedStudentValues);
		} else {
			System.out.println("Student with the id : " + id + " does not exist in the DB.");
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Finding the Student");

		int id = 2;

		// Call readStudent only once
		Student studentFound = studentDAO.readStudent(id);

		if (studentFound != null) {
			System.out.println("Student with id: " + studentFound.getId() + " is ");
			System.out.println(studentFound.getFirstName() + " " + studentFound.getLastName());
			System.out.println(studentFound.getEmail());
		} else {
			System.out.println("Student with the id: " + id + " does not exist in the DB.");
		}
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("honey", "paliwal", "honeypaliwal01@gmail.com");
		Student tempStudent2 = new Student("abhinav", "sharma", "abhinavsharma@gmail.com");
		Student tempStudent3 = new Student("himanshu", "vaishnav", "himanshuvishnav@gmail.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.create(tempStudent1);
		studentDAO.create(tempStudent2);
		studentDAO.create(tempStudent3);
		System.out.println("Students created.");
	}

}







