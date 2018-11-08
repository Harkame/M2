/**
 */
package tp.metaprogramming.memo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see tp.metaprogramming.memo.MemoFactory
 * @model kind="package"
 * @generated
 */
public interface MemoPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "memo";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/memo";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "memo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MemoPackage eINSTANCE = tp.metaprogramming.memo.impl.MemoPackageImpl.init();

	/**
	 * The meta object id for the '{@link tp.metaprogramming.memo.impl.MemoObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tp.metaprogramming.memo.impl.MemoObjectImpl
	 * @see tp.metaprogramming.memo.impl.MemoPackageImpl#getMemoObject()
	 * @generated
	 */
	int MEMO_OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMO_OBJECT__INSTANCES = 0;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMO_OBJECT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMO_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tp.metaprogramming.memo.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tp.metaprogramming.memo.impl.NamedElementImpl
	 * @see tp.metaprogramming.memo.impl.MemoPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__INSTANCES = MEMO_OBJECT__INSTANCES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = MEMO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = MEMO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = MEMO_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tp.metaprogramming.memo.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tp.metaprogramming.memo.impl.PersonImpl
	 * @see tp.metaprogramming.memo.impl.MemoPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 0;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__INSTANCES = NAMED_ELEMENT__INSTANCES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__AGE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Has</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__HAS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Birthday</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON___BIRTHDAY = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tp.metaprogramming.memo.impl.AutomobileImpl <em>Automobile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tp.metaprogramming.memo.impl.AutomobileImpl
	 * @see tp.metaprogramming.memo.impl.MemoPackageImpl#getAutomobile()
	 * @generated
	 */
	int AUTOMOBILE = 3;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMOBILE__INSTANCES = NAMED_ELEMENT__INSTANCES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMOBILE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMOBILE__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Automobile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMOBILE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Automobile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMOBILE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tp.metaprogramming.memo.impl.WorldImpl <em>World</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tp.metaprogramming.memo.impl.WorldImpl
	 * @see tp.metaprogramming.memo.impl.MemoPackageImpl#getWorld()
	 * @generated
	 */
	int WORLD = 4;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD__INSTANCES = MEMO_OBJECT__INSTANCES;

	/**
	 * The feature id for the '<em><b>Population</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD__POPULATION = MEMO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Automobile</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD__AUTOMOBILE = MEMO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>World</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD_FEATURE_COUNT = MEMO_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>World</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD_OPERATION_COUNT = MEMO_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tp.metaprogramming.memo.AutomobileType <em>Automobile Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tp.metaprogramming.memo.AutomobileType
	 * @see tp.metaprogramming.memo.impl.MemoPackageImpl#getAutomobileType()
	 * @generated
	 */
	int AUTOMOBILE_TYPE = 5;

	/**
	 * Returns the meta object for class '{@link tp.metaprogramming.memo.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see tp.metaprogramming.memo.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link tp.metaprogramming.memo.Person#getAge <em>Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Age</em>'.
	 * @see tp.metaprogramming.memo.Person#getAge()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Age();

	/**
	 * Returns the meta object for the containment reference list '{@link tp.metaprogramming.memo.Person#getHas <em>Has</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Has</em>'.
	 * @see tp.metaprogramming.memo.Person#getHas()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Has();

	/**
	 * Returns the meta object for the '{@link tp.metaprogramming.memo.Person#birthday() <em>Birthday</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Birthday</em>' operation.
	 * @see tp.metaprogramming.memo.Person#birthday()
	 * @generated
	 */
	EOperation getPerson__Birthday();

	/**
	 * Returns the meta object for class '{@link tp.metaprogramming.memo.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see tp.metaprogramming.memo.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link tp.metaprogramming.memo.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see tp.metaprogramming.memo.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link tp.metaprogramming.memo.MemoObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see tp.metaprogramming.memo.MemoObject
	 * @generated
	 */
	EClass getMemoObject();

	/**
	 * Returns the meta object for the attribute list '{@link tp.metaprogramming.memo.MemoObject#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Instances</em>'.
	 * @see tp.metaprogramming.memo.MemoObject#getInstances()
	 * @see #getMemoObject()
	 * @generated
	 */
	EAttribute getMemoObject_Instances();

	/**
	 * Returns the meta object for class '{@link tp.metaprogramming.memo.Automobile <em>Automobile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Automobile</em>'.
	 * @see tp.metaprogramming.memo.Automobile
	 * @generated
	 */
	EClass getAutomobile();

	/**
	 * Returns the meta object for the attribute '{@link tp.metaprogramming.memo.Automobile#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see tp.metaprogramming.memo.Automobile#getType()
	 * @see #getAutomobile()
	 * @generated
	 */
	EAttribute getAutomobile_Type();

	/**
	 * Returns the meta object for class '{@link tp.metaprogramming.memo.World <em>World</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>World</em>'.
	 * @see tp.metaprogramming.memo.World
	 * @generated
	 */
	EClass getWorld();

	/**
	 * Returns the meta object for the containment reference list '{@link tp.metaprogramming.memo.World#getPopulation <em>Population</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Population</em>'.
	 * @see tp.metaprogramming.memo.World#getPopulation()
	 * @see #getWorld()
	 * @generated
	 */
	EReference getWorld_Population();

	/**
	 * Returns the meta object for the containment reference list '{@link tp.metaprogramming.memo.World#getAutomobile <em>Automobile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Automobile</em>'.
	 * @see tp.metaprogramming.memo.World#getAutomobile()
	 * @see #getWorld()
	 * @generated
	 */
	EReference getWorld_Automobile();

	/**
	 * Returns the meta object for enum '{@link tp.metaprogramming.memo.AutomobileType <em>Automobile Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Automobile Type</em>'.
	 * @see tp.metaprogramming.memo.AutomobileType
	 * @generated
	 */
	EEnum getAutomobileType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MemoFactory getMemoFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link tp.metaprogramming.memo.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tp.metaprogramming.memo.impl.PersonImpl
		 * @see tp.metaprogramming.memo.impl.MemoPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Age</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__AGE = eINSTANCE.getPerson_Age();

		/**
		 * The meta object literal for the '<em><b>Has</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__HAS = eINSTANCE.getPerson_Has();

		/**
		 * The meta object literal for the '<em><b>Birthday</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PERSON___BIRTHDAY = eINSTANCE.getPerson__Birthday();

		/**
		 * The meta object literal for the '{@link tp.metaprogramming.memo.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tp.metaprogramming.memo.impl.NamedElementImpl
		 * @see tp.metaprogramming.memo.impl.MemoPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link tp.metaprogramming.memo.impl.MemoObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tp.metaprogramming.memo.impl.MemoObjectImpl
		 * @see tp.metaprogramming.memo.impl.MemoPackageImpl#getMemoObject()
		 * @generated
		 */
		EClass MEMO_OBJECT = eINSTANCE.getMemoObject();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMO_OBJECT__INSTANCES = eINSTANCE.getMemoObject_Instances();

		/**
		 * The meta object literal for the '{@link tp.metaprogramming.memo.impl.AutomobileImpl <em>Automobile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tp.metaprogramming.memo.impl.AutomobileImpl
		 * @see tp.metaprogramming.memo.impl.MemoPackageImpl#getAutomobile()
		 * @generated
		 */
		EClass AUTOMOBILE = eINSTANCE.getAutomobile();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTOMOBILE__TYPE = eINSTANCE.getAutomobile_Type();

		/**
		 * The meta object literal for the '{@link tp.metaprogramming.memo.impl.WorldImpl <em>World</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tp.metaprogramming.memo.impl.WorldImpl
		 * @see tp.metaprogramming.memo.impl.MemoPackageImpl#getWorld()
		 * @generated
		 */
		EClass WORLD = eINSTANCE.getWorld();

		/**
		 * The meta object literal for the '<em><b>Population</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORLD__POPULATION = eINSTANCE.getWorld_Population();

		/**
		 * The meta object literal for the '<em><b>Automobile</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORLD__AUTOMOBILE = eINSTANCE.getWorld_Automobile();

		/**
		 * The meta object literal for the '{@link tp.metaprogramming.memo.AutomobileType <em>Automobile Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tp.metaprogramming.memo.AutomobileType
		 * @see tp.metaprogramming.memo.impl.MemoPackageImpl#getAutomobileType()
		 * @generated
		 */
		EEnum AUTOMOBILE_TYPE = eINSTANCE.getAutomobileType();

	}

} //MemoPackage
