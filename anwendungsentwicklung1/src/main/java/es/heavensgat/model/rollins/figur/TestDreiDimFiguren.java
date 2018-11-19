package es.heavensgat.model.rollins.figur;

public class TestDreiDimFiguren {

	public static void main(String[] args) {
		Figur3D [] dreiDimFiguren = new Figur3D[5];
		
		//Ein Quader
		dreiDimFiguren[0] = new GeradesPrisma(10.0, new Rechteck(3,4));
		
		//Ein Zylinder
		dreiDimFiguren[1] = new GeradesPrisma(5.0, new Kreis(4.0));
		
		//Ein Dreiecksprisma
		dreiDimFiguren[2] = new GeradesPrisma(5.0, new Dreieck(4.0, 5.0, 3.0));
		
		//Eine Kugel
		dreiDimFiguren[3] = new Kugel(5.0);

		//Eine Kugel
		dreiDimFiguren[4] = new Kegel(5.0, new Kreis(3.0));

		for(int i = 0; i < dreiDimFiguren.length; i++){
			System.out.println("Objekt der Klasse "+dreiDimFiguren[i].getClass());
			System.out.println("Oberfl�che "+ dreiDimFiguren[i].oberflaeche());
			System.out.println("Volumen "+ dreiDimFiguren[i].volumen() );
		}
	}

}
