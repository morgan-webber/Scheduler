package gui;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import app.Logging;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tools.DatabaseBroker;

public class LoginController {
	@FXML TextField txtUsername;
	@FXML PasswordField txtPassword;
	@FXML Button btnLogin;
	@FXML Label lblStatus;
	
	@FXML public void btnLoginClick() {
		
		boolean connected;
		
		try{
			connected = DatabaseBroker.connectToDatabase();
		}
		catch (SQLException sqle) {
			if (sqle.getErrorCode() == 1045) { // 1045 = Bad User/Pass Combo
				
			}
			connected = false;
		}
		
		if (connected) {
			
			// Hop to Dashboard
			try {
	    		FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
	    		Parent root = loader.load();
	    		Stage stage = new Stage();
	    	    stage.setTitle("Dashboard");
	    		stage.setScene(new Scene(root));
	    		stage.show();
	    		
	    		((Stage) txtUsername.getScene().getWindow()).close();
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
			
			// Log our login time
			Logging.logLoginTime(DatabaseBroker.getUser(), java.time.LocalDateTime.now());
			
		}
		else {
			lblStatus.setStyle("-fx-text-fill: #990000");
			lblStatus.setText("Not connected");
		}
		
	}
	
	private void setStatus(String text, boolean isGood) {
		
		if (isGood) {
			lblStatus.setStyle("fx-text-fill: #009900");
		}
		else {
			lblStatus.setStyle("fx-text-fill: #990000");
		}
		
		lblStatus.setText(text);
	}
}
