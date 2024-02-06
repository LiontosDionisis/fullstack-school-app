package gr.aueb.cf.viewcontroller;

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
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserSearchResults extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTxt;
	private JTextField passwordTxt;
	private JTextField roleTxt;
	private JTextField idTxt;

	
	/**
	 * Create the frame.
	 */
	public UserSearchResults() {
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
		passwordTxt.setBounds(231, 174, 122, 20);
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
