# ASA Banking Client-Server Application

## Table of Contents

-   [Overview](#overview)
-   [Features](#features)
-   [Technologies Used](#technologies-used)
-   [Project Structure](#project-structure)
-   [Installation](#installation)
-   [Usage](#usage)
-   [Architecture](#architecture)
    -   [Design Patterns](#design-patterns)
    -   [Components](#components)
-   [Contributing](#contributing)
-   [Contact](#contact)

## Overview

The **ASA Banking Client-Server Application** is a robust Java-based system designed to simulate a simplified banking environment. It enables clients to securely authenticate, create bank accounts, and perform transactions. Leveraging the **Observer Design Pattern**, the system ensures real-time notifications between the server and its clients, enhancing the responsiveness and interactivity of the application.

## Features

-   **Secure User Authentication:** Users can log in with credentials, receiving session tokens for secure interactions.
-   **Account Management:** Create, manage, and delete bank accounts with specified initial balances.
-   **Transaction Processing:** Facilitate secure transactions between accounts, ensuring data integrity and consistency.
-   **Real-Time Notifications:** Clients receive immediate updates on server state changes and transaction statuses through the Observer pattern.
-   **Modular Architecture:** Clear separation of concerns with distinct components handling specific functionalities.
-   **Extensible Design:** Easily extendable for additional features and services in the future.

## Technologies Used

-   **Java (JDK 8+)**: Core programming language for building the application.
-   **Git**: Version control system for tracking changes and collaboration.
-   **Eclipse/IntelliJ IDEA**: Recommended IDEs for development and debugging.

## Project Structure

```
asa-project/
├── code/
│   ├── target/
│       └── asa-1.jar
│   ├── README.md
│   └── src/main/java/com/alma/
│       ├── App.java
│       ├── attachment/
│       │   ├── Attachment.java
│       │   ├── ProvidedPortRequiredRulesAttachment.java
│       │   └── RequiredPortProvidedRulesAttachment.java
│       ├── banking/
│       │   ├── Account.java
│       │   ├── BankingService.java
│       │   ├── Transaction.java
│       │   └── User.java
│       ├── component/
│       │   ├── ComponentInterface.java
│       │   ├── Component.java
│       │   ├── ProvidedPort.java
│       │   ├── ProvidedService.java
│       │   ├── ProvideInterface.java
│       │   ├── RequiredPort.java
│       │   ├── RequiredService.java
│       │   └── RequireInterface.java
│       ├── configuration/
│       │   └── Configuration.java
│       ├── connector/
│       │   ├── Connector.java
│       │   ├── Glue.java
│       │   ├── ProvideRules.java
│       │   └── RequireRules.java
│       ├── core/
│       │   ├── Port.java
│       │   ├── Rule.java
│       │   └── Service.java
│       ├── observer/
│       │   ├── Observer.java
│       │   └── Subject.java
│       ├── rules/
│       │   ├── RulesInterface.java
│       │   └── RuleType.java
│       └── server_client/
│           ├── Client.java
│           ├── ConnectionManager.java
│           ├── Database.java
│           ├── SecurityManager.java
│           └── Server.java
└── models/
    ├── M1/
    │   ├── M1.aird
    │   ├── M1.ecore
    │   └── M1.png
    └── M2/
        ├── M2.aird
        ├── M2.ecore
        └── M2.png
```

## Installation

### Prerequisites

-   **Java Development Kit (JDK) 8 or higher:** Ensure that Java is installed on your system. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).

### Steps

1. **Clone the Repository**

    ```bash
    git clone https://github.com/salim-atalla/asa.git
    cd asa-project/code/asa/
    ```

2. **Compile the Project**

    The project can be compiled using Maven.

    ```bash
    mvn clean package
    ```

3. **Run the Application**

    After a successful compilation, execute the jar file.

    ```bash
    java -jar target/asa-1.jar
    ```

    **Expected Output:**

    ```
    Application lancée avec succès !
    Simulating interaction between Client and Server...
    Server: State changed, notifying observers...
    Client: Notification from server - Server state has changed.
    Client: Notification from server - Attempting to authenticate user: user1
    Server: User 'user1' authenticated successfully. Session token: user1-TOKEN-12345
    Client: Authenticated successfully. Session token: user1-TOKEN-12345
    Client authenticated successfully.
    Database: Account ACC123 created with balance 1000.0
    Server: Account ACC123 created with initial balance 1000.0
    Client: Notification from server - Account ACC123 created successfully.
    Database: Account ACC456 created with balance 500.0
    Server: Account ACC456 created with initial balance 500.0
    Client: Notification from server - Account ACC456 created successfully.
    Account ACC123: Withdrawn 200.0. New balance: 800.0
    Account ACC456: Deposited 200.0. New balance: 700.0
    Server: Transaction TXN001 completed: Transaction{transactionId='TXN001', fromAccount='ACC123', toAccount='ACC456', amount=200.0}
    Client: Notification from server - Transaction TXN001 completed successfully.
    Simulation completed successfully!
    ```

## Usage

### Functional Workflow

1. **Startup:**

    - The application initializes and sets up the server and client components.
    - The client is registered as an observer of the server.

2. **Authentication:**

    - The client sets its credentials (`username` and `password`).
    - The client authenticates with the server using the `authenticate` method.
    - Upon successful authentication, the client receives a `sessionToken`.

3. **Banking Operations:**

    - **Create Account:** The client can create new bank accounts by specifying an account number and an initial balance.
    - **Perform Transaction:** The client can perform transactions between two accounts by specifying transaction details.

4. **Notifications:**
    - The server sends real-time notifications to the client about the status of operations and any state changes.

### Example Operations

-   **Creating Accounts:**

    ```java
    client.createAccount("ACC123", 1000.0);
    client.createAccount("ACC456", 500.0);
    ```

-   **Performing a Transaction:**

    ```java
    client.performTransaction("TXN001", "ACC123", "ACC456", 200.0);
    ```

## Architecture

The ASA Banking application is built with a modular architecture, ensuring scalability, maintainability, and ease of understanding. The key architectural components and design patterns employed are detailed below.

### Design Patterns

1. **Observer Pattern:**

    - **Purpose:** Facilitates real-time communication between the server and clients.
    - **Implementation:**
        - **Subject (`Server`):** Maintains a list of observers (clients) and notifies them of state changes.
        - **Observer (`Client`):** Receives updates from the server and reacts accordingly.

2. **Singleton Pattern (Optional):**
    - **Purpose:** Ensures that classes like `Database` or `SecurityManager` have only one instance throughout the application lifecycle.
    - **Implementation:** Use private constructors and provide a global access point.

### Components

1. **Core Components (`core` package):**

    - **Service:** Represents the services provided or required by different components.
    - **Port:** Defines the entry and exit points for services.
    - **Rule:** Defines the rules for interactions between connectors.

2. **Connector Components (`connector` package):**

    - **Connector:** Bridges the provided and required interfaces based on defined rules.
    - **Glue:** Manages the binding between different components.

3. **Banking Components (`banking` package):**

    - **Account:** Represents a bank account with an account number and balance.
    - **Transaction:** Represents a banking transaction between accounts.
    - **User:** Represents a system user with credentials.
    - **BankingService:** Interface defining banking operations like creating accounts and performing transactions.

4. **Server-Client Components (`server_client` package):**

    - **Server:** Implements `BankingService` and `Subject`. Manages user authentication, account creation, and transaction processing.
    - **Client:** Implements `Observer`. Handles user interactions, authentication, and initiates banking operations.
    - **ConnectionManager:** Manages user connections and authentication processes.
    - **SecurityManager:** Handles session token generation and validation.
    - **Database:** Manages user credentials and account data.

5. **Observer Components (`observer` package):**

    - **Subject:** Interface for managing observers.
    - **Observer:** Interface for receiving updates from the subject.

6. **Attachment Components (`attachment` package):**

    - **Attachment Classes:** Manage the attachment of rules between provided and required ports.

7. **Configuration Components (`configuration` package):**
    - **Configuration:** Manages application configurations and settings.

## Contributing

Contributions are welcome! To contribute to the ASA Banking application, please follow these steps:

1. **Fork the Repository**

    Click the "Fork" button at the top right of the repository page to create your own fork.

2. **Clone Your Fork**

    ```bash
    git clone https://github.com/votre-utilisateur/asa-banking.git
    cd asa-project/code/src
    ```

3. **Create a New Branch**

    ```bash
    git checkout -b feature/YourFeatureName
    ```

4. **Make Your Changes**

    Implement your feature or fix bugs as needed.

5. **Commit Your Changes**

    ```bash
    git commit -m "Add detailed README and fix authentication flow"
    ```

6. **Push to Your Fork**

    ```bash
    git push origin feature/YourFeatureName
    ```

7. **Create a Pull Request**

    Navigate to the original repository and click "Compare & pull request". Provide a clear description of your changes.

## Contact

**Anis Ait Yacoub**  
Student Master's degree in Computer Science / Software and distributed systems architecture

Email: [anis.ait-yacoub@etu.univ-nantes.fr](mailto:anis.ait-yacoub@etu.univ-nantes.fr)  
GitLab: [https://gitlab.univ-nantes.fr/E235352S/](https://gitlab.univ-nantes.fr/E235352S/)

**Salim Atalla**  
Student Master's degree in Computer Science / Software and distributed systems architecture

Email: [salim.atalla@etu.univ-nantes.fr](mailto:salim.atalla@etu.univ-nantes.fr)  
GitHub: [https://github.com/salim-atalla](https://gitlab.univ-nantes.fr/E191350P)

---

## Acknowledgements

-   Inspired by standard client-server architecture principles.
-   Utilizes design patterns for efficient and maintainable code structure.

---

**Happy Coding!** 🚀
