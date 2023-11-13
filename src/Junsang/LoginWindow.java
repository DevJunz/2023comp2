package Junsang;

import java.awt.*;
import javax.swing.*;

public class LoginWindow extends JFrame{
	JTextField id;
	JPasswordField pw;
	
	public LoginWindow() {
		setSize(300,150);
		
		JPanel panel = new JPanel();
		id = new JTextField(20);
		pw = new JPasswordField(20);
		add(panel);
		
		panel.add(new JLabel("id     "));
		panel.add(id);
		panel.add(new JLabel("password"));
		panel.add(pw);
		
		JButton login = new JButton("Login");
		panel.add(login);
		
		JButton regist = new JButton("Registration");
		panel.add(regist);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new LoginWindow();
	}
}
