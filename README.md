# 🏦 API de Empréstimos ☕ 

## Descrição
Esta é uma API de Empréstimos que permite a criação, listagem, atualização, exclusão e cálculo de aprovação de empréstimos com base na renda mensal do solicitante. A API foi desenvolvida utilizando Spring Boot e permite a interação com um banco de dados para armazenar e gerenciar os dados dos empréstimos.
## ⚙ Tecnologias Utilizadas

- [**Java 17**](https://docs.oracle.com/en/java/javase/17/)
- [**Spring Boot**](https://spring.io/projects/spring-boot)
- [**Spring MVC**](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [**Spring Data JPA**](https://spring.io/projects/spring-data-jpa)
---
### **Banco de dados e Documentação:**
- [**Mysql**](https://dev.mysql.com/downloads/)
- [**H2 Database**](https://www.h2database.com/html/main.html) (para testes)
- [**SpringDoc OpenAPI 3**](https://springdoc.org/v2/#spring-webflux-support) (Swagger)



## Práticas Adotadas
- **Arquitetura RESTful:** Estruturação da API seguindo os princípios REST.
- **Injeção de Dependências:** Uso do Spring Framework para injeção de dependências.
- **Documentação Automática:** Utilização do Swagger para documentação automática dos endpoints da API.
- **Validações:** Implementação de validações básicas para os dados de entrada.
- **Testes:** Testes básicos utilizando o banco de dados H2 em memória.

## Como Executar
1. **Clone o repositório:**
   ```sh
   git clone https://github.com/DiogoMakotto/emprestimo-api.git
   cd projeto-emprestimos

    mvn spring-boot:run

2. **Acesse a aplicação:**

    - A API estará disponível em: `http://localhost:8080`
    - A documentação Swagger estará disponível em: `http://localhost:8080/swagger-ui.html`

## API Endpoints - Emprestimos

- **POST /emprestimos**

    - **Descrição:** Cria um novo empréstimo.
    - **Corpo da Requisição:**

~~~JSON
[
  {
    "nome": "João Silva",
    "valorEmprestimoDesejado": "30000.0",
    "rendaMensal": "5000.0"
  }
]
~~~
**Resposta:**
~~~JSON
[
  {
    "id": 1,
    "nome": "João Silva",
    "valorEmprestimoDesejado": "30000.0",
    "rendaMensal": "5000.0"
  }
]
~~~

- **GET /emprestimos**

  - **Descrição:** Lista todos os empréstimos.
  
**Resposta:**
~~~json
[
    {
        "id": 1,
        "nome": "João Silva",
        "valorEmprestimoDesejado": "30000.0",
        "rendaMensal": "5000.0"
    }
]
~~~

- **PUT /emprestimos**

  - **Descrição:** Atualiza um empréstimo existente.
~~~Json
[
  {
    "id": 1,
    "nome": "João Silva",
    "valorEmprestimoDesejado": "35000.0",
    "rendaMensal": "5000.0"
  }
]
~~~
**Resposta:**
~~~Json
[
  {
    "id": 1,
    "nome": "João Silva",
    "valorEmprestimoDesejado": "35000.0",
    "rendaMensal": "5000.0"
  }
]
~~~

- **DELETE /emprestimos/{id}**

  - **Descrição:** Deleta um empréstimo pelo ID.
  
**Resposta:**
~~~Json
[
  {
    "id": 2,
    "nome": "Maria Souza",
    "valorEmprestimoDesejado": "25000.0",
    "rendaMensal": "4500.0"
  }
]
~~~

- **POST /emprestimos/calcular**

  - **Descrição:** Calcula se o empréstimo solicitado pode ser aprovado com base na renda mensal do solicitante.
  - **Corpo da Requisição**
~~~Json
[
    {
      "nome": "João Silva",
      "valorEmprestimoDesejado": "30000.0",
      "rendaMensal": "5000.0"
    }
]
~~~
**Resposta:**
~~~Json
[
  {
    "valorMaximoEmprestimo": 31730.18,
    "aprovado": true
  }
]
~~~
