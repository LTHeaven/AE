package es.heavensgat.model.rollins.figur;

public class Pentagon {

	public Pentagon(double seitenLaenge) {
		super(seitenLaenge, 5);
	}

	@Override
	public double flaeche() {

		return (Math.pow(this.getSeitenLaenge(),2)/4)*Math.sqrt(25+10*Math.sqrt(5));
	}

}
