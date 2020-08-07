/**
 * 
 */
package controller;

import  java.io.*;

import model.Document;

import java.time.LocalDate;




import javax.swing.JOptionPane;

import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import  org.apache.poi.hssf.usermodel.HSSFRow;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * @author gauthierbohyn
 *
 */


public class GeneratePdf {

	private Double totalhtva = 0.0;
	
	   public GeneratePdf(Document document) {
		   
		   String statut =document.getStatus();
		   
		   String clientNom = document.getClientInfo().getNom();
		   String clientAdresse = document.getClientInfo().getAdresse();
		   String clientTel = document.getClientInfo().getTel();
		   String clientTVA = document.getClientInfo().getTVA();
		   String clientMail = document.getClientInfo().getEmail();
		
		 
		   
	        try {
	            String filename = "Facture.xls" ;
	            HSSFWorkbook workbook = new HSSFWorkbook();
	            HSSFSheet sheet = workbook.createSheet(statut+" "+clientNom);  

	            
	            HSSFRow row0 = sheet.createRow((short)0);
	            HSSFRow row2 = sheet.createRow((short)2);
	            HSSFRow row3 = sheet.createRow((short)3);
	            HSSFRow row4 = sheet.createRow((short)4);
	            HSSFRow row5 = sheet.createRow((short)5);
	            HSSFRow row6 = sheet.createRow((short)6);
	            row0.createCell(1).setCellValue(statut);
	            row2.createCell(1).setCellValue("Wecodx");
	            row3.createCell(1).setCellValue("1, rue Sainte-Wivine");
	            row4.createCell(1).setCellValue("Malèves-Sainte-Marie");
	            row5.createCell(1).setCellValue("0472307670");
	            row6.createCell(1).setCellValue("gauthier@wecodx.com");
	            
	           
	            
	            
	            row2.createCell(3).setCellValue(clientNom);
	            row3.createCell(3).setCellValue(clientAdresse);
	            row4.createCell(3).setCellValue(clientTel);
	            row5.createCell(3).setCellValue(clientTVA);
	            row6.createCell(3).setCellValue(clientMail);

	           
	         

	    		
	    		//LocalDate today = Utils.GetDate();
	    		//System.out.println(today);
	    		int s=15;
	    		
	    		//sheet.createRow((short)s-3).createCell(1).setCellValue(today);
    			
	    		Double totalhtva = 0.0;

	    		HSSFRow rowTitle = sheet.createRow((short)s-1);
    			rowTitle.createCell(1).setCellValue("Quantité");
    			rowTitle.createCell(2).setCellValue("Description");
    			rowTitle.createCell(3).setCellValue("Prix unitaire");
    			
    			
	    		for(int i = 0; i<document.getDescriptionList().size();i++) {
	    			
	    			
	    			HSSFRow rowAll = sheet.createRow((short)s);
	    			rowAll.createCell(1).setCellValue(Integer.toString(document.getDescriptionList().get(i).getQuantite()));
	    			rowAll.createCell(2).setCellValue(document.getDescriptionList().get(i).getDescription());
	    			rowAll.createCell(3).setCellValue(String.valueOf(document.getDescriptionList().get(i).getPrix())+"€");
	    			
	    			s++;
	    			
	    		}
	    		
	    		for(int i = 0; i<document.getDescriptionList().size();i++) {
	    			System.out.println(document.getDescriptionList().get(i).getPrix());
	    			Double quant = (double) document.getDescriptionList().get(i).getQuantite();
	    			Double finalT = quant * document.getDescriptionList().get(i).getPrix();
	    			totalhtva+=finalT;
	    		}
	    		
	    		
	    		
	    	
	    		
	    		HSSFRow rowHTVA = sheet.createRow((short)s+3);
	    				rowHTVA.createCell(2).setCellValue("Total HTVA:");
	    				rowHTVA.createCell(3).setCellValue(totalhtva+" €");
	    		
	    		HSSFRow rowTotalTva = sheet.createRow((short)s+4);
	    			rowTotalTva.createCell(2).setCellValue("Total TVA:");
	    			rowTotalTva.createCell(3).setCellValue(totalhtva*21/100+" €");
	    			
	    		HSSFRow rowTotalTVAC = sheet.createRow((short)s+5);
	    			rowTotalTVAC.createCell(2).setCellValue("Total TVAC:");
	    			rowTotalTVAC.createCell(3).setCellValue(totalhtva+(totalhtva*21/100)+" €");	
	    		
	    		HSSFRow rowLast1 = sheet.createRow((short)s+9);
	    		rowLast1.createCell(2).setCellValue("BE23 0636 6641 5091");
	    		HSSFRow rowLast2 = sheet.createRow((short)s+10);
	    		rowLast2.createCell(2).setCellValue("www.wecodx.com");
	    			

	            
	            
	            FileOutputStream fileOut = new FileOutputStream(filename);
	            workbook.write(fileOut);
	            fileOut.close();
	            workbook.close();
	            System.out.println("La facture s'est générée avec succès!");
	            JFrame parent = new JFrame();

	            JOptionPane.showMessageDialog(parent, "La facture s'est générée avec succès!");

	        } catch ( Exception ex ) {
	            System.out.println(ex);
	        }
	    }
}
