# ApplicationTemoin

le dossier lib/ contient:
  client.jar
  serveur.jar
 
 
Pour ajouter les .jar dans eclipse n'oubliez pas le "add to build path"

les classe sonts dans src/ divisé en 3 packages
  model        (contenant tous les services qu'on propose)
  view         (contenant java fx)
  controler
  
l'utilisation prévu est la suivante:
  
  l'utilisateur se connecte depuis le client
  
  les vues du package view s'affichent
  
  lors d'une interacation de l'utilisateur exemple (clique sur le bouton voir requête d'amis)
  l'information et transmise au controler qui va se charger d'apppeler les bonnes commende du model
  puis le model traite l'action en cours et fait appel a une fonction de view qui met à jour la vue.
 

