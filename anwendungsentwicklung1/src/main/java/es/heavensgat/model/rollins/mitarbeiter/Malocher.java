package es.heavensgat.model.rollins.mitarbeiter;

/**
 * class Malocher
 */
public class Malocher extends Mitarbeiter
{
	private double stundenSatz;
	private int anzahlStunden;

	/**
	 * Malocher constructor
	 *
	 * @param original
	 */
	public Malocher(Malocher original)
	{
		super(original.getID(), original.getName());
		setStundenSatz(original.getStundenSatz());
		setAnzahlStunden(original.getAnzahlStunden());
	}

	/**
	 * Malocher constructor
	 *
	 * @param id
	 * @param name
	 * @param satz
	 */
	public Malocher(int id, String name, double satz)
	{
		super(id, name);
		setStundenSatz(satz);
		setAnzahlStunden(0);
	}

	/**
	 * @return double
	 */
	public double getStundenSatz()
	{
		return stundenSatz;
	}

	/**
	 * @param double stundenSatz
	 */
	public void setStundenSatz(double stundenSatz)
	{
		if( stundenSatz > 0)
		{
			this.stundenSatz = stundenSatz;
		}else{
			throw new IllegalArgumentException("Stundensatz ungueltig");
		}
	}

	/**
	 * @return int
	 */
	public int getAnzahlStunden()
	{
		return anzahlStunden;
	}

	/**
	 * @param int anzahlStunden
	 */
	public void setAnzahlStunden(int anzahlStunden)
	{
		if( anzahlStunden > 0)
		{
			this.anzahlStunden = anzahlStunden;
		}else{
			throw new IllegalArgumentException("Anzahlstunden ungueltig");
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
	 * @return double
	 */
	public double einkommen()
	{
		return anzahlStunden *stundenSatz;
	}

	/**
	 * @return String
	 */
	public String toString()
	{
		return super.toString() +("Malocher hat Einkommen: " + einkommen());
	}
}
