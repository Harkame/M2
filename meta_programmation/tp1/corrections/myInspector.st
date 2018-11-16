inspect: object
	| attributes result |
	result := ''.
	attributes := object class allInstVarNames.
	attributes do: [ :each | result := result, each, ' ', (object instVarNamed: each) asString, '\'].
	^ result withCRs.

| myObject myInspector |

myObject := MyStack new.
myInspector := MyInspector new.

myInspector inspect: myObject.
