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

// ✅ Correction : bon import de SingletonConnection
import Connexion.Singleton;

public class Affichage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Affichage frame = new Affichage();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Affichage() {
		// ✅ Correction : bon appel de la méthode de connexion
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
		panel.setBounds(10, 10, 936, 73);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Article en stock ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(344, 10, 270, 37);
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
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 153, 153));
		panel_2.setBounds(10, 82, 10, 507);
		contentPane.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 153, 153));
		panel_3.setBounds(936, 82, 10, 507);
		contentPane.add(panel_3);

		JButton btnNewButton_1 = new JButton("Actualiser");
		btnNewButton_1.setBounds(413, 10, 98, 27);
		panel_1.add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 93, 611, 447);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] { "id article", "nom article", "prix unitaire", "categorie", "quantite" }
		));
		table.setBackground(new Color(192, 192, 192));
		scrollPane.setViewportView(table);

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		if (connection != null) {
			try {
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM article WHERE qte > 0;");
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					String[] rowData = {
						rs.getString("idart"),
						rs.getString("nom"),
						rs.getString("prix_unit"),
						rs.getString("categorie"),
						rs.getString("qte")
					};
					model.addRow(rowData);
				}
				if (model.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Il n'existe aucun article en stock", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		btnNewButton_1.addActionListener(e -> {
			model.setRowCount(0);
			if (connection != null) {
				try {
					PreparedStatement stmt = connection.prepareStatement("SELECT * FROM article WHERE qte > 0;");
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
						String[] rowData = {
							rs.getString("idart"),
							rs.getString("nom"),
							rs.getString("prix_unit"),
							rs.getString("categorie"),
							rs.getString("qte")
						};
						model.addRow(rowData);
					}
					if (model.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Il n'existe aucun article en stock", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		setLocationRelativeTo(null);
	}
}

