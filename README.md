# Numja - A Numpy equivalent for Java

| __Testing__ | [![CI](https://github.com/Deo-Favente/Numja/actions/workflows/ci.yml/badge.svg)](https://github.com/Deo-Favente/Numja/actions/workflows/ci.yml) ![Coverage](badges/jacoco.svg) |
|:------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| __Package__ | [![CD](https://github.com/Deo-Favente/Numja/actions/workflows/cd.yml/badge.svg)](https://github.com/Deo-Favente/Numja/actions/workflows/cd.yml)                                |

## Auteurs
Samuel [@samuel38fr](https://github.com/samuel38fr) <br>
Enzo [@Deo-Favente](https://github.com/Deo-Favente) <br>
Loïc [@Neayd](https://github.com/Neayd)

Projet réalisé dans le cadre du cours de DevOps.

## Fonctionnalités 
- Vecteurs (1D) et de matrices (2D)
- Données de type float supportés

## Démonstration
Exécutez simplement l'image Docker pour voir un aperçu des fonctionnalités :
```
docker pull ghcr.io/deo-favente/numja:main
docker run ghcr.io/deo-favente/numja:main
```

## Outils utilisés
- Gestion de version : Git (sur [Github.com](github.com))
- IDE : IntellijIdea
- Gestion et de construction de projet : Maven
- Couverture de code : JaCoco
- Déploiement d'une démo : Docker et Github Packages
- Hébergement de la documentation : [Github Pages](https://deo-favente.github.io/Numja/) (page d'accueil) et [Javadoc](https://deo-favente.github.io/Numja/apidocs/) (documentation de l'API)

## Mode de fonctionnement
### Workflow
Nous travaillons sur un workflow feature branch classique. Une personne peut travailler sur une ou plusieurs branches en parallèle.
Chaque ajout de fonctionnalité / doc se fait après une pull request. La pull request doit valider tests unitaires, d'intégration et être approuvé par au moins une personne qui n'a pas travaillé sur le dernier commit.

### Nomenclature des branches
Nous avons une nomenclature de nommage de branches afin d'avoir des noms normalisés :
- `feat/nouvelle-feature` : Nouvelle fonctionnalité de la bibliothèque
- `bugfix/correctif`, `hotfix/correctif` : Correction de bugs
- `doc/readme` : Ajout de documentation
- `ci-cd/tests` : Améliorations liées au CI CD

### Nomenclature des tags
Les tags sont des versions du logiciel, avec leur fonctionnalités respectives, manuellement marquées par l'équipe de développement comme stables. On entend par stable sans bug connu, car la branche main peut parfois avoir besoin de correctifs.
Les différentes versions du logicielles sont groupées par tag.

Ajouter une nouvelle fonctionnallité fait passer le logiciel de la version `vx.y` à la version `v(x+1).0` <br>
Corriger un bug important fait passer la version `vx.y` à la version `vx.(y+1)`


## Documentation
Deux pages sont hébergées sur Github Pages :
- [Page d'accueil](https://deo-favente.github.io/Numja/) : présentation du projet (ce README)
- [Javadoc](https://deo-favente.github.io/Numja/apidocs/) : documentation complète de l'API 
