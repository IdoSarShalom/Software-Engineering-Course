package project4;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;

public class Diary {

	// fields:
	private LinkedList<Event>[] days_of_month;
	// --------------------------------------

	// constructors:
	public Diary() {
		this.days_of_month = new LinkedList[30];
		for (int i = 0; i < 30; i++) {
			this.days_of_month[i] = new LinkedList<Event>();
		}
	}
	// --------------------------------------

	// general functions:
	public void addEvent(Event e) throws CloneNotSupportedException {
		if (isOverlap(e))
			return;
		int day_of_month = e.getDate().getDate();
		if (e instanceof Meeting) {
			this.days_of_month[day_of_month - 1].add(e.clone());
			Collections.sort(this.days_of_month[day_of_month - 1]);
		}
		if (e instanceof NotMeeting) {
			this.days_of_month[day_of_month - 1].add(e.clone());
			Collections.sort(this.days_of_month[day_of_month - 1]);
		}
	}

	public void delLastEvent(Date d) {
		if (this.days_of_month[d.getDate() - 1].isEmpty()) {
			return;
		}
		this.days_of_month[d.getDate() - 1].removeLast();
	}

	public LinkedList<Event> printAllByDate(Date d) {
		return this.days_of_month[d.getDate() - 1];
	}

	public void delEventByName(String name) {
		for (LinkedList<Event> list : this.days_of_month) {
			Iterator<Event> itr = list.iterator();
			while (itr.hasNext()) {
				Event e = itr.next();
				if (e.comparePerson(new Person(name, "0"))) // it compares between names and not number cause
					itr.remove(); // we cannot have two people with the same name
			}
		}
	}

	public ArrayList<String> printAllByPerson(String name) {
		boolean flag = true;
		ArrayList<String> list_of_events = new ArrayList<String>();
		for (LinkedList<Event> list : this.days_of_month) {
			Iterator<Event> itr = list.iterator();
			while (itr.hasNext()) {
				Event e = itr.next();
				if (e.comparePerson(new Person(name, "0"))) {
					flag = false;
					list_of_events.add(e.toString());
				}
			}
		}
		if (flag) {
			list_of_events.add("There are no events with " + name);
		}
		return list_of_events;

	}

	private boolean isOverlap(Event newE) {
		Iterator<Event> itr = this.days_of_month[newE.getDate().getDate() - 1].iterator();
		while (itr.hasNext()) {
			Event e = itr.next();
			int inst = e.isOverlap(newE);
			if (inst == -1) { // delete the calling item and add new
				itr.remove();
				System.out.println("Latter event deleted due to time overlap");
				return false;
			}
			if (inst == 1) { // don't add new
				System.out.println("Can't add due to time overlap");
				return true;
			}
		}
		return false; // isOverlap returned just zeros - no overlaps
	}

	public ArrayList<String> printAll() {
		boolean flag = true;
		ArrayList<String> list_of_events = new ArrayList<String>();
		for (LinkedList<Event> list : this.days_of_month) {
			Iterator<Event> itr = list.iterator();
			while (itr.hasNext()) {
				flag = false;
				list_of_events.add(itr.next().toString());
			}
		}
		if (flag) {
			list_of_events.add("There are no events");
		}
		return list_of_events;
	}

	public boolean validDate(int date, int hour, int minute) {
		if (date > 30 || date < 1) {
			return false;
		}
		if (hour > 23 || hour < 0) {
			return false;
		}
		if (minute > 59 || minute < 0) {
			return false;
		}
		return true;
	}

}
