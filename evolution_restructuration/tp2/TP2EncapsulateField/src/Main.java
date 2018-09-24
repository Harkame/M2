/**
 * 
 * @author Louis Daviaud
 *
 */
public abstract class Main {
	/*
	 * Probleme : Les attributs sont public, on veux les rendres private mais pour y acceder quand meme
	 * 
	 * Sujet : Encapsulate	Field
	 */
	public static void main(String[] Args) {
		System.out.println("Person creation...");
		
		Person person = new Person("Toto", 42);
		
		System.out.println("Person created : ");
		
		System.out.println("\tName " + person.name);

		System.out.println("\tAge : " + person.age);
	}
}
