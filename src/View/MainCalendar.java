package View;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

import Data.UserInfo;

public class MainCalendar extends JFrame {
	private JPanel CalendarPanel;
	private JComboBox<String> MonthComboBox;
    private CardLayout cardLayout;
    private JPanel ControlPanel;
    //생성자 부분
    public MainCalendar(){
    	setTitle("My Java 스케줄러");
    	setSize(400,300);
    	cardLayout = new CardLayout();
    	CalendarPanel = new JPanel(cardLayout);
    	
    	//달 선택하는 콤보 박스
    	String[] Month_Arr = new DateFormatSymbols().getMonths();
        MonthComboBox = new JComboBox(Month_Arr);
        MonthComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ChangeCalendar();
            }
        });
        
        //ContralPanel 가장 윗 부분
        JButton PreviousButton=new JButton("previous");
        PreviousButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
        
        }	
        });
        JButton NextButton=new JButton("next");
        NextButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
        
        }
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
    	int SelectedMonth = MonthComboBox.getSelectedIndex();
    	Calendar ThisCalendar = Calendar.getInstance();
    	ThisCalendar.set(Calendar.YEAR,2024);
    	ThisCalendar.set(Calendar.MONTH,SelectedMonth);
    	/*===============================================*/
    	DayPanel = new JPanel(new GridLayout(0,7));
    	DayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    	String[] DaysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    	for (String day : DaysOfWeek) {
            JLabel dayLabel = new JLabel(day, JLabel.CENTER);
            DayPanel.add(dayLabel);
        }
    	/*===============================================*/
    	
    	ThisCalendar.set(Calendar.DAY_OF_MONTH, 1);
        int getFirstDay = ThisCalendar.get(Calendar.DAY_OF_WEEK);

        for(int i = 0; i < getFirstDay - 1; i++) {
        	JLabel tmp = new JLabel();
        	DayPanel.add(tmp);
        }
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
        	});
        	DayPanel.add(dayButton);
        }
        String monthString = new SimpleDateFormat("MMMM yyyy").format(ThisCalendar.getTime());
        CalendarPanel.add(DayPanel, monthString);
        cardLayout.show(CalendarPanel, monthString);
    	
    }
}
    
    
}
