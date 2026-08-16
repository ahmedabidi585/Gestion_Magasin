# 🏪 Store Management System — Supermarket ABIDI AHMED

> **Java desktop application (Swing)** for comprehensive store management, including inventory, purchases, sales, customers, suppliers, and user management.

---

## 📋 Table of Contents

* [Overview](#overview)
* [Features](#features)
* [Project Architecture](#project-architecture)
* [Requirements](#requirements)
* [Installation & Configuration](#installation--configuration)
* [Database Structure](#database-structure)
* [User Roles](#user-roles)
* [Technologies Used](#technologies-used)
* [License](#license)

---

## 🎯 Overview

**Store Management System** is a Java Swing desktop application developed for **Supermarket ABIDI BENZARTI**. It manages the main operations of a retail store, including inventory management, stock entries and exits, purchase orders, sales orders, customers, suppliers, and products.

The application follows an **MVC (Model-View-Controller)** architecture and uses **MySQL** as the database through the **DAO (Data Access Object)** design pattern.

---

## ✨ Features

| Module                     | Description                                 |
| -------------------------- | ------------------------------------------- |
| 🔐 **Authentication**      | Secure login with role-based access control |
| 📦 **Product Management**  | Add, update, delete, and search products    |
| 👥 **Customer Management** | Complete CRUD operations for customers      |
| 🏭 **Supplier Management** | Complete CRUD operations for suppliers      |
| 📥 **Stock Entries**       | Record incoming merchandise                 |
| 📤 **Stock Exits**         | Record outgoing merchandise                 |
| 🛒 **Purchase Orders**     | Create and track purchase orders            |
| 💰 **Sales Orders**        | Create and track sales orders               |
| 🔍 **Search**              | Advanced data search functionality          |
| 👤 **User Management**     | Account administration for administrators   |

---

## 🏗️ Project Architecture

```text id="n4l3qo"
Gestion_Magasin/
│
├── src/
│   ├── Connexion/
│   │   ├── Singleton.java          # MySQL connection management
│   │   └── Test.java               # Database connection test
│   │
│   ├── Modele/
│   │   ├── Article.java             # Product entity
│   │   ├── BonAchat.java            # Purchase order entity
│   │   ├── BonCommande.java         # Sales/order entity
│   │   ├── Client.java              # Customer entity
│   │   ├── Fournisseur.java         # Supplier entity
│   │   ├── LigneAchat.java          # Purchase order line
│   │   ├── LigneCommande.java       # Order line
│   │   ├── Personne.java            # Parent class for Client/Supplier
│   │   ├── User.java                # User entity
│   │   └── DAO/
│   │       ├── *Dao.java            # DAO interfaces
│   │       └── *Imp.java            # DAO implementations
│   │
│   └── Vue/
│       ├── Login.java                # Login interface
│       ├── Admin.java                # Administrator interface
│       ├── Magasinier.java           # Storekeeper interface
│       ├── ResponsableAchat.java     # Purchasing manager interface
│       ├── ResponsableVente.java     # Sales manager interface
│       ├── ArticleInterface.java     # Product CRUD interface
│       ├── ClientInterface.java      # Customer CRUD interface
│       ├── FournisseurInterface.java # Supplier CRUD interface
│       ├── Bon_achat.java             # Purchase order management
│       ├── Bon_commande.java          # Sales/order management
│       ├── Entrestock.java             # Stock entry management
│       ├── Sortiestock.java             # Stock exit management
│       ├── Ligneachat.java             # Purchase order lines
│       ├── Lignecommande.java          # Order lines
│       ├── Recherche.java              # Search interface v1
│       ├── Recherche1.java             # Search interface v2
│       ├── Affichage.java              # Data display
│       └── UiUtils.java                # Common UI utilities
│
├── lib/
│   └── mysql-connector-j-8.3.0.jar    # MySQL JDBC driver
│
├── .classpath                          # Eclipse configuration
├── .project                            # Eclipse project metadata
└── README.md
```

---

## ⚙️ Requirements

* **Java JDK 11** or later
* **MySQL 8.0** or later
* **Eclipse IDE** recommended, or any compatible Java IDE
* **MySQL Connector/J 8.3.0** — already included in `lib/`

---

## 🚀 Installation & Configuration

### 1. Clone the Repository

```bash id="z0d9gu"
git clone https://github.com/ahmedabidi585/Gestion_Magasin.git
cd Gestion_Magasin
```

### 2. Import the Project into Eclipse

1. Open **Eclipse IDE**.
2. Go to `File` → `Import` → `Existing Projects into Workspace`.
3. Select the cloned project directory.
4. Click **Finish**.

### 3. Configure the MySQL Database

Create a database named `gestion_stock`:

```sql id="9p4z7h"
CREATE DATABASE gestion_stock
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE gestion_stock;
```

Then execute the provided SQL script to create the required tables.

### 4. Configure the Database Connection

Open:

```text id="h9im4c"
src/Connexion/Singleton.java
```

Update the MySQL credentials:

```java id="6n0d7m"
con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/gestion_stock",
    "root",      // Your MySQL username
    ""           // Your MySQL password
);
```

### 5. Run the Application

Launch the main login interface:

```text id="o5pp3r"
Vue.Login
```

---

## 🗄️ Database Structure

The `gestion_stock` database contains the following tables:

| Table            | Description                       |
| ---------------- | --------------------------------- |
| `user`           | Application users and their roles |
| `article`        | Product catalog                   |
| `client`         | Store customers                   |
| `fournisseur`    | Suppliers                         |
| `bon_achat`      | Purchase orders                   |
| `bon_commande`   | Sales/orders                      |
| `ligne_achat`    | Purchase order details            |
| `ligne_commande` | Order details                     |

### Example — `user` Table

```sql id="7kmyfw"
CREATE TABLE user (
    id_user       INT PRIMARY KEY AUTO_INCREMENT,
    nom_u         VARCHAR(50) NOT NULL,
    prenom_u      VARCHAR(50) NOT NULL,
    password_user INT NOT NULL,
    role_user     VARCHAR(30) NOT NULL
    -- Roles: admin | magasinier | responsableachat | responsablevente
);
```

> **Note:** A first administrator account must be created manually to access the application:

```sql id="8r1mvs"
INSERT INTO user (nom_u, prenom_u, password_user, role_user)
VALUES ('admin', 'admin', 1234, 'admin');
```

---

## 👤 User Roles

| Role                   | Access                                                                      |
| ---------------------- | --------------------------------------------------------------------------- |
| **Admin**              | Full access: user management, products, customers, suppliers, and inventory |
| **Storekeeper**        | Stock entry and stock exit management                                       |
| **Purchasing Manager** | Purchase orders, suppliers, and product management                          |
| **Sales Manager**      | Sales/orders and customer management                                        |

---

## 🛠️ Technologies Used

| Technology            | Version | Purpose                   |
| --------------------- | ------- | ------------------------- |
| **Java**              | JDK 11+ | Main programming language |
| **Java Swing**        | —       | Graphical user interface  |
| **MySQL**             | 8.0+    | Relational database       |
| **JDBC**              | —       | Database connectivity     |
| **MySQL Connector/J** | 8.3.0   | MySQL JDBC driver         |
| **Eclipse IDE**       | —       | Development environment   |
| **MVC**               | —       | Application architecture  |
| **DAO Pattern**       | —       | Data access layer         |

---

## 📝 License

This project is intended for **educational and internal use**.

---

*Developed for **Supermarket ABIDI AHMED**.*
