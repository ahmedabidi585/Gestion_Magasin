package Vue;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Connexion.Singleton;
import Modele.Article;
import Modele.LigneCommande;
import Modele.DAO.ArticleImp;
import Modele.DAO.LigneAchatImp;
import Modele.DAO.LigneCommandeImp;

public class Sortiestock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table1;
	private JTextField idcommande;
	private JTextField idarticle;
	private JTextField quantite;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
				try {
					Sortiestock frame = new Sortiestock();
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
	public Sortiestock() {
		ArticleImp obj11 = new ArticleImp();
		LigneCommandeImp obj12 = new LigneCommandeImp();
		Connection connection =Singleton.getConnection();
	
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
		
		JLabel lblNewLabel = new JLabel("Sortie article de stock");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(300, 10, 336, 37);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Menu Principale");
		btnNewButton.addActionListener(e -> {
                new Magasinier().setVisible(true);
				setVisible(false);
			}
		});btnNewButton.setBackground(new Color(249,249,249));btnNewButton.setBounds(10,27,133,21);panel.add(btnNewButton);

	JPanel panel_1 = new JPanel();panel_1.setBackground(new Color(0,153,153));panel_1.setBounds(10,550,936,63);contentPane.add(panel_1);

	JPanel panel_2 = new JPanel();panel_2.setBackground(new Color(0,153,153));panel_2.setBounds(10,82,10,507);contentPane.add(panel_2);

	JPanel panel_3 = new JPanel();panel_3.setBackground(new Color(0,153,153));panel_3.setBounds(936,82,10,507);contentPane.add(panel_3);panel_1.setLayout(null);

	table=new JTable();table.setBackground(new Color(192,192,192));

	table.setModel(new DefaultTableModel(new Object[][]{},new String[]{"id achat","id article","quantite"}));
	DefaultTableModel model = (DefaultTableModel) table.getModel();

	table1=new JTable();table1.setBackground(new Color(192,192,192));table1.setModel(new DefaultTableModel(new Object[][]{},new String[]{"id article ","nom article ","prix unitaire","categorie","quantite"}));
	DefaultTableModel model1 = (DefaultTableModel) table1.getModel();

	idcommande=new JTextField();idcommande.setBackground(new Color(255,255,255));idcommande.setEditable(false);idcommande.setBounds(429,182,74,36);contentPane.add(idcommande);idcommande.setColumns(10);

	idarticle=new JTextField();idarticle.setBackground(new Color(255,255,255));idarticle.setEditable(false);idarticle.setColumns(10);idarticle.setBounds(429,266,74,36);contentPane.add(idarticle);

	quantite=new JTextField();quantite.setBackground(new Color(255,255,255));quantite.setEditable(false);quantite.setColumns(10);quantite.setBounds(429,345,74,36);contentPane.add(quantite);

	JLabel lblNewLabel_1 = new JLabel(
			"id commande");lblNewLabel_1.setFont(new Font("Tahoma",Font.BOLD,13));lblNewLabel_1.setBounds(344,182,86,36);contentPane.add(lblNewLabel_1);

	JLabel lblNewLabel_1_1 = new JLabel(
			"id article");lblNewLabel_1_1.setFont(new Font("Tahoma",Font.BOLD,13));lblNewLabel_1_1.setBounds(349,265,70,36);contentPane.add(lblNewLabel_1_1);

	JLabel lblNewLabel_1_2 = new JLabel(
			"quantite");lblNewLabel_1_2.setFont(new Font("Tahoma",Font.BOLD,13));lblNewLabel_1_2.setBounds(349,345,70,36);contentPane.add(lblNewLabel_1_2);

	JButton btnNewButton_1 = new JButton("Modifier quantite");

	btnNewButton_1.setBounds(353,467,150,49);contentPane.add(btnNewButton_1);

	JScrollPane scrollPane = new JScrollPane();scrollPane.setBounds(30,82,305,437);contentPane.add(scrollPane);

	table_1=new JTable();

	table_1.setBackground(new Color(192,192,192));table_1.setModel(new DefaultTableModel(new Object[][]{},new String[]{"id commande","id article ","quantite"}));
	DefaultTableModel modelcom = (DefaultTableModel) table_1.getModel();scrollPane.setViewportView(table_1);

	JScrollPane scrollPane_1 = new JScrollPane();scrollPane_1.setBounds(527,103,398,437);contentPane.add(scrollPane_1);

	table_2=new JTable();table_2.setBackground(new Color(192,192,192));table_2.setModel(new DefaultTableModel(new Object[][]{},new String[]{"id article ","nom article ","prix_unitaire","categorie","quantite"}));
	DefaultTableModel modelart = (DefaultTableModel) table_2.getModel();scrollPane_1.setViewportView(table_2);

	table_1.getSelectionModel().addListSelectionListener(e->
	{
		if (!e.getValueIsAdjusting()) {
			int i = table_1.getSelectedRow();
			System.out.println(i);
			idcommande.setText(modelcom.getValueAt(i, 0).toString());
			idarticle.setText(modelcom.getValueAt(i, 1).toString());
			quantite.setText(modelcom.getValueAt(i, 2).toString());
		}
	});

	btnNewButton_1.addActionListener(e->
	{
		if (idcommande.getText().trim().isEmpty()
				|| idarticle.getText().trim().isEmpty()
				|| quantite.getText().trim().isEmpty()) {

			JOptionPane.showMessageDialog(
					this,
					"Veuillez sélectionner une ligne.",
					"Erreur",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			int idcom = Integer.parseInt(idcommande.getText().trim());
			int idart = Integer.parseInt(idarticle.getText().trim());
			int qte = Integer.parseInt(quantite.getText().trim());

			if (qte <= 0) {
				JOptionPane.showMessageDialog(
						this,
						"La quantité doit être supérieure à 0.",
						"Erreur",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			boolean oldAutoCommit = connection.getAutoCommit();

			try {
				connection.setAutoCommit(false);

				// Vérifier si cette commande/article a déjà été traité.
				try (PreparedStatement stmt = connection.prepareStatement(
						"SELECT idcom FROM lignecomverification WHERE idcom = ? AND idart = ?")) {

					stmt.setInt(1, idcom);
					stmt.setInt(2, idart);

					try (ResultSet rs = stmt.executeQuery()) {
						if (rs.next()) {
							connection.rollback();

							JOptionPane.showMessageDialog(
									this,
									"Cette commande a déjà été traitée.",
									"Erreur",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
				}

				// Vérifier que le stock est suffisant.
				try (PreparedStatement checkStock = connection.prepareStatement(
						"SELECT qte FROM article WHERE idart = ?")) {

					checkStock.setInt(1, idart);

					try (ResultSet rsStock = checkStock.executeQuery()) {
						if (!rsStock.next()) {
							connection.rollback();

							JOptionPane.showMessageDialog(
									this,
									"Article introuvable.",
									"Erreur",
									JOptionPane.ERROR_MESSAGE);
							return;
						}

						int stock = rsStock.getInt("qte");

						if (stock < qte) {
							connection.rollback();

							JOptionPane.showMessageDialog(
									this,
									"Stock insuffisant. Stock disponible : " + stock,
									"Erreur",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
				}

				// Décrémenter le stock.
				int updatedRows;
				try (PreparedStatement stmt1 = connection.prepareStatement(
						"UPDATE article SET qte = qte - ? WHERE idart = ?")) {

					stmt1.setInt(1, qte);
					stmt1.setInt(2, idart);
					updatedRows = stmt1.executeUpdate();
				}

				// Enregistrer la sortie.
				int insertedRows;
				try (PreparedStatement stmt2 = connection.prepareStatement(
						"INSERT INTO lignecomverification (idcom, idart) VALUES (?, ?)")) {

					stmt2.setInt(1, idcom);
					stmt2.setInt(2, idart);
					insertedRows = stmt2.executeUpdate();
				}

				if (updatedRows > 0 && insertedRows > 0) {
					connection.commit();

					// Rafraîchir le tableau des articles.
					modelart.setRowCount(0);

					ArrayList<Article> articles = obj11.getAllArticles();

					for (Article art : articles) {
						String idarti = String.valueOf(art.getIdart());
						String nomart = String.valueOf(art.getNom());
						String prixunitaireart = String.valueOf(art.getPrix_unit());
						String categorie = String.valueOf(art.getCategorie());
						String quantiteArt = String.valueOf(art.getQte());

						modelart.addRow(new String[] {
								idarti,
								nomart,
								prixunitaireart,
								categorie,
								quantiteArt
						});
					}

					JOptionPane.showMessageDialog(
							this,
							"Modification de quantité avec succès.",
							"Succès",
							JOptionPane.INFORMATION_MESSAGE);

					idcommande.setText("");
					idarticle.setText("");
					quantite.setText("");
				} else {
					connection.rollback();

					JOptionPane.showMessageDialog(
							this,
							"Problème lors de la modification.",
							"Erreur",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (SQLException ex) {
				try {
					connection.rollback();
				} catch (SQLException rollbackEx) {
					rollbackEx.printStackTrace();
				}

				JOptionPane.showMessageDialog(
						this,
						"Erreur SQL : " + ex.getMessage(),
						"Erreur",
						JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();

			} finally {
				try {
					connection.setAutoCommit(oldAutoCommit);
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(
					this,
					"Les identifiants et la quantité doivent être numériques.",
					"Erreur",
					JOptionPane.ERROR_MESSAGE);
		}
	});

	ArrayList<LigneCommande> lignecommande = obj12.getAllLigneCommande();
	int c = 0;

	while(c<lignecommande.size())
	{
		String idcom = String.valueOf(lignecommande.get(c).getIdcom());
		String idarticle = String.valueOf(lignecommande.get(c).getIdart());
		String quantite = String.valueOf(lignecommande.get(c).getQte());

		String[] rowData = { idcom, idarticle, quantite };
		modelcom.addRow(rowData);
		c = c + 1;

	}

	System.out.println(modelcom.getColumnCount());System.out.println(modelcom.getRowCount());

	ArrayList<Article> article = obj11.getAllArticles();
	int i = 0;

	while(i<article.size())
	{
	        String idart = String.valueOf(article.get(i).getIdart());
	        String nomart =  String.valueOf(article.get(i).getNom());
	        String prixunitaireart =  String.valueOf(article.get(i).getPrix_unit());
	        String categorie =  String.valueOf(article.get(i).getCategorie());
	        String quantite = String.valueOf(article.get(i).getQte());

	        
	        String[] rowData = {idart, nomart, prixunitaireart,categorie,quantite};
	        modelart.addRow(rowData);
	        i=i+1;
			
			
		
            }

	setLocationRelativeTo(null);
}