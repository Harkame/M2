/**
 */
package tp.metaprog2.world;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tp.metaprog2.world.WorldPackage
 * @generated
 */
public interface WorldFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorldFactory eINSTANCE = tp.metaprog2.world.impl.WorldFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>person</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>person</em>'.
	 * @generated
	 */
	person createperson();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WorldPackage getWorldPackage();

} //WorldFactory
