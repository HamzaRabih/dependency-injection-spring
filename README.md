# 🖥️ TP – Injection de Dépendances avec Spring (Annotations)

## 📌 Remarque
Cette branche est dédiée uniquement à l’injection de dépendances avec Spring Annotations.
Les autres méthodes (instanciation statique, dynamique, Spring XML) se trouvent dans d’autres branches.


## 🎯 Objectif
Cette partie du TP montre comment réaliser **l’injection de dépendances** en utilisant **Spring Framework** avec les **annotations** (`@Component`, `@Autowired`, `@Qualifier`), sans fichier XML.  
Ici, la configuration se fait directement dans le code source.

---

## 📂 Structure du projet

    ma.enset.iibdcc.Partie1
    │
    ├── dao
    │ ├── IDoa.java
    │ ├── DaoImpl.java # Version BDD (bean "d")
    │ └── DaoImplV2.java # Version capteur (bean "d2")
    │
    ├── metier
    │ ├── IMetier.java
    │ └── MetierImpl.java # Injection via @Autowired
    │
    └── presentation
    └── PresSpringAnnotation.java
---

---

## 🔍 Explication

### 1. Déclaration des Beans avec `@Component`
Spring détecte automatiquement les classes annotées avec `@Component` lors du **scan du package**.

```java
@Component("d")
public class DaoImpl implements IDoa { ... }

@Component("d2")
public class DaoImplV2 implements IDoa { ... }
```
- @Component("idBean") : nom du bean dans le conteneur Spring

## 2. Injection avec @Autowired et @Qualifier

@Component("metier")
public class MetierImpl implements IMetier {
```java
    @Component("metier")
    public class MetierImpl implements IMetier {
    
        @Autowired
        @Qualifier("d2") // Spécifie quelle implémentation utiliser
        private IDoa doa;
    
        @Override
        public double calcul() {
            double t = doa.getData();
            return t * 12 * Math.PI / 2 * Math.cos(t);
        }
    }
```
- @Autowired : injection automatique par Spring

- @Qualifier : permet de choisir quelle implémentation utiliser si plusieurs existent

## 3. Lancement de l’application

```java
    public class PresSpringAnnotation {
    public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
    new AnnotationConfigApplicationContext("ma.enset.iibdcc");
    
            IMetier metier = context.getBean(IMetier.class);
            System.out.println(metier.calcul());
        }
    }
```

- AnnotationConfigApplicationContext("ma.enset.iibdcc") : scanne le package pour trouver les classes annotées

- getBean(IMetier.class) : récupère le bean MetierImpl automatiquement injecté avec le DAO choisi

## ⚙️ Dépendances Maven

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>6.2.9</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>6.2.9</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-beans</artifactId>
        <version>6.2.9</version>
    </dependency>
</dependencies>
```
