package Vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Connexion.Singleton;
import Modele.DAO.ArticleImp;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import Modele.Article;

public class Recherche extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField recherche;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
				try {
					Recherche frame = new Recherche();
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
	public Recherche() {
		ArticleImp obj10 = new ArticleImp();
		Connection connection = Singleton.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 660);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(236, 255, 248));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 153));
		panel.setForeground(new Color(64, 0, 110));
		panel.setBounds(10, 10, 946, 73);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rechercher");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(335, 10, 262, 37);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 153));
		panel_1.setBounds(10, 550, 946, 73);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 153, 153));
		panel_2.setBounds(10, 82, 10, 507);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 153, 153));
		panel_3.setBounds(946, 82, 10, 507);
		contentPane.add(panel_3);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Menu Principale");
		btnNewButton.addActionListener(e -> {
				ResponsableVente responsable = new ResponsableVente();
				responsable.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(249, 249, 249));
		btnNewButton.setBounds(10, 27, 133, 21);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(441, 113, 480, 413);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id article ", "nom article ", "prix unit", "categorie", "quantite"
			}
		));
		DefaultTableModel model1 = (DefaultTableModel) table.getModel();
		table.setBackground(new Color(192, 192, 192));
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(40, 113, 364, 413);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Recherche par categorie : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 259, 178, 23);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Recherche par id article  : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 93, 178, 23);
		panel_4.add(lblNewLabel_1_1);
		
		recherche = new JTextField();
		recherche.setBounds(198, 96, 124, 19);
		panel_4.add(recherche);
		recherche.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("recherche");
		btnNewButton_1.addActionListener(e -> {
				try {
				if(recherche.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "ajoute id article d'abord  ", "Erreur", JOptionPane.ERROR_MESSAGE);
					
				}
				
				else {
					
					if(obj10.getArticleById(Integer.parseInt(recherche.getText())) == null) {
						JOptionPane.showMessageDialog(null, "id article non exist ", "Erreur", JOptionPane.ERROR_MESSAGE);
						
					}
					else {
						PreparedStatement stmt1;
						
							String res= recherche.getText();
							int idart = Integer.parseInt(res);
							stmt1 = connection.prepareStatement("select * from article where idart = ?;");
							  stmt1.setInt(1,idart);
							  ResultSet rs1 = stmt1.executeQuery();
							    model1.setRowCount(0);
							    while(rs1.next()) {
							        String[] rowData = {String.valueOf(rs1.getInt("idart")),rs1.getString("nom"),String.valueOf(rs1.getDouble("prix_unit")),rs1.getString("categorie"),String.valueOf(rs1.getInt("qte"))};
							        model1.addRow(rowData);}}}}
						catch(NumberFormatException e1) {
									JOptionPane.showMessageDialog(null, " essayez d'entre un entier", "Erreur", JOptionPane.ERROR_MESSAGE);
						}
						 catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	


					}
				    }
					
				
			
	
		          
				);
		btnNewButton_1.setBounds(198, 137, 124, 21);
		panel_4.add(btnNewButton_1);
		

		

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();

		try {
			PreparedStatement stmt = connection.prepareStatement("select distinct (categorie) from article ;");
		 
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			model.addElement(rs.getString("categorie"));
		}
		JComboBox choixcategorie = new JComboBox<>(model);
		choixcategorie.setBackground(new Color(192, 192, 192));
		choixcategorie.setBounds(198, 261, 124, 21);
		panel_4.add(choixcategorie);
		
		JButton btnNewButton_2 = new JButton("recherche");
		btnNewButton_2.addActionListener(e -> {
				if (choixcategorie.getSelectedItem().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "selectionne votre choix ", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						PreparedStatement stmt1 = connection.prepareStatement("select * from article where categorie = ?;");
					    stmt1.setString(1,choixcategorie.getSelectedItem().toString() );
					    ResultSet rs1 = stmt1.executeQuery();
					    model1.setRowCount(0);
					    while(rs1.next()) {
					        String[] rowData = {String.valueOf(rs1.getInt("idart")),rs1.getString("nom"),String.valueOf(rs1.getDouble("prix_unit")),rs1.getString("categorie"),String.valueOf(rs1.getInt("qte"))};
					        model1.addRow(rowData);
					    	
					    	
					    }

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				
			}
		});
		btnNewButton_2.setBounds(198, 309, 124, 21);
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Supprimer tous : ");
		btnNewButton_3.addActionListener(e -> {
				model1.setRowCount(0);
			}
		});
		btnNewButton_3.setBounds(198, 382, 156, 21);
		panel_4.add(btnNewButton_3);
		
;
	}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setLocationRelativeTo(null);
		
	ArrayList<Article>  articles = obj10.getAllArticles();
	for(Article art : articles) {
        String[] rowData = {String.valueOf(art.getIdart()),art.getNom(),String.valueOf(art.getPrix_unit()),art.getCategorie(),String.valueOf(art.getQte())};
        model1.addRow(rowData);
	}
	
}
	
}

