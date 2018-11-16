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
 *   <li>{@link tp.metaprogramming.memo.World#getPopulation <em>Population</em>}</li>
 *   <li>{@link tp.metaprogramming.memo.World#getAutomobile <em>Automobile</em>}</li>
 * </ul>
 *
 * @see tp.metaprogramming.memo.MemoPackage#getWorld()
 * @model
 * @generated
 */
public interface World extends MemoObject {
	/**
	 * Returns the value of the '<em><b>Population</b></em>' containment reference list.
	 * The list contents are of type {@link tp.metaprogramming.memo.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Population</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Population</em>' containment reference list.
	 * @see tp.metaprogramming.memo.MemoPackage#getWorld_Population()
	 * @model containment="true"
	 * @generated
	 */
	EList<Person> getPopulation();

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

} // World
