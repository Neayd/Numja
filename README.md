# Numja - A Numpy equivalent for Java
| Catégorie     | Badge                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
|:--------------|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| __Tests__     | [![CI](https://github.com/Deo-Favente/Numja/actions/workflows/ci.yml/badge.svg)](https://github.com/Deo-Favente/Numja/actions/workflows/ci.yml) ![Coverage](badges/jacoco.svg)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| __Livraison__ | [![CD](https://github.com/Deo-Favente/Numja/actions/workflows/cd.yml/badge.svg)](https://github.com/Deo-Favente/Numja/actions/workflows/cd.yml)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| __Analyse__   | [![Quality Gate Status](https://im2ag-sonar.univ-grenoble-alpes.fr/api/project_badges/measure?project=M1-Info-DevOps-Projet-Numja&metric=alert_status&token=sqb_c321480420056c1e5e025e5c1b50028a2deeb1c7)](https://im2ag-sonar.univ-grenoble-alpes.fr/dashboard?id=M1-Info-DevOps-Projet-Numja) [![Maintainability Rating](https://im2ag-sonar.univ-grenoble-alpes.fr/api/project_badges/measure?project=M1-Info-DevOps-Projet-Numja&metric=software_quality_maintainability_rating&token=sqb_c321480420056c1e5e025e5c1b50028a2deeb1c7)](https://im2ag-sonar.univ-grenoble-alpes.fr/dashboard?id=M1-Info-DevOps-Projet-Numja) [![Security Rating](https://im2ag-sonar.univ-grenoble-alpes.fr/api/project_badges/measure?project=M1-Info-DevOps-Projet-Numja&metric=software_quality_security_rating&token=sqb_c321480420056c1e5e025e5c1b50028a2deeb1c7)](https://im2ag-sonar.univ-grenoble-alpes.fr/dashboard?id=M1-Info-DevOps-Projet-Numja)                                                             |
| __Autre__     | [![Lines of Code](https://im2ag-sonar.univ-grenoble-alpes.fr/api/project_badges/measure?project=M1-Info-DevOps-Projet-Numja&metric=ncloc&token=sqb_c321480420056c1e5e025e5c1b50028a2deeb1c7)](https://im2ag-sonar.univ-grenoble-alpes.fr/dashboard?id=M1-Info-DevOps-Projet-Numja) ![GitHub repo size](https://img.shields.io/github/repo-size/deo-favente/numja) ![GitHub commit activity](https://img.shields.io/github/commit-activity/t/Deo-Favente/Numja) ![GitHub Repo stars](https://img.shields.io/github/stars/Deo-Favente/Numja?style=flat&label=Github%20Stars&color=FFFF00) ![GitHub forks](https://img.shields.io/github/forks/Deo-Favente/Numja?style=flat&label=Github%20Forks&color=800080) ![GitHub watchers](https://img.shields.io/github/watchers/Deo-Favente/Numja?style=flat&label=Github%20Watchers&color=00FF00) ![YouTube Channel Subscribers](https://img.shields.io/youtube/channel/subscribers/UCX6OQ3DkcsbYNE6H8uQQuVA?style=flat&label=Mr%20Beast's%20Subscriber%20Counter) |
## Description
Numja est un équivalent Java de la bibliothèque de calcul scientifique Numpy. Elle permet de représenter et d'effectuer facilement des opérations sur des matrices et des vecteurs.

## Auteurs
Samuel [@samuel38fr](https://github.com/samuel38fr) <br>
Enzo [@Deo-Favente](https://github.com/Deo-Favente) <br>
Loïc [@Neayd](https://github.com/Neayd)

Projet réalisé dans le cadre du cours de DevOps.

## Fonctionnalités 
- Vecteurs (1D) et de matrices (2D)
- Données de type float supportés
- Redimensionner un vecteur ou une matrice
- Operation d'addition avec scalaire ou tableau

## Installation
Avec Maven :
```
<dependency>
  <groupId>fr.uga.numja</groupId>
  <artifactId>numja</artifactId>
  <version>2.0-SNAPSHOT</version>
</dependency>
```
Puis
```
mvn install
```

## Démonstration
Exécutez simplement l'image Docker pour voir un aperçu des fonctionnalités :
```
docker pull ghcr.io/deo-favente/numja:main
docker run ghcr.io/deo-favente/numja:main
```

## Documentation
Deux pages sont hébergées sur Github Pages :
- [Page d'accueil](https://deo-favente.github.io/Numja/) : présentation du projet (ce README)
- [Javadoc](https://deo-favente.github.io/Numja/apidocs/) : documentation complète de l'API


## Outils utilisés
- Gestion de version : Git (sur Github) ([Lien vers le repo](https://github.com/deo-favente/numja))
- IDE : IntellijIdea
- Gestion et de construction de projet : Maven 
- Couverture de code : JaCoco
- Exécution d'une démo: Docker 
- Déploiement de l'image Docker et de la lib Maven : Github Packages ([Lien vers les déploiements](https://github.com/Deo-Favente/Numja/packages/))
- Hébergement de la documentation : Github Pages ([Lien vers la page d'accueil](https://deo-favente.github.io/Numja/)) et Javadoc ([Lien vers la documentation de l'API](https://deo-favente.github.io/Numja/apidocs/))
- Analyse statique : SonarQube ([Lien vers notre instance](https://im2ag-sonar.univ-grenoble-alpes.fr/dashboard?id=M1-Info-DevOps-Projet-Numja))

## Mode de fonctionnement
### Workflow
Nous travaillons sur un workflow feature branch classique. Une personne peut travailler sur une ou plusieurs branches en parallèle.
Chaque ajout de fonctionnalité / doc se fait après une pull request. La pull request doit valider les tests unitaires être approuvé par au moins une personne qui n'a pas travaillé sur le dernier commit.
Une analyse statique de code est lancée à chaque déploiement afin de pousser les analyses.

### Nomenclature des branches
Nous avons une nomenclature de nommage de branches afin d'avoir des noms normalisés :
- `feat/nouvelle-feature` : Nouvelle fonctionnalité de la bibliothèque
- `bugfix/correctif`, `hotfix/correctif` : Correction de bugs
- `doc/readme` : Ajout de documentation
- `ci-cd/tests` : Améliorations liées au CI CD
