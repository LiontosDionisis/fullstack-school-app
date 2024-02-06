package gr.aueb.cf.viewcontroller;

import gr.aueb.cf.dao.IUserDAO;
import gr.aueb.cf.viewcontroller.Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsersMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchUserTxt;
	private JTextField insertUserTxt;
	private JTextField passwordTxt;
	private JTextField roleTxt;
	private String searchUsername;

	/**
	 * Create the frame.
	 */
	public UsersMenu() {
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
