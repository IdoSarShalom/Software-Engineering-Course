package project4;

public class Music extends Media {
	// constructors:
	public Music(String n, String l) {
		super(n, l);
	}
	//--------------------------------------

	// general functions:
	public String turnOn() {
		return ("The song " + getName() + " is now playing for " + getLength() + " time");
	}
	//--------------------------------------
}