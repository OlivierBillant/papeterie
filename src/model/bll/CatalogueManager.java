package model.bll;


import java.util.List;

import model.bo.Article;
import model.dal.ArticleDAO;

public class CatalogueManager {
	private ArticleDAO articleDao;
	
	
	
	public CatalogueManager() {
		articleDao = new ArticleDAO();
	}
	
	public List<Article> getCatalogue(){
		List<Article> articles = null;
		articles = articleDao.selectAll();
		//erreur de connexion à traiter
		return articles; // aussi possible return articleDao.selecAll();
	}
	
	public void addArticle(Article newArticle){
		//valider article avant ajout
		articleDao.insert(newArticle);
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
	
	private void validerArticle(Article a) {
		String str = "";
		if ((a.getReference() == null) || 
			(a.getReference().length() == 0) || 
			(a.getReference().trim().length() == 0)){
			str = "La référence n'est pas valide";
		}
		//utiliser str pour remonter l'exception au controller.
		
		
	}
}