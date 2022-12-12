package fr.utt.LO02.VL.CestDuBrutal;

import java.util.ArrayList;

public interface Strategie {
	
	public void typeStrategie(ArrayList<Etudiant> etuCible,Etudiant etuAction);
	public String nomStrat();

}
