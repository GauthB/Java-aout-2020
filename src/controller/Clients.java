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
	
	public ResultSet getClientsId(Connection conn,String ref) throws SQLException {

		Statement stmt = conn.createStatement();
		ResultSet rs;
	    rs = stmt.executeQuery("SELECT id FROM clients WHERE id+' '+nom = '"+ref+"'");

		return rs;

	}
	
	public ResultSet getClientsAllId(Connection conn,int id) throws SQLException {

		Statement stmt = conn.createStatement();
		ResultSet rs;
	    rs = stmt.executeQuery("SELECT * FROM clients WHERE id='"+id+"'");

		return rs;

	}
	
	

	public void insertClient(Connection conn, String nom, String adresse,String numTVA, String mail,String numTel ) throws SQLException {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate("INSERT INTO clients (nom, adresse, tva, email, telephone) "
		          +"VALUES ('"+nom+"', '"+adresse+"', '"+numTVA+"', '"+mail+"','"+numTel+"')");

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