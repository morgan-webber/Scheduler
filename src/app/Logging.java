package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logging {

	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
	
	public static boolean logLoginTime(String user, LocalDateTime loginTime) {
		
		File logFile = new File("logins.txt");
		
		try {
			FileWriter fw = new FileWriter(logFile, true);
			fw.write("New login by " + user + " @ " + dtf.format(loginTime) + "\n");
			fw.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
}
