Launcher
|___LawnMowerApp
	|___LawnMower[]
	    |___Position
	        |___Direction
	        |___Lawn
      
LawnMowerInput
|___Lawn
|___LawnMowerProgramming[]
    |___Position
    |___MowerInstruction[]

Lawn : Pelouse avec des coordonnées max x et y qui correspondent à ce qui est
lu dans le fichier.

Position : Position sur la pelouse.  Permet de représenter les coordonnées x
et y, la direction, et de gérer les déplacements (pivoter, avancer) à l'intérieur
de la pelouse.  

LawnMower : Tondeuse.  La tondeuse connait sa position et peut exécuter une 
liste d'instructions à partir d'une position initiale.

LawnMowerException : Erreur d'exécution, par exemple une instruction inconnue.

LawnMowerProgramming : Programmation d'une tondeuse.  C'est une liste d'instructions
à partir d'une position initiale.

LawnMowerInput : Données d'entrée.  Correspond au fichier d'entrée, permet
de lire les paramètres de la pelouse et la programmation de chaque tondeuse.

MowerInstruction : Instruction de déplacement (G, D, A).

Launcher : Classe de lancement.  Prend en argument un nom de fichier d'entree 
et affiche la position finale des tondeuses.  En l'absence d'un nom de fichier, 
lire sur l'entree standard.

LawnMowerApp : Application de gestion des tondeuses sur la pelouse.

