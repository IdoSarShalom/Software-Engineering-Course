package project4;

import java.util.Collections; // Import the Collections class
import java.util.ArrayList; // Import the ArrayList class
import java.util.Iterator; // Import  the Iterator class
import java.util.Scanner; // Import the Scanner class

import javax.swing.JOptionPane;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.IOException; // Import this class to handle errors
import java.io.FileWriter; // Import the FileWriter class

public class Contacts {

	// fields:
	private ArrayList<Person> list;
	// --------------------------------------

	// constructors:
	public Contacts() {
		this.list = new ArrayList<Person>();
	}
	// --------------------------------------

	// getters & setters:
	public ArrayList<Person> getList() {
		return list;
	}

	public void setList(ArrayList<Person> list) {
		this.list = list;
	}
	// --------------------------------------

	// general functions:
	// 1
	public void addPerson(Person p) {
		Iterator<Person> it = this.list.iterator();
		while (it.hasNext() & it.hasNext() != false) {
			if (it.next().getName().equals(p.getName())) {
				JOptionPane.showMessageDialog(null, "Failed to add, there is already person with this name");
				return;
			}
		}
		this.list.add(p);
	}

	// 2

	public void removePerson(String name) {
		Iterator<Person> it = this.list.iterator();
		while (it.hasNext()) {
			if (it.next().getName().equals(name)) {
				it.remove();
				JOptionPane.showMessageDialog(null, "Person was deleted successfully");
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "Person was not found");
	}

	// 3
	public String[] print() {
		String arr_1[];
		arr_1 = new String[this.list.size() + 1];
		int i = 0;
		if (this.list.size() != 0) {
			arr_1[i] = "Contacts list:\n";
			i = i + 1;
		}
		if (this.list.isEmpty())
			JOptionPane.showMessageDialog(null, "No persons in contacts app");
		else {
			Iterator<Person> itr = this.list.iterator();
			while (itr.hasNext()) {
				arr_1[i] = itr.next().toString();
				i = i + 1;
			}
		}
		return arr_1;

	}

	// 4
	public String searchPersonByName(String name) {
		Iterator<Person> itr = this.list.iterator();
		while (itr.hasNext()) {
			Person p = itr.next();
			if (p.getName().equals(name)) {
				return p.toString();
			}
		}
		return "Person is not found";
	}

	public boolean inContacts(String name) { // return true if person's name and number in contacts, otherwise false
		Iterator<Person> itr = this.list.iterator();
		while (itr.hasNext()) {
			Person p = itr.next();
			if (p.equals(new Person(name, "0")))
				return true;
		}
		return false;
	}

	public Person retPersonByname(String name) throws CloneNotSupportedException { // return Person pointer person's
																					// name in contacts
		Iterator<Person> itr = this.list.iterator();
		while (itr.hasNext()) {
			Person p = itr.next();
			if (p.getName().equals(name)) {
				return p.clone();
			}
		}
		return null;
	}

	// Sort persons by name using the sort method of Collections class
	// 5
	public void sortPersonsByName() {
		Collections.sort(this.list);
	}

	// Sort persons by name using merge sort algorithm
	// 6
	public void sortPersonsByPhoneNumber() {
		mergeSort(this.list, 0, this.list.size() - 1);
	}

	// Divide the n-element sequence to be sorted into two
	// subsequences of (n/2) elements.
	private void mergeSort(ArrayList<Person> unsortedList, int start, int end) {
		if (start < end) {
			double q = Math.floor((double) (start + end) / 2);
			int middle = (int) q;
			mergeSort(unsortedList, start, middle);
			mergeSort(unsortedList, middle + 1, end);
			merge(unsortedList, start, middle, end);
		}
	}

	// Merge procedure assumes that List[start..middle] and List[middle+1…end] are
	// in sorted
	private void merge(ArrayList<Person> unsortedList, int start, int middle, int end) {
		ArrayList<Person> copyList = new ArrayList<Person>(unsortedList);

		int i = start;
		int j = middle + 1;

		Boolean[] flag = { true, true };

		Person p1, p2;

		for (int index = start; index <= end; index = index + 1) { // iterates from start to end
			if (!flag[0]) { // if i > middle
				p2 = copyList.get(j);
				unsortedList.set(index, p2);
				j = j + 1;
				if (j > end)
					flag[1] = false;
			} else if (!flag[1]) { // if j > end
				p1 = copyList.get(i);
				unsortedList.set(index, p1);
				i = i + 1;
				if (i > middle)
					flag[0] = false;
			} else { // otherwise
				p1 = copyList.get(i);
				p2 = copyList.get(j);

				// if list(i) >= list(j) - sort numerically the numbers in the list
				if (Integer.parseInt(p1.getNumber()) >= Integer.parseInt(p2.getNumber()) && flag[0]) {
					unsortedList.set(index, p1);
					i = i + 1;
					if (i > middle)
						flag[0] = false;
				} else if (flag[1]) { // if list(i) < list(j)
					unsortedList.set(index, p2);
					j = j + 1;
					if (j > end)
						flag[1] = false;
				}
			}
		}
	}

	// 7
	public void removeDup() {
		Iterator<Person> it = this.list.iterator();
		ArrayList<Person> temp = new ArrayList<Person>();
		while (it.hasNext()) { // run on the original list
			boolean b = true;
			Iterator<Person> tempIt = temp.iterator();
			Person p1 = it.next();
			while (tempIt.hasNext()) { // run on the unique list
				Person p2 = tempIt.next();
				if (p1.equals(p2)) {
					it.remove(); // remove from the list if it already in the unique
					b = false;
					break;
				}
			}
			if (b) { // if it is the first time
				temp.add(p1);
			}
		}
	}

	// 8
	public void reverseOrder() {
		Iterator<Person> itr = this.list.iterator();
		ArrayList<Person> temp = new ArrayList<Person>();
		while (itr.hasNext()) {
			temp.add(0, itr.next()); // add elements to the head
		}
		this.list = temp;
	}

	// we assume the write and read files are arranged like that:
	// name-number
	// name-number
	// ...

	// 9
	public void writeInFile(String fileName) {
		try {
			File myFile = new File(fileName + ".txt"); // create the file
			myFile.createNewFile();
			try {
				FileWriter writer_1 = new FileWriter(myFile.getName());
				Iterator<Person> itr = this.list.iterator();
				while (itr.hasNext()) { // iterates the list and write in the file
					Person a = new Person();
					a = itr.next();
					writer_1.write(a.getName() + "-" + a.getNumber() + "\n");
				}
				writer_1.close();
				JOptionPane.showMessageDialog(null, "Contacts have been saved in file");
			} catch (IOException error) { // if can't write
				JOptionPane.showMessageDialog(null, "Error: " + error.toString());
			}

		} catch (IOException error) { // if can't create the file
			JOptionPane.showMessageDialog(null, "Error: " + error.toString());
		}

	}

	// 10
	public void readFromFile(String fileName) {
		try {
			File file = new File(fileName); // create file object
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) { // iterates the file and save it line by line
				String line = reader.nextLine();
				String[] data = line.split("-"); // split the data by the delimiter we used
				this.list.add(new Person(data[0], data[1]));
			}
			reader.close();
		} catch (FileNotFoundException e) { // if cannot locate the file
			JOptionPane.showMessageDialog(null, "Error: " + e.toString());
		}
	}

	// --------------------------------------

}
