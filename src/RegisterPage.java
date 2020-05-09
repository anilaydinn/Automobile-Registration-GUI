import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class RegisterPage extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JTextField tfConfirmPassword;
	private JButton btnBack;
	private JButton btnRegister;

	/**
	 * Create the frame.
	 */
	public RegisterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRegister.setBounds(161, 23, 100, 22);
		contentPane.add(lblRegister);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(169, 75, 205, 19);
		contentPane.add(tfUsername);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(23, 77, 94, 15);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(23, 108, 94, 15);
		contentPane.add(lblPassword);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(169, 106, 205, 19);
		contentPane.add(tfPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(23, 139, 134, 15);
		contentPane.add(lblConfirmPassword);
		
		tfConfirmPassword = new JTextField();
		tfConfirmPassword.setColumns(10);
		tfConfirmPassword.setBounds(169, 137, 205, 19);
		contentPane.add(tfConfirmPassword);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(287, 173, 87, 25);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				LoginPage loginPage = new LoginPage();
				setVisible(false);
				loginPage.setVisible(true);
			}
		});
		contentPane.add(btnBack);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(174, 173, 101, 25);
		contentPane.add(btnRegister);
		
	}
}
