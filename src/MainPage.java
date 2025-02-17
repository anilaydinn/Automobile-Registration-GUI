import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private JTextField tfBrand;
	private JTextField tfModel;
	private JTextField tfColor;
	private JTextField tfFuelType;
	private JTextField tfDoors;
	private JTextField tfPlate;

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel addPanel = new JPanel();
		addPanel.setVisible(false);
		addPanel.setBounds(270, 41, 479, 268);
		contentPane.add(addPanel);
		addPanel.setLayout(null);
		
		JLabel lblCarImage = new JLabel("");
		lblCarImage.setBounds(204, 41, 522, 325);
		contentPane.add(lblCarImage);
		
		ImageIcon carImage = new ImageIcon("./images/car.png");
		lblCarImage.setIcon(carImage);
		
		JButton btnAddCar = new JButton("Add Car");
		btnAddCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPanel.setVisible(true);
				lblCarImage.setVisible(false);
			}
		});
		btnAddCar.setBounds(54, 50, 117, 25);
		contentPane.add(btnAddCar);
		
		JButton btnUpdateCar = new JButton("Update Car");
		btnUpdateCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String plate = JOptionPane.showInputDialog("Please enter plate for update.");
				UpdatePage updatePage = new UpdatePage(plate);
				
				if(updatePage.plateIsExist(plate)) {
					setVisible(false);
					updatePage.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "This car not found!");
				}
			}
		});
		btnUpdateCar.setBounds(54, 126, 117, 25);
		contentPane.add(btnUpdateCar);
		
		JButton btnDeleteCar = new JButton("Delete Car");
		btnDeleteCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeletePage deletePage = new DeletePage();
				setVisible(false);
				deletePage.setVisible(true);
			}
		});
		btnDeleteCar.setBounds(54, 202, 117, 25);
		contentPane.add(btnDeleteCar);
		
		JButton btnListCar = new JButton("List Car");
		btnListCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowPage showPage = new ShowPage();
				setVisible(false);
				showPage.setVisible(true);
			}
		});
		btnListCar.setBounds(54, 284, 117, 25);
		contentPane.add(btnListCar);
		
		JLabel lblAutomobileRegistrationSystem = new JLabel("Automobile Registration System");
		lblAutomobileRegistrationSystem.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAutomobileRegistrationSystem.setBounds(204, 12, 387, 30);
		contentPane.add(lblAutomobileRegistrationSystem);
		
		tfBrand = new JTextField();
		tfBrand.setBounds(116, 49, 289, 19);
		addPanel.add(tfBrand);
		tfBrand.setColumns(10);
		
		JLabel lblBrand = new JLabel("Brand:");
		lblBrand.setBounds(12, 51, 86, 15);
		addPanel.add(lblBrand);
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setBounds(12, 80, 86, 15);
		addPanel.add(lblModel);
		
		tfModel = new JTextField();
		tfModel.setColumns(10);
		tfModel.setBounds(116, 78, 289, 19);
		addPanel.add(tfModel);
		
		tfColor = new JTextField();
		tfColor.setColumns(10);
		tfColor.setBounds(116, 107, 289, 19);
		addPanel.add(tfColor);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(12, 109, 86, 15);
		addPanel.add(lblColor);
		
		tfFuelType = new JTextField();
		tfFuelType.setColumns(10);
		tfFuelType.setBounds(116, 138, 289, 19);
		addPanel.add(tfFuelType);
		
		JLabel lblFuelType = new JLabel("Fuel Type:");
		lblFuelType.setBounds(12, 140, 86, 15);
		addPanel.add(lblFuelType);
		
		JLabel lblDoors = new JLabel("Doors:");
		lblDoors.setBounds(12, 171, 86, 15);
		addPanel.add(lblDoors);
		
		tfDoors = new JTextField();
		tfDoors.setColumns(10);
		tfDoors.setBounds(116, 169, 289, 19);
		addPanel.add(tfDoors);
		
		JLabel lblPlate = new JLabel("Plate:");
		lblPlate.setBounds(12, 200, 86, 15);
		addPanel.add(lblPlate);
		
		tfPlate = new JTextField();
		tfPlate.setColumns(10);
		tfPlate.setBounds(116, 198, 289, 19);
		addPanel.add(tfPlate);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FileManager fileManager = new FileManager("automobiles.txt");
				String brand = tfBrand.getText();
				String model = tfModel.getText();
				String color = tfColor.getText();
				String fuelType = tfFuelType.getText();
				int doors;
				try {
					doors = Integer.parseInt(tfDoors.getText());
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "You should write number of doors !");
					doors = 0;
				}
				
				
				String plate = tfPlate.getText();
				Car car = new Car(brand, model, color, fuelType, doors, plate);
				
				if(car.getBrand().equals("")) {
					JOptionPane.showMessageDialog(null, "You should write brand !");
					return;
				}
				else if(car.getModel().equals("")) {
					JOptionPane.showMessageDialog(null, "You should write model !");
					return;
				}
				else if(car.getColor().equals("")) {
					JOptionPane.showMessageDialog(null, "You should write color !");
					return;
				}
				else if(car.getFuelType().equals("")) {
					JOptionPane.showMessageDialog(null, "You should write fuel type !");
					return;
				}
				else if(car.getDoors() == 0) {
					JOptionPane.showMessageDialog(null, "You should write number of doors !");
					return;
				}
				else if(car.getDoors() > 4 || car.getDoors() == 3) {
					JOptionPane.showMessageDialog(null, "Impossible, generally cars have 2 or 4 doors!");
					return;
				}
				else if(tfDoors.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "You should write number of doors !");
					return;
				}
				else if(car.getPlate().equals("")) {
					JOptionPane.showMessageDialog(null, "You should write plate !");
					return;
				}
				
				fileManager.addCarToFile(car);
				tfBrand.setText("");
				tfModel.setText("");
				tfColor.setText("");
				tfFuelType.setText("");
				tfDoors.setText("");
				tfPlate.setText("");
				
				try {
					File automobilesFile = new File("automobiles.txt");
					Scanner automobilesScanner = new Scanner(new BufferedReader(new FileReader(automobilesFile)));
					ArrayList<String> automobileLines = new ArrayList<String>();
					
					while(automobilesScanner.hasNextLine()) {
						
						automobileLines.add(automobilesScanner.nextLine());
					}
					automobilesScanner.close();
					
					try {
						File tempFile = new File("temp.txt");
						FileWriter tempFileWriter = new FileWriter(tempFile);
						
						for(String automobile : automobileLines) {
							
							tempFileWriter.write(automobile + "\n");
						}
						tempFileWriter.close();
						JOptionPane.showMessageDialog(null, "Automobile succesfully registered.");
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(115, 231, 139, 25);
		addPanel.add(btnAdd);
		
		JButton btnCloseAdd = new JButton("Close");
		btnCloseAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPanel.setVisible(false);
				lblCarImage.setVisible(true);
			}
		});
		btnCloseAdd.setBounds(266, 231, 139, 25);
		addPanel.add(btnCloseAdd);
		
		JLabel lblAddCar = new JLabel("Add Car");
		lblAddCar.setBounds(207, 12, 70, 15);
		addPanel.add(lblAddCar);	
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginPage loginPage = new LoginPage();
				setVisible(false);
				loginPage.setVisible(true);
			}
		});
		btnExit.setBounds(671, 12, 78, 25);
		contentPane.add(btnExit);
		
		setLocationRelativeTo(null);
		
	}
}
