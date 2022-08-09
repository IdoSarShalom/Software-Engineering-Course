package tar2;

public class Music extends Media {
	// constructors:
	public Music(String n, String l) {
		super(n, l);
	}
	//--------------------------------------

	// general functions:
	public void turnOn() {
		System.out.println("The song " + getName() + " is now playing for " + getLength() + " time");
	}
	//--------------------------------------
}