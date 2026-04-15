# Numja - A Numpy equivalent for Java

| | |
| --- | --- |
| Testing | [![Unit tests](https://github.com/Deo-Favente/Numja/actions/workflows/development.yml/badge.svg)](https://github.com/Deo-Favente/Numja/actions/workflows/development.yml) |
| Coverage | ![Coverage](badges/jacoco.svg) |
| Package | |

## Auteurs
Samuel [@samuel38fr](https://github.com/samuel38fr) <br>
Enzo [@Deo-Favente](https://github.com/Deo-Favente) <br>
Loïc [@Neayd](https://github.com/Neayd)

Projet réalisé dans le cadre du cours de DevOps.

## Fonctionnalités 
- Vecteurs (1D) et de matrices (2D)
- Données de type float supportés

## Outils utilisés
- Gestion de version : Git (sur [Github.com](github.com))
- IDE : IntellijIdea
- Gestion et de construction de projet : Maven
- Couverture de code : JaCoco

## Mode de fonctionnement
### Workflow
Nous travaillons sur un workflow feature branch classique. Une personne peut travailler sur une ou plusieurs branches en parallèle.
Chaque ajout de fonctionnalité / doc se fait après une pull request. La pull request doit valider tests unitaires, d'intégration et être approuvé par au moins une personne qui n'a pas travaillé sur le dernier commit.

### Nomenclature des branches
Nous avons une nomenclature de nommage de branches afin d'avoir des noms normalisés :
- `feat/nouvelle-feature` : Nouvelle fonctionnalité de la bibliothèque
- `bugfix/correctif` : Correctif sur la branche principale
- `doc/readme` : Ajout de documentation
- `ci-cd/tests` : Améliorations liées au CI CD

### Nomenclature des tags
Les différentes versions du logicielles sont groupées par tag.
Ajouter une nouvelle fonctionnallité fait passer le logiciel de la version `vx.y` à la version `v(x+1).y` <br>
Corriger un bug important fait passer la version `vx.y` à la version `vx.(y+1)`
