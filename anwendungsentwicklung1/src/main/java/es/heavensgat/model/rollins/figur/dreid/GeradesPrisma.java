package es.heavensgat.model.rollins.figur.dreid;

import es.heavensgat.model.bbender.figur.Figur2D;

public class GeradesPrisma extends Figur3D{

	private double hoehe;
	private Figur2D grund;

	public GeradesPrisma(double hoehe, Figur2D grund) {
		this.hoehe = hoehe;
		this.grund = grund;
	}

	public double getHoehe() {
		return hoehe;
	}

	public void setHoehe(double hoehe) {
		this.hoehe = hoehe;
	}
	
	public double oberflaeche() {
		double o = 2 * grund.flaeche() + grund.umfang() * this.getHoehe();
		return o;
	}

	public double volumen() {
		
		return this.getHoehe() * grund.flaeche() ;
	}
}
