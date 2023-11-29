package View;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class AddEventFrame extends JFrame {
	private JTextArea ta;
	private JTextField tf;
	private JPanel buttonpanel;
	private JButton addbutton;
	private JButton resetbutton;
	public AddEventFrame(DayButton b) {
		String s = b.DayInfo.StringData;
		setTitle(b.DayInfo.Year+"년 "+b.DayInfo.Month+"월"+b.DayInfo.Day+"일");
		setLayout(new GridLayout(3,0));
		ta = new JTextArea(20,20);
		ta.setEditable(false);//변경 불가
		ta.setFont(new Font("Serif", Font.BOLD, 18));
		tf = new JTextField(30);
		ta.setText(s);
		
		String taText = ta.getText();
		add(tf);
		add(ta);
		
		int lineCount = 0;
		for(char c : taText.toCharArray()) {
			if(c == '\n')
				lineCount++;
		}
		if(lineCount!=0) {
			b.title.setText(lineCount+"");
			b.setBorderPainted(false);
			b.setBackground(Color.PINK);
			
		}
		
		setSize(400,300);
		
		buttonpanel = new JPanel();
		addbutton = new JButton("add");
		
		addbutton.addActionListener(e ->{
			String text =tf.getText();
			ta.append ("- " + text + "\n"); 
			tf.selectAll();
			b.DayInfo.StringData = ta.getText();
			
			String taText1 = ta.getText();
			int lineCount1 = 0;
			for(char c : taText1.toCharArray()) {
				if(c == '\n')
					lineCount1++;
			}
			if(lineCount1!=0) {
				b.title.setText(lineCount1+"");
				b.setBorderPainted(false);
				b.setBackground(Color.PINK);
			}
			
			try {
				File directory = new File("src/Data/Database");
				
				if(!directory.exists())directory.mkdir();
				
				FileWriter fw = new FileWriter("src/Data/Database/"+b.DayInfo.Year+"_"+b.DayInfo.Month+"_"+b.DayInfo.Day+".txt");
				
				fw.write(b.DayInfo.StringData);
				fw.close();
			}
			catch(IOException ea) {
				ea.printStackTrace();
				
			}
			

		});
		
		//====================================== reset button
		resetbutton = new JButton("reset");
		resetbutton.addActionListener(e->{
			ta.setText("");
			b.DayInfo.StringData = "";
			b.title.setText("");
			b.setBackground(new JButton().getBackground());
			b.setBorderPainted(true);
			
			File file = new File("src/Data/Database/"+b.DayInfo.Year+"_"+b.DayInfo.Month+"_"+b.DayInfo.Day+".txt");
			if(file.exists()) file.delete();
			else {
				System.out.println("파일이 존재하지 않습니다.");
			}
			
		});
		buttonpanel.add(addbutton);
		buttonpanel.add(resetbutton);
		add(buttonpanel);
}
}
