package fr.utt.LO02.VL.CestDuBrutal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//import java.util.Scanner;

public final class Partie {
	Joueur joueur1;
	Joueur joueur2;
	// Joueur quiJoue;
	private boolean gagnee = false;
	private String vainqueur;
	private int zone = 0;
	private Map<Integer, Zone> zones = new LinkedHashMap<>();
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
			System.out.println("\n\033[1;33m======Trêve de " + joueur_actuel.getNomJoueur() + "======\033[0m");
			System.out.println("L'heure est au mouvement de troupes !");
			System.out.println("Quelle action voulez-vous faire ?");
			System.out.println("1-Affecter des reservistes");
			System.out.println("2-redeployer combatants valides");
			System.out.println("3-Connaitre le nombre de Credits ECTS sur les zones de vos choix");
			System.out.println("4-Passer la phase de treve");
			switch (entree.nextInt()) {
			// On affiche les réservistes
			case 1:
				joueur_actuel.affecterReservistes(joueur_actuel, zones);
				break;
			case 2:
				// il faut bien sûr que le joueur contrôle des zones afin de pouvoir réaliser
				// cette étape
				boolean zones_dispo = false;
				for (int k = 1; k <= 5; k++) {
					if (zones.get(k).getEstControleePar() == joueur_actuel && zones.get(k).getEtu(joueur_actuel).size() > 1) {
						zones_dispo = true;
					}
				}
				if (zones_dispo == true) {
					System.out.println("Zones disponibles");
					if (joueur_actuel.getNbZonesControlees() != 0) {
						for (int k = 1; k <= 5; k++) {
							if (zones.get(k).getEstControleePar() == joueur_actuel && zones.get(k).getEtu(joueur_actuel).size() > 1) {
								System.out.println(k + "-" + zones.get(k).getNomZone());
							}
						}
						zoneSelec = entree.nextInt();

						if (zones.get(zoneSelec).getEstControleePar() == joueur_actuel) {
							System.out.println("Quels etudiants voulez-vous reaffecter ?");
							System.out.println("\t\tCrédits\tDexterité\tForce\tRésistance\tInitiative\tConstitution\tStrat");
							for (int y = 0; y < zones.get(zoneSelec).getEtu(joueur_actuel).size(); y++) {
								System.out.println(
										y + "-Etudiant N°" + zones.get(zoneSelec).getEtu(joueur_actuel).get(y).getNumEtudiant() + zones.get(zoneSelec).getEtu(joueur_actuel).get(y).toString());
							}
							etuSelec = entree.nextInt();

							if (etuSelec <= zones.get(zoneSelec).getEtu(joueur_actuel).size() && etuSelec >= 0) {
								System.out.println("choisissez une zone où réaffecter cet étudiant :");
								for (int k = 1; k <= 5; k++) {
									if (zones.get(k).getEstControleePar() == null) {
										System.out.println(k + "-" + zones.get(k).getNomZone());
									}
								}
								int zoneReafect = entree.nextInt();

								if (zones.get(zoneReafect).getEstControleePar() == null) {
									Etudiant etuMouvement = zones.get(zoneSelec).getEtu(joueur_actuel).get(etuSelec);
									zones.get(zoneSelec).desaffecterEtudiant(etuMouvement);
									zones.get(zoneReafect).affecterEtudiant(etuMouvement);
									System.out.println("Voulez vous changer sa stratégie ? Sa stratégie est actuellement " + etuMouvement.getStrategie().nomStrat());
									System.out.println("0-Oui");
									System.out.println("1-Non");

									if (entree.nextInt() == 0) {
										System.out.println("Choisissez sa nouvelle stratégie :");
										System.out.println("1-Soigner");
										System.out.println("2-Attaquer");
										System.out.println("3-Aléatoire");
										int nouvelleStrat = entree.nextInt();
										switch (nouvelleStrat) {
										case 1:
											etuMouvement.setStrategie(new Soigner());
											break;
										case 2:
											etuMouvement.setStrategie(new Attaquer());
											break;
										case 3:
											etuMouvement.setStrategie(new Aleatoire());
											break;
										default:
											System.out.println("Cette stratégie n'existe pas");
											break;
										}
									}
								} else {
									System.out.println("Veuillez choisir une zone valide");
								}
							} else {
								System.out.println("Cet étudaiant n'est pas dans une zone conquise");
							}
						} else {
							System.out.println("Veuillez choisir une zone que vous controllez");
						}
					} else {
						System.out.println("Vous ne pouvez pas redeployer d'etudiants si vous ne controlez aucune zone !");
					}
				} else {
					System.out.println("Vous n'avez aucun étidiants à redéployer");
				}
				break;
			case 3:
				System.out.println("De quelle zone voulez vous connaître les credits ECTS totaux ?");
				System.out.println("1-La Bibliothèque");
				System.out.println("2-Le Bureau Des Etudiants");
				System.out.println("3-Le Quartier Administratif");
				System.out.println("4-Les Halles Industrielles");
				System.out.println("5-La Halle Sportive");
				zoneSelec = entree.nextInt();
				if (zoneSelec < 1 || zoneSelec > 5) {
					System.out.println("Zone inexistante... try again !");
				} else {
					System.out.println("Il y a un total de " + zones.get(zoneSelec).getECTS() + " ECTS dans cette zone");
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

	/**
	 * @param gagnee the gagnee to set
	 */

	/**
	 * @return the etat_partie
	 */

	/**
	 * @param etat_partie the etat_partie to set
	 */

	/**
	 * @return the vainqueur
	 */

	/**
	 * @param vainqueur the vainqueur to set
	 */

	/**
	 * @return the quiJoue
	 */

	public void melee(Joueur J1, Joueur J2) {
		boolean flag = true;
		for (int i = 1; i <= 5; i++) {
			if (this.zones.get(i).getEstControleePar() == null) {
				this.zones.get(i).triInitiative();
			}
		}
		while (flag == true) {
			// System.out.println((zone+1));
			if (this.zones.get(zone + 1).getEstControleePar() == null) {
				flag = this.zones.get(zone + 1).combatZone(J1, J2);
			}
			zone = (zone + 1) % 5;
		}
	}

	public static void main(String[] args) {

		Partie partie = Partie.getInstance();
		System.out.println("\033[1;31m ===== Début de la partie ! =====\033[0m\n\nPhase 1 : Parametrage des troupes.\n");
		System.out.println("Tour du joueur 1 :");
		//Joueur joueur1 = new Joueur("toto", Faction.A2I);// commenter pour automatiser
		Joueur joueur1 = new Joueur();//décommenter pour automatiser
		System.out.println("Tour du joueur 2 :");
		//Joueur joueur2 = new Joueur("tutu", Faction.GM);// commenter pour automatiser
		Joueur joueur2 = new Joueur();//décommenter pour automatiser
		System.out.println("Phase 2 : Affectation des troupes sur le champ de bataille.\n");

		partie.zones.put(1, new Zone("la Bibliothèque", joueur1, joueur2));
		partie.zones.put(2, new Zone("le Bureau Des Etudiants", joueur1, joueur2));
		partie.zones.put(3, new Zone("le Quartier Administratif", joueur1, joueur2));
		partie.zones.put(4, new Zone("les Halles industrielles", joueur1, joueur2));
		partie.zones.put(5, new Zone("la Halle sportive", joueur1, joueur2));
		/*
		 * //décommenter pour automatiser for (int i = 6; i <= 10; i++) {
		 * partie.zones.get(1).affecterEtudiant(joueur1.getEtudiantsDispo().get(i));
		 * partie.zones.get(1).affecterEtudiant(joueur2.getEtudiantsDispo().get(i)); }
		 * partie.zones.get(2).affecterEtudiant(joueur1.getEtudiantsDispo().get(11));
		 * partie.zones.get(2).affecterEtudiant(joueur2.getEtudiantsDispo().get(11));
		 * partie.zones.get(2).affecterEtudiant(joueur1.getEtudiantsDispo().get(12));
		 * partie.zones.get(2).affecterEtudiant(joueur2.getEtudiantsDispo().get(12));
		 * partie.zones.get(3).affecterEtudiant(joueur1.getEtudiantsDispo().get(13));
		 * partie.zones.get(3).affecterEtudiant(joueur2.getEtudiantsDispo().get(13));
		 * partie.zones.get(3).affecterEtudiant(joueur1.getEtudiantsDispo().get(14));
		 * partie.zones.get(3).affecterEtudiant(joueur2.getEtudiantsDispo().get(14));
		 * partie.zones.get(4).affecterEtudiant(joueur1.getEtudiantsDispo().get(15));
		 * partie.zones.get(4).affecterEtudiant(joueur2.getEtudiantsDispo().get(15));
		 * partie.zones.get(4).affecterEtudiant(joueur1.getEtudiantsDispo().get(16));
		 * partie.zones.get(4).affecterEtudiant(joueur2.getEtudiantsDispo().get(16));
		 * partie.zones.get(5).affecterEtudiant(joueur1.getEtudiantsDispo().get(17));
		 * partie.zones.get(5).affecterEtudiant(joueur2.getEtudiantsDispo().get(17));
		 * partie.zones.get(5).affecterEtudiant(joueur1.getEtudiantsDispo().get(18));
		 * partie.zones.get(5).affecterEtudiant(joueur2.getEtudiantsDispo().get(18));
		 */
		joueur1.AffectationTroupes(partie.zones);// commenter pour automatiser
		joueur2.AffectationTroupes(partie.zones);// commenter pour automatiser
		while (partie.gagnee == false) {
			partie.melee(joueur1, joueur2);
			if (joueur1.getNbZonesControlees() < 3 && joueur2.getNbZonesControlees() < 3) {
				//@formatter:off
				for(int i = 1;i<=5;i++) {System.out.println(partie.zones.get(i).getNomZone()+" est controllée par "+(partie.zones.get(i).getEstControleePar()==null?"\033[1;32mpersonne\033[0m":("\033[1;31m"+partie.zones.get(i).getEstControleePar().getNomJoueur())+"\033[0m"));}//@formatter:on
				partie.treve(joueur1);
				partie.treve(joueur2);
			} else {
				partie.gagnee = true;
				if (joueur1.getNbZonesControlees() >= 3) {
					partie.vainqueur = joueur1.getNomJoueur();
				} else {
					partie.vainqueur = joueur2.getNomJoueur();
				}
			}
		}
		System.out.println("\\033[4;35mPartie gagnée par " + partie.vainqueur + "\\033[0m");
	}

}
