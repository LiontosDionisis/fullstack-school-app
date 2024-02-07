package gr.aueb.cf.dao;

import gr.aueb.cf.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.model.Teacher;
import gr.aueb.cf.service.util.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl implements ITeacherDAO{

    @Override
    public Teacher insert(Teacher teacher) throws TeacherDAOException {
        String sql = "INSERT INTO TEACHERS (SSN,FIRSTNAME,LASTNAME) VALUES (?,?,?)";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {

            String ssn = teacher.getSsn();
            String firstname = teacher.getFirstname();
            String lastname = teacher.getLastname();

            ps.setString(1,ssn);
            ps.setString(2,firstname);
            ps.setString(3,lastname);

            int n = ps.executeUpdate();
            if (n != 1) return null;
            JOptionPane.showMessageDialog(null, n + " rows affected","INSERT",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e1) {
            e1.printStackTrace();
            throw new TeacherDAOException("SQL Insert Error in Teacher");
        }
        return teacher;
    }

    @Override
    public Teacher update(Teacher teacher) throws TeacherDAOException {
        String sql = "UPDATE TEACHERS SET SSN = ?, FIRSTNAME = ?, LASTNAME = ? WHERE ID = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {

            String ssn = teacher.getSsn();
            String firstname = teacher.getFirstname();
            String lastname = teacher.getLastname();
            int id = teacher.getId();

            ps.setString(1,ssn);
            ps.setString(2, firstname);
            ps.setString(3, lastname);
            ps.setInt(4,id);

            int n = ps.executeUpdate();
            if (n != 1) return null;
            JOptionPane.showMessageDialog(null, n + " rows affected","INSERT",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e1) {
            e1.printStackTrace();
            throw new TeacherDAOException("SQL Updated Error in Teacher");
        }
        return teacher;
    }

    @Override
    public void delete(Integer id) throws TeacherDAOException {
        String sql = "DELETE FROM TEACHERS WHERE ID = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1,id);
            int n = ps.executeUpdate();

            if (n != 1) {
                return;
            }
            JOptionPane.showMessageDialog(null,n + " rows affected", "DELETE", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TeacherDAOException("SQL Delete Error In Teacher");
        }
    }

    @Override
    public Teacher getById(Integer id) throws TeacherDAOException {
        String sql = "SELECT * FROM TEACHERS WHERE ID = ?";
        Teacher teacher = null;
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)
           ) {

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                teacher = new Teacher(rs.getInt("ID"), rs.getString("SSN"),rs.getString("FIRSTNAME"),rs.getString("LASTNAME"),rs.getInt("SPECIALITY_ID"),
                        rs.getInt("USER_ID"));
            }
        } catch (SQLException e1){
            e1.printStackTrace();
            throw new TeacherDAOException("SQL getById Error In Teachers");
        }
        return teacher;
    }

    @Override
    public List<Teacher> getByLastName(String lastname) throws TeacherDAOException {
        String sql = "SELECT * FROM TEACHERS WHERE LASTNAME LIKE ?";
        Teacher teacher = null;
        List<Teacher> teachers = new ArrayList<>();
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setString(1,lastname = "%");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                teacher = new Teacher(rs.getInt("ID"), rs.getString("SSN"),rs.getString("FIRSTNAME"),rs.getString("LASTNAME"),rs.getInt("SPECIALITY_ID"),
                        rs.getInt("USER_ID"));
                teachers.add(teacher);
            }
        } catch (SQLException e1){
            e1.printStackTrace();
            throw new TeacherDAOException("SQL getById Error In Teachers");
        }
        return teachers;
    }
}
