package controller;

import java.util.ArrayList;
import java.util.List;

import model.bll.CatalogueManager;
import model.bo.Article;
import model.bo.Ramette;
import model.bo.Stylo;

public class AppliTestBLL {

	public static void main(String[] args) {
		// Instanciation du jeu d'essai
		List<Article> articles = new ArrayList<>();
		Stylo stylo = new Stylo("Bic", "BBOrange", "Bic bille Orange", 1.2f, 20, "bleu");
		articles.add(stylo);
		articles.add(new Ramette("Clairef", "CRA4S", "Ramette A4 Sup", 9f, 20, 80));
		articles.add(new Stylo("Stypen", "PlumeS", "Stylo Plume Stypen", 5.5f, 20, "jaune"));
		articles.add(new Stylo("Waterman", "WOBGreen", "Waterman Orion Bille vert", 4.2f, 35, "vert"));
		articles.add(new Ramette("ProDesign", "ForLaser", "A4 Special laser", 5.5f, 55, 100));

		CatalogueManager mger = new CatalogueManager();

		for (Article art : articles) {
			mger.addArticle(art);
		}
//		System.out.println(mger.getCatalogue());
		List<Article> catalogue = mger.getCatalogue();
		for (Article article : catalogue) {
			System.out.println(article);
		}

		((Stylo) stylo).setCouleur("noir");
		((Stylo) stylo).setDesignation("Bic bille noir");
		((Stylo) stylo).setReference("BBNoir");
		mger.updateArticle(stylo);
		System.out.println("Article apr�s modification  : " + stylo.toString());

		mger.removeArticle(stylo.getIdArticle());
		
//		System.out.println(mger.getCatalogue());
		catalogue = mger.getCatalogue();
		for (Article article : catalogue) {
			System.out.println(article);
		}
	}

}
