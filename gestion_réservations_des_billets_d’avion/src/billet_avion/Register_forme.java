package billet_avion;
//////////////////////////////////////***********  Cette classe Pour ceer un nouveau compte pour utiliser L'application
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Cursor;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Register_forme extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Fist_Name;
	private JTextField textField_Last_Name;
	private JTextField textField_Username;
	private JTextField textField_Email;
	private JTextField textField_phone;
	private JPasswordField passwordField;
	private JPasswordField passwordField_Confirm_Password;

	/**
	 * Launch the application.
	 */
	
	
	   public boolean verifyFields()
    {
                String FirstName=textField_Fist_Name.getText();
				String LastName=textField_Last_Name.getText();
				String Username=textField_Username.getText();
				String Email=textField_Email.getText();
				String phone=textField_phone.getText();
				String passeword=passwordField.getText();
				String Confirm_passeword=passwordField_Confirm_Password.getText();
			
				
        
        // verifier si un champ est vide
        
        if(FirstName.trim().equals("") || LastName.trim().equals("")
                || Username.trim().equals("") || Email.trim().equals("")||phone.trim().equals("")
                ||passeword.trim().equals("")||Confirm_passeword.trim().equals("") )
        {
            JOptionPane.showMessageDialog(null, "Verifier si un champ au plus Sont  vide ","Champ Vide",2);
            return false;
        }
		return false;
        
       
    }
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_forme frame = new Register_forme();
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
	public Register_forme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(47, 36, 110, 28);
		panel.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLastName.setBounds(47, 108, 110, 28);
		panel.add(lblLastName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(47, 175, 110, 28);
		panel.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(47, 237, 110, 28);
		panel.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPhone.setBounds(47, 304, 110, 28);
		panel.add(lblPhone);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(47, 376, 110, 28);
		panel.add(lblPassword);
		
		JLabel lblConfirmePassword = new JLabel("Confirm Password");
		lblConfirmePassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfirmePassword.setBounds(47, 442, 196, 28);
		panel.add(lblConfirmePassword);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(47, 513, 110, 28);
		panel.add(lblGender);
		
		textField_Fist_Name = new JTextField();
		textField_Fist_Name.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_Fist_Name.setOpaque(false);
		textField_Fist_Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_Fist_Name.setBounds(276, 25, 236, 35);
		panel.add(textField_Fist_Name);
		textField_Fist_Name.setColumns(10);
		
		textField_Last_Name = new JTextField();
		textField_Last_Name.setOpaque(false);
		textField_Last_Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_Last_Name.setColumns(10);
		textField_Last_Name.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_Last_Name.setBounds(276, 93, 236, 35);
		panel.add(textField_Last_Name);
		
		textField_Username = new JTextField();
		textField_Username.setOpaque(false);
		textField_Username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_Username.setColumns(10);
		textField_Username.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_Username.setBounds(276, 159, 236, 35);
		panel.add(textField_Username);
		
		textField_Email = new JTextField();
		textField_Email.setOpaque(false);
		textField_Email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_Email.setColumns(10);
		textField_Email.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_Email.setBounds(276, 230, 236, 35);
		panel.add(textField_Email);
		
		textField_phone = new JTextField();
		textField_phone.setOpaque(false);
		textField_phone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_phone.setColumns(10);
		textField_phone.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_phone.setBounds(276, 297, 236, 35);
		panel.add(textField_phone);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setOpaque(false);
		passwordField.setBounds(276, 362, 236, 35);
		panel.add(passwordField);
		
		passwordField_Confirm_Password = new JPasswordField();
		passwordField_Confirm_Password.setOpaque(false);
		passwordField_Confirm_Password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField_Confirm_Password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		passwordField_Confirm_Password.setBounds(276, 428, 236, 35);
		panel.add(passwordField_Confirm_Password);
		
		JRadioButton rdbtnNewRadioButton_Male = new JRadioButton("Male");
		rdbtnNewRadioButton_Male.setOpaque(false);
		rdbtnNewRadioButton_Male.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton_Male.setBounds(276, 510, 88, 35);
		panel.add(rdbtnNewRadioButton_Male);
		
		JRadioButton rdbtnNewRadioButton_Female = new JRadioButton("Female");
		rdbtnNewRadioButton_Female.setOpaque(false);
		rdbtnNewRadioButton_Female.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton_Female.setBounds(409, 510, 103, 35);
		panel.add(rdbtnNewRadioButton_Female);
		
		////////////////////////*******le boutton save 
		
		JButton btnNewButton_Save = new JButton("Save");
		btnNewButton_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// declaration des variables utilise 
				String firstName = textField_Fist_Name.getText();
                String lastName = textField_Last_Name.getText();
                String userName = textField_Username.getText();
                String emailId = textField_Email.getText();
                String mobileNumber = textField_phone.getText();
                int len = mobileNumber.length();
                String password = passwordField.getText();
                String confirmePasswod=passwordField_Confirm_Password.getText();
                ////  Gender
                String gender = null;
                if(rdbtnNewRadioButton_Male.isSelected()) 
                    gender="Male";
                else if(rdbtnNewRadioButton_Female.isSelected()) 
                    gender="Female";
                

                 
                 boolean usename_yeString = false;
                 
                 try {
     				Connection connection1=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
     				Statement stmt=(Statement) connection1.createStatement();
     				
     				String requete ="Select * from users_travelers where username='"  +userName + "'" ;
     				ResultSet rSet =((java.sql.Statement) stmt).executeQuery(requete);
     				
     				if(rSet.next()) {
     					usename_yeString=true;
     				}
     				else {
     					usename_yeString=false;
     				}
     				connection1.close();
     				
     			} catch (Exception e1) {
     				// TODO: handle exception
     			}
                 
                 
                 
                 String msg = "" + firstName;
                 msg += " \n";
                 
                 if (passwordField.getText().equals(passwordField_Confirm_Password.getText())) {
                 	if(!verifyFields()) {
                 	    if (len != 10) {
                         JOptionPane.showMessageDialog(btnNewButton_Save, "Enter a valid mobile number");
                 	    }
                 	    try {
                 	    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
 							
 							String query = "INSERT INTO users_travelers values('" + firstName + "','" + lastName + "','" + userName + "','" +
                             password + "','" + emailId + "','" + mobileNumber + "','" + gender + "')";
                             // remember peut etre une source d'une erreur

                             java.sql.Statement sta =connection.createStatement();
                             int x = ((java.sql.Statement) sta).executeUpdate(query);
                             if (x == 0) {
                             JOptionPane.showMessageDialog(btnNewButton_Save, "This is alredy exist");
                             } else {
                             	JOptionPane.showMessageDialog(btnNewButton_Save,
                                 "Welcome, " + msg + "Your account is sucessfully created");
                               }
                             connection.close();
                         } catch (Exception e2) {
                         e2.printStackTrace();
                         }
                 	}
                 	else {
                 		JOptionPane.showMessageDialog(btnNewButton_Save, "This Username is Already Taken, Choose Another One");
                 	}
                 }
                 else {
                 	 JOptionPane.showMessageDialog(btnNewButton_Save, "password doesn't match");
                 }
                 
			}
		});
		
		
		////////////////////////////////////////////////////////////////////////
		btnNewButton_Save.setOpaque(false);
		btnNewButton_Save.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_Save.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Save.setBounds(249, 579, 88, 35);
		panel.add(btnNewButton_Save);
		
		
		  //// quiter l'application 
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frmloginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmloginSystem,"voulez vous quitter l'Application?","Login Systems",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					    System.exit(0);
				};
			}
		});
		
		
		/////////////////////////////////
		btnExit.setOpaque(false);
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.setBounds(424, 579, 88, 35);
		panel.add(btnExit);
		
		
		//  Reset les champs a zero
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_Fist_Name.setText(null);
				textField_Last_Name.setText(null);
				textField_Email.setText(null);
				textField_Username.setText(null);
				passwordField.setText(null);
				textField_phone.setText(null);
				passwordField_Confirm_Password.setText(null);
			}
		});
		
		
		
		//pour le choix entre Male  ou Female 
				/////////////
		ButtonGroup bg = new ButtonGroup();
	    bg.add(rdbtnNewRadioButton_Male);
	    bg.add(rdbtnNewRadioButton_Female);
		//////////////////////////////////
		
		btnReset.setOpaque(false);
		btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBounds(81, 579, 88, 35);
		panel.add(btnReset);
		
		
		// retoure a la fenetre login
		JLabel lblNewLabel_Login = new JLabel(">>Already have an Account? Login");
		lblNewLabel_Login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login fr = new Login();
				fr.setVisible(true);
				dispose();
			}
		});
		//////////////////////////////////////////////
		lblNewLabel_Login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_Login.setForeground(Color.RED);
		lblNewLabel_Login.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_Login.setBounds(122, 638, 369, 35);
		panel.add(lblNewLabel_Login);
		
		JLabel lblNewLabel_background = new JLabel("");
		lblNewLabel_background.setIcon(new ImageIcon(Register_forme.class.getResource("/images/h1-background-1.jpg")));
		lblNewLabel_background.setBounds(0, 0, 601, 683);
		panel.add(lblNewLabel_background);
	}

}
