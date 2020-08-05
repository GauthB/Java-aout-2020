/**
 * 
 */
package controller;

import  java.io.*;

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
	
	   public static void main(String[]args) {
		   
		   String statut ="Facture";
		   String clientNom = "Cardiomedic";
		   String clientAdresse = "1360 Perwez";
		   String clientTel = "0476958364";
		   String clientTVA = "BE22186165618";
		   String clientMail = "contact@cardiomedic.be";
		   
		   
		   
	        try {
	            String filename = "Facture.xls" ;
	            HSSFWorkbook workbook = new HSSFWorkbook();
	            HSSFSheet sheet = workbook.createSheet("Facture "+clientNom);  

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
	            
	            
	            
	            
	            row2.createCell(5).setCellValue(clientNom);
	            row3.createCell(5).setCellValue(clientAdresse);
	            row4.createCell(5).setCellValue(clientTel);
	            row5.createCell(5).setCellValue(clientTVA);
	            row6.createCell(5).setCellValue(clientMail);

	           
	            JFrame parent = new JFrame();

	            JOptionPane.showMessageDialog(parent, "La facture s'est générée avec succès!");
	            
	            
	            //HSSFRow row = sheet.createRow((short)1);
	            //row.createCell(0).setCellValue("1");
	            //row.createCell(1).setCellValue("Sankumarsingh");
	            //row.createCell(2).setCellValue("India");
	            //row.createCell(3).setCellValue("sankumarsingh@gmail.com");

	            
	            
	            FileOutputStream fileOut = new FileOutputStream(filename);
	            workbook.write(fileOut);
	            fileOut.close();
	            workbook.close();
	            System.out.println("Your excel file has been generated!");

	        } catch ( Exception ex ) {
	            System.out.println(ex);
	        }
	    }
}
