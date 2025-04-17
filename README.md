@# 📝 User Post API para Microblog

Uma API RESTful para gerenciar usuários (leitores e escritores) e seus posts, feita com Spring Boot 3.2.4 e Java 17.

---

## 🚀 Funcionalidades

- Registro de leitores e escritores
- Autenticação com login e token JWT
- Criação e listagem de posts por usuários autenticados
- Validações com Bean Validation
- Swagger UI para documentação interativa
- Banco em memória (H2)

---

## 🛠️ Tecnologias usadas

- Java 17
- Spring Boot 3.2.4
  - Spring Web
  - Spring Data JPA
  - Spring Security
  - Validation
- H2 Database
- Lombok
- SpringDoc OpenAPI

---

## ▶️ Como rodar

### Pré-requisitos

- Java 17+
- Maven 3.8+

### Passo a passo

```bash
# https
git https://github.com/vini-basilio/dev-posts.git
cd dev-posts
./mvnw spring-boot:run
```

Acesse a documentação Swagger:  
👉 [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

---

## 📚 Documentação da API

Você pode testar todas as rotas diretamente pelo Swagger UI, mas se quiser importar no Postman:

1. Gere o arquivo JSON do Swagger:

   - Rode a aplicação
   - Acesse: [`http://localhost:8080/v3/api-docs`](http://localhost:8080/v3/api-docs)
   - Salve o conteúdo como `openapi.json`

2. Importe no Postman:
   - Abra o Postman > Import > Raw Text ou File > selecione o `openapi.json`

---

## ⚙️ Configurações obrigatórias

Antes de rodar a API, é necessário configurar o arquivo src/main/resources/application.properties com os parâmetros abaixo:

```
# Configurações do banco H2
spring.datasource.url=jdbc:h2:mem:seu_banco
spring.datasource.username=seu_nome
spring.datasource.password=
spring.jpa.show-sql=true
spring.jpa.open-in-view=false
spring.jpa.hibernate.ddl-auto=create
# Opções: validate | update | create | create-drop
spring.jpa.properties.hibernate.format_sql=true

# Console web do H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.trace=false
spring.h2.console.settings.web-allow-others=false

# Configurações de segurança e token JWT
api.security.token.secret=seu_segredo
# Tempo de expiração do token (em ms)
api.security.token.expiration=360000

# Senha usada para criar o admin na inicialização (exemplo de uso)
api.admin.password=senha
```

> 💡 Dica: Você pode trocar esses valores conforme sua necessidade, principalmente os campos secret, username e a senha de admin

## 🔐 Autenticação

- **Endpoint de login:** `POST /users/login`
- Envie o `login` e `password`
- Você receberá um **token JWT**
- Use o token no Postman/Swagger como `Bearer <token>`

---

## 🔗 Endpoints principais

### 🧑 Registro de usuários

| Método | Rota                     | Ação                    |
| ------ | ------------------------ | ----------------------- |
| POST   | `/users/register/reader` | Cadastrar novo leitor   |
| POST   | `/users/register/writer` | Cadastrar novo escritor |

### 🔑 Login

| Método | Rota           | Ação          |
| ------ | -------------- | ------------- |
| POST   | `/users/login` | Login e token |

### 📝 Posts

| Método | Rota           | Ação                            |
| ------ | -------------- | ------------------------------- |
| POST   | `/users/posts` | Cria um post (auth obrigatória) |

---

## 🧪 Exemplos de JSON

### Registrar leitor

```json
{
  "name": "Maria Leitura",
  "login": "maria@example.com",
  "password": "12345"
}
```

### Registrar escritor

```json
{
  "name": "João Escritor",
  "login": "joao@example.com",
  "password": "12345",
  "adminPassword": "senhaSecreta"
}
```

### Login

```json
{
  "login": "joao@example.com",
  "password": "12345"
}
```

### Criar post (autenticado)

```json
{
  "title": "Post legal",
  "post": "Esse é o conteúdo do post"
}
```

---

## 👨‍💻 Autor

Feito com 💻 por [Vini](https://github.com/vini-basilio)
