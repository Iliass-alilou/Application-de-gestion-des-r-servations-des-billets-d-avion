package billet_avion;
////////////////////////************************** Cette classe pour L'admin (Gestion des vols)
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.xml.ws.AsyncHandler;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Administrateur_Gestion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtChercherUnVol;
	private JTable table_Vols;
	private JTextField txtChercherHeurDepart;
	private JTextField txtChercherAeroportDepart;
	private JTextField txtChercherAeroportArrivee;
	
	// Fonction Pour Actualiser la table
	
			public void ActualiserTable_Vol() {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 Statement stmt=connection.createStatement();
					 String  sql1="Select * from vol  ";
					 ResultSet resultSet=stmt.executeQuery(sql1);
					 table_Vols.setModel(DbUtils.resultSetToTableModel(resultSet));
			         JOptionPane.showMessageDialog(null,"la table est mise à jour..... ");
					
				}catch(ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				}
			
			///////////////////////////Pour afficher tout les Vols disponible
			public void ActualiserTable_Vol1() {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 Statement stmt=connection.createStatement();
					 String  sql1="Select * from vol  ";
					 ResultSet resultSet=stmt.executeQuery(sql1);
					 table_Vols.setModel(DbUtils.resultSetToTableModel(resultSet));
			         
					 connection.close();
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
					Administrateur_Gestion frame = new Administrateur_Gestion();
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
	public Administrateur_Gestion() {
		setTitle("g\u00E9rer les vols");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1452, 902);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.setBounds(0, 0, 580, 26);
		panel.add(menuBar);
		
		
		 
		////////////////oubrire la gestion des voyageurs
		JMenuItem mntmNewMenuItem_Voyageur = new JMenuItem(" Voyageur");
		mntmNewMenuItem_Voyageur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Voyageur fr = new Voyageur();
				fr.setVisible(true);
				dispose();
			}
		});
		
		//////////////////////////////////
		
		
		
		mntmNewMenuItem_Voyageur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmNewMenuItem_Voyageur.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		menuBar.add(mntmNewMenuItem_Voyageur);
		
		
		//////////////////////////////ouvrire la gestion des Avions
		JMenuItem mntmNewMenuItem_Avion = new JMenuItem("  Avion");
		mntmNewMenuItem_Avion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Avion fr = new Avion();
				fr.setVisible(true);
				dispose();
			}
		});
		
		///////////////////////////////
		mntmNewMenuItem_Avion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmNewMenuItem_Avion.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		menuBar.add(mntmNewMenuItem_Avion);
		
		
		//////////  Sortire de l'application
		JMenuItem mntmNewMenuItem_Exit = new JMenuItem("Quitter");
		mntmNewMenuItem_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame frmloginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmloginSystem,"voulez vous quitter l'Application?","Login Systems",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					    System.exit(0);
				}
			}
		});
		
		///////////////////////////////////
		mntmNewMenuItem_Exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmNewMenuItem_Exit.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		menuBar.add(mntmNewMenuItem_Exit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setBounds(0, 40, 1424, 81);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Gestion des Vols");
		lblNewLabel.setForeground(new Color(255, 255, 224));
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));
		lblNewLabel.setBounds(633, 13, 278, 55);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(22, 431, 222, 307);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		
		////////////////////////************ Ouvrire un jframe pour Ajouter un Vol
		JButton btnAjouterModifierVol = new JButton("Ajouter/modifier vol");
		btnAjouterModifierVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ajouter_Vol fr = new Ajouter_Vol();
				fr.setVisible(true);
				dispose();
				
			}
		});
		
		////////////////////////////////////
		btnAjouterModifierVol.setOpaque(false);
		btnAjouterModifierVol.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAjouterModifierVol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAjouterModifierVol.setBounds(0, 86, 211, 42);
		panel_2.add(btnAjouterModifierVol);
		
		
		
		/////////************** Pour supprimer un vol de la base de donnees
		
		JButton btnAnnulerUnVol = new JButton("Annuler un vol");
		btnAnnulerUnVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row =table_Vols.getSelectedRow();
				String cell=table_Vols.getModel().getValueAt(row, 0).toString();
				//String sql="delete from vol where id_vol="+cell ;
				String sql="delete from vol where vol.id_vol="+cell;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					PreparedStatement preparedStatement=connection.prepareStatement(sql);
					preparedStatement.execute();
					JOptionPane.showMessageDialog(null,"Le Vol de l'Id"+ cell+" a été bien Annulé");
					connection.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 Statement stmt=connection.createStatement();
					 String  sql1="Select * from vol  ";
					 ResultSet resultSet=stmt.executeQuery(sql1);
					 table_Vols.setModel(DbUtils.resultSetToTableModel(resultSet));
			         
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
		
		
		
		
		btnAnnulerUnVol.setOpaque(false);
		btnAnnulerUnVol.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnnulerUnVol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAnnulerUnVol.setBounds(0, 158, 211, 42);
		panel_2.add(btnAnnulerUnVol);
		
		
		/////////////**********Mettre a jour la table vol
		JButton btnMettreJour = new JButton("Mettre \u00E0 jour");
		btnMettreJour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualiserTable_Vol();
			}
		});
		////////////////////////////////////////////
		btnMettreJour.setOpaque(false);
		btnMettreJour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMettreJour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMettreJour.setBounds(0, 243, 211, 42);
		panel_2.add(btnMettreJour);
		
		
		/////////****************** Afficher tout les vols disponibles
		
		JButton btnAfficherToutLes = new JButton(" Tout les vols");
		btnAfficherToutLes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualiserTable_Vol1();
			}
		});
		////////////////////////////
		btnAfficherToutLes.setOpaque(false);
		btnAfficherToutLes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAfficherToutLes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAfficherToutLes.setBounds(-1, 13, 212, 42);
		panel_2.add(btnAfficherToutLes);
		
		
		
		// focus Gained and Lost recherche par id 
		txtChercherUnVol = new JTextField();
		txtChercherUnVol.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				 if(txtChercherUnVol.getText().trim().toLowerCase().equals("chercher un vol par son id")){
					 txtChercherUnVol.setText("");
					 txtChercherUnVol.setForeground(Color.black);
			        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtChercherUnVol.getText().trim().equals("") || 
						txtChercherUnVol.getText().trim().toLowerCase().equals("chercher un vol par son id"))
			        {
			            
					txtChercherUnVol.setText("chercher un vol par son id");
					txtChercherUnVol.setForeground(new Color (153,153,153));
			        
			        }
			}
		});
		
		
		
		
        /////////////****** Key Released pour chercher un vol par son id
		txtChercherUnVol.setText("Chercher un vol par son Id");
		txtChercherUnVol.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 String sql="select * from vol where id_vol=?";
					 PreparedStatement preparedStatement=connection.prepareStatement(sql);
					 preparedStatement.setString(1,txtChercherUnVol.getText() );
					 ResultSet resultSet=preparedStatement.executeQuery();
					 table_Vols.setModel(DbUtils.resultSetToTableModel(resultSet));
					 connection.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		
		////////////////////////////////
		txtChercherUnVol.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(205, 92, 92)));
		txtChercherUnVol.setOpaque(false);
		txtChercherUnVol.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtChercherUnVol.setBounds(63, 205, 291, 34);
		panel.add(txtChercherUnVol);
		txtChercherUnVol.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(">>");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_2.setBounds(22, 215, 44, 24);
		panel.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(299, 352, 1062, 466);
		panel.add(scrollPane);
		
		table_Vols = new JTable();
		scrollPane.setViewportView(table_Vols);
		
		JLabel label = new JLabel(">>");
		label.setFont(new Font("Tahoma", Font.BOLD, 23));
		label.setBounds(381, 215, 44, 24);
		panel.add(label);
		
		
		//////////////********  chercher un vol par son Heur depart 
		txtChercherHeurDepart = new JTextField();
		txtChercherHeurDepart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 String sql="select * from vol where HeureDepart=?";
					 PreparedStatement preparedStatement=connection.prepareStatement(sql);
					 preparedStatement.setString(1,txtChercherHeurDepart.getText() );
					 ResultSet resultSet=preparedStatement.executeQuery();
					 table_Vols.setModel(DbUtils.resultSetToTableModel(resultSet));
					 connection.close();
				} catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		
		
         //////////////********  Focus lost and Gaind recherche par HeurDepart
		txtChercherHeurDepart.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtChercherHeurDepart.getText().trim().toLowerCase().equals("chercher un vol par son heuredepart")){
					txtChercherHeurDepart.setText("");
					txtChercherHeurDepart.setForeground(Color.black);
			        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtChercherHeurDepart.getText().trim().equals("") || 
						txtChercherHeurDepart.getText().trim().toLowerCase().equals("chercher un vol par son heuredepart"))
			        {
			            
					txtChercherHeurDepart.setText("chercher un vol par son heuredepart");
					txtChercherHeurDepart.setForeground(new Color (153,153,153));
			        
			        }
			}
		});
		
		////////////////////////////////
		txtChercherHeurDepart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtChercherHeurDepart.setText("Chercher un vol par son HeureDepart");
		txtChercherHeurDepart.setOpaque(false);
		txtChercherHeurDepart.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtChercherHeurDepart.setColumns(10);
		txtChercherHeurDepart.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(205, 92, 92)));
		txtChercherHeurDepart.setBounds(423, 205, 382, 34);
		panel.add(txtChercherHeurDepart);
		
		JLabel label_1 = new JLabel(">>");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_1.setBounds(837, 215, 44, 24);
		panel.add(label_1);
		
		
         /////////////////************ chercher par AeroportDepart
		txtChercherAeroportDepart = new JTextField();
		txtChercherAeroportDepart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 String sql="select * from vol where AeroportDepart=?";
					 PreparedStatement preparedStatement=connection.prepareStatement(sql);
					 preparedStatement.setString(1,txtChercherAeroportDepart.getText() );
					 ResultSet resultSet=preparedStatement.executeQuery();
					 table_Vols.setModel(DbUtils.resultSetToTableModel(resultSet));
					 connection.close();
				} catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		
		/////////////////********************
		///////**********  Focus lost et Gained recherche par Areoport depart
		txtChercherAeroportDepart.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtChercherAeroportDepart.getText().trim().toLowerCase().equals("chercher un vol par son aeroportdepart")){
					txtChercherAeroportDepart.setText("");
					txtChercherAeroportDepart.setForeground(Color.black);
			        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtChercherAeroportDepart.getText().trim().equals("") || 
						txtChercherAeroportDepart.getText().trim().toLowerCase().equals("chercher un vol par son aeroportdepart"))
			        {
			            
					txtChercherAeroportDepart.setText("chercher un vol par son aeroportdepart");
					txtChercherAeroportDepart.setForeground(new Color (153,153,153));
			        
			        }
			}
		});
		
		//////////////////////**************************
		txtChercherAeroportDepart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtChercherAeroportDepart.setText("Chercher un vol par son AeroportDepart");
		txtChercherAeroportDepart.setOpaque(false);
		txtChercherAeroportDepart.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtChercherAeroportDepart.setColumns(10);
		txtChercherAeroportDepart.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(205, 92, 92)));
		txtChercherAeroportDepart.setBounds(879, 205, 410, 34);
		panel.add(txtChercherAeroportDepart);
		
		JLabel label_2 = new JLabel(">>");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_2.setBounds(837, 302, 44, 24);
		panel.add(label_2);
		
		
        /////////////////////////******** Chercher par Aeroport Arrivee
		txtChercherAeroportArrivee = new JTextField();
		txtChercherAeroportArrivee.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 String sql="select * from vol where AeroportArrivee=?";
					 PreparedStatement preparedStatement=connection.prepareStatement(sql);
					 preparedStatement.setString(1,txtChercherAeroportArrivee.getText() );
					 ResultSet resultSet=preparedStatement.executeQuery();
					 table_Vols.setModel(DbUtils.resultSetToTableModel(resultSet));
					 connection.close();
				} catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		///////////******************************
		////// Focus Lost et Gained recherche par AeroportArrivee
		txtChercherAeroportArrivee.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtChercherAeroportArrivee.getText().trim().toLowerCase().equals("chercher un vol par son aeroportarrivee")){
					txtChercherAeroportArrivee.setText("");
					txtChercherAeroportArrivee.setForeground(Color.black);
			        }
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtChercherAeroportArrivee.getText().trim().equals("") || 
						txtChercherAeroportArrivee.getText().trim().toLowerCase().equals("chercher un vol par son aeroportarrivee"))
			        {
			            
					txtChercherAeroportArrivee.setText("chercher un vol par son aeroportarrivee");
					txtChercherAeroportArrivee.setForeground(new Color (153,153,153));
			        
			        }
			}
		});
		//////////////////////*****************
		txtChercherAeroportArrivee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtChercherAeroportArrivee.setText("Chercher un vol par son AeroportArrivee");
		txtChercherAeroportArrivee.setOpaque(false);
		txtChercherAeroportArrivee.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtChercherAeroportArrivee.setColumns(10);
		txtChercherAeroportArrivee.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(205, 92, 92)));
		txtChercherAeroportArrivee.setBounds(879, 292, 410, 34);
		panel.add(txtChercherAeroportArrivee);
	}
}
