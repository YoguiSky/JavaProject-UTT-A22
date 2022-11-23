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
		nombreEtu ++;
	}
	public void desaffecterEtudiant(Etudiant etudiant) {
		if (etudiant.getFactionEtu() == factionJ1) {
			etuJoueur1.remove(etudiant);
		} else if (etudiant.getFactionEtu() == factionJ2) {
			etuJoueur2.remove(etudiant);
		}
		nombreEtu --;
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
	 * @param nombreEtu the nombreEtu to set
	 */
	public void setNombreEtu(int nombreEtu) {
		this.nombreEtu = nombreEtu;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
