
public class Car {

	private String brand;
	private String model;
	private String color;
	private String fuelType;
	private int doors;
	private String plate;
	
	public Car(String brand,String model, String color, String fuelType, int doors, String plate) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.fuelType = fuelType;
		this.doors = doors;
		this.plate = plate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public String toString() {
		
		return this.brand + " " + this.model + " " + this.color + " " + this.fuelType + " "+ this.doors + " " + this.plate; 
	}
}
