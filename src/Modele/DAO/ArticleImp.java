package Modele.DAO;
import Modele.Article;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connexion.Singleton;


public class ArticleImp implements ArticleDao {
	private Connection getConnection() {
		return Singleton.getConnection();
	}

	@Override
	public void addArticle(Article article) {
		Connection connection = getConnection();
		if (connection == null) return;
		try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO article (idart, nom, prix_unit, categorie, qte) VALUES (?, ?, ?, ?, ?)")) {
			stmt.setInt(1, article.getIdart());
			stmt.setString(2, article.getNom());
			stmt.setDouble(3, article.getPrix_unit());
			stmt.setString(4, article.getCategorie());
			stmt.setInt(5, article.getQte());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Article getArticleById(int articleId) {
		Connection connection = getConnection();
		if (connection == null) return null;
		Article article = null;
		try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM article WHERE idart = ?")) {
			stmt.setInt(1, articleId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				article = new Article(rs.getInt("idart"), rs.getString("nom"), rs.getDouble("prix_unit"), rs.getString("categorie"), rs.getInt("qte"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public ArrayList<Article> getAllArticles() {
		ArrayList<Article> articles = new ArrayList<>();
		Connection connection = getConnection();
		if (connection == null) return articles;
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM article");
			while (rs.next()) {
				Article article = new Article(rs.getInt("idart"), rs.getString("nom"), rs.getDouble("prix_unit"), rs.getString("categorie"), rs.getInt("qte"));
				articles.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public void updateArticle(int idart, String nom, double prix_unit, String categorie, int qte) {
		Connection connection = getConnection();
		if (connection == null) return;
		try (PreparedStatement stmt = connection.prepareStatement("UPDATE article SET nom = ?, prix_unit = ?, categorie = ?, qte = ? WHERE idart = ?")) {
			stmt.setString(1, nom);
			stmt.setDouble(2, prix_unit);
			stmt.setString(3, categorie);
			stmt.setInt(4, qte);
			stmt.setInt(5, idart);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteArticle(int articleId) {
		Connection connection = getConnection();
		if (connection == null) return;
		try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM article WHERE idart = ?")) {
			stmt.setInt(1, articleId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}



