<h1>📊 Cégkezelő webalkalmazás</h1>
<h3>Beadandó webalkalmazás - Nyíregyházi Egyetem, Programozási Környezetek (BPI1223)</h3>

<h2>👨‍💻Fontos adatok:</h2>
<h5>Vincze Marcell; Programozási Környezetek (BPI1223); 2024/2025/II. félév</h5>

<h2>📖 Leírás</h2>
<p>Webalkalmazás Spring Boot és MySQL technológiák felhasználásával, amely lehetőséget nyújt cégek és alkalmazottaik kezelésére egy Bootstrap-alapú, reszponzív felületen.</p>

<h2>🚀 Funkcionalitás</h2>
<ul>
  <li>Cégek és alkalmazottak CRUD műveletei (Create, Read, Delete)</li>
  <li>Két entitás kapcsolata: Egy céghez több alkalmazott tartozhat</li>
  <li>Reszponzív, modern felület Bootstrap 5-tel</li>
  <li>MySQL adatbázis támogatás</li>
  <li>Thymeleaf template engine használata</li>
</ul>

<h2>🗂️ Entitások (JPA osztályok)</h2>

<h3><code>Company</code></h3>
<pre><code>@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
}
</code></pre>

<h3><code>Employee</code></h3>
<pre><code>@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
</code></pre>

<h2>🧩 Adatbázis (MySQL)</h2>

<pre><code>CREATE TABLE company (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    location VARCHAR(255)
);

CREATE TABLE employee (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    position VARCHAR(255),
    company_id BIGINT,
    FOREIGN KEY (company_id) REFERENCES company(id)
);
</code></pre>

<h2>💻 Frontend</h2>
<ul>
  <li>Bootstrap 5 alapú reszponzív design</li>
  <li>Középre igazított táblázatok és űrlapok</li>
  <li>Navigációs sáv cégek és alkalmazottak kezeléséhez</li>
  <li>Layout fájl használatával egységes megjelenés</li>
</ul>

<h2>📂 Projektstruktúra</h2>
<pre><code>src/
├── main/
│   ├── java/org/beadando/company/
│   │   ├── controller/
│   │   ├── model/
│   │   ├── repository/
│   │   └── service/
│   └── resources/
│       ├── templates/
│       │   ├── companies.html
│       │   ├── employees.html
│       │   └── layout.html
│       ├── static/
│       │   └── style.css
│       └── application.properties
</code></pre>

<h2>⚙️ Konfiguráció</h2>

<h3><code>application.properties</code></h3>
<pre><code>spring.application.name=company
spring.datasource.url=jdbc:mysql://localhost:3306/beadando_company
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
</code></pre>