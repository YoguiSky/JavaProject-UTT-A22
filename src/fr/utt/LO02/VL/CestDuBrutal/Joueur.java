package fr.utt.LO02.VL.CestDuBrutal;

public class Joueur {
	
	private int nbZonesControlees;
	private int nbPoints;
	private String nomJoueur;
	private Etudiant[] etudiantsDispo;
	private enum faction{
		ISI,
		MTE,
		A2I,
		RT,
		GM,
		MM,
		GI,
	};
	
	/**
	 * constructeur de la classe Joueur
	 * @param nomJoueur
	 */
	public Joueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
		//ajouter la définition de la faction du joueur
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


	/**
	 * @return the etudiantsDispo
	 */
	public Etudiant[] getEtudiantsDispo() {
		return etudiantsDispo;
	}


	/**
	 * @param etudiantsDispo the etudiantsDispo to set
	 */
	public void setEtudiantsDispo(Etudiant[] etudiantsDispo) {
		this.etudiantsDispo = etudiantsDispo;
	}


	public void affecterTroupes(Etudiant EtuAffecte ,Zone zoneAffectee,int nbTroupes) {
		
	}
	
	public void affecterPoints(Etudiant PointsEtu, int nbPoints) {
		
	}
	
	public void definirStrategie(Etudiant strategieEtu, Strategie typeStrategie) {
		
	}
	
	public void choixReserviste(Etudiant EtuReserviste, boolean EstReserviste) {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
