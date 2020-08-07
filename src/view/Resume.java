package view;

import java.awt.BorderLayout;
import controller.GeneratePdf;
import controller.Utils;
import controller.Clients;
import view.Start;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.List;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import model.Document;


import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
public class Resume extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField htva;
	private JTextField totalTVAfix;
	private JTextField totalTVACFix;
	private Double total = 0.00;
	private boolean verif = false;
	
	


	/**
	 * Create the frame.
	 */
	public Resume(Document document) {
		
		
		
		for(int i = 0; i<document.getDescriptionList().size();i++) {
			System.out.println(document.getDescriptionList().get(i).getPrix());
			Double quant = (double) document.getDescriptionList().get(i).getQuantite();
			Double finalT = quant * document.getDescriptionList().get(i).getPrix();
			total+=finalT;
		}
		
		
		int id = document.getClientInfo().getId();

		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{64, 116, 152, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
	
		JLabel lblFacture = new JLabel(document.getStatus());
		lblFacture.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_lblFacture = new GridBagConstraints();
		gbc_lblFacture.gridwidth = 2;
		gbc_lblFacture.insets = new Insets(0, 0, 5, 5);
		gbc_lblFacture.gridx = 1;
		gbc_lblFacture.gridy = 0;
		contentPane.add(lblFacture, gbc_lblFacture);
		
		Utils utils = new Utils();
		LocalDate today = Utils.GetDate();
		
		JLabel lblDate = new JLabel("Date: "+today);
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 1;
		gbc_lblDate.gridy = 1;
		contentPane.add(lblDate, gbc_lblDate);
		Clients clients = new Clients();
		
		String firstName = "";
		String adresse = "";
		String numTVA="";
		String mail = "";
		String numTel = "";
		
		try {
			ResultSet clientId= clients.getClientsAllId(clients.connect(),id) ;
			while ( clientId.next() ) {
                firstName = clientId.getString("nom");
                adresse = clientId.getString("adresse");
                numTVA = clientId.getString("tva");
                mail = clientId.getString("email");
                numTel = clientId.getString("telephone");
                System.out.println(firstName);
            }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("erreur dans le getClients");
			e1.printStackTrace();
		}
		
		JLabel lblClient = new JLabel("Client:");
		lblClient.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblClient = new GridBagConstraints();
		gbc_lblClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblClient.gridx = 0;
		gbc_lblClient.gridy = 3;
		contentPane.add(lblClient, gbc_lblClient);
		
		JLabel lblNom = new JLabel(firstName);
		lblNom.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.WEST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 4;
		contentPane.add(lblNom, gbc_lblNom);
		
		JLabel lblAdresse = new JLabel(adresse);
		lblAdresse.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.WEST;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 1;
		gbc_lblAdresse.gridy = 8;
		contentPane.add(lblAdresse, gbc_lblAdresse);
		
		JLabel lblNumroDeTva = new JLabel(numTVA);
		lblNumroDeTva.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		GridBagConstraints gbc_lblNumroDeTva = new GridBagConstraints();
		gbc_lblNumroDeTva.anchor = GridBagConstraints.WEST;
		gbc_lblNumroDeTva.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumroDeTva.gridx = 1;
		gbc_lblNumroDeTva.gridy = 9;
		contentPane.add(lblNumroDeTva, gbc_lblNumroDeTva);
		
		JLabel lblMail = new JLabel(mail);
		lblMail.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		GridBagConstraints gbc_lblMail = new GridBagConstraints();
		gbc_lblMail.anchor = GridBagConstraints.WEST;
		gbc_lblMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblMail.gridx = 1;
		gbc_lblMail.gridy = 10;
		contentPane.add(lblMail, gbc_lblMail);
		
		JLabel lblTlphone = new JLabel(numTel);
		lblTlphone.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		GridBagConstraints gbc_lblTlphone = new GridBagConstraints();
		gbc_lblTlphone.anchor = GridBagConstraints.WEST;
		gbc_lblTlphone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTlphone.gridx = 1;
		gbc_lblTlphone.gridy = 11;
		contentPane.add(lblTlphone, gbc_lblTlphone);
		
		
		
		
		List list_1 = new List();
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.insets = new Insets(0, 0, 5, 5);
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 1;
		gbc_list_1.gridy = 12;
		contentPane.add(list_1, gbc_list_1);
		
		
		List list = new List();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 2;
		gbc_list.gridy = 12;
		contentPane.add(list, gbc_list);
		

		for(int i = 0; i<document.getDescriptionList().size();i++) {
			list_1.add(Integer.toString(document.getDescriptionList().get(i).getQuantite()) +" "+document.getDescriptionList().get(i).getDescription());
			list.add(String.valueOf(document.getDescriptionList().get(i).getPrix())+" €");
		}
		
		
		JLabel lblTva = new JLabel("% TVA:");
		GridBagConstraints gbc_lblTva = new GridBagConstraints();
		gbc_lblTva.anchor = GridBagConstraints.EAST;
		gbc_lblTva.insets = new Insets(0, 0, 5, 5);
		gbc_lblTva.gridx = 0;
		gbc_lblTva.gridy = 13;
		contentPane.add(lblTva, gbc_lblTva);
		
		textField = new JTextField("21.0");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 13;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnCalculerLeTotal = new JButton("Calculer le total");
		GridBagConstraints gbc_btnCalculerLeTotal = new GridBagConstraints();
		gbc_btnCalculerLeTotal.anchor = GridBagConstraints.WEST;
		gbc_btnCalculerLeTotal.insets = new Insets(0, 0, 5, 5);
		gbc_btnCalculerLeTotal.gridx = 2;
		gbc_btnCalculerLeTotal.gridy = 13;
		contentPane.add(btnCalculerLeTotal, gbc_btnCalculerLeTotal);
		
		btnCalculerLeTotal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Resume resume = new Resume();
				try {
					double TVA = Double.parseDouble(textField.getText());
					textField.setText(TVA+"");
					
					htva.setText(total+"€");
					Double TVAfix = total*TVA/100;
					totalTVAfix.setText(TVAfix+"€");
					Double TVACFix = TVAfix+total;
					totalTVACFix.setText(TVACFix+"€");
					//lblTotalTvac.setText(TVA+"%");
					verif=true;
					
					
				}
				catch(NumberFormatException err) {
					textField.setText("Veuillez encoder un chiffre.");
				}
				
				
			}
		});
		
		JLabel lblTotal = new JLabel("Total HTVA:");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 1;
		gbc_lblTotal.gridy = 14;
		contentPane.add(lblTotal, gbc_lblTotal);
		
		htva = new JTextField();
		htva.setEditable(false);
		GridBagConstraints gbc_htva = new GridBagConstraints();
		gbc_htva.insets = new Insets(0, 0, 5, 5);
		gbc_htva.fill = GridBagConstraints.HORIZONTAL;
		gbc_htva.gridx = 2;
		gbc_htva.gridy = 14;
		contentPane.add(htva, gbc_htva);
		htva.setColumns(10);
		
		JLabel lblTotalTva = new JLabel("Total TVA:");
		GridBagConstraints gbc_lblTotalTva = new GridBagConstraints();
		gbc_lblTotalTva.anchor = GridBagConstraints.EAST;
		gbc_lblTotalTva.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalTva.gridx = 1;
		gbc_lblTotalTva.gridy = 15;
		contentPane.add(lblTotalTva, gbc_lblTotalTva);
		
		totalTVAfix = new JTextField();
		totalTVAfix.setEditable(false);
		GridBagConstraints gbc_totalTVAfix = new GridBagConstraints();
		gbc_totalTVAfix.insets = new Insets(0, 0, 5, 5);
		gbc_totalTVAfix.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalTVAfix.gridx = 2;
		gbc_totalTVAfix.gridy = 15;
		contentPane.add(totalTVAfix, gbc_totalTVAfix);
		totalTVAfix.setColumns(10);
		
		JLabel lblTotalTvac = new JLabel("Total TVAC:");
		GridBagConstraints gbc_lblTotalTvac = new GridBagConstraints();
		gbc_lblTotalTvac.anchor = GridBagConstraints.EAST;
		gbc_lblTotalTvac.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalTvac.gridx = 1;
		gbc_lblTotalTvac.gridy = 16;
		contentPane.add(lblTotalTvac, gbc_lblTotalTvac);
		
		totalTVACFix = new JTextField();
		totalTVACFix.setEditable(false);
		GridBagConstraints gbc_totalTVACFix = new GridBagConstraints();
		gbc_totalTVACFix.insets = new Insets(0, 0, 5, 5);
		gbc_totalTVACFix.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalTVACFix.gridx = 2;
		gbc_totalTVACFix.gridy = 16;
		contentPane.add(totalTVACFix, gbc_totalTVACFix);
		totalTVACFix.setColumns(10);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.RED);
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnnuler.gridx = 1;
		gbc_btnAnnuler.gridy = 17;
		contentPane.add(btnAnnuler, gbc_btnAnnuler);
		
		btnAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Start start = new view.Start();
				start.setVisible(true); 
				setVisible(false);
			}
		});
		
		JButton btnGnrer = new JButton("Générer");
		btnGnrer.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnGnrer = new GridBagConstraints();
		gbc_btnGnrer.insets = new Insets(0, 0, 0, 5);
		gbc_btnGnrer.gridx = 2;
		gbc_btnGnrer.gridy = 17;
		contentPane.add(btnGnrer, gbc_btnGnrer);
		
		btnGnrer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(verif==false) {
					JFrame parent = new JFrame();

		            JOptionPane.showMessageDialog(parent, "Le total n'a pas été calculé.");
				}else {

					setVisible(false);
					
					GeneratePdf generatePdf = new GeneratePdf(document);	
				}
				
			}
		});
	}

}
