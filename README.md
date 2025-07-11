# Redis Rate Limiter

This project demonstrates how to implement a rate limiting mechanism using Redis in a Spring Boot application. It was developed as a learning exercise to understand how to apply rate limiting in backend services.

## What is Rate Limiting?

Rate limiting is used to control the number of requests a client can make to an API within a specific time period. This helps protect services from abuse, manage traffic load, and ensure fair usage across clients.

## Technologies Used

- Java
- Spring Boot
- Redis
- Maven
- Lombok

## How It Works

- Each API request is associated with a key in Redis.
- The request count for the key is incremented on each call.
- If the number of requests exceeds the allowed limit within a defined time window, further requests are rejected.
- Redis automatically expires the key after the time window ends, resetting the count.

## Project Structure

src/
├── main/
│ ├── java/
│ │ └── com.example.redisratelimiter/
│ │ ├── controller/
│ │ ├── service/
│ │ ├── config/
│ │ └── RedisRateLimiterApplication.java
│ └── resources/
│ └── application.yml


## Example Endpoint

A sample controller demonstrates how rate limiting is applied to API calls.

GET /api/test


Repeated requests to this endpoint will trigger rate limiting based on the configuration.

## How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/SumanthBatta/redis-rate-limiter.git
   cd redis-rate-limiter
Start Redis locally:
docker run --name redis -p 6379:6379 redis
Run the Spring Boot application:
./mvnw spring-boot:run
Use Postman or curl to test the API:
curl http://localhost:8080/api/test
Learning Outcomes

Integration of Redis with Spring Boot
Implementation of in-memory rate limiting using Redis counters and expiration
Basic setup and configuration of a Spring Boot application
