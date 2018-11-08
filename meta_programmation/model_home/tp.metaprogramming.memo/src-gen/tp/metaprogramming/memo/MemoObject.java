/**
 */
package tp.metaprogramming.memo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tp.metaprogramming.memo.MemoObject#getInstances <em>Instances</em>}</li>
 * </ul>
 *
 * @see tp.metaprogramming.memo.MemoPackage#getMemoObject()
 * @model
 * @generated
 */
public interface MemoObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Instances</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' attribute list.
	 * @see tp.metaprogramming.memo.MemoPackage#getMemoObject_Instances()
	 * @model derived="true"
	 * @generated
	 */
	EList<Object> getInstances();

} // MemoObject
