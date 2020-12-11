## Cahier des charges test unitaires `

Getall: Je veux vérifier qu'il y a toutes les voitures initial dans la BDD -> je fais donc une requette GET sur /cars -> je vérigie que la réponse me renvoie bien les 3 voitures initialisé au format JSON 

GetOne: Je veux vérifier que je peux récupérer une voiture par id -> je fais une requète GET sur /cars/1 -> je vérifie que réponse me renvoie bien la voiture avec l'id un au format JSON

Post: Je veux vérifier que je peux ajouter une voitures -> je fais une requete POST sur /cars avec ma voiture au format JSON {"id:4, "brand":"Audi", "modele":"A4"} -> je vérifie avec le Getbyid /cars/4 que la voiture est bien créé

Put: Je veux vérifier que je peux modifier une voiture -> je fais une requete PUT sur /cars/4 avec mes modification au format JSON {"id:4, "brand":"Audi", "modele":"A3"} -> je vérifie avec le Getbyid /cars/4 que la voiture est bien modifié

Delete: Je veux vérifier que je peux supprimer une voiture -> je fais une requete DELETE sur /cars/4 -> je vérifie avec le GetAll /cars que la voiture supprimé n'est pas dans la liste