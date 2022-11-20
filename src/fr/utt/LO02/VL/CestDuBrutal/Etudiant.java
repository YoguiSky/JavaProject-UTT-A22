package fr.utt.LO02.VL.CestDuBrutal;

public class Etudiant {
	
	private boolean enCombat;
	private boolean reserviste;
	private int creditsECTS = 30;
	private double dexterite = 0;
	private double force = 0;
	private double resistance = 0;
	private int constitution = 0;
	private int initiative = 0;
	private Strategie strategie;
	private Zone localisation; //a retirer/modifier quand on aura modifié le lien Etudiant/ZOne dans le diagramme de classes

	/**
	 * Le constructeur de la classe Etudiant
	 * @param enCombat
	 * @param dexterite
	 * @param force
	 * @param resistance
	 * @param initiative
	 * @param constitution
	 */
	public Etudiant(boolean enCombat, double dexterite, double force, double resistance, int initiative, int constitution) {
		this.enCombat = enCombat;
		this.dexterite = dexterite;
		this.force = force;
		this.resistance = resistance;
		this.constitution = constitution;
		this.initiative = initiative;
	}
	
	/**
	 * @return the enCombat
	 */
	public boolean isEnCombat() {
		return enCombat;
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
	public void setDexterite(double dexterite) {
		this.dexterite = dexterite;
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
	public void setForce(double force) {
		this.force = force;
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
	public void setResistance(double resistance) {
		this.resistance = resistance;
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
	public void setConstitution(int constitution) {
		this.constitution = constitution;
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
	public void setInitiative(int initiative) {
		this.initiative = initiative;
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

	public void action() {
		strategie.typeStrategie();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Etudiant toto = new Etudiant(false, 0, 0, 0, 0, 0);
	}

}
