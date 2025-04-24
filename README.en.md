# Project Author
## Orlov Andrei

# 🏨 Hotel API

The **Hotel API** is a backend service designed for managing hotel operations. It provides functionalities for handling bookings, user authentication, room management, inventory management, employee management, maintenance, reviews, and much more. This project is built with **Java** and follows modern development practices, including token-based authentication and role-based access control.

---

## ✨ Features

- 🔑 **Authentication and Authorization**
    - User registration and login.
    - JWT-based authentication.
    - Role-based access control (`USER`, `ADMIN`).

- 🏠 **Room Management**
    - View available rooms.
    - Add, update, or delete room details (Admin only).

- 📅 **Booking Management**
    - Create, retrieve, and delete bookings.
    - Role-based restrictions for booking operations.

- 👤 **User Management**
    - Retrieve user details.
    - Update or delete users (Admin only).

- 👥 **Employee Management**
    - Manage employee details (Admin only).

- 📝 **Review System**
    - Allow users to leave reviews for rooms.

- 📦 **Inventory Management**
    - Manage inventory items (Admin only).

- 🛠️ **Maintenance Management**
    - Manage maintenance tasks (Admin only).

---

## 🛠️ Technologies

- **Programming Language**: Java 🟦
- **Framework**: Spring Boot 🍃
- **Authentication**: JWT (JSON Web Tokens) 🔒
- **Database**: PostgreSQL 🛢️ (Docker)
- **Build Tool**: Maven 🛠️
- **API Documentation**: OpenAPI (Swagger) 📘

---

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher ☕
- Maven 📦
- Docker 🐳

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yattorie/hotel-api.git
   cd hotel-api
   ```

2. Configure the application:
    - Update the `application.yml` file with your database credentials and other configurations.

3. Run the database using Docker Compose:
   ```bash
   docker-compose up -d
   ```

   This will start a PostgreSQL container for the database. Ensure the database credentials in your `application.yml` match those in the `docker-compose.yml` file.

4. Build the project:
   ```bash
   mvn clean install
   ```

5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

---

## 📚 API Endpoints

### 🔑 Authentication
| Method | Endpoint                   | Description               | Access   |
|--------|----------------------------|---------------------------|----------|
| POST   | `/api/v1/auth/login`       | User login                | Public   |
| POST   | `/api/v1/auth/registration`| User registration         | Public   |
| POST   | `/api/v1/auth/refresh_token`| Refresh JWT token        | Public   |

### 🏠 Rooms
| Method | Endpoint              | Description                | Access       |
|--------|-----------------------|----------------------------|--------------|
| GET    | `/api/v1/rooms`       | Get all rooms              | Public       |
| GET    | `/api/v1/rooms/{id}`  | Get room by ID             | Public       |
| POST   | `/api/v1/rooms`       | Create a new room          | Admin only   |
| PUT    | `/api/v1/rooms/{id}`  | Update room details        | Admin only   |
| DELETE | `/api/v1/rooms/{id}`  | Delete room                | Admin only   |

### 📅 Bookings
| Method | Endpoint              | Description                | Access       |
|--------|-----------------------|----------------------------|--------------|
| GET    | `/api/v1/bookings`    | Get all bookings           | USER, ADMIN  |
| GET    | `/api/v1/bookings/{id}`| Get booking by ID         | USER, ADMIN  |
| POST   | `/api/v1/bookings`    | Create a new booking       | USER, ADMIN  |
| DELETE | `/api/v1/bookings/{id}`| Delete booking            | USER, ADMIN  |

### 👤 Users
| Method | Endpoint              | Description                | Access       |
|--------|-----------------------|----------------------------|--------------|
| GET    | `/api/v1/users/{id}`  | Get user by ID             | USER, ADMIN  |
| GET    | `/api/v1/users`       | Get all users              | Admin only   |
| POST   | `/api/v1/users`       | Create a new user          | Admin only   |
| PUT    | `/api/v1/users/{id}`  | Update user details        | Admin only   |
| DELETE | `/api/v1/users/{id}`  | Delete user                | Admin only   |

### 👥 Employees
| Method | Endpoint              | Description                | Access       |
|--------|-----------------------|----------------------------|--------------|
| GET    | `/api/v1/employees`   | Get all employees          | Admin only   |
| GET    | `/api/v1/employees/{id}`| Get employee by ID        | Admin only   |
| POST   | `/api/v1/employees`   | Create a new employee      | Admin only   |
| PUT    | `/api/v1/employees/{id}`| Update employee details   | Admin only   |
| DELETE | `/api/v1/employees/{id}`| Delete employee           | Admin only   |

### 📝 Reviews
| Method | Endpoint              | Description                | Access       |
|--------|-----------------------|----------------------------|--------------|
| GET    | `/api/v1/reviews/{id}`| Get review by ID           | USER, ADMIN  |
| GET    | `/api/v1/reviews`     | Get all reviews            | USER, ADMIN  |
| POST   | `/api/v1/reviews`     | Create a new review        | USER, ADMIN  |
| DELETE | `/api/v1/reviews/{id}`| Delete review              | Admin only   |

### 📦 Inventory
| Method | Endpoint              | Description                | Access       |
|--------|-----------------------|----------------------------|--------------|
| GET    | `/api/v1/inventories/{id}` | Get inventory item by ID| Admin only   |
| GET    | `/api/v1/inventories`     | Get all inventory items  | Admin only   |
| POST   | `/api/v1/inventories`     | Create a new inventory item| Admin only |
| PUT    | `/api/v1/inventories/{id}`| Update inventory item    | Admin only   |
| DELETE | `/api/v1/inventories/{id}`| Delete inventory item    | Admin only   |

### 🛠️ Maintenance
| Method | Endpoint                  | Description                   | Access       |
|--------|---------------------------|-------------------------------|--------------|
| GET    | `/api/v1/maintenances`    | Get all maintenance tasks     | USER, ADMIN  |
| GET    | `/api/v1/maintenances/{id}`| Get maintenance task by ID    | USER, ADMIN  |
| POST   | `/api/v1/maintenances`    | Create a new maintenance task | Admin only   |
| PUT    | `/api/v1/maintenances/{id}`| Update maintenance task       | Admin only   |
| DELETE | `/api/v1/maintenances/{id}`| Delete maintenance task       | Admin only   |
