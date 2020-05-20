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

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JPasswordField pfPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 231);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login ");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 18));
		lblLogin.setBounds(185, 22, 87, 22);
		contentPane.add(lblLogin);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(134, 71, 205, 19);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(22, 73, 94, 15);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(22, 104, 94, 15);
		contentPane.add(lblPassword);
		
		pfPasswordField = new JPasswordField();
		pfPasswordField.setBounds(134, 102, 205, 19);
		contentPane.add(pfPasswordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(134, 133, 99, 25);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileManager fileManager = new FileManager("users.txt");
				String username = tfUsername.getText();
				String password = new String(pfPasswordField.getPassword());
				
				if(fileManager.readUserFile(username, password)) {
					MainPage mainPage = new MainPage();
					setVisible(false);
					mainPage.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Username or password incorrect !");
				}
				
			}
		});
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(245, 133, 94, 25);
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				RegisterPage registerPage = new RegisterPage();
				setVisible(false);
				registerPage.setVisible(true);
			}
		});
		contentPane.add(btnRegister);
		
	}
}
