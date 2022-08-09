package tar2;

public class Person implements Comparable<Person>, Cloneable {

	// fields:
	private String name;
	private String number;
	//--------------------------------------

	// constructors:
	public Person(String name, String number) {
		this.name = name;
		if (validNum(number)) // check if the number is integer
			this.number = number;
		else {
			System.out.println("Invalid number, number was set to 00000");
			this.number = "00000";
		}
	}

	public Person() {
		this("no name", "00000");
	}
	//--------------------------------------

	// getters & setters:
	public String getName() {
		return this.name;
	}

	public String getNumber() {
		return this.number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(String number) {
		if (validNum(number))
			this.number = number;
		else {
			System.out.println("Invalid number, number was set to 00000");
			this.number = "00000";
		}
	}
	//--------------------------------------

	// general functions:
	public boolean validNum(String number) {
		try {
			int value = Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Name: " + this.name + "\tNumber: " + this.number;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Person))
			return false;
		Person p = (Person) other;
		return this.name.equals(p.getName());
	}

	@Override
	public Person clone() throws CloneNotSupportedException {
		return (Person) super.clone();
	}

	// Compare between two persons names lexicographically
	@Override
	public int compareTo(Person p) {
		return this.name.compareTo(p.getName());
	}
	//--------------------------------------

}
