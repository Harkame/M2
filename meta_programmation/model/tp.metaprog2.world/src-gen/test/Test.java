package test;

import org.eclipse.emf.ecore.EMemoClass;

import tp.metaprog2.world.WorldFactory;
import tp.metaprog2.world.person;

public class Test {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		person person = WorldFactory.eINSTANCE.createperson();
		person.setName("Toto");

		WorldFactory.eINSTANCE.createperson().setName("Titi");
		WorldFactory.eINSTANCE.createperson().setName("Tata");

		/*
		EAttribute instancesAttribute = EcorePackage.eINSTANCE.getEMemoClass_Instances();
		
		for (Object object : (List) person.eClass().eGet(instancesAttribute))
			System.out.println(object.toString());
		*/
		
		EMemoClass eMemoClass = (EMemoClass) person.eClass();
		
		for(Object object : eMemoClass.getInstances())
			System.out.println(object.toString());
	}
}
