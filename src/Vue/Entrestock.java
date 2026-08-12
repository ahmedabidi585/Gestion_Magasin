package Vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import Modele.Article;
import Modele.LigneAchat;
import Modele.User;
import Modele.DAO.ArticleImp;
import Modele.DAO.LigneAchatImp;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Entrestock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table1;
	private JTextField idachat;
	private JTextField idarticle;
	private JTextField quantite;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Entrestock frame = new Entrestock();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Entrestock() {
		ArticleImp obj11 = new ArticleImp();
		LigneAchatImp obj12 = new LigneAchatImp();
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
		panel.setBounds(10, 10, 936, 73);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel(" Entrée article en stock");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(300, 10, 336, 37);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("Menu Principale");
		btnNewButton.addActionListener(e -> {
			new Magasinier().setVisible(true);
			setVisible(false);
		});
		btnNewButton.setBackground(new Color(249, 249, 249));
		btnNewButton.setBounds(10, 27, 133, 21);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 153));
		panel_1.setBounds(10, 550, 936, 63);
		contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 153, 153));
		panel_2.setBounds(10, 82, 10, 507);
		contentPane.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 153, 153));
		panel_3.setBounds(936, 82, 10, 507);
		contentPane.add(panel_3);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(30, 104, 301, 436);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(192, 192, 192));

		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] { "id achat", "id article", "quantite" }
		));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(531, 104, 395, 436);
		contentPane.add(scrollPane_1);

		table1 = new JTable();
		table1.setBackground(new Color(192, 192, 192));
		table1.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] { "id article ", "nom article ", "prix unitaire", "categorie", "quantite" }
		));
		DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
		scrollPane_1.setViewportView(table1);

		idachat = new JTextField();
		idachat.setBackground(new Color(255, 255, 255));
		idachat.setEditable(false);
		idachat.setBounds(429, 182, 74, 36);
		contentPane.add(idachat);
		idachat.setColumns(10);

		idarticle = new JTextField();
		idarticle.setBackground(new Color(255, 255, 255));
		idarticle.setEditable(false);
		idarticle.setColumns(10);
		idarticle.setBounds(429, 266, 74, 36);
		contentPane.add(idarticle);

		quantite = new JTextField();
		quantite.setBackground(new Color(255, 255, 255));
		quantite.setEditable(false);
		quantite.setColumns(10);
		quantite.setBounds(429, 345, 74, 36);
		contentPane.add(quantite);

		JLabel lblNewLabel_1 = new JLabel("id achat ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(349, 182, 70, 36);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("id article ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(349, 265, 70, 36);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("quantite");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(349, 345, 70, 36);
		contentPane.add(lblNewLabel_1_2);

		JButton btnNewButton_1 = new JButton("Modifier quantite");
		btnNewButton_1.addActionListener(e -> {
			if (idachat.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Pas de ligne selectionneé ", "Erreur", JOptionPane.ERROR_MESSAGE);
			} else {
				int idach = Integer.parseInt(idachat.getText());
				int idart = Integer.parseInt(idarticle.getText());
				int qte = Integer.parseInt(quantite.getText());

				try {
					PreparedStatement stmt = connection.prepareStatement("select idachat from ligneachatverification where idachat =? and idart= ?;");
					stmt.setInt(1, idach);
					stmt.setInt(2, idart);
					ResultSet rs = stmt.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Cette achat a été traitée", "Erreur", JOptionPane.ERROR_MESSAGE);
					} else {
						PreparedStatement stmt1 = connection.prepareStatement(" update article set qte = qte+? where idart = ?;");
						stmt1.setInt(1, qte);
						stmt1.setInt(2, idart);

						PreparedStatement stmt2 = connection.prepareStatement("  insert into ligneachatverification values(?,?);");
						stmt2.setInt(1, idach);
						stmt2.setInt(2, idart);

						if (stmt1.executeUpdate() > 0 && stmt2.executeUpdate() > 0) {
							model1.setRowCount(0);
							ArrayList<Article> articleList = obj11.getAllArticles();
							int i = 0;

							while (i < articleList.size()) {
								String idarti = String.valueOf(articleList.get(i).getIdart());
								String nomart = String.valueOf(articleList.get(i).getNom());
								String prixunitaireart = String.valueOf(articleList.get(i).getPrix_unit());
								String categorie = String.valueOf(articleList.get(i).getCategorie());
								String quantiteVal = String.valueOf(articleList.get(i).getQte());

								String[] rowData = { idarti, nomart, prixunitaireart, categorie, quantiteVal };
								model1.addRow(rowData);
								i = i + 1;
							}
							JOptionPane.showMessageDialog(null, "Modification de quantite avec succes", "Succes", JOptionPane.INFORMATION_MESSAGE);
							idachat.setText("");
							idarticle.setText("");
							quantite.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "Il y a un probleme dans la modification", "Erreur", JOptionPane.ERROR_MESSAGE);
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(353, 467, 150, 49);
		contentPane.add(btnNewButton_1);

		table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					idachat.setText(model.getValueAt(i, 0).toString());
					idarticle.setText(model.getValueAt(i, 1).toString());
					quantite.setText(model.getValueAt(i, 2).toString());
				}
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		ArrayList<Article> article = obj11.getAllArticles();
		int i= 0;
		
		while(i<article.size()) {
	        String idart = String.valueOf(article.get(i).getIdart());
	        String nomart =  String.valueOf(article.get(i).getNom());
	        String prixunitaireart =  String.valueOf(article.get(i).getPrix_unit());
	        String categorie =  String.valueOf(article.get(i).getCategorie());
	        String quantite = String.valueOf(article.get(i).getQte());

	        
	        String[] rowData = {idart, nomart, prixunitaireart,categorie,quantite};
	        model1.addRow(rowData);
	        i=i+1;
			
			
		
            }
		
		
		ArrayList<LigneAchat> ligneachat = obj12.getAllLigneAchats();
		int c= 0;
		
		while(c<ligneachat.size()) {
	        String idachat = String.valueOf(ligneachat.get(c).getIdachat());
	        String idarticle =  String.valueOf(ligneachat.get(c).getIdart());
	        String quantite =  String.valueOf(ligneachat.get(c).getQte());

	        
	        String[] rowData = {idachat, idarticle,quantite};
	        model.addRow(rowData);
	        c=c+1;
			
			
		}
		
		setLocationRelativeTo(null);
		
		
}
}
