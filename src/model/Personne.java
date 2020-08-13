/**
 * 
 */
package model;

/**
 * @author gauthierbohyn
 *
 */
public class Personne {


	private String nom;
	private String TVA;
	private String email;
	private String adresse;
	private String tel;
	
	
	public Personne(String nom,String TVA,String email,String adresse,String tel){
		this.nom = nom;
		this.TVA = TVA;
		this.email = email;
		this.adresse = adresse;
		this.tel = tel;
	}


	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**
	 * @return the tVA
	 */
	public String getTVA() {
		return TVA;
	}


	/**
	 * @param tVA the tVA to set
	 */
	public void setTVA(String tVA) {
		TVA = tVA;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}


	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}


	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
}
