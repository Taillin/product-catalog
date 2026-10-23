# Product Catalog

> A web application for managing a product catalog — create, view, edit, delete and search products with a clean UI.

## Features

- **Create** — Add new products (name, category, price, description, image URL)
- **Read** — Browse all products in a user-friendly list
- **Update** — Edit existing product details
- **Delete** — Remove products from the database
- **Search** — Filter products by name and/or category

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Java 25, Spring Boot 4.0 |
| Data Access | Spring Data JPA, Hibernate |
| Database | PostgreSQL |
| Frontend | Thymeleaf, HTML |
| Build | Maven |


## Project Structure

```
app/src/main/java/com/aitu/product_catalog/
├── controller/
│   └── ProductController.java   # HTTP endpoints (CRUD + search)
├── model/
│   └── Product.java             # JPA entity
├── repository/
│   └── ProductRepository.java   # Database queries
├── service/
│   └── ProductService.java      # Business logic
└── ProductCatalogApplication.java

app/src/main/resources/
├── templates/
│   ├── product-list.html        # Products list page
│   ├── product-detail.html      # Single product page
│   └── product-form.html        # Create / Edit form
└── application.properties
```

## API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/products` | List all (supports `?search=` & `?category=`) |
| GET | `/products/{id}` | View product details |
| GET | `/products/new` | Open create form |
| POST | `/products/save` | Save new or updated product |
| GET | `/products/edit/{id}` | Open edit form |
| GET | `/products/delete/{id}` | Delete product |

## Team

| Name | Role |
|------|------|
| Yermakov Ilya | Team Lead / Backend |
| Khametov Ilyas | Backend |
| Askar Azamat | Frontend |
| Kabyken Diyar | QA |

Academic group: **IT-2503 / AIDI 2503**
