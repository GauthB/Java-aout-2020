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
	 *  Test the connection to the database
	 */
	@Test
	void testConnection() {
			Clients clients = new Clients();
			if (clients.connect()!=null) {
				System.out.print("La connection a été éffectuée \n");
			}
			else {
				System.out.print("Erreur de connection avec la db \n");
				fail("Erreur de connection avec la db");
		}  
	}
	
	/**
	 *  Test a request
	 * Check if the database is not empty.
	 * @throws SQLException 
	 */
		@Test
		void testRequete() throws SQLException {
				Clients clients = new Clients();
				if (clients.getClients(clients.connect())!=null) {
					System.out.print("La base de données n'est pas vide \n");
				}
				else {
					System.out.print("La base de données est vide \n");
					fail("La base de données est vide");
				}  
		}
}

