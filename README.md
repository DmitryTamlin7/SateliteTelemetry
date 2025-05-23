# 🛰️ Satellite Telemetry Monitoring System

📡 **A web-based system for monitoring satellite telemetry data** in real-time with data filtering, visualization, and persistence.

---

## 🧩 Stack Used

* 🖥️ **Backend**: Java 17, Spring Boot, JPA/Hibernate
* 🌐 **Frontend**: HTML5, JavaScript, Chart.js
* 🐘 **Database**: PostgreSQL
* 🐳 **Containerization**: Docker, Docker Compose
* 🔄 **Streaming**: Apache Kafka

---

## 🚀 Features

* 📥 Receive and store telemetry data from satellite (via REST API or Kafka)
* 📊 View real-time and historical data (temperature, battery, timestamp)
* 🔍 Filter by temperature and battery levels
* 🧪 Unit and integration tests (JUnit)
* 🐋 Easy deployment with Docker Compose

---

## 🛠️ Getting Started

### 📦 Build and Run with Docker

```bash
# Build the backend app
docker build -t telemetry-app .

# Run with PostgreSQL and Kafka using Docker Compose
docker-compose up --build
```

App: [http://localhost:8080](http://localhost:8080)
PostgreSQL: localhost:5432 (user: `postgres`, pass: `postgres`)
Kafka: localhost:9092

---

### 📂 Project Structure

```
SateliteTelemetry/
├── src/
│   └── main/java/com/example/telemetry
│       ├── controller/      # REST controllers
│       ├── model/           # Entity classes
│       ├── service/         # Business logic
│       └── kafka/           # Kafka consumer
├── frontend/                # index.html, script.js, Chart.js
├── Dockerfile               # Backend Docker config
├── docker-compose.yml       # Multi-service definition
├── schema.sql               # DB initialization
├── README.md                # 📘 This file
└── fullscreen.png           # 🖼️ Screenshot of the UI
```

---

## 🐘 PostgreSQL via CLI

```bash
# Open psql shell
psql -h localhost -U postgres

# Show tables
\dt

# Run query
SELECT * FROM telemetry_data;
```

---

## 🧪 Run Tests

```bash
./gradlew test
```

---

## 📬 API Endpoints

* `GET /telemetry` — Get all telemetry
* `POST /telemetry` — Submit new data
* `GET /telemetry/filter?minTemp=20&maxTemp=40&batteryLevel=70`

---

## 📎 License

MIT — free to use for academic or personal projects.

---

🛰️ Built with ☕ and ☁️ for the future of telemetry systems!
