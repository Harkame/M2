/**
 */
package org.eclipse.emf.ecore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMemo Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecore.EMemoClass#getInstances <em>Instances</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecore.EcorePackage#getEMemoClass()
 * @model
 * @generated
 */
public interface EMemoClass extends EClass {
	/**
	 * Returns the value of the '<em><b>Instances</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' attribute list.
	 * @see org.eclipse.emf.ecore.EcorePackage#getEMemoClass_Instances()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Object> getInstances();

} // EMemoClass
