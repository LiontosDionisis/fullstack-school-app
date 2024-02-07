package gr.aueb.cf.viewcontroller;

import gr.aueb.cf.dao.IUserDAO;
import gr.aueb.cf.dao.UserDAOImpl;
import gr.aueb.cf.dao.exceptions.UserDAOException;
import gr.aueb.cf.dto.UserInsertDTO;
import gr.aueb.cf.model.User;
import gr.aueb.cf.service.IUserService;
import gr.aueb.cf.service.UserServiceImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;

public class UsersMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private final IUserDAO userDAO = new UserDAOImpl();
	private final IUserService userService = new UserServiceImpl(userDAO);
	private JPanel contentPane;
	private JTextField searchUserTxt;
	private JTextField insertUserTxt;
	private JTextField passwordTxt;
	private JTextField roleTxt;
	private String searchUsername;


	public UsersMenu() {
		addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
				searchUserTxt.setText("");
				insertUserTxt.setText("");
				passwordTxt.setText("");
				roleTxt.setText("");
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

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel searchLbl = new JLabel("SEARCH FOR USER");
		searchLbl.setForeground(new Color(0, 0, 255));
		searchLbl.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		searchLbl.setBounds(267, 34, 274, 38);
		contentPane.add(searchLbl);

		JLabel usernameLbl = new JLabel("INSERT USERNAME");
		usernameLbl.setForeground(new Color(0, 0, 255));
		usernameLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameLbl.setBounds(327, 68, 153, 29);
		contentPane.add(usernameLbl);

		searchUserTxt = new JTextField();
		searchUserTxt.setBounds(267, 108, 274, 20);
		contentPane.add(searchUserTxt);
		searchUserTxt.setColumns(10);

		JButton searchBtn = new JButton("SEARCH");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchUsername = searchUserTxt.getText().trim();
				Main.getUsersMenu().setEnabled(false);
				Main.getUserSearchResults().setVisible(true);
			}
		});
		searchBtn.setForeground(new Color(255, 0, 0));
		searchBtn.setBounds(361, 139, 89, 29);
		contentPane.add(searchBtn);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 231, 868, 11);
		contentPane.add(separator);

		JLabel lblNewLabel = new JLabel("INSERT USER");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(327, 231, 200, 55);
		contentPane.add(lblNewLabel);

		JLabel insertUserLbl = new JLabel("Username");
		insertUserLbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		insertUserLbl.setBounds(125, 295, 80, 29);
		contentPane.add(insertUserLbl);

		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		passwordLbl.setBounds(135, 336, 70, 29);
		contentPane.add(passwordLbl);

		JLabel roleLbl = new JLabel("Role");
		roleLbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		roleLbl.setBounds(166, 376, 39, 29);
		contentPane.add(roleLbl);

		insertUserTxt = new JTextField();
		insertUserTxt.setBounds(232, 301, 218, 20);
		contentPane.add(insertUserTxt);
		insertUserTxt.setColumns(10);

		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(232, 342, 218, 20);
		contentPane.add(passwordTxt);

		roleTxt = new JTextField();
		roleTxt.setColumns(10);
		roleTxt.setBounds(232, 382, 113, 20);
		contentPane.add(roleTxt);

		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = insertUserTxt.getText().trim();
				String password = passwordTxt.getText().trim();
				String role = roleTxt.getText().trim();

				try {
					UserInsertDTO userDTO = new UserInsertDTO();
					userDTO.setUsername(username);
					userDTO.setPassword(password);
					userDTO.setRole(role);

					User user = userService.insertUser(userDTO);

					if (user == null) {
						JOptionPane.showMessageDialog(null, "User not inserted", "INSERT ERROR", JOptionPane.ERROR_MESSAGE);
					}

					JOptionPane.showMessageDialog(null, "User inserted", "INSERT", JOptionPane.INFORMATION_MESSAGE);

				} catch (UserDAOException e1) {
					e1.printStackTrace();

				}
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(232, 424, 104, 29);
		contentPane.add(btnNewButton);
	}

	public String getSearchUsername() {
		return searchUsername;
	}

}
