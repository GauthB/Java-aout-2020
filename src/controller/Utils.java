/**
 * 
 */
package controller;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 * @author gauthierbohyn
 *
 */
public class Utils implements IntUtils{

	/**
	 * 
	 * @return the current date
	 */
	public LocalDate GetDate() {
		//Get Date Today
		ZoneId zonedId = ZoneId.of( "Europe/Paris" );
		LocalDate today = LocalDate.now( zonedId );
		
		return today;
	};
	
	
	/**
	 * 
	 * @param str
	 * @return boolean if the variable is numeric
	 */
	public boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
}
