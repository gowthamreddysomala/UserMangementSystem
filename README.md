   # 🚀 UserManagementAPI


ATTENTION DEVELOPERS!
This project, for ease of initial setup and local development, may contain default database credentials in src/main/resources/application.properties (or application.yml). An example for PostgreSQL is shown below, but the same principles apply to any production database like MariaDB.

# ⚠️ DO NOT USE THESE DEFAULTS IN PRODUCTION! ⚠️
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver


<p align="center">
  <b>Robust, scalable, and modern REST API for user management built with Spring Boot</b>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/build-passing-brightgreen" alt="Build Status"/>
  <img src="https://img.shields.io/badge/tests-passing-brightgreen" alt="Tests"/>
  <img src="https://img.shields.io/badge/java-17-blue" alt="Java Version"/>
  <img src="https://img.shields.io/badge/spring--boot-3.0+-blueviolet" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/database-PostgreSQL-blue" alt="Database"/>
</p>

---

## 📑 Table of Contents
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Quick Start](#-quick-start)
- [Setup Instructions](#-setup-instructions)
- [Running Tests](#-running-tests)
- [API Documentation](#-api-documentation)
- [FAQ](#-faq)
- [Contributing](#-contributing)
- [Acknowledgements](#-acknowledgements)
- [Contact & Community](#-contact--community)

---

## ✨ Features

| Feature                | Description                                      |
|------------------------|--------------------------------------------------|
| User CRUD              | Create, read, update, and delete users           |
| Bulk User Creation     | Add multiple users in a single request           |
| Pagination             | List users with pagination support               |
| Input Validation       | Ensures data integrity and correctness           |
| Mock Data Loading      | Load mock users for testing/demo                 |
| Comprehensive Testing  | JUnit & MockMvc test coverage                    |

---

## 🛠️ Tech Stack

| Layer      | Technology                        |
|------------|-----------------------------------|
| Backend    | Java 17, Spring Boot 3, Spring Data JPA |
| Database   | PostgreSQL (configurable)         |
| Testing    | JUnit 5, Spring Boot Test, MockMvc|
| Build Tool | Maven                             |

---

## ⚡ Quick Start

```bash
git clone https://github.com/aadityakumar08/UserManagementAPI.git
cd UserManagementAPI
mvn spring-boot:run
```

---

## ⚙️ Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/aadityakumar08/UserManagementAPI.git
   cd UserManagementAPI
   ```
2. **Configure the database**
   - Edit `src/main/resources/application.properties` with your PostgreSQL credentials.
3. **Build the project**
   ```bash
   mvn clean install
   ```
4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

---

## 🧪 Running Tests

```bash
mvn test
```

---

## 📚 API Documentation

### User CRUD

| Method | Endpoint                  | Description                | Body Example |
|--------|---------------------------|----------------------------|--------------|
| POST   | `/api/users`              | Create a new user          | `{ "name": "John Doe", "email": "john@example.com" }` |
| POST   | `/api/users/multiple`     | Create multiple users      | `[ { "name": "Alice", "email": "alice@example.com" }, ... ]` |
| GET    | `/api/users`              | Get all users              |              |
| GET    | `/api/users/{id}`         | Get user by ID             |              |
| PUT    | `/api/users/{id}`         | Update user                | `{ "name": "New Name", "email": "new@example.com" }` |
| DELETE | `/api/users/{id}`         | Delete user                |              |
| GET    | `/api/users/mock`         | Get mock users             |              |
| GET    | `/api/users/page`         | Get paginated users        |              |

#### Example: Create User (cURL)
```bash
curl -X POST http://localhost:8080/api/users \
  -H 'Content-Type: application/json' \
  -d '{ "name": "John Doe", "email": "john@example.com" }'
```

#### Example: Bulk Create Users (cURL)
```bash
curl -X POST http://localhost:8080/api/users/multiple \
  -H 'Content-Type: application/json' \
  -d '[{"name": "Alice", "email": "alice@example.com"}, {"name": "Bob", "email": "bob@example.com"}]'
```

---

## ❓ FAQ

**Q: How do I change the database?**  
A: Edit your `application.properties` file with your new database credentials.

**Q: How do I run tests?**  
A: Use `mvn test` from the project root.

**Q: Can I use a different database?**  
A: Yes! Spring Data JPA supports many databases. Update your configuration accordingly.

---

## 🤝 Contributing

1. **Fork** the repo and create your branch from `main` or `testing`.
2. **Make your changes** and add tests.
3. **Ensure all tests pass:**
   ```bash
   mvn test
   ```
4. **Submit a pull request** with a clear description.

For more details, see [CONTRIBUTING.md](CONTRIBUTING.md).

---

## 🙏 Acknowledgements
- Spring Boot & Spring Data JPA documentation
- Open source community for inspiration

---

## 📫 Contact & Community

- **Author:** Gowtham Reddy
- [LinkedIn](https://www.linkedin.com/in/gowthamreddysomala/)  
- [GitHub](https://github.com/gowthamreddysomala)  
- [Open an Issue]* for questions or suggestions

--- 
