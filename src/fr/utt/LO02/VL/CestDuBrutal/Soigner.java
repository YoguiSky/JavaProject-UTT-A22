package fr.utt.LO02.VL.CestDuBrutal;

import java.util.ArrayList;

public class Soigner implements Strategie {
	
	/**
	 * méthode Stratégie qui s'occupe du soin
	 */
	public void typeStrategie(ArrayList<Etudiant> etuCible,Etudiant etuAction) {
		int x = (int)(Math.random()*101); //x est un nombre aléatoire compris entre 0 et 100 
		double y = Math.random()*0.6;
		
		System.out.println("etu N "+etuAction.getNumEtudiant() + " soigne etu N " + etuCible.get(0).getNumEtudiant());
		if (x >= 0 && x <= 20+6*etuAction.getDexterite()){
			//Le soin est réussi !
			System.out.println("Le soin est reussi !"); //Il est préférable d'informer le joueur du déroulement du soin
			int creditsECTSGagne = (int)(y*(10 + etuCible.get(0).getConstitution()));
			System.out.println("y : "+y
					+"\ncreditsECTSGagne : "+creditsECTSGagne);
			//remplacer ça par une méthode étudiant etuCible.get(0).add() qu'il faut d'abord rajouter dans la classe Etudiant
			etuCible.get(0).setCreditsECTS(etuCible.get(0).getCreditsECTS() + creditsECTSGagne );
			 
			if (etuCible.get(0).getCreditsECTS() > 30 + etuCible.get(0).getConstitution()) {
				etuCible.get(0).setCreditsECTS(30 + etuCible.get(0).getConstitution());
				
				System.out.println(etuCible.get(0).getNumEtudiant() + " a regagne toute sa vie !");
			}
			
			else {
				System.out.println("etu N "+etuCible.get(0).getNumEtudiant() + " a regagne " + creditsECTSGagne + " credits ECTS !");
					}
		}
		else{
			//Si la première condition n'est pas respectée, le soin échoue.
			System.out.println("le soin echoue...");
		}
	}
	public String nomStrat() {
		return "soigner";
	}

	public static void main(String[] args) {
		Soigner defensive = new Soigner();
		Etudiant etu1J1 = new Etudiant(Faction.A2I,false,10,9,1,4,2,1);
		Etudiant etu2J1 = new Etudiant(Faction.A2I,false,10,4,8,1,5,2);
		Etudiant etu3J1 = new Etudiant(Faction.A2I,false,10,2,5,9,6,3);
		Etudiant etu1J2 = new Etudiant(Faction.GM,false,10,6,8,1,2,1);
		Etudiant etu2J2 = new Etudiant(Faction.GM,false,10,3,5,4,7,2);
		Etudiant etu3J2 = new Etudiant(Faction.GM,false,10,6,1,3,5,3);
		ArrayList<Etudiant> etuJ1 = new ArrayList<Etudiant>();
		ArrayList<Etudiant> etuJ2 = new ArrayList<Etudiant>();
		etuJ1.add(etu1J1);etuJ1.add(etu2J1);etuJ1.add(etu3J1);
		etuJ2.add(etu1J2);etuJ2.add(etu2J2);etuJ2.add(etu3J2);
		
		etu1J1.setStrategie(defensive);etu2J1.setStrategie(defensive);etu3J1.setStrategie(defensive);
		etu1J2.setStrategie(defensive);etu2J2.setStrategie(defensive);etu3J2.setStrategie(defensive);
		etu1J1.setCreditsECTS(1);etu2J1.setCreditsECTS(1);etu3J1.setCreditsECTS(1);
		etu1J2.setCreditsECTS(1);etu2J2.setCreditsECTS(1);etu3J2.setCreditsECTS(1);
		etu1J1.action(etuJ2, etuJ1);
		etu2J1.action(etuJ2, etuJ1);
		etu3J1.action(etuJ2, etuJ1);
		etu1J2.action(etuJ1, etuJ2);
		etu2J2.action(etuJ1, etuJ2);
		etu3J2.action(etuJ1, etuJ2);
		
		
		/*int x1 = (int)(Math.random()*101);
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
		
		double y = Math.random()*0.6;
		for(int i=0;i<10;i++) {
			y = Math.random()*0.6;
			System.out.println("y : "+y);
		}
		*/
		// TODO Auto-generated method stub

	}

}