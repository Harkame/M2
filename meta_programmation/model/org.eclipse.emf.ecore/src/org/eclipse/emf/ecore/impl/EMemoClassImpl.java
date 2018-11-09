/**
 */
package org.eclipse.emf.ecore.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EMemoClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMemo Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecore.impl.EMemoClassImpl#getInstances <em>Instances</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EMemoClassImpl extends EClassImpl implements EMemoClass {
	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated NOT
	 * @ordered
	 */
	protected EList<Object> instances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMemoClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcorePackage.Literals.EMEMO_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getInstances() {
		if (instances == null) {
			instances = new EDataTypeUniqueEList<Object>(Object.class, this, EcorePackage.EMEMO_CLASS__INSTANCES);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcorePackage.EMEMO_CLASS__EANNOTATIONS:
				return getEAnnotations();
			case EcorePackage.EMEMO_CLASS__NAME:
				return getName();
			case EcorePackage.EMEMO_CLASS__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case EcorePackage.EMEMO_CLASS__INSTANCE_CLASS:
				return getInstanceClass();
			case EcorePackage.EMEMO_CLASS__DEFAULT_VALUE:
				return getDefaultValue();
			case EcorePackage.EMEMO_CLASS__INSTANCE_TYPE_NAME:
				return getInstanceTypeName();
			case EcorePackage.EMEMO_CLASS__EPACKAGE:
				if (resolve) return getEPackage();
				return basicGetEPackage();
			case EcorePackage.EMEMO_CLASS__ETYPE_PARAMETERS:
				return getETypeParameters();
			case EcorePackage.EMEMO_CLASS__ABSTRACT:
				return isAbstract();
			case EcorePackage.EMEMO_CLASS__INTERFACE:
				return isInterface();
			case EcorePackage.EMEMO_CLASS__ESUPER_TYPES:
				return getESuperTypes();
			case EcorePackage.EMEMO_CLASS__EOPERATIONS:
				return getEOperations();
			case EcorePackage.EMEMO_CLASS__EALL_ATTRIBUTES:
				return getEAllAttributes();
			case EcorePackage.EMEMO_CLASS__EALL_REFERENCES:
				return getEAllReferences();
			case EcorePackage.EMEMO_CLASS__EREFERENCES:
				return getEReferences();
			case EcorePackage.EMEMO_CLASS__EATTRIBUTES:
				return getEAttributes();
			case EcorePackage.EMEMO_CLASS__EALL_CONTAINMENTS:
				return getEAllContainments();
			case EcorePackage.EMEMO_CLASS__EALL_OPERATIONS:
				return getEAllOperations();
			case EcorePackage.EMEMO_CLASS__EALL_STRUCTURAL_FEATURES:
				return getEAllStructuralFeatures();
			case EcorePackage.EMEMO_CLASS__EALL_SUPER_TYPES:
				return getEAllSuperTypes();
			case EcorePackage.EMEMO_CLASS__EID_ATTRIBUTE:
				return getEIDAttribute();
			case EcorePackage.EMEMO_CLASS__ESTRUCTURAL_FEATURES:
				return getEStructuralFeatures();
			case EcorePackage.EMEMO_CLASS__EGENERIC_SUPER_TYPES:
				return getEGenericSuperTypes();
			case EcorePackage.EMEMO_CLASS__EALL_GENERIC_SUPER_TYPES:
				return getEAllGenericSuperTypes();
			case EcorePackage.EMEMO_CLASS__INSTANCES:
				return getInstances();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EcorePackage.EMEMO_CLASS__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection<? extends EAnnotation>)newValue);
				return;
			case EcorePackage.EMEMO_CLASS__NAME:
				setName((String)newValue);
				return;
			case EcorePackage.EMEMO_CLASS__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case EcorePackage.EMEMO_CLASS__INSTANCE_TYPE_NAME:
				setInstanceTypeName((String)newValue);
				return;
			case EcorePackage.EMEMO_CLASS__ETYPE_PARAMETERS:
				getETypeParameters().clear();
				getETypeParameters().addAll((Collection<? extends ETypeParameter>)newValue);
				return;
			case EcorePackage.EMEMO_CLASS__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case EcorePackage.EMEMO_CLASS__INTERFACE:
				setInterface((Boolean)newValue);
				return;
			case EcorePackage.EMEMO_CLASS__ESUPER_TYPES:
				getESuperTypes().clear();
				getESuperTypes().addAll((Collection<? extends EClass>)newValue);
				return;
			case EcorePackage.EMEMO_CLASS__EOPERATIONS:
				getEOperations().clear();
				getEOperations().addAll((Collection<? extends EOperation>)newValue);
				return;
			case EcorePackage.EMEMO_CLASS__ESTRUCTURAL_FEATURES:
				getEStructuralFeatures().clear();
				getEStructuralFeatures().addAll((Collection<? extends EStructuralFeature>)newValue);
				return;
			case EcorePackage.EMEMO_CLASS__EGENERIC_SUPER_TYPES:
				getEGenericSuperTypes().clear();
				getEGenericSuperTypes().addAll((Collection<? extends EGenericType>)newValue);
				return;
			case EcorePackage.EMEMO_CLASS__INSTANCES:
				getInstances().clear();
				getInstances().addAll((Collection<? extends Object>)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EcorePackage.EMEMO_CLASS__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case EcorePackage.EMEMO_CLASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EcorePackage.EMEMO_CLASS__INSTANCE_CLASS_NAME:
				unsetInstanceClassName();
				return;
			case EcorePackage.EMEMO_CLASS__INSTANCE_TYPE_NAME:
				unsetInstanceTypeName();
				return;
			case EcorePackage.EMEMO_CLASS__ETYPE_PARAMETERS:
				getETypeParameters().clear();
				return;
			case EcorePackage.EMEMO_CLASS__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case EcorePackage.EMEMO_CLASS__INTERFACE:
				setInterface(INTERFACE_EDEFAULT);
				return;
			case EcorePackage.EMEMO_CLASS__ESUPER_TYPES:
				unsetESuperTypes();
				return;
			case EcorePackage.EMEMO_CLASS__EOPERATIONS:
				getEOperations().clear();
				return;
			case EcorePackage.EMEMO_CLASS__ESTRUCTURAL_FEATURES:
				getEStructuralFeatures().clear();
				return;
			case EcorePackage.EMEMO_CLASS__EGENERIC_SUPER_TYPES:
				unsetEGenericSuperTypes();
				return;
			case EcorePackage.EMEMO_CLASS__INSTANCES:
				getInstances().clear();
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EcorePackage.EMEMO_CLASS__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case EcorePackage.EMEMO_CLASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EcorePackage.EMEMO_CLASS__INSTANCE_CLASS_NAME:
				return isSetInstanceClassName();
			case EcorePackage.EMEMO_CLASS__INSTANCE_CLASS:
				return getInstanceClass() != null;
			case EcorePackage.EMEMO_CLASS__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? getDefaultValue() != null : !DEFAULT_VALUE_EDEFAULT.equals(getDefaultValue());
			case EcorePackage.EMEMO_CLASS__INSTANCE_TYPE_NAME:
				return isSetInstanceTypeName();
			case EcorePackage.EMEMO_CLASS__EPACKAGE:
				return basicGetEPackage() != null;
			case EcorePackage.EMEMO_CLASS__ETYPE_PARAMETERS:
				return eTypeParameters != null && !eTypeParameters.isEmpty();
			case EcorePackage.EMEMO_CLASS__ABSTRACT:
				return ((eFlags & ABSTRACT_EFLAG) != 0) != ABSTRACT_EDEFAULT;
			case EcorePackage.EMEMO_CLASS__INTERFACE:
				return ((eFlags & INTERFACE_EFLAG) != 0) != INTERFACE_EDEFAULT;
			case EcorePackage.EMEMO_CLASS__ESUPER_TYPES:
				return isSetESuperTypes();
			case EcorePackage.EMEMO_CLASS__EOPERATIONS:
				return eOperations != null && !eOperations.isEmpty();
			case EcorePackage.EMEMO_CLASS__EALL_ATTRIBUTES:
				return !getEAllAttributes().isEmpty();
			case EcorePackage.EMEMO_CLASS__EALL_REFERENCES:
				return !getEAllReferences().isEmpty();
			case EcorePackage.EMEMO_CLASS__EREFERENCES:
				return !getEReferences().isEmpty();
			case EcorePackage.EMEMO_CLASS__EATTRIBUTES:
				return !getEAttributes().isEmpty();
			case EcorePackage.EMEMO_CLASS__EALL_CONTAINMENTS:
				return !getEAllContainments().isEmpty();
			case EcorePackage.EMEMO_CLASS__EALL_OPERATIONS:
				return !getEAllOperations().isEmpty();
			case EcorePackage.EMEMO_CLASS__EALL_STRUCTURAL_FEATURES:
				return !getEAllStructuralFeatures().isEmpty();
			case EcorePackage.EMEMO_CLASS__EALL_SUPER_TYPES:
				return !getEAllSuperTypes().isEmpty();
			case EcorePackage.EMEMO_CLASS__EID_ATTRIBUTE:
				return getEIDAttribute() != null;
			case EcorePackage.EMEMO_CLASS__ESTRUCTURAL_FEATURES:
				return eStructuralFeatures != null && !eStructuralFeatures.isEmpty();
			case EcorePackage.EMEMO_CLASS__EGENERIC_SUPER_TYPES:
				return isSetEGenericSuperTypes();
			case EcorePackage.EMEMO_CLASS__EALL_GENERIC_SUPER_TYPES:
				return !getEAllGenericSuperTypes().isEmpty();
			case EcorePackage.EMEMO_CLASS__INSTANCES:
				return instances != null && !instances.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (instances: ");
		result.append(instances);
		result.append(')');
		return result.toString();
	}

} //EMemoClassImpl
