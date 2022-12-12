package fr.utt.LO02.VL.CestDuBrutal;

import java.util.ArrayList;
//import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

public class Etudiant {

	private Faction factionEtu;
	private boolean enCombat;
	private boolean reserviste;
	private int creditsECTS = 30;
	private double dexterite = 0;
	private double force = 0;
	private double resistance = 0;
	private int constitution = 0;
	private int initiative = 0;
	private Strategie strategie;
	private int numEtudiant;
	private boolean estMort;
	
	public boolean isEstMort() {
		return estMort;
	}

	public void setEstMort(boolean estMort) {
		this.estMort = estMort;
	}

	private Zone localisation; // a retirer/modifier quand on aura modifié le lien Etudiant/ZOne dans le
								// diagramme de classes

	/**
	 * Le constructeur de la classe Etudiant
	 * 
	 * @param enCombat
	 * @param dexterite
	 * @param force
	 * @param resistance
	 * @param initiative
	 * @param constitution
	 */
	public Etudiant(Faction factionEtu, boolean reserviste, double dexterite, double force, double resistance,
			int initiative, int constitution, int numEtudiant) {
		this.reserviste = reserviste;
		this.dexterite = dexterite;
		this.force = force;
		this.resistance = resistance;
		this.constitution = constitution;
		this.initiative = initiative;
		this.factionEtu = factionEtu;
		this.numEtudiant = numEtudiant;
	}

	/**
	 * @return the enCombat
	 */
	public boolean isEnCombat() {
		return enCombat;
	}

	public Faction getFactionEtu() {
		return factionEtu;
	}

	public void setFactionEtu(Faction factionEtu) {
		this.factionEtu = factionEtu;
	}

	/**
	 * @param enCombat the enCombat to set
	 */
	public void setEnCombat(boolean enCombat) {
		this.enCombat = enCombat;
	}

	/**
	 * @return the reserviste
	 */
	public boolean isReserviste() {
		return reserviste;
	}

	/**
	 * @param reserviste the reserviste to set
	 */
	public void setReserviste(boolean reserviste) {
		this.reserviste = reserviste;
	}

	/**
	 * @return the creditsECTS
	 */
	public int getCreditsECTS() {
		return creditsECTS;
	}

	/**
	 * @param creditsECTS the creditsECTS to set
	 */
	public void setCreditsECTS(int creditsECTS) {
		this.creditsECTS = creditsECTS;
	}

	/**
	 * @return the dexterite
	 */
	public double getDexterite() {
		return dexterite;
	}

