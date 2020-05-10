import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListCarPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ListCarPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JList carJlist = new JList();
		carJlist.setBounds(12, 53, 643, 362);
		contentPane.add(carJlist);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPage mainPage = new MainPage();
				setVisible(false);
				mainPage.setVisible(true);
			}
		});
		btnBack.setBounds(12, 427, 117, 25);
		contentPane.add(btnBack);
		
		JButton btnList = new JButton("List");
		btnList.setBounds(538, 427, 117, 25);
		contentPane.add(btnList);
		
		JLabel lblListCar = new JLabel("List Car");
		lblListCar.setFont(new Font("Dialog", Font.BOLD, 18));
		lblListCar.setBounds(293, 26, 88, 15);
		contentPane.add(lblListCar);
	}
}
