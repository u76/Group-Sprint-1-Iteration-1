import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import javax.swing.border.TitledBorder;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class RegistrationPage implements ActionListener{

	private JFrame frame;
	private JTextField fullName;
	private JTextField username;
	private JTextField password;
	private JTextField email;
	private JButton btnSubmit;
	private static Connection conn;
	private static Statement stmt;
	private static ResultSet myRs;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public RegistrationPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(255, 127, 80));
		frame.getContentPane().setForeground(new Color(255, 127, 80));
		frame.setSize(1081,639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1047, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Register at");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(122, 62, 293, 76);
		panel.add(lblNewLabel_1);
		
		JLabel lblFirstName = new JLabel("Full Name");
		lblFirstName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblFirstName.setBounds(599, 62, 145, 56);
		panel.add(lblFirstName);
		
		fullName = new JTextField();
		fullName.setOpaque(false);
		fullName.setBackground(new Color(255, 0, 0));
		fullName.setBorder(null);
		fullName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		fullName.setForeground(new Color(255, 250, 240));
		fullName.setBounds(599, 113, 438, 39);
		panel.add(fullName);
		fullName.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(599, 162, 438, 2);
		panel.add(separator);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblUsername.setBounds(589, 185, 145, 50);
		panel.add(lblUsername);
		
		username = new JTextField();
		username.setOpaque(false);
		username.setForeground(new Color(245, 245, 245));
		username.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		username.setColumns(10);
		username.setBorder(null);
		username.setBackground(Color.RED);
		username.setBounds(589, 232, 438, 39);
		panel.add(username);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(589, 281, 438, 2);
		panel.add(separator_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblPassword.setBounds(599, 295, 130, 50);
		panel.add(lblPassword);
		
		password = new JTextField();
		password.setOpaque(false);
		password.setForeground(new Color(245, 245, 245));
		password.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		password.setColumns(10);
		password.setBorder(null);
		password.setBackground(Color.RED);
		password.setBounds(589, 337, 438, 39);
		panel.add(password);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(589, 386, 438, 2);
		panel.add(separator_2);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEmailAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailAddress.setForeground(Color.WHITE);
		lblEmailAddress.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblEmailAddress.setBounds(599, 398, 154, 56);
		panel.add(lblEmailAddress);
		
		email = new JTextField();
		email.setOpaque(false);
		email.setForeground(new Color(250, 235, 215));
		email.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		email.setColumns(10);
		email.setBorder(null);
		email.setBackground(Color.RED);
		email.setBounds(599, 449, 438, 39);
		panel.add(email);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(589, 499, 438, 2);
		panel.add(separator_3);
		
		JLabel lblNewLabel = new JLabel("Register at");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 21));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Documents\\Study materials\\5th Sem\\3208 Project\\Assignment\\Credit Transfer\\atmc img 2.jpg"));
		lblNewLabel.setBounds(0, 0, 538, 582);
		panel.add(lblNewLabel);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("Berlin Sans FB", Font.PLAIN, 21));
		btnSubmit.addActionListener(this);
		btnSubmit.setBorder(null);
		btnSubmit.setActionCommand("Submit");
		btnSubmit.setBackground(new Color(255, 165, 0));
		btnSubmit.setBounds(907, 533, 120, 39);
		panel.add(btnSubmit);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Documents\\Study materials\\5th Sem\\3208 Project\\Assignment\\Credit Transfer\\input background1.jpg"));
		label.setBounds(532, 0, 515, 582);
		panel.add(label);
		frame.getContentPane().setLayout(groupLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSubmit) {
			if (fullName.getText().equalsIgnoreCase("")||username.getText().equalsIgnoreCase("")||password.getText().equalsIgnoreCase("")||email.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(btnSubmit, "Fill out all the details first ");
			}
			else {
				try {
					conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/login data","root","");
					stmt=conn.createStatement();
					ResultSet myRs=stmt.executeQuery("SELECT * FROM `user_detail` WHERE username= \""+ username.getText()+"\"&& password=\""+password.getText()+"\"");
					if (myRs.next()) {
						JOptionPane.showMessageDialog(btnSubmit, ""+username.getText()+" is already registered. create different account");
					}
					else {
						SendEmail sendEmail =new SendEmail(email.getText(),"Welcome ","Welcome to our fellow team member");
						if (sendEmail.success!=0) {
							stmt.executeUpdate("INSERT INTO `user_detail` (Name, username, password, email) VALUES('"+fullName.getText()+"','"+username.getText()+"','"+password.getText()+"','"+email.getText()+"')");
							JOptionPane.showMessageDialog(btnSubmit, "Welcome "+username.getText());
						}
						
					}
					
				}
				catch(Exception ex){ex.printStackTrace();}
			}
			
		}
	}
}
