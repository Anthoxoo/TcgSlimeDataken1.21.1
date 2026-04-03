# Item binder avec 6 slots, faire en sorte que : on ne puisse mettre que des "CardItem" dedans, mettre 6 slots et augmenter la taille des cases.

## Voir implémentation API Curios pour stocker binder.

### Faire fonction qui va donner les effets au joueur en bouclant sur les items contenus dans
### le binder du joueur.

#### Faire assets

#### Faire ouverture booster

#### Mettre bonus si jamais x cartes dans le binder sont de la "meme famille"

##### Mettre les sounds

##### Mettre dans config la possibilité pour le joueur de modifier les probas de loot des cartes donc les mettre en Static final dans le config et les reprendre directement dans le Service/CardStats



# FAITS

~~Créer un objet carte qui va recevoir des attributs grace a une méthode give_effects~~
~~fonction random_tier qui va utiliser un randomizer entre 0 et 1 et en fonction du nb tiré choisir le tier (a discuter des valeurs) et qui va renvoyer un enum tier~~
~~Implémenter give_effects qui va prendre en paramètre un enum et qui va utiliser un switch Pour choisir le tier a donner, va renvoyer : (a voir en fonction de curios / implémentation d'effet par joueur...)~~