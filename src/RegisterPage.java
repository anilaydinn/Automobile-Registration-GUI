import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class RegisterPage extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JButton btnBack;
	private JButton btnRegister;
	private JPasswordField pfPasswordField;
	private JPasswordField pfConfirmPasswordField;

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
		tfUsername.setBounds(179, 75, 195, 19);
		contentPane.add(tfUsername);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(23, 77, 94, 15);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(23, 108, 94, 15);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(23, 139, 134, 15);
		contentPane.add(lblConfirmPassword);
		
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
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FileManager fileManager = new FileManager("users.txt");
				
				String username = tfUsername.getText();
				String password = new String(pfPasswordField.getPassword());
				String confirmPassword = new String(pfConfirmPasswordField.getPassword());
				
				if((!username.equals("") && !password.equals("") && !confirmPassword.equals("")) && (password.equals(confirmPassword))) {
					User user = new User(username, password);
					fileManager.addUserToFile(user);
				}
				else if(username.equals("") || password.equals("") || confirmPassword.equals("")) {
					
					JOptionPane.showMessageDialog(null, "You should fill all fields !");
				}
				else if(!username.equals("") && !password.equals(confirmPassword)) {
					
					JOptionPane.showMessageDialog(null, "Password fields are should be same !");
				}
				else if(!username.equals("") && (password.equals("") || confirmPassword.equals(""))) {
					
					JOptionPane.showMessageDialog(null, "You should fill all pasword fields !");
				}
			}
		});
		btnRegister.setBounds(174, 173, 101, 25);
		contentPane.add(btnRegister);
		
		pfPasswordField = new JPasswordField();
		pfPasswordField.setBounds(179, 106, 195, 19);
		contentPane.add(pfPasswordField);
		
		pfConfirmPasswordField = new JPasswordField();
		pfConfirmPasswordField.setBounds(179, 137, 195, 19);
		contentPane.add(pfConfirmPasswordField);
		
	}
}
