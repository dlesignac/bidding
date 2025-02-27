# Bidding

## Besoin métier
Le besoin métier consiste à exposer une API HTTP permettant de créer et rechercher des offres sur des marchés d'énergie.
Afin de faciliter son déploiement, des outils sont fournis pour lancer tous les composants nécessaires en local.

### Vocabulaire

#### Market
Le point d'entrée du besoin exprimé est le Marché, ou `Market`. Les seuls attributs précisés sont les règles de
validation des offres placées sur un marché, qu'on a choisi de ne pas matérialiser ici pour simplifier. On n'aura donc
besoin que d'un type `MarketId` pour décrire sur quel marché les offres sont placées.

#### Bid, BidBlock, Supply
Une offre, ou `Bid`, est un aggrégat qui n'est cohérent que si l'ensemble de ses sous-ressources, les `BidBlock`s, est
complet et cohérent. A l'inverse, un `BidBlock` n'est cohérent qu'en étant lié à un `Bid`. En conséquence, le `Bid` et
ses `BidBlock`s ont le même cycle de vie.

Un `BidBlock` représente l'association entre une période temps, une quantité d'énergie fournie, et un prix.

Pour répondre au besoin de traçabilité, la quantité d'énergie fournie pour un `BidBlock` est modélisée sous la forme
d'un ensemble de fournitures, ou `Supply`(ie)s, qui définissent quel parc producteur fournit quelle quantité de
l'énergie totale du `BidBlock`. Ces fournitures sont intrinsèquement liées à leur `BidBlock` et ont donc également le
même cycle de vie.

#### Supplier
Bien que le besoin exprime la notion de parc producteur d'énergie avec des types différents, ces notions ne semblent pas
(dans le cadre de l'exercice) avoir d'utilité particulière. En conséquence, on a réduit la notion de parc à un simple
identifiant de fournisseur, ou `SupplierId`, sans cycle de vie propre.

## Stack locale

### Prérequis
* JDK 21+
* Apache Maven 3.9+
* Docker 27.5+

### Lancement
Dans le dossier `local-stack`:

1. lancer le build des sources et des images Docker
```
./build.sh
```

2. lancer la stack Docker
```
docker compose up
```

L'API HTTP est alors disponible à l'adresse `http://localhost:8080/bidding`

## API HTTP
Voir [ici](doc/api_http.md).

## Architecture
Voir [ici](doc/architecture.md).

## Limites et améliorations

### Limites métier

#### Règles de marché
L'implémentation actuelle ne tient pas compte des règles définies pour un marché:
* durée totale du `Bid` de 24 heures
* contiguité des `BidBlocks`, durée de 3 heures
* ...

#### Pagination des données liées au temps
Les endpoints de récupération de `Bid`s et de `Supplier`s pour un marché retournent actuellement la totalité de
l'historique sauvegardé, ce qui pourrait poser à terme un problème de performance (et de limite de taille d'une réponse
HTTP). En pratique, ces endpoints devraient fournir des paramètres pour préciser une fenêtre de recherche et un système
de pagination pour limiter la quantité d'éléments dans la réponse.

#### Modifications
Le besoin n'exprimant pas la nécessité de pouvoir modifier ou écraser une offre a posteriori, rien n'est implémenté à
ce sujet.

### Limites techniques

#### Intégration et déploiement
Compte tenu de son statut d'exercice, ce projet ne fournit pas de CI et de CD.
