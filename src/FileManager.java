import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileManager {

	private FileWriter automobilesFileWriter;
	private FileWriter userFileWriter;
	private BufferedReader userFileBufferedReader;
	private FileReader userFileFileReader;
	private Scanner userFileScanner;
	private File automobilesFile;
	private File usersFile;
	
	public FileManager(String filename) {
		
		if(filename.equals("automobiles.txt")) {
			
			this.automobilesFile = new File(filename);
		}
		else if(filename.equals("users.txt")) {
			
			this.usersFile = new File(filename);
		}
	}
	
	public void setAutomobilesFileWriter(FileWriter automobilesFileWriter) {
		
		this.automobilesFileWriter = automobilesFileWriter;
	}
	
	public FileWriter getAutomobilesFileWriter() {
		
		return this.automobilesFileWriter;
	}
	
	public void setUserFileWriter(FileWriter userFileWriter) {
		
		this.userFileWriter = userFileWriter;
	}
	
	public FileWriter getUserFileWriter() {
		
		return this.userFileWriter;
	}
	
	public void setUsersFile(File usersFile) {
		
		this.usersFile = usersFile;
	}
	
	public File getUsersFile() {
		
		return this.usersFile;
	}
	
	public void setAutomobilesFile(File automobilesFile) {
		
		this.automobilesFile = automobilesFile;
	}
	
	public File getAutomobilesFile() {
		
		return this.automobilesFile;
	}
	
	public void addCarToFile(Car car) {
		
		try {
			
			this.automobilesFileWriter = new FileWriter(automobilesFile,true);
			this.automobilesFileWriter.write(car.toString() + "\n");
			this.automobilesFileWriter.close();
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void addUserToFile(User user) {
		
		try {
			
			this.userFileWriter = new FileWriter(usersFile,true);
			this.userFileWriter.write(user.toString() + "\n");
			this.userFileWriter.close();
		}
		catch(IOException e){
			
			e.printStackTrace();
		}
	}
	
	public boolean readUserFile(String username, String password) {
		
		boolean isLogin = false;
		
		try {
			
			this.userFileFileReader = new FileReader(usersFile);
			this.userFileBufferedReader = new BufferedReader(this.userFileFileReader);
			this.userFileScanner = new Scanner(this.userFileBufferedReader);
			
			while(userFileScanner.hasNextLine()) {
				
				String user_info = userFileScanner.nextLine();
				
				if(user_info.equals(username + " " + password)) {
					
					isLogin = true;
					break;
				}
				else {
					
					isLogin = false;
				}
			}
			return isLogin;
		}
		catch(IOException e) {
			
			JOptionPane.showMessageDialog(null, "Users file is empty! User not found!");
			return false;
		}
	}
	
	public boolean isUsernameExists(String username) {
		
		try {
			
			this.userFileFileReader = new FileReader(usersFile);
			this.userFileBufferedReader = new BufferedReader(this.userFileFileReader);
			this.userFileScanner = new Scanner(this.userFileBufferedReader);
			
			while(userFileScanner.hasNextLine()) {
				
				if(userFileScanner.nextLine().contains(username)) {
					return true;
				}
			}
			return false;
		}
		catch (IOException e) {
			return false;
		}
	}
}
