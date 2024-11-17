
# Spring Boot GraphQL Application

This repository demonstrates a simple implementation of a **GraphQL API** using **Spring Boot**. The project serves as a starting point for creating scalable and efficient APIs using the GraphQL query language within the Spring ecosystem.

---

## Features

- **GraphQL API** implementation with queries, mutations, and custom types.
- Modular project structure for easier scalability and maintenance.
- Example schema showcasing typical CRUD operations.
- Integrated error handling for better developer experience.
- Lightweight, modern setup with Spring Boot.

---

## Prerequisites

- **Java**: Ensure you have JDK 17+ installed.
- **Maven**: For managing dependencies and building the project.

---

## Getting Started

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/marcinzygmunt-pl/spring-boot-graphql.git
   cd spring-boot-graphql
   ```

2. **Build the Project**:
   Run the following Maven command to build the project:
   ```bash
   mvn clean install
   ```

3. **Run the Application**:
   Start the application using:
   ```bash
   mvn spring-boot:run
   ```

4. **Access GraphQL Playground**:
   Once the application is running, navigate to:
   ```
   http://localhost:8080/graphql
   ```
    And for GUI tool to:
    ```
   http://localhost:8080/graphiql?path=/graphql
   ``` 

---

## Example Schema

Below is an example schema used in the project:

```graphql
type Query {
    getCompany(id: UUID!): Company
    listCompanies: [Company!]
}

type Mutation {
    createCompany(input: CompanyInput!): Company
    updateCompany(id: UUID!, input: CompanyInput!): Company
    deleteCompany(id: UUID!): Boolean
}

type Company {
    id: UUID!
    name: String!
    address: String
    employees: Int
}

input CompanyInput {
    name: String!
    address: String
    employees: Int
}
```

---

## Example Queries and Mutations

### Query a Single Company
```graphql
query GetCompany {
    getCompany(id: "123e4567-e89b-12d3-a456-426614174000") {
        id
        name
        address
    }
}
```

### List All Companies
```graphql
query ListCompanies {
    listCompanies {
        id
        name
        employees
    }
}
```

### Create a New Company
```graphql
mutation CreateCompany {
    createCompany(input: {
        name: "TechCorp"
        address: "123 Tech Street"
        employees: 50
    }) {
        id
        name
    }
}
```

### Delete a Company
```graphql
mutation DeleteCompany {
    deleteCompany(id: "123e4567-e89b-12d3-a456-426614174000")
}
```

---

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.marcinzygmunt.graphql/
│   │       ├── controllers/
│   │       ├── models/
│   │       ├── repositories/
│   │       ├── services/
│   └── resources/
│       ├── application.yml    # Application configuration
│       ├── schema.graphqls    # GraphQL schema
```

---

## Contributing

Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a feature branch: `git checkout -b feature-name`.
3. Commit changes: `git commit -m "Description of changes"`.
4. Push to your branch: `git push origin feature-name`.
5. Open a pull request.

---


Feel free to explore, contribute, and provide feedback! 🚀
