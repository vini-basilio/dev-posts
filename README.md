# 📝 User Post API para Microblog

Uma API RESTful para gerenciar usuários e seus posts, feita com Spring Boot 3.2.4 e Java 17.  
Ideal para testes, aprendizado e como entrega de desafio técnico.

---

## 🚀 Funcionalidades

- Criar e listar usuários
- Criar posts associados a usuários
- Validações com Bean Validation
- Swagger UI para documentação interativa
- Banco em memória (H2)

---

## 🛠️ Tecnologias usadas

- Java 17
- Spring Boot 3.2.4
  - Web
  - Data JPA
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
git clone https://github.com/seu-usuario/user-post-api.git
cd user-post-api
./mvnw spring-boot:run
```

Acesse a documentação Swagger:  
👉 http://localhost:8080/swagger-ui.html

---

## 🔗 Endpoints principais

### Usuários

| Método | Rota          | Ação                    |
| ------ | ------------- | ----------------------- |
| GET    | `/users`      | Lista todos os usuários |
| GET    | `/users/{id}` | Detalha um usuário      |
| POST   | `/users`      | Cria um novo usuário    |
| DELETE | `/users/{id}` | Remove um usuário       |

### Posts

| Método | Rota                    | Ação                        |
| ------ | ----------------------- | --------------------------- |
| POST   | `/users/{userId}/posts` | Cria um post para o usuário |

---

## 🧪 Exemplo de JSON

### Criar usuário

```json
{
  "name": "João da Silva",
  "login": "joao@example.com"
}
```

### Criar post

```json
{
  "title": "Meu primeiro post",
  "content": "Esse é o conteúdo do post."
}
```

---

## 🧠 Observações

- A relação `User` → `Post` é bidirecional.
- A validação ocorre nos DTOs com anotações como `@NotBlank`, `@Email`, `@Size`, etc.
- O projeto usa `CascadeType.ALL` para persistir posts junto com o usuário (quando aplicável).

---

## 👨‍💻 Autor

Feito com 💻 por [Seu Nome Aqui](https://github.com/vini-basilio)
