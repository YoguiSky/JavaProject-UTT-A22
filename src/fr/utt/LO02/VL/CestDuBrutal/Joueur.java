package fr.utt.LO02.VL.CestDuBrutal;

import java.util.*;

public class Joueur {

	private int nbZonesControlees;
	private int nbPoints;
	private String nomJoueur;
	private Map<Integer, Etudiant> etudiantsDispo = new LinkedHashMap<>();

	private enum faction {
		ISI, MTE, A2I, RT, GM, MM, GI,
	};

	/**
	 * constructeur de la classe Joueur
	 * 
	 * @param nomJoueur
	 */
	public Joueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
		this.nbPoints = 15;
		
		
		//Joueur this = new Joueur("this");
		boolean next = true;
		Scanner entree = new Scanner(System.in);
		for (int i = 0; i < 5; ++i) {
			System.out.println("Etudiant : " + i);
			next = true;
			this.etudiantsDispo.put(i, new Etudiant(false, 10, 10, 10, 10, 10));
			while (this.getNbPoints() > 0 && next == true) {
				System.out.println(
						"Choisissez un paramêtre à modifier :\n1-dexterite\n2-force\n3-resistance\n4-initiative\n5-constitution\n6-etudiant suivant\nvous avez "
								+ this.getNbPoints() + " crédits");
				int competence = entree.nextInt();
				int points_a_ajouter;
				switch (competence) {
				case 1:
					System.out.println("votre etudiant possède " + this.etudiantsDispo.get(i).getDexterite()
							+ " de dexterite, entrez la valeur à lui ajouter :");
					points_a_ajouter = entree.nextInt();
					if (this.getNbPoints() - points_a_ajouter >= 0) {
						this.setNbPoints(this.getNbPoints() - points_a_ajouter);
						this.etudiantsDispo.get(i)
								.setDexterite(this.etudiantsDispo.get(i).getDexterite() + points_a_ajouter);

						System.out.println("L'etudiant numéro " + i + " a maintenant "
								+ this.etudiantsDispo.get(i).getDexterite() + " de dexterite");
					} else {
						System.out.println("Pas assez de crédits !");
					}
					break;
				case 2:
					System.out.println("votre etudiant possède " + this.etudiantsDispo.get(i).getForce()
							+ " de force, entrez la valeur à lui ajouter :");
					points_a_ajouter = entree.nextInt();
					if (this.getNbPoints() - points_a_ajouter >= 0) {
						this.setNbPoints(this.getNbPoints() - points_a_ajouter);
						this.etudiantsDispo.get(i).setForce(this.etudiantsDispo.get(i).getForce() + points_a_ajouter);

						System.out.println("L'etudiant numéro " + i + " a maintenant "
								+ this.etudiantsDispo.get(i).getForce() + " de force");
					} else {
						System.out.println("Pas assez de crédits !");
					}
					break;
				case 6:
					next = false;
					break;
					
				}

			}
		}
		entree.close();
		// ajouter la définition de la faction du joueur
	}

	/**
	 * @return the nbZonesControlees
	 */
	public int getNbZonesControlees() {
		return nbZonesControlees;
	}

	/**
	 * @param nbZonesControlees the nbZonesControlees to set
	 */
	public void setNbZonesControlees(int nbZonesControlees) {
		this.nbZonesControlees = nbZonesControlees;
	}

	/**
	 * @return the nbPoints
	 */
	public int getNbPoints() {
		return nbPoints;
	}

	/**
	 * @param nbPoints the nbPoints to set
	 */
	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	/**
	 * @return the nomJoueur
	 */
	public String getNomJoueur() {
		return nomJoueur;
	}

	/**
	 * @param nomJoueur the nomJoueur to set
	 */
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public void affecterTroupes(Etudiant EtuAffecte, Zone zoneAffectee, int nbTroupes) {

	}

	public void affecterPoints(Etudiant PointsEtu, int nbPoints) {

	}

	public void definirStrategie(Etudiant strategieEtu, Strategie typeStrategie) {

	}

	public void choixReserviste(Etudiant EtuReserviste, boolean EstReserviste) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Joueur toto = new Joueur("toto");
		System.out.println(toto.getNomJoueur());
	}

}
