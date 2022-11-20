package fr.utt.LO02.VL.CestDuBrutal;

import java.util.*;

public class Joueur {

	private int nbZonesControlees;
	private int nbPoints = 400;
	private String nomJoueur;
	private Map<Integer, Etudiant> etudiantsDispo = new LinkedHashMap<>();
	private Faction factionJoueur = null;

	/**
	 * constructeur de la classe Joueur
	 * 
	 * @param nomJoueur
	 */

	public Joueur() {
		Attaquer attaquer = new Attaquer();
		Soigner soigner = new Soigner();
		Aleatoire aleatoire = new Aleatoire();

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

		for (int i = 1; i <= 20; i++) {
			next = true;

			if (i <= 15) {
				System.out.println("Etudiant n° " + i);
				this.etudiantsDispo.put(i, new Etudiant(false, 0, 0, 0, 0, 0));
			} else if (i > 15 && i <= 19) {
				System.out.println("Etudiant d'élite n° " + (i - 15));
				this.etudiantsDispo.put(i, new Etudiant(false, 1, 1, 1, 5, 1));
			} else if (i > 19) {
				System.out.println("Maitre du gobi");
				this.etudiantsDispo.put(i, new Etudiant(false, 2, 2, 2, 10, 2));
			}

			while (this.getNbPoints() > 0 && next == true) {
				System.out.println(
						"Choisissez un paramêtre à modifier :\n0-Strategie\n1-dexterite\n2-force\n3-resistance\n4-initiative\n5-constitution\n6-etudiant suivant\n7-etudiant précédent\nvous avez "
								+ this.getNbPoints() + " crédits");

				int points_a_ajouter;
				switch (entree.nextInt()) {
				case 0:
					while (this.etudiantsDispo.get(i).getStrategie() == null) {
						System.out.println("Choisissez une stratégie : \n1-Soigner\n2-Attaquer\n3-Aleatoire");
						switch (entree.nextInt()) {
						case 1:
							this.etudiantsDispo.get(i).setStrategie(soigner);
							break;
						case 2:
							this.etudiantsDispo.get(i).setStrategie(attaquer);
							break;
						case 3:
							this.etudiantsDispo.get(i).setStrategie(aleatoire);
							break;
						default:
							System.out.println("veuillez entrer une des valeurs propose");
							break;
						}
					}
					break;
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
					this.etudiantsDispo.get(i).setStrategie(aleatoire);
					break;
				case 7:// précédent
					next = false;
					if (i - 2 > 0) {
						i -= 2;
					} else {
						i -= 1;
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

	public Map<Integer, Etudiant> getEtudiantsDispo() {
		return etudiantsDispo;
	}

	public void setEtudiantsDispo(Map<Integer, Etudiant> etudiantsDispo) {
		this.etudiantsDispo = etudiantsDispo;
	}

	public Faction getFactionJoueur() {
		return factionJoueur;
	}

	public void setFactionJoueur(Faction factionJoueur) {
		this.factionJoueur = factionJoueur;
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
		
	}

}
