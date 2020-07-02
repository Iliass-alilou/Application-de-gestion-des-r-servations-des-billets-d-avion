package billet_avion;
//////////////////////////////// *************  Classe Pour Gestion des Voyageurs
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import javafx.scene.layout.Border;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Voyageur extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch_id_vol;
	private JTextField txtIdDeVoyageur;
	private JTable table_vol_voyageurs;
	
	
	// Fonction Pour Actualiser la table
	
	public void ActualiserTable_Voyageur() {
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
			 Statement stmt=connection.createStatement();
			 String  sql1="Select * from voyageur  ";
			 ResultSet resultSet=stmt.executeQuery(sql1);
			 table_vol_voyageurs.setModel(DbUtils.resultSetToTableModel(resultSet));
	         JOptionPane.showMessageDialog(null,"la table est mise à jour..... ");
			
		}catch(ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voyageur frame = new Voyageur();
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
	public Voyageur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1308, 819);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		///////////  Afficher les voyageur d'un vol par son id 
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		////////////*************
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setBounds(0, 0, 1280, 121);
		panel.add(panel_1);
		
		JLabel lblGestionDesVoyageurs = new JLabel("Gestion des Voyageurs");
		lblGestionDesVoyageurs.setForeground(new Color(255, 255, 224));
		lblGestionDesVoyageurs.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));
		lblGestionDesVoyageurs.setBounds(490, 30, 298, 37);
		panel_1.add(lblGestionDesVoyageurs);
		
		///// Allez sur les vols
		JButton buttonVols = new JButton("Vols");
		buttonVols.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonVols.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Administrateur_Gestion fr = new Administrateur_Gestion();
				fr.setVisible(true);
				dispose();
			}
		});
		
		////////////////////////////////
		buttonVols.setOpaque(false);
		buttonVols.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonVols.setBounds(12, 32, 127, 35);
		panel_1.add(buttonVols);
		
		////// Allez sur espace gestion Avions
		JButton btnAvions = new JButton("Avions");
		btnAvions.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAvions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Avion fr = new Avion();
				fr.setVisible(true);
				dispose();
			}
		});
		
		/////////////////////////
		btnAvions.setOpaque(false);
		btnAvions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAvions.setBounds(1114, 32, 133, 35);
		panel_1.add(btnAvions);
		
		JLabel label_1 = new JLabel("<< Aller sur");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(22, 75, 101, 16);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Aller sur >>");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(1136, 75, 101, 16);
		panel_1.add(label_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 330, 272, 436);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		
	  //  String idVol=txtSearch_id_vol.getText(); 
		
		
		//////////////************  Afficher tous les voyageur de tout les vols
		JButton btnNewButton_Tout_Voyageurs = new JButton("Tout les voyageurs");
		btnNewButton_Tout_Voyageurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
               try {
					
            	   Class.forName("com.mysql.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					Statement stmt=connection.createStatement();
					String  sql1="Select * from voyageur ";
					ResultSet resultSet=stmt.executeQuery(sql1);
					table_vol_voyageurs.setModel(DbUtils.resultSetToTableModel(resultSet));
					
					
				} catch (Exception e) {
					System.out.println("Probleme de chargement de donnees de la base de donnees");
				}
			}
		});
		
		
		
		
		btnNewButton_Tout_Voyageurs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_Tout_Voyageurs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Tout_Voyageurs.setBounds(0, 70, 266, 37);
		panel_2.add(btnNewButton_Tout_Voyageurs);
		
		
		///////**** ouvrire un jframe pour Ajouter un voyageur dans un vol
		JButton btnAjouterModifierUnVoyageur = new JButton("Ajouter/Modifier voyageur");
		btnAjouterModifierUnVoyageur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ajouter_Voyageur fr = new Ajouter_Voyageur();
				fr.setVisible(true);
				dispose();
			}
		});
		
		///////////////////
		btnAjouterModifierUnVoyageur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAjouterModifierUnVoyageur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAjouterModifierUnVoyageur.setBounds(0, 151, 266, 37);
		panel_2.add(btnAjouterModifierUnVoyageur);
		
	
		
		
		
		/////////************   Pour supprimer un voyageur du Table
		
		JButton btnSupprimerUnVoyageur = new JButton("Supprimer un voyageur");
		btnSupprimerUnVoyageur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int row =table_vol_voyageurs.getSelectedRow();
				String cell=table_vol_voyageurs.getModel().getValueAt(row, 0).toString();
				String sql="delete from voyageur where Id_voyageur="+cell;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					PreparedStatement preparedStatement=connection.prepareStatement(sql);
					preparedStatement.execute();
					JOptionPane.showMessageDialog(null,"Le voyageur a été bien supprimé");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
					
				
			}
		});
		
		
		
		
		
		
		btnSupprimerUnVoyageur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSupprimerUnVoyageur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSupprimerUnVoyageur.setBounds(0, 238, 266, 37);
		panel_2.add(btnSupprimerUnVoyageur);
		
		
		///////************Mettre a jour les voyageur d'un vol
		JButton btnMettreJour = new JButton("Mettre \u00E0 jour");
		btnMettreJour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualiserTable_Voyageur();
			}
		});
		
		
		
		btnMettreJour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMettreJour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMettreJour.setBounds(0, 318, 266, 37);
		panel_2.add(btnMettreJour);
		
		
		/////////////////****** Afficher les voyageurs d'un vol par son id
		txtSearch_id_vol = new JTextField();
		txtSearch_id_vol.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 String sql="select * from voyageur where id_vol=?";
					 PreparedStatement preparedStatement=connection.prepareStatement(sql);
					 preparedStatement.setString(1,txtSearch_id_vol.getText() );
					 ResultSet resultSet=preparedStatement.executeQuery();
					 table_vol_voyageurs.setModel(DbUtils.resultSetToTableModel(resultSet));
					 connection.close();
				} catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
        //////////Gaing lost
		txtSearch_id_vol.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtSearch_id_vol.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				 if(txtSearch_id_vol.getText().trim().toLowerCase().equals("entrer id de vol pour afficher les voyageurs de ce dernier")){
					 txtSearch_id_vol.setText("");
					 txtSearch_id_vol.setForeground(Color.black);
			        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtSearch_id_vol.getText().trim().equals("") || 
						txtSearch_id_vol.getText().trim().toLowerCase().equals("entrer id de vol pour afficher les voyageurs de ce dernier"))
			        {
			            
					txtSearch_id_vol.setText("entrer id de vol pour afficher les voyageurs de ce dernier");
					txtSearch_id_vol.setForeground(new Color (153,153,153));
			        
			        }
			}
		});
		
		////////////////////
		txtSearch_id_vol.setText("Entrer id de vol pour Afficher les voyageurs de ce dernier");
		txtSearch_id_vol.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSearch_id_vol.setBounds(348, 165, 466, 34);
		panel.add(txtSearch_id_vol);
		txtSearch_id_vol.setColumns(10);
		
		
        //////////  *************  Afficher UN voyageur par son id 
		txtIdDeVoyageur = new JTextField();
		txtIdDeVoyageur.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 String sql="select * from voyageur where Id_voyageur=?";
					 PreparedStatement preparedStatement=connection.prepareStatement(sql);
					 preparedStatement.setString(1,txtIdDeVoyageur.getText() );
					 ResultSet resultSet=preparedStatement.executeQuery();
					 table_vol_voyageurs.setModel(DbUtils.resultSetToTableModel(resultSet));
					 connection.close();
				} catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		
		
		
		/////////////// focus Gaind and lost  
		
		txtIdDeVoyageur.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				 if(txtIdDeVoyageur.getText().trim().toLowerCase().equals("id de voyageur")){
					 txtIdDeVoyageur.setText("");
					 txtIdDeVoyageur.setForeground(Color.black);
			        }
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtIdDeVoyageur.getText().trim().equals("") || 
						txtIdDeVoyageur.getText().trim().toLowerCase().equals("id de voyageur"))
			        {
			            
					txtIdDeVoyageur.setText("id de voyageur");
					txtIdDeVoyageur.setForeground(new Color (153,153,153));
			        
			        }
			}
		});
		
		///////////////
		txtIdDeVoyageur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtIdDeVoyageur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdDeVoyageur.setText("Id de voyageur");
		txtIdDeVoyageur.setBounds(348, 253, 243, 34);
		panel.add(txtIdDeVoyageur);
		txtIdDeVoyageur.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(348, 300, 920, 436);
		panel.add(scrollPane);
		
		table_vol_voyageurs = new JTable();
		scrollPane.setViewportView(table_vol_voyageurs);
	}
}
