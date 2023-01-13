package fr.utt.LO02.VL.CestDuBrutal;

import java.util.*;

/**
 * classe Zone du projet C'est du brutal !
 * @author Vincent DELESTRE
 * @author Louis GALLOIS
 */
public class Zone {

	private Faction factionJ1;
	private Faction factionJ2;
	private ArrayList<Etudiant> etuJoueur1 = new ArrayList<Etudiant>();
	private ArrayList<Etudiant> etuJoueur2 = new ArrayList<Etudiant>();
	private ArrayList<Etudiant> etuZone = new ArrayList<Etudiant>();
	private Joueur estControleePar = null;
	private Joueur joueur1;
	private Joueur joueur2;
	private String nomZone;
	private int nombreEtu;

	/**
	 * constructeur de la classe Zone
	 */
	public Zone(String nomZone, Joueur j1, Joueur j2) {
		// A compléter
		this.nomZone = nomZone;
		this.joueur1 = j1;
		this.joueur2 = j2;
		this.factionJ1 = j1.getFactionJoueur();
		this.factionJ2 = j2.getFactionJoueur();

	}
	
	/**
	 * methode qui trie les etudiants des factions compris dans la zones par ordre decroissant d'initiative
	 */
	public void triInitiative() {
		etuZone.clear();
		etuZone.addAll(etuJoueur1);
		etuZone.addAll(etuJoueur2);
		etuZone.sort(Comparator.comparing(Etudiant::getInitiative).reversed());
	}
	
	/**
	 * methode qui trie les etudiants d'une zone (par faction) par nombre de credits ECTS (ordre croissant).
	 */
	public void triECTS() {
		etuJoueur1.sort(Comparator.comparing(Etudiant::getCreditsECTS));
		etuJoueur2.sort(Comparator.comparing(Etudiant::getCreditsECTS));
	}
	
	/**
	 * 
	 * @return le nombre de credits ECTS sur une zone
	 */
	public int getECTS() {
		Iterator<Etudiant> ITetuzone = etuZone.iterator();
		int ECTSttl = 0;
		while (ITetuzone.hasNext()) {
			ECTSttl += ITetuzone.next().getCreditsECTS();
		}
		return ECTSttl;
	}
	
	/**
	 * methode qui modelise le combat dans les zones
	 * @param J1
	 * @param J2
	 * @return boolean
	 */
	public boolean combatZone(Joueur j1, Joueur j2) {
		System.out.println("\nCombat dans " + this.getNomZone());
		triECTS();
		etuZone.get(0).action(etuJoueur1, etuJoueur2);
		etuZone.add(etuZone.get(0));
		etuZone.remove(0);
		if (etuJoueur1.size() == 0 || etuJoueur2.size() == 0) {
			if (etuJoueur1.size() == 0) {
				this.setEstControleePar(j2);
				j2.setNbZonesControlees(j2.getNbZonesControlees()+1);
			} else {
				this.setEstControleePar(j1);
				j1.setNbZonesControlees(j1.getNbZonesControlees()+1);
			}
			return false;
		} else {
			return true;
		}
	}

	
	/**
	 * methode qui permet d'affecter un etudiant a une zone
	 * @param etudiant
	 */
	public void affecterEtudiant(Etudiant etudiant) {
		if (etudiant.getFactionEtu() == factionJ1) {
			etuJoueur1.add(etudiant);

		} else if (etudiant.getFactionEtu() == factionJ2) {
			etuJoueur2.add(etudiant);
		}
		etudiant.setLocalisation(this);
		System.out.println("L'etudiant N°"+etudiant.getNumEtudiant() +" a été affecté à "+this.getNomZone());
		nombreEtu = etuJoueur1.size() + etuJoueur2.size();
	}
	
	/**
	 * methode qui permet de desaffecter un etudiant d'une zone
	 * @param etudiant
	 */
	public void desaffecterEtudiant(Etudiant etudiant) {
		if (etudiant.getFactionEtu() == factionJ1) {
			etuJoueur1.remove(etudiant);
		} else if (etudiant.getFactionEtu() == factionJ2) {
			etuJoueur2.remove(etudiant);
		}
		etudiant.setLocalisation(null);
		System.out.println("L'etudiant N°"+etudiant.getNumEtudiant() +" a été désaf	fecté de "+this.getNomZone());
		nombreEtu = etuJoueur1.size() + etuJoueur2.size();
	}
	
	/**
	 * @return the estControleePar
	 */
	public Joueur getEstControleePar() {
		return estControleePar;
	}

	/**
	 * @param estControleePar the estControleePar to set
	 */
	public void setEstControleePar(Joueur estControleePar) {
		this.estControleePar = estControleePar;
	}

	/**
	 * @return the nomZone
	 */
	public String getNomZone() {
		return nomZone;
	}

	/**
	 * @param nomZone the nomZone to set
	 */
	public void setNomZone(String nomZone) {
		this.nomZone = nomZone;
	}

	/**
	 * @return the nombreEtu
	 */
	public int getNombreEtu() {
		return nombreEtu;
	}

	/**
	 * @return the etuJoueur1
	 */
	public ArrayList<Etudiant> getEtu(Joueur joueur) {
		if (joueur == joueur1)return etuJoueur1;
		else return etuJoueur2;
	}

	public ArrayList<Etudiant> getEtuJoueur1() {
		return etuJoueur1;
	}

	/**
	 * @param etuJoueur1 the etuJoueur1 to set
	 */
	public void setEtuJoueur1(ArrayList<Etudiant> etuJoueur1) {
		this.etuJoueur1 = etuJoueur1;
	}

	/**
	 * @return the etuJoueur2
	 */
	public ArrayList<Etudiant> getEtuJoueur2() {
		return etuJoueur2;
	}

	/**
	 * @param etuJoueur2 the etuJoueur2 to set
	 */
	public void setEtuJoueur2(ArrayList<Etudiant> etuJoueur2) {
		this.etuJoueur2 = etuJoueur2;
	}

	/**
	 * @return the factionJ1
	 */
	public Faction getFactionJ1() {
		return factionJ1;
	}

	/**
	 * @param factionJ1 the factionJ1 to set
	 */
	public void setFactionJ1(Faction factionJ1) {
		this.factionJ1 = factionJ1;
	}

	/**
	 * @return the factionJ2
	 */
	public Faction getFactionJ2() {
		return factionJ2;
	}

	/**
	 * @param factionJ2 the factionJ2 to set
	 */
	public void setFactionJ2(Faction factionJ2) {
		this.factionJ2 = factionJ2;
	}

}