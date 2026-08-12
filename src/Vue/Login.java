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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Connexion.Singleton;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	private static String nom;
	private static String prenom;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Login frame = new Login();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(UiUtils.PRIMARY_DARK);
		panel.setBounds(10, 143, 356, 469);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(102, 51, 153));
		lblNewLabel_1.setBounds(56, 10, 290, 386);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(UiUtils.loadIcon("images/11.png"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UiUtils.PRIMARY);
		panel_1.setBounds(376, 10, 566, 602);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(106, 138, 353, 454);
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(UiUtils.PRIMARY);
		panel_6.setBounds(10, 10, 333, 434);
		panel_5.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(135, 10, 70, 76);
		panel_6.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(UiUtils.loadIcon("images/111-removebg-preview 1212.png"));

		textField = new JTextField();
		textField.setBounds(114, 91, 125, 26);
		panel_6.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("User Name");
		lblNewLabel_3.setBounds(21, 91, 122, 26);
		panel_6.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		lblNewLabel_3.setForeground(Color.WHITE);

		passwordField = new JPasswordField();
		passwordField.setBounds(114, 141, 125, 26);
		panel_6.add(passwordField);

		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(21, 141, 122, 26);
		panel_6.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		lblNewLabel_4.setForeground(Color.WHITE);

		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(e -> doLogin());
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		btnNewButton_1.setBounds(114, 362, 125, 21);
		panel_6.add(btnNewButton_1);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(UiUtils.loadIcon("images/152533 jj.png"));
		lblNewLabel_5.setBounds(249, 362, 74, 21);
		panel_6.add(lblNewLabel_5);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UiUtils.PRIMARY_DARK);
		panel_2.setBounds(10, 10, 356, 123);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 10, 336, 103);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(UiUtils.PRIMARY_DARK);
		panel_4.setBounds(10, 10, 316, 83);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel = new JLabel("SUPERMARKET ABIDI BENZARTI");
		lblNewLabel.setBounds(22, 22, 500, 40);
		panel_4.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.BOLD | Font.ITALIC, 7));
		lblNewLabel.setForeground(Color.WHITE);

		setLocationRelativeTo(null);
	}

	private void doLogin() {
		if (UiUtils.isBlank(textField) || passwordField.getPassword().length == 0) {
			UiUtils.error(this, "Essayer de completer vos données");
			return;
		}

		String name = textField.getText().trim();
		String passwordString = new String(passwordField.getPassword());

		int password;
		try {
			password = Integer.parseInt(passwordString);
		} catch (NumberFormatException ex) {
			UiUtils.error(this, "il faut que le mot de passe est un entier\nvérifier votre mot de passe");
			return;
		}

		Connection connection = null;
		try {
			connection = Singleton.getConnection();
			if (connection == null) {
				UiUtils.error(this, "Impossible de se connecter à la base de données");
				return;
			}

			PreparedStatement stmt = connection.prepareStatement(
					"select nom_u, prenom_u, role_user from user where nom_u = ? and password_user = ?");
			stmt.setString(1, name);
			stmt.setInt(2, password);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				nom = rs.getString("nom_u");
				prenom = rs.getString("prenom_u");
				String role = rs.getString("role_user").toLowerCase();

				if ("responsableachat".equals(role)) {
					UiUtils.navigate(new ResponsableAchat(), this);
				} else if ("responsablevente".equals(role)) {
					UiUtils.navigate(new ResponsableVente(), this);
				} else if ("magasinier".equals(role)) {
					UiUtils.navigate(new Magasinier(), this);
				} else if ("admin".equals(role)) {
					UiUtils.navigate(new Admin(), this);
				} else {
					JOptionPane.showMessageDialog(this, "Rôle inconnu: " + role, "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Aucun utilisateur trouvé avec les informations fournies.",
						"Erreur", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			UiUtils.error(this, "Erreur de base de données: " + e1.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

	public static String getNom() {
		return nom == null ? "" : nom;
	}

	public static String getPrenom() {
		return prenom == null ? "" : prenom;
	}
}

