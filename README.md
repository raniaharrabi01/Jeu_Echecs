Jeu d'Échecs
Ce projet représente un jeu d'échecs interactif développé en Java, avec une architecture modulaire utilisant trois design patterns essentiels pour garantir la flexibilité,
la maintenabilité et la possibilité d'étendre facilement le projet.

Fonctionnalités principales :
Plateau de jeu :
Affichage du plateau avec la disposition initiale des pièces.
Suivi des mouvements et des mises à jour en temps réel après chaque coup.
Pièces d'échecs :
Chaque type de pièce suit ses règles de déplacement spécifiques, tout en étant géré par des classes dédiées.
Gestion des joueurs et des règles :
Le jeu permet l'alternance des tours entre les joueurs et vérifie les conditions de victoire, d'échec ou d'échec et mat.

Design patterns utilisés :
Strategy Pattern :
Utilisé pour gérer les différents comportements des pièces. Chaque pièce (roi, reine, fou, etc.) a une stratégie de déplacement spécifique. Le Strategy Pattern permet de changer dynamiquement la manière dont une pièce se déplace sans modifier son code, mais en remplaçant la stratégie de déplacement associée à la pièce.
Singleton Pattern :
Appliqué pour la gestion de la partie et du plateau de jeu. Il garantit qu'il n'y a qu'une seule instance du plateau et de la partie pendant toute la durée du jeu, ce qui simplifie le suivi des états du jeu et évite la création d'instances redondantes.
Observer Pattern :
Utilisé pour observer et notifier les changements sur le plateau de jeu et dans le jeu. Chaque pièce (et d'autres composants du jeu) peut être un observateur du plateau de jeu, réagissant aux mouvements ou aux changements d’état, permettant ainsi de maintenir une interface utilisateur à jour en temps réel sans créer de dépendances fortes entre les objets.

![image](https://github.com/user-attachments/assets/148b6bfc-1ea9-4537-9ddd-921b1f0c1a47)
