package controller;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * @author gauthierbohyn
 *
 */

public class Clients {

	public Connection connect() {

		String BDD = "projetjava?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	                   String url = "jdbc:mysql://localhost:8889/" + BDD;
	                   String user = "root";
	                   String passwd = "root";

		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn = DriverManager.getConnection(url, user, passwd);
		    return conn;


		}
		catch (Exception e){

		    e.printStackTrace();
		    return null;
		}

	}


	public ResultSet getClients(Connection conn) throws SQLException {

		Statement stmt = conn.createStatement();
		ResultSet rs;
	    rs = stmt.executeQuery("SELECT * FROM clients");


		return rs;

	}

	public void insertClient(Connection conn) throws SQLException {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate("INSERT INTO clients (nom, adresse, tva, email, telephone) "
		          +"VALUES ('Michel Simon', 'Rue du Champs 18, 1000 Chimay', '0485784895', 'm.s@gmail.com','04875154556')");

		conn.close();

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
            	Clients client = new Clients();
                try {

                	//SELECT
                	ResultSet result = client.getClients(client.connect());
                	while ( result.next() ) {
                        String firstName = result.getString("nom");
                        System.out.println(firstName);
                    }


                	//INSERT
                	//client.insertClient(client.connect());



				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
	}
}