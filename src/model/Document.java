/**
 * 
 */
package model;

import model.Description;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ClientInfo;

/**
 * @author gauthierbohyn this class allows to collect all the useful information
 *         for the correct filling of the document that we are going to generate
 */

public class Document {

	
	private String status;
	private ClientInfo clientInfo;
	private List<Description> descriptionList = new ArrayList<Description>();
	private Double montantTVA;
	

	
	/**
	 * @return the montantTVA
	 */
	public Double getMontantTVA() {
		return montantTVA;
	}

	/**
	 * @param montantTVA the montantTVA to set
	 */
	public void setMontantTVA(Double montantTVA) {
		this.montantTVA = montantTVA;
	}

	/**
	 * 
	 * @param status
	 */
	public Document(String status ) {
		
		// System.out.println("----");
		System.out.println(status);
		// System.out.println("----");
		this.status = status;
		
		
		
		
	}

	/**
	 * @param id
	 * @throws SQLException
	 */
	public void setInfoClient(int id) throws SQLException {

		
		DbConnect dbConnect = new DbConnect();

		dbConnect.getClientsAllId(dbConnect.connect(), id);

		try {
			ResultSet clientId = dbConnect.getClientsAllId(dbConnect.connect(), id);
			while (clientId.next()) {
				
				 this.clientInfo = new ClientInfo(id,clientId.getString("nom"),clientId.getString("adresse"),clientId.getString("tva"),clientId.getString("email"),clientId.getString("telephone"));
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("erreur dans le getClients");
			e1.printStackTrace();
		}
		
		System.out.println(this.clientInfo.getNom());
	}

	
	
	/**
	 * 
	 * @param quantite
	 * @param descript
	 * @param prix
	 */
	public void addDescription(int quantite, String descript, Double prix) {
		Description description = new Description(quantite, descript, prix);

		System.out.println(description.getQuantite());
		this.descriptionList.add(description);
	}
	/**
	 * 
	 * @param nbr
	 */
	public void delDescription(int nbr) {
		this.descriptionList.remove(nbr);
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the clientInfo
	 */
	public ClientInfo getClientInfo() {
		return clientInfo;
	}

	/**
	 * @param clientInfo the clientInfo to set
	 */
	public void setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
	}

	/**
	 * @return the descriptionList
	 */
	public List<Description> getDescriptionList() {
		return descriptionList;
	}

	/**
	 * @param descriptionList the descriptionList to set
	 */
	public void setDescriptionList(List<Description> descriptionList) {
		this.descriptionList = descriptionList;
	}


}
