package gr.aueb.cf.dao;

import gr.aueb.cf.dao.exceptions.UserDAOException;
import gr.aueb.cf.model.User;

import java.util.List;

public interface IUserDAO {

    User insert(User user) throws UserDAOException;
    User update(User user) throws UserDAOException;
    void delete(int id) throws UserDAOException;
    User getById(int id) throws UserDAOException;
    List<User> getByLastName(String lastname) throws UserDAOException;
}
