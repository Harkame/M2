/**
 */
package tp.metaprogramming.memo;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Automobile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tp.metaprogramming.memo.Automobile#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see tp.metaprogramming.memo.MemoPackage#getAutomobile()
 * @model
 * @generated
 */
public interface Automobile extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link tp.metaprogramming.memo.AutomobileType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see tp.metaprogramming.memo.AutomobileType
	 * @see #setType(AutomobileType)
	 * @see tp.metaprogramming.memo.MemoPackage#getAutomobile_Type()
	 * @model
	 * @generated
	 */
	AutomobileType getType();

	/**
	 * Sets the value of the '{@link tp.metaprogramming.memo.Automobile#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see tp.metaprogramming.memo.AutomobileType
	 * @see #getType()
	 * @generated
	 */
	void setType(AutomobileType value);

} // Automobile
