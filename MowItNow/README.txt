LawnMower
	position
	lawn
	move(Instruction)
	execute(LawnMowerProgramming)

Position
	x
	y
	direction

Direction
	N
	E
	W
	S

Lawn
	sizeX
	sizeY

Instruction
	D
	G
	A
	
LawnMowerInstructions
	lawnMowerProgramming[]
	LawnMowerInstructions(String)
	getLawnMowerProgrammingList()
	getLawn()
>> Charge le fichier d'instructions de la tondeuse. 
>> Permet de récupérer la programmation de chaque tondeuse.
>> Permet d'instancier la pelouse
	
LawnMowerProgramming
	initialPosition
	instructions
	
App
	main()