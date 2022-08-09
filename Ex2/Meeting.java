package tar2;

import java.util.Date;

public class Meeting extends Event {

	// fields:
	private Person person;
	// --------------------------------------

	// constructors:
	public Meeting(Date d, int dur, Person p) throws CloneNotSupportedException {
		super(d, dur);
		this.person = p.clone();
	}
	// --------------------------------------

	// getters & setters:
	public Person getPerson() {
		return this.person;
	}
	// --------------------------------------

	// general functions:
	@Override
	public String toString() {
		return "Meeting - \t" + super.toString() + "\t" + this.person.toString();
	}

	public boolean comparePerson(Person p) {
		return this.person.equals(p);
	}
	// --------------------------------------
}
