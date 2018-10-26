package tp.metaprogramming.memo.test;

import tp.metaprogramming.memo.Automobile;
import tp.metaprogramming.memo.AutomobileType;
import tp.metaprogramming.memo.MemoFactory;
import tp.metaprogramming.memo.Person;
import tp.metaprogramming.memo.World;

public class Main {
	
	public static void main(String[] Args)
	{
		World world = MemoFactory.eINSTANCE.createWorld();
		
		Automobile automobile = MemoFactory.eINSTANCE.createAutomobile();
		automobile.setType(AutomobileType.MERCEDES);
		automobile.setName("Class c");
		
		world.getAutomobile().add(automobile);
		
		Person person = MemoFactory.eINSTANCE.createPerson();
		person.setName("Toto");
		person.setAge(42);
		person.getAutomobile().add(automobile);
		world.getPerson().add(person);
		
		System.out.println(person.getAge());
		person.birthday();
		System.out.println(person.getAge());
	}

}
