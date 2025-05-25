📚 Library Management System (MVC)
A Java-based Library Management System utilizing the Model-View-Controller (MVC) design pattern. This project is ideal for efficiently managing library resources, users, and transactions, and offers a modular, scalable architecture suitable for educational or practical deployment.

🚀 Features
User Authentication & Role-Based Access
Admin, Librarian, Student roles
Book Catalog Management
Add, update, delete, search books
Issue & Return Book Functionality
Fine Calculation for overdue books
Member Management
Add, update, remove members
Transaction History & Reporting
MVC Architecture for clean separation of concerns
🛠 Technologies & Libraries Used
Java (Core)
External Libraries:
RSCalendar.jar
RSFoto_v1.0.jar
MySQL Connector/J (version 9)
IDE: NetBeans
GUI: Java Swing/AWT or JavaFX (specify which, if applicable)
Database: MySQL
Build Tool: Managed via NetBeans project structure
🏁 Getting Started
Prerequisites
Java Development Kit (JDK 8 or higher)
MySQL Database
NetBeans IDE (recommended)
External libraries:
RSCalendar.jar
RSFoto_v1.0.jar
mysql-connector-java-9.x.x.jar
Add these to your project’s library list
Setup Instructions
1. Clone the Repository:

bash
git clone https://github.com/ihshan001/Library-Management-System-MVC-.git
cd Library-Management-System-MVC-
2. Open with NetBeans:

Open NetBeans IDE
Go to File > Open Project and select the cloned folder
3. Add Libraries:

Right-click the project in NetBeans
Choose Properties > Libraries > Add JAR/Folder
Add RSCalendar.jar, RSFoto_v1.0.jar, and mysql-connector-java-9.x.x.jar
4. Configure the Database:

Create a MySQL database (e.g., library_db)
Import the provided SQL schema (if available)
Update the database connection settings in the project files
(e.g., in db.properties or the relevant Java class)
5. Build and Run the Project:

Right-click the project and select Run in NetBeans
6. Login:

Use default credentials (if set) or create a new admin user
📂 Project Structure
Code
src/
│
├── controller/
├── model/
├── view/
├── util/
└── Main.java
controller/ — Handles user input and application logic
model/ — Represents the data and business rules
view/ — Manages the GUI
util/ — Utility classes (e.g., database connection)
🤝 Contributing
Fork the repo
Create your feature branch:
bash
git checkout -b feature/YourFeature
Commit your changes:
bash
git commit -am 'Add some feature'
Push to the branch:
bash
git push origin feature/YourFeature
Open a Pull Request
⚖️ License
This project is licensed under the MIT License.
See LICENSE for details.

👤 Author
ihshan001
GitHub Profile
