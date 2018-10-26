/**
 */
package tp.metaprogramming.memo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tp.metaprogramming.memo.MemoClass#getInstances <em>Instances</em>}</li>
 * </ul>
 *
 * @see tp.metaprogramming.memo.MemoPackage#getMemoClass()
 * @model abstract="true"
 * @generated
 */
public interface MemoClass extends EObject {
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
	 * @see tp.metaprogramming.memo.MemoPackage#getMemoClass_Instances()
	 * @model derived="true"
	 * @generated
	 */
	EList<Object> getInstances();

} // MemoClass
