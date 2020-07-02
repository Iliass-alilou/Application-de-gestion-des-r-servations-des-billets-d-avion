package billet_avion;

import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Label;
import javax.swing.JRadioButton;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
//////////////////////*******************************   Cette classe pour s'authentifier  *********************/
public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField_Username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					Login frame = new Login();
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
	public Login() {
		// centrer la fenetre
		this.setLocationRelativeTo(null);
		
		
			
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Panel panel = new Panel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JRadioButton rdbtn_Traveler = new JRadioButton("Traveler");
		rdbtn_Traveler.setOpaque(false);
		rdbtn_Traveler.setBounds(170, 283, 127, 25);
		rdbtn_Traveler.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtn_Traveler.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel.add(rdbtn_Traveler);
		
		JRadioButton rdbtn_Admin = new JRadioButton("Admin");
		rdbtn_Admin.setOpaque(false);
		rdbtn_Admin.setBounds(333, 283, 127, 25);
		rdbtn_Admin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtn_Admin.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel.add(rdbtn_Admin);
		
		
		// ouvrire la fenetre de s'enregistrement 
		Label label_CreateAccount = new Label("   >>No Acount? Create one..");
		label_CreateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Register_forme fr = new Register_forme();
				fr.setVisible(true);
				dispose();
			}
		});
		
		
		
		
		label_CreateAccount.setBounds(170, 428, 290, 24);
		label_CreateAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_CreateAccount.setForeground(Color.RED);
		label_CreateAccount.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(label_CreateAccount);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setBackground(Color.RED);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 21));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		passwordField.setOpaque(false);
		passwordField.setBounds(170, 176, 290, 40);
		panel.add(passwordField);
		
		textField_Username = new JTextField();
		textField_Username.setForeground(Color.BLACK);
		textField_Username.setBackground(Color.RED);
		textField_Username.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textField_Username.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_Username.setOpaque(false);
		textField_Username.setBounds(170, 91, 290, 40);
		panel.add(textField_Username);
		textField_Username.setColumns(10);
		
		// cliker eur le button Login pour le client
		
		JButton btnNewButton_Login = new JButton("Login");
		btnNewButton_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					Statement stmt=con.createStatement();
					if(rdbtn_Traveler.isSelected()) {
						String  sql="select * from users_travelers where 	username='"+textField_Username.getText()
						+"' and password='"+passwordField.getText().toString()+"'";
						ResultSet rs=stmt.executeQuery(sql);
						if(rs.next()) {
							JOptionPane.showMessageDialog(null,"Login Sucessfully ...");
							//Login.dispose();
							Traveler Tv = new Traveler();
							Tv.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null,"incorrect username or password ...");
						    con.close();
						}
					}
					else {
						if(rdbtn_Admin.isSelected()) {
							String  sql="select * from users_admin where 	username_admin='"
						+textField_Username.getText()+"' and password_admin='"+passwordField.getText().toString()+"'";
							ResultSet rs=stmt.executeQuery(sql);
							if(rs.next()) {
								JOptionPane.showMessageDialog(null,"Login Sucessfully ...");
								//Login.dispose();
								Administrateur_Gestion Ad = new Administrateur_Gestion();
								Ad.setVisible(true);
							}	
							else {
								JOptionPane.showMessageDialog(null,"incorrect username or password ...");
							    con.close();}
							
							}
							
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,e);
				}
		}
			
			
		});
		
		
		
		
		//pour le choie entre Traveler ou Admin 
		/////////////
		ButtonGroup bg = new ButtonGroup();
        bg.add(rdbtn_Traveler);
        bg.add(rdbtn_Admin);
		///////////////
		
		
		
		btnNewButton_Login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_Login.setOpaque(false);
		btnNewButton_Login.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnNewButton_Login.setBounds(168, 343, 97, 40);
		panel.add(btnNewButton_Login);
		
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
		
		
		
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setOpaque(false);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnExit.setBounds(363, 343, 97, 40);
		panel.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(170, 56, 116, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(168, 144, 150, 29);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("You are..");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(170, 239, 116, 25);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_background = new JLabel("");
		lblNewLabel_background.setIcon(new ImageIcon(Login.class.getResource("/images/plane.jpg")));
		lblNewLabel_background.setBounds(0, 0, 632, 605);
		panel.add(lblNewLabel_background);
	}
}
