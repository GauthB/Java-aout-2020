package view;

import java.awt.BorderLayout;
import controller.Clients;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Utils;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import view.AjoutClient;
public class ClientsView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientsView frame = new ClientsView();
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
	public ClientsView() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		
		JLabel lblVeuillezSelectionnerCe = new JLabel("Veuillez selectionner votre client:");
		contentPane.add(lblVeuillezSelectionnerCe, BorderLayout.NORTH);
		Clients clients = new Clients();
		List list = new List();
		// remplissage du tableau
		try {
			ResultSet clientTb= clients.getClients(clients.connect()) ;
			while ( clientTb.next() ) {
                String firstName = clientTb.getString("id")+" "+clientTb.getString("nom");
                //System.out.println(firstName);
                list.add(firstName);
            }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("erreur dans le getClients");
			e1.printStackTrace();
		}
		
		//selectionner le client
		list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e.getActionCommand());
				
				try {
					ResultSet clientId= clients.getClientsId(clients.connect(),e.getActionCommand()) ;
					while ( clientId.next() ) {
		                String firstName = clientId.getString("id");
		                System.out.println(firstName);
		                
		            }
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("erreur dans le getClients");
					e1.printStackTrace();
				}
				
				
			}
		});
		
		list.setBackground(Color.GRAY);
		contentPane.add(list, BorderLayout.WEST);
		
		JButton btnAddClient = new JButton("Ajouter un nouveau client");
		contentPane.add(btnAddClient, BorderLayout.SOUTH);
		
		btnAddClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AjoutClient ajoutClient = new view.AjoutClient();
				ajoutClient.setVisible(true); 
				setVisible(false);
				Utils.getStatus();
			}
		});
	}

}