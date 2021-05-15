package Project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI implements ActionListener{

	private static JFrame frame;
	private static JPanel panel;
	private static JLabel userLabel;
	private static JTextField userText;
	private static JPasswordField passwordText;
	private static JLabel passwordLabel;
	private static JButton buttonLogin1;
	private static JButton buttonLogin2;
	private static JButton buttonLogin3;
	private static JButton buttonReset;
	private static JButton buttonSignUp;
	private static JLabel success;
	
//	public static HashMap<String, String> customerLoginInfo = new HashMap<String, String>();
//	public static HashMap<String, String> authorityLoginInfo = new HashMap<String, String>();
//	public static HashMap<String, String> administratorLoginInfo = new HashMap<String, String>();
	
	GUI(){
		
	}
//	GUI(HashMap<String, String> loginInfoOriginal){
//		customerLoginInfo = loginInfoOriginal;
//	}
	
	public void guiCreate() {
		
//		cvIdandPassword idandPasswords = new IdandPassword();
		//customerLoginInfo = idandPasswords.getCustomerLoginInfo();
		
//		
//		authorityLoginInfo = idandPasswords.getAuthorityLoginInfo();
//		administratorLoginInfo = idandPasswords.getAdministratorLoginInfo();
		frame = new JFrame();
		panel = new JPanel();
		frame.setSize(550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		userLabel = new JLabel("User");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		passwordLabel= new JLabel("Password");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		buttonLogin1 = new JButton("Login As Customer");
		buttonLogin1.setBounds(10, 300, 300, 25);
		buttonLogin1.addActionListener(new GUI());
		panel.add(buttonLogin1);
		
		buttonLogin2 = new JButton("Login As Parkin Authority");
		buttonLogin2.setBounds(10, 340, 300, 25);
		buttonLogin2.addActionListener(new GUI());
		panel.add(buttonLogin2);
		
		buttonLogin3 = new JButton("Login As System Administrator");
		buttonLogin3.setBounds(10, 380, 300, 25);
		buttonLogin3.addActionListener(new GUI());
		panel.add(buttonLogin3);
		
		buttonReset = new JButton("Reset");
		buttonReset.setBounds(10, 420, 300, 25);
		buttonReset.addActionListener(new GUI());
		panel.add(buttonReset);
		
		buttonSignUp = new JButton("Sign Up");
		buttonSignUp.setBounds(10, 460, 300, 25);
		buttonSignUp.addActionListener(new GUI());
		panel.add(buttonSignUp);
		
		success = new JLabel();
		success.setBounds(10, 200, 300, 25);
		panel.add(success);
		success.setText(null);
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
//		IdandPassword idandPasswords = new IdandPassword();
//		GUI gui = new GUI(idandPasswords.getCustomerLoginInfo());
		GUI gui = new GUI();
		gui.guiCreate();
//		IdandPassword idandPasswords = new IdandPassword();
//		customerLoginInfo = idandPasswords.getCustomerLoginInfo();
//		authorityLoginInfo = idandPasswords.getAuthorityLoginInfo();
//		administratorLoginInfo = idandPasswords.getAdministratorLoginInfo();
//		frame = new JFrame();
//		panel = new JPanel();
//		frame.setSize(550, 550);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(panel);
//		
//		panel.setLayout(null);
//		
//		userLabel = new JLabel("User");
//		userLabel.setBounds(10, 20, 80, 25);
//		panel.add(userLabel);
//		
//		userText = new JTextField(20);
//		userText.setBounds(100, 20, 165, 25);
//		panel.add(userText);
//		
//		passwordLabel= new JLabel("Password");
//		passwordLabel.setBounds(10, 50, 80, 25);
//		panel.add(passwordLabel);
//		
//		passwordText = new JPasswordField();
//		passwordText.setBounds(100, 50, 165, 25);
//		panel.add(passwordText);
//		
//		buttonLogin1 = new JButton("Login As Customer");
//		buttonLogin1.setBounds(10, 300, 300, 25);
//		buttonLogin1.addActionListener(new GUI());
//		panel.add(buttonLogin1);
//		
//		buttonLogin2 = new JButton("Login As Parkin Authority");
//		buttonLogin2.setBounds(10, 340, 300, 25);
//		buttonLogin2.addActionListener(new GUI());
//		panel.add(buttonLogin2);
//		
//		buttonLogin3 = new JButton("Login As System Administrator");
//		buttonLogin3.setBounds(10, 380, 300, 25);
//		buttonLogin3.addActionListener(new GUI());
//		panel.add(buttonLogin3);
//		
//		buttonReset = new JButton("Reset");
//		buttonReset.setBounds(10, 420, 300, 25);
//		buttonReset.addActionListener(new GUI());
//		panel.add(buttonReset);
//		
//		buttonSignUp = new JButton("Sign Up");
//		buttonSignUp.setBounds(10, 460, 300, 25);
//		buttonSignUp.addActionListener(new GUI());
//		panel.add(buttonSignUp);
//		
//		success = new JLabel();
//		success.setBounds(10, 200, 300, 25);
//		panel.add(success);
//		success.setText(null);
//		
//		frame.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		String user = userText.getText();
//		String password = String.valueOf(passwordText.getPassword());
// if reset is clicked
		if(e.getSource() == buttonReset) {
			userText.setText("");
			passwordText.setText("");
			success.setText(null);
		}
// if login as customer is clicked	
//		if(e.getSource() == buttonLogin1) {
//			
//			if(customerLoginInfo.containsKey(user)) {
//				if(customerLoginInfo.get(user).equals(password)) {
//					success.setForeground(Color.green);
//					success.setText("Successful");
//					frame.dispose();
//					CustomerLogin customer = new CustomerLogin(user);
//				}
//				else {
//					success.setForeground(Color.red);
//					success.setText("Incorrect Password");
//				}
//			}
//			else {
//				success.setForeground(Color.red);
//				success.setText("Incorrect User");
//			}
//		}
//// if login as authority is clicked		
//		if(e.getSource() == buttonLogin2) {
//			
//			if(authorityLoginInfo.containsKey(user)) {
//				if(authorityLoginInfo.get(user).equals(password)) {
//					success.setForeground(Color.green);
//					success.setText("Successful");
//					frame.dispose();
//					AuthorityLogin authority = new AuthorityLogin(user);
//				}
//				else {
//					success.setForeground(Color.red);
//					success.setText("Incorrect Password");
//				}
//			}
//			else {
//				success.setForeground(Color.red);
//				success.setText("Incorrect User");
//			}
//		}
//// if login as Administrator is clicked		
//		if(e.getSource() == buttonLogin3) {
//			
//			if(administratorLoginInfo.containsKey(user)) {
//				if(administratorLoginInfo.get(user).equals(password)) {
//					success.setForeground(Color.green);
//					success.setText("Successful");
//					frame.dispose();
//					AdministratorLogin administrator = new AdministratorLogin(user);
//				}
//				else {
//					success.setForeground(Color.red);
//					success.setText("Incorrect Password");
//				}
//			}
//			else {
//				success.setForeground(Color.red);
//				success.setText("Incorrect User");
//			}
//		}
//// if Sign  Up is clicked
//		if(e.getSource() == buttonSignUp) {
//			frame.dispose();
//			NewLogin newUser = new NewLogin(user);
//		}
		
	}
}
