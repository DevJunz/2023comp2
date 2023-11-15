package Model;
import java.time.LocalDate;
import View.CalendarFrame;

public class CalendarMaker {
	public CalendarMaker() {
		CalendarFrame CFrame = new CalendarFrame(LocalDate.now());
	}
}
