package Vue;

import java.awt.Color;
import java.awt.Component;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class UiUtils {

	public static final Color PRIMARY = new Color(0, 153, 153);
	public static final Color PRIMARY_DARK = new Color(0, 81, 81);
	public static final Color BACKGROUND = new Color(236, 255, 248);
	public static final Color TABLE_BG = new Color(192, 192, 192);

	private UiUtils() {
	}

	public static void navigate(JFrame next, JFrame current) {
		if (next != null) {
			next.setLocationRelativeTo(null);
			next.setVisible(true);
		}
		if (current != null) {
			current.dispose();
		}
	}

	public static ImageIcon loadIcon(String path) {
		if (path == null || path.isEmpty()) {
			return null;
		}
		File f = new File(path);
		return f.exists() ? new ImageIcon(f.getAbsolutePath()) : null;
	}

	public static void error(Component parent, String message) {
		JOptionPane.showMessageDialog(parent, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}

	public static void success(Component parent, String message) {
		JOptionPane.showMessageDialog(parent, message, "Succes", JOptionPane.INFORMATION_MESSAGE);
	}

	public static boolean isBlank(javax.swing.text.JTextComponent text) {
		return text.getText() == null || text.getText().trim().isEmpty();
	}
}

