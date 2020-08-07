/**
 * 
 */
package model;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Clients;

/**
 * @author gauthierbohyn
 *
 * this class is used to collect all the information for the client to whom we will send the document
 */
public class ClientInfo {

	private  int id;
	private  String nom;
	private  String TVA;
	private  String email;
	private  String adresse;
	private  String tel;
	
	/**
	 * @param id
	 * @throws SQLException
	 */
	public ClientInfo(int id) throws SQLException {
		this.id=id;
		
		Clients clients = new Clients();
		
		clients.getClientsAllId(clients.connect(),id);
		
		try {
			ResultSet clientId= clients.getClientsAllId(clients.connect(),id) ;
			while ( clientId.next() ) {
                this.nom = clientId.getString("nom");
                this.adresse = clientId.getString("adresse");
                this.TVA = clientId.getString("tva");
                this.email = clientId.getString("email");
                this.tel = clientId.getString("telephone");
            }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("erreur dans le getClients");
			e1.printStackTrace();
		}
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
