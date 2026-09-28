# AutoManager - AutoBots

Sistema desenvolvido para a atividade prática da disciplina, utilizando uma arquitetura baseada em Spring Boot para gerenciamento de clientes de uma empresa de manutenção veicular e venda de autopeças.

O projeto implementa CRUDs para clientes, documentos, endereços e telefones, utilizando DTOs, Services, Repositories, Controllers e regras de negócio.

---

# Objetivo da atividade

Esta atividade tem como objetivo completar o CRUD básico de um sistema de gestão utilizando uma arquitetura organizada e conceitos de desenvolvimento de aplicações web.

## Tecnologias utilizadas

| Tecnologia | Versão |
|---|---|
| Java | 17.0.20.1 |
| Spring Boot | 2.6.3 |
| Maven | 3.8.4 |
| Hibernate | 5.6.4.Final |
| Lombok | Utilizado no projeto |
| Spring Data JPA | Utilizado no projeto |
| Spring Web | Utilizado no projeto |

---

## Como executar o projeto

### 1. Abrir o terminal

Entre na pasta do projeto:

```
cd automanager
```

---

### 2. Configurar o Java

O projeto foi executado utilizando:

```text
Java 17.0.20.1
```

---

## Executando a aplicação

Com o terminal na pasta do projeto automanager:

```cmd
mvnw.cmd spring-boot:run
```

Quando a aplicação iniciar corretamente, será exibido:

```text
Tomcat started on port(s): 8080
```

A API estará disponível em:

```text
http://localhost:8080
```

# Rotas da API
As rotas podem ser testadas utilizando ferramentas como:

- Postman
- Insomnia
- Thunder Client
- Navegador, para requisições GET

## Cliente

### Cadastrar cliente

```http
POST /cliente/cadastro
```

Body:

```json
{
    "nome": "Laura Silva",
    "nomeSocial": "Laura",
    "dataNascimento": "2003-05-15",
    "dataCadastro": "2026-09-27",
    "documentos": [
        {
            "tipo": "CPF",
            "numero": "12345678900"
        }
    ],
    "endereco": {
        "estado": "SP",
        "cidade": "São José dos Campos",
        "bairro": "Centro",
        "rua": "Rua Exemplo",
        "numero": "100",
        "codigoPostal": "12200-000",
        "informacoesAdicionais": "Casa"
    },
    "telefones": [
        {
            "ddd": "12",
            "numero": "999999999"
        }
    ]
}
```

### Listar clientes

```http
GET /cliente/clientes
```

### Buscar cliente

```http
GET /cliente/cliente/{id}
```

### Atualizar cliente

```http
PUT /cliente/atualizar/{id}
```

### Excluir cliente

```http
DELETE /cliente/excluir/{id}
```

---

## Documento

### Cadastrar documento

```http
POST /documento/cadastro
```

Body:

```json
{
    "tipo": "CPF",
    "numero": "12345678900"
}
```

### Listar documentos

```http
GET /documento/documentos
```

### Buscar documento

```http
GET /documento/{id}
```

### Atualizar documento

```http
PUT /documento/{id}
```

### Excluir documento

```http
DELETE /documento/{id}
```

---

## Endereço

### Cadastrar endereço

```http
POST /endereco/cadastro
```

Body:

```json
{
    "estado": "SP",
    "cidade": "São José dos Campos",
    "bairro": "Centro",
    "rua": "Rua Exemplo",
    "numero": "100",
    "codigoPostal": "12200-000",
    "informacoesAdicionais": "Casa"
}
```

### Listar endereços

```http
GET /endereco/enderecos
```

### Buscar endereço

```http
GET /endereco/{id}
```

### Atualizar endereço

```http
PUT /endereco/{id}
```

### Excluir endereço

```http
DELETE /endereco/{id}
```

---

## Telefone

### Cadastrar telefone

```http
POST /telefone/cadastro
```

Body:

```json
{
    "ddd": "12",
    "numero": "999999999"
}
```

### Listar telefones

```http
GET /telefone/telefones
```

### Buscar telefone

```http
GET /telefone/{id}
```

### Atualizar telefone

```http
PUT /telefone/{id}
```

### Excluir telefone

```http
DELETE /telefone/{id}
```

---

# Tratamento de erros

O projeto possui exceções específicas para situações como:

- Cliente não encontrado
- Documento não encontrado
- Endereço não encontrado
- Telefone não encontrado
- Documento duplicado
