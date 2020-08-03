package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import view.AjoutClient;
public class Clients extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clients frame = new Clients();
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
	public Clients() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		
		JLabel lblVeuillezSelectionnerCe = new JLabel("Veuillez selectionner votre client:");
		contentPane.add(lblVeuillezSelectionnerCe, BorderLayout.NORTH);
		
		List list = new List();
		list.add("a");
	      list.add("b");
	      list.add("c");
	      list.add("d");
	      list.add("e");
	      list.add("f");
	      list.add("a");
	      list.add("b");
	      list.add("c");
	      list.add("d");
	      list.add("e");
	      list.add("f");
	      list.add("a");
	      list.add("b");
	      list.add("c");
	      list.add("d");
	      list.add("e");
	      list.add("f");
	      list.add("a");
	      list.add("b");
	      list.add("c");
	      list.add("d");
	      list.add("e");
	      list.add("f");
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
			}
		});
	}

}
