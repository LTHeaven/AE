package es.heavensgat.model.rollins.figur.zweid;

public class GleichseitigesDreieck extends N_Eck {

	public GleichseitigesDreieck(double seitenLaenge) {
		
		super(seitenLaenge, 3);
	}

	@Override
	public double flaeche() {

		Dreieck d = new Dreieck(getSeitenLaenge() ,getSeitenLaenge(),getSeitenLaenge());

		return d.flaeche();
	}
	public double getHoehe(){
		Dreieck d = new Dreieck(this.getSeitenLaenge(),this.getSeitenLaenge(),this.getSeitenLaenge());
		return d.getHoehe();
	}

}
