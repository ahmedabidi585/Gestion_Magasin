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

import Modele.Client;
import Modele.DAO.ClientImp;

public class ClientInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idclient;
	private JTextField nomclient;
	private JTextField prenomclient;
	private JTextField adresseclient;
	private JTextField telclient;
	private JTable table_1;

	private final ClientImp clientDao = new ClientImp();
	private DefaultTableModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				ClientInterface frame = new ClientInterface();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public ClientInterface() {
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

		JLabel lblNewLabel = new JLabel("Client");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(359, 10, 201, 37);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("Menu Principale");
		btnNewButton.addActionListener(e -> UiUtils.navigate(new ResponsableVente(), ClientInterface.this));
		btnNewButton.setBackground(new Color(249, 249, 249));
		btnNewButton.setBounds(10, 27, 155, 21);
		panel.add(btnNewButton);

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
		panel_3.setBounds(936, 82, 10, 518);
		contentPane.add(panel_3);
		panel_1.setLayout(null);

		JButton btnNewButton_1_1 = new JButton("Supprimer");
		btnNewButton_1_1.addActionListener(e -> supprimerClient());
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(405, 10, 114, 41);
		panel_1.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Modifer");
		btnNewButton_1_2.addActionListener(e -> modifierClient());
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2.setBounds(638, 10, 114, 41);
		panel_1.add(btnNewButton_1_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		panel_4.setBounds(38, 100, 367, 422);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nom :");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(56, 56, 56));
		lblNewLabel_1.setBounds(47, 145, 74, 36);
		panel_4.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Prenom :");
		lblNewLabel_1_1.setForeground(new Color(56, 56, 56));
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(47, 185, 86, 36);
		panel_4.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Adresse :");
		lblNewLabel_1_2.setForeground(new Color(56, 56, 56));
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		lblNewLabel_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_2.setBounds(47, 225, 86, 36);
		panel_4.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("tel :");
		lblNewLabel_1_3.setForeground(new Color(56, 56, 56));
		lblNewLabel_1_3.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		lblNewLabel_1_3.setBackground(Color.WHITE);
		lblNewLabel_1_3.setBounds(47, 265, 74, 36);
		panel_4.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("id  :");
		lblNewLabel_1_4.setForeground(new Color(56, 56, 56));
		lblNewLabel_1_4.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		lblNewLabel_1_4.setBackground(Color.WHITE);
		lblNewLabel_1_4.setBounds(47, 105, 74, 36);
		panel_4.add(lblNewLabel_1_4);

		idclient = new JTextField();
		idclient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idclient.setBounds(131, 115, 149, 23);
		panel_4.add(idclient);
		idclient.setColumns(10);

		nomclient = new JTextField();
		nomclient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nomclient.setColumns(10);
		nomclient.setBounds(131, 150, 149, 23);
		panel_4.add(nomclient);

		prenomclient = new JTextField();
		prenomclient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		prenomclient.setColumns(10);
		prenomclient.setBounds(131, 192, 149, 23);
		panel_4.add(prenomclient);

		adresseclient = new JTextField();
		adresseclient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adresseclient.setColumns(10);
		adresseclient.setBounds(131, 231, 149, 23);
		panel_4.add(adresseclient);

		telclient = new JTextField();
		telclient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		telclient.setColumns(10);
		telclient.setBounds(131, 270, 149, 23);
		panel_4.add(telclient);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(441, 100, 473, 422);
		contentPane.add(scrollPane);

		table_1 = new JTable();
		table_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nom", "Prenom", "Adresse", "Tel" }));
		scrollPane.setViewportView(table_1);
		table_1.setBackground(UiUtils.TABLE_BG);
		model = (DefaultTableModel) table_1.getModel();

		table_1.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int i = table_1.getSelectedRow();
				if (i >= 0) {
					idclient.setText(String.valueOf(model.getValueAt(i, 0)));
					nomclient.setText(String.valueOf(model.getValueAt(i, 1)));
					prenomclient.setText(String.valueOf(model.getValueAt(i, 2)));
					adresseclient.setText(String.valueOf(model.getValueAt(i, 3)));
					telclient.setText(String.valueOf(model.getValueAt(i, 4)));
				}
			}
		});

		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(160, 10, 114, 41);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(e -> ajouterClient());

		chargerClients();
		setLocationRelativeTo(null);
	}

	private void chargerClients() {
		model.setRowCount(0);
		for (Client c : clientDao.getAllClients()) {
			model.addRow(new Object[] { c.getId(), c.getNom(), c.getPrenom(), c.getAdresse(), c.getTel() });
		}
	}

	private void ajouterClient() {
		if (UiUtils.isBlank(idclient) || UiUtils.isBlank(nomclient) || UiUtils.isBlank(prenomclient)
				|| UiUtils.isBlank(adresseclient) || UiUtils.isBlank(telclient)) {
			UiUtils.error(this, "Essayer de completer votre données");
			return;
		}
		try {
			int id = Integer.parseInt(idclient.getText().trim());
			String nom = nomclient.getText().trim();
			String prenom = prenomclient.getText().trim();
			String adresse = adresseclient.getText().trim();
			int tel = Integer.parseInt(telclient.getText().trim());

			if (clientDao.getClientById(id) != null) {
				UiUtils.error(this, "id client exist deja");
				return;
			}

			clientDao.addClient(new Client(id, nom, prenom, adresse, tel));
			model.addRow(new Object[] { id, nom, prenom, adresse, tel });
			viderChamps();
			UiUtils.success(this, "Ajouté avec succès");
		} catch (NumberFormatException e) {
			UiUtils.error(this, "Verifier les données saisie");
		}
	}

	private void modifierClient() {
		int i = table_1.getSelectedRow();
		if (i < 0) {
			UiUtils.error(this, "Pas de ligne selectionnée");
			return;
		}
		try {
			int id = Integer.parseInt(idclient.getText().trim());
			String nom = nomclient.getText().trim();
			String prenom = prenomclient.getText().trim();
			String adresse = adresseclient.getText().trim();
			int tel = Integer.parseInt(telclient.getText().trim());

			clientDao.updateClient(id, nom, prenom, adresse, tel);
			model.setValueAt(id, i, 0);
			model.setValueAt(nom, i, 1);
			model.setValueAt(prenom, i, 2);
			model.setValueAt(adresse, i, 3);
			model.setValueAt(tel, i, 4);

			viderChamps();
			table_1.clearSelection();
			UiUtils.success(this, "Modification avec succes");
		} catch (NumberFormatException e) {
			UiUtils.error(this, "Verifier les données saisie");
		}
	}

	private void supprimerClient() {
		int i = table_1.getSelectedRow();
		if (i < 0) {
			UiUtils.error(this, "Pas de ligne selectionnée");
			return;
		}
		int id = Integer.parseInt(String.valueOf(model.getValueAt(i, 0)));
		clientDao.deleteClient(id);
		model.removeRow(i);
		viderChamps();
		table_1.clearSelection();
		UiUtils.success(this, "Suppression avec succes");
	}

	private void viderChamps() {
		idclient.setText("");
		nomclient.setText("");
		prenomclient.setText("");
		adresseclient.setText("");
		telclient.setText("");
	}
}

