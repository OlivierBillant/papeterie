package controller;

import java.util.ArrayList;
import java.util.List;

import bll.CatalogueManager;
import bo.Article;
import dal.ArticleDAO;

public class AppTest {

	public static void main(String[] args) {
		List<Article> articles = new ArrayList<>();
		ArticleDAO articleDao = new ArticleDAO();
		CatalogueManager catalogue = new CatalogueManager();
		catalogue.validerArticle(2);
	}

}
