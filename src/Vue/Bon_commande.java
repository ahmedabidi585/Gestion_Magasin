
package Vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
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
import Modele.BonCommande;
import Modele.Client;
import Modele.LigneCommande;
import Modele.DAO.ArticleImp;
import Modele.DAO.BonCommandeImp;
import Modele.DAO.ClientImp;
import Modele.DAO.LigneCommandeImp;

public class Bon_commande extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idcommande;
	private JTextField datecommande;
	private JTextField idclient;
	private JTable table;
	private JTextField idarticle;
	private JTextField quantite;
	private JTable table_1;
	private JTable table_2;

	private final LigneCommandeImp ligneCommandeDao = new LigneCommandeImp();
	private final BonCommandeImp bonCommandeDao = new BonCommandeImp();
	private final ArticleImp articleDao = new ArticleImp();
	private final ClientImp clientDao = new ClientImp();
	private final Connection connection = Singleton.getConnection();
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private DefaultTableModel model2;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Bon_commande frame = new Bon_commande();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Bon_commande() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 970, 660);
		contentPane = new JPanel();
		contentPane.setBackground(UiUtils.BACKGROUND);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(UiUtils.PRIMARY);
		panel.setForeground(new Color(64, 0, 110));
		panel.setBounds(10, 10, 946, 73);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Bon Commande");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(335, 10, 262, 37);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UiUtils.PRIMARY);
		panel_1.setBounds(10, 550, 946, 73);
		contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UiUtils.PRIMARY);
		panel_2.setBounds(10, 82, 10, 507);
		contentPane.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(UiUtils.PRIMARY);
		panel_3.setBounds(946, 82, 10, 507);
		contentPane.add(panel_3);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("Menu Principale");
		btnNewButton.addActionListener(e -> UiUtils.navigate(new ResponsableVente(), Bon_commande.this));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(10, 27, 131, 21);
		panel.add(btnNewButton);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		panel_4.setBounds(48, 93, 350, 225);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		idcommande = new JTextField();
		idcommande.setBounds(160, 12, 134, 27);
		panel_4.add(idcommande);
		idcommande.setColumns(10);

		datecommande = new JTextField();
		datecommande.setColumns(10);
		datecommande.setBounds(160, 79, 134, 27);
		panel_4.add(datecommande);

		idclient = new JTextField();
		idclient.setColumns(10);
		idclient.setBounds(160, 147, 134, 27);
		panel_4.add(idclient);

		JLabel lblNewLabel_1 = new JLabel("id commande :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(28, 10, 106, 27);
		panel_4.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("date commande :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(28, 77, 136, 27);
		panel_4.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("id client ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(28, 145, 79, 27);
		panel_4.add(lblNewLabel_1_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(445, 93, 462, 150);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "id commande", "Date commande", "id Client" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(92);
		table.getColumnModel().getColumn(1).setMinWidth(26);
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();

		table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					idcommande.setText(String.valueOf(model.getValueAt(i, 0)));
					datecommande.setText(String.valueOf(model.getValueAt(i, 1)));
					idclient.setText(String.valueOf(model.getValueAt(i, 2)));
				}
			}
		});

		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(e -> ajouterBonCommande());
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(170, 10, 121, 40);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Supprimer");
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.addActionListener(e -> supprimerBonCommande());
		btnNewButton_1_1.setBounds(389, 10, 121, 40);
		panel_1.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Modifier");
		btnNewButton_1_2.setBackground(Color.WHITE);
		btnNewButton_1_2.addActionListener(e -> modifierBonCommande());
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2.setBounds(607, 10, 116, 40);
		panel_1.add(btnNewButton_1_2);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(192, 192, 192));
		panel_5.setBounds(48, 369, 350, 171);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Ajouter article a bon commande ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(82, 10, 180, 13);
		panel_5.add(lblNewLabel_2);

		idarticle = new JTextField();
		idarticle.setColumns(10);
		idarticle.setBounds(160, 33, 134, 27);
		panel_5.add(idarticle);

		quantite = new JTextField();
		quantite.setColumns(10);
		quantite.setBounds(160, 80, 134, 27);
		panel_5.add(quantite);

		JLabel lblNewLabel_1_2_1 = new JLabel("id article");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(28, 33, 79, 27);
		panel_5.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("Quantite");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(28, 80, 79, 27);
		panel_5.add(lblNewLabel_1_2_2);

		JButton btnNewButton_2 = new JButton("Ajouter article");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(229, 140, 111, 21);
		panel_5.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Ligne Commande");
		btnNewButton_3.addActionListener(e -> UiUtils.navigate(new Lignecommande(), Bon_commande.this));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(10, 140, 134, 21);
		panel_5.add(btnNewButton_3);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(445, 401, 462, 139);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "idart", "nom", "prix_unit", "categorie ", "quantite" }));
		model1 = (DefaultTableModel) table_1.getModel();
		scrollPane_1.setViewportView(table_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(445, 253, 462, 138);
		contentPane.add(scrollPane_2);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "id client", "nom", "prenom", "adresse", "tel " }));
		model2 = (DefaultTableModel) table_2.getModel();
		scrollPane_2.setViewportView(table_2);

		btnNewButton_2.addActionListener(e -> ajouterArticleAuBon());

		chargerDonnees();
		setLocationRelativeTo(null);
	}

	private void chargerDonnees() {
		model.setRowCount(0);
		for (BonCommande b : bonCommandeDao.getAllBonCommandes()) {
			model.addRow(new Object[] { b.getIdcom(), b.getDatecom(), b.getId_c() });
		}

		model1.setRowCount(0);
		for (Article a : articleDao.getAllArticles()) {
			model1.addRow(new Object[] { a.getIdart(), a.getNom(), a.getPrix_unit(), a.getCategorie(), a.getQte() });
		}

		model2.setRowCount(0);
		for (Client c : clientDao.getAllClients()) {
			model2.addRow(new Object[] { c.getId(), c.getNom(), c.getPrenom(), c.getAdresse(), c.getTel() });
		}
	}

	private void ajouterBonCommande() {
		if (UiUtils.isBlank(idcommande) || UiUtils.isBlank(datecommande) || UiUtils.isBlank(idclient)) {
			UiUtils.error(this, "Essayer de completer votre données");
			return;
		}
		try {
			int idcom = Integer.parseInt(idcommande.getText().trim());
			Date date = Date.valueOf(datecommande.getText().trim());
			int idcl = Integer.parseInt(idclient.getText().trim());

			if (bonCommandeDao.getBonCommandeById(idcom) != null) {
				UiUtils.error(this, "id commande exist déja");
				return;
			}
			if (clientDao.getClientById(idcl) == null) {
				UiUtils.error(this, "id client non exist");
				return;
			}

			bonCommandeDao.addBonCommande(new BonCommande(idcom, date, idcl));
			model.addRow(new Object[] { idcom, date, idcl });
			viderChampsBon();
			UiUtils.success(this, "Ajout bon commande avec succes");
		} catch (NumberFormatException e) {
			UiUtils.error(this, "Verifier les données saisie");
		} catch (IllegalArgumentException e) {
			UiUtils.error(this, "Date invalide (format attendu: AAAA-MM-JJ)");
		}
	}

	private void supprimerBonCommande() {
		int i = table.getSelectedRow();
		if (i < 0) {
			UiUtils.error(this, "Pas de ligne selectionnée");
			return;
		}
		int idcom = Integer.parseInt(String.valueOf(model.getValueAt(i, 0)));
		bonCommandeDao.deleteBonCommande(idcom);
		model.removeRow(i);
		viderChampsBon();
		table.clearSelection();
		UiUtils.success(this, "Suppression avec succes");
	}

	private void modifierBonCommande() {
		int i = table.getSelectedRow();
		if (i < 0) {
			UiUtils.error(this, "Pas de ligne selectionnée");
			return;
		}
		try {
			int idcom = Integer.parseInt(idcommande.getText().trim());
			Date date = Date.valueOf(datecommande.getText().trim());
			int idcl = Integer.parseInt(idclient.getText().trim());

			if (bonCommandeDao.getBonCommandeById(idcom) == null) {
				UiUtils.error(this, "id commande non exist");
				return;
			}
			if (clientDao.getClientById(idcl) == null) {
				UiUtils.error(this, "id client non exist");
				return;
			}

			bonCommandeDao.updateBonCommande(idcom, date, idcl);
			model.setValueAt(idcom, i, 0);
			model.setValueAt(date, i, 1);
			model.setValueAt(idcl, i, 2);

			viderChampsBon();
			table.clearSelection();
			UiUtils.success(this, "Modification avec succes");
		} catch (NumberFormatException e) {
			UiUtils.error(this, "Verifier les données saisie");
		} catch (IllegalArgumentException e) {
			UiUtils.error(this, "Date invalide (format attendu: AAAA-MM-JJ)");
		}
	}

	private void ajouterArticleAuBon() {
		if (UiUtils.isBlank(idcommande) || UiUtils.isBlank(idarticle) || UiUtils.isBlank(quantite)) {
			UiUtils.error(this, "Completer de saisir votre donnees");
			return;
		}
		try {
			int idcom = Integer.parseInt(idcommande.getText().trim());
			int idart = Integer.parseInt(idarticle.getText().trim());
			int qte = Integer.parseInt(quantite.getText().trim());

			if (bonCommandeDao.getBonCommandeById(idcom) == null) {
				UiUtils.error(this, "id commande non existe , ajouter un bon commande d'abord");
				return;
			}
			if (articleDao.getArticleById(idart) == null) {
				UiUtils.error(this, "identifiant de l'article non existe");
				return;
			}
			if (ligneCommandeExiste(idcom, idart)) {
				UiUtils.error(this, "identifiant de la commande client et l'article dans ligne commande deja exist");
				return;
			}

			ligneCommandeDao.addLigneCommande(new LigneCommande(idcom, idart, qte));
			idarticle.setText("");
			quantite.setText("");
			UiUtils.success(this, "Ajout article dans ligne commande avec succes");
		} catch (NumberFormatException e) {
			UiUtils.error(this, "Verifier les données saisie");
		}
	}

	private boolean ligneCommandeExiste(int idcom, int idart) {
		if (connection == null) {
			return false;
		}
		try (PreparedStatement stmt = connection
				.prepareStatement("select idcom from lignecommande where idcom = ? and idart = ?")) {
			stmt.setInt(1, idcom);
			stmt.setInt(2, idart);
			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	private void viderChampsBon() {
		idcommande.setText("");
		datecommande.setText("");
		idclient.setText("");
	}
}
