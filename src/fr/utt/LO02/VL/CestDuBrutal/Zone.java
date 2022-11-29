package fr.utt.LO02.VL.CestDuBrutal;

import java.util.Set;
import java.util.HashSet;

public class Zone {

	Faction factionJ1;
	Faction factionJ2;
	Set<Etudiant> etuJoueur1 = new HashSet<Etudiant>();
	Set<Etudiant> etuJoueur2 = new HashSet<Etudiant>();
	private Joueur estControleePar;
	private String nomZone;
	private int nombreEtu; // penser à modifier le lien Zone/Etudiant dans le diagramme de classes !!

	/**
	 * constructeur de la classe Zone
	 */
	public Zone(String nomZone, Faction factionJ1, Faction factionJ2) {
		// A compléter
		this.nomZone = nomZone;
		this.factionJ1 = factionJ1;
		this.factionJ2 = factionJ2;

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
		nombreEtu++;
	}
	public void desaffecterEtudiant(Etudiant etudiant) {
		if (etudiant.getFactionEtu() == factionJ1) {
			etuJoueur1.remove(etudiant);
		} else if (etudiant.getFactionEtu() == factionJ2) {
			etuJoueur2.remove(etudiant);
		}
		etudiant.setLocalisation(null);
		nombreEtu--;
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

	public Faction getFactionJ1() {
		return factionJ1;
	}

	public void setFactionJ1(Faction factionJ1) {
		this.factionJ1 = factionJ1;
	}

	public Faction getFactionJ2() {
		return factionJ2;
	}

	public void setFactionJ2(Faction factionJ2) {
		this.factionJ2 = factionJ2;
	}

	public Set<Etudiant> getEtuJoueur1() {
		return etuJoueur1;
	}

	public void setEtuJoueur1(Set<Etudiant> etuJoueur1) {
		this.etuJoueur1 = etuJoueur1;
	}

	public Set<Etudiant> getEtuJoueur2() {
		return etuJoueur2;
	}

	public void setEtuJoueur2(Set<Etudiant> etuJoueur2) {
		this.etuJoueur2 = etuJoueur2;
	}

	/**
	 * @return the nombreEtu
	 */
	public int getNombreEtu() {
		return nombreEtu;
	}

	/**
	 * @param nombreEtu the nombreEtu to set
	 */
	public void setNombreEtu(int nombreEtu) {
		this.nombreEtu = nombreEtu;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
