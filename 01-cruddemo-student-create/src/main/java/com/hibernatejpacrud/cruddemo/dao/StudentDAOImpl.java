package com.hibernatejpacrud.cruddemo.dao;

import com.hibernatejpacrud.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void create(Student theStudent) {
        entityManager.persist(theStudent);
    }

    //implement read method
    @Override
    public Student readStudent(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student removeStudent = entityManager.find(Student.class, id);
        entityManager.remove(removeStudent);
    }


}










