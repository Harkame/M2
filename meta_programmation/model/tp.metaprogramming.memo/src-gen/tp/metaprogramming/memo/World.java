/**
 */
package tp.metaprogramming.memo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>World</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tp.metaprogramming.memo.World#getAutomobile <em>Automobile</em>}</li>
 *   <li>{@link tp.metaprogramming.memo.World#getPerson <em>Person</em>}</li>
 * </ul>
 *
 * @see tp.metaprogramming.memo.MemoPackage#getWorld()
 * @model
 * @generated
 */
public interface World extends MemoClass {
	/**
	 * Returns the value of the '<em><b>Automobile</b></em>' containment reference list.
	 * The list contents are of type {@link tp.metaprogramming.memo.Automobile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Automobile</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Automobile</em>' containment reference list.
	 * @see tp.metaprogramming.memo.MemoPackage#getWorld_Automobile()
	 * @model containment="true"
	 * @generated
	 */
	EList<Automobile> getAutomobile();

	/**
	 * Returns the value of the '<em><b>Person</b></em>' containment reference list.
	 * The list contents are of type {@link tp.metaprogramming.memo.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Person</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person</em>' containment reference list.
	 * @see tp.metaprogramming.memo.MemoPackage#getWorld_Person()
	 * @model containment="true"
	 * @generated
	 */
	EList<Person> getPerson();

} // World
