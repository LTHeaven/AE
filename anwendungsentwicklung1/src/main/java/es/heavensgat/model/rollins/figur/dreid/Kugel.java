package es.heavensgat.model.rollins.figur.dreid;

public class Kugel extends Figur3D{
	private double radius;
	
	public Kugel(double radius) {
		super();
		if(radius < 0){
			throw new IllegalArgumentException("Ungültiger radius");
		}
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double oberflaeche() {

		return 4 * Math.PI * Math.pow(radius, 2);
	}
	public double volumen() {

		return 4/3 * Math.PI * Math.pow(radius, 3);
	}

}
