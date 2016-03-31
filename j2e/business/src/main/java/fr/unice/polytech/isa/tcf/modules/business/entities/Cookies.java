package fr.unice.polytech.isa.tcf.modules.business.entities;

public enum Cookies {
	//let's compile it to force the changes
	CHOCOLALALA("Chocolalala", 1.30),
	DARK_TEMPTATION("Dark Temptation", 1.90),
	SOO_CHOCOLATE("Soo Chocolate", 1.25);

	private String name;
	private double price;

	public double getPrice() { return price; }
	public String getName() { return name; }

	Cookies(String value, double price) {
		this.name = value;
		this.price = price;
	}

}
