# Architecture

## Service
Le service se présente en 2 exécutables:
* un serveur HTTP `bidding-server`
* un job de migration de schéma de base de données `bidding-db-changelog-job`.

### Serveur HTTP (`bidding-server`)

#### Stack technique
L'application s'appuie sur Spring Boot pour exposer son API HTTP
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

et pour requêter sa base de données:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

#### Architecture héxagonale
Afin que le code exprime le plus clairement possible le besoin, et de manière à pouvoir interchanger un composant
technique par un autre en cas de besoin, on utilise ici une architecture héxagonale.

Les notions métier sont regroupées dans un package `domain` et validées de manière à limiter autant que possible leur
création dans un état incohérent. Les détails techniques y sont abstraits via des interfaces (exemple
[ici](../bidding-service/bidding-server/src/main/java/fr/agregio/bidding/server/domain/bid/BidRepository.java)) dont les
implémentations, situées dans le package `infra`, sont fournies par Spring au chargement du contexte.

#### Implémentation JPA d'un repository
Préfixée `Jpa` (exemple
[ici](../bidding-service/bidding-server/src/main/java/fr/agregio/bidding/server/infra/persistence/jpa/bid/JpaBidRepository.java)),
l'implémentation utilise une couche de mapping pour passer d'un objet métier à un objet manipulable par Hibernate,
suffixé `JpaDto` (exemple
[ici](../bidding-service/bidding-server/src/main/java/fr/agregio/bidding/server/infra/persistence/jpa/bid/BidJpaDto.java)).

Pour limiter les interférences d'Hibernate avec le modèle métier, on a volontairement choisi de ne pas utiliser
d'annotation `@OneToMany` et `@ManyToOne`, ce qui a néanmoins un impact sur la performance de lecture.

#### Génération d'IDs en base de données
Afin de rester aussi déterministe que possible au sein des tests, on déclare des `IdGenerator`s (exemple
[ici](../bidding-service/bidding-server/src/main/java/fr/agregio/bidding/server/infra/persistence/jpa/bid/BidIdGenerator.java)).
De cette manière, on peut les remplacer si besoin par des mocks et garder le contrôle sur ce qui généré, facilitant
ainsi les assertions et la gestion des données de test.

Pour le Runtime, on a choisi de fournir comme implémentation une génération aléatoire de UUID, qui ne garantit pas
l'absence de collision, mais qui reste simple et relativement peu risquée.

### Executable de migration de schéma de base de données (`bidding-db-changelog-job`)
Pour retirer la responsabilité au serveur HTTP de gérer les migrations de son schéma, on délègue cette partie à un
exécutable dédié. Ici, on a arbitrairement utilisé Liquibase.

## Tests
Afin de prouver le bon fonctionnement du service et de garantir qu'aucune régression n'a lieu lors de récentes
modifications, on dispose ici de 2 couches de test: des tests unitaires (exemple
[ici](../bidding-service/bidding-server/src/test/java/fr/agregio/bidding/server/domain/energy/EnergyTest.java)) et des tests
d'intégration (exemple
[ici](../bidding-service/bidding-server/src/test/java/fr/agregio/bidding/server/http/api/bid/CreateMarketBidTest.java)).

### Tests d'intégration
Les tests d'intégration, reconnaissables parce qu'ils étendent la classe 
[SpringContextAware](../bidding-service/bidding-server/src/test/java/fr/agregio/bidding/server/test/SpringContextAware.java),
s'appuient sur la dépendance
```
<dependency>
    <groupId>com.playtika.testcontainers</groupId>
    <artifactId>embedded-postgresql</artifactId>
    <scope>test</scope>
</dependency>
```
pour monter au démarrage de l'application un conteneur Docker PostgreSQL dédiée aux tests.

Entre chaque test, un [script SQL](../bidding-service/bidding-server/src/test/resources/sql/clean.sql) de nettoyage de la base
permet de garantir que les tests n'interfèrent pas les uns avec les autres.
