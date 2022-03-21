package bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bo.Article;
import dal.ArticleDAO;
import dal.Connexion;

public class CatalogueManager {
	private ArticleDAO articleDao = new ArticleDAO();
	
	public CatalogueManager() {}
	
	public List<Article> getCatalogue(){
		return articleDao.selectAll();
	}
	
	public void addArticle(Article a){
		articleDao.insert(a);
	}
	
	public void updateArticle(Article a){
		articleDao.update(a);
	}
	
	public void removeArticle(int id){
		articleDao.delete(id);
	}
	
	public Article getArticle(int id){
		return articleDao.selectBy(id);
	}
	
	public void validerArticle(int id) {
		Connection cnx = Connexion.getCnx();
		String sqlPrepared = "SELECT * FROM article WHERE id = ?";
		try {
			PreparedStatement pStmt = cnx.prepareStatement(sqlPrepared);
			pStmt.setInt(1, id); // binder
			// pStmt.executeUpdate();
			ResultSet rs = pStmt.executeQuery();
			rs.next(); // extraire de la pile
			rs.getMetaData().contains("reference");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}