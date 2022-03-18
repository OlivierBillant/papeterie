package bo;

public class Ramette extends Article {
	private int grammage;

	public Ramette() {
		
	}

	public Ramette(Integer idArticle, String marque, String ref,  String designation, float pu, int qte, int grammage) {
		super(  idArticle, marque, ref, designation, pu, qte);
		
		setGrammage(grammage);
	}
	
	public Ramette( String marque, String ref,  String designation, float pu, int qte, int grammage) {
		super(   marque, ref, designation, pu, qte);
		setGrammage(grammage);
		
	}


	/**
	 * @return the grammage
	 */
	public int getGrammage() {
		return grammage;
	}

	/**
	 * @param grammage
	 *            the grammage to set
	 */
	public void setGrammage(int grammage) {
		this.grammage = grammage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(super.toString());
		buffer.append(" ");
		buffer.append("Ramette [grammage=");
		buffer.append(getGrammage());
		buffer.append("]");
		return buffer.toString();
	}
}
