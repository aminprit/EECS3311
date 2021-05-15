package Project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewLogin implements ActionListener{
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton buttonCustomer;
	private static JButton buttonAuthority;
	private static JButton buttonAdministrator;
	private static JButton buttonCancel;
	private static JLabel welcomeLabel = new JLabel("Hello!");
	
	NewLogin(){}
	
	NewLogin(String user){
			
		welcomeLabel.setBounds(0,0,400,35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Welcome to Sign Up");
		frame = new JFrame();
		panel = new JPanel();
		
			
		
		frame.add(welcomeLabel);
		frame.setSize(550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
//		frame.setLayout(null);

		
		panel.setLayout(null);
		
		userLabel = new JLabel("User");
		userLabel.setBounds(10, 80, 80, 25);
		panel.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(100, 80, 165, 25);
		panel.add(userText);
		
		passwordLabel= new JLabel("Password");
		passwordLabel.setBounds(10, 110, 80, 25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 110, 165, 25);
		panel.add(passwordText);
		
		buttonCustomer= new JButton("Sign Up as Customer");
		buttonCustomer.setBounds(10, 300, 300, 25);
		buttonCustomer.addActionListener(new NewLogin());
		panel.add(buttonCustomer);
		
		buttonAuthority = new JButton("Sign Up as Authority");
		buttonAuthority.setBounds(10, 330, 300, 25);
		buttonAuthority.addActionListener(new NewLogin());
		panel.add(buttonAuthority);
		
		buttonAdministrator = new JButton("Sign Up as Administrator");
		buttonAdministrator.setBounds(10, 360, 300, 25);
		buttonAdministrator.addActionListener(new NewLogin());
		panel.add(buttonAdministrator);
		
		buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(10, 390, 300, 25);
		buttonCancel.addActionListener(new NewLogin());
		panel.add(buttonCancel);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		IdandPassword idandPasswords = new IdandPassword();

		String user = userText.getText();
		String password = String.valueOf(passwordText.getPassword());
		
		if(e.getSource() == buttonCancel) {
			frame.dispose();
		}
		if (e.getSource() == buttonCustomer) {
			idandPasswords.addCustomer(user, password);
			frame.dispose();
			GUI gui = new GUI();
			gui.guiCreate();
		}
		if (e.getSource() == buttonAuthority) {
			idandPasswords.addAuthority(user, password);
			frame.dispose();
			GUI gui = new GUI();
			gui.guiCreate();
		}
		if (e.getSource() == buttonAdministrator) {
			idandPasswords.addAdministrator(user, password);
			frame.dispose();
			GUI gui = new GUI();
			gui.guiCreate();
		}
	}
}
