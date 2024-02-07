package gr.aueb.cf.dao;

import gr.aueb.cf.dao.exceptions.UserDAOException;
import gr.aueb.cf.model.User;
import gr.aueb.cf.service.UserNotFoundException;

import java.util.List;

public interface IUserDAO {

    User insert(User user) throws UserDAOException;
    User update(User user) throws UserDAOException;
    void delete(Integer id) throws UserDAOException;
    User getById(Integer id) throws UserDAOException;
    User getByUsername(String username) throws UserDAOException;
}
