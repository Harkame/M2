package umlutils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;
import org.eclipse.uml2.uml.CallEvent;
//import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.internal.impl.FinalStateImpl;
import org.eclipse.uml2.uml.internal.impl.PseudostateImpl;
import org.eclipse.uml2.uml.internal.impl.RegionImpl;
import org.eclipse.uml2.uml.internal.impl.StateImpl;

public class TPState {
	private static UMLFactory factory = UMLFactory.eINSTANCE;
	
	public static Model loadModel(String uri) {
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
	
	public static Collection<StateMachine> getStateMachines(Class c)
	{
		Collection<StateMachine> stateMachines = new ArrayList<StateMachine>();
	
		for(Element element : c.getOwnedBehaviors())
			if(element instanceof StateMachine)
				stateMachines.add((StateMachine) element);
			
		return stateMachines;
	}
	
	public static boolean checkSingleRegion(StateMachine stateMachineToCheck)
	{	
		return stateMachineToCheck.getRegions().size() == 1;
	}
	
	public static Collection<Vertex> getStates(StateMachine stateMachine)
	{	
		Collection<Vertex> states = new ArrayList<Vertex>();
		
		Region region = stateMachine.getRegions().get(0);
		
		//System.out.println(region.toString());
		
		for(Element element : region.getOwnedElements())
			if(element instanceof Vertex)
				states.add((Vertex) element);
		
		return states;
	}
	
	//Ecrivez une m´ethode prenant en param`etre une machine `a ´etat bien form´ee pour
	//notre exercice, et qui retourne la liste des op´erations se trouvant comme trigger dans la machine
	//`a ´etat.
	
	public static Collection<Operation> getTriggerOperations(StateMachine stateMachine)
	{
		Collection<Operation> triggerOperations = new ArrayList<Operation>();
		
		Region region = stateMachine.getRegions().get(0);
		
		for (Transition transition : region.getTransitions())
			for(Trigger trigger : transition.getTriggers())
			{
				Event event = trigger.getEvent();
				
				if(event instanceof CallEvent)
					triggerOperations.add(((CallEvent) event).getOperation());
			}
		
		return triggerOperations;
	}
	
	public static void applyStatePattern(Class classToApplyStatePatternTo)
	{
		Collection<StateMachine> stateMachines = getStateMachines(classToApplyStatePatternTo);
		
		//System.out.print(stateMachines.toString());	
		
		for(StateMachine stateMachine : stateMachines)
		{
			//System.out.println(checkSingleRegion(stateMachine));
			
			Collection<Vertex> states = getStates(stateMachine);
			
			Class generateSuperClass = factory.createClass();
			generateSuperClass.setName(classToApplyStatePatternTo.getName() + "State");
			
			for(Vertex state : states)
			{
				Class generatedClass = factory.createClass();
				generatedClass.setName(state.getName() + "State");
				generatedClass.createGeneralization(generateSuperClass);
				
				System.out.print(generatedClass.getSuperClasses());
			}
			
			classToApplyStatePatternTo.createOwnedAttribute("currentState", generateSuperClass);

			//System.out.println(states.toString());
			
			Collection<Operation> triggerOperations = getTriggerOperations(stateMachine);
			
			for(Operation triggerOperation : triggerOperations)
			{
				Constraint constraint = factory.createConstraint();
				//constraint.set
				//triggerOperation.body
			}
			
			//System.out.println(triggerOperations);
		}
	}

	public static void main(String[] args) {
		Model model = loadModel("../TP_State/TP_State.uml");
		
		Class searchedClass = null;
		
		for (NamedElement namedElement : model.getMembers())
			if (namedElement instanceof Class && namedElement.getName().equals("Chicken"))
				searchedClass = (Class) namedElement;
		
		applyStatePattern(searchedClass);
		
		/*
		Collection<StateMachine> stateMachines = getStateMachines("Chicken", model);
		
		//System.out.print(stateMachines.toString());	
		
		for(StateMachine stateMachine : stateMachines)
		{
			//System.out.println(checkSingleRegion(stateMachine));
			
			Collection<Vertex> states = getStates(stateMachine);

			//System.out.println(states.toString());
			
			Collection<Operation> triggerOperations = getTriggerOperations(stateMachine);
			
			//System.out.println(triggerOperations);
		}
		*/
		
		
	}
}
