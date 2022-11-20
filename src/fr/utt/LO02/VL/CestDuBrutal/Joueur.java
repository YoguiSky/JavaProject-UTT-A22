package fr.utt.LO02.VL.CestDuBrutal;

import java.util.*;

public class Joueur {

	private int nbZonesControlees;
	private int nbPoints;
	private String nomJoueur;
	private Map<Integer, Etudiant> etudiantsDispo = new LinkedHashMap<>();
	private Faction factionJoueur = null;

	/**
	 * constructeur de la classe Joueur
	 * 
	 * @param nomJoueur
	 */
	public Joueur() {
		Scanner entree = new Scanner(System.in);
		System.out.println("Choisissez un nom :");
		this.nomJoueur = entree.next();
		while (this.factionJoueur == null) {
			System.out.println(
					"Entrez le chiffre correspondant a la faction que vous choisissez : \n1-ISI\n2-MTE\n3-A2I\n4-RT\n5-GM\n6-MM\n7-GI");
			switch (entree.nextInt()) {
			case 1:
				this.factionJoueur = Faction.ISI;
				break;
			case 2:
				this.factionJoueur = Faction.MTE;
				break;
			case 3:
				this.factionJoueur = Faction.A2I;
				break;
			case 4:
				this.factionJoueur = Faction.RT;
				break;
			case 5:
				this.factionJoueur = Faction.GM;
				break;
			case 6:
				this.factionJoueur = Faction.MM;
				break;
			case 7:
				this.factionJoueur = Faction.GI;
				break;
			default:
				System.out.println("Faction non reconnue");
				break;
			}
		}
		this.nbPoints = 15;

		// Joueur this = new Joueur("this");
		boolean next = true;

		for (int i = 0; i < 5; i++) {
			next = true;
			this.etudiantsDispo.put(i, new Etudiant(false, 10, 10, 10, 10, 10));
			while (this.getNbPoints() > 0 && next == true) {
				System.out.println("Etudiant : " + i);
				System.out.println(
						"Choisissez un paramêtre à modifier :\n1-dexterite\n2-force\n3-resistance\n4-initiative\n5-constitution\n6-etudiant suivant\n7-etudiant précédent\nvous avez "
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
				case 3:
					System.out.println("votre etudiant possède " + this.etudiantsDispo.get(i).getResistance()
							+ " de résistance, entrez la valeur à lui ajouter :");
					points_a_ajouter = entree.nextInt();
					if (this.getNbPoints() - points_a_ajouter >= 0) {
						this.setNbPoints(this.getNbPoints() - points_a_ajouter);
						this.etudiantsDispo.get(i)
								.setResistance(this.etudiantsDispo.get(i).getResistance() + points_a_ajouter);

						System.out.println("L'etudiant numéro " + i + " a maintenant "
								+ this.etudiantsDispo.get(i).getResistance() + " de résistance");
					} else {
						System.out.println("Pas assez de crédits !");
					}
					break;
				case 4:
					System.out.println("votre etudiant possède " + this.etudiantsDispo.get(i).getInitiative()
							+ " d'initiative, entrez la valeur à lui ajouter :");
					points_a_ajouter = entree.nextInt();
					if (this.getNbPoints() - points_a_ajouter >= 0) {
						this.setNbPoints(this.getNbPoints() - points_a_ajouter);
						this.etudiantsDispo.get(i)
								.setInitiative(this.etudiantsDispo.get(i).getInitiative() + points_a_ajouter);

						System.out.println("L'etudiant numéro " + i + " a maintenant "
								+ this.etudiantsDispo.get(i).getInitiative() + " d'initiative");
					} else {
						System.out.println("Pas assez de crédits !");
					}
					break;
				case 5:
					System.out.println("votre etudiant possède " + this.etudiantsDispo.get(i).getConstitution()
							+ " de constitution, entrez la valeur à lui ajouter :");
					points_a_ajouter = entree.nextInt();
					if (this.getNbPoints() - points_a_ajouter >= 0) {
						this.setNbPoints(this.getNbPoints() - points_a_ajouter);
						this.etudiantsDispo.get(i)
								.setConstitution(this.etudiantsDispo.get(i).getConstitution() + points_a_ajouter);

						System.out.println("L'etudiant numéro " + i + " a maintenant "
								+ this.etudiantsDispo.get(i).getConstitution() + " de constitution");
					} else {
						System.out.println("Pas assez de crédits !");
					}
					break;
				case 6:// suivant
					next = false;
					break;
				case 7:// précédent
					next = false;
					if (i - 2 >= 0) {
						i -= 2;
					}
					break;
				default:
					System.out.println("veuillez entrer une des valeurs propose");
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
		EtuReserviste.setReserviste(EstReserviste);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Joueur toto = new Joueur();
		System.out.println(toto.getNomJoueur());
	}

}
