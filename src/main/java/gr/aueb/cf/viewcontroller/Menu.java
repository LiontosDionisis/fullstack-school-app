package gr.aueb.cf.viewcontroller;

import gr.aueb.cf.viewcontroller.Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton userBtn = new JButton("Users");
		userBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Main.getMenu().setEnabled(false);
//				Main.getUsersMenu().setVisible(true);
				
				try {
			        Main.getMenu().setEnabled(false);
			        Main.getUsersMenu().setVisible(true);
			    } catch (NullPointerException ex) {
			        ex.printStackTrace();
			        // Handle the exception or log a message
			    }
			}
		});
		userBtn.setForeground(new Color(255, 0, 0));
		userBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		userBtn.setBounds(43, 48, 110, 23);
		contentPane.add(userBtn);
		
		JButton btnTeachers = new JButton("Teachers");
		btnTeachers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTeachers.setForeground(new Color(0, 0, 255));
		btnTeachers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTeachers.setBounds(173, 96, 118, 23);
		contentPane.add(btnTeachers);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.setForeground(new Color(0, 0, 0));
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStudents.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStudents.setBounds(303, 161, 121, 23);
		contentPane.add(btnStudents);
	}
}
