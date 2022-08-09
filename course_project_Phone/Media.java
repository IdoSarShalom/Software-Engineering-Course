package project4;

public abstract class Media {
	// fields:
	private String name;
	private String length;
	// --------------------------------------

	// constructors:
	public Media(String n, String l) {
		this.name = n;
		this.length = l;
	}
	// --------------------------------------

	// getters & setters:
	public String getName() {
		return this.name;
	}

	public String getLength() {
		return this.length;
	}
	// --------------------------------------

	// general functions:
	public abstract String turnOn();

	// --------------------------------------
}
