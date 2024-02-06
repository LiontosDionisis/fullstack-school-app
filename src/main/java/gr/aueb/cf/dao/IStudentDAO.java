package gr.aueb.cf.dao;

import gr.aueb.cf.dao.exceptions.StudentDAOException;
import gr.aueb.cf.model.Student;

import java.util.List;

public interface IStudentDAO {

    Student insert(Student student) throws StudentDAOException;
    Student update(Student student) throws StudentDAOException;
    void delete(int id) throws StudentDAOException;
    Student getById(int id) throws StudentDAOException;
    List<Student> getByLastName(String lastname) throws StudentDAOException;
}
