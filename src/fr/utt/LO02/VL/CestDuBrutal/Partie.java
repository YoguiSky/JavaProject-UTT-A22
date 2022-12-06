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
    public void treve(Joueur joueur) {
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
    			for(int i=0; i< quiJoue.getEtudiantsDispo().size(); i++) {
    				if (quiJoue.getEtudiantsDispo().get(i).isReserviste() == true) {
    					System.out.println("Etudiant N°" + quiJoue.getEtudiantsDispo().get(i)
    							+ "\t\nCredits ECTS : " + quiJoue.getEtudiantsDispo().get(i).getCreditsECTS()
    							+ "\t\nDexterite : " + quiJoue.getEtudiantsDispo().get(i).getDexterite()
    							+ "\t\nForce : " + quiJoue.getEtudiantsDispo().get(i).getForce()
    							+ "\t\nResistance : " + quiJoue.getEtudiantsDispo().get(i).getResistance()
    							+ "\t\nInitiative : " + quiJoue.getEtudiantsDispo().get(i).getInitiative()
    							+ "\t\nConstitution : " + quiJoue.getEtudiantsDispo().get(i).getConstitution());	
    				}
    				reservisteSelec = entree.nextInt();
    				//On affecte le réserviste dans une zone qui n'est pas déjà contrôlée
    				if(quiJoue.getEtudiantsDispo().get(reservisteSelec).isReserviste() == true) {
    					System.out.println("Zones non controlees : ");
    					for (int j = 0; j < zones.size() ; j++ ) {
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
    		case 2: break;
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