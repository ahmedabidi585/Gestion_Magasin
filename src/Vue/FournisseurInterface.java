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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Modele.Fournisseur;
import Modele.DAO.FournisseurImp;

public class FournisseurInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField telfournisseur;
	private JTextField adressefournisseur;
	private JTextField prenomfournisseur;
	private JTextField nomfournisseur;
	private JTextField idfournisseur;
	private JTextField matriculefournisseur;
	private JTable table;

	private final FournisseurImp fournisseurDao = new FournisseurImp();
	private DefaultTableModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FournisseurInterface frame = new FournisseurInterface();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FournisseurInterface() {
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
		panel.setBounds(10, 10, 936, 73);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Fournisseur");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(359, 10, 201, 37);
		panel.add(lblNewLabel);

		JButton btnNewButton_2 = new JButton("Menu Principale");
		btnNewButton_2.addActionListener(e -> UiUtils.navigate(new ResponsableAchat(), FournisseurInterface.this));
		btnNewButton_2.setBackground(new Color(249, 249, 249));
		btnNewButton_2.setBounds(24, 27, 133, 21);
		panel.add(btnNewButton_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UiUtils.PRIMARY);
		panel_1.setBounds(10, 550, 936, 63);
		contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UiUtils.PRIMARY);
		panel_2.setBounds(10, 82, 10, 507);
		contentPane.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(UiUtils.PRIMARY);
		panel_3.setBounds(936, 82, 10, 507);
		contentPane.add(panel_3);
		panel_1.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(50, 108, 365, 414);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		telfournisseur = new JTextField();
		telfournisseur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		telfournisseur.setColumns(10);
		telfournisseur.setBounds(130, 270, 149, 23);
		panel_4.add(telfournisseur);

		adressefournisseur = new JTextField();
		adressefournisseur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adressefournisseur.setColumns(10);
		adressefournisseur.setBounds(130, 217, 149, 23);
		panel_4.add(adressefournisseur);

		prenomfournisseur = new JTextField();
		prenomfournisseur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		prenomfournisseur.setColumns(10);
		prenomfournisseur.setBounds(130, 157, 149, 23);
		panel_4.add(prenomfournisseur);

		nomfournisseur = new JTextField();
		nomfournisseur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nomfournisseur.setColumns(10);
		nomfournisseur.setBounds(130, 100, 149, 23);
		panel_4.add(nomfournisseur);

		idfournisseur = new JTextField();
		idfournisseur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idfournisseur.setColumns(10);
		idfournisseur.setBounds(130, 45, 149, 23);
		panel_4.add(idfournisseur);

		JLabel lblNewLabel_1 = new JLabel("Id : ");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		lblNewLabel_1.setBounds(22, 45, 53, 23);
		panel_4.add(lblNewLabel_1);

		matriculefournisseur = new JTextField();
		matriculefournisseur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		matriculefournisseur.setColumns(10);
		matriculefournisseur.setBounds(130, 325, 149, 23);
		panel_4.add(matriculefournisseur);

		JLabel lblNewLabel_1_1 = new JLabel("Nom : ");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(22, 100, 87, 23);
		panel_4.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Prenom : ");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(22, 157, 87, 23);
		panel_4.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Adresse :");
		lblNewLabel_1_3.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(22, 217, 87, 23);
		panel_4.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Tel : ");
		lblNewLabel_1_4.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(22, 268, 76, 23);
		panel_4.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Matricule : ");
		lblNewLabel_1_5.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(22, 326, 98, 22);
		panel_4.add(lblNewLabel_1_5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(453, 108, 450, 414);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nom", "Prenom", "Adresse", "Matricule", "Tel" }));
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
		model = (DefaultTableModel) table.getModel();

		table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					idfournisseur.setText(String.valueOf(model.getValueAt(i, 0)));
					nomfournisseur.setText(String.valueOf(model.getValueAt(i, 1)));
					prenomfournisseur.setText(String.valueOf(model.getValueAt(i, 2)));
					adressefournisseur.setText(String.valueOf(model.getValueAt(i, 3)));
					matriculefournisseur.setText(String.valueOf(model.getValueAt(i, 4)));
					telfournisseur.setText(String.valueOf(model.getValueAt(i, 5)));
				}
			}
		});

		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(e -> ajouterFournisseur());
		btnNewButton_1.setBounds(177, 10, 113, 43);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Supprimer");
		btnNewButton_1_1.addActionListener(e -> supprimerFournisseur());
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(408, 10, 113, 43);
		panel_1.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Modifer");
		btnNewButton_1_2.addActionListener(e -> modifierFournisseur());
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2.setBounds(610, 10, 113, 43);
		panel_1.add(btnNewButton_1_2);

		chargerFournisseurs();
		setLocationRelativeTo(null);
	}

	private void chargerFournisseurs() {
		model.setRowCount(0);
		for (Fournisseur f : fournisseurDao.getAllFournisseurs()) {
			model.addRow(new Object[] { f.getId(), f.getNom(), f.getPrenom(), f.getAdresse(), f.getMatricule(),
					f.getTel() });
		}
	}

	private void ajouterFournisseur() {
		if (UiUtils.isBlank(idfournisseur) || UiUtils.isBlank(nomfournisseur) || UiUtils.isBlank(prenomfournisseur)
				|| UiUtils.isBlank(adressefournisseur) || UiUtils.isBlank(matriculefournisseur)
				|| UiUtils.isBlank(telfournisseur)) {
			UiUtils.error(this, "Essayer de completer votre données");
			return;
		}
		try {
			int id = Integer.parseInt(idfournisseur.getText().trim());
			String nom = nomfournisseur.getText().trim();
			String prenom = prenomfournisseur.getText().trim();
			String adresse = adressefournisseur.getText().trim();
			int matricule = Integer.parseInt(matriculefournisseur.getText().trim());
			int tel = Integer.parseInt(telfournisseur.getText().trim());

			if (fournisseurDao.getFournisseurById(id) != null) {
				UiUtils.error(this, "id utilisateur deja exist");
				return;
			}

			fournisseurDao.addFournisseur(new Fournisseur(id, nom, prenom, adresse, matricule, tel));
			model.addRow(new Object[] { id, nom, prenom, adresse, matricule, tel });
			viderChamps();
			UiUtils.success(this, "Ajouté avec succès");
		} catch (NumberFormatException e) {
			UiUtils.error(this, "Verifier les types des données saisie");
		}
	}

	private void supprimerFournisseur() {
		int i = table.getSelectedRow();
		if (i < 0) {
			UiUtils.error(this, "Pas de ligne selectionnée");
			return;
		}
		int id = Integer.parseInt(String.valueOf(model.getValueAt(i, 0)));
		fournisseurDao.deleteFournisseur(id);
		model.removeRow(i);
		viderChamps();
		table.clearSelection();
		UiUtils.success(this, "Suppression avec succes");
	}

	private void modifierFournisseur() {
		int i = table.getSelectedRow();
		if (i < 0) {
			UiUtils.error(this, "Pas de ligne selectionnée");
			return;
		}
		try {
			int id = Integer.parseInt(idfournisseur.getText().trim());
			String nom = nomfournisseur.getText().trim();
			String prenom = prenomfournisseur.getText().trim();
			String adresse = adressefournisseur.getText().trim();
			int matricule = Integer.parseInt(matriculefournisseur.getText().trim());
			int tel = Integer.parseInt(telfournisseur.getText().trim());

			fournisseurDao.updateFournisseur(id, nom, prenom, adresse, matricule, tel);
			model.setValueAt(id, i, 0);
			model.setValueAt(nom, i, 1);
			model.setValueAt(prenom, i, 2);
			model.setValueAt(adresse, i, 3);
			model.setValueAt(matricule, i, 4);
			model.setValueAt(tel, i, 5);

			viderChamps();
			table.clearSelection();
			UiUtils.success(this, "Modification avec succes");
		} catch (NumberFormatException e) {
			UiUtils.error(this, "Verifier les types des données saisie");
		}
	}

	private void viderChamps() {
		idfournisseur.setText("");
		nomfournisseur.setText("");
		prenomfournisseur.setText("");
		adressefournisseur.setText("");
		matriculefournisseur.setText("");
		telfournisseur.setText("");
	}
}

