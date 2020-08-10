/**
 * 
 */
package model;

/**
 * @author gauthierbohyn
 *
 *         this class makes it possible to collect all the information for each
 *         description.
 */
public class Description {

	private int quantite;
	private String description;
	private Double prix;

	/**
	 * @param quantite
	 * @param description
	 * @param prix
	 */
	public Description(int quantite, String description, Double prix) {
		this.quantite = quantite;
		this.description = description;
		this.prix = prix;
	}

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the prix
	 */
	public Double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(Double prix) {
		this.prix = prix;
	}

}
