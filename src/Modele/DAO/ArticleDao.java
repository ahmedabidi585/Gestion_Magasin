package Modele.DAO;
import java.util.List;
import Modele.Article;

public interface ArticleDao {
    void addArticle(Article article);
    Article getArticleById(int articleId);
    List<Article> getAllArticles();
    void updateArticle(int idart,String nom ,double prix_unit,String categorie, int qte );
    void deleteArticle(int articleId);

}
