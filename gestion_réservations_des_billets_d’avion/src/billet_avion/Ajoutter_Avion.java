package billet_avion;
////////////////////////////// ****** Classe POUR ajouter des Avions
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ajoutter_Avion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_Avion_Modifier;
	private JTextField textField_id_Avion;
	private JTextField textField_Compagnie;
	private JTextField textField_Nbr_place;
	
	//a/mise  A jour
	public void ActualiserTable_Avion() {
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
			 Statement stmt=connection.createStatement();
			 String  sql1="Select * from avion  ";
			 ResultSet resultSet=stmt.executeQuery(sql1);
			 table_Avion_Modifier.setModel(DbUtils.resultSetToTableModel(resultSet));
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
	
	public boolean verifyFields()
    {
                String company=textField_Compagnie.getText();
                String id_AvionString=textField_id_Avion.getText();
                String places=textField_Nbr_place.getText();
               
                
				
        
        // check empty fields
        
        if(company.trim().equals("") ||id_AvionString.trim().equals("")|| places.trim().equals("") )
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
					Ajoutter_Avion frame = new Ajoutter_Avion();
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
	public Ajoutter_Avion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1214, 707);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 1196, 106);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAjouterDesAvions = new JLabel("Ajouter des Avions");
		lblAjouterDesAvions.setForeground(new Color(255, 255, 224));
		lblAjouterDesAvions.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));
		lblAjouterDesAvions.setBounds(476, 28, 237, 37);
		panel.add(lblAjouterDesAvions);
		
		
		//////***********     Retour au Jframe Avion
		JButton btn_Back = new JButton("");
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Avion fr1 = new Avion();
				fr1.setVisible(true);
				dispose();
			}
		});
		
		
		
		
		btn_Back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Back.setOpaque(false);
		btn_Back.setIcon(new ImageIcon(Ajoutter_Avion.class.getResource("/images/back.jpg")));
		btn_Back.setBounds(12, 13, 97, 67);
		panel.add(btn_Back);
		
		JLabel lblNewLabel = new JLabel("Retour");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(121, 34, 82, 30);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(24, 217, 277, 408);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField_id_Avion = new JTextField();
		textField_id_Avion.setEditable(false);
		textField_id_Avion.setOpaque(false);
		textField_id_Avion.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		textField_id_Avion.setColumns(10);
		textField_id_Avion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_id_Avion.setBounds(12, 44, 253, 44);
		panel_1.add(textField_id_Avion);
		
		JLabel lblNewLabel_1 = new JLabel("Id de l'Avion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(12, 13, 152, 36);
		panel_1.add(lblNewLabel_1);
		
		textField_Compagnie = new JTextField();
		textField_Compagnie.setOpaque(false);
		textField_Compagnie.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		textField_Compagnie.setColumns(10);
		textField_Compagnie.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_Compagnie.setBounds(12, 178, 253, 44);
		panel_1.add(textField_Compagnie);
		
		JLabel lblCompagnie = new JLabel("Compagnie");
		lblCompagnie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCompagnie.setBounds(12, 147, 152, 36);
		panel_1.add(lblCompagnie);
		
		JLabel lblNembreDePalces = new JLabel("Nombre de palces");
		lblNembreDePalces.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNembreDePalces.setBounds(12, 283, 194, 36);
		panel_1.add(lblNembreDePalces);
		
		textField_Nbr_place = new JTextField();
		textField_Nbr_place.setOpaque(false);
		textField_Nbr_place.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		textField_Nbr_place.setColumns(10);
		textField_Nbr_place.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(233, 150, 122)));
		textField_Nbr_place.setBounds(12, 316, 253, 44);
		panel_1.add(textField_Nbr_place);
		
		//////////////////////////////////*****************   Mettre A jours les Avions disponnibles dans la base de donnees
		
		JButton button_MetterAjour = new JButton("Mettre \u00E0 jour");
		button_MetterAjour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ActualiserTable_Avion();
			}
		});
		
		
		////////////////////////////////////////////////////////////////////////////////////////////
		button_MetterAjour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_MetterAjour.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_MetterAjour.setBounds(313, 541, 177, 38);
		contentPane.add(button_MetterAjour);
		
		
		///////////////////////////////********************  Afficher les Avions disponibles dans la  base de donnees
		JButton btnAvionsAvions_disponibles = new JButton("Avions disponibles");
		btnAvionsAvions_disponibles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAvionsAvions_disponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
               try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
					Statement stmt=connection.createStatement();
					String  sql1="Select * from avion ";
					ResultSet resultSet=stmt.executeQuery(sql1);
					table_Avion_Modifier.setModel(DbUtils.resultSetToTableModel(resultSet));
					
					
				} catch (Exception e1) {
					System.out.println("Probleme de chargement de donnees de la base de donnees");
				}
			}
		});
		
		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		btnAvionsAvions_disponibles.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnAvionsAvions_disponibles.setBounds(24, 148, 279, 38);
		contentPane.add(btnAvionsAvions_disponibles);
		
		
		////////////********************  Modifier les Avions
		JButton btnModifier_Avion = new JButton("Modifier");
		btnModifier_Avion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id_AvionString=textField_id_Avion.getText();
				String company=textField_Compagnie.getText();
                String places=textField_Nbr_place.getText();
				
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Vous etes sure de tes Informations","Clear TextField", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					if (!verifyFields()) {
						try {
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
							Statement statement = connection.createStatement();
							
 							String query ="UPDATE avion Set id_avion ='"+id_AvionString+"' , compagnie='"+company+"' , nb_palce='"+places+"'where id_avion='"+id_AvionString+"'  ";
 							statement.executeUpdate(query);
							connection.close();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(btnModifier_Avion, "L'Avion à été bien Modifié");
					}
					
				}
				
				
			}
		});
		
		
		
		btnModifier_Avion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModifier_Avion.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnModifier_Avion.setBounds(313, 405, 177, 38);
		contentPane.add(btnModifier_Avion);
		
		
		/////////////////  ********************** Ajouter un Avion 
		JButton btnAjouter_Avion = new JButton("Ajouter");
		btnAjouter_Avion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//String id_AvionString=textField_id_Avion.getText();
				String company=textField_Compagnie.getText();
                String places=textField_Nbr_place.getText();
				
				
				int YesOrNo = JOptionPane.showConfirmDialog(null,"Vous etes sure de tes Informations","Clear TextField", JOptionPane.YES_NO_OPTION);
				if(YesOrNo==0) {
					if (!verifyFields()) {
						try {
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billet_avion","root","");
							Statement statement = connection.createStatement();
							
 							String query ="Insert into avion(compagnie,nb_palce) values ('"+company+"','"+places+"')";
 							statement.executeUpdate(query);
							connection.close();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(btnAjouter_Avion, "Le Vol à été bien Ajouté");
					}
					
				}
			}
		});
		
		
		
		
		btnAjouter_Avion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAjouter_Avion.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnAjouter_Avion.setBounds(313, 269, 177, 38);
		contentPane.add(btnAjouter_Avion);
		
		
		
		///////////// Selectionner du Tableau et Afficher dans les jtextfields
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel) table_Avion_Modifier.getModel();
				 // get the selected row index
			       int selectedRowIndex = table_Avion_Modifier.getSelectedRow();
			       
			       // set the selected row data into jtextfields
			          textField_id_Avion.setText(model.getValueAt(selectedRowIndex, 0).toString());
			          textField_Compagnie.setText(model.getValueAt(selectedRowIndex, 1).toString());
			          textField_Nbr_place.setText(model.getValueAt(selectedRowIndex, 2).toString());
			          
			}
		});
		
		
		
		
		
		scrollPane.setBounds(515, 217, 669, 408);
		contentPane.add(scrollPane);
		
		table_Avion_Modifier = new JTable();
		scrollPane.setViewportView(table_Avion_Modifier);
	}
}
