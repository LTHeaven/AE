package es.heavensgat.model.rollins.figur.dreid;

import es.heavensgat.model.rollins.figur.zweid.N_Eck;

//Jede Seite ist gleich lang
public class GleichseitigePyramide extends Pyramide{

	public GleichseitigePyramide(double hoehe, N_Eck grund) {
		super(hoehe, grund);
	}
	public GleichseitigePyramide(double hoehe, double kante, int anzahlSeiten) {
		super(hoehe, new N_Eck(kante, anzahlSeiten));
	}
	public N_Eck getGrund(){
		return (N_Eck)super.getGrund();
	}

	@Override
	public double mantel() {

		return getGrund().umfang()/2 * this.getSlantLength();
	}
	public double getKante(){
		return getGrund().getSeitenLaenge();
	}
	public int getAnzahlSeiten() {
		return this.getGrund().getN();
	}
	public double getSlantLength(){
		
		return Math.hypot(this.getGrund().innenKreisRadius(),this.getHoehe()) ;
	}
	public double getCornerLength(){
		
		return Math.hypot(this.getGrund().getSeitenLaenge()/2 ,this.getSlantLength()) ;
	}

}
