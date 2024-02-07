package gr.aueb.cf.service;

import gr.aueb.cf.dao.IUserDAO;
import gr.aueb.cf.dao.exceptions.UserDAOException;
import gr.aueb.cf.dto.UserInsertDTO;
import gr.aueb.cf.dto.UserUpdateDTO;
import gr.aueb.cf.model.User;

public class UserServiceImpl implements IUserService{
    private final IUserDAO userDAO;

    public UserServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User insertUser(UserInsertDTO userDTO) throws UserDAOException {
        if (userDTO == null) return null;
        User user = null;

        try {
            user = map(userDTO);
            return userDAO.insert(user);
        } catch (UserDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User updateUser(UserUpdateDTO userDTO) throws UserDAOException, UserNotFoundException {
        if (userDTO == null) return null;
        User user = null;

        try {
            user = map(userDTO);
            if (userDAO.getById(userDTO.getId()) == null){
                throw new UserNotFoundException(user);
            }
            return userDAO.update(user);
        } catch (UserDAOException | UserNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteUser(Integer id) throws UserDAOException, UserNotFoundException {
        if (id == null) return;

        try {
            if (userDAO.getById(id) == null) {
                throw new UserNotFoundException("User not found");
            }
             userDAO.delete(id);
        } catch (UserDAOException | UserNotFoundException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User getUserById(Integer id) throws UserDAOException, UserNotFoundException {
        User user;

        try {
            user = userDAO.getById(id);
            if (user == null) {
                throw new UserNotFoundException("User not found");
            }
        } catch (UserNotFoundException | UserDAOException e){
            e.printStackTrace();
            throw e;
        }
        return user;
    }

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException, UserDAOException {
        User user;
        try {
            user = userDAO.getByUsername(username);
            if (user == null) {
                throw new UserNotFoundException("User not found");
            }
        } catch (UserDAOException | UserNotFoundException e) {
            e.printStackTrace();
            throw e;
        }

        return user;
    }

    private User map(UserInsertDTO dto) {
        return new User(null, dto.getUsername(), dto.getPassword(), dto.getRole());
    }

    private User map(UserUpdateDTO dto) {
        return  new User(dto.getId(), dto.getUsername(), dto.getPassword(),dto.getRole());
    }

}
