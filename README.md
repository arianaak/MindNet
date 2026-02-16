🧠 MindNet - Cognitive Support & Memory Archive

MindNet este o aplicație full-stack dezvoltată în Java Spring Boot, concepută pentru a sprijini persoanele cu deficiențe cognitive în arhivarea amintirilor și menținerea rutinelor zilnice, oferind în același timp un portal de supraveghere clinică pentru îngrijitori.

✨ Funcționalități Principale

Arhivă Cognitivă (Journal): Permite pacienților să salveze amintiri cu text și imagini (suport Base64 direct din clipboard).

Planificator Săptămânal: Un calendar interactiv pentru gestionarea medicației și a activităților recurente.

Portal pentru Îngrijitori: Panou de administrare pentru monitorizarea notelor medicale și gestionarea conturilor pacienților.

Audit Trail: Jurnal de activitate în timp real pentru monitorizarea thread-urilor de sistem și securitate.

🛠️ Detalii Tehnice & Cerințe Îndeplinite

Backend: Java 17+, Spring Boot, Spring Data JPA.

Baza de Date: H2 cu persistență pe fișier (datele se salvează local în /data).

Securitate: Spring Security cu RBAC (Role-Based Access Control) și criptare BCrypt.

Sisteme & Networking: - Multi-threading: Thread-uri de fundal pentru monitorizarea integrității.

Sockets: Diagnostic ServerSocket pe Portul 8888.

Validare: Validare strictă a datelor (Jakarta Validation) pentru a preveni înregistrările incomplete.

Testare: Unit Testing cu JUnit 5 pentru verificarea modelelor și logică de business.

🚀 Cum se rulează

Clonează repozitoriul: git clone https://github.com/utilizator/MindNet.git

Deschide proiectul în IntelliJ IDEA.

Asigură-te că ai Java 17+ configurat.

Rulează aplicația (DemoApplication.java).

Accesează: http://localhost:8080 (Login implicit: admin / admin123).

Proiect dezvoltat ca parte a cerințelor de laborator pentru Sisteme Informatice.
