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
import Modele.LigneAchat;
import Modele.LigneCommande;
import Modele.DAO.LigneCommandeImp;
import Modele.DAO.*;

public class Ligneachat extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rechercher;
	private JTextField quantitemodifier;
	private JTable table ; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Ligneachat frame = new Ligneachat();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ligneachat() {
		LigneAchatImp obj6 = new LigneAchatImp();
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

		JLabel lblNewLabel = new JLabel("Ligne  Achat");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(335, 10, 262, 53);
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
			new Bon_achat().setVisible(true);
			setVisible(false);
		});
		btnNewButton.setBackground(new Color(249, 249, 249));
		btnNewButton.setBounds(10, 27, 154, 21);
		panel.add(btnNewButton);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(30, 102, 359, 424);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		rechercher = new JTextField();
		rechercher.setBounds(193, 111, 60, 26);
		panel_4.add(rechercher);
		rechercher.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("recherche par ID Commande :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 109, 173, 28);
		panel_4.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("recherche");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 9));

		btnNewButton_1.setBounds(261, 114, 88, 21);
		panel_4.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Recupere tous les donnes ");

		btnNewButton_2.setBounds(40, 397, 229, 21);
		panel_4.add(btnNewButton_2);

		JLabel lblNewLabel_2 = new JLabel("Modifer Quantite : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 192, 165, 26);
		panel_4.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(399, 102, 502, 424);
		contentPane.add(scrollPane);

		table = new JTable();

		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] { "id achat ", "id article", "quantite" }
		));
		scrollPane.setViewportView(table);
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		btnNewButton_1.addActionListener(e -> {
			if (rechercher.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Saisir id bon achat ", "Erreur", JOptionPane.ERROR_MESSAGE);
			} else {
				int idacha = Integer.parseInt(rechercher.getText());

				try {
					PreparedStatement stmt = connection.prepareStatement("Select idachat from ligneachat where idachat =?;");
					stmt.setInt(1, idacha);
					ResultSet rs = stmt.executeQuery();
					if (!(rs.next())) {
						JOptionPane.showMessageDialog(null, "id Bon achat non exist ", "Erreur", JOptionPane.ERROR_MESSAGE);
					} else {
						model.setRowCount(0);
						PreparedStatement stmt1 = connection.prepareStatement("select * from ligneachat where idachat = ?;");
						stmt1.setInt(1, idacha);
						ResultSet rs1 = stmt1.executeQuery();
						while (rs1.next()) {
							String idachat = String.valueOf(rs1.getInt("idachat"));
							String idarticle = String.valueOf(rs1.getInt("idart"));
							String quantite = String.valueOf(rs1.getInt("qte"));

							String[] rowData = { idachat, idarticle, quantite };
							model.addRow(rowData);
						}
						rechercher.setText("");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnNewButton_2.addActionListener(e -> {
			model.setRowCount(0);
			ArrayList<LigneAchat> ligneachat = obj6.getAllLigneAchats();
			int i = 0;

			while (i < ligneachat.size()) {
				String idachat = String.valueOf(ligneachat.get(i).getIdachat());
				String idarticle = String.valueOf(ligneachat.get(i).getIdart());
				String quantite = String.valueOf(ligneachat.get(i).getQte());

				String[] rowData = { idachat, idarticle, quantite };
				model.addRow(rowData);
				i = i + 1;
			}
		});

		table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					quantitemodifier.setText(model.getValueAt(i, 2).toString());
				}
			}
		});

		JButton btnNewButton_1_1 = new JButton("Modifer");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1_1.addActionListener(e -> {
			int i = table.getSelectedRow();
			if (i >= 0) {
				int idacha = Integer.parseInt(model.getValueAt(i, 0).toString());
				int idart = Integer.parseInt(model.getValueAt(i, 1).toString());
				int quantite = Integer.parseInt(quantitemodifier.getText().toString());

				model.setValueAt(idacha, i, 0);
				model.setValueAt(idart, i, 1);
				model.setValueAt(quantitemodifier.getText(), i, 2);
				obj6.updateLigneAchat(idacha, idart, quantite);
				table.clearSelection();

				JOptionPane.showMessageDialog(null, "Modifcation avec succes ", "Succes", JOptionPane.INFORMATION_MESSAGE);
				quantitemodifier.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Selectionne un ligne ", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnNewButton_1_1.setBounds(261, 195, 88, 21);
		panel_4.add(btnNewButton_1_1);

		JButton btnNewButton_3 = new JButton("Supprimer");
		btnNewButton_3.addActionListener(e -> {
			int i = table.getSelectedRow();
			if (i >= 0) {
				int idachat = Integer.parseInt(model.getValueAt(i, 1).toString());
				model.removeRow(i);
				obj6.deleteLigneAchat(idachat);
				JOptionPane.showMessageDialog(null, "Suppression avec succes ", "Succes", JOptionPane.INFORMATION_MESSAGE);
				table.clearSelection();
			} else {
				JOptionPane.showMessageDialog(null, "Pas de ligne selectionne", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnNewButton_3.setBounds(40, 346, 229, 21);
		panel_4.add(btnNewButton_3);

		quantitemodifier = new JTextField();
		quantitemodifier.setColumns(10);
		quantitemodifier.setBounds(193, 192, 58, 23);
		panel_4.add(quantitemodifier);

		ArrayList<LigneAchat> ligneachat = obj6.getAllLigneAchats();
		int i = 0;

		while (i < ligneachat.size()) {
			String idachat = String.valueOf(ligneachat.get(i).getIdachat());
			String idarticle = String.valueOf(ligneachat.get(i).getIdart());
			String quantite = String.valueOf(ligneachat.get(i).getQte());

			String[] rowData = { idachat, idarticle, quantite };
			model.addRow(rowData);
			i = i + 1;
		}
		setLocationRelativeTo(null);
	}
}



