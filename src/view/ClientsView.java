package view;

import java.awt.BorderLayout;
import model.Document;
import controller.Clients;
import controller.Utils;

import java.awt.EventQueue;
import view.Creation;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	 * The view to select your client
	 * 
	 * @param document
	 */
	public ClientsView(Document document) {

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

		/**
		 * fill in the client list
		 */
		try {
			ResultSet clientTb = clients.getClients(clients.connect());
			while (clientTb.next()) {
				String firstName = clientTb.getString("id") + " " + clientTb.getString("nom");
				list.add(firstName);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("erreur dans le getClients");
			e1.printStackTrace();
		}

		/**
		 * when we click in the list
		 */
		list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					ResultSet clientId = clients.getClientsId(clients.connect(), e.getActionCommand());
					while (clientId.next()) {
						int id = Integer.parseInt(clientId.getString("id"));
						document.setInfoClient(id);
						Creation creation = new view.Creation(document);
						creation.setVisible(true);
						setVisible(false);

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("erreur dans le getClients");
					e1.printStackTrace();
				}

			}
		});
		// setVisible(false);
		list.setBackground(Color.GRAY);
		contentPane.add(list, BorderLayout.WEST);

		JButton btnAddClient = new JButton("Ajouter un nouveau client");
		contentPane.add(btnAddClient, BorderLayout.SOUTH);

		/**
		 * Add a customer to the database
		 */
		btnAddClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AjoutClient ajoutClient = new view.AjoutClient(document);
				ajoutClient.setVisible(true);
				setDefaultCloseOperation(ClientsView.HIDE_ON_CLOSE);
				setVisible(false);
			}
		});
	}
}
