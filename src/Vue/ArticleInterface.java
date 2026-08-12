package Vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Modele.Article;
import Modele.DAO.ArticleImp;

public class ArticleInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idarticle;
	private JTextField nomarticle;
	private JTextField prixunitaire;
	private JTextField categorie;
	private JTextField quantite;
	private JTable table;

	private final ArticleImp articleDao = new ArticleImp();
	private DefaultTableModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				ArticleInterface frame = new ArticleInterface();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public ArticleInterface() {
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

		JLabel lblNewLabel = new JLabel("Article");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(412, 10, 201, 37);
		panel.add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("Menu principale");
		btnNewButton_1.addActionListener(e -> UiUtils.navigate(new ResponsableAchat(), ArticleInterface.this));
		btnNewButton_1.setBounds(31, 27, 113, 21);
		panel.add(btnNewButton_1);

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

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(45, 93, 368, 436);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		idarticle = new JTextField();
		idarticle.setBounds(164, 60, 137, 25);
		panel_4.add(idarticle);
		idarticle.setColumns(10);

		nomarticle = new JTextField();
		nomarticle.setColumns(10);
		nomarticle.setBounds(164, 107, 137, 25);
		panel_4.add(nomarticle);

		prixunitaire = new JTextField();
		prixunitaire.setColumns(10);
		prixunitaire.setBounds(164, 156, 137, 25);
		panel_4.add(prixunitaire);

		categorie = new JTextField();
		categorie.setColumns(10);
		categorie.setBounds(164, 207, 137, 25);
		panel_4.add(categorie);

		JLabel lblNewLabel_1 = new JLabel("id article  :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 60, 100, 25);
		panel_4.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("nom article  : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 107, 117, 25);
		panel_4.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("prix unitaire");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 154, 117, 25);
		panel_4.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("categorie :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(10, 205, 117, 25);
		panel_4.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("quantite : ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(10, 252, 100, 25);
		panel_4.add(lblNewLabel_1_4);

		quantite = new JTextField();
		quantite.setColumns(10);
		quantite.setBounds(164, 255, 137, 24);
		panel_4.add(quantite);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(433, 93, 489, 436);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "id article ", "nom", "prix unitaire", "categorie", "quantite" }));
		model = (DefaultTableModel) table.getModel();
		table.setBackground(UiUtils.TABLE_BG);
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					idarticle.setText(String.valueOf(model.getValueAt(i, 0)));
					nomarticle.setText(String.valueOf(model.getValueAt(i, 1)));
					prixunitaire.setText(String.valueOf(model.getValueAt(i, 2)));
					categorie.setText(String.valueOf(model.getValueAt(i, 3)));
					quantite.setText(String.valueOf(model.getValueAt(i, 4)));
				}
			}
		});

		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(e -> ajouterArticle());
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(205, 19, 132, 39);
		panel_1.add(btnNewButton);

		JButton btnMofidier = new JButton("Modifier");
		btnMofidier.addActionListener(e -> modifierArticle());
		btnMofidier.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMofidier.setBounds(604, 19, 132, 39);
		panel_1.add(btnMofidier);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(e -> supprimerArticle());
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSupprimer.setBounds(403, 17, 132, 39);
		panel_1.add(btnSupprimer);
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSupprimer.setBounds(403, 17, 132, 39);
		panel_1.add(btnSupprimer);

		chargerArticles();
		setLocationRelativeTo(null);
	}

	private void chargerArticles() {
		model.setRowCount(0);
		for (Article a : articleDao.getAllArticles()) {
			model.addRow(new Object[] { a.getIdart(), a.getNom(), a.getPrix_unit(), a.getCategorie(), a.getQte() });
		}
	}

	private void ajouterArticle() {
		if (UiUtils.isBlank(idarticle) || UiUtils.isBlank(nomarticle) || UiUtils.isBlank(prixunitaire)
				|| UiUtils.isBlank(categorie) || UiUtils.isBlank(quantite)) {
			UiUtils.error(this, "Essayer de completer votre données");
			return;
		}
		try {
			int id = Integer.parseInt(idarticle.getText().trim());
			String nom = nomarticle.getText().trim();
			double prix = Double.parseDouble(prixunitaire.getText().trim());
			String cat = categorie.getText().trim();
			int qte = Integer.parseInt(quantite.getText().trim());

			if (articleDao.getArticleById(id) != null) {
				UiUtils.error(this, "id article exist deja");
				return;
			}

			articleDao.addArticle(new Article(id, cat, prix, nom, qte));
			model.addRow(new Object[] { id, nom, prix, cat, qte });
			viderChamps();
			UiUtils.success(this, "Ajout avec succes");
		} catch (NumberFormatException e) {
			UiUtils.error(this, "Verifier les données saisie");
		}
	}

	private void modifierArticle() {
		int i = table.getSelectedRow();
		if (i < 0) {
			UiUtils.error(this, "Pas de ligne selectionnée");
			return;
		}
		try {
			int id = Integer.parseInt(idarticle.getText().trim());
			String nom = nomarticle.getText().trim();
			double prix = Double.parseDouble(prixunitaire.getText().trim());
			String cat = categorie.getText().trim();
			int qte = Integer.parseInt(quantite.getText().trim());

			articleDao.updateArticle(id, nom, prix, cat, qte);
			model.setValueAt(id, i, 0);
			model.setValueAt(nom, i, 1);
			model.setValueAt(prix, i, 2);
			model.setValueAt(cat, i, 3);
			model.setValueAt(qte, i, 4);

			viderChamps();
			table.clearSelection();
			UiUtils.success(this, "Modification avec succes");
		} catch (NumberFormatException e) {
			UiUtils.error(this, "Verifier les données saisie");
		}
	}

	private void supprimerArticle() {
		int i = table.getSelectedRow();
		if (i < 0) {
			UiUtils.error(this, "Pas de ligne selectionnée");
			return;
		}
		int id = Integer.parseInt(String.valueOf(model.getValueAt(i, 0)));
		articleDao.deleteArticle(id);
		model.removeRow(i);
		viderChamps();
		table.clearSelection();
		UiUtils.success(this, "Suppression avec succes");
	}

	private void viderChamps() {
		idarticle.setText("");
		nomarticle.setText("");
		prixunitaire.setText("");
		categorie.setText("");
		quantite.setText("");
	}
}

