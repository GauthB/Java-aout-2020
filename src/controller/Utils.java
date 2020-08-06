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
public class Utils {

	
	public static LocalDate GetDate() {
		//Get Date Today
		ZoneId zonedId = ZoneId.of( "Europe/Paris" );
		LocalDate today = LocalDate.now( zonedId );
		
		return today;
	};
	
	
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
}