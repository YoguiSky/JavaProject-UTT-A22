package fr.utt.LO02.VL.CestDuBrutal;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Zone {

	private Faction factionJ1;
	private Faction factionJ2;
	private Set<Etudiant> etuJoueur1 = new HashSet<Etudiant>();
	private Set<Etudiant> etuJoueur2 = new HashSet<Etudiant>();
	private Joueur estControleePar = null;
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

	public void combatZone(Joueur joueur1, Joueur joueur2) {
		this.getNomZone();
		int bestInitiativeJ1 = 0;
		int bestInitiativeJ2 = 0;
		Etudiant etuBestInitiativeJ1 = null;
		Etudiant etuBestInitiativeJ2 = null;
		Etudiant etuBestInitiative;
		// On récupère l'etat de contrôle de la zone au tout debut des combats
		Joueur statutControle = this.getEstControleePar();
		// la condition représente la condition d'arrêt des combats (changement de
		// statut de controle de la zone).
		while (this.getEstControleePar() == null || statutControle == this.getEstControleePar()) {

			Iterator<Etudiant> itJ1 = etuJoueur1.iterator();
			while (itJ1.hasNext()) {
				Etudiant meilleureInitiativeJ1 = itJ1.next();
				if (meilleureInitiativeJ1.getInitiative() > bestInitiativeJ1) {
					bestInitiativeJ1 = meilleureInitiativeJ1.getInitiative();
					etuBestInitiativeJ1 = meilleureInitiativeJ1;
				}
			}
			Iterator<Etudiant> itJ2 = etuJoueur2.iterator();
			while (itJ2.hasNext()) {
				Etudiant meilleureInitiativeJ2 = itJ2.next();
				if (meilleureInitiativeJ2.getInitiative() > bestInitiativeJ2) {
					bestInitiativeJ2 = meilleureInitiativeJ2.getInitiative();
					etuBestInitiativeJ2 = meilleureInitiativeJ2;
				}
			}
			// maintenant qu'on à récupéré la meilleure des initiatives des etudiants de
			// chaque zone, on determine la meilleur entre les deux étudiants.
			if (etuBestInitiativeJ1.getInitiative() > etuBestInitiativeJ2.getInitiative()) {
				etuBestInitiative = etuBestInitiativeJ1;
			}
			else {
				etuBestInitiative = etuBestInitiativeJ2;
			}
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

	/**
	 * @return the etuJoueur1
	 */
	public Set<Etudiant> getEtuJoueur1() {
		return etuJoueur1;
	}

	/**
	 * @param etuJoueur1 the etuJoueur1 to set
	 */
	public void setEtuJoueur1(Set<Etudiant> etuJoueur1) {
		this.etuJoueur1 = etuJoueur1;
	}

	/**
	 * @return the etuJoueur2
	 */
	public Set<Etudiant> getEtuJoueur2() {
		return etuJoueur2;
	}

	/**
	 * @param etuJoueur2 the etuJoueur2 to set
	 */
	public void setEtuJoueur2(Set<Etudiant> etuJoueur2) {
		this.etuJoueur2 = etuJoueur2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}