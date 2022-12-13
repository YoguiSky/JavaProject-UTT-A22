package fr.utt.LO02.VL.CestDuBrutal;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Classe Attaquer de notre interface Strategie
 * 
 * @author Vincent
 *
 */
public class Attaquer implements Strategie {

	/**
	 * méthode attaquer
	 */
	public void typeStrategie(ArrayList<Etudiant> etuCible,Etudiant etuAction) {
		//System.out.println(etuAction + " attaque " + etuCible.get(0));
		
		//On commence par définir tous nos paramètres :
		System.out.println("etu n°" + etuAction.getNumEtudiant() + " faction = " + etuAction.getFactionEtu() + " pv = "
				+ etuAction.getCreditsECTS() + " initiative = " + etuAction.getInitiative() + " attaque etu n°"
				+ etuCible.get(0).getNumEtudiant() + " faction = " + etuCible.get(0).getFactionEtu() + " pv = "
				+ etuCible.get(0).getCreditsECTS() + " initiative = " + etuCible.get(0).getInitiative());
		
		int x = (int)(Math.random()*101); //x est un nombre aléatoire compris entre 0 et 100
		double y = -(Math.random()-1); //la fonction random donne un nombre aléatoire compris entre [0,1[. On soustrait 1 au nombre obtenu pour qu'il soit compris dans l'intervalle [-1,0[. On multiplie ensuite le résultat par (-1) afin d'avoir un nombre compris entre ]0,1].
		int degatsReference = 10;
		double coefficientDegat;
		double valMin; // valeur minimum du coefficientDegats. 
		double valMinParam = 10*etuAction.getForce() - 5*etuCible.get(0).getResistance(); //un des deux paramètres de la condition qui nous permet d'avoir valMin.
		 
		
		int creditsECTSPerdus; //nombre de credits qui seront perdus au terme de l'attaque
		
		//on détermine si l'attaque est réussie ou non grâce à une condition. Il n'y a pas besoin de prendre la brone inférieure en compte car x est positif ou nul.
		if (x <= 40 + 3*etuAction.getDexterite()) {
			System.out.println("L'attaque est réussie.");
			
			//calcul du coefficient dégât :
			//valMinParam correspond à la deuxième valeur en paramètre de la fonction min utilisée
			if (valMinParam < 100) {
				valMin = valMinParam;
				System.out.println("valMin : "+valMin);
			}
			else {
				valMin = 100;
				System.out.println("valMin : "+valMin);
			}
			
			//on crée une deuxième condition, cette fois pour déterminer le coef le plus grand entre valMin et 0 :
			if( valMin > 0) {
				coefficientDegat = valMin/100;
				System.out.println("coefficientDegats : "+coefficientDegat);
			}
			else {
				coefficientDegat = 0;
				System.out.println("coefficientDegats : "+coefficientDegat);
			}
			
			//Maintenant qu'on a tous nos paramètres, nous pouvons calculer les dégats infligés à l'etudiant cible.
			creditsECTSPerdus = (int)(y*(1 + coefficientDegat)+degatsReference);
			
			etuCible.get(0).setCreditsECTS(etuCible.get(0).getCreditsECTS() - creditsECTSPerdus);
			
			System.out.println("L'Etudiant a perdu " + creditsECTSPerdus);
			if (etuCible.get(0).getCreditsECTS() <= 0) {
				System.out.println("L'étudiant n°" + etuCible.get(0).getNumEtudiant()
						+ " est mort, il reste " + (etuCible.size() - 1) + " étudiants\n");
				etuCible.get(0).setEstMort(true);
				etuCible.get(0).getLocalisation().desaffecterEtudiant(etuCible.get(0));
			}
			
		}
		
		else {
			System.out.println("L'attaque a échoué...");
		}
		//Ligne de tests :
		System.out.print("\nForce etuAction : "+etuAction.getForce()
		+"\nResistance EtuCible : "+etuCible.get(0).getResistance());
		System.out.println("\nx : "+x);
		System.out.println("y : "+y);
		System.out.println("degatsReference : "+degatsReference);
		System.out.println("valMinParam : "+valMinParam);
		//System.out.println("valMin : "+valMin);
		//System.out.println("coefficientDegats : "+coefficientDegat);
		//System.out.println("creditsECTSPerdus : "+creditsECTSPerdus);
	}

	public String nomStrat() {
		return "attaquer";
	}

	public static void main(String[] args) {
		Attaquer offensive = new Attaquer();
		//Joueur j1 = new Joueur();
		//Joueur j2 = new Joueur();
		//j1.setFactionJoueur(Faction.A2I);
		//j2.setFactionJoueur(Faction.GM);
		Etudiant etu1J1 = new Etudiant(Faction.A2I,false,7,9,1,4,2,1);
		Etudiant etu2J1 = new Etudiant(Faction.A2I,false,2,4,8,1,5,2);
		Etudiant etu3J1 = new Etudiant(Faction.A2I,false,4,2,5,9,6,3);
		Etudiant etu1J2 = new Etudiant(Faction.GM,false,4,6,8,1,2,1);
		Etudiant etu2J2 = new Etudiant(Faction.GM,false,1,3,5,4,7,2);
		Etudiant etu3J2 = new Etudiant(Faction.GM,false,7,6,1,3,5,3);
		ArrayList<Etudiant> etuJ1 = new ArrayList<Etudiant>();
		ArrayList<Etudiant> etuJ2 = new ArrayList<Etudiant>();
		etuJ1.add(etu1J1);etuJ1.add(etu2J1);etuJ1.add(etu3J1);
		etuJ2.add(etu1J2);etuJ2.add(etu2J2);etuJ2.add(etu3J2);
		
		etu1J1.setStrategie(offensive);etu2J1.setStrategie(offensive);etu3J1.setStrategie(offensive);
		etu1J2.setStrategie(offensive);etu2J2.setStrategie(offensive);etu3J2.setStrategie(offensive);
		etu1J1.action(etuJ2, etuJ1);
		etu2J1.action(etuJ2, etuJ1);
		//Map<Integer,Zone> zoneTest = new LinkedHashMap<>();
		// TODO Auto-generated method stub
		
		int x1 = (int)(Math.random()*101);
		int x2 = (int)(Math.random()*101);
		int x3 = (int)(Math.random()*101);
		int x4 = (int)(Math.random()*101);
		int x5 = (int)(Math.random()*101);
		System.out.println(
				"\nx1 : "+x1
				+"\nx2 : "+x2
				+"\nx3 : "+x3
				+"\nx4 : "+x4
				+"\nx5 : "+x5);
		int x = (int)(Math.random()*101);
		while (x != 100) {
			x = (int)(Math.random()*101);
		}
		System.out.println("x : "+x);
		double y = -(Math.random()-1);
		while (y < 0) {
			y = -(Math.random()-1);
		}
		System.out.println("y : "+y);
	}

}