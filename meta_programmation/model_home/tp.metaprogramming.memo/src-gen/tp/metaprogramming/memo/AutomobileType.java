/**
 */
package tp.metaprogramming.memo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Automobile Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see tp.metaprogramming.memo.MemoPackage#getAutomobileType()
 * @model
 * @generated
 */
public enum AutomobileType implements Enumerator {
	/**
	 * The '<em><b>BMW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BMW_VALUE
	 * @generated
	 * @ordered
	 */
	BMW(0, "BMW", "BMW"),

	/**
	 * The '<em><b>Mercedes</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MERCEDES_VALUE
	 * @generated
	 * @ordered
	 */
	MERCEDES(1, "Mercedes", "Mercedes"),

	/**
	 * The '<em><b>Audi</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUDI_VALUE
	 * @generated
	 * @ordered
	 */
	AUDI(2, "Audi", "Audi"),

	/**
	 * The '<em><b>Citroen</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CITROEN_VALUE
	 * @generated
	 * @ordered
	 */
	CITROEN(3, "Citroen", "Citroen"),

	/**
	 * The '<em><b>Renault</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RENAULT_VALUE
	 * @generated
	 * @ordered
	 */
	RENAULT(4, "Renault", "Renault");

	/**
	 * The '<em><b>BMW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BMW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BMW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BMW_VALUE = 0;

	/**
	 * The '<em><b>Mercedes</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mercedes</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MERCEDES
	 * @model name="Mercedes"
	 * @generated
	 * @ordered
	 */
	public static final int MERCEDES_VALUE = 1;

	/**
	 * The '<em><b>Audi</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Audi</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AUDI
	 * @model name="Audi"
	 * @generated
	 * @ordered
	 */
	public static final int AUDI_VALUE = 2;

	/**
	 * The '<em><b>Citroen</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Citroen</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CITROEN
	 * @model name="Citroen"
	 * @generated
	 * @ordered
	 */
	public static final int CITROEN_VALUE = 3;

	/**
	 * The '<em><b>Renault</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Renault</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RENAULT
	 * @model name="Renault"
	 * @generated
	 * @ordered
	 */
	public static final int RENAULT_VALUE = 4;

	/**
	 * An array of all the '<em><b>Automobile Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AutomobileType[] VALUES_ARRAY = new AutomobileType[] { BMW, MERCEDES, AUDI, CITROEN,
			RENAULT, };

	/**
	 * A public read-only list of all the '<em><b>Automobile Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AutomobileType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Automobile Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AutomobileType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AutomobileType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Automobile Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AutomobileType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AutomobileType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Automobile Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AutomobileType get(int value) {
		switch (value) {
		case BMW_VALUE:
			return BMW;
		case MERCEDES_VALUE:
			return MERCEDES;
		case AUDI_VALUE:
			return AUDI;
		case CITROEN_VALUE:
			return CITROEN;
		case RENAULT_VALUE:
			return RENAULT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private AutomobileType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //AutomobileType
