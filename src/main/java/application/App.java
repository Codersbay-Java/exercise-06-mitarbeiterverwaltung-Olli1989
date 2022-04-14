package application;

import java.util.Scanner;

public class App {
	private static int id = 0;
	private static Employee[] employeeArr = new Employee[2];
	
	public static void main(String[] args) {
		
		//application();		
		application2();	

	}
	
	private static void application() {
		Scanner scan = new Scanner(System.in);
		
		String name, country, city;
		String firstName, lastName, exit;
		Department dept;
		Employee empl;
		boolean wrong = false;
		
		System.out.println("Bitte legen Sie eine Abteilung an:");
		System.out.print("Name ");
		name = scan.nextLine();
		System.out.print("Land ");
		country = scan.nextLine();
		System.out.print("Stadt ");
		city = scan.nextLine();
		
		dept = new Department(name, country, city, generateIDDept());
		
		System.out.println("""
				
				Bitte legen Sie einen Mitarbeiter an:
				""");

		System.out.print("Vorname ");
		firstName = scan.nextLine();
		System.out.print("Nachname ");
		lastName = scan.nextLine();
		
		empl = new Employee(firstName, lastName, generateIDEmpl(), dept);
		addToStringArr(empl);
		
		System.out.println("""
				
				Sie haben folgenden Mitarbeiter angelegt:
				""");
		empl.print();
		
		System.out.println("""
				Möchten Sie noch einen Mitarbeiter anlegen?
				j for ja und n für beenden
				""");
		
		
		
		do {
			exit = scan.nextLine();
			if(exit.equalsIgnoreCase("j")) {
				application();
				wrong = false;
			} else if(exit.equalsIgnoreCase("N")) {
				printEmployeeArr();
				System.out.println("Auf Wiedersehen!");
				wrong = false;
			} else {
				System.out.println("Falsche Eingabe bitte entweder j für ja oder n für nein eingeben");
				wrong = true;
			}
		} while(wrong);
		
		
	}
	
	private static void application2() {
		Scanner scan = new Scanner(System.in);
		
		//String name, country, city;
		String firstName, lastName, exit;
		//Department dept;
		Employee empl;
		boolean wrong = false;
		int choice;
		
		Department[] deptArr = new Department[3];
		deptArr[0] = new Department("Abteilung 1", "Aut", "Linz", generateIDDept());
		deptArr[1] = new Department("Abteilung 2", "Aut", "Linz", generateIDDept());
		deptArr[2] = new Department("Abteilung 3", "Aut", "Linz", generateIDDept());
			
		System.out.println("Bitte legen Sie einen Mitarbeiter an:");

		System.out.print("Vorname ");
		firstName = scan.nextLine();
		System.out.print("Nachname ");
		lastName = scan.nextLine();
		
		System.out.println("In welcher Abteilung soll " + firstName + " " + lastName + " arbeiten?");
		
		System.out.println("Bitte wählen Sie die Abteilung: ");
		for(int i = 0; i<deptArr.length; i++) {
			System.out.println((i+1)+ " für " + deptArr[i].name);
		}
		do {
			choice = Integer.parseInt(scan.nextLine());
			if(choice < 1 || choice > deptArr.length) {
				wrong = true;
				System.out.println("Bitte wählen sie eine Nummer in dem angegebenen Bereich");
			} else {
				wrong = false;
			}
		} while(wrong);
		
		wrong = false;
		
		
		empl = new Employee(firstName, lastName, generateIDEmpl(), deptArr[choice-1]);
		addToStringArr(empl);
		
		System.out.println("""
				
				Sie haben folgenden Mitarbeiter angelegt:
				""");
		empl.print();
		
		System.out.println("""
				Möchten Sie noch einen Mitarbeiter anlegen?
				j for ja und n für beenden
				""");
		
		
		
		do {
			exit = scan.nextLine();
			if(exit.equalsIgnoreCase("j")) {
				application2();
				wrong = false;
			} else if(exit.equalsIgnoreCase("N")) {
				printEmployeeArr();
				System.out.println("Auf Wiedersehen!");
				wrong = false;
			} else {
				System.out.println("Falsche Eingabe bitte entweder j für ja oder n für nein eingeben");
				wrong = true;
			}
		} while(wrong);
		
		
	}
	
	private static int generateIDDept() {
		Department.depId++;
		return Department.depId;
	}
	
	private static int generateIDEmpl() {
		Employee.emplId++;
		return Employee.emplId;
	}
	
	
	private static void addToStringArr(Employee employee) {
		
		boolean helper = true;
		
		if(employeeArr[employeeArr.length-1]!=null) {
			Employee[] newArr = new Employee[employeeArr.length*2];
			for(int j =0 ; j<employeeArr.length;j++) {
				newArr[j]= employeeArr[j];
			}
			employeeArr = newArr;
		}
		
		for(int i = 0; i < employeeArr.length; i++) {
			
			if(employeeArr[i]==null && helper) {
				employeeArr[i] = employee;
				helper = false;
				
			} 
		}
	}
	
	private static void printEmployeeArr() {
		System.out.println("Folgende Mitarbeiter wurden angelegt:");
		for(Employee empl: employeeArr) {
			if (empl!=null) {
				System.out.println(empl.id + " " + empl.firstName + " " + empl.lastName);	
			}
		}
	}
	

}
