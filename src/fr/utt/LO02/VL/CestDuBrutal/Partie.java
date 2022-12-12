package fr.utt.LO02.VL.CestDuBrutal;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//import java.util.Scanner;

public final class Partie {
	Joueur joueur1;
	Joueur joueur2;
	// Joueur quiJoue;
	private boolean gagnee;
	private int etatPartie;
	private String vainqueur;
	private Map<Integer, Zone> zones = new LinkedHashMap<>();
	/*
	 * private enum phaseDeJeu{ Treve, Melee, };
	 */
	private static Partie instance = null;

	/**
	 * constructeur de la classe Partie
	 */
	private Partie() {
		// A compléter
	}

	// Méthode associée à la phase 4
	public void treve(Joueur joueur_actuel) {

		// On déclare l'ensemble des objets au début de la méthode
		boolean flag = false; // Condition d'arrêt de la méthode trêve
		// zoneSelec, etuSelec et zoneObjectif sont des entiers qui prendront les
		// valeurs choisies par le joueur dans la console
		int zoneSelec = 0; // Il faut initialiser zoneSelec pour ne pas avoir d'erreur dans le programme
		int etuSelec;
		// int zoneObjectif;

		Scanner entree = new Scanner(System.in);
		while (flag == false) {
			System.out.println("L'heure est au mouvement de troupes !");
			System.out.println("Quelle action voulez-vous faire ?");
			System.out.println("1-Affecter des reservistes");
			System.out.println("2-redeployer combatants valides");
			System.out.println("3-Connaitre le nombre de Credits ECTS sur les zones de vos choix");
			System.out.println("4-Passer la phase de treve");
			switch (entree.nextInt()) {
			// On affiche les réservistes disponibles
			case 1:
				joueur_actuel.affecterReservistes(joueur_actuel, zones);
				break;
			case 2:
				// il faut bien sûr que le joueur contrôle des zones afin de pouvoir réaliser
				// cette étape
				if (joueur_actuel.getNbZonesControlees() != 0) {
					for (int k = 1; k < zones.size(); k++) {
						if (zones.get(k).getEstControleePar() == joueur_actuel) {
							System.out.println("Zone N°" + k + " : " + zones.get(k).getNomZone());
						}
					}

					zoneSelec = entree.nextInt();
					System.out.println("Quels etudiants voulez-vous reaffecter ?");
					for (int y = 1; y < zones.get(zoneSelec).getEtu(joueur_actuel).size(); y++) {
						// On affiche le numéro de l'étudiant ainsi que ses caractéristiques
						System.out.println("Etudiant N°" + joueur_actuel.getEtudiantsDispo().get(y) + "\n"
								+ joueur_actuel.getEtudiantsDispo().get(y).toString());

						etuSelec = entree.nextInt();
						joueur_actuel.getEtudiantsDispo().get(etuSelec).affecterEtudiantZone(joueur_actuel, zones,
								etuSelec, zoneSelec);
					}

				} else {
					System.out.println("Vous ne pouvez pas redeployer d'etudiants si vous ne controlez aucune zone !");
				}
				break;
			case 3:
				System.out.println(
						"De quelle zone voulez vous connaître les credits ECTS totaux ? \n1-La Bibliothèquen\n2-Le Bureau Des Etudiants\n3-Le Quartier Administratif\n4-Les Halles Industrielles\n5-La Halle Sportive");
				zoneSelec = entree.nextInt();
				if (zoneSelec < 1 || zoneSelec > 5) {
					System.out.println("Zone inexistante... try again !");
				} else {
					System.out.println(zones.get(zoneSelec).getECTS());
				}
				break;
			// Si on ne fait rien on sort de la méthode
			case 4:
				flag = true;
				break;
			default:
				System.out.println("Veuillez choisir une action valide.");
			}
		}
	}

	public static Partie getInstance() {
		if (instance == null) {
			instance = new Partie();
		}
		return instance;
	}

	/**
	 * @return the gagnee
	 */
	public boolean isGagnee() {
		return gagnee;
	}

	/**
	 * @param gagnee the gagnee to set
	 */
	public void setGagnee(boolean gagnee) {
		this.gagnee = gagnee;
	}

