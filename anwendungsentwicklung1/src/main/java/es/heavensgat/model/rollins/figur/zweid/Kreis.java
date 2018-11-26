package es.heavensgat.model.rollins.figur.zweid;

import es.heavensgat.model.bbender.figur.Figur2D;

/**
 * class Kreis
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

		radius = r;
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
	public boolean setRadius(double radius)
	{
		boolean zulaessig = false;

		if(radius > 0)
		{
			zulaessig = true;
			this.radius = radius;
		}else {
			if (radius < 0)
			{
				this.radius = -radius;
			} else {
				this.radius = 1;
			}
		}

		return zulaessig; 
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
