import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class ShowPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ShowPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JList carJlist = new JList();
		carJlist.setBounds(12, 40, 592, 347);
		contentPane.add(carJlist);
		
		try {
			File tempFile = new File("temp.txt");
			Scanner tempScanner = new Scanner(new BufferedReader(new FileReader(tempFile)));
			ArrayList<String> showList = new ArrayList<String>();
			DefaultListModel<String> DLM = new DefaultListModel<String>();
			
			while(tempScanner.hasNextLine()) {
				
				showList.add(tempScanner.nextLine());
			}
			tempScanner.close();
			
			for(String automobile : showList) {
				DLM.addElement(automobile);
			}
			
			carJlist.setModel(DLM);
			
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "File not found!");
		}
		
		JLabel lblShowPage = new JLabel("Show Page");
		lblShowPage.setFont(new Font("Dialog", Font.BOLD, 18));
		lblShowPage.setBounds(262, 12, 131, 29);
		contentPane.add(lblShowPage);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPage mainPage = new MainPage();
				setVisible(false);
				mainPage.setVisible(true);
			}
		});
		btnBack.setBounds(12, 399, 117, 40);
		contentPane.add(btnBack);
	}
}
