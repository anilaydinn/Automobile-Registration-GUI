import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

	private FileWriter writer;
	private File file;
	private ArrayList<Car> cars;
	
	public FileManager() {
		
		this.file = new File("automobiles.txt");
		
		try {
			this.writer = new FileWriter(this.file, true);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void setWriter(FileWriter writer) {
		
		this.writer = writer;
	}
	
	public FileWriter getWriter() {
		
		return this.writer;
	}
	
	public void addCarstoArrayList(Car car) {
		
		this.cars.add(car);
	}
	
	public void setCars(ArrayList<Car> cars) {
		
		this.cars = cars;
	}
	
	public ArrayList<Car> getCars(){
		
		return this.cars;
	}
	
	public void setFile(File file) {
		
		this.file = file;
	}
	
	public File getFile() {
		
		return this.file;
	}
	
	public void addCarToFile(Car car) {
		
		try {
			this.writer.write(car.toString() + "\n");
			this.writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
