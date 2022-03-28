package application;

public class Employee {
	final Department dept;
	
	
	public static int emplId = 0;
	/*
	 *
	 * Your code comes here. Remember you can overload constructors.
	 *
	 */
	
	String firstName;
	String lastName;
	int id;
	
	public Employee() {
		firstName = "Max";
		lastName = "Mustermann";
		id = 123;
		dept = new Department();
	}
	
	
	public Employee(String firstName, String lastName, int id, Department dept) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.dept = dept;
	}
	
	public void print() {
		System.out.println("Der Mitarbeiter " + id + " " + firstName + " " + lastName + " arbeitet in der Abteilung " + dept.name + " in " + dept.city);
	}

	public boolean isEquals(Employee other) {
		return id == other.id;
	}
}
