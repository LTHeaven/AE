package es.heavensgat.model.rollins.mitarbeiter;

public class Buerohengst extends Mitarbeiter{

	private double festgehalt;

	public Buerohengst(Buerohengst original) {
		super(original.getID(), original.getName());
		festgehalt = original.getFestgehalt();
	}
	public Buerohengst(int id, String name, double festgehalt) {
		super(id, name);
		setFestgehalt(festgehalt);
	}

	public double getFestgehalt() {
		return festgehalt;
	}
	public double einkommen() {
		return festgehalt;
	}

	public void setFestgehalt(double festgehalt) {
		if(festgehalt > 300) // Mindestlohn 300 Euro
			this.festgehalt = festgehalt;
		else this.festgehalt = 300;
	}
	protected void setID(int id){
	}
	public String toString(){
		return super.toString() +"Buerohengst hat Einkommen: " + festgehalt;
	}
}
