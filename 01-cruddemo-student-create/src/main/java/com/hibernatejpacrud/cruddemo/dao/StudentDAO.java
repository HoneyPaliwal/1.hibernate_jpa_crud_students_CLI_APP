package com.hibernatejpacrud.cruddemo.dao;

import com.hibernatejpacrud.cruddemo.entity.Student;

public interface StudentDAO {

    //create
    void create(Student theStudent);

    //read
     Student readStudent(int id);

     //update
     void updateStudent(Student theStudent);

     //delete
    void delete(int id);

}
