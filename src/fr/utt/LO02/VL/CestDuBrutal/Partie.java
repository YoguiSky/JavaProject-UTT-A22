package fr.utt.LO02.VL.CestDuBrutal;

import java.util.LinkedHashMap;
import java.util.Map;

//import java.util.Scanner;

public final class Partie {
	private boolean gagnee;
	private int etatPartie;
	private String vainqueur;
	private Joueur quiJoue;
	private Map<Integer, Zone> Zones = new LinkedHashMap<>();
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
	public Joueur getQuiJoue() {
		return quiJoue;
	}

	/**
	 * @param quiJoue the quiJoue to set
	 */
	public void setQuiJoue(Joueur quiJoue) {
		this.quiJoue = quiJoue;
	}

	public void melee() {
		boolean flag = true;
		int zone = 0;
		while (flag == true) {
			//System.out.println((zone+1));
			flag = this.Zones.get(1).combatZone();
			zone = (zone+1)%5;
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
		// @formatter:off
		partie.Zones.put(1, new Zone("la Bibliothèque", joueur1.getFactionJoueur(), joueur2.getFactionJoueur()));
		partie.Zones.put(2,	new Zone("le Bureau Des Etudiants", joueur1.getFactionJoueur(), joueur2.getFactionJoueur()));
		partie.Zones.put(3,	new Zone("le Quartier Administratif", joueur1.getFactionJoueur(), joueur2.getFactionJoueur()));
		partie.Zones.put(4,	new Zone("les Halles industrielles", joueur1.getFactionJoueur(), joueur2.getFactionJoueur()));
		partie.Zones.put(5, new Zone("la Halle sportive", joueur1.getFactionJoueur(), joueur2.getFactionJoueur()));
		// @formatter:on
		
		/*
		 * for (int i = 1;i<20;i++) { if(i<=5) {
		 * joueur1.getEtudiantsDispo().get(i).setReserviste(true);
		 * joueur2.getEtudiantsDispo().get(i).setReserviste(true); }else if (i<=10) {
		 * partie.Zones.get(1).affecterEtudiant(joueur1.getEtudiantsDispo().get(i)); } }
		 */
		// joueur1.AffectationTroupes(partie.Zones);
		for (int i = 6; i <= 10; i++) {
			partie.Zones.get(1).affecterEtudiant(joueur1.getEtudiantsDispo().get(i));
			partie.Zones.get(1).affecterEtudiant(joueur2.getEtudiantsDispo().get(i));
		}
		partie.Zones.get(1).triInitiative();
		partie.Zones.get(1).triECTS();
		System.out.println(partie.Zones.get(1).getECTS());
		//System.out.println(partie.Zones.get(1).getEtuJoueur1().size());
		//partie.Zones.get(1).combatZone();
		//partie.Zones.get(1).combatZone();
		partie.melee();
		// partie.Zones.get(1).testSort();
		// TODO Auto-generated method stub

	}

}
