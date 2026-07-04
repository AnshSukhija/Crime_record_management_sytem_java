# 🔍 Crime Record Management System 📑

An interactive, GUI-based desktop application built using **Java** to streamline, track, and analyze crime data records. This project demonstrates core Object-Oriented Programming (OOP) architectures, graphical user interfaces (Swing/AWT), file operations, and data analysis in Java.

---

## 🚀 Features

* 🔐 **Secure Role-Based Access:** Dedicated logic for administrators and general users utilizing abstract class inheritance.
* 🖥️ **Interactive GUIs:** Clean, user-friendly desktop interfaces for logging in and interacting with the central dashboard.
* 📊 **Crime Data Analytics:** Built-in analyzer engine to scan historical logs and pinpoint high-risk or crime-prone areas.
* 💾 **Persistent File Storage:** Seamlessly reads and writes records locally using robust file I/O operations so no data is lost on exit.
* 🧩 **OOP Foundation:** Implements clean software engineering principles like encapsulation, inheritance, and abstraction.

---

## 📂 Project Structure & Component Breakdown

Based on the repository files, here is how the core architecture connects:

| File Name | Purpose & Responsibility |
| --- | --- |
| 🛡️ `Admin.java` | Manages elevated administrative privileges and system controls. |
| 🧬 `User.java` | The base abstract user class defining core authentication methods. |
| 🔍 `CrimeAnalyzer.java` | The analytical engine used to process data and discover crime patterns. |
| 🗃️ `CrimeRecord.java` | The blueprint object holding specific attributes for individual crime logs. |
| 💾 `FileHandler.java` | Manages file reading and writing streams to persist records on your disk. |
| 🖥️ `CrimeRecordsSystemGUI.java` | The introductory window serving as the login and gateway to the application. |
| 📊 `CrimeDashboardGUI.java` | The primary operational dashboard for visualizing, adding, and auditing records. |

---

## ⚙️ Prerequisites & Setup

To run this system locally on your machine, ensure you have the **Java Development Kit (JDK 8 or higher)** installed.

### 1. Clone the Repository

```bash
git clone https://github.com/AnshSukhija/Crime_record_management_sytem_java.git

```

### 2. Navigate to the Source Folder

```bash
cd Crime_record_management_sytem_java

```

### 3. Compile the Application

Compile all `.java` files together using your terminal:

```bash
javac *.java

```

### 4. Launch the App

Run the main entry GUI file to fire up the system:

```bash
java CrimeRecordsSystemGUI

```

---

## 🛠️ Tech Stack & Concepts Explored

* **Language:** Java (JDK 8+)
* **GUI Framework:** Java Swing / AWT
* **Data Persistence:** Java File I/O (`java.io`)
* **Core Paradigms:** Inheritance, Encapsulation, Polymorphism, and File-Based Data Management.

---

## 🤝 Contributing

Have ideas to make this project even better?

1. **Fork** the repository.
2. Create a feature branch (`git checkout -b feature/AmazingFeature`).
3. **Commit** your refinements (`git commit -m 'Add some AmazingFeature'`).
4. **Push** to the branch (`git push origin feature/AmazingFeature`).
5. Open a **Pull Request**!

Developed with 💻 and ☕ by [AnshSukhija](https://www.google.com/search?q=https://github.com/AnshSukhija).
