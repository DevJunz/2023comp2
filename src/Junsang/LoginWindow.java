package Junsang;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginWindow extends JFrame{
	private static JLabel password1, username1;
	private static JTextField username;
	private static JButton login, cancel, regist;
	private static JPasswordField password;
	
	public LoginWindow() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		setTitle("Login Page");
		add(panel);
		panel.setBackground(Color.WHITE);
		setSize(new Dimension(400, 300));
		
		username1 = new JLabel("Username");
		username1.setBounds(100, 38, 70, 20);
		panel.add(username1);
		
		username = new JTextField();
		username.setBounds(100, 57, 193, 28);
		panel.add(username);
		
		password1 = new JLabel("Password");
		password1.setBounds(100, 95, 70, 20);
		panel.add(password1);
		
		password = new JPasswordField();
		password.setBounds(100, 115, 193, 28);
		panel.add(password);
		
		login = new JButton("Login");
		login.setBounds(100, 170, 90, 25);
		login.setForeground(Color.WHITE);
		login.setBackground(Color.BLACK);
		panel.add(login);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(203, 170, 90, 25);
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.addActionListener(e -> {System.exit(0);});
		panel.add(cancel);
		
		regist = new JButton("Registration");
		regist.setBounds(143, 210, 110, 20);
		regist.setForeground(Color.WHITE);
		regist.setBackground(Color.BLACK);
		panel.add(regist);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new LoginWindow();
	}
}
