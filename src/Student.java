
public class Student 
implements Comparable<Gradebook> 
{
	private String firstName; // Private member variables
	private String lastName;
	private String grade;
	private int ID;
	private static int id = 1000;
	/**
	 * Original constructor
	 */
	public Student(){
		
	}
	
//	public Student(String f, String l, int i){
//		firstName = f;
//		lastName = l;
//		ID = i;
//	}
	
	/**
	 * Overloaded constructor
	 * @param f
	 * @param l
	 * @param g
	 */
	public Student(String f, String l, String g){
		firstName = f;
		lastName = l;
		grade = g;
		ID = id++;
	}
	
	/**
	 * Return the first name
	 * @return
	 */
	public String getFirstName(){
		return firstName;
	}
	
	/**
	 * Return the last name
	 * @return
	 */
	public String getLastName(){
		return lastName;
	}
	
	/**
	 * Return ID
	 * @return
	 */
	public int getID(){
		return ID;
	}
	
	/**
	 * Prints out first, last name, and grade
	 */
	public String toString(){
		return (firstName + " " + lastName + " | " + grade);
	}

	@Override
	public int compareTo(Gradebook o) {
		Object other = (Object) o;
		String last = getLastName();
		String first = getFirstName();
		if (last.compareTo(((Student) other).getLastName()) < 0){
			return -1;
		}
		else if (last.compareTo(((Student) other).getLastName()) > 0){
			return 1;
		}
		else{
			if (firstName.compareTo(((Student) other).getFirstName()) < 0){
				return -1;
			}
			else {
				return 1;
			}
		}
	}
}
//	/**
//	 * CompareTo function
//	 */
//	public int compareTo(Object o) {
//		Student other = (Student) o;
//		String last = getLastName();
//		String first = getFirstName();
//		if (last.compareTo(other.getLastName()) < 0){
//			return -1;
//		}
//		else if (last.compareTo(other.getLastName()) > 0){
//			return 1;
//		}
////		else{
////			if (firstName.compareTo(other.firstName) < 0){
////				return -1;
////			}
////			else {
////				return 1;
////			}
////		}
//		return ID;
//	}

