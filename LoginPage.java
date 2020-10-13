import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.sql.*;

public class LoginPage implements ActionListener {

	private JFrame frame;
	private JTextField txtEnterUsername;
	private JPasswordField passwordField;
	private JButton btnLogIn;
	private JButton btnRegister;
	private static Connection conn;
	private static Statement stmt;
	private ResultSet myRs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(1112,669);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 99, 71));
		panel.setBorder(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblUsername.setForeground(Color.WHITE);
		
		txtEnterUsername = new JTextField();
		txtEnterUsername.setForeground(Color.LIGHT_GRAY);
		txtEnterUsername.setBorder(null);
		txtEnterUsername.setOpaque(false);
		txtEnterUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 21));
		txtEnterUsername.setBackground(new Color(255, 0, 51));
		txtEnterUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtEnterUsername.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setBorder(null);
		passwordField.setOpaque(false);
		passwordField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 21));
		
		JSeparator separator_1 = new JSeparator();
		
		btnLogIn = new JButton("Log In");
		btnLogIn.setBackground(new Color(255, 99, 71));
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setBorder(new LineBorder(new Color(255, 140, 0), 1, true));
		btnLogIn.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		btnLogIn.addActionListener(this);
		
		btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		btnRegister.setBorder(new LineBorder(new Color(255, 140, 0), 1, true));
		btnRegister.setBackground(new Color(233, 150, 122));
		btnRegister.addActionListener(this);
		
		JLabel lblNewLabel_1 = new JLabel("Transfer your credit easily");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 26));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 127, 80));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Documents\\Study materials\\5th Sem\\3208 Project\\Assignment\\Credit Transfer\\atmc img 2.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Documents\\Study materials\\5th Sem\\3208 Project\\Assignment\\Credit Transfer\\input background1.jpg"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(82)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 516, Short.MAX_VALUE))
					.addGap(13)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
							.addGap(254))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(43)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtEnterUsername, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
									.addGap(17))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(30)
									.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
									.addGap(12))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(30)
									.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
									.addGap(255)))
							.addGap(12))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(43)
							.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(155)
							.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
					.addGap(102))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(525)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 505, Short.MAX_VALUE)
					.addGap(68))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(60)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 546, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(123)
					.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(33)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtEnterUsername, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(73)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(113)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addGap(76)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 546, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
					.addGap(2))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnLogIn) {
			if (txtEnterUsername.getText().equalsIgnoreCase("")||passwordField.getText().contentEquals("")) {
				JOptionPane.showMessageDialog(btnLogIn, "Write username & password");
			}
			else {
				try {
					conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/login data","root","");
					stmt=conn.createStatement();
					ResultSet myRs=stmt.executeQuery("SELECT * FROM `user_detail` WHERE username= \""+ txtEnterUsername.getText()+"\"&& password=\""+passwordField.getText()+"\"");
						if (myRs.next()) {
							StudentProfile profile =new StudentProfile(txtEnterUsername.getText(),passwordField.getText());
						}
						else {
							JOptionPane.showMessageDialog(btnLogIn, "INVALID username or password ");
						}
				}
				catch(Exception ex){ex.printStackTrace();}
			}
		}
		else if(e.getSource()==btnRegister) {
			RegistrationPage rg= new RegistrationPage();
		}
		
	}
}
