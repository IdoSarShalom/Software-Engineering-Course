package project4;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class SMS {
	private ArrayList<Text> texts;

	public SMS() {
		this.texts = new ArrayList<Text>();
	}

	public void newTextByPerson(Person p, String str) {
		if (isInTexts(p.getName())) {
			Text a = findTxtByPerson(p.getName());
			a.addText(str);
		} else {
			texts.add(new Text(p, str));
		}
	}

	public void deleteTextsByName(String name) {
		if (isInTexts(name)) {
			texts.remove(findTxtByPerson(name));
		} else {
			JOptionPane.showMessageDialog(null, "Person does not have text");

		}
	}

	public void printTxtByName(String name) {
		if (isInTexts(name)) {
			JOptionPane.showMessageDialog(null, findTxtByPerson(name).getText());
		} else {
			JOptionPane.showMessageDialog(null, "Person does not have text");
		}

	}

	public Text findTxtByPerson(String name) {
		Iterator<Text> it = this.texts.iterator();
		while (it.hasNext()) {
			Text a = it.next();
			if (a.getPersonName().equals(name)) {
				return a;
			}
		}
		return null;
	}

	public ArrayList<String> searchForStr(String str) {
		boolean flag = true;
		Iterator<Text> it = this.texts.iterator();
		ArrayList<String> contacts_ = new ArrayList<String>();
		while (it.hasNext()) {
			Text a = it.next();
			if (a.getText().contains(str)) {
				flag = false;
				contacts_.add(a.getPersonName());
			}
		}
		if (flag)
			contacts_.add("The string was not found");

		return contacts_;
	}

	public boolean isInTexts(String name) {
		Iterator<Text> it = this.texts.iterator();
		while (it.hasNext()) {
			if (it.next().getPersonName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<String> printAllTexts() {
		ArrayList<String> all_SMS = new ArrayList<String>();

		if (this.texts.isEmpty())
			all_SMS.add("there  are no texts");
		else {
			Iterator<Text> it = this.texts.iterator();
			while (it.hasNext()) {
				Text t = it.next();
				all_SMS.add(t.getPersonName() + ":");
				Iterator<String> it_1 = t.get_text_list().iterator();
				while (it_1.hasNext()) {
					all_SMS.add(it_1.next());
				}
			}
		}
		return all_SMS;
	}

}
