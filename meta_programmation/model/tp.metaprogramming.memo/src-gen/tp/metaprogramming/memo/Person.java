/**
 */
package tp.metaprogramming.memo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tp.metaprogramming.memo.Person#getAge <em>Age</em>}</li>
 *   <li>{@link tp.metaprogramming.memo.Person#getAutomobile <em>Automobile</em>}</li>
 * </ul>
 *
 * @see tp.metaprogramming.memo.MemoPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Age</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age</em>' attribute.
	 * @see #setAge(int)
	 * @see tp.metaprogramming.memo.MemoPackage#getPerson_Age()
	 * @model
	 * @generated
	 */
	int getAge();

	/**
	 * Sets the value of the '{@link tp.metaprogramming.memo.Person#getAge <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Age</em>' attribute.
	 * @see #getAge()
	 * @generated
	 */
	void setAge(int value);

	/**
	 * Returns the value of the '<em><b>Automobile</b></em>' reference list.
	 * The list contents are of type {@link tp.metaprogramming.memo.Automobile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Automobile</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Automobile</em>' reference list.
	 * @see tp.metaprogramming.memo.MemoPackage#getPerson_Automobile()
	 * @model
	 * @generated
	 */
	EList<Automobile> getAutomobile();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void birthday();

} // Person
