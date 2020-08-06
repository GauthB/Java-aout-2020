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

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

/**
 * @author gauthierbohyn
 *
 */
public class testDb {
	

/**
 *  Tester la connexion à la base de données
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
	
	/**
	 *  Tester une requete 
	 *  Vérifier si la base de données n'est pas vide.
	 * @throws SQLException 
	 */
		@Test
		void testRequete() throws SQLException {
				Clients clients = new Clients();
				if (clients.getClients(clients.connect())!=null) {
					System.out.print("La base de données n'est pas vide");
				}
				else {
					System.out.print("La base de données est vide");
					fail("La base de données est vide");
				}  
		}
}

