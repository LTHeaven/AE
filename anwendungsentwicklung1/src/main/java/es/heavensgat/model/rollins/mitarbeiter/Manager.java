package es.heavensgat.model.rollins.mitarbeiter;

public class Manager {

	private double bonus;

	public Manager(Manager original) {

		bonus = original.getBonus();
	}

	public Manager(int id, String name, double festgehalt, double bonus) {
		//Die Manager-IDs fangen alle mit 50 an

		setBonus(bonus);
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) 
	{
		//Der Bonus liegt zwischen 1 und 200%
		if(bonus > 0 && bonus <= 2)
			this.bonus = bonus;
		else
			this.bonus = 0;
	}
	protected void setID(int id){

	}
	public double berechneBonus(){
		return getFestgehalt() *  bonus;
	}
	public double einkommen(){
		return getFestgehalt() + berechneBonus();
	}
	public String toString(){
		return super.toString()+"Manager bekommt dazu Bonus: " + berechneBonus()+"Manager hat Einkommen: " + einkommen();
	}
}
