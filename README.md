# 🖥️ TP – Injection de Dépendances avec Spring (Configuration XML)

## 📌 Remarque
Cette branche est dédiée uniquement à l’injection de dépendances avec Spring XML.
Les autres méthodes (instanciation statique, dynamique, annotations Spring) se trouvent dans d’autres branches.

## 🎯 Objectif
Cette partie du TP montre comment réaliser **l’injection de dépendances** en utilisant **Spring Framework** avec un **fichier de configuration XML**.  
Cette approche permet de configurer les objets et leurs dépendances **sans modifier le code Java**, en externalisant la configuration.

---

## 📂 Structure du projet

    java
    ├──ma.enset.iibdcc.Partie1
    │
    ├── dao
    │ ├── IDoa.java
    │ └── DaoImpl.java
    │
    ├── metier
    │ ├── IMetier.java
    │ └── MetierImpl.java
    │
    └── presentation
    └── PresSpringXML.java # Point d'entrée du programme
    ressources
    ├──config.xml # Configuration Spring

---

## 🔍 Explication

### 1. Fichier de configuration `config.xml`
Ce fichier définit les **beans** (objets) que Spring va gérer, ainsi que leurs dépendances.

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Définition du DAO -->
    <bean id="d" class="ma.enset.iibdcc.Partie1.dao.DaoImpl"></bean>

    <!-- Définition du service métier avec injection de dépendance -->
    <bean id="metier" class="ma.enset.iibdcc.Partie1.metier.MetierImpl">
        <property name="doa" ref="d"></property>
    </bean>
</beans>
```

- id : identifiant du bean
- class : nom complet de la classe à instancier
- property : injection d’une dépendance via un setter (setDoa dans MetierImpl)

### 2. Code Java PresSpringXML.java

```java
   ApplicationContext SpringContext =
   new ClassPathXmlApplicationContext("config.xml");
    IMetier metier = (IMetier) SpringContext.getBean("metier");
    System.out.println(metier.calcul());

```

- ApplicationContext : conteneur Spring qui lit la configuration et instancie les beans
- getBean("metier") : récupération du bean métier configuré dans config.xml
- L’injection se fait automatiquement grâce au fichier XML

### 3. Avantages
Pas de modification du code pour changer l’implémentation
Configuration centralisée dans un seul fichier
Facilite les tests et la maintenance

## ⚙️ Dépendances Maven
Ajouter dans pom.xml :
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






