package View;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.stream.IntStream;

import javax.swing.*;

import Data.UserInfo;
import View.AddEventFrame;

public class MainCalendar extends JFrame {
	private JPanel CalendarPanel;
	private JComboBox<String> MonthComboBox;
    private CardLayout cardLayout;
    private JPanel ControlPanel;
    //생성자 부분
    public MainCalendar(){
    	setTitle("My Java 스케줄러");
    	setSize(500,600);
    	cardLayout = new CardLayout();
    	CalendarPanel = new JPanel(cardLayout);
    	
    	//달 선택하는 콤보 박스
    	String[] Month_Arr = new DateFormatSymbols().getMonths();
    	
        MonthComboBox = new JComboBox(Month_Arr);
        MonthComboBox.addActionListener(e -> ChangeCalendar() );
        
        //ContralPanel 가장 윗 부분
        
        JButton PreviousButton=new JButton("previous");
        PreviousButton.addActionListener(e -> {
        	int selectedMonth = MonthComboBox.getSelectedIndex();
        	MonthComboBox.setSelectedIndex((selectedMonth == 0 ? 11 : selectedMonth-1));
        });
        JButton NextButton=new JButton("next");
        NextButton.addActionListener(e -> {
        	int selectedMonth = MonthComboBox.getSelectedIndex();
        	MonthComboBox.setSelectedIndex((selectedMonth == 11 ? 0 : selectedMonth+1));
        });
        
        JLabel  Month_Seclect = new JLabel("Select Month:");
        ControlPanel = new JPanel();
        ControlPanel.add(PreviousButton);
        ControlPanel.add(Month_Seclect);
        ControlPanel.add(MonthComboBox);
        ControlPanel.add(NextButton);
     add(ControlPanel,"North");
     add(CalendarPanel,"Center");
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setVisible(true);
     MakeCalendar();
        
    }
    //Calendar를 바꾸는 메서드
    private void ChangeCalendar() {
    	int selectedMonth = MonthComboBox.getSelectedIndex();
        cardLayout.show(CalendarPanel, String.valueOf(selectedMonth));
    }
    /*===============================================*/
    private JPanel DayPanel; // 요일이 저장되는 panel로 라벨이 저장되어 있다. 
    //함수 정의 부분
    //MakeCalendar 메서드는 처음 시작할 때 한 번만 호출된다. 
    private void MakeCalendar(){
    	for(int m=0;m<12;m++) {
    	
    	Calendar ThisCalendar = Calendar.getInstance();
    	ThisCalendar.set(Calendar.YEAR,2024);
    	ThisCalendar.set(Calendar.MONTH,m);
    	/*===============================================*/
    	DayPanel = new JPanel(new GridLayout(0,7));
    	DayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    	ArrayList<String> DaysOfWeek = new ArrayList<>(Arrays.asList("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"));
    	for (String day : DaysOfWeek) {
            JLabel dayLabel = new JLabel(day, JLabel.CENTER);
            /*================== 요일 색 바꾸기*/
            if(day == "Sun")
            	dayLabel.setForeground(Color.red);
            else if(day == "Sat")
            	dayLabel.setForeground(Color.blue);
            /*==================*/
            DayPanel.add(dayLabel);
        }
    	/*===============================================*/
    	
    	ThisCalendar.set(Calendar.DAY_OF_MONTH, 1);
        int getFirstDay = ThisCalendar.get(Calendar.DAY_OF_WEEK);

        IntStream.range(0, getFirstDay - 1)
        .forEach(i -> DayPanel.add(new JLabel()));
        //버튼 추가 과정
        for(int i = 1;i<ThisCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)+1;i++) {
        	DayButton dayButton = new DayButton(Integer.toString(i));
        	dayButton.addActionListener(e->{
        		DayButton b= (DayButton)e.getSource();
        		if(b.DayInfo==null) {
        			b.DayInfo = new UserInfo();
            		b.DayInfo.Year = ThisCalendar.get(Calendar.YEAR);
            		b.DayInfo.Month = ThisCalendar.get(Calendar.MONTH)+1;
            		b.DayInfo.Day = Integer.parseInt(b.getText());
        		}
        		
        		AddEventFrame addeventframe = new AddEventFrame(b);
        		addeventframe.setVisible(true);
        	});
        	
        	String filePath = "src/Data/Database/"+2024+"_"+(m+1)+"_"+i+".txt";
        	File file = new File(filePath);
        	if(file.exists()) {
        		System.out.println("파일존재"+i);
        		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        			String dataline="";
        			String line;
                    while ((line = reader.readLine()) != null) {
                        dataline+=line + "\n";
                    }
                    dayButton.DayInfo = new UserInfo();
            		dayButton.DayInfo.Year = ThisCalendar.get(Calendar.YEAR);
            		dayButton.DayInfo.Month = ThisCalendar.get(Calendar.MONTH)+1;
            		dayButton.DayInfo.Day = i;
            		dayButton.DayInfo.StringData = dataline;
            		AddEventFrame addeventframe = new AddEventFrame(dayButton);
            		
                } catch (IOException e) {
                    e.printStackTrace();
                }
        		
        	}
        	/*=============== 날짜 색 바꾸기*/
        	if((i+getFirstDay-2)%7==0)
        		dayButton.setForeground(Color.red);
        	else if((i+getFirstDay-2)%7==6)
        		dayButton.setForeground(Color.blue);
        	/*================*/
        	DayPanel.add(dayButton);
        }
       
        CalendarPanel.add(DayPanel, String.valueOf(m));
       
    	
    }
}
    
    
}
