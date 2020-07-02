package billet_avion;
///////////////////////////////////*******  Classe pour Gestion des Avions
import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Avion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtChercherPar_Company;
	private JTable table_Avion;
	private JTextField txtChercherUnAvion;
	
	
	// Fonction Pour Actualiser la table
	
		public void ActualiserTable_Avion() {
			try {
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
				 Statement stmt=connection.createStatement();
				 String  sql1="Select * from avion  ";
				 ResultSet resultSet=stmt.executeQuery(sql1);
				 table_Avion.setModel(DbUtils.resultSetToTableModel(resultSet));
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
					Avion frame = new Avion();
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
	
	
	public Avion() {
		/////   
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
			}
		});
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1194, 767);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setBounds(0, 0, 1166, 121);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion des Avions");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 224));
		lblNewLabel.setBounds(464, 30, 298, 37);
		panel_1.add(lblNewLabel);
		
		
		////////////////// Retour au gestion des vols
		JButton btnNewButton_Vol = new JButton("Vols");
		btnNewButton_Vol.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_Vol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Vol.setOpaque(false);
		btnNewButton_Vol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Administrateur_Gestion fr = new Administrateur_Gestion();
				fr.setVisible(true);
				dispose();
			}
		});
		
		/////////////////////////////
		
		btnNewButton_Vol.setBounds(27, 32, 127, 35);
		panel_1.add(btnNewButton_Vol);
		
		///////////////// Aller sur Gestion Voyageur 
		JButton btnNewButton_Voyageur = new JButton("Voyageur");
		btnNewButton_Voyageur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_Voyageur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Voyageur.setOpaque(false);
		btnNewButton_Voyageur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Voyageur fr1 = new Voyageur();
				fr1.setVisible(true);
				dispose();
			}
		});
		
		//////////////////////////
		btnNewButton_Voyageur.setBounds(1008, 34, 133, 35);
		panel_1.add(btnNewButton_Voyageur);
		
		JLabel lblNewLabel_1 = new JLabel("<< Aller sur");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(37, 75, 101, 16);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblAllerSur = new JLabel("Aller sur >>");
		lblAllerSur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAllerSur.setBounds(1028, 75, 101, 16);
		panel_1.add(lblAllerSur);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 257, 256, 382);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		/////////////******** Afficher tout les Les Avions disponibles dans la base de donnees 
		
		JButton btnNewButton_Tout_Avion = new JButton("Tout les Avions");
		btnNewButton_Tout_Avion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					Statement stmt=connection.createStatement();
					String  sql1="Select * from avion ";
					ResultSet resultSet=stmt.executeQuery(sql1);
					table_Avion.setModel(DbUtils.resultSetToTableModel(resultSet));
					
					
				} catch (Exception e) {
					System.out.println("Probleme de chargement de donnees de la base de donnees");
				}
			}
		});
		
		
		/////////////////////////////////////////////////
		btnNewButton_Tout_Avion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_Tout_Avion.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_Tout_Avion.setBounds(0, 73, 256, 38);
		panel_2.add(btnNewButton_Tout_Avion);
		
		
		///////////  ouvrire un autre Jframe pour Ajouter ou modifier un Avion 
		JButton btnAjouterModifierAvion = new JButton("Ajouter/Modiffier un Avion");
		btnAjouterModifierAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ajoutter_Avion fr1 = new Ajoutter_Avion();
				fr1.setVisible(true);
				dispose();
			}
		});
		//////////////
		btnAjouterModifierAvion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAjouterModifierAvion.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnAjouterModifierAvion.setBounds(0, 139, 256, 38);
		panel_2.add(btnAjouterModifierAvion);
		
		
		///////////***********  	Pour supprimer un Avion de la base de donnees
		JButton btnSupprimerUnAvion = new JButton("Supprimer un Avion");
		btnSupprimerUnAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row =table_Avion.getSelectedRow();
				String cell=table_Avion.getModel().getValueAt(row, 0).toString();
				//String sql="delete from vol where id_vol="+cell ;
				String sql="delete from avion where id_avion="+cell;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					PreparedStatement preparedStatement=connection.prepareStatement(sql);
					preparedStatement.execute();
					JOptionPane.showMessageDialog(null,"Le Vol de l'Id"+ cell+" a été bien Annulé");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}

				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					Statement stmt=connection.createStatement();
					String  sql1="Select * from avion ";
					ResultSet resultSet=stmt.executeQuery(sql1);
					table_Avion.setModel(DbUtils.resultSetToTableModel(resultSet));
					
					
				} catch (Exception e1) {
					System.out.println("Probleme de chargement de donnees de la base de donnees");
				}
			}
		});
		
		
		
		
		btnSupprimerUnAvion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSupprimerUnAvion.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSupprimerUnAvion.setBounds(0, 213, 256, 38);
		panel_2.add(btnSupprimerUnAvion);
		
		// Actualiser la table Avion
		
		JButton btnMettreJour = new JButton("Mettre \u00E0 jour");
		btnMettreJour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ActualiserTable_Avion();
			}
		});
		btnMettreJour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMettreJour.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnMettreJour.setBounds(0, 283, 256, 38);
		panel_2.add(btnMettreJour);
		
		
		
        /////////  Chercher les Avion d'une compagnie
		txtChercherPar_Company = new JTextField();
		txtChercherPar_Company.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 String sql="select * from avion where compagnie=?";
					 PreparedStatement preparedStatement=connection.prepareStatement(sql);
					 preparedStatement.setString(1,txtChercherPar_Company.getText() );
					 ResultSet resultSet=preparedStatement.executeQuery();
					 table_Avion.setModel(DbUtils.resultSetToTableModel(resultSet));
					 connection.close();
				} catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		
		
		
		
		///////////**********Focus Lost et Grained de recherche par company
		txtChercherPar_Company.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtChercherPar_Company.getText().trim().toLowerCase().equals("chercher un avion par sa compagnie")){
					txtChercherPar_Company.setText("");
					txtChercherPar_Company.setForeground(Color.black);
			        }
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if (txtChercherPar_Company.getText().trim().equals("") || 
						txtChercherPar_Company.getText().trim().toLowerCase().equals("chercher un avion par sa compagnie"))
			        {
			            
					txtChercherPar_Company.setText("chercher un avion par sa compagnie");
					txtChercherPar_Company.setForeground(new Color (153,153,153));
			        
			        }
			}
		});
		
		
		
		txtChercherPar_Company.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		txtChercherPar_Company.setText("Chercher un Avion par sa Compagnie");
		txtChercherPar_Company.setOpaque(false);
		txtChercherPar_Company.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		txtChercherPar_Company.setBounds(775, 210, 379, 33);
		panel.add(txtChercherPar_Company);
		txtChercherPar_Company.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel(">>");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(731, 213, 32, 25);
		panel.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(324, 257, 830, 415);
		panel.add(scrollPane);
		
		table_Avion = new JTable();
		scrollPane.setViewportView(table_Avion);
		
		
        /////////////////*** Focus Lost et Grained
		txtChercherUnAvion = new JTextField();
		txtChercherUnAvion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtChercherUnAvion.getText().trim().toLowerCase().equals("chercher un avion par son id")){
					txtChercherUnAvion.setText("");
					txtChercherUnAvion.setForeground(Color.black);
			        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtChercherUnAvion.getText().trim().equals("") || 
						txtChercherUnAvion.getText().trim().toLowerCase().equals("chercher un avion par son id"))
			        {
			            
					txtChercherUnAvion.setText("chercher un avion par son id");
					txtChercherUnAvion.setForeground(new Color (153,153,153));
			        
			        }
			}
		});
		
		///////////********  Chercher des Avions par nom de company ou leur id
		txtChercherUnAvion.setText("Chercher un Avion par son Id");
		txtChercherUnAvion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 String sql="select * from avion where 	id_avion=?";
					 PreparedStatement preparedStatement=connection.prepareStatement(sql);
					 preparedStatement.setString(1,txtChercherUnAvion.getText() );
					 ResultSet resultSet=preparedStatement.executeQuery();
					 table_Avion.setModel(DbUtils.resultSetToTableModel(resultSet));
					 connection.close();
				} catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		
		
		
		txtChercherUnAvion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		txtChercherUnAvion.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtChercherUnAvion.setOpaque(false);
		txtChercherUnAvion.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		txtChercherUnAvion.setBounds(360, 204, 303, 44);
		panel.add(txtChercherUnAvion);
		txtChercherUnAvion.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel(">>");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(324, 211, 41, 28);
		panel.add(lblNewLabel_5);
	}
}
