package tp.metaprogramming.memo.test;

import tp.metaprogramming.memo.Automobile;
import tp.metaprogramming.memo.AutomobileType;
import tp.metaprogramming.memo.MemoFactory;
import tp.metaprogramming.memo.Person;
import tp.metaprogramming.memo.World;

public class MemoTest {

	public static void main(String[] args)
	{
		World world = MemoFactory.eINSTANCE.createWorld();
		
		Automobile automobile = MemoFactory.eINSTANCE.createAutomobile();
		automobile.setType(AutomobileType.MERCEDES);
		automobile.setName("Class C");
		
		world.getAutomobile().add(automobile);
		
		Person person = MemoFactory.eINSTANCE.createPerson();
		person.setName("Toto");
		person.setAge(42);
		person.getHas().add(automobile);
		
		world.getPopulation().add(person);
		
		System.out.print(person.getAge());
		person.birthday();
		System.out.print(person.getAge());
	}
}
