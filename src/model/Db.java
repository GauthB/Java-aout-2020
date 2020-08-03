/**
 * 
 */
package model;

/**
 * @author gauthierbohyn
 *
 */

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

public class Db {

    public static void main(String[] args) {
           EventQueue.invokeLater(new Runnable() {
               public void run() {

            	   String BDD = "projetjava?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                   String url = "jdbc:mysql://localhost:8889/" + BDD;
                   String user = "root";
                   String passwd = "root";

                   try {
                       Class.forName("com.mysql.cj.jdbc.Driver");
                       System.out.println("Driver ok");
                       Connection conn = DriverManager.getConnection(url, user, passwd);
                       System.out.println("Connecter");
                   } catch (Exception e){
                       e.printStackTrace();
                       System.out.println("Erreur");
                       System.exit(0);
                   }
               }
           });
       }
}
