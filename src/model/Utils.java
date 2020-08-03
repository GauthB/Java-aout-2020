/**
 * 
 */
package model;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 * @author gauthierbohyn
 *
 */
public class Utils {

	public String status="devis";
	public static LocalDate GetDate() {
		//Get Date Today
		ZoneId zonedId = ZoneId.of( "Europe/Paris" );
		LocalDate today = LocalDate.now( zonedId );
		
		return today;
	};
	
	public static void setStatus( boolean e) {
		//String status="";
		Utils utils = new Utils();
		if(e==true) {
			utils.status ="Devis";
		}
		else {
			utils.status ="Facture";
		}
		//System.out.println( utils.status );
	}
	
	public static  String getStatus() {
		//String status="";
		Utils utils = new Utils();
		System.out.println( utils.status );
		return utils.status ;
	}
}
