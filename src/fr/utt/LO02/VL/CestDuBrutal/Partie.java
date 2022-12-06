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
    	boolean flag = false;
    	int reservisteSelec;
    	int zoneSelec;
    	Scanner entree = new Scanner(System.in);
    	while(flag == false) {
    		System.out.println("L'heure est au mouvement de troupes !");
    		System.out.println(
    				"Quelle action voulez-vous faire ? \n1-Affecter des reservistes \n2-redeployer combatants valides \n3-Connaitre le nombre de Credits ECTS sur les zones de vos choix");
    		switch(entree.nextInt()) {
    		case 1:
    			System.out.println("Reservistes disponibles :");
    			for(int i=1; i< quiJoue.getEtudiantsDispo().size(); i++) {
    				if (quiJoue.getEtudiantsDispo().get(i).isReserviste() == true) {
    					System.out.println("Etudiant N°" + quiJoue.getEtudiantsDispo().get(i)
    							+ "\t\nCredits ECTS : " + quiJoue.getEtudiantsDispo().get(i).getCreditsECTS()
    							+ "\t\nDexterite : " + quiJoue.getEtudiantsDispo().get(i).getDexterite()
    							+ "\t\nForce : " + quiJoue.getEtudiantsDispo().get(i).getForce()
    							+ "\t\nResistance : " + quiJoue.getEtudiantsDispo().get(i).getResistance()
    							+ "\t\nInitiative : " + quiJoue.getEtudiantsDispo().get(i).getInitiative()
    							+ "\t\nConstitution : " + quiJoue.getEtudiantsDispo().get(i).getConstitution()
    							+ "\t\nStrategie : " + quiJoue.getEtudiantsDispo().get(i).getStrategie());	
    				}
    				reservisteSelec = entree.nextInt();
    				//On affecte le réserviste dans une zone qui n'est pas déjà contrôlée
    				if(quiJoue.getEtudiantsDispo().get(reservisteSelec).isReserviste() == true) {
    					System.out.println("Zones non controlees : ");
    					for (int j = 1; j < zones.size() ; j++ ) {
    						if(zones.get(j).getEstControleePar() == null) {
    							System.out.println(j + "-" + zones.get(j).getNomZone()); //afficher le nombre de crédits ECTS pour chaque faction dans la zone quand la méthode sera créée
    						}
    						zoneSelec = entree.nextInt();
    						if(zones.get(zoneSelec).getEstControleePar() == null) {
    							zones.get(zoneSelec).affecterEtudiant(quiJoue.getEtudiantsDispo().get(reservisteSelec));
    							quiJoue.getEtudiantsDispo().get(reservisteSelec).setReserviste(false);
    							System.out.println(
    									"L'etudiant N°" + reservisteSelec + " est maintenant affecte dans la zone " + zones.get(zoneSelec).getNomZone() + ".");
    						}else {
    							System.out.println("Zone deja controlee !");
    						}
    					}
    				}else {
    					System.out.println("Cet etudiant n'est pas reserviste !");
    				}
    			}
    			break;
    		case 2: 
    			if(quiJoue.getNbZonesControlees() != 0) {
    				for(int k=1; k < zones.size(); k++ ) {
    					if(zones.get(k).getEstControleePar() == quiJoue) {
    						System.out.println("Zone N°" + k + " : " + zones.get(k).getNomZone());
    					}
    					zoneSelec = entree.nextInt();
    					if(zones.get(zoneSelec).getEstControleePar() == quiJoue){
    						if( quiJoue.getFactionJoueur() == joueur1.getFactionJoueur()) {
    							for (int l = 1; l < zones.get(zoneSelec).getEtuJoueur1().size(); l++) {
    								System.out.println("Etudiant N°" + joueur1.getEtudiantsDispo().get(l)
    		    							+ "\t\nCredits ECTS : " + joueur1.getEtudiantsDispo().get(l).getCreditsECTS()
    		    							+ "\t\nDexterite : " + joueur1.getEtudiantsDispo().get(l).getDexterite()
    		    							+ "\t\nForce : " + joueur1.getEtudiantsDispo().get(l).getForce()
    		    							+ "\t\nResistance : " + joueur1.getEtudiantsDispo().get(l).getResistance()
    		    							+ "\t\nInitiative : " + joueur1.getEtudiantsDispo().get(l).getInitiative()
    		    							+ "\t\nConstitution : " + joueur1.getEtudiantsDispo().get(l).getConstitution()
    		    							+ "\t\nStrategie : " + joueur1.getEtudiantsDispo().get(l).getStrategie());
    							}
    						}else {
    							for (int l = 1; l < zones.get(zoneSelec).getEtuJoueur2().size(); l++) {
    								System.out.println("Etudiant N°" + joueur2.getEtudiantsDispo().get(l)
    		    							+ "\t\nCredits ECTS : " + joueur2.getEtudiantsDispo().get(l).getCreditsECTS()
    		    							+ "\t\nDexterite : " + joueur2.getEtudiantsDispo().get(l).getDexterite()
    		    							+ "\t\nForce : " + joueur2.getEtudiantsDispo().get(l).getForce()
    		    							+ "\t\nResistance : " + joueur2.getEtudiantsDispo().get(l).getResistance()
    		    							+ "\t\nInitiative : " + joueur2.getEtudiantsDispo().get(l).getInitiative()
    		    							+ "\t\nConstitution : " + joueur2.getEtudiantsDispo().get(l).getConstitution()
    		    							+ "\t\nStrategie : " + joueur2.getEtudiantsDispo().get(l).getStrategie());
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
    		case 3: break;
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