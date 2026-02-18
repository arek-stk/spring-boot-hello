**📘 Spring Boot Hello API**
**📌 Beschreibung**

Dies ist mein erstes Projekt mit Spring Boot.
Ich habe damit die Grundlagen von REST APIs, JSON Verarbeitung, Service-Schicht und Datenbank-Anbindung gelernt.

Das Projekt ist eine einfache API zum Speichern und Abrufen von Namen.

🚀 Was ich in diesem Projekt umgesetzt habe
✅ Spring Boot REST API

Controller mit GET und POST Endpoints

JSON Request & Response

DTO Klassen (Request / Response)

✅ Service Layer

Trennung von Controller und Business Logik

Datenverarbeitung im Service

✅ H2 Datenbank

In-Memory Datenbank

Speicherung von Namen in Tabelle

Zugriff über JPA Repository

H2 Console zum Anzeigen der Daten

🧩 Technologien

Java

Spring Boot

Spring Web

Spring Data JPA

H2 Database

Maven

▶ Projekt starten
1️⃣ Projekt öffnen

Projekt in IntelliJ öffnen.

2️⃣ Anwendung starten

Starte:

HelloApplication.java


Oder über Terminal:

mvn spring-boot:run

🌐 API Endpoints
➜ POST Name speichern
POST /hello

Request JSON:
{
  "name": "Arek"
}

Response:
{
  "message": "Hallo Arek!",
  "count": 1
}

➜ GET Namen abrufen
GET /hello

Response:
{
  "names": ["Arek"],
  "count": 1
}

🗄 H2 Datenbank Console

Im Browser öffnen:

http://localhost:8080/h2-console/

Login Daten
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (leer)

**🎯 Ziel des Projekts**

Grundlagen von Backend Entwicklung mit Spring Boot verstehen und praktisch umsetzen.

🔜 Nächste Schritte

 CRUD API erweitern

 Dauerhafte Datenbank Speicherung

 Unit & Integration Tests

 Security Basics (Login / Auth)

 API Dokumentation (Swagger)
