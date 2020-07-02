package billet_avion;
///////////////////////////// ************ Classe pour Ajouter un Voyageur a un Vol
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Ajouter_Voyageur extends JFrame {

	private JPanel contentPane;
	private JTextField textField_id_vol;
	private JTextField textField_Nom;
	private JTextField textField_CIN;
	private JTextField textField_Id_Avion;
	private JTextField textField_prenom;
	private JTextField textField_Numero_Passeport;
	private JTable table;
	private JTextField textField_phone;
	private JTextField txtChercherParIdvol;

	/**
	 * Launch the application.
	 */
	
	
	
	public boolean verifyFields()
    {
                String ID_vol=textField_id_vol.getText();
				String iD_Avion=textField_Id_Avion.getText();
				String Nom_Voyageur=textField_Nom.getText();
				String Prenom=textField_prenom.getText();
				String CIN=textField_CIN.getText();
				String Passeport=textField_Numero_Passeport.getText();
				//String Mail=textField_mail.getText();
				String Phone=textField_phone.getText();
				
				
				
        
        // check empty fields
        
        if(ID_vol.trim().equals("") || iD_Avion.trim().equals("") || Nom_Voyageur.trim().equals("")||Prenom.trim().equals("")
        		||Nom_Voyageur.trim().equals("")||Prenom.trim().equals("")
                ||CIN.trim().equals("")||Passeport.trim().equals("")||Phone.trim().equals("") )
        {
            JOptionPane.showMessageDialog(null, "Verifier si un champ au plus Sont  vide","Champ Vide",2);
            return false;
        }
		return false;
        
        // check if the two password are equals or not
        
       
    }

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajouter_Voyageur frame = new Ajouter_Voyageur();
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
	public Ajouter_Voyageur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1653, 905);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setBounds(0, 0, 1625, 106);
		panel.add(panel_1);
		
		JLabel lblAffecterDesVoyageurs = new JLabel("Affecter des Voyageurs \u00E0 un Vol");
		lblAffecterDesVoyageurs.setForeground(new Color(255, 255, 224));
		lblAffecterDesVoyageurs.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));
		lblAffecterDesVoyageurs.setBounds(652, 28, 394, 37);
		panel_1.add(lblAffecterDesVoyageurs);
		
		//////////////////  ******************************************  Retour au Gestion des Voyageurs
		JButton button_Back = new JButton("");
		button_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Voyageur fr1 = new Voyageur();
				fr1.setVisible(true);
				dispose();
			}
		});
		
		
		/////////////////////////////////////////////////////////////////////////////////////
		button_Back.setIcon(new ImageIcon(Ajouter_Voyageur.class.getResource("/images/back.jpg")));
		button_Back.setOpaque(false);
		button_Back.setBounds(12, 13, 97, 67);
		panel_1.add(button_Back);
		
		JLabel label_2 = new JLabel("Retour");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(121, 34, 82, 30);
		panel_1.add(label_2);
		
		
		
		////////////////  Afficher tous les Reservations Possibles
		JButton btnLesRservationDisponibles = new JButton("Les R\u00E9servation disponibles");
		btnLesRservationDisponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 Statement stmt=connection.createStatement();
					 String  sql1="Select * from vols_traveler_reserve  ";
					 ResultSet resultSet=stmt.executeQuery(sql1);
					 table.setModel(DbUtils.resultSetToTableModel(resultSet));
			         
					 connection.close();
				}catch(ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				}

			
		});
		btnLesRservationDisponibles.setOpaque(false);
		btnLesRservationDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLesRservationDisponibles.setBounds(26, 154, 436, 42);
		panel.add(btnLesRservationDisponibles);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(26, 209, 436, 393);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		textField_id_vol = new JTextField();
		textField_id_vol.setEditable(false);
		textField_id_vol.setOpaque(false);
		textField_id_vol.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		textField_id_vol.setColumns(10);
		textField_id_vol.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_id_vol.setBounds(12, 43, 199, 34);
		panel_2.add(textField_id_vol);
		
		JLabel lblIdvol = new JLabel("Id_vol");
		lblIdvol.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdvol.setBounds(12, 23, 103, 34);
		panel_2.add(lblIdvol);
		
		textField_Nom = new JTextField();
		textField_Nom.setEditable(false);
		textField_Nom.setOpaque(false);
		textField_Nom.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		textField_Nom.setColumns(10);
		textField_Nom.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_Nom.setBounds(12, 139, 199, 34);
		panel_2.add(textField_Nom);
		
		textField_CIN = new JTextField();
		textField_CIN.setEditable(false);
		textField_CIN.setOpaque(false);
		textField_CIN.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		textField_CIN.setColumns(10);
		textField_CIN.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_CIN.setBounds(12, 241, 199, 34);
		panel_2.add(textField_CIN);
		
		JLabel lblNom = new JLabel("Nom ");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNom.setBounds(12, 112, 103, 34);
		panel_2.add(lblNom);
		
		JLabel lblCin = new JLabel("CIN");
		lblCin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCin.setBounds(12, 215, 103, 34);
		panel_2.add(lblCin);
		
		JLabel lblIdavion = new JLabel("id_avion");
		lblIdavion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdavion.setBounds(223, 23, 103, 34);
		panel_2.add(lblIdavion);
		
		textField_Id_Avion = new JTextField();
		textField_Id_Avion.setEditable(false);
		textField_Id_Avion.setOpaque(false);
		textField_Id_Avion.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		textField_Id_Avion.setColumns(10);
		textField_Id_Avion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_Id_Avion.setBounds(223, 43, 199, 34);
		panel_2.add(textField_Id_Avion);
		
		textField_prenom = new JTextField();
		textField_prenom.setEditable(false);
		textField_prenom.setOpaque(false);
		textField_prenom.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		textField_prenom.setColumns(10);
		textField_prenom.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_prenom.setBounds(223, 139, 199, 34);
		panel_2.add(textField_prenom);
		
		textField_Numero_Passeport = new JTextField();
		textField_Numero_Passeport.setEditable(false);
		textField_Numero_Passeport.setOpaque(false);
		textField_Numero_Passeport.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		textField_Numero_Passeport.setColumns(10);
		textField_Numero_Passeport.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_Numero_Passeport.setBounds(223, 241, 199, 34);
		panel_2.add(textField_Numero_Passeport);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrenom.setBounds(223, 112, 103, 34);
		panel_2.add(lblPrenom);
		
		JLabel lblNumeropasseport = new JLabel("Numero_Passeport");
		lblNumeropasseport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeropasseport.setBounds(223, 215, 139, 34);
		panel_2.add(lblNumeropasseport);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(12, 312, 103, 34);
		panel_2.add(lblEmail);
		
		JTextField textField_mail = new JTextField();
		textField_mail.setEditable(false);
		textField_mail.setOpaque(false);
		textField_mail.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		textField_mail.setColumns(10);
		textField_mail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_mail.setBounds(12, 346, 199, 34);
		panel_2.add(textField_mail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhone.setBounds(223, 312, 103, 34);
		panel_2.add(lblPhone);
		
		textField_phone = new JTextField();
		textField_phone.setEditable(false);
		textField_phone.setOpaque(false);
		textField_phone.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		textField_phone.setColumns(10);
		textField_phone.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_phone.setBounds(223, 346, 199, 34);
		panel_2.add(textField_phone);
		
		
		/////***********  Afficher les info selectees dans jtexfield
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				  DefaultTableModel model=(DefaultTableModel) table.getModel();
					 // get the selected row index
				       int selectedRowIndex = table.getSelectedRow();
				       
				       // set the selected row data into jtextfields
				         textField_id_vol.setText(model.getValueAt(selectedRowIndex, 2).toString());
				         textField_Id_Avion.setText(model.getValueAt(selectedRowIndex, 3).toString());
				         textField_Nom.setText(model.getValueAt(selectedRowIndex, 4).toString());
				         textField_prenom.setText(model.getValueAt(selectedRowIndex, 5).toString());
				         textField_CIN.setText(model.getValueAt(selectedRowIndex, 6).toString());
				         textField_Numero_Passeport.setText(model.getValueAt(selectedRowIndex, 1).toString());
				         textField_mail.setText(model.getValueAt(selectedRowIndex, 7).toString());
				         textField_phone.setText(model.getValueAt(selectedRowIndex, 8).toString());
			}
		});
	
		
		
		
		///////////////////***************  Affecter un voyageur au vole indique(Table voyageur)
		scrollPane.setBounds(474, 209, 1151, 393);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_Ajoutter = new JButton("Ajouter Ce Voyageur au Vol Indiqu\u00E9");
		btnNewButton_Ajoutter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			    String ID_vol=textField_id_vol.getText();
				String Passeport=textField_Numero_Passeport.getText();
				String Prenom=textField_prenom.getText();
				String Nom_Voyageur=textField_Nom.getText();
				String CIN=textField_CIN.getText();
				String Email=textField_mail.getText();
				String Phone=textField_phone.getText();
				
                int YesOrNo = JOptionPane.showConfirmDialog(null,"veuillez vérifier les informations saisies","Ajoutter voyageur", JOptionPane.YES_NO_OPTION);
				
				if(YesOrNo==0) {
					if (!verifyFields()) {
						try {
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
							Statement statement = connection.createStatement();
							
 							String query = "INSERT INTO voyageur(id_vol ,NumeroPassport,Prenom,Nom,CIN,Email,phone) values('" + ID_vol + "','" + Passeport + "','" + Prenom + "','" + Nom_Voyageur + "','" +
 									CIN + "','" + Email + "','" + Phone + "')";
 							statement.executeUpdate(query);
							connection.close();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(btnNewButton_Ajoutter, "Le voyageur à été bien affecté à ce Vol");
					}
					
				}
				///////////// S'il est Ajouter doit etre supprimer de la table
				int row =table.getSelectedRow();
				String cell=table.getModel().getValueAt(row, 0).toString();
				//String sql="delete from vol where id_vol="+cell ;
				String sql="delete from vols_traveler_reserve where id_reserve="+cell;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					PreparedStatement preparedStatement=connection.prepareStatement(sql);
					preparedStatement.execute();
					//JOptionPane.showMessageDialog(null,"veuillez mise à jour Votre Table des réservations disponibles");
					connection.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 Statement stmt=connection.createStatement();
					 String  sql1="Select * from vols_traveler_reserve  ";
					 ResultSet resultSet=stmt.executeQuery(sql1);
					 table.setModel(DbUtils.resultSetToTableModel(resultSet));
			         
					 connection.close();
				}catch(ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			
			
			
			}
		});
		
		
		
		/////////////////////////////////////////////////////////////////
		btnNewButton_Ajoutter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Ajoutter.setBounds(26, 650, 371, 33);
		panel.add(btnNewButton_Ajoutter);
		
		
		////*******************  Rejetter Un Voyageur
		
		
		JButton btnRejetterCeVoyageur = new JButton("Rejetter ce Voyageur");
		btnRejetterCeVoyageur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row =table.getSelectedRow();
				String cell=table.getModel().getValueAt(row, 0).toString();
				//String sql="delete from vol where id_vol="+cell ;
				String sql="delete from vols_traveler_reserve where id_reserve="+cell;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					PreparedStatement preparedStatement=connection.prepareStatement(sql);
					preparedStatement.execute();
					JOptionPane.showMessageDialog(null,"Ce Voyageur a été bien Rejetté");
					connection.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 Statement stmt=connection.createStatement();
					 String  sql1="Select * from vols_traveler_reserve  ";
					 ResultSet resultSet=stmt.executeQuery(sql1);
					 table.setModel(DbUtils.resultSetToTableModel(resultSet));
			         
					 connection.close();
				}catch(ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		btnRejetterCeVoyageur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRejetterCeVoyageur.setBounds(474, 650, 387, 33);
		panel.add(btnRejetterCeVoyageur);
		
		JLabel lblSelectionnerUnVoygeur = new JLabel("S\u00E9lectionner Un voygeur Pour lui ajoutter \u00E0 un Vol ou lui Rejetter");
		lblSelectionnerUnVoygeur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelectionnerUnVoygeur.setBounds(750, 156, 605, 38);
		panel.add(lblSelectionnerUnVoygeur);
		
		
		///*************** Mise a jour
		JButton button_MiseAjour = new JButton("Mettre \u00E0 jour");
		button_MiseAjour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 Statement stmt=connection.createStatement();
					 String  sql1="Select * from vols_traveler_reserve  ";
					 ResultSet resultSet=stmt.executeQuery(sql1);
					 table.setModel(DbUtils.resultSetToTableModel(resultSet));
			         JOptionPane.showMessageDialog(null,"la table est mise à jour..... ");
					
				}catch(ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		
		
		button_MiseAjour.setOpaque(false);
		button_MiseAjour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_MiseAjour.setBounds(26, 721, 371, 33);
		panel.add(button_MiseAjour);
		
		////////////  chercher les de mande de reservation par id_vol 
		txtChercherParIdvol = new JTextField();
		txtChercherParIdvol.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				 try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 String sql="select * from vols_traveler_reserve where id_vol=?";
					 PreparedStatement preparedStatement=connection.prepareStatement(sql);
					 preparedStatement.setString(1,txtChercherParIdvol.getText() );
					 ResultSet resultSet=preparedStatement.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(resultSet));
					 connection.close();
				} catch (Exception e1) {
					// TODO: handle exception
				}
				 
			}
		});
		txtChercherParIdvol.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtChercherParIdvol.getText().trim().toLowerCase().equals("chercher par id_vol")){
					txtChercherParIdvol.setText("");
					txtChercherParIdvol.setForeground(Color.black);
			        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtChercherParIdvol.getText().trim().equals("") || 
						txtChercherParIdvol.getText().trim().toLowerCase().equals("chercher par id_vol"))
			        {
			            
					txtChercherParIdvol.setText("chercher par id_vol");
					txtChercherParIdvol.setForeground(new Color (153,153,153));
			        
			        }
			}
		});
		txtChercherParIdvol.setText("   Chercher par Id_Vol");
		txtChercherParIdvol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtChercherParIdvol.setBounds(474, 154, 245, 42);
		panel.add(txtChercherParIdvol);
		txtChercherParIdvol.setColumns(10);
	}
}
