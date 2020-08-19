/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.ClientInfo;
/**
 * @author gauthierbohyn
 *
 */

public class DocumentPays extends Document{

	private Map<Integer, String> pays = new HashMap<Integer, String>();
	

	
	

	
	public DocumentPays(Map<Integer, String> pays, String status) {
		
		super(status);
		this.pays = pays;
	}
	
	public DocumentPays( String status) {
		
		super(status);
		addPays();
	}


	/**
	 * 
	 */
	public void addPays() {
		pays.put(1, "Belgique");
		pays.put(2, "Allemagne");
	}
	
	

	/**
	 * @return the pays
	 */
	public Map<Integer, String> getPays() {
		return pays;
	}





	/**
	 * @param pays the pays to set
	 */
	public void setPays(Map<Integer, String> pays) {
		this.pays = pays;
	}
	


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public  String toString() {
		System.out.println("--------");
		 String listPays="";
	
		 for (Object key : pays.keySet()) {
	            System.out.println(  pays.get(key));
	            
	            
	            listPays=listPays+" "+pays.get(key);
	        }
		
		 
		
		return "Liste des pays= " + listPays ;
	}
	
	
	
	
}
