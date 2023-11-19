package Model;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;

import javax.swing.*;

import Data.UserInfo;

import java.util.*;

public class CalendarProgram {
	private JFrame frame;
    private JPanel calendarPanel;
    
    private JComboBox<String> monthComboBox;
    private CardLayout cardLayout;
    
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new CalendarProgram().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Calendar Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        calendarPanel = new JPanel(cardLayout);

       //달 선택하는 콤보 박스
        String[] months = new DateFormatSymbols().getMonths();
        monthComboBox = new JComboBox<>(months);
        monthComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCalendar();
            }
        });
      //previous버튼 클릭하면 이전 달로 넘어가게
        JButton previousButton=new JButton("previous");
        previousButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
        	
        }
        });
      //next버튼 클릭하면 다음 달로 넘어가게
        JButton nextButton=new JButton("next");
        nextButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
        	
        }
        });//controlPanel에 previousButton,nextButton, monthComboBox넣음
        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.add(previousButton);
        controlPanel.add(new JLabel("Select Month:"));
        controlPanel.add(monthComboBox);
        controlPanel.add(nextButton);
        
        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(calendarPanel, BorderLayout.CENTER);
;
        frame.setVisible(true);
        updateCalendar();
    }

    private void updateCalendar() {
        int selectedMonth = monthComboBox.getSelectedIndex();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2024);
        calendar.set(Calendar.MONTH, selectedMonth);
 //날짜 버튼 넣는 패널, calendar패널에 부착됨
        JPanel monthPanel = new JPanel(new GridLayout(0, 7));
        monthPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 요일 레이블 추가할 것
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : daysOfWeek) {
            JLabel dayLabel = new JLabel(day, JLabel.CENTER);
            monthPanel.add(dayLabel);
        }


       
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int getFirstDay = calendar.get(Calendar.DAY_OF_WEEK);

        for(int i = 0; i < getFirstDay - 1; i++) {
        	JLabel tmp = new JLabel();
        	monthPanel.add(tmp);
        }
        //새로 만든 버튼 
        class CustomButton extends JButton {
            public UserInfo data;
            public CustomButton(String text) {
                super(text); 
                
            }

        }
        class AddEvent extends JFrame {
        	private JTextArea ta;
        	private JTextField tf;
        	private JButton addbutton;
        	public AddEvent(String s,CustomButton b) {
        		setTitle(b.data.Year+"년 "+b.data.Month+"월"+b.data.Day+"일");
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
        			b.data.StringData = ta.getText();
        			

        		});
        		add(addbutton);
        		setVisible(true);
        		
        		
			}
        }
        
        //날짜 버튼
        for (int i = 1; i < calendar.getActualMaximum(Calendar.DAY_OF_MONTH) + 1; i++) {
        	CustomButton dayButton = new CustomButton(Integer.toString(i));
            dayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	CustomButton b = (CustomButton)e.getSource();
                	if(b.data==null) {
                		b.data = new UserInfo();
                		b.data.Year = calendar.get(Calendar.YEAR);
                		b.data.Month = calendar.get(Calendar.MONTH);
                		b.data.Day = Integer.parseInt(b.getText());
                	}
                	AddEvent addframe = new AddEvent(b.data.StringData,b);
                	b.data.StringData=addframe.ta.getText();
                	
                	
                	
                }
            });
            monthPanel.add(dayButton);
        }

        String monthString = new SimpleDateFormat("MMMM yyyy").format(calendar.getTime());
        calendarPanel.add(monthPanel, monthString);
        cardLayout.show(calendarPanel, monthString);
    }
    
    
}
