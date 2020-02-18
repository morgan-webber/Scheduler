package gui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.GregorianCalendar;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class DashboardController {
	
	@FXML GridPane calendarGrid;
	ArrayList<Button> days = new ArrayList<>();
	GregorianCalendar cal = new GregorianCalendar(2020, 1, 1);
	
	
	
	
	
	
	enum calendarViewRange {MONTH, WEEK};
	
	@FXML public void initialize() {
		
	}
	
	public void updateCalendarView(calendarViewRange view) {
		
	}
}
