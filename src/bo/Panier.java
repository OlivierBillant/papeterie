package bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eni Ecole Le panier stocke les articles sélectionnés par
 *         l'utilisateur au cours de sa navigation. Le panier n'est pas
 *         sauvegardé.
 */
public class Panier {

	// Attributs d'instance
	private List<Ligne> lignesPanier;
	private float montant;

	// Constructeurs
	public Panier() {
//		float montant;
		lignesPanier = new ArrayList<Ligne>();
	}

	// Getters et Setters
	/**
	 * @return the lignesPanier
	 */
	public final List<Ligne> getLignesPanier() {
		return lignesPanier;
	}

	/**
	 * Ajouter une ligne au panier. Le prix de la ligne est calculé (Qte*prix)
	 * 
	 * @param numero
	 * @param article
	 * @param qte
	 * 
	 */
	public void addLigne(Article article, int qte) {
		// verif qt...
		Ligne ligneAdding = new Ligne(article, qte);
		lignesPanier.add(ligneAdding);
	}

	/**
	 * Retourne la ligne sélectionnée du Panier ou null si pas trouvée
	 * 
	 * @param index
	 * @return
	 */
	public final Ligne getLigne(int index) {
		return lignesPanier.get(index); //0
	}

	
	/**
	 * Supprimer la ligne du panier. La quantité en stock augmente de la
	 * quantité associée à la ligne
	 * 
	 * @param numero
	 */
	public void removeLigne(int index) {
		// update qt...
		lignesPanier.remove(index);
	}

	/**
	 * Modifier la quantité placée dans le panier La quantité en stock augment
	 * ou diminue en fonction de cette nouvelle qté
	 * 
	 * @param index
	 * @param newQte
	 * @throws PlusEnStockException
	 */
	public void updateLigne(int index, int newQte) {
		// verif qt...
		this.getLigne(index).setQte(newQte);

	}

	public float getMontant() {
		float total= 0.0f;
		for (Ligne l :lignesPanier) {
			total += l.getPrix();
		}
		return total;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}
	/**
	 * Présenter le détail du panier
	 */
	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		bf.append("Panier : \n\n");
		for (Ligne ligne : lignesPanier) {
			bf.append("ligne " );
			bf.append( lignesPanier.indexOf(ligne) );
			bf.append( " :\t");
			bf.append(ligne.toString());
			bf.append("\n");
		}
		bf.append("\nValeur du panier : " + getMontant());
		bf.append("\n\n");
		return bf.toString();
	}
}
