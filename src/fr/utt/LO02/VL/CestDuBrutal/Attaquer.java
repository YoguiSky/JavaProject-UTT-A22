package fr.utt.LO02.VL.CestDuBrutal;

/**
 * Classe Attaquer de notre interface Strategie
 * @author Vincent
 *
 */
public class Attaquer implements Strategie{
	
	/**
	 * méthode attaquer
	 */
	public void typeStrategie(Etudiant etuCible,Etudiant etuAction) {
		System.out.println(etuAction + " attaque " + etuCible);
		
		//On commence par définir tous nos paramètres :
		
		int x = (int)Math.random()*101; //x est un nombre aléatoire compris entre 0 et 100
		double y = -(Math.random()-1); //la fonction random donne un nombre aléatoire compris entre [0,1[. On soustrait 1 au nombre obtenu pour qu'il soit compris dans l'intervalle [-1,0[. On multiplie ensuite le résultat par (-1) afin d'avoir un nombre compris entre ]0,1].
		int degatsReference = 10;
		double coefficientDegat;
		double valMin; // valeur minimum du coefficientDegats. 
		double valMinParam = 10*etuAction.getForce() - 5*etuCible.getResistance(); //un des deux paramètres de la condition qui nous permet d'avoir valMin.
		 
		
		int creditsECTSPerdus; //nombre de credits qui seront perdus au terme de l'attaque
		
		//on détermine si l'attaque est réussie ou non grâce à une condition. Il n'y a pas besoin de prendre la brone inférieure en compte car x est positif ou nul.
		if (x <= 40 + 3*etuAction.getDexterite()) {
			System.out.println("L'attaque est réussie.");
			
			//calcul du coefficient dégât :
			//valMinParam correspond à la deuxième valeur en paramètre de la fonction min utilisée
			if (valMinParam < 100) {
				valMin = valMinParam;
			}
			else {
				valMin = 100;
			}
			
			//on crée une deuxième condition, cette fois pour déterminer le coef le plus grand entre valMin et 0 :
			if( valMin > 0) {
				coefficientDegat = valMin;
			}
			else {
				coefficientDegat = 0;
			}
			
			//Maintenant qu'on a tous nos paramètres, nous pouvons calculer les dégats infligés à l'etudiant cible.
			creditsECTSPerdus = (int)(y*(1 + coefficientDegat)+degatsReference);
			
			etuCible.setCreditsECTS(etuCible.getCreditsECTS() - creditsECTSPerdus);
			
			System.out.println("L'Etudiant a perdu " + creditsECTSPerdus);
		}
		
		else {
			System.out.println("L'attaque a échoué...");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}