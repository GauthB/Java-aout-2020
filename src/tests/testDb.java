/**
 * 
 */
package tests;
import controller.Clients;
/**
 * @author gauthierbohyn
 *
 */



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author gauthierbohyn
 *
 */
public class testDb {
	

/**
 *  TestGetVaisseau
 *  Verifier si ce que l'on reçoit du getVaisseau est bien egale a la valeur de la variable vaisseau
 */
	@Test
	void testConnection() {
			Clients clients = new Clients();
			if (clients.connect()!=null) {
				System.out.print("La connection a été éffectuée");
			}
			else {
				System.out.print("Erreur de connection avec la db");
				fail("Erreur de connection avec la db");
		}  
	}
}