/**
 * 
 */
package model;

import java.sql.SQLException;

/**
 * @author gauthierbohyn
 *
 *         this class is used to collect all the information for the client to
 *         whom we will send the document
 */
public class ClientInfo extends Personne {

	private int id;

	/**
	 * 
	 * @param id
	 * @param nom
	 * @param TVA
	 * @param email
	 * @param adresse
	 * @param tel
	 * @throws SQLException
	 */
	public ClientInfo(int id,String nom,String TVA,String email,String adresse,String tel)  {

		super( nom,TVA,email,adresse,tel);
		
		this.id = id;

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
