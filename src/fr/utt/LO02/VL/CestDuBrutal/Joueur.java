package fr.utt.LO02.VL.CestDuBrutal;

import java.util.Scanner;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class Joueur {

	private int nbZonesControlees;
	private int nbPoints = 400;
	private String nomJoueur;
	private Map<Integer, Etudiant> etudiantsDispo = new HashMap<>();
	private Faction factionJoueur = null;
	private int nbReservistes = 0; // le joueur a initialement affecté aucun réserviste

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

		// Joueur this = new Joueur("this");
		boolean next = true;

		for (int i = 1; i <= 20; i++) {
			next = true;

			if (i <= 15) {
				System.out.println("\nEtudiant n° " + i);
				this.etudiantsDispo.put(i, new Etudiant(this.factionJoueur, false, 0, 0, 0, 0, 0));
			} else if (i > 15 && i <= 19) {
				System.out.println("\nEtudiant d'élite n° " + (i - 15));
				this.etudiantsDispo.put(i, new Etudiant(this.factionJoueur, false, 1, 1, 1, 5, 1));
			} else if (i > 19) {
				System.out.println("\nMaitre du gobi");
				this.etudiantsDispo.put(i, new Etudiant(this.factionJoueur, false, 2, 2, 2, 10, 2));
			}

			while (this.getNbPoints() > 0 && next == true) {
				System.out.println("\nEntrez le chiffre associer à votre choix, vous avez " + this.getNbPoints()
						+ " crédits et " + this.nbReservistes + " réservistes");
				System.out.println("\nChoix :\t\tStats :");
				System.out.println("0-Strategie\t" + (this.etudiantsDispo.get(i).getStrategie() == null ? "aléatoire"
						: this.etudiantsDispo.get(i).getStrategie().nomStrat()));
				System.out.println("1-Dexterite\t" + this.etudiantsDispo.get(i).getDexterite());
				System.out.println("2-Force\t\t" + this.etudiantsDispo.get(i).getForce());
				System.out.println("3-Resistance\t" + this.etudiantsDispo.get(i).getResistance());
				System.out.println("4-Initiative\t" + this.etudiantsDispo.get(i).getInitiative());
				System.out.println("5-Constitution\t" + this.etudiantsDispo.get(i).getConstitution());
				System.out.println(
						"6-Réserviste\t" + (this.etudiantsDispo.get(i).isReserviste() == true ? "oui" : "non"));
				System.out.println("\n7-Etudiant suivant");
				System.out.println("8-Etudiant précédent");
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
					if (this.setNbPoints(-points_a_ajouter)) {
						if (this.etudiantsDispo.get(i).setDexterite(points_a_ajouter)) {
							System.out.println("L'etudiant numéro " + i + " a maintenant "
									+ this.etudiantsDispo.get(i).getDexterite() + " de dexterite");
						} else {
							this.setNbPoints(points_a_ajouter);// Reimbursement
							System.out.println("L'étudiant doit avoir entre 0 et 10 de dexterité");
						}

					} else {
						System.out.println("Pas assez de crédits !");
					}
					break;
				case 2:
					System.out.println("votre etudiant possède " + this.etudiantsDispo.get(i).getForce()
							+ " de force, entrez la valeur à lui ajouter :");
					points_a_ajouter = entree.nextInt();
					if (this.setNbPoints(-points_a_ajouter)) {
						if (this.etudiantsDispo.get(i).setForce(points_a_ajouter)) {
							System.out.println("L'etudiant numéro " + i + " a maintenant "
									+ this.etudiantsDispo.get(i).getForce() + " de force");
						} else {
							this.setNbPoints(points_a_ajouter);
							System.out.println("L'étudiant doit avoir entre 0 et 10 de force");
						}

					} else {
						System.out.println("Pas assez de crédits !");
					}
					break;
				case 3:
					System.out.println("votre etudiant possède " + this.etudiantsDispo.get(i).getResistance()
							+ " de résistance, entrez la valeur à lui ajouter :");
					points_a_ajouter = entree.nextInt();
					if (this.setNbPoints(-points_a_ajouter)) {
						if (this.etudiantsDispo.get(i).setResistance(points_a_ajouter)) {
							System.out.println("L'etudiant numéro " + i + " a maintenant "
									+ this.etudiantsDispo.get(i).getResistance() + " de resistance");
						} else {
							this.setNbPoints(points_a_ajouter);
							System.out.println("L'étudiant doit avoir entre 0 et 10 de resistance");
						}

					} else {
						System.out.println("Pas assez de crédits !");
					}
					break;
				case 4:
					System.out.println("votre etudiant possède " + this.etudiantsDispo.get(i).getInitiative()
							+ " d'initiative, entrez la valeur à lui ajouter :");
					points_a_ajouter = entree.nextInt();
					if (this.setNbPoints(-points_a_ajouter)) {
						if (this.etudiantsDispo.get(i).setInitiative(points_a_ajouter)) {
							System.out.println("L'etudiant numéro " + i + " a maintenant "
									+ this.etudiantsDispo.get(i).getInitiative() + " d'initiative");
						} else {
							this.setNbPoints(points_a_ajouter);
							System.out.println("L'étudiant doit avoir entre 0 et 10 d'initiative");
						}

					} else {
						System.out.println("Pas assez de crédits !");
					}
					break;
				case 5:
					System.out.println("votre etudiant possède " + this.etudiantsDispo.get(i).getConstitution()
							+ " de constitution, entrez la valeur à lui ajouter :");
					points_a_ajouter = entree.nextInt();
					if (this.setNbPoints(-points_a_ajouter)) {
						if (this.etudiantsDispo.get(i).setConstitution(points_a_ajouter)) {
							System.out.println("L'etudiant numéro " + i + " a maintenant "
									+ this.etudiantsDispo.get(i).getConstitution() + " de constitution");
						} else {
							this.setNbPoints(points_a_ajouter);
							System.out.println("L'étudiant doit avoir entre 0 et 30 de constitution");
						}

					} else {
						System.out.println("Pas assez de crédits !");
					}
					break;
				case 6:// choix si étudiant réserviste ou non
					System.out.println("Voulez-vous choisir cet étudiant pour être réserviste ?\n\n0-Non\n1-Oui");
					switch (entree.nextInt()) {
					case 0:
						if (this.etudiantsDispo.get(i).isReserviste() == true) {
							this.nbReservistes--;
						}
						this.etudiantsDispo.get(i).setReserviste(false);
						break;
					case 1:
						if (this.nbReservistes < 5) {
							if (this.etudiantsDispo.get(i).isReserviste() == false) {
								this.nbReservistes++;
							}
							this.etudiantsDispo.get(i).setReserviste(true);
						} else {
							System.out.println("Vous ne pouvez pas assigner plus de réservistes.");
						}
						break;
					}
					break;
				case 7:// suivant
					if (this.nbReservistes < 5 && i == 20) {
						System.out.println("veuillez affecter 5 reservistes.\nVous n'avez que " + this.nbReservistes
								+ " affectés sur les 5 prévus.");
						i--;
					} else {

						if (this.etudiantsDispo.get(i).getStrategie() == null) {
							this.etudiantsDispo.get(i).setStrategie(aleatoire);
						}
					}
					next = false;
					break;
				case 8:// précédent
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
		// entree.close();
		// ajouter la définition de la faction du joueur
	}

	
	
	
	
	
	
	
	//TODO
	/*public int getKeyEtudiant(Etudiant value) {
		for (Entry<Integer, Etudiant> entry : this.etudiantsDispo.entrySet()) {
			if (entry.getValue() == value) {
				return (int) entry.getKey();
			}
		}
	}
*/
	public void AffectationTroupes(Map<Integer, Zone> zones) {
		boolean flag = false;
		Scanner entree = new Scanner(System.in);
		while (flag == false) {
			int etudiantSelec;
			System.out.println("choisissez une zone :");
			System.out.println("1-La Bibliothèque\t\t"
					+ (zones.get(1).getFactionJ1() == this.getFactionJoueur() ? zones.get(1).getEtuJoueur1().size()
							: zones.get(1).getEtuJoueur2().size()));
			System.out.println("2-Le Bureau Des Etudiants\t"
					+ (zones.get(2).getFactionJ1() == this.getFactionJoueur() ? zones.get(2).getEtuJoueur1().size()
							: zones.get(2).getEtuJoueur2().size()));
			System.out.println("3-Le Quartier Administratif\t"
					+ (zones.get(3).getFactionJ1() == this.getFactionJoueur() ? zones.get(3).getEtuJoueur1().size()
							: zones.get(3).getEtuJoueur2().size()));
			System.out.println("4-Les Halles Industrielles\t"
					+ (zones.get(4).getFactionJ1() == this.getFactionJoueur() ? zones.get(4).getEtuJoueur1().size()
							: zones.get(4).getEtuJoueur2().size()));
			System.out.println("5-La Halle Sportive\t\t"
					+ (zones.get(5).getFactionJ1() == this.getFactionJoueur() ? zones.get(5).getEtuJoueur1().size()
							: zones.get(5).getEtuJoueur2().size()));
			System.out.println("\n6-Fin");
			int lieuSelec = entree.nextInt();
			if (lieuSelec >= 1 && lieuSelec <= 5) {
				System.out.println(
						"Vous avez actuellement " + (zones.get(lieuSelec).getFactionJ1() == this.getFactionJoueur()
								? zones.get(lieuSelec).getFactionJ1()
								: zones.get(lieuSelec).getFactionJ2()) + " étudiants dans cette zone");

				System.out.print("Voici les étudiants déjà affectés:");
				for (int i = 0; i < 5; i++) {

				}
				System.out.println("Choisissez ce que vous souhaitez faire :");
				System.out.println("0-Désaffecter étudiant");
				System.out.println("1-Affecter étudiant");
				System.out.println("2-Retour");
				int actionSelec = entree.nextInt();
				switch (actionSelec) {
				case 0:
					System.out.println("Entrez le numéro de l'étudiant à désaffecteraffecter à "
							+ zones.get(lieuSelec).getNomZone());
					etudiantSelec = entree.nextInt();

					if (this.etudiantsDispo.get(etudiantSelec).getLocalisation() == zones.get(lieuSelec)) {
						zones.get(lieuSelec).desaffecterEtudiant(this.etudiantsDispo.get(etudiantSelec));
					} else {
						System.out.println("L'étudiant n'est pas dans cette zone");
					}
					break;
				case 1:
					System.out.println(
							"Entrez le numéro de l'étudiant à affecter à " + zones.get(lieuSelec).getNomZone());
					etudiantSelec = entree.nextInt();
					if (this.etudiantsDispo.get(etudiantSelec).isReserviste() == false) {
						if (this.etudiantsDispo.get(etudiantSelec).getLocalisation() != zones.get(lieuSelec)
								&& this.etudiantsDispo.get(etudiantSelec).getLocalisation() != null) {
							System.out.println("L'étudiant est déjà assigné à une zone");
						} else {
							zones.get(lieuSelec).affecterEtudiant(this.etudiantsDispo.get(etudiantSelec));
						}
					} else {
						System.out.println("L'étudiant est réserviste, il ne peut pas être assigné à une zone");
					}
					break;
				default:
					break;
				}
			} else {
				if (zones.get(1).getFactionJ1() == this.getFactionJoueur()) {
					// @formatter:off
					if (zones.get(1).getEtuJoueur1().size() >= 1 && 
						zones.get(2).getEtuJoueur1().size() >= 1 && 
						zones.get(3).getEtuJoueur1().size() >= 1 && 
						zones.get(4).getEtuJoueur1().size() >= 1 &&
						zones.get(5).getEtuJoueur1().size() >= 1) {
					// @formatter:on
						flag = true;
					} else {
						System.out.println("Vous devez assigner au moins 1 étudiant dans chaque zone");
					}
				} else {
					// @formatter:off
					if (zones.get(1).getEtuJoueur2().size() >= 1 && 
						zones.get(2).getEtuJoueur2().size() >= 1 && 
						zones.get(3).getEtuJoueur2().size() >= 1 && 
						zones.get(4).getEtuJoueur2().size() >= 1 &&
						zones.get(5).getEtuJoueur2().size() >= 1) {
					// @formatter:on
						flag = true;
					} else {
						System.out.println("Vous devez assigner au moins 1 étudiant dans chaque zone");
					}
				}
			}
		}

	}
    

	/**
	 * Méthode utilisée lors de la phase de trêve pour affecter les réservistes dans les zones non contrôlées.
	 * 
	 * @param joueur
	 * @param zones
	 * @param zoneSelec
	 */
	public void affecterReservistes(Joueur joueur, Map<Integer,Zone> zones, int zoneSelec) {
		int reservisteSelec;
		Scanner entree = new Scanner(System.in);
		
		System.out.println("Reservistes disponibles :");
		for(int i=1; i< joueur.getEtudiantsDispo().size(); i++) {
			if (joueur.getEtudiantsDispo().get(i).isReserviste() == true) {
				//caractéristiques de l'étudiant affichées à l'aide de la méthode toString
				System.out.println("Etudiant N°" + joueur.getEtudiantsDispo().get(i)
						+ "\n" + joueur.getEtudiantsDispo().get(i).toString());
			}
			reservisteSelec = entree.nextInt();
			//On affecte le réserviste sélectionné dans une zone qui n'est pas déjà contrôlée
			if(joueur.getEtudiantsDispo().get(reservisteSelec).isReserviste() == true) {
				System.out.println("Zones non controlees : ");
				for (int j = 1; j < zones.size() ; j++ ) {
					if(zones.get(j).getEstControleePar() == null) {
						System.out.println(j + "-" + zones.get(j).getNomZone()); //afficher le nombre de crédits ECTS pour chaque faction dans la zone quand la méthode sera créée
					}
					//une fois qu'on a affiché les zones non contrôlées on selectionne dans quelle zone on y met notre étudiant réserviste
					zoneSelec = entree.nextInt();
					if(zones.get(zoneSelec).getEstControleePar() == null) {
						zones.get(zoneSelec).affecterEtudiant(joueur.getEtudiantsDispo().get(reservisteSelec));
						joueur.getEtudiantsDispo().get(reservisteSelec).setReserviste(false);
						System.out.println(
								"L'etudiant N°" + reservisteSelec + " est maintenant affecte dans la zone " + zones.get(zoneSelec).getNomZone() + ".");
					}else {
						System.out.println("Zone deja controlee !");
					}
				}
			}else {
				System.out.println("Cet etudiant n'est pas reserviste !");
			}
		}
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
	public boolean setNbPoints(int nbPoints) {
		if ((this.nbPoints + nbPoints) >= 0) {
			this.nbPoints += nbPoints;
			return true;
		} else {
			return false;
		}
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

	public void affecterPoints(Etudiant PointsEtu, int nbPoints) {

	}

	public void definirStrategie(Etudiant strategieEtu, Strategie typeStrategie) {

	}

	public void choixReserviste(Etudiant EtuReserviste, boolean EstReserviste) {
		EtuReserviste.setReserviste(EstReserviste);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Joueur toto = new Joueur();

	}

}