/**
 */
package tp.metaprog2.world.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EMemoClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.EMemoClassImpl;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import tp.metaprog2.world.WorldFactory;
import tp.metaprog2.world.WorldPackage;
import tp.metaprog2.world.person;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorldPackageImpl extends EPackageImpl implements WorldPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EMemoClass personEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see tp.metaprog2.world.WorldPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WorldPackageImpl() {
		super(eNS_URI, WorldFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link WorldPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WorldPackage init() {
		if (isInited)
			return (WorldPackage) EPackage.Registry.INSTANCE.getEPackage(WorldPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredWorldPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		WorldPackageImpl theWorldPackage = registeredWorldPackage instanceof WorldPackageImpl
				? (WorldPackageImpl) registeredWorldPackage
				: new WorldPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theWorldPackage.createPackageContents();

		// Initialize created meta-data
		theWorldPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWorldPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(WorldPackage.eNS_URI, theWorldPackage);
		return theWorldPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMemoClass getperson() {
		return personEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getperson_Name() {
		return (EAttribute) personEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorldFactory getWorldFactory() {
		return (WorldFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		personEClass = EcoreFactory.eINSTANCE.createEMemoClass();

		((EMemoClassImpl) personEClass).setClassifierID(PERSON);
		getEClassifiers().add(personEClass);
		
		//personEClass = createEMemoClass(PERSON);
		createEAttribute(personEClass, PERSON__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(personEClass, person.class, "person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getperson_Name(), ecorePackage.getEString(), "name", null, 0, 1, person.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //WorldPackageImpl
