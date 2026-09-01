# RentaCar

RentaCar is a Spring Boot web application for managing a car rental business. It provides a complete business workflow for handling customers, vehicle inventory, reservation scheduling, and payment records in a single MVC application.

## Features

### 1. Dashboard
- Overview screen with key business metrics
- Quick access to customers, vehicles, reservations, and payments
- Modern dashboard layout using Thymeleaf templates and custom CSS

### 2. Customer Management
- Add new customers
- Edit customer information
- View customer list
- Delete customers
- Customer details include first name, last name, email, phone, license number, and address

### 3. Vehicle Management
- Add new vehicles
- Update vehicle details
- Manage vehicle status such as AVAILABLE, RENTED, and MAINTENANCE
- Track make, model, type, plate number, and daily rate

### 4. Reservation Management
- Create rental reservations
- Select customer and vehicle
- Set reservation start and end dates
- Automatically calculate total price based on daily rate and rental duration
- Track reservation status such as PENDING or CONFIRMED

### 5. Payment Management
- Record payment for each reservation
- Track payment amount, method, and status
- Link payment directly to a reservation

### 6. Data Seeding
- Sample data is loaded automatically on startup through the `DataSeeder`
- Pre-filled customers, vehicles, and reservation records help demonstrate the system quickly

## Tech Stack

- Java 21
- Spring Boot 3.2.11
- Spring Web MVC
- Thymeleaf
- Spring Data JPA
- MySQL 8
- Maven
- JUnit 5 + Mockito

## Project Structure

```text
prj/RentaCar/
├── pom.xml
├── README.md
├── screenshots/
├── src/
│   ├── main/
│   │   ├── java/com/example/rentacar/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   ├── RentaCarApplication.java
│   │   │   └── DataSeeder.java
│   │   ├── resources/
│   │   │   ├── static/css/styles.css
│   │   │   ├── templates/
│   │   │   └── application.properties
│   └── test/java/com/example/rentacar/
│       ├── controller/
│       ├── repository/
│       └── service/
└── target/
```

## Main Modules

- `controller` — handles MVC pages and request routing
- `model` — entity classes such as Customer, Vehicle, Reservation, and Payment
- `repository` — JPA repositories for database access
- `service` — booking logic, pricing calculation, and business validation
- `templates` — Thymeleaf HTML pages for the UI
- `static/css` — styling for the app

## Run the Application

1. Open a terminal
2. Go to the project folder:

```bash
cd /Users/uyenhoang/Documents/MIU/SE/src/CS425SE/prj/RentaCar
```

3. Start MySQL locally (Docker):

```bash
docker run --name rentacar-mysql \
  -e MYSQL_DATABASE=rentacar \
  -e MYSQL_ROOT_PASSWORD=root \
  -p 3306:3306 \
  -d mysql:8.0
```

4. Set Java 21:

```bash
export JAVA_HOME=/usr/local/Cellar/openjdk@21/21.0.11/libexec/openjdk.jdk/Contents/Home
export PATH="$JAVA_HOME/bin:$PATH"
```

5. Run the app:

```bash
mvn spring-boot:run
```

6. Open the browser at:

```text
http://localhost:8080/
```

### Database configuration
The app uses MySQL with these default values:

```properties
spring.datasource.url=${SPRING_DATASOURCE_URL:jdbc:mysql://localhost:3306/rentacar?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME:root}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD:root}
```

You can connect to the same database with Beekeeper Studio using:

- Host: `localhost`
- Port: `3306`
- Database: `rentacar`
- Username: `root`
- Password: `root`

## Test the Application

Run all tests:

```bash
mvn test
```

Run a specific test:

```bash
mvn test -Dtest=ReservationServiceTest
```

## Screenshots

Store UI screenshots in this folder:

```text
/Users/uyenhoang/Documents/MIU/SE/src/CS425SE/prj/RentaCar/screenshots
```

Recommended screenshot files:
- `home.png`
- `customers-list.png`
- `vehicles-list.png`
- `reservations-list.png`
- `payments-list.png`
- `customer-form.png`

## Default Demo Data

When the application starts, it preloads sample records so the system is usable immediately:
- Sample customers
- Sample vehicles
- Example reservation

## Notes

This application is a monolithic Spring Boot project designed to demonstrate a realistic car rental management workflow while staying simple enough to understand and extend.

The project was renamed from the earlier eRegistrar naming to the current `RentaCar` branding, and the legacy demo loader was updated to a relevant `DataSeeder` implementation.

The application is configured for a full MySQL setup rather than an embedded database, and it is validated to run on Java 21.

## Future Enhancements

- User authentication and role-based access
- Search and filter for reservations
- Reporting and analytics dashboard
- Email notification for bookings
- Deploy to cloud hosting with external MySQL
- REST API support for frontend integration
- Payment methods implementation fully completed.
