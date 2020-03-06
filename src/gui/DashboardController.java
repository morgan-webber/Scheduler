package gui;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.GregorianCalendar;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class DashboardController {
	
	@FXML GridPane calendar;
	ArrayList<AnchorPaneButton> days = new ArrayList<>();
	GregorianCalendar cal = new GregorianCalendar(2020, 1, 1);
	
	
	Text calendarTitle;
	YearMonth currentYearMonth;
	
	enum CalendarViewRange {MONTH, WEEK};
	CalendarViewRange currentView = CalendarViewRange.MONTH;
	
	@FXML public void initialize() {
		
		// Update our calendar view
		updateCalendarView(currentView);
		
	}
	
	public void updateCalendarView(CalendarViewRange view) {
		
		if (view == CalendarViewRange.MONTH) {
			
			// Create the buttons for the days of the week
			calendar = new GridPane();
			calendar.setPrefSize(600, 400);
			calendar.setGridLinesVisible(true);
			
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 7; j++) {
					AnchorPaneButton node = new AnchorPaneButton();
					days.add(node);
					calendar.add(node, j, i);
				}
			}
			
			// Create labels for the days of the week
			Text[] daysOfWeek = new Text[] { new Text("Sunday"), new Text("Monday"), new Text("Tuesday"), 
					new Text("Wednesday"), new Text("Thursday"), new Text("Friday"), new Text("Saturday") };
			GridPane labels = new GridPane();
			labels.setPrefWidth(600);
			int col = 0;
			for (Text txt : daysOfWeek) {
				AnchorPane pn = new AnchorPane();
				pn.setPrefSize(200,  10);
				pn.setBottomAnchor(txt,  5.0);
				pn.getChildren().add(txt);
				labels.add(pn, col++, 0);
			}
			
			// Create the title and buttons to change the month
		    calendarTitle = new Text();
			Button btnPreviousMonth = new Button("<<");
			btnPreviousMonth.setOnAction(e -> previousMonth());
			Button btnNextMonth = new Button(">>");
			btnNextMonth.setOnAction(e -> nextMonth());
			HBox titleBar = new HBox(btnPreviousMonth, calendarTitle, btnNextMonth);
			titleBar.setAlignment(Pos.BASELINE_CENTER);
			populateCalendar(yearMonth);
			view = new VBox(titleBar, labels, calendar);
			
			
		}
		else if (view == CalendarViewRange.WEEK){
			
		}
		

		
	}
	
    private void nextMonth() {
        currentYearMonth = currentYearMonth.plusMonths(1);
        populateCalendar(currentYearMonth);
    }
	
	/**
     * Set the days of the calendar to correspond to the appropriate date
     * @param yearMonth year and month of month to render
     */
    public void populateCalendar(YearMonth yearMonth) {
        // Get the date we want to start with on the calendar
        LocalDate calendarDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);
        // Dial back the day until it is SUNDAY (unless the month starts on a sunday)
        while (!calendarDate.getDayOfWeek().toString().equals("SUNDAY") ) {
            calendarDate = calendarDate.minusDays(1);
        }
        // Populate the calendar with day numbers
        for (AnchorPaneButton ap : days) {
            if (ap.getChildren().size() != 0) {
                ap.getChildren().remove(0);
            }
            Text txt = new Text(String.valueOf(calendarDate.getDayOfMonth()));
            ap.setDate(calendarDate);
            ap.setTopAnchor(txt, 5.0);
            ap.setLeftAnchor(txt, 5.0);
            ap.getChildren().add(txt);
            calendarDate = calendarDate.plusDays(1);
        }
        // Change the title of the calendar
        calendarTitle.setText(yearMonth.getMonth().toString() + " " + String.valueOf(yearMonth.getYear()));
    }
	
	private void previousMonth() {
        currentYearMonth = currentYearMonth.minusMonths(1);
        populateCalendar(currentYearMonth);
    }
}
