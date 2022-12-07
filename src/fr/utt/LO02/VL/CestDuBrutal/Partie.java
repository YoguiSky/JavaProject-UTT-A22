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
    	boolean flag = false;
    	int reservisteSelec;
    	int zoneSelec;
    	int etuSelec;
    	int zoneObjectif;
    	Attaquer ofensive = new Attaquer();
    	Soigner defensive = new Soigner();
    	Aleatoire aleatoire = new Aleatoire();
    	
    	Scanner entree = new Scanner(System.in);
    	while(flag == false) {
    		System.out.println("L'heure est au mouvement de troupes !");
    		System.out.println(
    				"Quelle action voulez-vous faire ? \n1-Affecter des reservistes \n2-redeployer combatants valides \n3-Connaitre le nombre de Credits ECTS sur les zones de vos choix \n4-Passer la phase de treve");
    		switch(entree.nextInt()) {
    		//On affiche les réservistes disponibles
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
    				//On affecte le réserviste sélectionné dans une zone qui n'est pas déjà contrôlée
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
    			//On redeploye les combattants valides qui sont sur les zones deja controlées
    		case 2: 
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
    								System.out.println("Etudiant N°" + joueur1.getEtudiantsDispo().get(y)
    		    							+ "\t\nCredits ECTS : " + joueur1.getEtudiantsDispo().get(y).getCreditsECTS()
    		    							+ "\t\nDexterite : " + joueur1.getEtudiantsDispo().get(y).getDexterite()
    		    							+ "\t\nForce : " + joueur1.getEtudiantsDispo().get(y).getForce()
    		    							+ "\t\nResistance : " + joueur1.getEtudiantsDispo().get(y).getResistance()
    		    							+ "\t\nInitiative : " + joueur1.getEtudiantsDispo().get(y).getInitiative()
    		    							+ "\t\nConstitution : " + joueur1.getEtudiantsDispo().get(y).getConstitution()
    		    							+ "\t\nStrategie : " + joueur1.getEtudiantsDispo().get(y).getStrategie());
    								
    								etuSelec = entree.nextInt();
    								if(joueur1.getEtudiantsDispo().get(etuSelec).getLocalisation() == zones.get(zoneSelec)){
    									System.out.println(
    											"Choisissez ou vous voulez reaffectez l'etudiant : \n1-La Bibliothèquen\n2-Le Bureau Des Etudiants\n3-Le Quartier Administratif\n4-Les Halles Industrielles\n5-La Halle Sportive");
    									zoneObjectif = entree.nextInt();
    									//on réaffecte les étudiant sur les zones choisies tout en proposant de modifier la stratégie
    									switch(entree.nextInt()) {
    									case 1:
    										if(zoneObjectif != zoneSelec) {
    											zones.get(zoneObjectif).affecterEtudiant(joueur1.getEtudiantsDispo().get(etuSelec));
        										zones.get(zoneSelec).desaffecterEtudiant(joueur1.getEtudiantsDispo().get(etuSelec));
        										System.out.println(
        												"L'etudiant N°" + joueur1.getEtudiantsDispo().get(etuSelec) + " quitte la zone " + zones.get(zoneSelec) + " pour aller vers " + zones.get(zoneObjectif) + ".");
        										System.out.println("\nVoulez vous modifier sa strategie ? \n1-Oui\n2-Non");
        										switch(entree.nextInt()) {
        										case 1 :
        											System.out.println("Quelle strategie choisissez vous ? Le choix est vaste... \t\n1-Offensive\t\n2-Defensive\t\n3-Aleatoire\t\n4-Aucune");
        											switch(entree.nextInt()) {
        											case 1 : 
        												joueur1.getEtudiantsDispo().get(etuSelec).setStrategie(ofensive);
        												System.out.println("Strategie definie comme offensive");
        												break;
        											case 2 : 
        												joueur1.getEtudiantsDispo().get(etuSelec).setStrategie(defensive);
        												System.out.println("Strategie definie comme defensive");
        												break;
        											case 3 : 
        												joueur1.getEtudiantsDispo().get(etuSelec).setStrategie(aleatoire);        											
        												System.out.println("Strategie definie comme aleatoire");
        												break;
        											case 4 : System.out.println("Vous ne modifiez pas la strategie de l'etudiant");
        												break;
        											default : System.out.println("Non cette strategie n'existe malheureusement pas");
        											
        											}
        											break;
        										case 2 : System.out.println("D'accord."); 
        											break;
        										default : System.out.println("Commande pas valide... try again !");
        										}
    										}else {
    											System.out.println("Vous etes entrain de d'essayer de reaffecter l'etudiant sur la zone ou il est...");
    										}
    										break;
    									case 2:
    										if(zoneObjectif != zoneSelec) {
    											zones.get(zoneObjectif).affecterEtudiant(joueur1.getEtudiantsDispo().get(etuSelec));
        										zones.get(zoneSelec).desaffecterEtudiant(joueur1.getEtudiantsDispo().get(etuSelec));
        										System.out.println(
        												"L'etudiant N°" + joueur1.getEtudiantsDispo().get(etuSelec) + " quitte la zone " + zones.get(zoneSelec) + " pour aller vers " + zones.get(zoneObjectif) + ".");
        										System.out.println("\nVoulez vous modifier sa strategie ? \n1-Oui\n2-Non");
        										switch(entree.nextInt()) {
        										case 1 :
        											System.out.println("Quelle strategie choisissez vous ? Le choix est vaste... \t\n1-Offensive\t\n2-Defensive\t\n3-Aleatoire\t\n4-Aucune");
        											switch(entree.nextInt()) {
        											case 1 : 
        												joueur1.getEtudiantsDispo().get(etuSelec).setStrategie(ofensive);
        												System.out.println("Strategie definie comme offensive");
        												break;
        											case 2 : 
        												joueur1.getEtudiantsDispo().get(etuSelec).setStrategie(defensive);
        												System.out.println("Strategie definie comme defensive");
        												break;
        											case 3 : 
        												joueur1.getEtudiantsDispo().get(etuSelec).setStrategie(aleatoire);        											
        												System.out.println("Strategie definie comme aleatoire");
        												break;
        											case 4 : System.out.println("Vous ne modifiez pas la strategie de l'etudiant");
        												break;
        											default : System.out.println("Non cette strategie n'existe malheureusement pas");
        											
        											}
        											break;
        										case 2 : System.out.println("D'accord."); 
        											break;
        										default : System.out.println("Commande pas valide... try again !");
        										}
    										}else {
    											System.out.println("Vous etes entrain de d'essayer de reaffecter l'etudiant sur la zone ou il est...");
    										}
    										break;
    									case 3:
    										if(zoneObjectif != zoneSelec) {
    											zones.get(zoneObjectif).affecterEtudiant(joueur1.getEtudiantsDispo().get(etuSelec));
        										zones.get(zoneSelec).desaffecterEtudiant(joueur1.getEtudiantsDispo().get(etuSelec));
        										System.out.println(
        												"L'etudiant N°" + joueur1.getEtudiantsDispo().get(etuSelec) + " quitte la zone " + zones.get(zoneSelec) + " pour aller vers " + zones.get(zoneObjectif) + ".");
        										System.out.println("\nVoulez vous modifier sa strategie ? \n1-Oui\n2-Non");
        										switch(entree.nextInt()) {
        										case 1 :
        											System.out.println("Quelle strategie choisissez vous ? Le choix est vaste... \t\n1-Offensive\t\n2-Defensive\t\n3-Aleatoire\t\n4-Aucune");
        											switch(entree.nextInt()) {
        											case 1 : 
        												joueur1.getEtudiantsDispo().get(etuSelec).setStrategie(ofensive);
        												System.out.println("Strategie definie comme offensive");
        												break;
        											case 2 : 
        												joueur1.getEtudiantsDispo().get(etuSelec).setStrategie(defensive);
        												System.out.println("Strategie definie comme defensive");
        												break;
        											case 3 : 
        												joueur1.getEtudiantsDispo().get(etuSelec).setStrategie(aleatoire);        											
        												System.out.println("Strategie definie comme aleatoire");
        												break;
        											case 4 : System.out.println("Vous ne modifiez pas la strategie de l'etudiant");
        												break;
        											default : System.out.println("Non cette strategie n'existe malheureusement pas");
        											
        											}
        											break;
        										case 2 : System.out.println("D'accord."); 
        											break;
        										default : System.out.println("Commande pas valide... try again !");
        										}
    										}else {
    											System.out.println("Vous etes entrain de d'essayer de reaffecter l'etudiant sur la zone ou il est...");
    										}
    										break;
    									case 4:
    										if(zoneObjectif != zoneSelec) {
    											zones.get(zoneObjectif).affecterEtudiant(joueur1.getEtudiantsDispo().get(etuSelec));
        										zones.get(zoneSelec).desaffecterEtudiant(joueur1.getEtudiantsDispo().get(etuSelec));
        										System.out.println(
        												"L'etudiant N°" + joueur1.getEtudiantsDispo().get(etuSelec) + " quitte la zone " + zones.get(zoneSelec) + " pour aller vers " + zones.get(zoneObjectif) + ".");
        										System.out.println("\nVoulez vous modifier sa strategie ? \n1-Oui\n2-Non");
        										switch(entree.nextInt()) {
        										case 1 :
        											System.out.println("Quelle strategie choisissez vous ? Le choix est vaste... \t\n1-Offensive\t\n2-Defensive\t\n3-Aleatoire\t\n4-Aucune");
        											switch(entree.nextInt()) {
        											case 1 : 
        												joueur1.getEtudiantsDispo().get(etuSelec).setStrategie(ofensive);
        												System.out.println("Strategie definie comme offensive");
        												break;
        											case 2 : 
        												joueur1.getEtudiantsDispo().get(etuSelec).setStrategie(defensive);
        												System.out.println("Strategie definie comme defensive");
        												break;
        											case 3 : 
        												joueur1.getEtudiantsDispo().get(etuSelec).setStrategie(aleatoire);        											
        												System.out.println("Strategie definie comme aleatoire");
        												break;
        											case 4 : System.out.println("Vous ne modifiez pas la strategie de l'etudiant");
        												break;
        											default : System.out.println("Non cette strategie n'existe malheureusement pas");
        											
        											}
        											break;
        										case 2 : System.out.println("D'accord."); 
        											break;
        										default : System.out.println("Commande pas valide... try again !");
        										}
    										}else {
    											System.out.println("Vous etes entrain de d'essayer de reaffecter l'etudiant sur la zone ou il est...");
    										}
    										break;
    									case 5:
    										if(zoneObjectif != zoneSelec) {
    											zones.get(zoneObjectif).affecterEtudiant(joueur1.getEtudiantsDispo().get(etuSelec));
        										zones.get(zoneSelec).desaffecterEtudiant(joueur1.getEtudiantsDispo().get(etuSelec));
        										System.out.println(
        												"L'etudiant N°" + joueur1.getEtudiantsDispo().get(etuSelec) + " quitte la zone " + zones.get(zoneSelec) + " pour aller vers " + zones.get(zoneObjectif) + ".");
        										System.out.println("\nVoulez vous modifier sa strategie ? \n1-Oui\n2-Non");
        										switch(entree.nextInt()) {
        										case 1 :
        											System.out.println("Quelle strategie choisissez vous ? Le choix est vaste... \t\n1-Offensive\t\n2-Defensive\t\n3-Aleatoire\t\n4-Aucune");
        											switch(entree.nextInt()) {
        											case 1 : 
        												joueur1.getEtudiantsDispo().get(etuSelec).setStrategie(ofensive);
        												System.out.println("Strategie definie comme offensive");
        												break;
        											case 2 : 
        												joueur1.getEtudiantsDispo().get(etuSelec).setStrategie(defensive);
        												System.out.println("Strategie definie comme defensive");
        												break;
        											case 3 : 
        												joueur1.getEtudiantsDispo().get(etuSelec).setStrategie(aleatoire);        											
        												System.out.println("Strategie definie comme aleatoire");
        												break;
        											case 4 : System.out.println("Vous ne modifiez pas la strategie de l'etudiant");
        												break;
        											default : System.out.println("Non cette strategie n'existe malheureusement pas");
        											
        											}
        											break;
        										case 2 : System.out.println("D'accord."); 
        											break;
        										default : System.out.println("Commande pas valide... try again !");
        										}
    										}else {
    											System.out.println("Vous etes entrain de d'essayer de reaffecter l'etudiant sur la zone ou il est...");
    										}
    										break;
    									default: System.out.println("zone non-existante");
    									}
    								}else {
    									System.out.println("Veuillez selectionner un etudiant qui est dans cette zone !");
    								}
    							}
    						}else {
    							for (int x = 1; x < zones.get(zoneSelec).getEtuJoueur2().size(); x++) {
    								System.out.println("Etudiant N°" + joueur2.getEtudiantsDispo().get(x)
    		    							+ "\t\nCredits ECTS : " + joueur2.getEtudiantsDispo().get(x).getCreditsECTS()
    		    							+ "\t\nDexterite : " + joueur2.getEtudiantsDispo().get(x).getDexterite()
    		    							+ "\t\nForce : " + joueur2.getEtudiantsDispo().get(x).getForce()
    		    							+ "\t\nResistance : " + joueur2.getEtudiantsDispo().get(x).getResistance()
    		    							+ "\t\nInitiative : " + joueur2.getEtudiantsDispo().get(x).getInitiative()
    		    							+ "\t\nConstitution : " + joueur2.getEtudiantsDispo().get(x).getConstitution()
    		    							+ "\t\nStrategie : " + joueur2.getEtudiantsDispo().get(x).getStrategie());
    								
    								etuSelec = entree.nextInt();
    								if(joueur2.getEtudiantsDispo().get(etuSelec).getLocalisation() == zones.get(zoneSelec)){
    									System.out.println(
    											"Choisissez ou vous voulez reaffectez l'etudiant : \n1-La Bibliothèquen\n2-Le Bureau Des Etudiants\n3-Le Quartier Administratif\n4-Les Halles Industrielles\n5-La Halle Sportive");
    									zoneObjectif = entree.nextInt();
    									switch(entree.nextInt()) {
    									case 1:
    										if(zoneObjectif != zoneSelec) {
    											zones.get(zoneObjectif).affecterEtudiant(joueur2.getEtudiantsDispo().get(etuSelec));
        										zones.get(zoneSelec).desaffecterEtudiant(joueur2.getEtudiantsDispo().get(etuSelec));
        										System.out.println(
        												"L'etudiant N°" + joueur2.getEtudiantsDispo().get(etuSelec) + " quitte la zone " + zones.get(zoneSelec) + " pour aller vers " + zones.get(zoneObjectif) + ".");
        										System.out.println("\nVoulez vous modifier sa strategie ? \n1-Oui\n2-Non");
        										switch(entree.nextInt()) {
        										case 1 :
        											System.out.println("Quelle strategie choisissez vous ? Le choix est vaste... \t\n1-Offensive\t\n2-Defensive\t\n3-Aleatoire\t\n4-Aucune");
        											switch(entree.nextInt()) {
        											case 1 : 
        												joueur2.getEtudiantsDispo().get(etuSelec).setStrategie(ofensive);
        												System.out.println("Strategie definie comme offensive");
        												break;
        											case 2 : 
        												joueur2.getEtudiantsDispo().get(etuSelec).setStrategie(defensive);
        												System.out.println("Strategie definie comme defensive");
        												break;
        											case 3 : 
        												joueur2.getEtudiantsDispo().get(etuSelec).setStrategie(aleatoire);        											
        												System.out.println("Strategie definie comme aleatoire");
        												break;
        											case 4 : System.out.println("Vous ne modifiez pas la strategie de l'etudiant");
        												break;
        											default : System.out.println("Non cette strategie n'existe malheureusement pas");
        											
        											}
        											break;
        										case 2 : System.out.println("D'accord."); 
        											break;
        										default : System.out.println("Commande pas valide... try again !");
        										}
    										}else {
    											System.out.println("Vous etes entrain de d'essayer de reaffecter l'etudiant sur la zone ou il est...");
    										}
    										break;
    									case 2:
    										if(zoneObjectif != zoneSelec) {
    											zones.get(zoneObjectif).affecterEtudiant(joueur2.getEtudiantsDispo().get(etuSelec));
        										zones.get(zoneSelec).desaffecterEtudiant(joueur2.getEtudiantsDispo().get(etuSelec));
        										System.out.println(
        												"L'etudiant N°" + joueur2.getEtudiantsDispo().get(etuSelec) + " quitte la zone " + zones.get(zoneSelec) + " pour aller vers " + zones.get(zoneObjectif) + ".");
        										System.out.println("\nVoulez vous modifier sa strategie ? \n1-Oui\n2-Non");
        										switch(entree.nextInt()) {
        										case 1 :
        											System.out.println("Quelle strategie choisissez vous ? Le choix est vaste... \t\n1-Offensive\t\n2-Defensive\t\n3-Aleatoire\t\n4-Aucune");
        											switch(entree.nextInt()) {
        											case 1 : 
        												joueur2.getEtudiantsDispo().get(etuSelec).setStrategie(ofensive);
        												System.out.println("Strategie definie comme offensive");
        												break;
        											case 2 : 
        												joueur2.getEtudiantsDispo().get(etuSelec).setStrategie(defensive);
        												System.out.println("Strategie definie comme defensive");
        												break;
        											case 3 : 
        												joueur2.getEtudiantsDispo().get(etuSelec).setStrategie(aleatoire);        											
        												System.out.println("Strategie definie comme aleatoire");
        												break;
        											case 4 : System.out.println("Vous ne modifiez pas la strategie de l'etudiant");
        												break;
        											default : System.out.println("Non cette strategie n'existe malheureusement pas");
        											
        											}
        											break;
        										case 2 : System.out.println("D'accord."); 
        											break;
        										default : System.out.println("Commande pas valide... try again !");
        										}
    										}else {
    											System.out.println("Vous etes entrain de d'essayer de reaffecter l'etudiant sur la zone ou il est...");
    										}
    										break;
    									case 3:
    										if(zoneObjectif != zoneSelec) {
    											zones.get(zoneObjectif).affecterEtudiant(joueur2.getEtudiantsDispo().get(etuSelec));
        										zones.get(zoneSelec).desaffecterEtudiant(joueur2.getEtudiantsDispo().get(etuSelec));
        										System.out.println(
        												"L'etudiant N°" + joueur2.getEtudiantsDispo().get(etuSelec) + " quitte la zone " + zones.get(zoneSelec) + " pour aller vers " + zones.get(zoneObjectif) + ".");
        										System.out.println("\nVoulez vous modifier sa strategie ? \n1-Oui\n2-Non");
        										switch(entree.nextInt()) {
        										case 1 :
        											System.out.println("Quelle strategie choisissez vous ? Le choix est vaste... \t\n1-Offensive\t\n2-Defensive\t\n3-Aleatoire\t\n4-Aucune");
        											switch(entree.nextInt()) {
        											case 1 : 
        												joueur2.getEtudiantsDispo().get(etuSelec).setStrategie(ofensive);
        												System.out.println("Strategie definie comme offensive");
        												break;
        											case 2 : 
        												joueur2.getEtudiantsDispo().get(etuSelec).setStrategie(defensive);
        												System.out.println("Strategie definie comme defensive");
        												break;
        											case 3 : 
        												joueur2.getEtudiantsDispo().get(etuSelec).setStrategie(aleatoire);        											
        												System.out.println("Strategie definie comme aleatoire");
        												break;
        											case 4 : System.out.println("Vous ne modifiez pas la strategie de l'etudiant");
        												break;
        											default : System.out.println("Non cette strategie n'existe malheureusement pas");
        											
        											}
        											break;
        										case 2 : System.out.println("D'accord."); 
        											break;
        										default : System.out.println("Commande pas valide... try again !");
        										}
    										}else {
    											System.out.println("Vous etes entrain de d'essayer de reaffecter l'etudiant sur la zone ou il est...");
    										}
    										break;
    									case 4:
    										if(zoneObjectif != zoneSelec) {
    											zones.get(zoneObjectif).affecterEtudiant(joueur2.getEtudiantsDispo().get(etuSelec));
        										zones.get(zoneSelec).desaffecterEtudiant(joueur2.getEtudiantsDispo().get(etuSelec));
        										System.out.println(
        												"L'etudiant N°" + joueur2.getEtudiantsDispo().get(etuSelec) + " quitte la zone " + zones.get(zoneSelec) + " pour aller vers " + zones.get(zoneObjectif) + ".");
        										System.out.println("\nVoulez vous modifier sa strategie ? \n1-Oui\n2-Non");
        										switch(entree.nextInt()) {
        										case 1 :
        											System.out.println("Quelle strategie choisissez vous ? Le choix est vaste... \t\n1-Offensive\t\n2-Defensive\t\n3-Aleatoire\t\n4-Aucune");
        											switch(entree.nextInt()) {
        											case 1 : 
        												joueur2.getEtudiantsDispo().get(etuSelec).setStrategie(ofensive);
        												System.out.println("Strategie definie comme offensive");
        												break;
        											case 2 : 
        												joueur2.getEtudiantsDispo().get(etuSelec).setStrategie(defensive);
        												System.out.println("Strategie definie comme defensive");
        												break;
        											case 3 : 
        												joueur2.getEtudiantsDispo().get(etuSelec).setStrategie(aleatoire);        											
        												System.out.println("Strategie definie comme aleatoire");
        												break;
        											case 4 : System.out.println("Vous ne modifiez pas la strategie de l'etudiant");
        												break;
        											default : System.out.println("Non cette strategie n'existe malheureusement pas");
        											
        											}
        											break;
        										case 2 : System.out.println("D'accord."); 
        											break;
        										default : System.out.println("Commande pas valide... try again !");
        										}
    										}else {
    											System.out.println("Vous etes entrain de d'essayer de reaffecter l'etudiant sur la zone ou il est...");
    										}
    										break;
    									case 5:
    										if(zoneObjectif != zoneSelec) {
    											zones.get(zoneObjectif).affecterEtudiant(joueur2.getEtudiantsDispo().get(etuSelec));
        										zones.get(zoneSelec).desaffecterEtudiant(joueur2.getEtudiantsDispo().get(etuSelec));
        										System.out.println(
        												"L'etudiant N°" + joueur2.getEtudiantsDispo().get(etuSelec) + " quitte la zone " + zones.get(zoneSelec) + " pour aller vers " + zones.get(zoneObjectif) + ".");
        										System.out.println("\nVoulez vous modifier sa strategie ? \n1-Oui\n2-Non");
        										switch(entree.nextInt()) {
        										case 1 :
        											System.out.println("Quelle strategie choisissez vous ? Le choix est vaste... \t\n1-Offensive\t\n2-Defensive\t\n3-Aleatoire\t\n4-Aucune");
        											switch(entree.nextInt()) {
        											case 1 : 
        												joueur2.getEtudiantsDispo().get(etuSelec).setStrategie(ofensive);
        												System.out.println("Strategie definie comme offensive");
        												break;
        											case 2 : 
        												joueur2.getEtudiantsDispo().get(etuSelec).setStrategie(defensive);
        												System.out.println("Strategie definie comme defensive");
        												break;
        											case 3 : 
        												joueur2.getEtudiantsDispo().get(etuSelec).setStrategie(aleatoire);        											
        												System.out.println("Strategie definie comme aleatoire");
        												break;
        											case 4 : System.out.println("Vous ne modifiez pas la strategie de l'etudiant");
        												break;
        											default : System.out.println("Non cette strategie n'existe malheureusement pas");
        											
        											}
        											break;
        										case 2 : System.out.println("D'accord."); 
        											break;
        										default : System.out.println("Commande pas valide... try again !");
        										}
    										}else {
    											System.out.println("Vous etes entrain de d'essayer de reaffecter l'etudiant sur la zone ou il est...");
    										}
    										break;
    									default: System.out.println("zone non-existante");
    									}
    								}else {
    									System.out.println("Veuillez selectionner un etudiant qui est dans cette zone !");
    								}
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