/**
 * 
 */
package controller;

import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import controller.Clients;

/**
 * @author gauthierbohyn
 *
 */
public class ListingClients {

	/**
	 * 
	 * @param args
	 */
	   public ListingClients() {
	
		Clients clients = new Clients();
		
		
		
		  try {
	            String filename = "Listing_clients.xls" ;
	            HSSFWorkbook workbook = new HSSFWorkbook();
	            HSSFSheet sheet = workbook.createSheet("Listing clients");  
	            
				try {
					ResultSet clientTb= clients.getClients(clients.connect()) ;
					
					HSSFRow row = sheet.createRow((short)0);
            		row.createCell(0).setCellValue("Nom");
            		row.createCell(1).setCellValue("Adresse");
            		row.createCell(2).setCellValue("Numéro de TVA");
            		row.createCell(3).setCellValue("Email");
            		row.createCell(4).setCellValue("Numéro de téléphone");
            		
					int i =1;
					while ( clientTb.next() ) {
			            String infoClient = clientTb.getString("nom")+" | "+clientTb.getString("adresse")+" | "+clientTb.getString("tva")+" | "+clientTb.getString("email")+" | "+clientTb.getString("telephone");
			            HSSFRow row1 = sheet.createRow((short)i);
			            		row1.createCell(0).setCellValue(clientTb.getString("nom"));
			            		row1.createCell(1).setCellValue(clientTb.getString("adresse"));
			            		row1.createCell(2).setCellValue(clientTb.getString("tva"));
			            		row1.createCell(3).setCellValue(clientTb.getString("email"));
			            		row1.createCell(4).setCellValue(clientTb.getString("telephone"));
			            i++;
			            System.out.println(infoClient);
			        }
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("erreur dans le getClients");
					e1.printStackTrace();
				}
			    FileOutputStream fileOut = new FileOutputStream(filename);
		        workbook.write(fileOut);
		        fileOut.close();
		        workbook.close();
		        System.out.println("Your excel file has been generated!");
		        JFrame parent = new JFrame();
		
		        JOptionPane.showMessageDialog(parent, "Le listing des clients s'est généré avec succès!");
		
		    } catch ( Exception ex ) {
		        System.out.println(ex);
		    }
	   }
	
	
	
	
}
