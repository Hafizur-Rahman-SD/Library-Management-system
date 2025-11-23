# 📚 Library Management System (Spring Boot + Thymeleaf)

A full-featured **Library Management System** built with **Spring Boot 3**, **Spring MVC**, **Spring Data JPA**, **Hibernate**, **Thymeleaf**, and **MySQL**.

This project is designed with a **clean layered architecture** and **module-wise (DDD style) structure** for different library domains like student, vendor, purchase, inventory, publication, subscription, etc.

> Simple UI, clean code, SOLID-friendly structure — easy to extend and maintain.

---

## ✨ Core Features

### 👨‍🎓 Student Management
- Add / Edit / Delete students  
- Store **name, email, phone, department**, etc.  
- Dummy data pre-loaded for demo  
- Clean table view with actions

### 🏢 Vendor Management
- Manage book vendors / suppliers  
- Store **vendor name, company, phone, email, address**  
- Vendor used in Purchase module  
- CRUD operations with proper service & repo layers

### 📦 Purchase / Book Purchase
- Record purchased books from vendors  
- Fields: **book name, vendor, quantity, price per book, invoice, purchase date**  
- Linked with `Vendor` via `@ManyToOne`  
- Purchase list table with actions

### 📚 Inventory – Issue & Return
- Track **book issue & return**  
- Fields:
  - Book Title + Book Code  
  - Student Name + Student Unique ID  
  - Action Type (**ISSUE / RETURN**)  
  - Action Date  
  - Quantity  
  - Note  
  - Status (**ACTIVE / RETURNED**) – auto updated
- Features:
  - Dummy records on startup
  - Add / Edit / Delete  
  - Note **view** (popup / modal behaviour)
  - Status calculated based on action type

### 🏢 Publication Management
- Manage book publications / publishers  
- Fields: **publication name, code, contact person, email, phone, website, address, status, createdAt**  
- CRUD operations with a clean form & list view

### 💳 Subscription Type Management
- Configure different subscription plans (Weekly / Monthly / Yearly, etc.)  
- Fields:
  - Title
  - Amount (€)
  - Number of Days
  - Active / Inactive
- Dummy subscription types loaded on startup  
- Add / Edit / Delete from UI

### 📊 Reports (Basic UI)
- Dedicated **Reports** page  
- Date range filter UI  
- Summary cards (e.g. total purchase, total allotment, etc. – can be wired to real data)  
- Tabs for:
  - Book Allotment
  - Purchase Details
  - Submission Details (placeholder)
- Table tools UI: **Columns, Filters, Density, Export, Search** (front-end ready, JS/back-end can be extended later)

### 👤 Authentication & Profile (Basic)
- Separate login page: `/auth/login`  
- Logout redirects back to login  
- Simple profile page showing basic user info (static/dummy for now)  

### 🧩 Common Layout
- Global header & sidebar using Thymeleaf fragments  
- Shared `footer` fragment used in every page  
- `global.css` for base styling + module-wise CSS:
  - `student.css`
  - `vendor.css`
  - `purchase.css`
  - `inventory.css`
  - `publication.css`
  - `subscription-list.css`
  - `subscription-create.css`
  - `report.css`
- Component-based layout for easy reuse and consistency

---

## 🏗️ Tech Stack

### Backend
- **Java 25**
- **Spring Boot 3.5.7**
- **Spring MVC**
- **Spring Data JPA**
- **Hibernate ORM**
- **MySQL**
- **Jakarta Persistence API**
- **Spring Security** (for login/logout)

### Frontend
- **Thymeleaf** template engine
- **HTML5 / CSS3**
- Component-based header/sidebar/footer
- Global + per-module CSS
- Simple responsive layout

### Architecture
- **Layered Architecture**
  - `Controller` → `Service` → `Repository` → `Entity`
- **MVC (Model–View–Controller)**
- **DDD-style folder structure**, each bounded context in own package:
  - `student/`
  - `vendor/`
  - `purchase/`
  - `inventory/`
  - `publication/`
  - `subscription/`
  - `report/`
- Common utilities & data loaders in `common/`





