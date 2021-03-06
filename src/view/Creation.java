package view;

import java.awt.BorderLayout;
import model.Document;
import view.Resume;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.Utils;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Creation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnAjouter;
	private JButton btnFin;
	private JLabel lblQuantit;
	private JLabel lblDescription;
	private JLabel lblPrixHtva;
	private int nbrDescript = 0;

	/**
	 * The view to create an invoice or quote
	 * 
	 * @param document
	 */
	public Creation(Document document) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 99, 220, 44, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblCration = new JLabel("Création:");
		GridBagConstraints gbc_lblCration = new GridBagConstraints();
		gbc_lblCration.insets = new Insets(0, 0, 5, 5);
		gbc_lblCration.gridx = 0;
		gbc_lblCration.gridy = 0;
		contentPane.add(lblCration, gbc_lblCration);

		lblQuantit = new JLabel("Quantité");
		GridBagConstraints gbc_lblQuantit = new GridBagConstraints();
		gbc_lblQuantit.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantit.gridx = 0;
		gbc_lblQuantit.gridy = 1;
		contentPane.add(lblQuantit, gbc_lblQuantit);

		lblDescription = new JLabel("Description");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 1;
		gbc_lblDescription.gridy = 1;
		contentPane.add(lblDescription, gbc_lblDescription);

		lblPrixHtva = new JLabel("Prix unitaire HTVA");
		GridBagConstraints gbc_lblPrixHtva = new GridBagConstraints();
		gbc_lblPrixHtva.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrixHtva.gridx = 2;
		gbc_lblPrixHtva.gridy = 1;
		contentPane.add(lblPrixHtva, gbc_lblPrixHtva);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);

		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		btnAjouter = new JButton("Ajouter");
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 0);
		gbc_btnAjouter.gridx = 4;
		gbc_btnAjouter.gridy = 2;
		contentPane.add(btnAjouter, gbc_btnAjouter);

		List list_1 = new List();
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.insets = new Insets(0, 0, 0, 5);
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 0;
		gbc_list_1.gridy = 3;
		contentPane.add(list_1, gbc_list_1);

		List list_2 = new List();
		GridBagConstraints gbc_list_2 = new GridBagConstraints();
		gbc_list_2.insets = new Insets(0, 0, 0, 5);
		gbc_list_2.fill = GridBagConstraints.BOTH;
		gbc_list_2.gridx = 1;
		gbc_list_2.gridy = 3;
		contentPane.add(list_2, gbc_list_2);

		List list_3 = new List();
		GridBagConstraints gbc_list_3 = new GridBagConstraints();
		gbc_list_3.insets = new Insets(0, 0, 0, 5);
		gbc_list_3.fill = GridBagConstraints.BOTH;
		gbc_list_3.gridx = 2;
		gbc_list_3.gridy = 3;
		contentPane.add(list_3, gbc_list_3);

		List listDel = new List();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 3;
		gbc_list.gridy = 3;
		contentPane.add(listDel, gbc_list);

		/**
		 * The button add to the visual list and in the document variable
		 */
		btnAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nbrDescript = document.getDescriptionList().size();
				// Check if all values are valid
				if ((Utils.isNumeric(textField.getText()) == true) && (Utils.isNumeric(textField_1.getText()))
						&& (!textField.getText().equals("")) && (!textField_2.getText().equals(""))
						&& (!textField_1.getText().equals(""))) {
					nbrDescript++;

					int quant = Integer.parseInt(textField.getText());
					String descript = textField_2.getText();
					Double prix = Double.valueOf(textField_1.getText());

					document.addDescription(quant, descript, prix);

					list_1.add(textField.getText());
					list_2.add(descript);
					list_3.add(textField_1.getText() + " €");
					listDel.add("Supprimer ligne " + nbrDescript);
					System.out.println("Champ ok");
					textField.setText("");
					textField_2.setText("");
					textField_1.setText("");

				} else {
					System.out.println("Champ manquant");
					JFrame parent = new JFrame();

					JOptionPane.showMessageDialog(parent,
							"Erreur: Un champ est mal introduit. [Chiffre - Texte - Chiffre] ");
				}
			}
		});

		/**
		 * allows to delete a line in the document if we made a mistake
		 */
		listDel.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				int ligneSupp;
				// TODO Auto-generated method stub
				ligneSupp = Integer.parseInt(e.getActionCommand().substring(16));
				ligneSupp = ligneSupp - 1;
				System.out.println(ligneSupp);
				document.delDescription(ligneSupp);
				list_1.remove(ligneSupp);
				list_2.remove(ligneSupp);
				list_3.remove(ligneSupp);
				listDel.remove(ligneSupp);

				int s = 0;
				listDel.clear();
				for (int i = 0; i < document.getDescriptionList().size(); i++) {
					s = i + 1;
					listDel.add("Supprimer ligne " + s);
				}
			}
		});

		btnFin = new JButton("Fin");
		GridBagConstraints gbc_btnFin = new GridBagConstraints();
		gbc_btnFin.gridx = 4;
		gbc_btnFin.gridy = 3;
		contentPane.add(btnFin, gbc_btnFin);

		/**
		 * to view the summary before generating it
		 */
		btnFin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (document.getDescriptionList().size() == 0) {
					JFrame parent = new JFrame();
					JOptionPane.showMessageDialog(parent, "Vous n'avez rien encodé dans le document.");
				} else {
					Resume resume = new view.Resume(document);
					resume.setVisible(true);
					setVisible(false);
				}

			}
		});

	}

}
