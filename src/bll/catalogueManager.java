package bll;

import java.util.List;

import bo.Article;
import dal.ArticleDAO;

public class catalogueManager {
	private ArticleDAO articleDao = new ArticleDAO();
	
	public catalogueManager() {}
	
	public List<Article> getCatalogue(){
		return articleDao.getCatalogue();
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
	
	public void getArticle(int id){
		articleDao.selectById(id);
	}
	
	
	
}
