package tar2;

import java.util.Date;

public abstract class Event implements Cloneable, Comparable<Event> {

	// fields:
	private Date date;
	private int duration;
	// --------------------------------------

	// constructors:
	public Event(Date d, int dur) {
		this.date = (Date) d.clone();
		this.duration = dur;
	}
	// --------------------------------------

	// getters & setters:
	public Date getDate() {
		return this.date;
	}

	public int getDuration() {
		return this.duration;
	}
	// --------------------------------------

	// general functions:
	@Override
	public String toString() {
		return "Date: " + this.date.toString() + "\tDuration: " + Integer.toString(this.duration) + " minutes ";
	}

	@Override
	public boolean equals(Object e) {
		if (e instanceof Event) {
			if (this.date.equals(((Event) e).getDate()))
				return true;
		}
		return false;
	}

	@Override
	public int compareTo(Event e) {
		return this.date.compareTo(e.getDate());
	}

	public Event clone() throws CloneNotSupportedException {
		return (Event) super.clone();
	}

	public abstract boolean comparePerson(Person p);

	// we were told to delete the latter event, so we run through the list, before
	// adding the new
	// event, and look for overlaps. newE = e, the events that already in the list =
	// this.
	// If there is not overlap return 0;
	// If there is overlap and:
	// newE starts before this -> return -1, means delete this and add new
	// newE starts after this -> return 1, means don't add new
	public int isOverlap(Event e) {
		int timeInMinutes = this.date.getHours() * 60 + this.date.getMinutes();
		int newInMinutes = e.getDate().getHours() * 60 + e.getDate().getMinutes();
		if (newInMinutes < timeInMinutes && (newInMinutes + e.getDuration() > timeInMinutes))
			return -1; // delete this and add new
		if (timeInMinutes < newInMinutes && (timeInMinutes + this.duration > newInMinutes))
			return 1; // don't add new
		return 0; // no overlap
	}

	// --------------------------------------
}
