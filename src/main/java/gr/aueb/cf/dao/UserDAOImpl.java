package gr.aueb.cf.dao;

import gr.aueb.cf.dao.exceptions.UserDAOException;
import gr.aueb.cf.model.User;
import gr.aueb.cf.service.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements IUserDAO{
    @Override
    public User insert(User user) throws UserDAOException {
        String sql = "INSERT INTO USERS (USERNAME,PASSWORD,ROLE) VALUES (?,?,?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
             

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public User update(User user) throws UserDAOException {
        return null;
    }

    @Override
    public void delete(int id) throws UserDAOException {

    }

    @Override
    public User getById(int id) throws UserDAOException {
        return null;
    }

    @Override
    public List<User> getByLastName(String lastname) throws UserDAOException {
        return null;
    }
}
