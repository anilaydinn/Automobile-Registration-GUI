import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class UpdatePage extends JFrame {

	private JPanel contentPane;
	private JTextField tfBrand;
	private JTextField tfModel;
	private JLabel lblModel;
	private JTextField tfColor;
	private JLabel lblBrand_2;
	private JTextField tfFuelType;
	private JLabel lblFuelType;
	private JTextField tfDoors;
	private JLabel lblDoors;
	private JLabel lblPlate;
	private JTextField tfPlate;
	private String plate;
	/**
	 * Create the frame.
	 */
	public UpdatePage(String plate) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		this.plate = plate;
		
		JLabel lblUpdate = new JLabel("Update Automobile");
		lblUpdate.setFont(new Font("Dialog", Font.BOLD, 18));
		lblUpdate.setBounds(52, 12, 202, 27);
		contentPane.add(lblUpdate);
		
		tfBrand = new JTextField();
		tfBrand.setBounds(119, 51, 135, 19);
		contentPane.add(tfBrand);
		tfBrand.setColumns(10);
		
		JLabel lblBrand = new JLabel("Brand:");
		lblBrand.setBounds(31, 53, 70, 15);
		contentPane.add(lblBrand);
		
		tfModel = new JTextField();
		tfModel.setColumns(10);
		tfModel.setBounds(119, 82, 135, 19);
		contentPane.add(tfModel);
		
		lblModel = new JLabel("Model:");
		lblModel.setBounds(31, 84, 70, 15);
		contentPane.add(lblModel);
		
		tfColor = new JTextField();
		tfColor.setColumns(10);
		tfColor.setBounds(119, 113, 135, 19);
		contentPane.add(tfColor);
		
		lblBrand_2 = new JLabel("Color:");
		lblBrand_2.setBounds(31, 115, 70, 15);
		contentPane.add(lblBrand_2);
		
		tfFuelType = new JTextField();
		tfFuelType.setColumns(10);
		tfFuelType.setBounds(119, 144, 135, 19);
		contentPane.add(tfFuelType);
		
		lblFuelType = new JLabel("Fuel Type");
		lblFuelType.setBounds(31, 146, 70, 15);
		contentPane.add(lblFuelType);
		
		tfDoors = new JTextField();
		tfDoors.setColumns(10);
		tfDoors.setBounds(119, 175, 135, 19);
		contentPane.add(tfDoors);
		
		lblDoors = new JLabel("Doors:");
		lblDoors.setBounds(31, 177, 70, 15);
		contentPane.add(lblDoors);
		
		lblPlate = new JLabel("Plate:");
		lblPlate.setBounds(31, 208, 70, 15);
		contentPane.add(lblPlate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPage mainPage = new MainPage();
				setVisible(false);
				mainPage.setVisible(true);
			}
		});
		
		tfPlate = new JTextField();
		tfPlate.setColumns(10);
		tfPlate.setBounds(119, 206, 135, 19);
		contentPane.add(tfPlate);
		btnBack.setBounds(31, 248, 86, 25);
		contentPane.add(btnBack);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<String> automobilesList = new ArrayList<String>();
				
				String updatedBrand = tfBrand.getText();
				String updateModel = tfModel.getText();
				String updateColor = tfColor.getText();
				String updateFuelType = tfFuelType.getText();
				int updateDoors;
				
				try {
					updateDoors = Integer.parseInt(tfDoors.getText());
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "You should write number of doors !");
					updateDoors = 0;
				}
				
				String  updatePlate = tfPlate.getText();
				
				Car car = new Car(updatedBrand, updateModel, updateColor, updateFuelType, updateDoors, updatePlate);
				
				if(car.getBrand().equals("")) {
					JOptionPane.showMessageDialog(null, "You should write brand!");
					return;
				}
				else if(car.getModel().equals("")) {
					JOptionPane.showMessageDialog(null, "You should write model!");
					return;
				}
				else if(car.getColor().equals("")) {
					JOptionPane.showMessageDialog(null, "You should write color!");
					return;
				}
				else if(car.getFuelType().equals("")) {
					JOptionPane.showMessageDialog(null, "You should write fuel type!");
					return;
				}
				else if(car.getDoors() == 0) {
					JOptionPane.showMessageDialog(null, "You should write number of doors!");
					return;
				}
				else if(car.getDoors() > 4 || car.getDoors() == 3) {
					JOptionPane.showMessageDialog(null, "Impossible, generally cars have 2 or 4 doors!");
					return;
				}
				else if(tfDoors.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "You should write number of doors!");
					return;
				}
				else if(car.getPlate().equals("")) {
					JOptionPane.showMessageDialog(null, "You should write plate!");
					return;
				}
				
				try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("automobiles.txt")))){
					
					if(plateIsExist(plate)) {
						while(scanner.hasNextLine()) {
							
							String automobiles_info = scanner.nextLine();
							
							if(automobiles_info.contains(plate)) {
								continue;
							}
							
							automobilesList.add(automobiles_info);
						}
						scanner.close();
						
						try {
							File tempFile = new File("temp.txt");
							FileWriter tempFileWriter = new FileWriter(tempFile);
							
							for(String automobile : automobilesList) {
								
								tempFileWriter.write(automobile + "\n");
							}
							tempFileWriter.write(car.toString() + "\n");
							tempFileWriter.close();
						}
						catch (IOException e) {
							e.printStackTrace();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "This car not here !");
					}
				}
				catch (IOException e) {
					JOptionPane.showMessageDialog(null, "First, you should add car !");
				}
			}
		});
		btnUpdate.setBounds(168, 248, 86, 25);
		contentPane.add(btnUpdate);
	}
	
	public boolean plateIsExist(String plate) {
		if(!plate.equals("")) {
			
			try {
				File automobileFile = new File("automobiles.txt");
				Scanner automobileScanner = new Scanner(new BufferedReader(new FileReader(automobileFile)));
				
				while(automobileScanner.hasNextLine()) {
					
					if(automobileScanner.nextLine().contains(plate)) {
						automobileScanner.close();
						return true;
					}
				}
				automobileScanner.close();
				return false;
			}
			catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Automobile file not found !");
				return false;
			}
		}
		else {
			return false;
		}
	}
}
