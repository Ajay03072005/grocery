# 🛒 Grocery Management System (Java Console Application)

Welcome to the **Grocery Management System**, a simple and interactive Java console-based application designed to manage grocery store items efficiently. This beginner-friendly project demonstrates basic CRUD operations (Create, Read, Update, Delete) using Java and MySQL, making it perfect for learning backend logic and JDBC database connectivity.

---

## 📌 Features

- ✅ Add new grocery items (name, price, quantity)
- 📋 Display all grocery items in tabular format
- 🔍 Search items by name
- ✏️ Update existing item details
- ❌ Delete items from the inventory
- 📦 Persistent data storage using MySQL

---

## 💻 Tech Stack

| Technology | Purpose             |
|------------|---------------------|
| Java       | Backend logic       |
| MySQL      | Data storage        |
| JDBC       | DB connectivity     |
| Git/GitHub | Version control     |

---

## 🚀 Getting Started

### 🔧 Prerequisites

Ensure you have the following installed:

- ✅ Java JDK 17 or above (JDK 24 is supported)
- ✅ MySQL Server and MySQL Workbench (optional)
- ✅ Any Java IDE (IntelliJ / Eclipse) or command-line compiler

---

## 🗃️ Database Setup

1. Open MySQL terminal or Workbench and run the following:

```sql
CREATE DATABASE grocerydb;

USE grocerydb;

CREATE TABLE groceries (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  price DOUBLE,
  quantity INT
);
