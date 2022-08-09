package project4;

public class Video extends Media {
	// constructors:
	public Video(String n, String l) {
		super(n, l);
	}
	//--------------------------------------
	
	// general functions:
	public String turnOn() {
		return ("The video " + getName() + " is now playing for " + getLength() + " time");
	}
	//--------------------------------------
}

