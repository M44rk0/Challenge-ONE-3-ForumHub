# ForumHub - Gestão de Tópicos e Usuários

![alura_challenges](https://github.com/M44rk0/Challenge-ONE-1-Conversor-de-Moedas/assets/143122284/04fea3e9-1c07-4923-9fa6-657a987dec9a)

Este projeto é uma API REST desenvolvida com Spring Boot para gerenciar tópicos em um fórum, incluindo funcionalidades de autenticação Utilizando JWT.
Este desafio faz parte do programa Oracle Next Education (ONE) em colaboração com a Alura, com o objetivo de fortalecer e consolidar os conhecimentos adquiridos durante a Especialização Java Back-End. No desenvolvimento deste projeto, são aplicadas diversas habilidades, incluindo:

1. **Programação Orientada a Objetos (OOP)**: Utilização de princípios como encapsulamento, herança e polimorfismo para estruturar o código de forma modular e reutilizável.

2. **Desenvolvimento de APIs RESTful com Spring Boot**: Construção de endpoints HTTP que seguem os princípios REST para interação com recursos da aplicação.

3. **Autenticação e Autorização com JWT**: Implementação de um sistema de autenticação utilizando JSON Web Tokens (JWT), para gerenciar sessões de usuário de forma stateless e escalável.

4. **Persistência de Dados com Spring Data JPA e Hibernate**: Integração com bancos de dados relacionais para armazenamento e recuperação de informações, utilizando JPA (Java Persistence API) em conjunto com o framework Hibernate, e utilizando Flyway para o controle de versão e migrações de banco de dados.

5. **Segurança de Aplicações Web**: Implementação de medidas de segurança, como proteção contra CSRF (Cross-Site Request Forgery) e XSS (Cross-Site Scripting), além de práticas de segurança recomendadas para APIs REST.

7. **Gerenciamento de Dependências com Maven**: Utilização do Maven como gerenciador de dependências para facilitar a gestão e a integração de bibliotecas externas no projeto.



## Funcionalidades

- **Autenticação de Usuários**: Registro e login de usuários com geração de token JWT.
- **Gerenciamento de Tópicos**: Criação, listagem, atualização e exclusão de tópicos.
- **Detalhes de Tópicos**: Retorna informações detalhadas sobre um tópico específico.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3**
- **Spring Security**
- **Spring Data JPA / Hibernate**
- **MySQL**: Sistema de gerenciamento de banco de dados para armazenamento persistente.
- **Flyway**: Para o controle de versão e migrations do Banco de Dados.
- **Lombok**: Para redução de código boilerplate.

## Autenticação JWT

Para utilizar a API, você precisa autenticar um usuário e obter um token JWT válido.

1. **Faça uma requisição POST para `/login` com as credenciais do usuário:**

   - **URL**: `http://localhost:8080/login`
   - **Body**:
     ```json
     {
       "email": "email",
       "password": "senha"
     }
     ```

   - **Resposta Esperada**:
     ```json
     {
       "token": "token_jwt"
     }
     ```

## Testando a API

Utilizando o **Insomnia** ou **Postman** é possivel testar os endpoints da API.

### Endpoints Principais

- **POST /login**: Autentica o usuário e retorna um token JWT.
- **POST /topicos**: Cria um novo tópico.
- **GET /topicos**: Lista todos os tópicos disponíveis.
- **GET /topicos/{id}**: Retorna detalhes de um tópico específico.
- **PUT /topicos/{id}**: Atualiza um tópico existente.
- **DELETE /topicos/{id}**: Deleta um tópico específico.


