/**
 * 
 */
package model;

import java.sql.SQLException;

/**
 * @author gauthierbohyn
 *
 */
public class Administrateur extends Personne {

	
	
	private int id;
	private String webSite;
	private String NumCompte;

	/**
	 * 
	 * @param NumCompte
	 * @param webSite
	 * @param id
	 * @param nom
	 * @param TVA
	 * @param email
	 * @param adresse
	 * @param tel
	 * @throws SQLException
	 */
	public Administrateur(String NumCompte,String webSite,int id,String nom,String TVA,String email,String adresse,String tel){

		super( nom,TVA,email,adresse,tel);
		
		this.id = id;
		this.webSite=webSite;
		this.NumCompte=NumCompte;

	}

	
	
	/**
	 * @return the webSite
	 */
	public String getWebSite() {
		return webSite;
	}



	/**
	 * @param webSite the webSite to set
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}



	/**
	 * @return the numCompte
	 */
	public String getNumCompte() {
		return NumCompte;
	}



	/**
	 * @param numCompte the numCompte to set
	 */
	public void setNumCompte(String numCompte) {
		NumCompte = numCompte;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/* (non-Javadoc)
	 * @see model.Personne#getNom()
	 */
	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return super.getNom();
	}



	/* (non-Javadoc)
	 * @see model.Personne#getTVA()
	 */
	@Override
	public String getTVA() {
		// TODO Auto-generated method stub
		return super.getTVA();
	}



	/* (non-Javadoc)
	 * @see model.Personne#getEmail()
	 */
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}



	/* (non-Javadoc)
	 * @see model.Personne#getAdresse()
	 */
	@Override
	public String getAdresse() {
		// TODO Auto-generated method stub
		return super.getAdresse();
	}



	/* (non-Javadoc)
	 * @see model.Personne#getTel()
	 */
	@Override
	public String getTel() {
		// TODO Auto-generated method stub
		return super.getTel();
	}

	
	
	
}
