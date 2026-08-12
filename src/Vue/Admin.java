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

import Modele.User;
import Modele.DAO.UserImp;

public class Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField iduser;
	private JTextField nomuser;
	private JTextField prenomuser;
	private JTextField adresseuser;
	private JTextField roleuser;
	private JTextField passworduser;

	private final UserImp userDao = new UserImp();
	private DefaultTableModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Admin frame = new Admin();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Admin() {
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

		JLabel lblNewLabel = new JLabel("Admin : ");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 17));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(21, 0, 201, 37);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel(Login.getNom() + " " + Login.getPrenom());
		lblNewLabel_2.setForeground(new Color(192, 192, 192));
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		lblNewLabel_2.setBounds(22, 35, 278, 30);
		panel.add(lblNewLabel_2);

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

		JButton btnNewButton_3 = new JButton("Deconnecter");
		btnNewButton_3.addActionListener(e -> logout());
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 10));
		btnNewButton_3.setBounds(10, 28, 108, 21);
		panel_1.add(btnNewButton_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(45, 93, 368, 436);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		iduser = new JTextField();
		iduser.setBounds(154, 60, 137, 25);
		panel_4.add(iduser);
		iduser.setColumns(10);

		nomuser = new JTextField();
		nomuser.setColumns(10);
		nomuser.setBounds(154, 107, 137, 25);
		panel_4.add(nomuser);

		prenomuser = new JTextField();
		prenomuser.setColumns(10);
		prenomuser.setBounds(154, 154, 137, 25);
		panel_4.add(prenomuser);

		adresseuser = new JTextField();
		adresseuser.setColumns(10);
		adresseuser.setBounds(154, 205, 137, 25);
		panel_4.add(adresseuser);

		roleuser = new JTextField();
		roleuser.setColumns(10);
		roleuser.setBounds(154, 250, 137, 25);
		panel_4.add(roleuser);

		passworduser = new JTextField();
		passworduser.setColumns(10);
		passworduser.setBounds(154, 294, 137, 25);
		panel_4.add(passworduser);

		JLabel lblNewLabel_1 = new JLabel("id user :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 60, 100, 25);
		panel_4.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("nom user : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 107, 100, 25);
		panel_4.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("prenom user : ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 154, 117, 25);
		panel_4.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("adresse user : ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(10, 205, 117, 25);
		panel_4.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("role user : ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(10, 250, 100, 25);
		panel_4.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("password user :");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(10, 294, 134, 25);
		panel_4.add(lblNewLabel_1_5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(455, 93, 469, 430);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(UiUtils.TABLE_BG);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nom", "Prenom ", "Adresse",
				"role user ", "Password" }));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();

		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(e -> ajouterUtilisateur());
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(205, 19, 132, 39);
		panel_1.add(btnNewButton);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(e -> supprimerUtilisateur());
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSupprimer.setBounds(402, 19, 132, 39);
		panel_1.add(btnSupprimer);

		JButton btnMofidier = new JButton("Modifier");
		btnMofidier.addActionListener(e -> modifierUtilisateur());
		btnMofidier.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMofidier.setBounds(604, 19, 132, 39);
		panel_1.add(btnMofidier);

		table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					iduser.setText(String.valueOf(model.getValueAt(i, 0)));
					nomuser.setText(String.valueOf(model.getValueAt(i, 1)));
					prenomuser.setText(String.valueOf(model.getValueAt(i, 2)));
					adresseuser.setText(String.valueOf(model.getValueAt(i, 3)));
					roleuser.setText(String.valueOf(model.getValueAt(i, 4)));
					passworduser.setText(String.valueOf(model.getValueAt(i, 5)));
				}
			}
		});

		chargerUtilisateurs();
		setLocationRelativeTo(null);
	}

	private void chargerUtilisateurs() {
		model.setRowCount(0);
		ArrayList<User> users = userDao.getAllUsers();
		for (User u : users) {
			model.addRow(new Object[] { u.getId(), u.getNom(), u.getPrenom(), u.getAdresse(), u.getRole(),
					u.getPassword_user() });
		}
	}

	private void ajouterUtilisateur() {
		if (UiUtils.isBlank(iduser) || UiUtils.isBlank(nomuser) || UiUtils.isBlank(prenomuser)
				|| UiUtils.isBlank(adresseuser) || UiUtils.isBlank(roleuser) || UiUtils.isBlank(passworduser)) {
			UiUtils.error(this, "Essayer de compléter vos données");
			return;
		}

		String role = roleuser.getText().trim();
		if (!"responsableachat".equals(role) && !"responsablevente".equals(role) && !"magasinier".equals(role)
				&& !"admin".equals(role)) {
			UiUtils.error(this, "Vérifiez le rôle de l'utilisateur");
			return;
		}

		try {
			int id = Integer.parseInt(iduser.getText().trim());
			int pass = Integer.parseInt(passworduser.getText().trim());

			for (User p : userDao.getAllUsers()) {
				if (p.getPassword_user() == pass) {
					UiUtils.error(this, "Password déjà existant");
					return;
				}
			}

			User u = new User(id, nomuser.getText().trim(), prenomuser.getText().trim(), adresseuser.getText().trim(),
					role, pass);
			userDao.addUser(u);
			model.addRow(new Object[] { u.getId(), u.getNom(), u.getPrenom(), u.getAdresse(), u.getRole(), pass });
			viderChamps();
			UiUtils.success(this, "Ajouté avec succès");
		} catch (NumberFormatException e) {
			UiUtils.error(this, "ID et Mot de passe doivent être des entiers");
		}
	}

	private void supprimerUtilisateur() {
		int i = table.getSelectedRow();
		if (i < 0) {
			UiUtils.error(this, "Pas de ligne selectionnée");
			return;
		}
		try {
			int id = Integer.parseInt(String.valueOf(model.getValueAt(i, 0)));
			userDao.deleteUser(id);
			model.removeRow(i);
			viderChamps();
			table.clearSelection();
			UiUtils.success(this, "Suppression avec succes");
		} catch (NumberFormatException e) {
			UiUtils.error(this, "ID invalide");
		}
	}

	private void modifierUtilisateur() {
		int i = table.getSelectedRow();
		if (i < 0) {
			UiUtils.error(this, "Pas de ligne selectionnée");
			return;
		}
		try {
			int id = Integer.parseInt(iduser.getText().trim());
			int pass = Integer.parseInt(passworduser.getText().trim());
			String nom = nomuser.getText().trim();
			String prenom = prenomuser.getText().trim();
			String adresse = adresseuser.getText().trim();
			String role = roleuser.getText().trim();

			userDao.updateUser(id, nom, prenom, adresse, role, pass);
			model.setValueAt(id, i, 0);
			model.setValueAt(nom, i, 1);
			model.setValueAt(prenom, i, 2);
			model.setValueAt(adresse, i, 3);
			model.setValueAt(role, i, 4);
			model.setValueAt(pass, i, 5);

			viderChamps();
			table.clearSelection();
			UiUtils.success(this, "Modification avec succès");
		} catch (NumberFormatException e) {
			UiUtils.error(this, "ID et Mot de passe doivent être des entiers");
		}
	}

	private void viderChamps() {
		iduser.setText("");
		nomuser.setText("");
		prenomuser.setText("");
		adresseuser.setText("");
		roleuser.setText("");
		passworduser.setText("");
	}

	private void logout() {
		UiUtils.navigate(new Login(), this);
	}
}

