package View;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddEventFrame extends JFrame {
	private JTextArea ta;
	private JTextField tf;
	private JButton addbutton;
	public AddEventFrame(DayButton b) {
		String s = b.DayInfo.StringData;
		setTitle(b.DayInfo.Year+"년 "+b.DayInfo.Month+"월"+b.DayInfo.Day+"일");
		setLayout(new GridLayout(3,0));
		ta = new JTextArea(20,20);
		tf = new JTextField();
		ta.setText(s);
		setSize(400,300);
		addbutton = new JButton("add");
		add(tf);
		add(ta);
		addbutton.addActionListener(e ->{
			String text =tf.getText();
			ta.append (text + "\n");
			tf.selectAll();
			b.DayInfo.StringData = ta.getText();
			

		});
		add(addbutton);
		setVisible(true);
}
}
