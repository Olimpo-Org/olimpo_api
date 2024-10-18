## Documentação da API - Projeto Olimpo

Este projeto implementa uma API RESTful para gerenciar **Usuários** e **Comunidades**. A seguir estão descritos os **endpoints**, os **modelos** envolvidos, e a estratégia de tratamento de exceções usada no projeto.

## Endpoints

### **UserController** (Controlador de Usuário)

| Verbo HTTP | Endpoint | Descrição | Exemplo de Requisição |
| --- | --- | --- | --- |
| **POST** | `/v1/user/create` | Cria um novo usuário a partir de um objeto JSON. | **Body**: JSON com os dados do usuário. |
| **POST** | `/v1/user/login` | Realiza o login de um usuário com email e senha. | **Body**: JSON com os dados de login. |
| **GET** | `/v1/user/getAll` | Lista todos os usuários cadastrados no sistema. | - |
| **GET** | `/v1/user/getById/{id}` | Lista um usuário específico pelo seu ID. | **Path Variable**: `id` do usuário. |
| **GET** | `/v1/user/exists/{id}` | Verifica se um usuário existe pelo ID. | **Path Variable**: `id` do usuário. |
| **POST** | `/v1/user/grantAdministrator` | Concede permissão de administrador para um usuário. | **Body**: JSON com os dados do administrador. |
| **GET** | `/v1/user/isAdministrator/{customerId}/{communityId}` | Verifica se um usuário é administrador de uma comunidade. | **Path Variables**: `customerId` (ID do usuário) e `communityId` (ID da comunidade). |

### **CommunityController** (Controlador de Comunidade)

| Verbo HTTP | Endpoint | Descrição | Exemplo de Requisição |
| --- | --- | --- | --- |
| **POST** | `/v1/community/create` | Cria uma nova comunidade. | **Body**: JSON com os dados da comunidade. |
| **GET** | `/v1/community/getAll` | Lista todas as comunidades cadastradas. | - |
| **GET** | `/v1/community/getAllUsersInCommunity/{communityId}` | Lista todos os usuários de uma comunidade. | **Path Variable**: `communityId` (ID da comunidade). |
| **GET** | `/v1/community/getAllCommunitiesByUser/{customerId}` | Lista todas as comunidades em que um usuário participa. | **Path Variable**: `customerId` (ID do usuário). |
| **POST** | `/v1/community/createSolicitation` | Cria uma solicitação de ingresso em uma comunidade. | **Body**: JSON com os dados da solicitação. |
| **GET** | `/v1/community/getAllSolicitations/{communityId}` | Lista todas as solicitações de ingresso de uma comunidade. | **Path Variable**: `communityId` (ID da comunidade). |
| **POST** | `/v1/community/acceptSolicitation/{solicitationId}` | Aceita uma solicitação de ingresso na comunidade. | **Path Variable**: `solicitationId` (ID da solicitação). |

## Modelos

### **Login**

```java
public class Login {
    private String email;
    private String password;
}
```

### **User** (Usuário)

```java
@Entity
@Table(name = "customer")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @Email private String email;
    @NotNull @Size(min = 8) private String password;
    @NotNull private String name;
    @NotNull private String surname;
    @NotNull @Size(min = 11, max = 11) private String cpf;
    @NotNull private Integer genderId;
    @NotNull private Integer mainInterestId;
    @NotNull private Date birthdate;
    @NotNull private String profileImage;
}

```

### **Community** (Comunidade)

```java
@Entity
@Table(name = "community")
public class Community {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull private String name;
    @NotNull private Date startDate;
    @NotNull private String neighborhood;
    @NotNull private Integer regionId;
    @NotNull private String imageUrl;
}

```

### **Solicitation** (Solicitação)

```java
@RedisHash("solicitation")
public class Solicitation {
    private Long id;
    private String communityId;
    private String userId;
    private String userName;
    private String userUrlImage;
}

```

### CommunityUser

```java
@Entity
@Table(name = "community_customer")
public class CommunityUser {
    @EmbeddedId private CommunityUserId id;
}

```

### **Administrator** (Administrador)

```java
@Entity
@Table(name = "administrador")
public class Administrator {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull private String customerCpf;
    @NotNull private Long communityId;
}

```

### Advertising

```java
@Entity
@Table(name = "advertisement")
public class Advertising {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull private String description;
    @NotNull private LocalDate divulgationDate;
    private Integer idCategoryProduct;
    private String productName;
    private Long userId;
    private Long idPlan;
    private String imageUrl;
}

```

## Tratamento Global de Exceções

A aplicação possui um **GlobalExceptionHandler** que lida com diferentes exceções que podem ocorrer durante a execução da API. As principais exceções tratadas são:

- **CustomNotFoundException**: Retorna um status `404` (Not Found) quando uma entidade solicitada não é encontrada.
- **CustomBadRequestException**: Retorna um status `400` (Bad Request) quando há problemas com os dados enviados na requisição.
- **IllegalArgumentException**: Lança um `400` (Bad Request) quando um argumento inválido é fornecido.
- **HttpServerErrorException**: Lança um `500` (Internal Server Error) para erros inesperados do servidor.
- **Exception**: Uma exceção genérica para capturar quaisquer outras situações inesperadas.

Cada exceção é manipulada com uma mensagem de erro apropriada, fornecendo informações úteis para o cliente da API.
