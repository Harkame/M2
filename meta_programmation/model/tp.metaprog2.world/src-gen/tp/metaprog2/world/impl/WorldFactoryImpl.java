/**
 */
package tp.metaprog2.world.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EMemoClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tp.metaprog2.world.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorldFactoryImpl extends EFactoryImpl implements WorldFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WorldFactory init() {
		try {
			WorldFactory theWorldFactory = (WorldFactory) EPackage.Registry.INSTANCE.getEFactory(WorldPackage.eNS_URI);
			if (theWorldFactory != null) {
				return theWorldFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WorldFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorldFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case WorldPackage.PERSON:
			return createperson();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public person createperson() {
		personImpl person = new personImpl();
		
		EMemoClass eMemoClass = (EMemoClass) person.eClass();
		eMemoClass.getInstances().add(person);
		
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorldPackage getWorldPackage() {
		return (WorldPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static WorldPackage getPackage() {
		return WorldPackage.eINSTANCE;
	}

} //WorldFactoryImpl
