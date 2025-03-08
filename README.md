# Customer Management System (Mini CRM) 🏢

A simple customer management system built with **Java Spring Boot**, **Vue.js**, **PostgreSQL**, and **Docker**. This project allows users to **add, update, delete, and search for customers**, serving as a basic **mini CRM**.

## Features ✨

✅ RESTful API with **Spring Boot**✅ Frontend built with **Vue.js**✅ PostgreSQL for database management✅ Docker support for easy deployment✅ CRUD operations for customer management

## Technologies Used 🔧

- **Backend:** Java Spring Boot, Spring Data JPA, Hibernate
- **Frontend:** Vue.js, Axios
- **Database:** PostgreSQL
- **Deployment:** Docker, Docker Compose

## How to Run 🚀

### 1. Clone the Repository

```sh
git clone https://github.com/your-username/mini-crm.git
cd mini-crm
```

### 2. Start the Backend

```sh
cd backend  
mvn spring-boot:run  
```

### 3. Start the Frontend

```sh
cd frontend  
npm install  
npm run dev  
```

### 4. Open the Application

Visit `http://localhost:5173` in your browser.

## API Endpoints 🌐

| Method | Endpoint              | Description               |
| ------ | --------------------- | ------------------------- |
| GET    | `/api/customers`      | Retrieve all customers    |
| GET    | `/api/customers/{id}` | Retrieve a customer by ID |
| POST   | `/api/customers`      | Add a new customer        |
| PUT    | `/api/customers/{id}` | Update a customer         |
| DELETE | `/api/customers/{id}` | Delete a customer         |

## Future Improvements 🚀

📌 Authentication & Role-based Access📌 Pagination & Filtering📌 UI Enhancements

## License 📜

This project is licensed under the MIT License.
