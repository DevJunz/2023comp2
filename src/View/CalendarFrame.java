package View;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
public class CalendarFrame extends JFrame {
	JPanel DatePanel;
	JButton RightButton;
	JButton LeftButton;
	JPanel CalendarPanel;
	JPanel addPanel;
	public CalendarFrame(LocalDate today) {
		
		setSize(1000,1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
