# 💳 DevFlow Pay API

<p align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-success?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue?style=for-the-badge&logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-Ready-2496ED?style=for-the-badge&logo=docker)
![JWT](https://img.shields.io/badge/JWT-Security-black?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

</p>

---

# 📖 Sobre o Projeto

O **DevFlow Pay API** é uma API REST desenvolvida com **Spring Boot** que simula uma plataforma moderna de pagamentos digitais.

O projeto foi criado com foco em:

- arquitetura limpa;
- boas práticas de desenvolvimento;
- autenticação JWT;
- microsserviços;
- integrações serverless;
- testes automatizados;
- Docker;
- documentação OpenAPI.

Seu objetivo é servir como projeto de portfólio e referência para aplicações Java modernas.

---

# 🏗 Arquitetura

```
Cliente
     │
     ▼
Spring Boot API
     │
     ▼
Spring Security + JWT
     │
     ▼
Application Services
     │
     ▼
Repositories
     │
     ▼
PostgreSQL
```

---

# 🚀 Tecnologias

| Tecnologia | Versão |
|------------|---------|
| Java | 21 |
| Spring Boot | 3.5 |
| Spring Security | ✔ |
| JWT | ✔ |
| PostgreSQL | 16 |
| Flyway | ✔ |
| Docker | ✔ |
| Maven | ✔ |
| Lombok | ✔ |
| MapStruct | ✔ |
| Swagger/OpenAPI | ✔ |
| JUnit 5 | ✔ |
| Mockito | ✔ |

---

# 📂 Estrutura

```
src
 ├── auth
 ├── common
 ├── config
 ├── customer
 ├── exception
 ├── payment
 ├── product
 ├── security
 ├── user
 ├── webhook
 └── DevFlowPayApplication
```

---

# 🔐 Funcionalidades

- Login JWT
- Cadastro de usuários
- Cadastro de produtos
- Controle de estoque
- Pedidos
- Pagamentos
- Webhooks
- Auditoria
- Logs
- Validação de dados
- Tratamento global de exceções
- Documentação Swagger

---

# 📚 Endpoints

## Auth

| Método | Endpoint |
|---------|----------|
| POST | /auth/login |

## Users

| Método | Endpoint |
|---------|----------|
| GET | /users |
| GET | /users/{id} |
| POST | /users |
| PUT | /users/{id} |
| DELETE | /users/{id} |

## Products

| Método | Endpoint |
|---------|----------|
| GET | /products |
| POST | /products |
| PUT | /products/{id} |
| DELETE | /products/{id} |

---

# ⚙ Como executar

### Clone

```bash
git clone https://github.com/juceliocoelho2022/devflow-pay-api.git
```

### Entre no projeto

```bash
cd devflow-pay-api
```

### Execute

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

---

# 🐳 Docker

```bash
docker compose up -d
```

---

# 📑 Swagger

Após iniciar o projeto:

```
http://localhost:8080/swagger-ui/index.html
```

---

# 📈 Roadmap

## ✅ Sprint 1

- Estrutura inicial
- Configuração Maven
- Spring Boot
- PostgreSQL

## 🚧 Sprint 2

- JWT Authentication
- Spring Security

## 🚧 Sprint 3

- User Module

## 🚧 Sprint 4

- Product Module

## 🚧 Sprint 5

- Customer Module

## 🚧 Sprint 6

- Order Module

## 🚧 Sprint 7

- Payment Module

## 🚧 Sprint 8

- Webhooks

## 🚧 Sprint 9

- AWS Lambda

## 🚧 Sprint 10

- Docker

## 🚧 Sprint 11

- Testes

## 🚧 Sprint 12

- GitHub Actions

---

# 📊 Qualidade

- Clean Code
- SOLID
- Clean Architecture
- RESTful API
- DTO Pattern
- Repository Pattern
- Service Layer
- Global Exception Handler
- Bean Validation
- OpenAPI Documentation
- Unit Tests
- Integration Tests

---

# 👨‍💻 Autor

**Jucelio Farias Coelho**

Professor de Desenvolvimento de Sistemas • Desenvolvedor Java • Spring Boot • Kotlin • Android • Python • PostgreSQL

- 💼 LinkedIn: https://linkedin.com/in/jucelio-desenvolvedor-sistema
- 💻 GitHub: https://github.com/juceliocoelho2022

---

# ⭐ Contribuição

Contribuições são bem-vindas!

Caso tenha sugestões de melhorias, fique à vontade para abrir uma **Issue** ou enviar um **Pull Request**.

---

# 📄 Licença

Este projeto está licenciado sob a licença **MIT**.
