# RRAI-ENGINE — Royalty Rescue AI Backend

Spring Boot REST API powering the RRAI Customer Portal emergency incident intake system.

---

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Framework | Spring Boot 4.1.2 |
| Language | Java 17 |
| Database | PostgreSQL (Supabase) |
| ORM | Spring Data JPA / Hibernate |
| Build | Maven |

---

## API Endpoints

Base path: `/api`

### `POST /api/incidents`
Submit a new emergency incident.

**Request body:**
```json
{
  "callerName": "John Doe",
  "callerPhone": "+234 801 234 5678",
  "locationDescription": "Near Wuse Market, Abuja",
  "lga": "Municipal Area Council",
  "emergencyType": "cardiac",
  "presentingComplaint": "Chest pains and difficulty breathing",
  "personsAffected": 1,
  "prefferedLanguage": "en",
  "consentGiven": true
}
```

**Response `201 Created`:**
```json
{
  "incidentId": "uuid",
  "referenceNumber": "RRAI-A1B2C3D4",
  "status": "OPEN",
  "message": "Incident reported Successfully"
}
```

---

### `GET /api/incidents`
List all incidents.

**Response `202`:** Array of `Incident` objects.

---

### `GET /api/incidents/{refnumber}`
Look up a single incident by reference number (e.g. `RRAI-A1B2C3D4`).

**Response `202`:** Single `Incident` object.

---

### `PATCH /api/incidents/{refnumber}`
Update the status of an incident.

**Request body:** raw status string, e.g. `"RESOLVED"`

**Response `202`:** Updated `Incident` object.

---

## Project Structure

```
src/main/java/com/tarun/rraibackend/
├── controllers/
│   ├── IncidentPortal.java     # REST controller — all /api/incidents endpoints
│   └── CorsConfig.java         # CORS configuration (allows localhost:3000)
├── service/
│   └── IncidentService.java    # Business logic, reference number generation
├── model/
│   └── Incident.java           # JPA entity (Builder pattern)
├── repo/
│   └── IncidentRepo.java       # Spring Data JPA repository
├── DTO/
│   ├── IncidentRequestDto.java # Intake request shape
│   └── IncidentResponseDto.java# POST response shape
└── RraiBackendApplication.java # Entry point
```

---

## Running Locally

### Prerequisites
- Java 17+
- Maven (or use the included `./mvnw` wrapper)
- PostgreSQL database (project uses Supabase — configure your own in `application.properties`)

### Setup

1. Clone the repo:
   ```bash
   git clone https://github.com/tarun0306/RRAI-ENGINE.git
   cd RRAI-ENGINE
   ```

2. Create `src/main/resources/application.properties` from the example:
   ```bash
   cp src/main/resources/application.properties.example src/main/resources/application.properties
   ```
   Fill in your database credentials.

3. Run:
   ```bash
   ./mvnw spring-boot:run
   ```

Server starts on **http://localhost:8080**.

---

## Environment Configuration

Database and server settings live in `src/main/resources/application.properties` (git-ignored).  
See `application.properties.example` for the required keys.

---

## Frontend Integration

This backend is consumed by the [RRAI Customer Portal](https://github.com/tarun0306/RRAI) Next.js frontend.  
The frontend proxies all `/api/incidents` calls through its own Next.js API routes, which handle the snake_case ↔ camelCase field mapping.

---

## Reference Number Format

Each incident gets a unique reference number generated server-side:

```
RRAI-{8 uppercase hex chars}
Example: RRAI-A1B2C3D4
```
