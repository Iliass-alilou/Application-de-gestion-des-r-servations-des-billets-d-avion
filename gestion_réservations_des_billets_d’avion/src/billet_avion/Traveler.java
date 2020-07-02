package billet_avion;
///////////////////////////////////////********* Cette classe pour L'utilisateur afin de Reserver son Vol
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Traveler extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_Vols_Disponibles;
	private JTextField txt_chercher_Ville_Depart;
	private JTextField txt_chercher_ville_Arrivee;
	private JTextField txt_ID_Vol;
	private JTextField txt_ID_Avion;
	private JTextField txt_Ville_Depart;
	private JTextField txt_Ville_Arrivee;
	private JTextField txt_Heure_Depart;
	private JTextField txt_Heure_Arrivee;
	private JTextField txt_Duree;
	private JTextField txt_Chercher_HeurDepart;
	private JTextField txt_Nom_Voyageur;
	private JTextField txt_Prenom_voyageur;
	private JTextField txt_CIN_Voyageur;
	private JTextField txt_Passeport_Voyageur;
	private JTextField txtJourDepart;
	private JTextField textField_phone;
	private JTextField textField_Mail;
	private JTextField txt_nume_Passeport_Annuler;
	private JButton C9;
	private JTextField textField_Num_Siege;

	/**
	 * Launch the application.
	 * 
	 */

	 // create a function to verify the empty fields  
    public boolean verifyFields()
    {
                String ID_vol=txt_ID_Vol.getText();
				String iD_Avion=txt_ID_Avion.getText();
				String Ville_depart=txt_Ville_Depart.getText();
				String Ville_Arrivee=txt_Ville_Arrivee.getText();
				String Heure_depart=txt_Heure_Depart.getText();
				String Heure_Arrivee=txt_Heure_Arrivee.getText();
				String Duree=txt_Duree.getText();
				String Nom_Voyageur=txt_Nom_Voyageur.getText();
				String Prenom=txt_Prenom_voyageur.getText();
				String CIN=txt_CIN_Voyageur.getText();
				String Passeport=txt_Passeport_Voyageur.getText();
				String Mail=textField_Mail.getText();
				String Phone=textField_phone.getText();
				String siegeString=textField_Num_Siege.getText();
        
        // verifier si un champ est vide
        
        if(ID_vol.trim().equals("") || iD_Avion.trim().equals("")
                || Ville_depart.trim().equals("") || Ville_Arrivee.trim().equals("")||Heure_depart.trim().equals("")
                ||Heure_Arrivee.trim().equals("")||Duree.trim().equals("")||Nom_Voyageur.trim().equals("")||Prenom.trim().equals("")
                ||CIN.trim().equals("")||Passeport.trim().equals("")||Mail.trim().equals("")||Phone.trim().equals("")||siegeString.trim().equals("") )
        {
            JOptionPane.showMessageDialog(null, "Verifier si un champ au plus Sont  vide et Mercie de choisie Votre siege","Champ Vide",2);
            return false;
        }
		return false;
        
       
    }
    
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Traveler frame = new Traveler();
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
	public Traveler() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1036);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setBounds(1350, 32, 4, 947);
		panel.add(panel_1);
		
		
		/*************************    Afficher les informations selectionner dans Jtexfield*********************/
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				   DefaultTableModel model=(DefaultTableModel) table_Vols_Disponibles.getModel();
				 // get the selected row index
			       int selectedRowIndex = table_Vols_Disponibles.getSelectedRow();
			       
			       // set the selected row data into jtextfields
			         txt_ID_Vol.setText(model.getValueAt(selectedRowIndex, 0).toString());
			         txt_ID_Avion.setText(model.getValueAt(selectedRowIndex, 1).toString());
			         txt_Heure_Depart.setText(model.getValueAt(selectedRowIndex, 2).toString());
			         txt_Heure_Arrivee.setText(model.getValueAt(selectedRowIndex, 3).toString());
			         txt_Duree.setText(model.getValueAt(selectedRowIndex, 4).toString());
			         txt_Ville_Depart.setText(model.getValueAt(selectedRowIndex, 5).toString());
			         txt_Ville_Arrivee.setText(model.getValueAt(selectedRowIndex, 6).toString());
			         
			      
			} 
		});
			
		
		scrollPane.setBounds(495, 160, 843, 381);
		panel.add(scrollPane);
		
		table_Vols_Disponibles = new JTable();
		scrollPane.setViewportView(table_Vols_Disponibles);
		
		JLabel lblVolsDissponibls = new JLabel("les vols disponibles");
		lblVolsDissponibls.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVolsDissponibls.setBounds(781, 110, 231, 34);
		panel.add(lblVolsDissponibls);
		
		JLabel lblChercherVotreVol = new JLabel("Chercher Votre Vol:");
		lblChercherVotreVol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChercherVotreVol.setBounds(12, 47, 199, 34);
		panel.add(lblChercherVotreVol);
		
		
		/*****************  Chercher des Vols par leur Ville Deprt************************/
		txt_chercher_Ville_Depart = new JTextField();
		txt_chercher_Ville_Depart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txt_chercher_Ville_Depart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 String sql="select * from vol where AeroportDepart=?";
					 PreparedStatement preparedStatement=connection.prepareStatement(sql);
					 preparedStatement.setString(1,txt_chercher_Ville_Depart.getText() );
					 ResultSet resultSet=preparedStatement.executeQuery();
					 table_Vols_Disponibles.setModel(DbUtils.resultSetToTableModel(resultSet));
					 connection.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		
		
		/*****************  Focus Lost and Grained************************/
		txt_chercher_Ville_Depart.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txt_chercher_Ville_Depart.getText().trim().toLowerCase().equals("ville depart")){
					txt_chercher_Ville_Depart.setText("");
					txt_chercher_Ville_Depart.setForeground(Color.black);
			        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_chercher_Ville_Depart.getText().trim().equals("") || 
						txt_chercher_Ville_Depart.getText().trim().toLowerCase().equals("ville depart"))
			        {
			            
					txt_chercher_Ville_Depart.setText("ville depart");
					txt_chercher_Ville_Depart.setForeground(new Color (153,153,153));
			        
			        }
			}
		});
		
		
		
		txt_chercher_Ville_Depart.setText("   Ville Depart");
		txt_chercher_Ville_Depart.setOpaque(false);
		txt_chercher_Ville_Depart.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		txt_chercher_Ville_Depart.setColumns(10);
		txt_chercher_Ville_Depart.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		txt_chercher_Ville_Depart.setBounds(228, 32, 183, 44);
		panel.add(txt_chercher_Ville_Depart);
		
		
		/***************  Chercher des Vols par leur Ville Arrivee************************/
		txt_chercher_ville_Arrivee = new JTextField();
		txt_chercher_ville_Arrivee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txt_chercher_ville_Arrivee.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 String sql="select * from vol where AeroportArrivee=?";
					 PreparedStatement preparedStatement=connection.prepareStatement(sql);
					 preparedStatement.setString(1,txt_chercher_ville_Arrivee.getText() );
					 ResultSet resultSet=preparedStatement.executeQuery();
					 table_Vols_Disponibles.setModel(DbUtils.resultSetToTableModel(resultSet));
					 connection.close();
				} catch (Exception e1) {
					// TODO: handle exception
				}
				
			}
		});
		/***************  Focus Lost an Grained************************/
		txt_chercher_ville_Arrivee.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txt_chercher_ville_Arrivee.getText().trim().toLowerCase().equals("ville arrivee")){
					txt_chercher_ville_Arrivee.setText("");
					txt_chercher_ville_Arrivee.setForeground(Color.black);
			        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_chercher_ville_Arrivee.getText().trim().equals("") || 
						txt_chercher_ville_Arrivee.getText().trim().toLowerCase().equals("ville arrivee"))
			        {
			            
					txt_chercher_ville_Arrivee.setText("ville arrivee");
					txt_chercher_ville_Arrivee.setForeground(new Color (153,153,153));
			        
			        }
			}
		});
		
		
		txt_chercher_ville_Arrivee.setText("   Ville Arrivee");
		txt_chercher_ville_Arrivee.setOpaque(false);
		txt_chercher_ville_Arrivee.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		txt_chercher_ville_Arrivee.setColumns(10);
		txt_chercher_ville_Arrivee.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		txt_chercher_ville_Arrivee.setBounds(483, 32, 183, 44);
		panel.add(txt_chercher_ville_Arrivee);
		
		JLabel lblMerciDeSelectionne = new JLabel("Merci de S\u00E9lectionner dans la Table Votre Vol Souhait\u00E9");
		lblMerciDeSelectionne.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMerciDeSelectionne.setBounds(12, 110, 521, 34);
		panel.add(lblMerciDeSelectionne);
		
		JLabel lblIdDeVol = new JLabel("Id de Vol");
		lblIdDeVol.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdDeVol.setBounds(12, 165, 103, 34);
		panel.add(lblIdDeVol);
		
		txt_ID_Vol = new JTextField();
		txt_ID_Vol.setEditable(false);
		txt_ID_Vol.setOpaque(false);
		txt_ID_Vol.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		txt_ID_Vol.setColumns(10);
		txt_ID_Vol.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		txt_ID_Vol.setBounds(12, 195, 199, 34);
		panel.add(txt_ID_Vol);
		
		JLabel lblIdDavion = new JLabel("Id d'Avion");
		lblIdDavion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdDavion.setBounds(252, 165, 103, 34);
		panel.add(lblIdDavion);
		
		txt_ID_Avion = new JTextField();
		txt_ID_Avion.setEditable(false);
		txt_ID_Avion.setOpaque(false);
		txt_ID_Avion.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		txt_ID_Avion.setColumns(10);
		txt_ID_Avion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		txt_ID_Avion.setBounds(252, 195, 208, 34);
		panel.add(txt_ID_Avion);
		
		JLabel lblVilleDepart = new JLabel("Ville Depart");
		lblVilleDepart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVilleDepart.setBounds(12, 264, 103, 34);
		panel.add(lblVilleDepart);
		
		JLabel lblVilleArrivee = new JLabel("Ville Arrivee");
		lblVilleArrivee.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVilleArrivee.setBounds(252, 264, 103, 34);
		panel.add(lblVilleArrivee);
		
		txt_Ville_Depart = new JTextField();
		txt_Ville_Depart.setEditable(false);
		txt_Ville_Depart.setOpaque(false);
		txt_Ville_Depart.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		txt_Ville_Depart.setColumns(10);
		txt_Ville_Depart.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		txt_Ville_Depart.setBounds(12, 300, 199, 34);
		panel.add(txt_Ville_Depart);
		
		txt_Ville_Arrivee = new JTextField();
		txt_Ville_Arrivee.setEditable(false);
		txt_Ville_Arrivee.setOpaque(false);
		txt_Ville_Arrivee.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		txt_Ville_Arrivee.setColumns(10);
		txt_Ville_Arrivee.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		txt_Ville_Arrivee.setBounds(252, 300, 208, 34);
		panel.add(txt_Ville_Arrivee);
		
		JLabel lblHeureDepart = new JLabel("Heure Depart");
		lblHeureDepart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHeureDepart.setBounds(12, 362, 103, 34);
		panel.add(lblHeureDepart);
		
		JLabel lblHeureArrive = new JLabel("Heure Arrive");
		lblHeureArrive.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHeureArrive.setBounds(252, 362, 103, 34);
		panel.add(lblHeureArrive);
		
		JLabel lblDuree = new JLabel("Duree");
		lblDuree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDuree.setBounds(12, 456, 103, 34);
		panel.add(lblDuree);
		
		txt_Heure_Depart = new JTextField();
		txt_Heure_Depart.setEditable(false);
		txt_Heure_Depart.setOpaque(false);
		txt_Heure_Depart.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		txt_Heure_Depart.setColumns(10);
		txt_Heure_Depart.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		txt_Heure_Depart.setBounds(12, 391, 199, 34);
		panel.add(txt_Heure_Depart);
		
		txt_Heure_Arrivee = new JTextField();
		txt_Heure_Arrivee.setEditable(false);
		txt_Heure_Arrivee.setOpaque(false);
		txt_Heure_Arrivee.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		txt_Heure_Arrivee.setColumns(10);
		txt_Heure_Arrivee.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		txt_Heure_Arrivee.setBounds(252, 391, 208, 34);
		panel.add(txt_Heure_Arrivee);
		
		txt_Duree = new JTextField();
		txt_Duree.setEditable(false);
		txt_Duree.setOpaque(false);
		txt_Duree.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		txt_Duree.setColumns(10);
		txt_Duree.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		txt_Duree.setBounds(12, 491, 199, 34);
		panel.add(txt_Duree);
		
		
		/************ Chercher des Vols par leur Heur de depart  *************/
		txt_Chercher_HeurDepart = new JTextField();
		txt_Chercher_HeurDepart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txt_Chercher_HeurDepart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 String sql="select * from vol where HeureDepart=?";
					 PreparedStatement preparedStatement=connection.prepareStatement(sql);
					 preparedStatement.setString(1,txt_Chercher_HeurDepart.getText() );
					 ResultSet resultSet=preparedStatement.executeQuery();
					 table_Vols_Disponibles.setModel(DbUtils.resultSetToTableModel(resultSet));
					 connection.close();
				} catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		/************ Focus Lost and Grained*************/
		txt_Chercher_HeurDepart.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txt_Chercher_HeurDepart.getText().trim().toLowerCase().equals("heur depart")){
					txt_Chercher_HeurDepart.setText("");
					txt_Chercher_HeurDepart.setForeground(Color.black);
			        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_Chercher_HeurDepart.getText().trim().equals("") || 
						txt_Chercher_HeurDepart.getText().trim().toLowerCase().equals("heur depart"))
			        {
			            
					txt_Chercher_HeurDepart.setText("heur depart");
					txt_Chercher_HeurDepart.setForeground(new Color (153,153,153));
			        
			        }
			}
		});
		
		
		
		txt_Chercher_HeurDepart.setText("   Heur Depart");
		txt_Chercher_HeurDepart.setOpaque(false);
		txt_Chercher_HeurDepart.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		txt_Chercher_HeurDepart.setColumns(10);
		txt_Chercher_HeurDepart.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		txt_Chercher_HeurDepart.setBounds(1087, 32, 183, 44);
		panel.add(txt_Chercher_HeurDepart);
		
		JLabel lblApresQueVous = new JLabel("Apr\u00E8s que vous avez choisi votre Vol Merci d'entrer vos Informations");
		lblApresQueVous.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApresQueVous.setBounds(12, 566, 636, 34);
		panel.add(lblApresQueVous);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(22, 613, 569, 353);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		txt_Nom_Voyageur = new JTextField();
		txt_Nom_Voyageur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_Nom_Voyageur.setBounds(25, 53, 211, 40);
		panel_2.add(txt_Nom_Voyageur);
		txt_Nom_Voyageur.setColumns(10);
		
		JLabel lblVotreNom = new JLabel("Votre Nom");
		lblVotreNom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVotreNom.setBounds(25, 13, 103, 34);
		panel_2.add(lblVotreNom);
		
		txt_Prenom_voyageur = new JTextField();
		txt_Prenom_voyageur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_Prenom_voyageur.setColumns(10);
		txt_Prenom_voyageur.setBounds(25, 154, 211, 40);
		panel_2.add(txt_Prenom_voyageur);
		
		JLabel lblVotrePrenom = new JLabel("Votre Prenom");
		lblVotrePrenom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVotrePrenom.setBounds(25, 118, 103, 34);
		panel_2.add(lblVotrePrenom);
		
		txt_CIN_Voyageur = new JTextField();
		txt_CIN_Voyageur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_CIN_Voyageur.setColumns(10);
		txt_CIN_Voyageur.setBounds(337, 53, 211, 40);
		panel_2.add(txt_CIN_Voyageur);
		
		JLabel lblVotreCin = new JLabel("Votre CIN");
		lblVotreCin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVotreCin.setBounds(337, 13, 103, 34);
		panel_2.add(lblVotreCin);
		
		txt_Passeport_Voyageur = new JTextField();
		txt_Passeport_Voyageur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_Passeport_Voyageur.setColumns(10);
		txt_Passeport_Voyageur.setBounds(337, 154, 211, 40);
		panel_2.add(txt_Passeport_Voyageur);
		
		JLabel lblVotreNumeroDe = new JLabel("Num\u00E9ro de Passeport");
		lblVotreNumeroDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVotreNumeroDe.setBounds(337, 118, 187, 34);
		panel_2.add(lblVotreNumeroDe);
		
		textField_phone = new JTextField();
		textField_phone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_phone.setColumns(10);
		textField_phone.setBounds(337, 252, 211, 40);
		panel_2.add(textField_phone);
		
		JLabel lblAdresse = new JLabel("Phone");
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAdresse.setBounds(337, 220, 187, 34);
		panel_2.add(lblAdresse);
		
		textField_Mail = new JTextField();
		textField_Mail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Mail.setColumns(10);
		textField_Mail.setBounds(25, 252, 211, 40);
		panel_2.add(textField_Mail);
		
		JLabel label = new JLabel("Adresse Mail");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(25, 220, 187, 34);
		panel_2.add(label);
		
		
		//////////*******************  Enregistrer dans la base de donnees les informations du reservations des Vols
		JButton btn_Confirmer_Vol = new JButton("Confirmer Votre Vol");
		btn_Confirmer_Vol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String ID_vol=txt_ID_Vol.getText();
				String iD_Avion=txt_ID_Avion.getText();
				String Ville_depart=txt_Ville_Depart.getText();
				String Ville_Arrivee=txt_Ville_Arrivee.getText();
				String Heure_depart=txt_Heure_Depart.getText();
				String Heure_Arrivee=txt_Heure_Arrivee.getText();
			//	String Duree=txt_Duree.getText();
				String Nom_Voyageur=txt_Nom_Voyageur.getText();
				String Prenom=txt_Prenom_voyageur.getText();
				String CIN=txt_CIN_Voyageur.getText();
				String Passeport=txt_Passeport_Voyageur.getText();
				String Mail=textField_Mail.getText();
				String Phone=textField_phone.getText();
				String siege=textField_Num_Siege.getText();
				
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Vous etes sure de tes Informations","Clear TextField", JOptionPane.YES_NO_OPTION);
				
				if(YesOrNo==0) {
					if (!verifyFields()) {
						try {
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
							Statement statement = connection.createStatement();
							
 							String query = "INSERT INTO vols_traveler_reserve(Numero_Passeport,id_vol,id_avion,Nom,Prenom,CIN,Email,phone,ville_depart,ville_Arrivee,Heure_depart,Heure_Arrivee,siege) values('" + Passeport + "','" + ID_vol + "','" + iD_Avion + "','" + Nom_Voyageur + "','" +
 							Prenom + "','" + CIN + "','" + Mail + "','"+ Phone +"','"+ Ville_depart +"','"+
 									Ville_Arrivee +"','"+Heure_depart+"','"+Heure_Arrivee +"','"+siege+"')";
 							statement.executeUpdate(query);
							connection.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(btn_Confirmer_Vol, "Ton Vol à été bien reservé");
					}
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
						Statement statement = connection.createStatement();
						String SQL="Insert into sieges(	id_vol,traveler_NB_passeport,siege) values ('"+ID_vol+"','"+Passeport+"','"+siege+"')";
						statement.executeUpdate(SQL);
						connection.close();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}								
			}
		});
				
		btn_Confirmer_Vol.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Confirmer_Vol.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_Confirmer_Vol.setBounds(630, 838, 215, 44);
		panel.add(btn_Confirmer_Vol);
		
		/************* Focus Lost et Grained*******************/
		txtJourDepart = new JTextField();
		txtJourDepart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtJourDepart.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtJourDepart.getText().trim().toLowerCase().equals("date depart")){
					txtJourDepart.setText("");
					txtJourDepart.setForeground(Color.black);
			        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtJourDepart.getText().trim().equals("") || 
						txtJourDepart.getText().trim().toLowerCase().equals("date depart"))
			        {
			            
					txtJourDepart.setText("date depart");
					txtJourDepart.setForeground(new Color (153,153,153));
			        
			        }
			}
		});
		txtJourDepart.setText("   Date Depart");
		txtJourDepart.setOpaque(false);
		txtJourDepart.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		txtJourDepart.setColumns(10);
		txtJourDepart.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		txtJourDepart.setBounds(772, 32, 183, 44);
		panel.add(txtJourDepart);
		
		JLabel lblVotreSiege = new JLabel("Votre Siege");
		lblVotreSiege.setBounds(679, 645, 103, 34);
		panel.add(lblVotreSiege);
		lblVotreSiege.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 205, 170));
		panel_3.setBounds(901, 598, 437, 316);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblDejaReserveEt = new JLabel("D\u00E9ja R\u00E9serv\u00E9 ! vous voulez Annuler votre Vol?");
		lblDejaReserveEt.setBounds(20, 13, 405, 34);
		panel_3.add(lblDejaReserveEt);
		lblDejaReserveEt.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		
		
		txt_nume_Passeport_Annuler = new JTextField();
		
		///************************** Focus Lost et Focus Grained **************************/
		txt_nume_Passeport_Annuler.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txt_nume_Passeport_Annuler.getText().trim().toLowerCase().equals("numero de votre passeport")){
					txt_nume_Passeport_Annuler.setText("");
					txt_nume_Passeport_Annuler.setForeground(Color.black);
			        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_nume_Passeport_Annuler.getText().trim().equals("") || 
						txt_nume_Passeport_Annuler.getText().trim().toLowerCase().equals("numero de votre passeport"))
			        {
			            
					txt_nume_Passeport_Annuler.setText("numero de votre passeport");
					txt_nume_Passeport_Annuler.setForeground(new Color (153,153,153));
			        
			        }
			}
		});
		
		
		
		txt_nume_Passeport_Annuler.setBounds(12, 200, 211, 40);
		panel_3.add(txt_nume_Passeport_Annuler);
		txt_nume_Passeport_Annuler.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_nume_Passeport_Annuler.setText("Numero de votre Passeport");
		txt_nume_Passeport_Annuler.setColumns(10);
		
		
		////*************   Annuler le Voles /****
		JButton btnAnulerMonVol = new JButton("Annuler Mon Vol");
		btnAnulerMonVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String passeport=txt_nume_Passeport_Annuler.getText();
				
				
				/////   Delete from table de Reservations
				String sql="delete from vols_traveler_reserve where Numero_Passeport='"+passeport+"'";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					PreparedStatement preparedStatement=connection.prepareStatement(sql);
					preparedStatement.execute();
					//JOptionPane.showMessageDialog(null,"Votre Vol a été bien Annulé");
					connection.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				  /*   Or
				///  Delete From Table Voyageurs
				 */				
				String sql2="delete from voyageur where NumeroPassport='"+passeport+"'";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					PreparedStatement preparedStatement=connection.prepareStatement(sql2);
					preparedStatement.execute();
					JOptionPane.showMessageDialog(null,"Votre Vol a été bien Annulé");
					connection.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				

				
				
			}
		});		
		btnAnulerMonVol.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnulerMonVol.setBounds(247, 196, 190, 44);
		panel_3.add(btnAnulerMonVol);
		btnAnulerMonVol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Date limite  10 jours");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_1.setBounds(106, 101, 222, 25);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(32, 178, 170));
		panel_4.setBounds(1350, 32, 538, 3);
		panel.add(panel_4);
		panel_4.setLayout(null);
        
		/*******************************  Sotir de L'Application ************/
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frmloginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmloginSystem,"voulez vous quitter l'Application?","Reservation biellet",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					    System.exit(0);
				};
			}
		});
		
		
		//*******************************************************/
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(1795, 0, 97, 36);
		panel.add(btnNewButton_1);
		
		
		//////////////////****************  Vider Les Champs
		JButton btnNewButton = new JButton("Vider Les Champs");
		btnNewButton.setBounds(630, 753, 215, 44);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txt_Nom_Voyageur.setText(null);
				txt_Prenom_voyageur.setText(null);
			    textField_Mail.setText(null);
				txt_CIN_Voyageur.setText(null);
				txt_Passeport_Voyageur.setText(null);
				textField_phone.setText(null);
				textField_Num_Siege.setText(null);
				
			}
		});		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setOpaque(false);		
		///////////////*******************   Tout les Vols disponnibles
		JButton btnNewButton_2 = new JButton("Tout les Vols");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 Statement stmt=connection.createStatement();
					 String  sql1="Select * from vol  ";
					 ResultSet resultSet=stmt.executeQuery(sql1);
					 table_Vols_Disponibles.setModel(DbUtils.resultSetToTableModel(resultSet));
			         
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
		/////************************
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(545, 101, 146, 34);
		panel.add(btnNewButton_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(32, 178, 170));
		panel_5.setBounds(1888, 32, 4, 947);
		panel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(32, 178, 170));
		panel_6.setBounds(1350, 976, 542, 3);
		panel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(1376, 160, 482, 806);
		panel.add(panel_7);
		panel_7.setLayout(null);	
		////////////////////////////////////////////////
		JButton A1 = new JButton("A-1");
		A1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		A1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					A1.setBackground(Color.RED);
					String siege=A1.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		A1.setBounds(12, 13, 45, 25);
		panel_7.add(A1);		
		JButton A2 = new JButton("A-2");
		A2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					A2.setBackground(Color.RED);
					String siege=A2.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});	
		A2.setBounds(12, 58, 45, 25);
		panel_7.add(A2);	
		JButton A3 = new JButton("A-3");
		A3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					A3.setBackground(Color.RED);
					String siege=A3.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		A3.setBounds(12, 102, 45, 25);
		panel_7.add(A3);	
		JButton B1 = new JButton("B-1");
		B1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					B1.setBackground(Color.RED);
					String siege=B1.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		B1.setBounds(73, 13, 45, 25);
		panel_7.add(B1);	
		JButton B2 = new JButton("B-2");
		B2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					B2.setBackground(Color.RED);
					String siege=B2.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		B2.setBounds(73, 58, 45, 25);
		panel_7.add(B2);	
		JButton B3 = new JButton("B-3");
		B3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					B3.setBackground(Color.RED);
					String siege=B3.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		B3.setBounds(73, 102, 45, 25);
		panel_7.add(B3);
		
		JButton C2 = new JButton("C-2");
		C2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					C2.setBackground(Color.RED);
					String siege=C2.getText();
					textField_Num_Siege.setText(siege);
					
				}

			}
		});
		C2.setBounds(141, 58, 45, 25);
		panel_7.add(C2);
		
		JButton C3 = new JButton("C-3");
		C3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					C3.setBackground(Color.RED);
					String siege=C3.getText();
					textField_Num_Siege.setText(siege);
				}

			}
		});
		C3.setBounds(141, 102, 45, 25);
		panel_7.add(C3);
		
		JButton F1 = new JButton("F-1");
		F1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		F1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					F1.setBackground(Color.RED);
					String siege=F1.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		F1.setBounds(425, 13, 45, 25);
		panel_7.add(F1);
		
		JButton E1 = new JButton("E-1");
		E1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		E1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					E1.setBackground(Color.RED);
					String siege=E1.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		E1.setBounds(353, 13, 45, 25);
		panel_7.add(E1);
		
		JButton D1 = new JButton("D-1");
		D1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					D1.setBackground(Color.RED);
					String siege=D1.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		D1.setBounds(281, 13, 45, 25);
		panel_7.add(D1);
		
		JButton D2 = new JButton("D-2");
		D2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					D2.setBackground(Color.RED);
					String siege=D2.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		D2.setBounds(281, 58, 45, 25);
		panel_7.add(D2);
		
		JButton E2 = new JButton("E-2");
		E2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		E2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					E2.setBackground(Color.RED);
					String siege=E2.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		E2.setBounds(353, 58, 45, 25);
		panel_7.add(E2);
		
		JButton F2 = new JButton("F-2");
		F2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		F2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					F2.setBackground(Color.RED);
					String siege=F2.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		F2.setBounds(425, 58, 45, 25);
		panel_7.add(F2);
		
		JButton D3 = new JButton("D-3");
		D3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					D3.setBackground(Color.RED);
					String siege=D3.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		D3.setBounds(281, 102, 45, 25);
		panel_7.add(D3);
		
		JButton E3 = new JButton("E-3");
		E3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		E3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					E3.setBackground(Color.RED);
					String siege=E3.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		E3.setBounds(353, 102, 45, 25);
		panel_7.add(E3);
		
		JButton F3 = new JButton("F-3");
		F3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		F3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					F3.setBackground(Color.RED);
					String siege=F3.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		F3.setBounds(425, 102, 45, 25);
		panel_7.add(F3);
		
		JButton D4 = new JButton("D-4");
		D4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					D4.setBackground(Color.RED);
					String siege=D4.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		D4.setBounds(281, 150, 45, 25);
		panel_7.add(D4);
		
		JButton E4 = new JButton("E-4");
		E4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		E4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					E4.setBackground(Color.RED);
					String siege=E4.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		E4.setBounds(353, 150, 45, 25);
		panel_7.add(E4);
		
		JButton F4 = new JButton("F-4");
		F4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		F4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					F4.setBackground(Color.RED);
					String siege=F4.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		F4.setBounds(425, 150, 45, 25);
		panel_7.add(F4);
		
		JButton D5 = new JButton("D-5");
		D5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					D5.setBackground(Color.RED);
					String siege=D5.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		D5.setBounds(281, 198, 45, 25);
		panel_7.add(D5);
		
		JButton E5 = new JButton("E-5");
		E5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		E5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					E5.setBackground(Color.RED);
					String siege=E5.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		E5.setBounds(353, 198, 45, 25);
		panel_7.add(E5);
		
		JButton F5 = new JButton("F-5");
		F5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		F5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					F5.setBackground(Color.RED);
					String siege=F5.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		F5.setBounds(425, 198, 45, 25);
		panel_7.add(F5);
		
		JButton C4 = new JButton("C-4");
		C4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					C4.setBackground(Color.RED);
					String siege=C4.getText();
					textField_Num_Siege.setText(siege);
				}

			}
		});
		C4.setBounds(141, 150, 45, 25);
		panel_7.add(C4);
		
		JButton B4 = new JButton("B_4");
		B4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					B4.setBackground(Color.RED);
					String siege=B4.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		B4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		B4.setBounds(73, 150, 45, 25);
		panel_7.add(B4);
		
		
		
		JButton A4 = new JButton("A-4");
		A4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					A4.setBackground(Color.RED);
					String siege=A4.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		A4.setBounds(12, 150, 45, 25);
		panel_7.add(A4);
		
		
		
		JButton C5 = new JButton("C-5");
		C5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					C5.setBackground(Color.RED);
					String siege=C5.getText();
					textField_Num_Siege.setText(siege);
				}

			}
		});
		C5.setBounds(141, 198, 45, 25);
		panel_7.add(C5);
		
		JButton B5 = new JButton("B-5");
		B5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					B5.setBackground(Color.RED);
					String siege=B5.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		B5.setBounds(73, 198, 45, 25);
		panel_7.add(B5);	
		JButton A5 = new JButton("A-5");
		A5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					A5.setBackground(Color.RED);
					String siege=A5.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		A5.setBounds(12, 198, 45, 25);
		panel_7.add(A5);
		
		
		
		
		JButton A6 = new JButton("A-6");
		A6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					A6.setBackground(Color.RED);
					String siege=A6.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		A6.setBounds(12, 249, 45, 25);
		panel_7.add(A6);
		
		JButton B6 = new JButton("B-6");
		B6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					B6.setBackground(Color.RED);
					String siege=B6.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		B6.setBounds(73, 249, 45, 25);
		panel_7.add(B6);
		
		
		
		JButton C6 = new JButton("C-6");
		C6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					C6.setBackground(Color.RED);
					String siege=C6.getText();
					textField_Num_Siege.setText(siege);
				}

			}
		});
		C6.setBounds(141, 249, 45, 25);
		panel_7.add(C6);
		
		JButton D6 = new JButton("D-6");
		D6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					D5.setBackground(Color.RED);
					String siege=D5.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		D6.setBounds(281, 249, 45, 25);
		panel_7.add(D6);
		
		JButton E6 = new JButton("E-6");
		E6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		E6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					E6.setBackground(Color.RED);
					String siege=E6.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		E6.setBounds(353, 249, 45, 25);
		panel_7.add(E6);
		
		JButton F6 = new JButton("F-6");
		F6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		F6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					F6.setBackground(Color.RED);
					String siege=F6.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		F6.setBounds(425, 249, 45, 25);
		panel_7.add(F6);
		
		
		
		JButton A7 = new JButton("A-7");
		A7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					A7.setBackground(Color.RED);
					String siege=A7.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		A7.setBounds(12, 302, 45, 25);
		panel_7.add(A7);		
		JButton B7 = new JButton("B-7");
		B7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					B7.setBackground(Color.RED);
					String siege=B7.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		B7.setBounds(73, 302, 45, 25);
		panel_7.add(B7);
		
		
		
		JButton C7 = new JButton("C-7");
		C7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					C7.setBackground(Color.RED);
					String siege=C7.getText();
					textField_Num_Siege.setText(siege);
				}

			}
		});
		C7.setBounds(141, 302, 45, 25);
		panel_7.add(C7);
		
		JButton D7 = new JButton("D-7");
		D7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					D7.setBackground(Color.RED);
					String siege=D7.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		D7.setBounds(281, 302, 45, 25);
		panel_7.add(D7);
		
		JButton E7 = new JButton("E-7");
		E7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		E7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					E7.setBackground(Color.RED);
					String siege=E7.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		E7.setBounds(353, 302, 45, 25);
		panel_7.add(E7);
		
		JButton F7 = new JButton("F-7");
		F7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		F7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					F7.setBackground(Color.RED);
					String siege=F7.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		F7.setBounds(425, 302, 45, 25);
		panel_7.add(F7);
		
		
		
		JButton A8 = new JButton("A-8");
		A8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					A8.setBackground(Color.RED);
					String siege=A8.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		A8.setBounds(12, 359, 45, 25);
		panel_7.add(A8);		
		JButton B8 = new JButton("B-8");
		B8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					B8.setBackground(Color.RED);
					String siege=B8.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		B8.setBounds(73, 359, 45, 25);
		panel_7.add(B8);		
		JButton C8 = new JButton("C-8");
		C8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					C8.setBackground(Color.RED);
					String siege=C8.getText();
					textField_Num_Siege.setText(siege);
				}

			}
		});
		C8.setBounds(141, 359, 45, 25);
		panel_7.add(C8);
		
		JButton D8 = new JButton("D-8");
		D8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					D7.setBackground(Color.RED);
					String siege=D7.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		D8.setBounds(281, 359, 45, 25);
		panel_7.add(D8);
		
		JButton E8 = new JButton("E-8");
		E8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		E8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					E8.setBackground(Color.RED);
					String siege=E8.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		E8.setBounds(353, 359, 45, 25);
		panel_7.add(E8);
		
		JButton F8 = new JButton("F-8");
		F8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		F8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					F8.setBackground(Color.RED);
					String siege=F8.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		F8.setBounds(425, 359, 45, 25);
		panel_7.add(F8);
		
		
		
		JButton A9 = new JButton("A-9");
		A9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					A9.setBackground(Color.RED);
					String siege=A9.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		A9.setBounds(12, 412, 45, 25);
		panel_7.add(A9);
		
		
		
		JButton B9 = new JButton("B-9");
		B9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					B9.setBackground(Color.RED);
					String siege=B9.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		B9.setBounds(73, 412, 45, 25);
		panel_7.add(B9);
		
		
		
		C9 = new JButton("C-9");
		C9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					C9.setBackground(Color.RED);
					String siege=C9.getText();
					textField_Num_Siege.setText(siege);
				}

			}
		});
		C9.setBounds(141, 412, 45, 25);
		panel_7.add(C9);
		
		JButton D9 = new JButton("D-9");
		D9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					D9.setBackground(Color.RED);
					String siege=D9.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		D9.setBounds(281, 412, 45, 25);
		panel_7.add(D9);
		
		JButton E9 = new JButton("E-9");
		E9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		E9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					E9.setBackground(Color.RED);
					String siege=E9.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		E9.setBounds(353, 412, 45, 25);
		panel_7.add(E9);
		
		JButton F9 = new JButton("F-9");
		F9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		F9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					F9.setBackground(Color.RED);
					String siege=F9.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		F9.setBounds(425, 412, 45, 25);
		panel_7.add(F9);
		
		
		
		JButton A10 = new JButton("A-10");
		A10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					A10.setBackground(Color.RED);
					String siege=A10.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		A10.setBounds(12, 463, 45, 25);
		panel_7.add(A10);
		
		
		
		JButton B10 = new JButton("B-10");
		B10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					B10.setBackground(Color.RED);
					String siege=B10.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		B10.setBounds(73, 463, 45, 25);
		panel_7.add(B10);
		
		
		
		JButton C10 = new JButton("C-10");
		C10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					C10.setBackground(Color.RED);
					String siege=C10.getText();
					textField_Num_Siege.setText(siege);
				}

			}
		});
		C10.setBounds(141, 463, 45, 25);
		panel_7.add(C10);
		
		JButton D10 = new JButton("D-10");
		D10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					D10.setBackground(Color.RED);
					String siege=D10.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		D10.setBounds(281, 463, 45, 25);
		panel_7.add(D10);
		
		JButton E10 = new JButton("E-10");
		E10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		E10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					E10.setBackground(Color.RED);
					String siege=E10.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		E10.setBounds(353, 463, 45, 25);
		panel_7.add(E10);
		
		JButton F10 = new JButton("F-10");
		F10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		F10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					F10.setBackground(Color.RED);
					String siege=F10.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		F10.setBounds(425, 463, 45, 25);
		panel_7.add(F10);
		
		JButton A11 = new JButton("A-11");
		A11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					A11.setBackground(Color.RED);
					String siege=A11.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		A11.setBounds(12, 516, 45, 25);
		panel_7.add(A11);
		
		JButton B11 = new JButton("B-11");
		B11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					B11.setBackground(Color.RED);
					String siege=B11.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		
		
		B11.setBounds(73, 516, 45, 25);
		panel_7.add(B11);
		
		JButton C11 = new JButton("C-11");
		C11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					C11.setBackground(Color.RED);
					String siege=C11.getText();
					textField_Num_Siege.setText(siege);
				}

			}
		});
		C11.setBounds(141, 516, 45, 25);
		panel_7.add(C11);
		
		JButton D11 = new JButton("D-11");
		D11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					D11.setBackground(Color.RED);
					String siege=D11.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		D11.setBounds(281, 516, 45, 25);
		panel_7.add(D11);
		
		JButton E11 = new JButton("E-11");
		E11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		E11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					E11.setBackground(Color.RED);
					String siege=E11.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		E11.setBounds(353, 516, 45, 25);
		panel_7.add(E11);
		
		JButton F11 = new JButton("F-11");
		F11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		F11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					F11.setBackground(Color.RED);
					String siege=F11.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		F11.setBounds(425, 516, 45, 25);
		panel_7.add(F11);
		
		
		
		JButton A12 = new JButton("A-12");
		A12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					A12.setBackground(Color.RED);
					String siege=A12.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		A12.setBounds(12, 571, 45, 25);
		panel_7.add(A12);		
		JButton B12 = new JButton("B-12");
		B12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					B12.setBackground(Color.RED);
					String siege=B12.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		B12.setBounds(73, 571, 45, 25);
		panel_7.add(B12);		
		JButton C12 = new JButton("C-12");
		C12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					C12.setBackground(Color.RED);
					String siege=C12.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		C12.setBounds(141, 571, 45, 25);
		panel_7.add(C12);
		
		JButton D12 = new JButton("D-12");
		D12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					D12.setBackground(Color.RED);
					String siege=D12.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		D12.setBounds(281, 571, 45, 25);
		panel_7.add(D12);
		
		JButton E12 = new JButton("E-12");
		E12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		E12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					E12.setBackground(Color.RED);
					String siege=E12.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		E12.setBounds(353, 571, 45, 25);
		panel_7.add(E12);
		
		JButton F12 = new JButton("F-12");
		F12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		F12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					F12.setBackground(Color.RED);
					String siege=F12.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		F12.setBounds(425, 571, 45, 25);
		panel_7.add(F12);		
		JButton A13 = new JButton("A-13");
		A13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					A13.setBackground(Color.RED);
					String siege=A13.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		A13.setBounds(12, 621, 45, 25);
		panel_7.add(A13);
		
		
		
		JButton B13 = new JButton("B-13");
		B13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					B13.setBackground(Color.RED);
					String siege=B13.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		B13.setBounds(73, 621, 45, 25);
		panel_7.add(B13);
		
		
		
		JButton C13 = new JButton("C-13");
		C13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					C13.setBackground(Color.RED);
					String siege=C13.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		C13.setBounds(141, 621, 45, 25);
		panel_7.add(C13);
		
		JButton D13 = new JButton("D-13");
		D13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					D13.setBackground(Color.RED);
					String siege=D13.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		D13.setBounds(281, 621, 45, 25);
		panel_7.add(D13);
		
		JButton E13 = new JButton("E-13");
		E13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		E13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					E13.setBackground(Color.RED);
					String siege=E13.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		E13.setBounds(353, 621, 45, 25);
		panel_7.add(E13);
		
		JButton F13 = new JButton("F-13");
		F13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		F13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					F13.setBackground(Color.RED);
					String siege=F13.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		F13.setBounds(425, 621, 45, 25);
		panel_7.add(F13);
		
		
		
		JButton A14 = new JButton("A-14");
		A14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					A14.setBackground(Color.RED);
					String siege=A14.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		A14.setBounds(12, 665, 45, 25);
		panel_7.add(A14);
		
		
		
		
		JButton B14 = new JButton("B-14");
		B14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					B14.setBackground(Color.RED);
					String siege=B14.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		B14.setBounds(73, 665, 45, 25);
		panel_7.add(B14);
		
		
		
		JButton C14 = new JButton("C-14");
		C14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					C14.setBackground(Color.RED);
					String siege=C14.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		C14.setBounds(141, 665, 45, 25);
		panel_7.add(C14);	
		JButton D14 = new JButton("D-14");
		D14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					D14.setBackground(Color.RED);
					String siege=D14.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		D14.setBounds(281, 665, 45, 25);
		panel_7.add(D14);
		
		JButton E14 = new JButton("E-14");
		E14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		E14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					E14.setBackground(Color.RED);
					String siege=E14.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		E14.setBounds(353, 665, 45, 25);
		panel_7.add(E14);
		
		JButton F14 = new JButton("F-14");
		F14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		F14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					F14.setBackground(Color.RED);
					String siege=F14.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		F14.setBounds(425, 665, 45, 25);
		panel_7.add(F14);
		
		JLabel lblNewLabel_2 = new JLabel("1");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(220, 22, 38, 16);
		panel_7.add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel("2");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(220, 58, 38, 16);
		panel_7.add(label_1);
		
		JLabel label_2 = new JLabel("3");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(220, 102, 38, 16);
		panel_7.add(label_2);
		
		JLabel label_3 = new JLabel("4");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(220, 150, 38, 16);
		panel_7.add(label_3);
		
		JLabel label_4 = new JLabel("5");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(220, 196, 38, 16);
		panel_7.add(label_4);
		
		JLabel label_5 = new JLabel("6");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(220, 258, 38, 16);
		panel_7.add(label_5);
		
		JLabel label_6 = new JLabel("7");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(220, 311, 38, 16);
		panel_7.add(label_6);
		
		JLabel label_7 = new JLabel("8");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(220, 359, 38, 16);
		panel_7.add(label_7);
		
		JLabel label_8 = new JLabel("9");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(220, 421, 38, 16);
		panel_7.add(label_8);
		
		JLabel label_9 = new JLabel("10");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_9.setBounds(220, 472, 38, 16);
		panel_7.add(label_9);
		
		JLabel label_10 = new JLabel("11");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_10.setBounds(220, 525, 38, 16);
		panel_7.add(label_10);
		
		JLabel label_11 = new JLabel("12");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_11.setBounds(220, 580, 38, 16);
		panel_7.add(label_11);
		
		JLabel label_12 = new JLabel("13");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_12.setBounds(220, 630, 38, 16);
		panel_7.add(label_12);
		
		JLabel label_13 = new JLabel("14");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_13.setBounds(220, 674, 38, 16);
		panel_7.add(label_13);
		
		JButton A15 = new JButton("A-15");
		A15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					A15.setBackground(Color.RED);
					String siege=A15.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		A15.setBounds(12, 710, 45, 25);
		panel_7.add(A15);
		JButton B15 = new JButton("B-15");
		B15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					B15.setBackground(Color.RED);
					String siege=B15.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		B15.setBounds(73, 710, 45, 25);
		panel_7.add(B15);	
		JButton C15 = new JButton("C-15");
		C15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					C15.setBackground(Color.RED);
					String siege=C15.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		C15.setBounds(141, 710, 45, 25);
		panel_7.add(C15);
		
		JButton D15 = new JButton("D-15");
		D15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					D15.setBackground(Color.RED);
					String siege=D15.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		D15.setBounds(281, 710, 45, 25);
		panel_7.add(D15);
		
		JButton E15 = new JButton("E-15");
		E15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		E15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					E15.setBackground(Color.RED);
					String siege=E15.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		E15.setBounds(353, 710, 45, 25);
		panel_7.add(E15);
		
		JButton F15 = new JButton("F-15");
		F15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		F15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					F15.setBackground(Color.RED);
					String siege=F15.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		F15.setBounds(425, 710, 45, 25);
		panel_7.add(F15);
		
		
		
		JButton A16 = new JButton("A-16");
		A16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		A16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					A16.setBackground(Color.RED);
					String siege=A16.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		A16.setBounds(12, 755, 45, 25);
		panel_7.add(A16);
		
		
		
		
		JButton B16 = new JButton("B-16");
		B16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		B16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					B16.setBackground(Color.RED);
					String siege=B16.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		B16.setBounds(73, 755, 45, 25);
		panel_7.add(B16);
		
		JButton C16 = new JButton("C-16");
		C16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					C16.setBackground(Color.RED);
					String siege=C16.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		C16.setBounds(141, 755, 45, 25);
		panel_7.add(C16);
		
		JButton D16 = new JButton("D-16");
		D16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		D16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					D16.setBackground(Color.RED);
					String siege=D16.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		D16.setBounds(281, 755, 45, 25);
		panel_7.add(D16);
		
		JButton E16 = new JButton("E-16");
		E16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		E16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					E16.setBackground(Color.RED);
					String siege=E16.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		E16.setBounds(353, 755, 45, 25);
		panel_7.add(E16);
		
		JButton F16 = new JButton("F-16");
		F16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		F16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					F1.setBackground(Color.RED);
					String siege=F16.getText();
					textField_Num_Siege.setText(siege);
				}
			}
		});
		F16.setBounds(425, 755, 45, 25);
		panel_7.add(F16);
		
		JLabel label_14 = new JLabel("15");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_14.setBounds(220, 719, 38, 16);
		panel_7.add(label_14);
		
		JLabel label_15 = new JLabel("16");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_15.setBounds(220, 764, 38, 16);
		panel_7.add(label_15);
		
		
		JButton C1 = new JButton("C-1");
		C1.setBounds(141, 13, 45, 25);
		panel_7.add(C1);
		C1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ce siege?","Choix de Siege", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					C1.setBackground(Color.RED);
					String siege=C1.getText();
					textField_Num_Siege.setText(siege);
					
				}
			}
		});
		
		JLabel lblA = new JLabel("A");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblA.setBounds(1398, 121, 25, 16);
		panel.add(lblA);
		
		JLabel lblB = new JLabel("B");
		lblB.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblB.setBounds(1465, 121, 25, 16);
		panel.add(lblB);
		
		JLabel lblC = new JLabel("C");
		lblC.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblC.setBounds(1538, 121, 25, 16);
		panel.add(lblC);
		
		JLabel lblD = new JLabel("D");
		lblD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblD.setBounds(1670, 121, 25, 16);
		panel.add(lblD);
		
		JLabel lblE = new JLabel("E");
		lblE.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblE.setBounds(1746, 121, 25, 16);
		panel.add(lblE);
		
		JLabel lblF = new JLabel("F");
		lblF.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblF.setBounds(1822, 121, 25, 16);
		panel.add(lblF);
		
		
		////Focus Lost wt Grained
		textField_Num_Siege = new JTextField();
		textField_Num_Siege.setEditable(false);
		textField_Num_Siege.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_Num_Siege.setColumns(10);
		textField_Num_Siege.setBounds(630, 680, 215, 40);
		panel.add(textField_Num_Siege);
		
		//////////***** Les Siege deja Reserves seront en Green
		JButton btnNewButton_siegeDispo = new JButton("Siege Disponibles");
		btnNewButton_siegeDispo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {    
			         try {
			        	 
			        	 Class.forName("com.mysql.jdbc.Driver");
						 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
						 String sql="Select siege from sieges where id_vol='"+txt_ID_Vol.getText()+"'";
						 PreparedStatement preparedStatement=connection.prepareStatement(sql);
					     ResultSet resultSet =preparedStatement.executeQuery(sql);	 
						 while(resultSet.next()) {
							 String NBsiege=resultSet.getString("siege");
							 ///// Siege A
							 if(A1.getText().equals(NBsiege)) {A1.setBackground(Color.green);}
							 if(A2.getText().equals(NBsiege)) {A2.setBackground(Color.green);}
							 if(A3.getText().equals(NBsiege)) {A3.setBackground(Color.green);}
							 if(A4.getText().equals(NBsiege)) {A4.setBackground(Color.green);}
							 if(A5.getText().equals(NBsiege)) {A5.setBackground(Color.green);}
							 if(A6.getText().equals(NBsiege)) {A6.setBackground(Color.green);}
							 if(A7.getText().equals(NBsiege)) {A7.setBackground(Color.green);}
							 if(A8.getText().equals(NBsiege)) {A8.setBackground(Color.green);}
							 if(A9.getText().equals(NBsiege)) {A9.setBackground(Color.green);}
							 if(A10.getText().equals(NBsiege)){A10.setBackground(Color.green);}
							 if(A11.getText().equals(NBsiege)) {A11.setBackground(Color.green);}
							 if(A12.getText().equals(NBsiege)) {A12.setBackground(Color.green);}
							 if(A13.getText().equals(NBsiege)) {A13.setBackground(Color.green);}
							 if(A14.getText().equals(NBsiege)) {A14.setBackground(Color.green);}
							 if(A15.getText().equals(NBsiege)) {A15.setBackground(Color.green);}
							 if(A16.getText().equals(NBsiege)) {A16.setBackground(Color.green);}
							 //// Siege B
							 if(B1.getText().equals(NBsiege)) {B1.setBackground(Color.green);}
							 if(B2.getText().equals(NBsiege)) {B2.setBackground(Color.green);}
							 if(B3.getText().equals(NBsiege)) {B3.setBackground(Color.green);}
							 if(B4.getText().equals(NBsiege)) {B4.setBackground(Color.green);}
							 if(B5.getText().equals(NBsiege)) {B5.setBackground(Color.green);}
							 if(B6.getText().equals(NBsiege)) {B6.setBackground(Color.green);}
							 if(B7.getText().equals(NBsiege)) {B7.setBackground(Color.green);}
							 if(B8.getText().equals(NBsiege)) {B8.setBackground(Color.green);}
							 if(B9.getText().equals(NBsiege)) {B9.setBackground(Color.green);}
							 if(B10.getText().equals(NBsiege)) {B10.setBackground(Color.green);}
							 if(B11.getText().equals(NBsiege)) {B12.setBackground(Color.green);}
							 if(B13.getText().equals(NBsiege)) {B13.setBackground(Color.green);}
							 if(B14.getText().equals(NBsiege)) {B14.setBackground(Color.green);}
							 if(B15.getText().equals(NBsiege)) {B15.setBackground(Color.green);}
							 if(B16.getText().equals(NBsiege)) {B16.setBackground(Color.green);}
							 ///// Siege C
							 if(C1.getText().equals(NBsiege)) {C1.setBackground(Color.green);}
							 if(C2.getText().equals(NBsiege)) {C2.setBackground(Color.green);}
							 if(C3.getText().equals(NBsiege)) {C3.setBackground(Color.green);}
							 if(C4.getText().equals(NBsiege)) {C4.setBackground(Color.green);}
							 if(C5.getText().equals(NBsiege)) {C5.setBackground(Color.green);}
							 if(C6.getText().equals(NBsiege)) {C6.setBackground(Color.green);}
							 if(C7.getText().equals(NBsiege)) {C7.setBackground(Color.green);}
							 if(C8.getText().equals(NBsiege)) {C8.setBackground(Color.green);}
							 if(C9.getText().equals(NBsiege)) {C9.setBackground(Color.green);}
							 if(C10.getText().equals(NBsiege)){C10.setBackground(Color.green);}
							 if(C11.getText().equals(NBsiege)) {C11.setBackground(Color.green);}
							 if(C12.getText().equals(NBsiege)) {C12.setBackground(Color.green);}
							 if(C13.getText().equals(NBsiege)) {C13.setBackground(Color.green);}
							 if(C14.getText().equals(NBsiege)) {C14.setBackground(Color.green);}
							 if(C15.getText().equals(NBsiege)) {C15.setBackground(Color.green);}
							 if(C16.getText().equals(NBsiege)) {C6.setBackground(Color.green);}
							 /// Siege D
							 if(D1.getText().equals(NBsiege)) {D1.setBackground(Color.green);}
							 if(D2.getText().equals(NBsiege)) {D2.setBackground(Color.green);}
							 if(D3.getText().equals(NBsiege)) {D3.setBackground(Color.green);}
							 if(D4.getText().equals(NBsiege)) {D4.setBackground(Color.green);}
							 if(D5.getText().equals(NBsiege)) {D5.setBackground(Color.green);}
							 if(D6.getText().equals(NBsiege)) {D6.setBackground(Color.green);}
							 if(D7.getText().equals(NBsiege)) {D7.setBackground(Color.green);}
							 if(D8.getText().equals(NBsiege)) {D8.setBackground(Color.green);}
							 if(D9.getText().equals(NBsiege)) {D9.setBackground(Color.green);}
							 if(D10.getText().equals(NBsiege)) {D10.setBackground(Color.green);}
							 if(D11.getText().equals(NBsiege)) {D11.setBackground(Color.green);}
							 if(D12.getText().equals(NBsiege)) {D12.setBackground(Color.green);}
							 if(D13.getText().equals(NBsiege)) {D13.setBackground(Color.green);}
							 if(D14.getText().equals(NBsiege)) {D14.setBackground(Color.green);}
							 if(D15.getText().equals(NBsiege)) {D15.setBackground(Color.green);}
							 if(D16.getText().equals(NBsiege)) {D16.setBackground(Color.green);}
							 /////Siege E
							 if(E1.getText().equals(NBsiege)) {E1.setBackground(Color.green);}
							 if(E2.getText().equals(NBsiege)) {E2.setBackground(Color.green);}
							 if(E3.getText().equals(NBsiege)) {E3.setBackground(Color.green);}
							 if(E4.getText().equals(NBsiege)) {E4.setBackground(Color.green);}
							 if(E5.getText().equals(NBsiege)) {E5.setBackground(Color.green);}
							 if(E6.getText().equals(NBsiege)) {E6.setBackground(Color.green);}
							 if(E7.getText().equals(NBsiege)) {E7.setBackground(Color.green);}
							 if(E8.getText().equals(NBsiege)) {E8.setBackground(Color.green);}
							 if(E9.getText().equals(NBsiege)) {E9.setBackground(Color.green);}
							 if(E10.getText().equals(NBsiege)) {E10.setBackground(Color.green);}
							 if(E11.getText().equals(NBsiege)) {E11.setBackground(Color.green);}
							 if(E12.getText().equals(NBsiege)) {E12.setBackground(Color.green);}
							 if(E13.getText().equals(NBsiege)) {E13.setBackground(Color.green);}
							 if(E14.getText().equals(NBsiege)) {E14.setBackground(Color.green);}
							 if(E15.getText().equals(NBsiege)) {E15.setBackground(Color.green);}
							 if(E16.getText().equals(NBsiege)) {E16.setBackground(Color.green);}
							 //// Sige F
							 if(F1.getText().equals(NBsiege)) {F1.setBackground(Color.green);}
							 if(F2.getText().equals(NBsiege)) {F2.setBackground(Color.green);}
							 if(F3.getText().equals(NBsiege)) {F3.setBackground(Color.green);}
							 if(F4.getText().equals(NBsiege)) {F4.setBackground(Color.green);}
							 if(F5.getText().equals(NBsiege)) {F5.setBackground(Color.green);}
							 if(F6.getText().equals(NBsiege)) {F6.setBackground(Color.green);}
							 if(F7.getText().equals(NBsiege)) {F7.setBackground(Color.green);}
							 if(F8.getText().equals(NBsiege)) {F8.setBackground(Color.green);}
							 if(F9.getText().equals(NBsiege)) {F9.setBackground(Color.green);}
							 if(F10.getText().equals(NBsiege)) {F10.setBackground(Color.green);}
							 if(F11.getText().equals(NBsiege)) {F11.setBackground(Color.green);}
							 if(F12.getText().equals(NBsiege)) {F12.setBackground(Color.green);}
							 if(F13.getText().equals(NBsiege)) {F13.setBackground(Color.green);}
							 if(F14.getText().equals(NBsiege)) {F14.setBackground(Color.green);}
							 if(F15.getText().equals(NBsiege)) {F15.setBackground(Color.green);}
							 if(F16.getText().equals(NBsiege)) {F16.setBackground(Color.green);}
							 
						 }
						
					} catch (Exception e) {
						
					}
			}
		});	
		btnNewButton_siegeDispo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_siegeDispo.setBounds(1140, 110, 183, 33);
		panel.add(btnNewButton_siegeDispo);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(new Color(230, 230, 250));
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBounds(1387, 64, 36, 25);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Si\u00E8ge Disponible ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(1428, 73, 121, 16);
		panel.add(lblNewLabel);
		
		JButton button = new JButton("");
		button.setEnabled(false);
		button.setBackground(new Color(0, 255, 0));
		button.setBounds(1561, 64, 36, 25);
		panel.add(button);
		
		JLabel lblSigeOccup = new JLabel("si\u00E8ge Occup\u00E9");
		lblSigeOccup.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSigeOccup.setBounds(1609, 73, 103, 16);
		panel.add(lblSigeOccup);
		
		JButton button_1 = new JButton("");
		button_1.setEnabled(false);
		button_1.setBackground(new Color(255, 0, 0));
		button_1.setBounds(1714, 64, 36, 25);
		panel.add(button_1);
		
		JLabel lblVotreSige = new JLabel("Votre si\u00E8ge");
		lblVotreSige.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVotreSige.setBackground(new Color(255, 0, 0));
		lblVotreSige.setBounds(1773, 73, 103, 16);
		panel.add(lblVotreSige);
	}
}
