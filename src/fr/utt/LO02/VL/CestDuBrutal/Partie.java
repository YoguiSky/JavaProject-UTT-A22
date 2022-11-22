package fr.utt.LO02.VL.CestDuBrutal;

//import java.util.Scanner;

public class Partie {
	
	private boolean gagnee;
	private int etatPartie;
	private String vainqueur;
	private Joueur quiJoue;
	private enum phaseDeJeu{
		Treve,
		Melee,
	};
	
	/**
	 * constructeur de la classe Partie
	 */
	public Partie() {
		//A compléter
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
	public Joueur getQuiJoue() {
		return quiJoue;
	}



	/**
	 * @param quiJoue the quiJoue to set
	 */
	public void setQuiJoue(Joueur quiJoue) {
		this.quiJoue = quiJoue;
	}



	public static void main(String[] args) {
		Joueur joueur1 = new Joueur();
		joueur1.getEtudiantsDispo().get(1).action(joueur1.getEtudiantsDispo().get(2));
		// TODO Auto-generated method stub

	}

}
