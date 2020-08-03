package view;

import java.awt.BorderLayout;
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

import javax.swing.JTextField;
import javax.swing.JButton;
import view.Clients;
public class AjoutClient extends JFrame {

	private JPanel contentPane;
	private JTextField inputTel;
	private JTextField inputMail;
	private JTextField inputTva;
	private JTextField inputAdresse;
	private JTextField inputNom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutClient frame = new AjoutClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AjoutClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblAjoutDunClient = new JLabel("Ajout d'un client:");
		GridBagConstraints gbc_lblAjoutDunClient = new GridBagConstraints();
		gbc_lblAjoutDunClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblAjoutDunClient.gridx = 0;
		gbc_lblAjoutDunClient.gridy = 0;
		contentPane.add(lblAjoutDunClient, gbc_lblAjoutDunClient);
		
		JLabel lblNom = new JLabel("Nom:");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 2;
		contentPane.add(lblNom, gbc_lblNom);
		
		inputNom = new JTextField();
		GridBagConstraints gbc_inputNom = new GridBagConstraints();
		gbc_inputNom.insets = new Insets(0, 0, 5, 0);
		gbc_inputNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputNom.gridx = 1;
		gbc_inputNom.gridy = 2;
		contentPane.add(inputNom, gbc_inputNom);
		inputNom.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.EAST;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 0;
		gbc_lblAdresse.gridy = 3;
		contentPane.add(lblAdresse, gbc_lblAdresse);
		
		inputAdresse = new JTextField();
		GridBagConstraints gbc_inputAdresse = new GridBagConstraints();
		gbc_inputAdresse.insets = new Insets(0, 0, 5, 0);
		gbc_inputAdresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputAdresse.gridx = 1;
		gbc_inputAdresse.gridy = 3;
		contentPane.add(inputAdresse, gbc_inputAdresse);
		inputAdresse.setColumns(10);
		
		JLabel lblNumTva = new JLabel("Num TVA:");
		GridBagConstraints gbc_lblNumTva = new GridBagConstraints();
		gbc_lblNumTva.anchor = GridBagConstraints.EAST;
		gbc_lblNumTva.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumTva.gridx = 0;
		gbc_lblNumTva.gridy = 4;
		contentPane.add(lblNumTva, gbc_lblNumTva);
		
		inputTva = new JTextField();
		GridBagConstraints gbc_inputTva = new GridBagConstraints();
		gbc_inputTva.insets = new Insets(0, 0, 5, 0);
		gbc_inputTva.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputTva.gridx = 1;
		gbc_inputTva.gridy = 4;
		contentPane.add(inputTva, gbc_inputTva);
		inputTva.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail:");
		GridBagConstraints gbc_lblMail = new GridBagConstraints();
		gbc_lblMail.anchor = GridBagConstraints.EAST;
		gbc_lblMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblMail.gridx = 0;
		gbc_lblMail.gridy = 5;
		contentPane.add(lblMail, gbc_lblMail);
		
		inputMail = new JTextField();
		GridBagConstraints gbc_inputMail = new GridBagConstraints();
		gbc_inputMail.insets = new Insets(0, 0, 5, 0);
		gbc_inputMail.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputMail.gridx = 1;
		gbc_inputMail.gridy = 5;
		contentPane.add(inputMail, gbc_inputMail);
		inputMail.setColumns(10);
		
		JLabel lblTlphone = new JLabel("Téléphone:");
		GridBagConstraints gbc_lblTlphone = new GridBagConstraints();
		gbc_lblTlphone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTlphone.anchor = GridBagConstraints.EAST;
		gbc_lblTlphone.gridx = 0;
		gbc_lblTlphone.gridy = 6;
		contentPane.add(lblTlphone, gbc_lblTlphone);
		
		inputTel = new JTextField();
		GridBagConstraints gbc_inputTel = new GridBagConstraints();
		gbc_inputTel.insets = new Insets(0, 0, 5, 0);
		gbc_inputTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputTel.gridx = 1;
		gbc_inputTel.gridy = 6;
		contentPane.add(inputTel, gbc_inputTel);
		inputTel.setColumns(10);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		GridBagConstraints gbc_btnEnregistrer = new GridBagConstraints();
		gbc_btnEnregistrer.gridx = 1;
		gbc_btnEnregistrer.gridy = 8;
		contentPane.add(btnEnregistrer, gbc_btnEnregistrer);
		
		btnEnregistrer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Clients clients = new view.Clients();
				clients.setVisible(true); 
				setVisible(false);
			}
		});
	}

}
