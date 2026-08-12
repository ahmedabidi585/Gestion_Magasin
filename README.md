# 🏪 Gestion Magasin — Supermarket 

> Application de bureau Java (Swing) pour la gestion complète d'un magasin : stock, achats, ventes, clients, fournisseurs et utilisateurs.

---

## 📋 Table des matières

- [Aperçu](#aperçu)
- [Fonctionnalités](#fonctionnalités)
- [Architecture du projet](#architecture-du-projet)
- [Prérequis](#prérequis)
- [Installation & Configuration](#installation--configuration)
- [Structure de la base de données](#structure-de-la-base-de-données)
- [Rôles utilisateurs](#rôles-utilisateurs)
- [Technologies utilisées](#technologies-utilisées)

---

## 🎯 Aperçu

**Gestion Magasin** est une application Java Swing développée pour le **Supermarket ABIDI BENZARTI**. Elle permet de gérer l'ensemble des opérations d'un magasin : gestion du stock (entrées/sorties), bons de commande, bons d'achat, clients, fournisseurs et articles.

L'application utilise une architecture **MVC (Modèle-Vue-Contrôleur)** avec accès à une base de données **MySQL** via le patron de conception **DAO (Data Access Object)**.

---

## ✨ Fonctionnalités

| Module | Description |
|--------|-------------|
| 🔐 **Authentification** | Connexion sécurisée avec gestion des rôles |
| 📦 **Gestion des articles** | Ajout, modification, suppression, recherche |
| 👥 **Gestion des clients** | CRUD complet sur les clients |
| 🏭 **Gestion des fournisseurs** | CRUD complet sur les fournisseurs |
| 📥 **Entrées de stock** | Enregistrement des entrées de marchandises |
| 📤 **Sorties de stock** | Enregistrement des sorties de marchandises |
| 🛒 **Bons de commande** | Création et suivi des bons de commande |
| 💰 **Bons d'achat** | Création et suivi des bons d'achat |
| 🔍 **Recherche** | Recherche avancée sur les données |
| 👤 **Gestion des utilisateurs** | Administration des comptes (Admin uniquement) |

---

## 🏗️ Architecture du projet

```
Gestion_Magasin/
│
├── src/
│   ├── Connexion/
│   │   ├── Singleton.java       # Gestion de la connexion MySQL (pattern Singleton)
│   │   └── Test.java            # Test de connexion
│   │
│   ├── Modele/
│   │   ├── Article.java         # Entité Article
│   │   ├── BonAchat.java        # Entité Bon d'achat
│   │   ├── BonCommande.java     # Entité Bon de commande
│   │   ├── Client.java          # Entité Client
│   │   ├── Fournisseur.java     # Entité Fournisseur
│   │   ├── LigneAchat.java      # Entité Ligne d'achat
│   │   ├── LigneCommande.java   # Entité Ligne de commande
│   │   ├── Personne.java        # Classe parente (Client/Fournisseur)
│   │   ├── User.java            # Entité Utilisateur
│   │   └── DAO/
│   │       ├── *Dao.java        # Interfaces DAO
│   │       └── *Imp.java        # Implémentations DAO
│   │
│   └── Vue/
│       ├── Login.java           # Page de connexion
│       ├── Admin.java           # Interface Administrateur
│       ├── Magasinier.java      # Interface Magasinier
│       ├── ResponsableAchat.java  # Interface Responsable Achat
│       ├── ResponsableVente.java  # Interface Responsable Vente
│       ├── ArticleInterface.java  # CRUD Articles
│       ├── ClientInterface.java   # CRUD Clients
│       ├── FournisseurInterface.java # CRUD Fournisseurs
│       ├── Bon_achat.java       # Gestion bons d'achat
│       ├── Bon_commande.java    # Gestion bons de commande
│       ├── Entrestock.java      # Gestion entrées de stock
│       ├── Sortiestock.java     # Gestion sorties de stock
│       ├── Ligneachat.java      # Lignes de bon d'achat
│       ├── Lignecommande.java   # Lignes de bon de commande
│       ├── Recherche.java       # Recherche (version 1)
│       ├── Recherche1.java      # Recherche (version 2)
│       ├── Affichage.java       # Affichage des données
│       └── UiUtils.java         # Utilitaires UI communs
│
├── lib/
│   └── mysql-connector-j-8.3.0.jar  # Driver JDBC MySQL
│
├── .classpath                   # Configuration Eclipse
├── .project                     # Métadonnées Eclipse
└── README.md
```

---

## ⚙️ Prérequis

- **Java JDK** 11 ou supérieur
- **MySQL** 8.0 ou supérieur
- **Eclipse IDE** (recommandé) ou tout autre IDE Java
- **MySQL Connector/J** 8.3.0 (déjà inclus dans `lib/`)

---

## 🚀 Installation & Configuration

### 1. Cloner le dépôt

```bash
git clone https://github.com/<votre-utilisateur>/Gestion_Magasin.git
cd Gestion_Magasin
```

### 2. Importer dans Eclipse

1. Ouvrir **Eclipse IDE**
2. `File` → `Import` → `Existing Projects into Workspace`
3. Sélectionner le dossier cloné
4. Cliquer **Finish**

### 3. Configurer la base de données MySQL

Créer une base de données nommée `gestion_stock` :

```sql
CREATE DATABASE gestion_stock CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE gestion_stock;
```

Puis exécuter le script SQL fourni (voir section [Structure de la base de données](#structure-de-la-base-de-données)).

### 4. Configurer la connexion

Modifier le fichier `src/Connexion/Singleton.java` avec vos identifiants MySQL :

```java
con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/gestion_stock",
    "root",      // <- votre utilisateur MySQL
    ""           // <- votre mot de passe MySQL
);
```

### 5. Lancer l'application

Exécuter la classe principale :

```
Vue.Login
```

---

## 🗄️ Structure de la base de données

La base de données `gestion_stock` contient les tables suivantes :

| Table | Description |
|-------|-------------|
| `user` | Utilisateurs de l'application (avec rôles) |
| `article` | Catalogue des articles |
| `client` | Clients du magasin |
| `fournisseur` | Fournisseurs |
| `bon_achat` | Bons d'achat |
| `bon_commande` | Bons de commande |
| `ligne_achat` | Lignes détail des bons d'achat |
| `ligne_commande` | Lignes détail des bons de commande |

**Exemple — Table `user` :**

```sql
CREATE TABLE user (
    id_user       INT PRIMARY KEY AUTO_INCREMENT,
    nom_u         VARCHAR(50) NOT NULL,
    prenom_u      VARCHAR(50) NOT NULL,
    password_user INT NOT NULL,
    role_user     VARCHAR(30) NOT NULL
    -- roles: admin | magasinier | responsableachat | responsablevente
);
```

> **Note :** Créer un premier compte administrateur manuellement pour accéder à l'application :
> ```sql
> INSERT INTO user (nom_u, prenom_u, password_user, role_user)
> VALUES ('admin', 'admin', 1234, 'admin');
> ```

---

## 👤 Rôles utilisateurs

| Rôle | Accès |
|------|-------|
| **Admin** | Accès complet : gestion des utilisateurs, articles, clients, fournisseurs, stock |
| **Magasinier** | Gestion des entrées/sorties de stock |
| **Responsable Achat** | Gestion des bons d'achat, fournisseurs, articles |
| **Responsable Vente** | Gestion des bons de commande, clients |

---

## 🛠️ Technologies utilisées

| Technologie | Version | Rôle |
|-------------|---------|------|
| Java | JDK 11+ | Langage principal |
| Java Swing | — | Interface graphique (GUI) |
| MySQL | 8.0+ | Base de données relationnelle |
| JDBC | — | Connectivité base de données |
| MySQL Connector/J | 8.3.0 | Driver JDBC MySQL |
| Eclipse IDE | — | Environnement de développement |

---

## 📝 Licence

Ce projet est à usage pédagogique / interne.

---

*Développé pour le Supermarket ABIDI BENZARTI.*
