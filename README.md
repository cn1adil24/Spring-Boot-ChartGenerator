# Spring Boot Chart Generator using JFreeChart

This Spring Boot project demonstrates a simple application that reads existing CSV/XLS files from the project directory, writes them to an H2 database, and provides an endpoint to generate a PDF containing charts based on data stored in the database.

## Sample Generated Report

A sample generated report is included in this repository for your reference. This report serves as an example of what the application can produce when you access the chart PDF generation endpoint.

## Usage
### Generating PDF with Charts

1. Access the chart PDF generation endpoint:

    ```
    GET http://localhost:8080/report/generate
    ```

2. The application will fetch data from the H2 database and generate a PDF containing pie and ring charts based on the data

### Additional Endpoints

- **Pie Chart Data**: Access the pie chart data.

    ```
    GET http://localhost:8080/report/pie
    ```

- **Ring Chart Data**: Access the ring chart data.

    ```
    GET http://localhost:8080/report/ring
    ```
> Note: Ensure that the CSV/XLS files are already included in the project's repository.

## Technologies Used

- **Spring Boot**: A Java-based framework for building backend applications.
- **Spring Data JPA**: Simplifies database operations and management.
- **H2 Database**: An in-memory database for development and testing.
- **JFreeChart**: A powerful Java library for creating a wide range of charts.
- **Apache POI**: Used for processing XLS files.
- **iText**: Used for generating PDF documents.
