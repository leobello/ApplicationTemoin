# ApplicationTemoin

le dossier lib/ contient:
  client.jar
  serveur.jar
 
 
Pour ajouter les .jar dans eclipse n'oubliez pas le "add to build path"

Les classe sonts dans src/ divisé en 3 packages
  model        (contenant tous les services qu'on propose)
  view         (contenant java fx)
  controller
  
L'utilisation prévu est la suivante:
  
  L'utilisateur se connecte depuis le client.
  
  Les vues du package view s'affichent.
  
  Lors d'une interacation de l'utilisateur exemple (clique sur le bouton voir requête d'amis)
  l'information ou les sonts est transmise au controller qui va se charger de les traiter si besoin et 
  d'apppeler les bonnes fonctions du  package model.
  Le model traite ensuite l'action en cours et fait appel à une fonction de view qui met à jour la vue.
 

