package tar2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SMS {
	private ArrayList<Text> texts;

	// constructor
	public SMS() {
		this.texts = new ArrayList<Text>();
	}

	// add a text with person
	public void newTextByPerson(Person p, String str) {
		if (isInTexts(p.getName())) { // person already has texts
			Text a = findTxtByPerson(p.getName());
			a.addText(str);
		} else { // person does not have text
			texts.add(new Text(p, str));
		}
		System.out.println("SMS sent successfully");
	}

	public void deleteTextsByName(String name) {
		if (isInTexts(name)) { // person has text
			texts.remove(findTxtByPerson(name));
		} else {
			System.out.println("Person does not have text");

		}
	}

	public void printTxtByName(String name) {
		if (isInTexts(name)) { // person hhas text
			System.out.println(findTxtByPerson(name).getText());
		} else {
			System.out.println("Person does not have text");
		}

	}

	// get name and return the text with the person
	public Text findTxtByPerson(String name) {
		Iterator<Text> it = this.texts.iterator();
		while (it.hasNext()) {
			Text a = it.next();
			if (a.getPersonName().equals(name)) {
				return a;
			}
		}
		System.out.println("Person not found");
		return null;
	}

	// go over all texts and search for the string
	public void searchForStr(String str) {
		boolean flag = true; // check if the string was found
		Iterator<Text> it = this.texts.iterator();
		while (it.hasNext()) {
			Text a = it.next();
			if (a.getText().contains(str)) {
				flag = false;
				System.out.println(a.getPersonName());
			}
		}
		if (flag)
			System.out.println("The string was not found");
	}

	// check if the person has text
	public boolean isInTexts(String name) {
		Iterator<Text> it = this.texts.iterator();
		while (it.hasNext()) {
			if (it.next().getPersonName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public void printAllTexts() {
		if (this.texts.isEmpty())
			System.out.println("No texts in SMS app");
		else {
			Iterator<Text> it = this.texts.iterator();
			while (it.hasNext()) {
				Text t = it.next();
				System.out.println("Person " + t.getPersonName() + "\tmessage: " + t.getText());
			}
		}
	}

	public void printSMSMenu() {
		System.out.println("\nWhat do you want to do?");
		System.out.println("1. Send new SMS to person");
		System.out.println("2. Delete SMS with person");
		System.out.println("3. Print SMS with person");
		System.out.println("4. Search for a string");
		System.out.println("5. Print all texts");
		System.out.println("6. Exit");
	}

}
