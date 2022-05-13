package controller;


import view.Fenetre;

public class ControllerPapeterie {
	private static ControllerPapeterie instance;
	private static Fenetre f1;
	
	private ControllerPapeterie() {};

	public ControllerPapeterie getInstance(){
		if(instance == null) {
			instance  = new ControllerPapeterie();
		}
		return instance;
	}
	
	
	public static void main(String[] args) {
		f1 = new Fenetre();
	}
	
//	public static InfoLivre traitement(String titreLivre, String isbnLivre, String auteurLivre) {
//		Livre l = CatalogueManager.nouveauLivre(titreLivre, isbnLivre, auteurLivre);;
//		CatalogueManager.addLivre(l);
//		InfoLivre info = CatalogueManager.affichageCatalogue();
//		return info;
//	}
//	
//	public static InfoLivre traitement(int id, String titreLivre, String isbnLivre, String auteurLivre) {
//		Livre l = CatalogueManager.nouveauLivre(id, titreLivre, isbnLivre, auteurLivre);;
//		CatalogueManager.modifierLivre(l);
//		InfoLivre info = CatalogueManager.affichageCatalogue();
//		return info;
//	}
//	
//	public static InfoLivre traitement() {
//		InfoLivre info = CatalogueManager.affichageCatalogue();
//		return info;
//	}
//	
//	public static void traitement(int id) {
//		CatalogueManager.enleverLivre(id);
//	}
//	
//	public static void brulerAlexandrie() {
//		CatalogueManager.bruleAlexandrie();
//	}
//	
//	public static void constructionAlexandrie() {
//		CatalogueManager.constructionAlexandrie();
//	}
}
