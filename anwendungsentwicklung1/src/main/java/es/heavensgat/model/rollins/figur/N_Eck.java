package es.heavensgat.model.rollins.figur;

public class N_Eck {

	private double seitenLaenge;
	private int n;

	public int getN() {
		return n;
	}
	public N_Eck( double seitenLaenge,int anzahl ){
		
		if(seitenLaenge > 0 && anzahl > 0){
			setSeitenLaenge(seitenLaenge);
			this.n = anzahl;
		}else 
			throw new IllegalArgumentException();
	}
	@Override
	public double umfang() {

		return n*seitenLaenge;
	}
	public double getSeitenLaenge() {
		return seitenLaenge;
	}
	public void setSeitenLaenge(double seitenLaenge) {
		this.seitenLaenge = seitenLaenge;
	}
	public double innenKreisRadius(){
		return this.seitenLaenge/( Math.tan(Math.PI/this.n));
	}
	public double aussenKreisRadius(){
		return this.seitenLaenge/( Math.sin(Math.PI/this.n));
	}
	public double flaeche(){
		double seite = this.aussenKreisRadius();
		Dreieck d = new Dreieck(seite, seite, seitenLaenge);
		return d.flaeche()*n;
	}
}
