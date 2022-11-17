package fr.utt.LO02.VL.CestDuBrutal;

public class Zone {
	
	private Joueur estControleePar;
	private String nomZone;
	private int nombreEtu; //penser à modifier le lien Zone/Etudiant dans le diagramme de classes !!

	/**
	 * constructeur de la classe Zone
	 */
	public Zone() {
		//A compléter
	}
	/**
	 * @return the estControleePar
	 */
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



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
