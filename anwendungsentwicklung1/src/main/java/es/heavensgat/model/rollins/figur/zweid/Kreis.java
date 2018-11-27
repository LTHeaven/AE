package es.heavensgat.model.rollins.figur.zweid;

import es.heavensgat.model.bbender.figur.Figur2D;

/**
 * class Kreis
 * @author BBender, ARollins, PMaaß
 */
public class Kreis extends Figur2D
{
	private double radius;

	/**
	 * Kreis constructor
	 *
	 * @param r
	 */
	public Kreis(double r)
	{
		setRadius(r);
	}

	/**
	 * Kreis constructor
	 */
	public Kreis()
	{
		radius = 1;
	}

	/**
	 * @param radius
	 *
	 * @return
	 */
	public void setRadius(double radius)
	{
		if(radius > 0)
		{
			this.radius = radius;
		}else {
			throw new IllegalArgumentException("Radius ist nicht zulaessig");
		}
	}

	/**
	 * @return double
	 */
	public double getRadius()
	{
		return this.radius;
	}

	/**
	 * @return double
	 */
	public double flaeche()
	{
		double flaeche = this.radius * this.radius * Math.PI;

		return flaeche;
	}

	/**
	 * @return double
	 */
	public double umfang()
	{
		return Math.PI * 2 * radius;
	}
}
