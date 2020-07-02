package billet_avion;
////////////////////////////////// ************ Classe Pour Ajouter des Vols
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ajouter_Vol extends JFrame {

	private JPanel contentPane;
	private JTextField textField_id_Avion;
	private JTextField textField_Heur_depart;
	private JTextField textField_Heur_Arrivee;
	private JTextField textField_Duree_Vol;
	private JTextField textField_Aeroport_depart;
	private JTextField textField_Aeoroport_Arrivee;
	private JTable table_Modifier_Ajouter;
	private JTextField ID_Vol;

	/**
	 * Launch the application.
	 */
	
	
	 // create a function to verify the empty fields  
    public boolean verifyFields()
    {
                String ID_vol=ID_Vol.getText();
                String id_AvionString=textField_id_Avion.getText();
                String Heure_depart=textField_Heur_depart.getText();
                String Heure_Arrivee=textField_Heur_Arrivee.getText();
                String Duree=textField_Duree_Vol.getText();
                String AeroportDepart=textField_Aeroport_depart.getText();
                String AeroportArrivee=textField_Aeoroport_Arrivee.getText();
                
				
        
        // check empty fields
        
        if(ID_vol.trim().equals("") ||id_AvionString.trim().equals("")|| Heure_depart.trim().equals("")
                || Heure_Arrivee.trim().equals("") || Duree.trim().equals("")||AeroportDepart.trim().equals("")
                ||AeroportArrivee.trim().equals("") )
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
					Ajouter_Vol frame = new Ajouter_Vol();
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
	public Ajouter_Vol() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1405, 910);
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
		panel_1.setBounds(0, 0, 1377, 106);
		panel.add(panel_1);
		
		JLabel lblAjouterDesVols = new JLabel("Ajouter des Vols");
		lblAjouterDesVols.setForeground(new Color(255, 255, 224));
		lblAjouterDesVols.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));
		lblAjouterDesVols.setBounds(587, 28, 201, 37);
		panel_1.add(lblAjouterDesVols);

		////////////////**********************************************************  Retour au Gestion Vols
		JButton button_retour = new JButton("");
		button_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administrateur_Gestion fr1 = new Administrateur_Gestion();
				fr1.setVisible(true);
				dispose();
			}
		});
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		button_retour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_retour.setIcon(new ImageIcon(Ajouter_Vol.class.getResource("/images/back.jpg")));
		button_retour.setOpaque(false);
		button_retour.setBounds(12, 13, 97, 67);
		panel_1.add(button_retour);
		
		JLabel label_1 = new JLabel("Retour");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(121, 34, 82, 30);
		panel_1.add(label_1);
		
		
		
		//////////////////////////////////////  ******************************************
		JButton btnVolsDisponibles = new JButton("Vols disponibles");
		btnVolsDisponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 Statement stmt=connection.createStatement();
					 String  sql1="Select * from vol  ";
					 ResultSet resultSet=stmt.executeQuery(sql1);
					 table_Modifier_Ajouter.setModel(DbUtils.resultSetToTableModel(resultSet));
			         
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
		
		
		///////////////////////////////////////////////////////////////////////////////////////////
		btnVolsDisponibles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolsDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnVolsDisponibles.setBounds(10, 131, 247, 38);
		panel.add(btnVolsDisponibles);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 182, 247, 646);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		textField_id_Avion = new JTextField();
		textField_id_Avion.setBounds(12, 147, 190, 28);
		textField_id_Avion.setOpaque(false);
		textField_id_Avion.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		textField_id_Avion.setColumns(10);
		textField_id_Avion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		panel_2.add(textField_id_Avion);
		
		textField_Heur_depart = new JTextField();
		textField_Heur_depart.setOpaque(false);
		textField_Heur_depart.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		textField_Heur_depart.setColumns(10);
		textField_Heur_depart.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_Heur_depart.setBounds(12, 223, 190, 44);
		panel_2.add(textField_Heur_depart);
		
		textField_Heur_Arrivee = new JTextField();
		textField_Heur_Arrivee.setOpaque(false);
		textField_Heur_Arrivee.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		textField_Heur_Arrivee.setColumns(10);
		textField_Heur_Arrivee.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_Heur_Arrivee.setBounds(12, 318, 190, 44);
		panel_2.add(textField_Heur_Arrivee);
		
		textField_Duree_Vol = new JTextField();
		textField_Duree_Vol.setOpaque(false);
		textField_Duree_Vol.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		textField_Duree_Vol.setColumns(10);
		textField_Duree_Vol.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_Duree_Vol.setBounds(12, 409, 190, 44);
		panel_2.add(textField_Duree_Vol);
		
		textField_Aeroport_depart = new JTextField();
		textField_Aeroport_depart.setOpaque(false);
		textField_Aeroport_depart.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		textField_Aeroport_depart.setColumns(10);
		textField_Aeroport_depart.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_Aeroport_depart.setBounds(12, 500, 190, 44);
		panel_2.add(textField_Aeroport_depart);
		
		textField_Aeoroport_Arrivee = new JTextField();
		textField_Aeoroport_Arrivee.setOpaque(false);
		textField_Aeoroport_Arrivee.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		textField_Aeoroport_Arrivee.setColumns(10);
		textField_Aeoroport_Arrivee.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_Aeoroport_Arrivee.setBounds(12, 589, 190, 44);
		panel_2.add(textField_Aeoroport_Arrivee);
		
		JLabel label = new JLabel("Id de l'Avion");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(12, 98, 152, 36);
		panel_2.add(label);
		
		JLabel lblHeureDepart = new JLabel("Heure D\u00E9part");
		lblHeureDepart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHeureDepart.setBounds(12, 188, 152, 36);
		panel_2.add(lblHeureDepart);
		
		JLabel lblHeureArivee = new JLabel("Heure Arriv\u00E9e");
		lblHeureArivee.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHeureArivee.setBounds(12, 280, 152, 36);
		panel_2.add(lblHeureArivee);
		
		JLabel lblDureeDeVol = new JLabel("Dur\u00E9e de Vol");
		lblDureeDeVol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDureeDeVol.setBounds(12, 375, 152, 36);
		panel_2.add(lblDureeDeVol);
		
		JLabel lblAeroportDeDepart = new JLabel("Aeroport D\u00E9part");
		lblAeroportDeDepart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAeroportDeDepart.setBounds(12, 466, 152, 36);
		panel_2.add(lblAeroportDeDepart);
		
		JLabel lblAeroportArrivee = new JLabel("Aeroport Arriv\u00E9e");
		lblAeroportArrivee.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAeroportArrivee.setBounds(12, 557, 152, 36);
		panel_2.add(lblAeroportArrivee);
		
		JLabel lblIdvol = new JLabel("Id_Vol");
		lblIdvol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIdvol.setBounds(12, 13, 152, 36);
		panel_2.add(lblIdvol);
		
		ID_Vol = new JTextField();
		ID_Vol.setEditable(false);
		ID_Vol.setOpaque(false);
		ID_Vol.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		ID_Vol.setColumns(10);
		ID_Vol.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		ID_Vol.setBounds(12, 57, 190, 28);
		panel_2.add(ID_Vol);
		
		
		/////////////****** Ajouter un Vol
		JButton button_AJOUTER = new JButton("Ajouter");
		button_AJOUTER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String idVol=ID_Vol.getText();
				String id_AvionString=textField_id_Avion.getText();
				String HeureDepart=textField_Heur_depart.getText();
				String HeurArrivee=textField_Heur_Arrivee.getText();
				String Duree=textField_Duree_Vol.getText();
				String AeroportDepart=textField_Aeroport_depart.getText();
				String AeroportArrivee=textField_Aeoroport_Arrivee.getText();
				
				
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Vous etes sure de tes Informations","Clear TextField", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					if (!verifyFields()) {
						try {
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
							Statement statement = connection.createStatement();
							
 							String query ="Insert into vol(id_avion,HeureDepart,HeureArrivee,Duree,AeroportDepart,AeroportArrivee) values ('"+id_AvionString+"','"+HeureDepart
 									+"','"+HeurArrivee+"','"+Duree+"','"+AeroportDepart+"','"+AeroportArrivee+"')";
 							statement.executeUpdate(query);
							connection.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(button_AJOUTER, "Le Vol à été bien Ajouté");
					}
					
				}
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 Statement stmt=connection.createStatement();
					 String  sql1="Select * from vol  ";
					 ResultSet resultSet=stmt.executeQuery(sql1);
					 table_Modifier_Ajouter.setModel(DbUtils.resultSetToTableModel(resultSet));
			         
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
		
		
		
		
		button_AJOUTER.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_AJOUTER.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_AJOUTER.setBounds(269, 296, 177, 38);
		panel.add(button_AJOUTER);
		
		
		
		
		////////////////////*****************  Modifier Un Vol 
		JButton button_Modifier = new JButton("Modifier");
		button_Modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String idVol=ID_Vol.getText();
				String id_AvionString=textField_id_Avion.getText();
				String HeureDepart=textField_Heur_depart.getText();
				String HeurArrivee=textField_Heur_Arrivee.getText();
				String Duree=textField_Duree_Vol.getText();
				String AeroportDepart=textField_Aeroport_depart.getText();
				String AeroportArrivee=textField_Aeoroport_Arrivee.getText();
				
				
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Vous etes sure de tes Informations","Clear TextField", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					if (!verifyFields()) {
						try {
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
							Statement statement = connection.createStatement();
							
 							String query ="UPDATE vol Set  id_vol='"+idVol+"',id_avion='"+id_AvionString+"',HeureDepart='"+HeureDepart+"',HeureArrivee='"+HeurArrivee
 									+"',Duree='"+Duree+"',AeroportDepart='"+AeroportDepart+"',AeroportArrivee='"+AeroportArrivee+"'where id_vol='"+idVol+"'    ";
 							statement.executeUpdate(query);
							connection.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(button_Modifier, "Le Vol à été bien Modifié");
					}
					
				}
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 Statement stmt=connection.createStatement();
					 String  sql1="Select * from vol  ";
					 ResultSet resultSet=stmt.executeQuery(sql1);
					 table_Modifier_Ajouter.setModel(DbUtils.resultSetToTableModel(resultSet));
			         
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
		
		
		
		
		button_Modifier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_Modifier.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_Modifier.setBounds(269, 434, 177, 38);
		panel.add(button_Modifier);
		
		
		////////////////////////////////////////////////********************Mettre A jour les Vols disponnibles
		JButton button_MettreAjour = new JButton("Mettre \u00E0 jour");
		button_MettreAjour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					 Statement stmt=connection.createStatement();
					 String  sql1="Select * from vol  ";
					 ResultSet resultSet=stmt.executeQuery(sql1);
					 table_Modifier_Ajouter.setModel(DbUtils.resultSetToTableModel(resultSet));
			         JOptionPane.showMessageDialog(null,"la table est mise à jour..... ");
					
				}catch(ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
					
				}
			
		});
		
		
		///////////////////////////////////////////////////////////////////////////
		button_MettreAjour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_MettreAjour.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_MettreAjour.setBounds(269, 575, 177, 38);
		panel.add(button_MettreAjour);
		
		
		///  Remplir les Champs Lors de la selection dans le tableau 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				 DefaultTableModel model=(DefaultTableModel) table_Modifier_Ajouter.getModel();
				 // get the selected row index
			       int selectedRowIndex = table_Modifier_Ajouter.getSelectedRow();
			       
			       // set the selected row data into jtextfields
			          ID_Vol.setText(model.getValueAt(selectedRowIndex, 0).toString());
			          textField_id_Avion.setText(model.getValueAt(selectedRowIndex, 1).toString());
			          textField_Heur_depart.setText(model.getValueAt(selectedRowIndex, 2).toString());
			          textField_Heur_Arrivee.setText(model.getValueAt(selectedRowIndex, 3).toString());
			          textField_Duree_Vol.setText(model.getValueAt(selectedRowIndex, 4).toString());
			          textField_Aeroport_depart.setText(model.getValueAt(selectedRowIndex, 5).toString());
			          textField_Aeoroport_Arrivee.setText(model.getValueAt(selectedRowIndex, 6).toString());
	
			}
		});
		
		
		
		
		scrollPane.setBounds(483, 230, 894, 516);
		panel.add(scrollPane);
		
		table_Modifier_Ajouter = new JTable();
		scrollPane.setViewportView(table_Modifier_Ajouter);
	}
}
