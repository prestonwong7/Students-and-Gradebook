import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/** A program to add, remove, modify or print student names and grades. */
public class Gradebook {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean inputValidation = false;
		TreeMap<Integer, Student> map = new TreeMap<Integer, Student>(); // Uses student class
		
		// User input validation
		while (!inputValidation) {
			System.out.println("A)dd R)emove M)odify P)rint Q)uit");
			String input = in.next().toUpperCase();
			if (input.equals("Q")) {
				inputValidation = true;
			}
			// Add
			else if (input.equals("A")) {
				String firstName = firstName();
				String lastName = lastName();
				int ID = ID();
				String grade = grade();
				Student attribute1 = new Student(firstName, lastName, grade);
				map.put(ID, attribute1); // Add into map
			} 
			//REMOVE
			else if (input.equals("R")) {
				System.out.println("Enter ID to remove!");
				int ID = ID();
				boolean testFalse = false;
				while (!testFalse){
					if (map.get(ID) == null){
						System.out.println("NO ID FOUND! TRY AGAIN!");
						ID = ID();
						testFalse = false;
 					}
					else{
						testFalse = true;
					}
				}
				map.remove(ID); // Remove from map
			} 
			//If user selects M
			else if (input.equals("M")) {
				System.out.println("Enter the ID you want to MODIFY");
				int ID = ID();
				boolean testFalse2 = false;
				while (!testFalse2){
					if (map.get(ID) == null){
						System.out.println("NO ID FOUND! TRY AGAIN!");
						ID = ID();
						testFalse2 = false;
					}
					else{
						testFalse2 = true;
					}
				}
				String firstName = firstName();
				String lastName = lastName();
				String grade = grade();
				Student attribute1 = new Student(firstName, lastName, grade);
				map.put(ID, attribute1); // Modify the map using its ID
			} 
			//If user selects P
			else if (input.equalsIgnoreCase("P")) {
				Set set = map.entrySet();
				Iterator iterator = set.iterator();
				while(iterator.hasNext()) {
					Map.Entry mentry = (Map.Entry)iterator.next();
//					System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
					System.out.print("ID: "+ mentry.getKey() + " Student: ");
					System.out.println(mentry.getValue());
				} 
			}
			else {
				System.out.println("Try again!");
				inputValidation = false;
			}
		}
	}
	
	/**
	 * First name method
	 * @return
	 */
	public static String firstName() {
		Scanner in = new Scanner(System.in);
		boolean inputValidation = false;
		String firstName = "";
		System.out.println("Enter first name:");
		
		// Input Validation
		while (!inputValidation) { 
			if (in.hasNextLine()) { // First name validation
				String temp = in.next();
				inputValidation = true;
				firstName = temp;
			} else {
				System.out.println("Try Again!");
				in.next();
			}
		}
		return firstName;
	}
	
	/**
	 * User inputs last name
	 * @return
	 */
	public static String lastName(){
		Scanner in = new Scanner(System.in);
		boolean inputValidation = false;
		String lastName = "";
		System.out.println("Enter last name: ");
		
		// Input Validation
		while (!inputValidation) { 
			if (in.hasNextLine()) {
				String temp = in.next();
				inputValidation = true;
				lastName = temp;
			} else {
				System.out.println("Try Again!");
				in.next();
			}
		}
		return lastName;
	}
	
	/**
	 * User creates an ID for a person
	 * @return
	 */
	public static int ID(){
		Scanner in = new Scanner(System.in);
		boolean inputValidation = false;
		int ID = 0;
		System.out.println("Enter ID");
		
		while (!inputValidation) { 
			if (in.hasNextInt()) { // Input can only be number
				int temp = in.nextInt();
				inputValidation = true;
				ID = temp;
			} else {
				System.out.println("Try Again!");
				in.next();
			}
		}
		return ID;
	}
	
	/**
	 * User selects a grade
	 * @return
	 */
	public static String grade(){
		Scanner in = new Scanner(System.in);
		String grade = "";
		System.out.println("Input grade (A,B,C,D,F)");
		boolean inputValidation = false;
		
		//Validates A B C D F
		while (!inputValidation) { 
			if (in.hasNextLine()) {
				String temp = in.next();
				if (temp.equals("A")){
					inputValidation = true;
					grade = temp;
				}
				else if (temp.equals("B")){
					inputValidation = true;
					grade = temp;
				}
				else if (temp.equals("C")){
					inputValidation = true;
					grade = temp;
				}
				else if (temp.equals("D")){
					inputValidation = true;
					grade = temp;
				}
				else if (temp.equals("F")){
					inputValidation = true;
					grade = temp;
				}
				else{
					System.out.println("Try again!");
				}
			} else {
				System.out.println("Try Again!");
				in.next();
			}
		}
		return grade;
	}
}