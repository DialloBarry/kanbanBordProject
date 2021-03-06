Ce projet est le backend du projet kanbanboard,
Son src composé des packages suivants:
-le package DAO qui est composé des requetes jpql pour interroger la base de données MySQL
-le package domainKanban qui est composé des classes metiers
-le package jaxrsRequest qui est composé des de la couche service REST
-les packages webapp et serviceRest sur le debut du tp2 (Comprendre les mécanismes des ServletWeb)

Pour lancer l'application backend du projet kanbanboard:
Assurer vous que MySQL soit installé et creez y une base de donnée qui s'appelle "mydatabase"
Démarrer le serveur Undertow en lancer le fichier RestServer(comme un programme java classique ) 
qui se trouve dans le package jaxrs sur le port 8060
Demarrer la base de données MySQl et ainsi vous pouvez tester l'API REST dont les urls se trouvent dans les differents fichiers du 
package jaxrsRequest permettant de recuper et poster et de supprimer des infos dans la base de donnée