# 🖥️ TP – Injection de Dépendances en Java (Partie 1)

## 🎯 Objectif du TP
Ce TP a pour but de comprendre le concept **d'injection de dépendances** en Java et de l'appliquer à travers deux approches :
1. **Instantiation statique** (couplage faible mais toujours modifiable)
2. **Instantiation dynamique** (réflexion en Java)

L’objectif est de séparer les responsabilités entre couches (**DAO**, **métier**, **présentation**) tout en permettant de changer facilement les implémentations **sans modifier le code source** de la couche métier.

---

## 📂 Structure du projet

    ma.enset.iibdcc.Partie1
    │
    ├── dao
    │ ├── IDoa.java # Interface DAO (Data Access Object)
    │ ├── DaoImpl.java # Implémentation version BDD
    │ └── extension
    │ └── DaoImplV2.java # Implémentation version capteur
    │
    ├── metier
    │ ├── IMetier.java # Interface métier
    │ └── MetierImpl.java # Implémentation métier
    │
    └── presentation
    ├── Presentation1.java # Injection statique
    └── Presentation2.java # Injection dynamique

---

## 🔍 Explication des concepts

### 1. Couplage faible
Le **couplage faible** permet à une classe de dépendre d'une **abstraction** (interface) plutôt que d'une implémentation concrète.  
Ainsi, on peut changer l'implémentation utilisée **sans changer le code métier**.

Exemple :
```java
// Couplage faible : dépendance vers l'interface
private IDoa doa;
```

### 2. Injection de dépendances
📌 2.1. Instantiation statique
Dans Presentation1, on crée directement les instances dans le code :

```java
IDoa dao = new DaoImpl(); // Version BDD
MetierImpl metier = new MetierImpl(dao); // Injection via constructeur
```

 Avantage : Simple à comprendre et à implémenter.

 Inconvénient : Si on change l'implémentation (DaoImpl → DaoImplV2), il faut modifier et recompiler le code.

 ### 📌 2.2. Instantiation dynamique
Dans Presentation2, on utilise la réflexion pour créer les objets à partir des noms de classes stockés dans un fichier (config.txt).

Exemple config.txt :
```txt
    ma.enset.iibdcc.Partie1.extension.DaoImplV2
    ma.enset.iibdcc.Partie1.metier.MetierImpl
```
Code principal :

```java
    Scanner sc = new Scanner(new File("config.txt"));
    
    // Lecture du nom de la classe DAO
    String daoClassName = sc.nextLine();
    Class cDao = Class.forName(daoClassName);
    IDoa dao = (IDoa) cDao.newInstance();
    
    // Lecture du nom de la classe métier
    String metierClassName = sc.nextLine();
    Class cMetier = Class.forName(metierClassName);
    IMetier metier = (IMetier) cMetier.getConstructor(IDoa.class).newInstance(dao);
    
    System.out.println("Résultat: " + metier.calcul());
    
```

 Avantage : Changer l’implémentation sans modifier le code (juste changer config.txt).

 Inconvénient : Plus complexe, nécessite de gérer les exceptions liées à la réflexion.

# ⚙️ Exemple d’exécution
```txt
    Version BDD (Presentation1)
    Résultat= 186.221
```
Version Capteur (Presentation2 avec config.txt)
```txt
    Version capteur:
    Résultat:  121.556
```
