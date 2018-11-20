package es.heavensgat.model.rollins.figur;

//Ein Tetraeder hat vier gleiche gleichseitige Dreiecke
public class Tetraeder {

	public Tetraeder(double kante) {
		super(calcHoehe(kante), new GleichseitigesDreieck(kante));
	}

	@Override
	public double mantel() {
		return 3 * getGrund().flaeche();
	}
	//Hilfsmethode calcHoehe muss static sein, da sie im Konstruktor eingesetzt wird 
	//und die Instanz im Konstruktor noch nicht fertig aufgebaut ist
	private static double calcHoehe(double kante){

		//Strecke zum Mittelpunkt
		double sm= new GleichseitigesDreieck(kante).aussenKreisRadius()/3;
		//Pythagoras
		return Math.sqrt(kante*kante-sm*sm );
	}
	public double getKante(){
		GleichseitigesDreieck d = (GleichseitigesDreieck)getGrund();
		return d.getSeitenLaenge();
	}

}
