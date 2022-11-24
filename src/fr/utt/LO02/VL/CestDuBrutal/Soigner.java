package fr.utt.LO02.VL.CestDuBrutal;

public class Soigner implements Strategie {
	
	/**
	 * méthode Stratégie qui s'occupe du soin
	 */
	public void typeStrategie(Etudiant etuCible,Etudiant etuAction) {
		int x = (int)Math.random()*101; //x est un nombre aléatoire compris entre 0 et 100 
		double y = Math.random()*0.6;
		
		System.out.println(etuAction + " soigne " + etuCible);
		if (x >= 0 && x <= 20+6*etuAction.getDexterite()){
			//Le soin est réussi !
			System.out.println("Le soin est réussi !"); //Il est préférable d'informer le joueur du déroulement du soin
			int creditsECTSGagne = (int)(y*etuCible.getConstitution());
			
			//remplacer ça par une méthode étudiant etuCible.add() qu'il faut d'abord rajouter dans la classe Etudiant
			etuCible.setCreditsECTS(etuCible.getCreditsECTS() + creditsECTSGagne );
			 
			if (etuCible.getCreditsECTS() > 30 + etuCible.getConstitution()) {
				etuCible.setCreditsECTS(30 + etuCible.getConstitution());
				
				System.out.println(etuCible + " a regagné toute sa vie !");
			}
			
			else {
				System.out.println(etuCible + " a regagné " + creditsECTSGagne + " crédits ECTS !");
					}
		}
		else{
			//Si la première condition n'est pas respectée, le soin échoue.
			System.out.println("le soin a échoué...");
		}
	}
	public String nomStrat() {
		return "soigner";
	}

	public static void main(String[] args) {
		//Commande de test :
		double z1 = 1.2;
		double z2 = 1.7;
				
		int val1 = (int)z1;
		int val2 = (int)z2;
		
		System.out.println("z1 : " + z1 +"\nz2 :"+ z2 + "\nval1 :" + val1 + "\nval2 :" + val2);
		
		
		// TODO Auto-generated method stub

	}

}