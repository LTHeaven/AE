package es.heavensgat.model.rollins.figur.zweid;


import es.heavensgat.model.bbender.figur.Figur2D;

public class Dreieck extends Figur2D {
	private double seiteA;
	private double seiteB;
	private double seiteC;
	
	//Default Konstruktor wurde bewusst weggelassen
	public Dreieck(double a, double b, double c)
	{
		if( konstruierbar(a,b,c)){
			this.seiteA = a;
			this.seiteB = b;
			this.seiteC = c;
		}
		else{
			throw new IllegalArgumentException("Dreieck ist nicht konstruierbar");
		}
	}
	//Kopierkonstruktor
	public Dreieck(Dreieck original){
		//Konstruktor mit Wert�bergabe wird genutzt
		this( original.getSeiteA(), original.getSeiteB(), original.getSeiteC() );
	}

	public double getSeiteA() {
		return seiteA;
	}
	public void setSeiteA(double seiteA) {
		
		if( konstruierbar(seiteA, this.seiteB, this.seiteC))
			this.seiteA = seiteA;
		else
			throw new IllegalArgumentException("Seitenaenderung nicht moeglich");
	}
	public double getSeiteB() {
		return seiteB;
	}
	public void setSeiteB(double seiteB) {
		
		if( konstruierbar(this.seiteA, seiteB, this.seiteC))
			this.seiteB = seiteB;
		else
			throw new IllegalArgumentException("Seitenaenderung nicht moeglich");
	}
	public double getSeiteC() {
		return seiteC;
	}
	public void setSeiteC(double seiteC) {
		
		if( konstruierbar(this.seiteA, this.seiteB, seiteC))
			this.seiteC = seiteC;
		else
			throw new IllegalArgumentException("Seitenaenderung nicht moeglich");
	}
	public double getHoehe(){
		return this.flaeche()*2/this.seiteB;
	}
	@Override
	public double flaeche()
	{
		//Anwendung der Heronschen Formel
		double s=(seiteA+seiteB+seiteB)/2;
		return Math.sqrt(s*(s-seiteA)*(s-seiteB)*(s-seiteC));
	}
	@Override
	public double umfang()
	{
		return this.seiteA + this.seiteB + this.seiteC;
	}
	public static boolean konstruierbar(double a, double b, double c){
		boolean machbar=false;
		
		if(c + b > a && b + a > c && c + a > b)
			machbar = true;
		return machbar;
	}
	public String toString(){
		return "Seite A: "+ seiteA+", Seite B: "+ seiteB +", Seite C: " 
				+ seiteC+", Flaeche: "+ flaeche()+", Umfang: "+ umfang();
	}
}
