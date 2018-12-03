| view nodes mooseModel swingModel|

MooseModel resetRoot.
mooseModel := MooseModel importFromMSEStream: '../verveinej/rca.mse' asFileReference readStream.
mooseModel name: 'rca'. 
mooseModel rootFolder: '../rcaexplore'.
mooseModel install.

swingModel := MooseModel new.
CSNSwingImporter new sourceModel: mooseModel; createModelIn: swingModel.
swingModel name: 'RCA'.
swingModel.

view := RTMondrian new.

"nodes := mooseModel allModelClasses 
    select: [:class | class methods size > 25 ]."
"nodes := mooseModel allModelClasses 
    select: [:class | class methods size < 3 ]."
"nodes := mooseModel allMethods  
    select: [:method | method incomingInvocations isEmpty]."
"nodes := mooseModel allMethods 
    collect: [:method | method cyclomaticComplexity ]."

"nodes := mooseModel allMethods select:
[
	:method | method annotationInstances isNotEmpty and:
	[
		method annotationTypes anySatisfy: 
		[
			:type | type name = 'Deprecated'
		]
	]
]."

nodes := mooseModel allPackages.


view nodes: nodes.

view edgesFrom: #parentScope.
view layout tree.
view build.
view view.
