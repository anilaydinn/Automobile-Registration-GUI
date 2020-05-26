import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class DeletePage extends JFrame {

	private JPanel contentPane;
	
	public DeletePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 166);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JButton btnDeleteAll = new JButton("Delete All");
		btnDeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(lineExist()) {
					try {
						File tempFile = new File("temp.txt");
						FileWriter tempFileWriter = new FileWriter(tempFile);
						
						tempFileWriter.close();
						JOptionPane.showMessageDialog(null, "All automobiles successfully deleted.");
					}
					catch (IOException e) {
						JOptionPane.showMessageDialog(null, "First, you should add car !");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "There are no cars registered in the file.");
				}
			}
		});
		btnDeleteAll.setBounds(12, 49, 166, 25);
		contentPane.add(btnDeleteAll);
		
		JButton btnDeleteByPlate = new JButton("Delete by Plate");
		btnDeleteByPlate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<String> automobilesList = new ArrayList<String>();
				
				String plate = JOptionPane.showInputDialog("Please enter plate which car want to delete.");
				
				if(plateIsExist(plate)) {
					try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("temp.txt")))){
						
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
							tempFileWriter.close();
							JOptionPane.showMessageDialog(null, plate + " plate car successfully deleted.");
						}
						catch (IOException e) {
							e.printStackTrace();
						}
					}
					catch (IOException e) {
						JOptionPane.showMessageDialog(null, "First, you should add car !");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "This car not found!");
				}
				
			}
		});
		btnDeleteByPlate.setBounds(186, 49, 166, 25);
		contentPane.add(btnDeleteByPlate);
		
		JLabel lblDeletePage = new JLabel("Delete Page");
		lblDeletePage.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDeletePage.setBounds(119, 12, 132, 25);
		contentPane.add(lblDeletePage);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPage mainPage = new MainPage();
				setVisible(false);
				mainPage.setVisible(true);
			}
		});
		btnBack.setBounds(12, 99, 87, 25);
		contentPane.add(btnBack);
	}
	
	public boolean plateIsExist(String plate) {
		if(!plate.equals("")) {
			
			try {
				File tempFile = new File("temp.txt");
				Scanner tempScanner = new Scanner(new BufferedReader(new FileReader(tempFile)));
				
				while(tempScanner.hasNextLine()) {
					
					if(tempScanner.nextLine().contains(plate)) {
						tempScanner.close();
						return true;
					}
				}
				tempScanner.close();
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
	
	public boolean lineExist() {
		
		try {
			File tempFile = new File("temp.txt");
			Scanner tempScanner = new Scanner(new BufferedReader(new FileReader(tempFile)));
			
			if(tempScanner.hasNext()) {
				tempScanner.close();
				return true;
			}
			else {
				tempScanner.close();
				return false;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