	/**
	 * @param dexterite the dexterite to set
	 */
	public boolean setDexterite(double dexterite) {// max 10
		if ((this.dexterite + dexterite) >= 0 && (this.dexterite + dexterite) <= 10) {
			this.dexterite += dexterite;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return the force
	 */
	public double getForce() {
		return force;
	}

	/**
	 * @param force the force to set
	 */
	public boolean setForce(double force) {// max 10
		if ((this.force + force) >= 0 && (this.force + force) <= 10) {
			this.force += force;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return the resistance
	 */
	public double getResistance() {
		return resistance;
	}

	/**
	 * @param resistance the resistance to set
	 */
	public boolean setResistance(double resistance) {// max 10
		if ((this.resistance + resistance) >= 0 && (this.resistance + resistance) <= 10) {
			this.resistance += resistance;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return the constitution
	 */
	public int getConstitution() {
		return constitution;
	}

	/**
	 * @param constitution the constitution to set
	 */
	public boolean setConstitution(int constitution) {// max 30
		if ((this.constitution + constitution) >= 0 && (this.constitution + constitution) <= 30) {
			this.constitution += constitution;
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @return the initiative
	 */
	public int getInitiative() {
		return initiative;
	}

	/**
	 * @param initiative the initiative to set
	 */
	public boolean setInitiative(int initiative) {// max 10
		if ((this.initiative + initiative) >= 0 && (this.initiative + initiative) <= 10) {
			this.initiative += initiative;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return the strategie
	 */
	public Strategie getStrategie() {
		return strategie;
	}

	/**
	 * @param strategie the strategie to set
	 */
	public void setStrategie(Strategie strategie) {
		this.strategie = strategie;
	}

	/**
	 * @return the localisation
	 */
	public Zone getLocalisation() {
		return localisation;
	}

	/**
	 * @param localisation the localisation to set
	 */
	public void setLocalisation(Zone localisation) {
		this.localisation = localisation;
	}

	/**
	 * La méthode newStratégie est appellée en phase de trève lorsqu'on souhaite
	 * modifier la stratégie des étudiants qu'on redéploie. Si on choisit de ne pas
	 * choisir de nouvelle stratégie après avoir appelé la méthode, on garde la
	 * stratégie précédente.
	 * 
	 * @param joueur
	 * @param etuSelec
	 */
	public void newStrategie(Joueur joueur, int etuSelec) {
		// On déclare nos objets en début de méthode
		Attaquer offensive = new Attaquer();
		Soigner defensive = new Soigner();
		Aleatoire aleatoire = new Aleatoire();
		Scanner entree = new Scanner(System.in);

		// on séléctionne le choix du joueur à l'aide de la méthode nextInt
		System.out.println(
				"Quelle strategie choisissez vous ? Le choix est vaste... \t\n1-Offensive\t\n2-Defensive\t\n3-Aleatoire\t\n4-Aucune");
		switch (entree.nextInt()) {
		// le joueur choisit la stratégie offensive
		case 1:
			joueur.getEtudiantsDispo().get(etuSelec).setStrategie(offensive);
			System.out.println("Strategie definie comme offensive");
			break;
		// le joueur choisit la stratégie défensive
		case 2:
			joueur.getEtudiantsDispo().get(etuSelec).setStrategie(defensive);
			System.out.println("Strategie definie comme defensive");
			break;
		// le joueur choisit une stratégie aléatoire
		case 3:
			joueur.getEtudiantsDispo().get(etuSelec).setStrategie(aleatoire);
			System.out.println("Strategie definie comme aleatoire");
			break;
		// on ne fait rien
		case 4:
			System.out.println("Vous ne modifiez pas la strategie de l'etudiant");
			break;
		// message renvoyé si la commande ne entrée ne correspond à aucun des cas
		// ci-dessus
		default:
			System.out.println("Non cette strategie n'existe malheureusement pas");

		}
	}

	/**
	 * Méthode reaffecterEtudiant qui permet de réaffecter un étudiant d'une zone
	 * contrôlée vers une autre zone qui n'est pas contôlée. Dans cette méthode on
	 * redéfinit aussi la stratégie de l'étudiant réaffecté
	 * 
	 * @param joueur
	 * @param zones
	 * @param etuSelec
	 * @param zoneObjectif
	 * @param zoneSelec
	 */
	public void reaffecterEtudiant(Joueur joueur, Map<Integer, Zone> zones, int etuSelec, int zoneObjectif,
			int zoneSelec) {
		Scanner entree = new Scanner(System.in);
		// On vérifie que la zone choisie est différente de celle où l'étudiant est
		// actuellement
		if (zoneObjectif != zoneSelec) {
			// On affecte l'étudiant à la nouvelle zone tout en le retirant de l'ancienne
			zones.get(zoneObjectif).affecterEtudiant(joueur.getEtudiantsDispo().get(etuSelec));
			zones.get(zoneSelec).desaffecterEtudiant(joueur.getEtudiantsDispo().get(etuSelec));
			System.out.println("L'etudiant N°" + joueur.getEtudiantsDispo().get(etuSelec) + " quitte la zone "
					+ zones.get(zoneSelec) + " pour aller vers " + zones.get(zoneObjectif) + ".");
			// Une fois que c'est fait, on propose de modifier la stratégie de l'étudiant
			System.out.println("\nVoulez vous modifier sa strategie ? \n1-Oui\n2-Non");
			switch (entree.nextInt()) {
			case 1:
				// on applique une nouvelle stratégie à l'étudiant à l'aide d'une méthode
				// utilisant un switch-case
				joueur.getEtudiantsDispo().get(etuSelec).newStrategie(joueur, etuSelec);
				break;
			case 2:
				System.out.println("D'accord.");
				break;
			// Message renvoyé si la commande entrée dans la console ne correspond pas aux
			// options possibles
			default:
				System.out.println("Commande pas valide... try again !");
			}
		} else {
			System.out.println("Vous etes entrain de d'essayer de reaffecter l'etudiant sur la zone ou il est...");
		}
	}

	/**
	 * methode utilisée pour généraliser la reaffecation des etudiants das les
	 * différentes zones pendant la phase de trêve.
	 * 
	 * @param joueur
	 * @param zones
	 * @param etuSelec
	 * @param zoneSelec
	 */
	public void affecterEtudiantZone(Joueur joueur, Map<Integer, Zone> zones, int etuSelec, int zoneSelec) {
		int zoneObjectif;
		Scanner entree = new Scanner(System.in);
		if (joueur.getEtudiantsDispo().get(etuSelec).getLocalisation() == zones.get(zoneSelec)) {
			System.out.println(
					"Choisissez ou vous voulez reaffectez l'etudiant : \n1-La Bibliothèquen\n2-Le Bureau Des Etudiants\n3-Le Quartier Administratif\n4-Les Halles Industrielles\n5-La Halle Sportive");

			zoneObjectif = entree.nextInt();
			// on réaffecte les étudiant sur les zones choisies tout en proposant de
			// modifier la stratégie
			switch (entree.nextInt()) {
			case 1:
				joueur.getEtudiantsDispo().get(etuSelec).reaffecterEtudiant(joueur, zones, etuSelec, zoneObjectif,
						zoneSelec);
				break;
			case 2:
				joueur.getEtudiantsDispo().get(etuSelec).reaffecterEtudiant(joueur, zones, etuSelec, zoneObjectif,
						zoneSelec);
				break;
			case 3:
				joueur.getEtudiantsDispo().get(etuSelec).reaffecterEtudiant(joueur, zones, etuSelec, zoneObjectif,
						zoneSelec);
				break;
			case 4:
				joueur.getEtudiantsDispo().get(etuSelec).reaffecterEtudiant(joueur, zones, etuSelec, zoneObjectif,
						zoneSelec);
				break;
			case 5:
				joueur.getEtudiantsDispo().get(etuSelec).reaffecterEtudiant(joueur, zones, etuSelec, zoneObjectif,
						zoneSelec);
				break;
			default:
				System.out.println("zone non-existante");
			}
		} else {
			System.out.println("Veuillez selectionner un etudiant qui est dans cette zone !");
		}

	}

	@Override
	/**
	 * 
	 */
	public String toString() {
		return "\nCredits ECTS : " + this.creditsECTS + "\nDexterite : " + this.dexterite + "\nForce : " + this.force
				+ "\nResistence : " + this.resistance + "\nInitiative : " + this.initiative + "\nConstitution : "
				+ this.constitution + "\nStrategie : " + this.strategie.nomStrat();
	}

	public void action(ArrayList<Etudiant> etuJoueur1, ArrayList<Etudiant> etuJoueur2) {
		if (this.getStrategie() == new Attaquer()) {
			if (this.getFactionEtu() == etuJoueur1.get(0).getFactionEtu()) {
				strategie.typeStrategie(etuJoueur2, this);

				// etuJoueur2.sort(Comparator.comparing(Etudiant::getCreditsECTS));
			} else {
				strategie.typeStrategie(etuJoueur1, this);

				// etuJoueur1.sort(Comparator.comparing(Etudiant::getCreditsECTS));
			}
		} else if (this.getStrategie() == new Soigner()) {
			if (this.getFactionEtu() == etuJoueur1.get(0).getFactionEtu()) {
				strategie.typeStrategie(etuJoueur1, this);
			} else {
				strategie.typeStrategie(etuJoueur2, this);
			}

		} else if (this.getStrategie() == new Aleatoire()) {
			if (Math.random() > 0.5) {
				strategie.typeStrategie(etuJoueur2, this);
			}
			// etuJoueur2.sort(Comparator.comparing(Etudiant::getCreditsECTS));
		} else {
			strategie.typeStrategie(etuJoueur1, this);
		}
	}

	public int getNumEtudiant() {
		return numEtudiant;
	}

	public void setNumEtudiant(int numEtudiant) {
		this.numEtudiant = numEtudiant;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Etudiant toto = new Etudiant(false, 0, 0, 0, 0, 0);
	}

}
