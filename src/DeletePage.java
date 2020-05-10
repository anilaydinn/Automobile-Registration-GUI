import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeletePage extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public DeletePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 166);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JButton btnDeleteAll = new JButton("Delete All");
		btnDeleteAll.setBounds(12, 49, 166, 25);
		contentPane.add(btnDeleteAll);
		
		JButton btnDeleteByPlate = new JButton("Delete by Plate");
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
}
