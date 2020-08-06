/**
 * 
 */
package model;
import model.Description;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ClientInfo;
/**
 * @author gauthierbohyn
 *
 */
public class Document {

	private String status;
	private ClientInfo clientInfo;
	private List<Description> descriptionList = new ArrayList<Description>();
	
	
	public Document(String status) {
		//System.out.println("----");
		System.out.println(status);
		//System.out.println("----");
		this.status = status;
	}
	
	public void setInfoClient(int id) throws SQLException {
		
		this.clientInfo = new ClientInfo(id);
		System.out.println(this.clientInfo.getNom());
	}
	
	public void addDescription(int quantite, String descript, Double prix) {
		Description description = new Description(quantite, descript, prix);

		System.out.println(description.getQuantite());
		this.descriptionList.add(description);
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
