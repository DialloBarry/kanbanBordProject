Ce projet est le backend du projet kanbanboard,
Son src compos� des packages suivants:
-le package DAO qui est compos� des requetes jpql pour interroger la base de donn�es MySQL
-le package domainKanban qui est compos� des classes metiers
-le package jaxrsRequest qui est compos� des de la couche service REST
-les packages webapp et serviceRest sur le debut du tp2 (Comprendre les m�canismes des ServletWeb)

Pour lancer l'application backend du projet kanbanboard:
Assurer vous que MySQL soit install� et creez y une base de donn�e qui s'appelle "mydatabase"
D�marrer le serveur Undertow en lancer le fichier RestServer(comme un programme java classique ) 
qui se trouve dans le package jaxrs sur le port 8060
Demarrer la base de donn�es MySQl et ainsi vous pouvez tester l'API REST dont les urls se trouvent dans les differents fichiers du 
package jaxrsRequest permettant de recuper et poster et de supprimer des infos dans la base de donn�e