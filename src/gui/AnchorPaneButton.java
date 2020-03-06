package gui;

import java.time.LocalDate;
import java.time.MonthDay;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class AnchorPaneButton extends AnchorPane {

	private LocalDate date;
	
	public AnchorPaneButton(Node... children) {
		super(children);
		
		this.setOnMouseClicked(event -> System.out.println("This pane's date is: " + date));
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate calendarDate) {
		this.date = calendarDate;
	}
}
