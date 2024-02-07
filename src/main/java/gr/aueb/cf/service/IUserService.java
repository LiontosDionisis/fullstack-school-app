package gr.aueb.cf.service;

import gr.aueb.cf.dao.exceptions.UserDAOException;
import gr.aueb.cf.dto.UserInsertDTO;
import gr.aueb.cf.dto.UserUpdateDTO;
import gr.aueb.cf.model.User;

public interface IUserService {

    User insertUser(UserInsertDTO userDTO) throws UserDAOException;
    User updateUser(UserUpdateDTO userDTO) throws UserDAOException, UserNotFoundException;
    void deleteUser(Integer id) throws UserDAOException, UserNotFoundException;
    User getUserById(Integer id) throws UserDAOException, UserNotFoundException;
    User getUserByUsername(String username) throws UserNotFoundException, UserDAOException;
}
