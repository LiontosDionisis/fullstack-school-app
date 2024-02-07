package gr.aueb.cf.dao;

import gr.aueb.cf.dao.exceptions.UserDAOException;
import gr.aueb.cf.model.User;
import gr.aueb.cf.service.util.DBUtil;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    @Override
    public User insert(User user) throws UserDAOException {
        String sql = "INSERT INTO USERS (USERNAME,PASSWORD,ROLE) VALUES (?,?,?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            String username = user.getUsername();
            String password = user.getPassword();
            String role = user.getRole();

            BCrypt.hashpw(password, BCrypt.gensalt());      // Password Encryption

            ps.setString(1, username);
            ps.setString(2, BCrypt.hashpw(password, BCrypt.gensalt()));
            ps.setString(3, role);

            int n = ps.executeUpdate();

            if (n != 1) {
                return null;
            }
            JOptionPane.showMessageDialog(null, n + " rows affected\n" + " User has been inserted", "INSERT", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e1) {
            e1.printStackTrace();
            throw new UserDAOException("SQL Insert Error in User");
        }

        return user;
    }

    @Override
    public User update(User user) throws UserDAOException {
        String sql = "UPDATE USERS SET USERNAME = ? , PASSWORD = ? , ROLE = ? WHERE ID = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            int id = user.getId();
            String username = user.getUsername();
            String password = user.getPassword();
            String role = user.getRole();



            ps.setString(1, username);
            ps.setString(2, BCrypt.hashpw(password, BCrypt.gensalt()));
            ps.setString(3, role);
            ps.setInt(4, id);

            int n = ps.executeUpdate();

            if (n != 1) {
                return null;
            }
            JOptionPane.showMessageDialog(null, n + " rows affected\n" + " User has been updated", "UPDATE", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e1) {
            e1.printStackTrace();
            throw new UserDAOException("SQL Update Error in User");
        }
        return user;
    }

    @Override
    public void delete(Integer id) throws UserDAOException {
        String sql = "DELETE FROM USERS WHERE ID = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);

            int n = ps.executeUpdate();

            if (n != 1) return;

            JOptionPane.showMessageDialog(null, n + " rows affected\n" + " User has been deleted", "DELETE", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e1) {
            e1.printStackTrace();
            throw new UserDAOException("SQL Delete Error in User");
        }

    }

    @Override
    public User getById(Integer id) throws UserDAOException {
        String sql = "SELECT * FROM USERS WHERE ID = ?";
        User user = null;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs;

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(rs.getInt("ID"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("ROLE"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
            throw new UserDAOException("SQL getById Error in User");
        }

        return user;
    }

    @Override
    public User getByUsername(String username) throws UserDAOException {
        String sql = "SELECT * FROM USERS WHERE USERNAME LIKE ?";
        User user = null;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs;

            ps.setString(1, username + "%");
            rs = ps.executeQuery();

            if (rs.next()) {
                 user = new User(rs.getInt("ID"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("ROLE"));

            }
        } catch (SQLException e1) {
            e1.printStackTrace();
            throw new UserDAOException("SQL getByLastName Error in User");
        }
        return user;
    }
}