	/**
	 * @return the etat_partie
	 */
	public int getEtatPartie() {
		return etatPartie;
	}

	/**
	 * @param etat_partie the etat_partie to set
	 */
	public void setEtatPartie(int etatPartie) {
		this.etatPartie = etatPartie;
	}

	/**
	 * @return the vainqueur
	 */
	public String getVainqueur() {
		return vainqueur;
	}

	/**
	 * @param vainqueur the vainqueur to set
	 */
	public void setVainqueur(String vainqueur) {
		this.vainqueur = vainqueur;
	}

	/**
	 * @return the quiJoue
	 */

	public void melee() {
		boolean flag = true;
		int zone = 0;
		while (flag == true) {
			// System.out.println((zone+1));
			flag = this.zones.get(zone+1).combatZone(joueur1, joueur2);
			zone = (zone + 1) % 5;
		}
	}

	public static void main(String[] args) {

		Partie partie = Partie.getInstance();
		System.out.println(" ===== Début de la partie ! =====\n\nPhase 1 : Parametrage des troupes.\n");
		System.out.println("Tour du joueur 1 :");
		Joueur joueur1 = new Joueur("toto", Faction.A2I);
		System.out.println("Tour du joueur 2 :");
		Joueur joueur2 = new Joueur("tutu", Faction.GM);
		System.out.println("Phase 2 : Affectation des troupes sur le champ de bataille.\n");
		Joueur quiJoue = joueur1;
		// @formatter:off
		partie.zones.put(1, new Zone("la Bibliothèque", joueur1, joueur2));
		partie.zones.put(2,	new Zone("le Bureau Des Etudiants", joueur1, joueur2));
		partie.zones.put(3,	new Zone("le Quartier Administratif", joueur1, joueur2));
		partie.zones.put(4,	new Zone("les Halles industrielles", joueur1, joueur2));
		partie.zones.put(5, new Zone("la Halle sportive", joueur1, joueur2));
		// @formatter:on

		/*
		 * for (int i = 1;i<20;i++) { if(i<=5) {
		 * joueur1.getEtudiantsDispo().get(i).setReserviste(true);
		 * joueur2.getEtudiantsDispo().get(i).setReserviste(true); }else if (i<=10) {
		 * partie.zones.get(1).affecterEtudiant(joueur1.getEtudiantsDispo().get(i)); } }
		 */
		// joueur1.AffectationTroupes(partie.zones);
		for (int i = 6; i <= 10; i++) {
			partie.zones.get(1).affecterEtudiant(joueur1.getEtudiantsDispo().get(i));
			partie.zones.get(1).affecterEtudiant(joueur2.getEtudiantsDispo().get(i));
		}
		partie.zones.get(2).affecterEtudiant(joueur1.getEtudiantsDispo().get(11));
		partie.zones.get(2).affecterEtudiant(joueur2.getEtudiantsDispo().get(11));
		partie.zones.get(3).affecterEtudiant(joueur1.getEtudiantsDispo().get(12));
		partie.zones.get(3).affecterEtudiant(joueur2.getEtudiantsDispo().get(12));
		partie.zones.get(4).affecterEtudiant(joueur1.getEtudiantsDispo().get(13));
		partie.zones.get(4).affecterEtudiant(joueur2.getEtudiantsDispo().get(13));
		partie.zones.get(5).affecterEtudiant(joueur1.getEtudiantsDispo().get(14));
		partie.zones.get(5).affecterEtudiant(joueur2.getEtudiantsDispo().get(14));

		//partie.zones.get(1).triInitiative();
		//partie.zones.get(1).triECTS();
		//System.out.println(partie.zones.get(1).getECTS());
		// System.out.println(partie.zones.get(1).getEtuJoueur1().size());
		// partie.zones.get(1).combatZone();
		// partie.zones.get(1).combatZone();
		partie.melee();
		System.out.println("\nTrêve étudiant 1 :");
		partie.treve(joueur1);
		System.out.println("\nTrêve étudiant 2 :");
		partie.treve(joueur2);
		// partie.zones.get(1).testSort();
		// TODO Auto-generated method stub
	}

}
