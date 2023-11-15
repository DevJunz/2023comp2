package Junsang;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RegistrationWindow extends JFrame{
	private static JLabel password1 ,username1;
	private static JTextField newUsername;
	private static JButton regist, cancel;
	private static JPasswordField newPassword;
	
	public RegistrationWindow() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		setTitle("Registration Page");
		add(panel);
		panel.setBackground(Color.WHITE);
		setSize(new Dimension(400, 300));
		
		username1 = new JLabel("New Username");
		username1.setBounds(100, 38, 90, 20);
		panel.add(username1);
		
		newUsername = new JTextField();
		newUsername.setBounds(100, 57, 193, 28);
		panel.add(newUsername);
		
		password1 = new JLabel("New Password");
		password1.setBounds(100, 95, 90, 20);
		panel.add(password1);
		
		newPassword = new JPasswordField();
		newPassword.setBounds(100, 115, 193, 28);
		panel.add(newPassword);
		
		regist = new JButton("Registration");
		regist.setBounds(80, 170, 110, 25);
		regist.setForeground(Color.WHITE);
		regist.setBackground(Color.BLACK);
		panel.add(regist);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(203, 170, 110, 25);
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		panel.add(cancel);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new RegistrationWindow();
	}
}
