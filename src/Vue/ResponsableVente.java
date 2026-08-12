package Vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ResponsableVente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				ResponsableVente frame = new ResponsableVente();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public ResponsableVente() {
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

		JLabel lblNewLabel = new JLabel("Responsable de Vente :");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 17));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 0, 201, 37);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel(Login.getNom() + " " + Login.getPrenom());
		lblNewLabel_2.setForeground(new Color(192, 192, 192));
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		lblNewLabel_2.setBounds(22, 35, 278, 30);
		panel.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UiUtils.PRIMARY);
		panel_1.setBounds(10, 550, 936, 63);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton_3 = new JButton("Deconnecter");
		btnNewButton_3.addActionListener(e -> UiUtils.navigate(new Login(), ResponsableVente.this));
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 10));
		btnNewButton_3.setBounds(10, 28, 101, 25);
		panel_1.add(btnNewButton_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UiUtils.PRIMARY);
		panel_2.setBounds(10, 82, 10, 507);
		contentPane.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(UiUtils.PRIMARY);
		panel_3.setBounds(936, 82, 10, 507);
		contentPane.add(panel_3);

		JButton btnNewButton = new JButton("Client");
		btnNewButton.addActionListener(e -> UiUtils.navigate(new ClientInterface(), ResponsableVente.this));
		btnNewButton.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton.setBounds(400, 148, 205, 62);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("bon commande");
		btnNewButton_1.addActionListener(e -> UiUtils.navigate(new Bon_commande(), ResponsableVente.this));
		btnNewButton_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_1.setBounds(400, 252, 205, 62);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Recherche");
		btnNewButton_2.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton_2.setBounds(400, 350, 205, 62);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(e -> UiUtils.navigate(new Recherche(), ResponsableVente.this));

		setLocationRelativeTo(null);
	}
}

