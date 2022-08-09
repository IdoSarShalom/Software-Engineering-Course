
public class Person {

	private String name;
	
	private String number;
	
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
	
	// override
	public String toString() {
		return "Name: " + this.name + "\tNumber: " + this.number;
	}
	
	public boolean equals(Object other) {
		if (!(other instanceof Person))
			return false;
		Person p = (Person)other;
		return this.name.equals(p.getName()) 
				&& this.number.equals(p.getNumber());
	}
	
	public boolean validNum(String number) {
		try {
		    int Value = Integer.parseInt(number);
		    return true;
		} catch (NumberFormatException e) {
		    return false;
		}
	}
	
	
}
