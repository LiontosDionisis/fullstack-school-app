package gr.aueb.cf.viewcontroller;

import gr.aueb.cf.dao.IUserDAO;
import gr.aueb.cf.dao.UserDAOImpl;
import gr.aueb.cf.dao.exceptions.UserDAOException;
import gr.aueb.cf.dto.UserUpdateDTO;
import gr.aueb.cf.model.User;
import gr.aueb.cf.service.IUserService;
import gr.aueb.cf.service.UserNotFoundException;
import gr.aueb.cf.service.UserServiceImpl;
import gr.aueb.cf.viewcontroller.Main;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import static java.lang.Integer.parseInt;

public class UserSearchResults extends JFrame {

	private static final long serialVersionUID = 1L;
	private final IUserDAO userDAO = new UserDAOImpl();
	private final IUserService userService = new UserServiceImpl(userDAO);
	private JPanel contentPane;
	private JTextField usernameTxt;
	private JTextField passwordTxt;
	private JTextField roleTxt;
	private JTextField idTxt;

	public UserSearchResults() {
		addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {

			}

			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {
				try {

					User user = userDAO.getByUsername(Main.getUsersMenu().getSearchUsername().trim());
					if (user == null) {
						JOptionPane.showMessageDialog(null,"No users found","USERS",JOptionPane.ERROR_MESSAGE);
						Main.getUserSearchResults().setVisible(false);
						Main.getUsersMenu().setEnabled(true);
					}

					idTxt.setText(String.valueOf(user.getId()));
					usernameTxt.setText(user.getUsername());
					roleTxt.setText(user.getRole());


				} catch (UserDAOException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameTxt = new JTextField();
		usernameTxt.setBounds(231, 128, 122, 20);
		usernameTxt.setColumns(10);
		contentPane.add(usernameTxt);
		
		JLabel usernameLbl = new JLabel("Username");
		usernameLbl.setBounds(126, 126, 73, 21);
		usernameLbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(usernameLbl);
		
		passwordTxt = new JTextField();
		passwordTxt.setBounds(231, 174, 200, 20);
		passwordTxt.setColumns(10);
		contentPane.add(passwordTxt);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setBounds(126, 172, 70, 21);
		passwordLbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(passwordLbl);
		
		roleTxt = new JTextField();
		roleTxt.setBounds(231, 221, 86, 20);
		roleTxt.setColumns(10);
		contentPane.add(roleTxt);
		
		JLabel roleLbl = new JLabel("Role");
		roleLbl.setBounds(166, 219, 33, 21);
		roleLbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(roleLbl);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					String username = usernameTxt.getText();
					String password = passwordTxt.getText();
					String role = roleTxt.getText();
					Integer id = Integer.parseInt(idTxt.getText());

					UserUpdateDTO userDTO = new UserUpdateDTO();
					userDTO.setId(id);
					userDTO.setUsername(username);
					userDTO.setPassword(password);
					userDTO.setRole(role);

					User user = userService.updateUser(userDTO);

					if (user == null) {
						JOptionPane.showMessageDialog(null, "No user to update", "UPDATE ERROR", JOptionPane.ERROR_MESSAGE);
					}

					JOptionPane.showMessageDialog(null,"User has been updated", "UPDATE",JOptionPane.INFORMATION_MESSAGE);

					} catch (UserDAOException | UserNotFoundException e1) {
						e1.printStackTrace();
				}
			}
		});
		updateBtn.setBounds(126, 306, 111, 27);
		updateBtn.setForeground(Color.RED);
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(updateBtn);
		
		idTxt = new JTextField();
		idTxt.setBackground(new Color(255, 255, 168));
		idTxt.setEditable(false);
		idTxt.setBounds(231, 84, 61, 20);
		contentPane.add(idTxt);
		idTxt.setColumns(10);
		
		JLabel idLbl = new JLabel("ID");
		idLbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		idLbl.setBounds(166, 82, 33, 21);
		contentPane.add(idLbl);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer id = Integer.parseInt(idTxt.getText());
				try {
					int response = JOptionPane.showConfirmDialog(null,"Are you sure?","Warning",JOptionPane.YES_NO_OPTION);
					if (response == JOptionPane.YES_OPTION) {
						userService.deleteUser(id);
					}

				} catch (UserDAOException ex) {
					throw new RuntimeException(ex);
				} catch (UserNotFoundException ex) {
					throw new RuntimeException(ex);
				}
			}
		});
		deleteBtn.setForeground(Color.RED);
		deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deleteBtn.setBounds(247, 306, 106, 27);
		contentPane.add(deleteBtn);
		
		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getUserSearchResults().setVisible(false);
				Main.getUsersMenu().setEnabled(true);
			}
		});
		closeBtn.setForeground(Color.RED);
		closeBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		closeBtn.setBounds(578, 396, 129, 41);
		contentPane.add(closeBtn);
	}
}
