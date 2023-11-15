package test;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
public class TheDay {
	public static void main(String arg[]) {
		JFrame f = new FrameA();
	}
	

}
class FrameA extends JFrame{
	public FrameA() {
		setSize(500, 500);
		JPanel panel = new JPanel();
		JButton button1 = new JButton("버튼1");
		JTextField text = new JTextField(30);
		button1.addActionListener(e->{
			new FrameB(text);
		});
		panel.add(button1);
		panel.add(text);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
class FrameB extends JFrame{
	public FrameB(JTextField text) {
		setSize(500,500);
		JButton button2 = new JButton("버튼2");
		button2.addActionListener(t->{
			text.setText("성공");
		});
		add(button2);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}


