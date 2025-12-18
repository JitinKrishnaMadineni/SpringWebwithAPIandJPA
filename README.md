# SpringWebwithAPIandJPA
Implemented Spring Boot Restful APIs CRUD operations with layered architecture, JPA repository, Validation Annotations, Custom Annotations, Global Exception Handling, Custom API Response Wrapper
Enhancing Spring Boot APIs with Robust Exception Handling and Clean Architecture!

I recently implemented a comprehensive global exception handling mechanism in a Spring Boot project to improve API reliability and client communication.

* **Global Exception Handler:** Using `@RestControllerAdvice` to centralize error handling across all REST controllers.
* **Custom API Response Structure:** Introduced an `ApiResponse` wrapper class for consistent response format across success and error cases.
* **Detailed Error Reporting:** Created an `ApiError` model to provide clear HTTP status, error messages, and detailed sub-errors (e.g., validation issues).
* **Validation Handling:** Captured `MethodArgumentNotValidException` to relay precise validation failure reasons back to API clients.
* **Specific Exception Mapping:** Custom handling for `ResourceNotFoundException` to return meaningful 404 responses.
* **Fallback for Unhandled Exceptions:** Generic exception handler returning HTTP 500 with error details.
* **Clean, Reusable Code:** Leveraged a private method for building error responses to maintain DRY principles.

This approach ensures robust API feedback, improves frontend-backend communication, and provides a solid foundation for scalable RESTful services.

This project/module demonstrates a clean and effective global exception handling strategy for Spring Boot REST APIs, improving error response consistency and developer experience.

Features:

* **Global Exception Handler:**

  * Implemented via `@RestControllerAdvice` to capture exceptions thrown by any REST controller.

* **Custom API Response Wrapper:**

  * `ApiResponse<T>` wraps all API responses (both success and error) ensuring a consistent format.

* **Detailed API Error Object:**

  * `ApiError` encapsulates:

    * HTTP status code (`HttpStatus`)
    * User-friendly error message
    * Optional list of sub-errors (e.g., field validation errors)

* **Exception Handlers:**

  * `ResourceNotFoundException` → Returns HTTP 404 Not Found.
  * `MethodArgumentNotValidException` → Returns HTTP 400 Bad Request with detailed validation messages.
  * Fallback `Exception` handler → Returns HTTP 500 Internal Server Error.
