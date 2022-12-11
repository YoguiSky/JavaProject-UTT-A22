package fr.utt.LO02.VL.CestDuBrutal;

import java.util.LinkedHashMap;
import java.util.Map;

import java.util.Scanner;

public final class Partie {
	
	private boolean gagnee;
	private int etatPartie;
	private String vainqueur;
	private Joueur quiJoue;
	private Map<Integer, Zone> zones = new LinkedHashMap<>();
	private enum phaseDeJeu{
		Treve,
		Melee,
	};
	private static Partie instance = null;
	/**
	 * constructeur de la classe Partie
	 */
	private Partie() {
		//A compléter
	}
	

    public static Partie getInstance() {
        if ( instance == null ) {
            instance = new Partie();
        }
        return instance;
    }
    
    //Méthode associée à la phase 4 
    public void treve(Joueur joueur1, Joueur joueur2) {
    	//On déclare l'ensemble des objets au début de la méthode
    	boolean flag = false; //Condition d'arrêt de la méthode trêve
    	//zoneSelec, etuSelec et zoneObjectif sont des entiers qui prendront les valeurs choisies par le joueur dans la console
    	int zoneSelec = 0; //Il faut initialiser zoneSelec pour ne pas avoir d'erreur dans le programme
    	int etuSelec;
    	int zoneObjectif;
    	
    	Scanner entree = new Scanner(System.in);
    	while(flag == false) {
    		System.out.println("L'heure est au mouvement de troupes !");
    		System.out.println(
    				"Quelle action voulez-vous faire ? \n1-Affecter des reservistes \n2-redeployer combatants valides \n3-Connaitre le nombre de Credits ECTS sur les zones de vos choix \n4-Passer la phase de treve");
    		switch(entree.nextInt()) {
    		//On affiche les réservistes disponibles
    		case 1:
    			quiJoue.affecterReservistes(quiJoue, zones, zoneSelec);
    			break;
    			//On redéploye les combattants valides qui sont sur les zones deja controlées
    		case 2: 
    			//il faut bien sûr que le joueur contrôle des zones afin de pouvoir réaliser cette étape
    			if(quiJoue.getNbZonesControlees() != 0) {
    				for(int k=1; k < zones.size(); k++ ) {
    					if(zones.get(k).getEstControleePar() == quiJoue) {
    						System.out.println("Zone N°" + k + " : " + zones.get(k).getNomZone());
    					}
    					
    					zoneSelec = entree.nextInt();
    					if(zones.get(zoneSelec).getEstControleePar() == quiJoue){
    						System.out.println("Quels etudiants voulez-vous reaffecter ?");
    						
    						//petit problème : il faut s'assurer que les étudiants sélectionnées correspondent bien aux étudiants du joueur qui fait l'action; d'où la vérification de la faction des etudiants
    						if( quiJoue.getFactionJoueur() == joueur1.getFactionJoueur()) {
    							
    							for (int y = 1; y < zones.get(zoneSelec).getEtuJoueur1().size(); y++) {
    								//On affiche le numéro de l'étudiant ainsi que ses caractéristiques
    								System.out.println("Etudiant N°" + joueur1.getEtudiantsDispo().get(y) 
    										+ "\n" + joueur1.getEtudiantsDispo().get(y).toString());
    								
    								etuSelec = entree.nextInt();
    								joueur1.getEtudiantsDispo().get(etuSelec).affecterEtudiantZone(joueur1, zones,etuSelec, zoneSelec);
    							}
    						}else {
    							for (int x = 1; x < zones.get(zoneSelec).getEtuJoueur2().size(); x++) {
    								//on affiche les caractéristiques de l'étudiant à l'aide d'une méthode toString définie dans la classe Etudiant
    								System.out.println("Etudiant N°" + joueur2.getEtudiantsDispo().get(x)
    										+ "\n" + joueur2.getEtudiantsDispo().get(x).toString()); 
    								etuSelec = entree.nextInt();
    								joueur2.getEtudiantsDispo().get(etuSelec).affecterEtudiantZone(joueur2, zones, etuSelec, zoneSelec);
    							}
    						}
    						
    					}else {
    						System.out.println("Vous ne pouvez pas redeployer les etudiants d'une zone que vous ne controlez pas !");
    					}
    				}
    			}else {
    				System.out.println("Vous ne pouvez pas redeployer d'etudiants si vous ne controlez aucune zone !");
    			}
    			break;
    		//Accès à l'ensemble des crédits ECTS de l'équipe du joueur sur les zones  demandées
    		case 3: break;
    		//Si on ne fait rien on sort de la méthode
    		case 4:
    			flag = true;
    			break;
    		default: System.out.println("Veuillez choisir une action valide.");
    		}
    	}
    }
    

	/**
	 * @return the gagnee
	 */
	public boolean isGagnee() {
		return gagnee;
	}



	/**
	 * @param gagnee the gagnee to set
	 */
	public void setGagnee(boolean gagnee) {
		this.gagnee = gagnee;
	}



	/**
	 * @return the etat_partie
	 */
	public int getEtatPartie() {
		return etatPartie;
	}



	/**
	 * @param etat_partie the etat_partie to set
	 */
	public void setEtatPartie(int etatPartie) {
		this.etatPartie = etatPartie;
	}



	/**
	 * @return the vainqueur
	 */
	public String getVainqueur() {
		return vainqueur;
	}



	/**
	 * @param vainqueur the vainqueur to set
	 */
	public void setVainqueur(String vainqueur) {
		this.vainqueur = vainqueur;
	}



	/**
	 * @return the quiJoue
	 */
	public Joueur getQuiJoue() {
		return quiJoue;
	}



	/**
	 * @param quiJoue the quiJoue to set
	 */
	public void setQuiJoue(Joueur quiJoue) {
		this.quiJoue = quiJoue;
	}



	public static void main(String[] args) {
		Partie partie = Partie.getInstance();
		System.out.println(" ===== Début de la partie ! =====\n\nPhase 1 : Parametrage des troupes.\n");
		System.out.println("Tour du joueur 1 :");
		Joueur joueur1 = new Joueur();
		System.out.println("Tour du joueur 2 :");
		Joueur joueur2 = new Joueur();
		
		System.out.println("Phase 2 : Affectation des troupes sur le champ de bataille.\n");
		
		partie.zones.put(1,new Zone("la Bibliothèque",joueur1.getFactionJoueur(),joueur2.getFactionJoueur()));
		partie.zones.put(2,new Zone("le Bureau Des Etudiants",joueur1.getFactionJoueur(),joueur2.getFactionJoueur()));
		partie.zones.put(3,new Zone("le Quartier Administratif",joueur1.getFactionJoueur(),joueur2.getFactionJoueur()));
		partie.zones.put(4,new Zone("les Halles industrielles",joueur1.getFactionJoueur(),joueur2.getFactionJoueur()));
		partie.zones.put(5,new Zone("la Halle sportive",joueur1.getFactionJoueur(),joueur2.getFactionJoueur()));

		joueur1.AffectationTroupes(partie.zones);
		// TODO Auto-generated method stub

	}

}