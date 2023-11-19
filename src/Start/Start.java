package Start;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import View.MainCalendar;

public class Start {

	public static void main(String[] args) {
		 SwingUtilities.invokeLater(() -> {
	            try {
	                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            new MainCalendar();
	        });

	}

}
