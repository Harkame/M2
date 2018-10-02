package umlutils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;
//import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

public class LoadUML {

	private static UMLFactory factory = UMLFactory.eINSTANCE;
	
	public static void main(String[] args) {
		/*
		 * Model umlP = chargerModele("model/model.uml");
		 * 
		 * String nomModele = umlP.getName();
		 * 
		 * System.out.println("Ton modèle se nomme: \"" + nomModele + "\"");
		 * 
		 * umlP.setName("NewModelName"); System.out.println("\"" + nomModele +
		 * "\" Changé ! Le modèle se nomme: \"" + umlP.getName() + "\"");
		 * 
		 * sauverModele("model/changerNom.uml", umlP);
		 */

		Model model1 = chargerModele("model/model.uml");
		//Model umlP = chargerModele("model/packageMove.uml");
		
		Package myPackage = null;
		
		Class myClass = null;
		
		for (NamedElement namedElement : model1.getMembers())
			if (namedElement instanceof Package && namedElement.getName().equals("mypackage"))
				myPackage = (Package) namedElement;
			else if (namedElement instanceof Class && namedElement.getName().equals("Class1"))
				myClass = (Class) namedElement;
		
		moveClass(myClass, myPackage);
		
		//moveClass(myClass, myPackage);

		VisibilityKind visibilityKind = VisibilityKind.PRIVATE_LITERAL;
		
		for(Property property : myClass.getOwnedAttributes())
		{
			if(property.getName().equals("myAttribut"))
			{
				property.setVisibility(visibilityKind);
				
				Operation getter = factory.createOperation();
				
				Parameter paramReturn = factory.createParameter();
				
				paramReturn.setType(property.getType());
				paramReturn.setLower(property.getLower());
				paramReturn.setUpper(property.getUpper());
				paramReturn.setDirection(ParameterDirectionKind.RETURN_LITERAL);
				
				getter.getOwnedParameters().add(paramReturn);
				getter.setVisibility(VisibilityKind.PUBLIC_LITERAL);
				getter.setName("get" + property.getName());
				
				Operation setter = factory.createOperation();
				
				Parameter paramIn = factory.createParameter();
				
				paramIn.setType(property.getType());
				paramIn.setLower(property.getLower());
				paramIn.setUpper(property.getUpper());
				paramIn.setDirection(ParameterDirectionKind.IN_LITERAL);
				
				setter.getOwnedParameters().add(paramIn);
				setter.setVisibility(VisibilityKind.PUBLIC_LITERAL);
				setter.setName("set" + property.getName());
				
				myClass.getOwnedOperations().add(getter);
				myClass.getOwnedOperations().add(setter);
			}
		}
		
		sauverModele("model/changeVisibility.uml", model1);

	}
	
	public static Operation createOperation(Property property, String methodName, VisibilityKind visibilityKind, ParameterDirectionKind parameterDirectionKind)
	{
		Operation operation = factory.createOperation();
		
		Operation getter = factory.createOperation();
		
		Parameter paramReturn = factory.createParameter();
		
		paramReturn.setType(property.getType());
		paramReturn.setLower(property.getLower());
		paramReturn.setUpper(property.getUpper());
		paramReturn.setDirection(ParameterDirectionKind.RETURN_LITERAL);
		
		getter.getOwnedParameters().add(paramReturn);
		getter.setVisibility(VisibilityKind.PUBLIC_LITERAL);
		getter.setName("get" + property.getName());
		
		return operation;
	}
	
	public static void remountMethod(String className, String superClassName, String methodName)
	{
		Operation operation = null;
		
		Package myPackage = null;
		
		Class myClass = null;
		
		Model model1 = chargerModele("model/model.uml");
		
		for (NamedElement namedElement : model1.getMembers())
			if (namedElement instanceof Package && namedElement.getName().equals("mypackage"))
				myPackage = (Package) namedElement;
			else if (namedElement instanceof Class && namedElement.getName().equals("Class1"))
				myClass = (Class) namedElement;
		
	}
	
	public static void remountMethodAux(String className, String superClassName, Operation operation)
	{
		if(className.equals(superClassName))
		{
			
		}
	}
	
	public static void moveClass(Class classToMove, Package destinationPackage) {
		destinationPackage.getPackagedElements().add(classToMove);
	}	
	
	public Class findClassInPackage(String className, Package p)
	{
		Class c =  null;
		for(PackageableElement pd: p.getPackagedElements())
			if(pd instanceof Class)
			{
				Class pdc = (Class) pd;
				if(pdc.getName().equals(className))
					return pdc;
			}
			else if(pd instanceof Package)
			{
				Package pdp = (Package) pd;
				c = findClassInPackage(className, pdp);
				
				if(c != null)
					return c;
			}
		
		return c;
	}

	public static void sauverModele(String uri, EObject root) {
		Resource resource = null;
		try {
			URI uriUri = URI.createURI(uri);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
			resource = (new ResourceSetImpl()).createResource(uriUri);
			resource.getContents().add(root);
			resource.save(null);
		} catch (Exception e) {
			System.err.println("ERREUR sauvegarde du modèle : " + e);
			e.printStackTrace();
		}
	}

	public static Model chargerModele(String uri) {
		Resource resource = null;
		EPackage pack = UMLPackage.eINSTANCE;
		try {
			URI uriUri = URI.createURI(uri);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("uml", new XMIResourceFactoryImpl());
			resource = (new ResourceSetImpl()).createResource(uriUri);
			XMLResource.XMLMap xmlMap = new XMLMapImpl();
			xmlMap.setNoNamespacePackage(pack);
			java.util.Map options = new java.util.HashMap();
			options.put(XMLResource.OPTION_XML_MAP, xmlMap);
			resource.load(options);
		} catch (Exception e) {
			System.err.println("ERREUR chargement du modèle : " + e);
			e.printStackTrace();
		}
		return (Model) resource.getContents().get(0);
	}

}
