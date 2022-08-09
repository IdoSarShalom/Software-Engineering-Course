package tar2;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

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
		System.out.println("Event was added successfully");
	}

	public void delLastEvent(Date d) {
		if (this.days_of_month[d.getDate() - 1].isEmpty()) {
			System.out.println("No events in this day");
			return;
		}
		this.days_of_month[d.getDate() - 1].removeLast();
		System.out.println("Event was deleted successfully");
	}

	public void printAllByDate(Date d) {
		boolean flag = true;
		Iterator<Event> itr = this.days_of_month[d.getDate() - 1].iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
			flag = false;
		}
		if (flag)
			System.out.println("No events in this day");
	}

	public void delEventByName(String name) {
		for (LinkedList<Event> list : this.days_of_month) {
			Iterator<Event> itr = list.iterator();
			while (itr.hasNext()) {
				Event e = itr.next();
				if (e.comparePerson(new Person(name, "0"))) // it compares between names and not number cause
					itr.remove(); 							// we cannot have two people with the same name
			}
		}
	}

	public void printAllByPerson(String name) {
		boolean flag = true;
		for (LinkedList<Event> list : this.days_of_month) {
			Iterator<Event> itr = list.iterator();
			while (itr.hasNext()) {
				Event e = itr.next();
				if (e.comparePerson(new Person(name, "0"))) {
					flag = false;
					System.out.println(e);
				}
			}
		}
		if (flag)
			System.out.println("No events with this contact");
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

	public void printAll() {
		boolean flag = true;
		for (LinkedList<Event> list : this.days_of_month) {
			Iterator<Event> itr = list.iterator();
			while (itr.hasNext()) {
				flag = false;
				System.out.println(itr.next());
			}
		}
		if (flag)
			System.out.println("No events in the Diary app");
	}

	public boolean validDate(int date, int hour, int minute) {
		if (date > 30 || date < 1) {
			System.out.println("Error! Date must by between 1 to 30");
			return false;
		}
		if (hour > 23 || hour < 0) {
			System.out.println("Error! Hour must be between 0 to 23");
			return false;
		}
		if (minute > 59 || minute < 0) {
			System.out.println("Error! Minute must be between 0 to 59");
			return false;
		}
		return true;
	}

	public void printDiaryMenu() {
		System.out.println("\nWhat do you want to do?");
		System.out.println("1.	Add event");
		System.out.println("2.	Delete event by date");
		System.out.println("3.	Print events by date");
		System.out.println("4.	Print events by contact");
		System.out.println("5.	Print all events");
		System.out.println("6.	Exit");
	}

}
