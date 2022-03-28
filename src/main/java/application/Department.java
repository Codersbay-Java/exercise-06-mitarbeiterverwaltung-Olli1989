package application;

public class Department {
	/*
	 *
	 * Your code comes here. Remember you can overload constructors.
	 *
	 */
	public static int depId = 0;

	int id;
	String country;
	String city;
	public String name;
	
	
	public Department() {
		name= "Test";
		id= 123;
		country = "Neverland";
		city = "Gotham";
	}
	
	public Department (String name, String country, String city, int id) {
		this.name = name;
		this.country = country;
		this.city = city;
		this.id = id;
	}
	
	
	public boolean isEquals(Department other) {
		return id == other.id;
	}
}
