package fr.utt.LO02.VL.CestDuBrutal;

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
	public Etudiant(Faction factionEtu, boolean enCombat, double dexterite, double force, double resistance, int initiative,
			int constitution) {
		this.enCombat = enCombat;
		this.dexterite = dexterite;
		this.force = force;
		this.resistance = resistance;
		this.constitution = constitution;
		this.initiative = initiative;
		this.factionEtu = factionEtu;
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
	 * 
	 * @param etudiantCible
	 */
	public void action(Etudiant etudiantCible) {
		strategie.typeStrategie(etudiantCible, this);
	}
	
	@Override
	/**
	 * 
	 */
	public String toString() {
		return "\nCredits ECTS : " + this.creditsECTS 
				+ "\nDexterite : " + this.dexterite 
				+ "\nForce : " + this.force 
				+ "\nResistence : " + this.resistance
				+ "\nInitiative : " + this.initiative
				+ "\nConstitution : " + this.constitution
				+ "\nStrategie : " + this.strategie;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Etudiant toto = new Etudiant(Faction.A2I,false, 0, 0, 0, 0, 0);
		System.out.println(toto.toString());
	}
	
	

}