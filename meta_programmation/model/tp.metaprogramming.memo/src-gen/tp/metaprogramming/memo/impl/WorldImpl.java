/**
 */
package tp.metaprogramming.memo.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tp.metaprogramming.memo.Automobile;
import tp.metaprogramming.memo.MemoPackage;
import tp.metaprogramming.memo.Person;
import tp.metaprogramming.memo.World;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>World</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tp.metaprogramming.memo.impl.WorldImpl#getAutomobile <em>Automobile</em>}</li>
 *   <li>{@link tp.metaprogramming.memo.impl.WorldImpl#getPerson <em>Person</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorldImpl extends MemoClassImpl implements World {
	/**
	 * The cached value of the '{@link #getAutomobile() <em>Automobile</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutomobile()
	 * @generated
	 * @ordered
	 */
	protected EList<Automobile> automobile;

	/**
	 * The cached value of the '{@link #getPerson() <em>Person</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerson()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> person;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MemoPackage.Literals.WORLD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Automobile> getAutomobile() {
		if (automobile == null) {
			automobile = new EObjectContainmentEList<Automobile>(Automobile.class, this, MemoPackage.WORLD__AUTOMOBILE);
		}
		return automobile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getPerson() {
		if (person == null) {
			person = new EObjectContainmentEList<Person>(Person.class, this, MemoPackage.WORLD__PERSON);
		}
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MemoPackage.WORLD__AUTOMOBILE:
			return ((InternalEList<?>) getAutomobile()).basicRemove(otherEnd, msgs);
		case MemoPackage.WORLD__PERSON:
			return ((InternalEList<?>) getPerson()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MemoPackage.WORLD__AUTOMOBILE:
			return getAutomobile();
		case MemoPackage.WORLD__PERSON:
			return getPerson();
		}
		return super.eGet(featureID, resolve, coreType);
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
		case MemoPackage.WORLD__AUTOMOBILE:
			getAutomobile().clear();
			getAutomobile().addAll((Collection<? extends Automobile>) newValue);
			return;
		case MemoPackage.WORLD__PERSON:
			getPerson().clear();
			getPerson().addAll((Collection<? extends Person>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case MemoPackage.WORLD__AUTOMOBILE:
			getAutomobile().clear();
			return;
		case MemoPackage.WORLD__PERSON:
			getPerson().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MemoPackage.WORLD__AUTOMOBILE:
			return automobile != null && !automobile.isEmpty();
		case MemoPackage.WORLD__PERSON:
			return person != null && !person.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //WorldImpl
