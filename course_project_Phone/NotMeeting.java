package project4;

import java.util.Date;

public class NotMeeting extends Event {

	// fields:
	private String description;
	//--------------------------------------
	
	// constructors:
	public NotMeeting(Date d, int dur, String des) {
		super(d,dur);
		this.description = des;
	}
	//--------------------------------------
	
	// getters & setters:
	public String getDescription() {
		return this.description;
	}
	//--------------------------------------

	// general functions:
	@Override
	public String toString() {
		return "Not meeting - \t" + super.toString() + "\t" + this.description;
	}
	
	public boolean comparePerson(Person p) {
		return false;
	}
	//--------------------------------------
}

