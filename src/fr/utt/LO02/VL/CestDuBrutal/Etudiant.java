package fr.utt.LO02.VL.CestDuBrutal;

import java.util.ArrayList;
//import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

public class Etudiant {

	private Faction factionEtu;
	private boolean reserviste;
	private int creditsECTS = 30;
	private double dexterite = 0;
	private double force = 0;
	private double resistance = 0;
	private int constitution = 0;
	private int initiative = 0;
	private Strategie strategie;
	private int numEtudiant;
	private boolean estMort = false;
	private Zone localisation = null; // a retirer/modifier quand on aura modifié le lien Etudiant/ZOne dans le

	public boolean isEstMort() {
		return estMort;
	}

	public void setEstMort(boolean estMort) {
		this.estMort = estMort;
	}

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
	public Etudiant(Faction factionEtu, boolean reserviste, double dexterite, double force, double resistance, int initiative, int constitution, int numEtudiant) {
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
	public Faction getFactionEtu() {
		return factionEtu;
	}

	public void setFactionEtu(Faction factionEtu) {
		this.factionEtu = factionEtu;
	}

	/**
	 * @param enCombat the enCombat to set
	 */
	
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

	// @Override
	/**
	 * 
	 * */
	public String toString() {
		return "\t" + this.creditsECTS + "\t" + this.dexterite + "\t\t" + this.force + "\t" + this.resistance + "\t\t" + this.initiative + "\t\t" + this.constitution + "\t\t"
				+ this.strategie.nomStrat();
	}

	public void action(ArrayList<Etudiant> etuJoueur1, ArrayList<Etudiant> etuJoueur2) {
		if (this.getStrategie() instanceof Attaquer) {
			// System.out.println("=================Attaquer");
			if (this.getFactionEtu() == etuJoueur1.get(0).getFactionEtu()) {
				strategie.typeStrategie(etuJoueur2, this);

				// etuJoueur2.sort(Comparator.comparing(Etudiant::getCreditsECTS));
			} else {
				strategie.typeStrategie(etuJoueur1, this);

				// etuJoueur1.sort(Comparator.comparing(Etudiant::getCreditsECTS));
			}
		} else if (this.getStrategie() instanceof Soigner) {
			if (this.getFactionEtu() == etuJoueur1.get(0).getFactionEtu()) {
				strategie.typeStrategie(etuJoueur1, this);
			} else {
				strategie.typeStrategie(etuJoueur2, this);
			}

		} else if (this.getStrategie() instanceof Aleatoire) {
			double random = Math.random();
			if (random > 0.5) {
				if (this.getFactionEtu() == etuJoueur1.get(0).getFactionEtu()) {
					new Soigner().typeStrategie(etuJoueur1, this);
				} else {
					new Soigner().typeStrategie(etuJoueur2, this);
				}
			} else {
				if (this.getFactionEtu() == etuJoueur1.get(0).getFactionEtu()) {
					new Attaquer().typeStrategie(etuJoueur2, this);
				} else {
					new Attaquer().typeStrategie(etuJoueur1, this);
				}
			}
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
