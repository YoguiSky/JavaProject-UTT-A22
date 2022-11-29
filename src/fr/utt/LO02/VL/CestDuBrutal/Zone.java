package fr.utt.LO02.VL.CestDuBrutal;

import java.util.*;


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
		int moinsCreditsJ1 = 100;
		int moinsCreditsJ2 = 100;
		// certaines variables Etudiant sont initialisées comme nulles car elles sont
		// modifiées dans des conditions. Le programme considère une erreur si in ne les
		// initialise pas
		Etudiant etuBestInitiativeJ1 = null;
		Etudiant etuBestInitiativeJ2 = null;
		Etudiant etuAction;
		Etudiant etuCibleJ1 = null;
		Etudiant etuCibleJ2 = null;
		// On récupère l'etat de contrôle de la zone au tout debut des combats
		Joueur statutControle = this.getEstControleePar();
		// la condition représente la condition d'arrêt des combats (changement de
		// statut de controle de la zone).
		while (this.getEstControleePar() == null || statutControle == this.getEstControleePar()) {

			// On crée une boucle pour récupérer en même temps l'étudiant avec le moins de
			// credtis ECTS de cahque joueur ainsi que celui ayant la meilleure initiative.
			Iterator<Etudiant> itJ1 = etuJoueur1.iterator();
			while (itJ1.hasNext()) {
				Etudiant meilleureInitiativeJ1 = itJ1.next();
				if (meilleureInitiativeJ1.getInitiative() > bestInitiativeJ1) {
					bestInitiativeJ1 = meilleureInitiativeJ1.getInitiative();
					etuBestInitiativeJ1 = meilleureInitiativeJ1;
				}
				if (meilleureInitiativeJ1.getCreditsECTS() < moinsCreditsJ1) {
					moinsCreditsJ1 = meilleureInitiativeJ1.getCreditsECTS();
					etuCibleJ1 = etuBestInitiativeJ1;
				}
			}
			Iterator<Etudiant> itJ2 = etuJoueur2.iterator();
			while (itJ2.hasNext()) {
				Etudiant meilleureInitiativeJ2 = itJ2.next();
				if (meilleureInitiativeJ2.getInitiative() > bestInitiativeJ2) {
					bestInitiativeJ2 = meilleureInitiativeJ2.getInitiative();
					etuBestInitiativeJ2 = meilleureInitiativeJ2;
				}
				if (meilleureInitiativeJ2.getCreditsECTS() > moinsCreditsJ2) {
					moinsCreditsJ2 = meilleureInitiativeJ2.getCreditsECTS();
					etuCibleJ2 = meilleureInitiativeJ2;
				}
			}
			// maintenant qu'on à récupéré la meilleure des initiatives des etudiants de
			// chaque zone, on determine la meilleure entre les deux étudiants.
			if (etuBestInitiativeJ1.getInitiative() > etuBestInitiativeJ2.getInitiative()) {
				etuAction = etuBestInitiativeJ1;
			} else {
				etuAction = etuBestInitiativeJ2;
			}
			// maintenant, on détermine l'action que notre étudiant va réaliser. Pour cela,
			// on a besoin de récupérer la faction de l'étudaint ciblé par l'action

			if (etuAction.getStrategie() == new Attaquer()) {
				if (etuAction.getFactionEtu() == joueur1.getFactionJoueur()) {
					etuAction.action(etuCibleJ2);
				} else {
					etuAction.action(etuCibleJ1);
				}
			} else if (etuAction.getStrategie() == new Soigner()) {
				if (etuAction.getFactionEtu() == joueur1.getFactionJoueur()) {
					etuAction.action(etuCibleJ1);
				} else {
					etuAction.action(etuCibleJ2);
				}

			} else {
				double choixFaction = Math.random();
				if (choixFaction < 0.5) {
					etuAction.action(etuCibleJ1);
				} else {
					etuAction.action(etuCibleJ2);
				}

			}
		}

	}
	

	private List<Etudiant> triInitiative(Map<Integer, Etudiant> etudiantsJoueur) {
		//List orderInitiative = new ArrayList();
		//for (int i=1; i<5; i++) {
		//	etudiantsJoueur.get(i).getInitiative();
		//}
		List <Etudiant> etuOrdreInitiative = new ArrayList<Etudiant>(); 
		Iterator<Integer> itEtu = etudiantsJoueur.keySet().iterator();
		int etuTriInitiative = itEtu.next();
		return etuOrdreInitiative;
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
		// TODO Auto-generated method stub

	}

}