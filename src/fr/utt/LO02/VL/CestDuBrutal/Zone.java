package fr.utt.LO02.VL.CestDuBrutal;

import java.util.*;

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
	private int nombreEtu; // penser à modifier le lien Zone/Etudiant dans le diagramme de classes !!

	/**
	 * constructeur de la classe Zone
	 */
	public Zone(String nomZone, Joueur J1, Joueur J2) {
		// A compléter
		this.nomZone = nomZone;
		this.joueur1 = J1;
		this.joueur2 = J2;
		this.factionJ1 = J1.getFactionJoueur();
		this.factionJ2 = J2.getFactionJoueur();

	}
	public void triInitiative() {
		etuZone.clear();
		etuZone.addAll(etuJoueur1);
		etuZone.addAll(etuJoueur2);
		etuZone.sort(Comparator.comparing(Etudiant::getInitiative).reversed());
	}

	public void triECTS() {
		etuJoueur1.sort(Comparator.comparing(Etudiant::getCreditsECTS));
		etuJoueur2.sort(Comparator.comparing(Etudiant::getCreditsECTS));
	}

	public int getECTS() {
		//System.out.println(etuZone.size());
		Iterator<Etudiant> ITetuzone = etuZone.iterator();
		int ECTSttl = 0;
		while (ITetuzone.hasNext()) {
			ECTSttl += ITetuzone.next().getCreditsECTS();
		}
		return ECTSttl;
	}

	public boolean combatZone(Joueur J1, Joueur J2) {
		System.out.println("\nCombat dans " + this.getNomZone());
		triECTS();
		etuZone.get(0).action(etuJoueur1, etuJoueur2);
		etuZone.add(etuZone.get(0));
		etuZone.remove(0);
		if (etuJoueur1.size() == 0 || etuJoueur2.size() == 0) {
			if (etuJoueur1.size() == 0) {
				this.setEstControleePar(J2);
				J2.setNbZonesControlees(J2.getNbZonesControlees()+1);
			} else {
				this.setEstControleePar(J1);
				J1.setNbZonesControlees(J1.getNbZonesControlees()+1);
			}
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @return the estControleePar
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

	public static void main(String[] args) {
	
	}

}