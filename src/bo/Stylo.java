package bo;

public class Stylo extends Article {
	private String couleur;

	public Stylo() {
	}

	public Stylo(Integer idArticle, String marque, String ref, String designation, float pu, int qte, String couleur)  {
		super(  idArticle, marque, ref, designation, pu, qte);
		setCouleur(couleur);
	}
	
	public Stylo( String marque, String ref, String designation, float pu, int qte, String couleur)  {
		super(  marque, ref, designation, pu, qte);
		setCouleur(couleur);
	}


	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		String s = String.format("%s Stylo [Couleur=%s]", super.toString(), getCouleur());

		return s;
	}
}
