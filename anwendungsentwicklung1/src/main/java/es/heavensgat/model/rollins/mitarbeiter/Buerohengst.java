package es.heavensgat.model.rollins.mitarbeiter;


/**
 * class Buerohengst
 */
public class Buerohengst extends Mitarbeiter
{
	private double festgehalt;

	/**
	 * Buerohengst constructor
	 *
	 * @param original
	 */
	public Buerohengst(Buerohengst original)
	{
		super(original.getID(), original.getName());
		festgehalt = original.getFestgehalt();
	}

	/**
	 * Buerohengst constructor
	 *
	 * @param id
	 * @param name
	 * @param festgehalt
	 */
	public Buerohengst(int id, String name, double festgehalt)
	{
		super(id, name);
		setFestgehalt(festgehalt);
	}

	/**
	 * @return double
	 */
	public double getFestgehalt()
	{
		return festgehalt;
	}

	/**
	 * @return double
	 */
	public double einkommen()
	{
		return festgehalt;
	}

	/**
	 * @param int festgehalt
	 */
	public void setFestgehalt(double festgehalt)
	{
		// Mindestlohn 300 Euro
		if(festgehalt > 300)
		{
			this.festgehalt = festgehalt;
		} else{
			this.festgehalt = 300;
		}
	}

	/**
	 * @param int id
	 */
	protected void setID(int id)
	{
		this.id = id;
	}

	/**
	 * @return string
	 */
	public String toString()
	{
		return super.toString() +"Buerohengst hat Einkommen: " + festgehalt;
	}
}
