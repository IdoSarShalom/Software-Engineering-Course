
import java.util.ArrayList; // Import the ArrayList class
import java.util.Iterator; // Import  the Iterator class
import java.util.Scanner; // Import the Scanner class
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.IOException; // Import this class to handle errors
import java.io.FileWriter; // Import the FileWriter class

public class Contacts {

	private ArrayList<Person> list;

	public Contacts() {
		this.list = new ArrayList<Person>();
	}

	public ArrayList<Person> getList() {
		return list;
	}

	public void setList(ArrayList<Person> list) {
		this.list = list;
	}

	// 1
	public void addPerson(Person p) {
		this.list.add(p);
	}

	// 2
	public void removePerson(String name) {
		Iterator<Person> it = this.list.iterator();
		while (it.hasNext()) {
			if (it.next().getName().equals(name)) {
				it.remove();
				return;
			}
		}
		System.out.println("Person was not found");
		System.out.println();
	}

	// 3
	public void print() {
		Iterator<Person> itr = this.list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println();
	}

	// 4
	public void searchPersonByName(String name) {
		Iterator<Person> itr = this.list.iterator();
		boolean b = true;
		while (itr.hasNext()) {
			Person p = itr.next();
			if (p.getName().equals(name)) {
				System.out.println(p);
				b = false;
			}
		}
		if (b) {
			System.out.println("Person was not found");
			System.out.println();
		}
	}	

	enum SortBy {
		NAME, PHONENUMBER
	}

	// we used the same function for numbers and letters, we separated it using enum
	// 5
	public void sortPersonsByName() {
		mergeSort(this.list, 0, this.list.size() - 1, Contacts.SortBy.NAME);
	}

	// 6
	public void sortPersonsByPhoneNumber() {
		mergeSort(this.list, 0, this.list.size() - 1, Contacts.SortBy.PHONENUMBER);
	}
	
	// Divide the n-element sequence to be sorted into two
	// subsequences of (n/2) elements.
	private void mergeSort(ArrayList<Person> unsortedList, int start, int end, Contacts.SortBy sortKey) {
		if (start < end) {
			double q = Math.floor((double) (start + end) / 2);
			int middle = (int) q;
			mergeSort(unsortedList, start, middle, sortKey);
			mergeSort(unsortedList, middle + 1, end, sortKey);
			merge(unsortedList, start, middle, end, sortKey);
		}
	}

	// Merge procedure assumes that List[start..middle] and List[middle+1…end] are
	// in sorted
	private void merge(ArrayList<Person> unsortedList, int start, int middle, int end, Contacts.SortBy sortKey) {
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

				if (sortKey == Contacts.SortBy.PHONENUMBER) { // sort by numbers
					// if list(i) >= list(j)
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

				if (sortKey == Contacts.SortBy.NAME) { // sort by letters
					// if list(i) lexicographically order before list(j)
					if (p1.getName().compareTo(p2.getName()) <= 0 && flag[0]) {
						unsortedList.set(index, p1);
						i = i + 1;
						if (i > middle)
							flag[0] = false;
					} else if (flag[1]) { // if list(i) lexicographically order after list(j)
						unsortedList.set(index, p2);
						j = j + 1;
						if (j > end)
							flag[1] = false;
					}
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
				System.out.println("Contacts have been saved in file");
			} catch (IOException error) { // if can't write
				System.out.print("Error: ");
				error.printStackTrace();
			}

		} catch (IOException error) { // if can't create the file
			System.out.print("Error: ");
			error.printStackTrace();
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
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	// main loop
	public void mainLoop() {
		Scanner reader = new Scanner(System.in);
		while (true) {
			if (!handleUser(reader)) {
				reader.close();
				return;
			}
		}
	}

	// handling
	public boolean handleUser(Scanner reader) {

		while (true) {
			printMenu();
			String inst = reader.nextLine();
			if (inst.equals("1")) {
				System.out.println("Enter name:");
				String name = reader.nextLine();
				System.out.println("Enter number:");
				String number = reader.nextLine();
				addPerson(new Person(name, number));
			} else if (inst.equals("2")) {
				System.out.println("Enter name:");
				String name = reader.nextLine();
				removePerson(name);
			} else if (inst.equals("3")) {
				print();
			} else if (inst.equals("4")) {
				System.out.println("Enter name:");
				String name = reader.nextLine();
				searchPersonByName(name);
			} else if (inst.equals("5")) {
				sortPersonsByName();
				System.out.println("Sorted");
				System.out.println();
			} else if (inst.equals("6")) {
				sortPersonsByPhoneNumber();
				System.out.println("Sorted");
				System.out.println();
			} else if (inst.equals("7")) {
				removeDup();
				System.out.println("Removed");
				System.out.println();
			} else if (inst.equals("8")) {
				reverseOrder();
			} else if (inst.equals("9")) {
				System.out.println("Enter name (without .txt):");
				String fileName = reader.nextLine();
				writeInFile(fileName);
			} else if (inst.equals("10")) {
				System.out.println("Enter path:");
				String fileName = reader.nextLine();
				readFromFile(fileName);
			} else if (inst.equals("11")) {
				System.out.println("Bye");
				return false;
			} else {
				System.out.println("Wrong input! Try again!");
				System.out.println();
				continue;
			}
			break;
		}
		return true;
	}

	public void printMenu() {
		System.out.println("What do you want to do?");
		System.out.println("1.	Add contact");
		System.out.println("2.	Delete contact");
		System.out.println("3.	Print contacts");
		System.out.println("4.	Search contact");
		System.out.println("5.	Sort contacts by name");
		System.out.println("6.	Sort contacts by number");
		System.out.println("7.	Remove duplicates");
		System.out.println("8.	Reverse the order of the contacts");
		System.out.println("9.	Save contacts in text file");
		System.out.println("10.	Load contacts from text file");
		System.out.println("11.	Exit");
	}

}
