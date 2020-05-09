import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private JTextField tfBrand;
	private JTextField tfModel;
	private JTextField tfColor;
	private JTextField tfFuelType;
	private JTextField tfDoors;
	private JTextField tfPlate;
	private JTextField tfUpdateBrand;
	private JTextField tfUpdateModel;
	private JTextField tfUpdateColor;
	private JTextField tfUpdateFuelType;
	private JTextField tfUpdateDoors;
	private JTextField tfUpdatePlate;

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel addPanel = new JPanel();
		addPanel.setVisible(false);
		addPanel.setBounds(270, 41, 479, 268);
		contentPane.add(addPanel);
		addPanel.setLayout(null);
		
		JPanel updatePanel = new JPanel();
		updatePanel.setVisible(false);
		updatePanel.setLayout(null);
		updatePanel.setBounds(270, 41, 479, 268);
		contentPane.add(updatePanel);
		
		JButton btnAddCar = new JButton("Add Car");
		btnAddCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPanel.setVisible(true);
			}
		});
		btnAddCar.setBounds(54, 50, 117, 25);
		contentPane.add(btnAddCar);
		
		JButton btnUpdateCar = new JButton("Update Car");
		btnUpdateCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updatePanel.setVisible(true);
			}
		});
		btnUpdateCar.setBounds(54, 126, 117, 25);
		contentPane.add(btnUpdateCar);
		
		JButton btnDeleteCar = new JButton("Delete Car");
		btnDeleteCar.setBounds(54, 202, 117, 25);
		contentPane.add(btnDeleteCar);
		
		JButton btnListCar = new JButton("List Car");
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
		btnAdd.setBounds(115, 231, 139, 25);
		addPanel.add(btnAdd);
		
		JButton btnCloseAdd = new JButton("Close");
		btnCloseAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPanel.setVisible(false);
			}
		});
		btnCloseAdd.setBounds(266, 231, 139, 25);
		addPanel.add(btnCloseAdd);
		
		JLabel lblAddCar = new JLabel("Add Car");
		lblAddCar.setBounds(207, 12, 70, 15);
		addPanel.add(lblAddCar);
		
		JLabel lblUpdateCar = new JLabel("Update Car");
		lblUpdateCar.setBounds(207,12,90,15);
		updatePanel.add(lblUpdateCar);
		
		
		
		tfUpdateBrand = new JTextField();
		tfUpdateBrand.setColumns(10);
		tfUpdateBrand.setBounds(116, 49, 289, 19);
		updatePanel.add(tfUpdateBrand);
		
		JLabel lblUpdateBrand = new JLabel("Brand:");
		lblUpdateBrand.setBounds(12, 51, 86, 15);
		updatePanel.add(lblUpdateBrand);
		
		JLabel lblUpdateModel = new JLabel("Model:");
		lblUpdateModel.setBounds(12, 80, 86, 15);
		updatePanel.add(lblUpdateModel);
		
		tfUpdateModel = new JTextField();
		tfUpdateModel.setColumns(10);
		tfUpdateModel.setBounds(116, 78, 289, 19);
		updatePanel.add(tfUpdateModel);
		
		tfUpdateColor = new JTextField();
		tfUpdateColor.setColumns(10);
		tfUpdateColor.setBounds(116, 107, 289, 19);
		updatePanel.add(tfUpdateColor);
		
		JLabel lblUpdateColor = new JLabel("Color:");
		lblUpdateColor.setBounds(12, 109, 86, 15);
		updatePanel.add(lblUpdateColor);
		
		tfUpdateFuelType = new JTextField();
		tfUpdateFuelType.setColumns(10);
		tfUpdateFuelType.setBounds(116, 138, 289, 19);
		updatePanel.add(tfUpdateFuelType);
		
		JLabel lblUpdateFuelType = new JLabel("Fuel Type:");
		lblUpdateFuelType.setBounds(12, 140, 86, 15);
		updatePanel.add(lblUpdateFuelType);
		
		JLabel lblUpdateDoors = new JLabel("Doors:");
		lblUpdateDoors.setBounds(12, 171, 86, 15);
		updatePanel.add(lblUpdateDoors);
		
		tfUpdateDoors = new JTextField();
		tfUpdateDoors.setColumns(10);
		tfUpdateDoors.setBounds(116, 169, 289, 19);
		updatePanel.add(tfUpdateDoors);
		
		JLabel lblUpdatePlate = new JLabel("Plate:");
		lblUpdatePlate.setBounds(12, 200, 86, 15);
		updatePanel.add(lblUpdatePlate);
		
		tfUpdatePlate = new JTextField();
		tfUpdatePlate.setColumns(10);
		tfUpdatePlate.setBounds(116, 198, 289, 19);
		updatePanel.add(tfUpdatePlate);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(115, 231, 139, 25);
		updatePanel.add(btnUpdate);
		
		JButton btnCloseUpdate = new JButton("Close");
		btnCloseUpdate.setBounds(266, 231, 139, 25);
		btnCloseUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updatePanel.setVisible(false);
			}
		});
		updatePanel.add(btnCloseUpdate);
		
		setLocationRelativeTo(null);
	}
}
