package View;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
public class CalendarFrame extends JFrame {
	JPanel DatePanel;//최상단 연 월 일 표시할 부분
	JLabel DaysLabel;
	JButton CalendarButtons[];
	JPanel CalendarPanel;
	JPanel addPanel;
	public CalendarFrame(LocalDate today) {
		setSize(1000,1000);//Frame 사이즈 설정
		setLayout(new GridLayout(3,0));
		
		JPanel DatePanel = new JPanel();//최상단부분 
		JLabel DaysLabel = new JLabel("2023년 11월 16일");
		DatePanel.add(DaysLabel);
		add(DatePanel);
		/////////////////////////////////////////////////////////////////////
		JPanel CalendarPanel = new JPanel(new GridLayout(6,7));
		String s[] = {"Monday","Tuesday","Wednesday","Thurseday","Friday","Saturday","Sunday",
		"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19",
		"20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35"
		};
		CalendarButtons = new JButton[s.length];
		int count =0;
		for(String a:s) {
			CalendarButtons[count]= new JButton(a);
			CalendarPanel.add(CalendarButtons[count++]);
		}
		add(CalendarPanel);
		//////////////////////////////////////////////////////////////////////////
		addPanel = new JPanel();
		JTextArea result = new JTextArea(3,30);
		addPanel.add(result);
		add(addPanel);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
