package fr.utt.LO02.VL.CestDuBrutal;

import javax.swing.*;
import java.awt.*;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI {
	public static int etudiant = 0;
	public static void main(String[] args) {
		// Création de la fenêtre principale
		JFrame frame = new JFrame("C'est du brutal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);

		// Création des champs de texte modifiables à l'aide de boutons fléchés
		JSpinner selcreditsECTS = new JSpinner();
		JSpinner seldexterite = new JSpinner();
		JSpinner selforce = new JSpinner();
		JSpinner selresistance = new JSpinner();
		JSpinner selconstitution = new JSpinner();
		JSpinner selinitiative = new JSpinner();
		JSpinner value7Spinner = new JSpinner();
		JLabel numEtu = new JLabel("Num :");
		
		// Ajout d'un écouteur à chaque champ de texte pour afficher la valeur dans la
		// console lorsqu'une flèche est appuyée
		selcreditsECTS.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("Valeur du bouton fléché 1 : " + selcreditsECTS.getValue());
			}
		});
		seldexterite.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("Valeur du bouton fléché 2 : " + seldexterite.getValue());
			}
		});
		selforce.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("Valeur du bouton fléché 3 : " + selforce.getValue());
			}
		});
		selresistance.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("Valeur du bouton fléché 4 : " + selresistance.getValue());
			}
		});
		selconstitution.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("Valeur du bouton fléché 5 : " + selconstitution.getValue());
			}
		});
		selinitiative.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("Valeur du bouton fléché 6 : " + selinitiative.getValue());
			}
		});
		value7Spinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("Valeur du bouton fléché 7 : " + value7Spinner.getValue());
			}
		});

		// Création des boîtes combinées
		String[] strategieValues = { "Attaquer", "Soigner", "Aleatoire"};
		JComboBox<String> strategieComboBox = new JComboBox<>(strategieValues);
		String[] zoneValues = { "la Bibliothèque", "le Bureau Des Etudiants", "le Quartier Administratif", "les Halles industrielles", "la Halle sportive" };
		JComboBox<String> zoneComboBox = new JComboBox<>(zoneValues);

		// Création des boutons "étudiant suivant" et "étudiant précédent"
		JButton nextStudentButton = new JButton("Étudiant suivant");
		
		nextStudentButton.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				etudiant++;
				numEtu.setText("Etudiant n°"+etudiant);
			}
		});
		// Attachement du ChangeListener au JSpinner
		
		
		JButton previousStudentButton = new JButton("Étudiant précédent");
		previousStudentButton.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				etudiant--;
				numEtu.setText("Etudiant n°"+etudiant);
			}
		});
		// Création du panneau qui contiendra tous les éléments de l'interface
		JPanel panel = new JPanel();
		panel.add(numEtu);
		panel.add(new JLabel("Crédits ECTS :"));
		panel.add(selcreditsECTS);
		panel.add(new JLabel("Dextérité :"));
		panel.add(seldexterite);
		panel.add(new JLabel("Force :"));
		panel.add(selforce);
		panel.add(new JLabel("Résistance :"));
		panel.add(selresistance);
		panel.add(new JLabel("Constitution :"));
		panel.add(selconstitution);
		panel.add(new JLabel("Initiative :"));
		panel.add(selinitiative);
		panel.add(new JLabel("Valeur 7 :"));
		panel.add(value7Spinner);
		panel.add(new JLabel("Stratégie :"));
		panel.add(strategieComboBox);
		panel.add(new JLabel("Zone :"));
		panel.add(zoneComboBox);
		panel.add(nextStudentButton);
		panel.add(previousStudentButton);

		// Ajout du panneau à la fenêtre principale
		frame.add(panel);

		// Affichage de la fenêtre
		frame.setVisible(true);
	}
	public int getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(int etudiant) {
		this.etudiant = etudiant;
	}
}