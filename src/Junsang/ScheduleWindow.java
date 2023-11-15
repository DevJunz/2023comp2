package Junsang;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;

public class ScheduleWindow extends JFrame{
	private static JLabel y, m, d, sN, t, tilde, dt;
	private static JTextField scheduleName, from, until; 
	private static JTextArea details;
	private static JButton confirm, cancel;
	private static JPanel panelT, panelM, panelB;
	private static JComboBox month, day;
	
	public ScheduleWindow() {
		setTitle("Schedule Page");
		setSize(new Dimension(400, 300));
		
		panelM = new JPanel();
		panelM.setLayout(null);
		add(panelM, BorderLayout.CENTER);
		panelM.setBackground(Color.WHITE);
		
		sN = new JLabel("Schedule Name");
		sN.setBounds(30, 10, 90, 20);
		panelM.add(sN);
		
		scheduleName = new JTextField();
		scheduleName.setBounds(30, 29, 140, 28);
		panelM.add(scheduleName);
		
		t = new JLabel("Schedule Time");
		t.setBounds(30, 70, 90, 20);
		panelM.add(t);
		from = new JTextField();
		until = new JTextField();
		from.setBounds(30, 89, 140, 28);
		until.setBounds(30, 139, 140, 28);
		panelM.add(from);
		panelM.add(until);
		tilde = new JLabel("~");
		tilde.setBounds(93, 115, 20, 20);
		panelM.add(tilde);
		
		dt = new JLabel("Schedule Details");
		dt.setBounds(200, 10, 120, 20);
		panelM.add(dt);
		
		details = new JTextArea(2, 20);
		details.setLineWrap(true);
		JScrollPane scrollpane = new JScrollPane(details);
		scrollpane.setBounds(200, 29, 170, 140);
		panelM.add(scrollpane);
		
		panelT = new JPanel();
		add(panelT, BorderLayout.NORTH);
		panelT.setBackground(Color.WHITE);
		
		y = new JLabel("2024년");
		panelT.add(y);
		
		String[] months = {"1", "2", "3"};
		month = new JComboBox<>(months);
		panelT.add(month);
		m = new JLabel("월");
		panelT.add(m);
		
		String[] days = {"1", "2", "3"};
		day = new JComboBox<>(days);
		panelT.add(day);
		d = new JLabel("일");
		panelT.add(d);
		
		panelB = new JPanel();
		add(panelB, BorderLayout.SOUTH);
		panelB.setBackground(Color.WHITE);
		
		confirm = new JButton("Confirm");
		confirm.setSize(90, 25);
		confirm.setForeground(Color.WHITE);
		confirm.setBackground(Color.BLACK);
		panelB.add(confirm);
		
		cancel = new JButton("Cancel");
		cancel.setSize(90, 25);
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		panelB.add(cancel);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ScheduleWindow();
	}
}
