# Spring Microservices Project
### Project Overview

This project employs a microservices architecture using Spring Boot and Spring Cloud, featuring essential components like Config Server, API Gateway, and Service Registry. It includes specialized services such as Lesson Service, 
managing educational content, and Student Service, handling student data. Utilizing multiple relationships between entities, such as lessons and students, enhances data management efficiency and supports complex operations 
seamlessly across distributed systems. This architecture ensures scalability, modularity, and robust performance, leveraging Spring Cloud for service registration, discovery, and tracing capabilities with Zipkin.

This project consists of multiple Spring-based microservices:

- Config Server: Manages centralized configuration settings for microservices.
- API Gateway: Manages and routes external requests to microservices.
- Lesson Service: Manages lesson information.
- Student Service: Manages student information.
- Service Registry: Allows microservices to register and discover each other

## Dependencies
- Java Version: 17
- Spring Cloud Version: 2023.0.0
- Spring Cloud Config Server
- Zipkin Reporter Brave
- Micrometer Tracing Bridge Brave
- Spring Boot Starter Test
- Spring Cloud Starter Config
- Spring Cloud Starter Gateway MVC
- Netflix Eureka Server

## API Endpoints

### Lesson Service

- Add a Lesson:
    - URL: `/lesson`
    - Method: `POST`
    - Description: Adds a new lesson.
    - Example Request:
      ```sh
      curl -X POST http://localhost:8080/lesson -H "Content-Type: application/json" -d '{"name": "Mathematics"}'
      ```
- Get Lesson by ID:
    - URL: `/lesson/{id}`
    - Method: `GET`
    - Description: Retrieves the lesson with the specified ID.
    - Example Request:
      ```sh
      curl -X GET http://localhost:8080/lesson/1
      ```
- Get All Lessons:
    - URL: `/lesson`
    - Method: `GET`
    - Description: Retrieves all lessons.
    - Example Request:
      ```sh
      curl -X GET http://localhost:8080/lesson
      ```
- Get All Lessons with Students:
    - URL: `/lesson/with-students`
    - Method: `GET`
    - Description: Retrieves all lessons along with the students enrolled in each lesson.
    - Example Request:
      ```sh
      curl -X GET http://localhost:8080/lesson/with-students
      ```
- Get Lesson by ID:
    - URL: `/lesson/notification`
    - Method: `POST`
    - Description: Sends a new lesson notification.
    - Example Request:
      ```sh
      curl -X POST http://localhost:8080/lesson/notification -H "Content-Type: application/json" -d '{"name": "Physics"}'
      ```
      
## Student Service

- Add a Student:
    - URL: `/student`
    - Method: `POST`
    - Description: Adds a new student.
    - Example Request:
      ```sh
      curl -X POST http://localhost:8080/student -H "Content-Type: application/json" -d '{"name": "John Doe"}'
      ```
- Get Student by ID:
    - URL: `/student/{id}`
    - Method: `GET`
    - Description: Retrieves the student with the specified ID.
    - Example Request:
      ```sh
      curl -X GET http://localhost:8080/student/1
      ```
- Get All Students:
    - URL: `/student`
    - Method: `GET`
    - Description: Retrieves all students.
    - Example Request:
      ```sh
      curl -X GET http://localhost:8080/student
      ```
- Get Students by Lesson ID:
    - URL: `/student/lesson/{lessonId}`
    - Method: `GET`
    - Description: Retrieves students enrolled in the specified lesson.
    - Example Request:
      ```sh
      curl -X GET http://localhost:8080/student/lesson/1
      ```

### License
This project is licensed under the MIT License.













