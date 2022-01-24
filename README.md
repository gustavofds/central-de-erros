
# Central Errors Project

Essa é uma API Rest para centralizar registros de erros de
aplicações utilizando `Java` o banco relacional `PostgreSQL`
para salvar os logs de erros de uma aplicação Front-End
independende da plataforma utilizada, ou seja, essa API
pode ser consumida por aplicações mobile ou descktop.

## Funcionalidades

- É possível salvar logs de erro no Banco de Dados
- É possível recuperar eventos de Logs
- Filtrar os Logs por descrição, level, data, origem e log de evento
- Multiplataforma

## Tecnologia Aplicada

Nesse projeto foi utilizado as tecnologias abaixo.

- Java 8
- Spring Boot
- Banco Relacional PostegreSQL
- Autenticação usando o Oauth 2


## Aprendizados

Nesse projeto podemos colocar o nossos conhecimentos em
Back-End em prática e o maior desafio foi a gestão do tempo.

Quanto aos desafios tecnicos, confesso que a parte de filtragem
foi bem "tenso" de fazer por falta de experiência com filtros
em `Java`.


## Instalação

Para instalar é necessário clonar o repositório. Abaixo
tem um passo a passo utilizando o terminal bash do Ubuntu.

- É possível fazer os passos em outros sistemas operacionais,
    mas será nessário pesquisar um pouco no google.

1. Clone o repositório.

```bash
    git clone git@github.com:gustavofds/central-de-erros.git
```
- Em seguida entra na pasta que acabou de clonar:

```bash
    cd central-de-erros
```

2. Instale as dependências `maven`.

3. Agora é só abrir o projeto na sua IDE preferida.

## Configurações Inicias

Para rodar o projeto é necessário criar na pasta `src/resourses`,
um arquivo chamado `application.properties` e adicionar a variáveis
de ambiente de acordo com o aquivo `application.properties.example`
que está na mesma pasta.

- É necessário criar um banco postgreSQL com o nome `errors-center`.

```
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true

spring.datasource.url=jdbc:postgresql://{ip-do-banco-postgre}/errors-center
spring.datasource.username={nome do usuário postgre}
spring.datasource.password={senha do usuário postgre}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

security.oauth2.client.scope=password
security.oauth2.client.client-secret={palavra secreta para a geração de token}
security.oauth2.client.client-id={nome de usuário para a geração de token}
```
- Para que o Oauth possa funcionar é necessário você adicionar
    um `client-secret` e `client-id`. Você pode usar o nome `admin`
    nos dois.
## Documentação da API

Para acessar as rotas é necessário cadastrar um usuário para gerar
um token. Para isso acesse a rota abaixo no Postaman ou programa
da sua preferencia.

```http
  POST api/v1/user
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `login` | `string` | **Obrigatório**. O usuário que desejar|
| `Password` | `string` | **Obrigatório**. A senha que desejar|

- Resposta

```
status-code: 201

{
    "id": 5,
    "login": "admin5"
}
```

Depois de criar o usuário é necessário gerar um token.

```http
  POST /oauth/token
```

- Adicionar na aba Authorization `Basic Authorization`

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `Username` | `string` | **Obrigatório**. O mesmo valor da chave client-id|
| `Password` | `string` | **Obrigatório**. O mesmo valor da chave client-secret|

- No Body

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `grant_type` | `string` | **Obrigatório**. `password`|
| `username` | `string` | **Obrigatório**. O login criado|
| `password` | `string` | **Obrigatório**. A senha criada|

- Resposta

```
status-code: 200

{
    "access_token": "2f393103-d6cf-4b8f-8d76-92c494374454",
    "token_type": "bearer",
    "refresh_token": "9bf44baf-35be-4b0a-8e67-41b9264e4fca",
    "expires_in": 43199,
    "scope": "read write trust"
}
```
- Utilize o valor do access_token para acessar as rotas abaixo.

### Level Type Routes

#### Cria Level Types

```http
  POST /api/v1/type
```

- Body

```
  {
    "levelName": "info"
  }
```

- Resposta

```
 {
    "id": 3,
    "levelName": "info"
 }
```

#### Retorna todos Levels Types cadastrados

```http
  GET /api/v1/type/list
```

- Resposta

```
[
    {
        "id": 1,
        "levelName": "error"
    },
    {
        "id": 2,
        "levelName": "warning"
    },
    {
        "id": 3,
        "levelName": "info"
    }
]
```

#### Retorna Level Type por ID

```http
  GET api/v1/type/${id}
```

- Resposta

```
{
    "id": 3,
    "levelName": "info"
}
```

#### Atualiza Level Type

```http
  PUT api/v1/type/${id}
```

- Body

```
  {
    "levelName": "info25"
  }
```

- Resposta

```
 {
    "id": 3,
    "levelName": "info25"
 }
```

#### Deleta Level Type

```http
  DELETE api/v1/type/${id}
```

- Resposta

```
 {
    "id": 3,
    "levelName": "info25"
 }
```

### Log Event Routes


#### Cria Log Event

```http
  POST /api/v1/logevent
```

- Body

```
  {
    "levelTypeId": 3,
    "descriptionEvent": "evento de teste 05",
    "logEvent": "http://linkdoarquivo.com",
    "origin": "Linux",
    "quantity": 1
  }
```

- Resposta

```
{
    "id": 10,
    "descriptionEvent": "evento de teste 05",
    "logEvent": "http://linkdoarquivo.com",
    "origin": "Linux",
    "date": "2022-01-24",
    "quantity": 1,
    "levelType": {
        "id": 3,
        "levelName": "info25"
    }
}
```

#### Retorna todos Levels Types cadastrados

```http
  GET /api/v1/logevent
```

- Resposta

```
[
    {
        "id": 10,
        "descriptionEvent": "evento de teste 05",
        "origin": "Linux",
        "date": "2022-01-24",
        "quantity": 1,
        "levelType": {
            "id": 3,
            "levelName": "info25"
        }
    },
    {
        "id": 9,
        "descriptionEvent": "evento de teste 05",
        "origin": "Linux",
        "date": "2022-01-23",
        "quantity": 1,
        "levelType": {
            "id": 3,
            "levelName": "info25"
        }
    },
    {
        "id": 8,
        "descriptionEvent": "evento de teste 04",
        "origin": "mobile",
        "date": "2022-01-23",
        "quantity": 1,
        "levelType": {
            "id": 3,
            "levelName": "info25"
        }
    },
    {
        "id": 7,
        "descriptionEvent": "evento de teste 03",
        "origin": "mobile",
        "date": "2022-01-23",
        "quantity": 1,
        "levelType": {
            "id": 1,
            "levelName": "error"
        }
    },
    {
        "id": 6,
        "descriptionEvent": "evento de teste 02",
        "origin": "windows",
        "date": "2022-01-23",
        "quantity": 1,
        "levelType": {
            "id": 2,
            "levelName": "warning"
        }
    },
    {
        "id": 5,
        "descriptionEvent": "evento de teste 01",
        "origin": "windows",
        "date": "2022-01-23",
        "quantity": 1,
        "levelType": {
            "id": 2,
            "levelName": "warning"
        }
    }
]
```
- É possível paginar e ordenar essa requisição através da url
```http
  GET /api/v1/logevent?page=0&sort=id,desc
```

#### Retorna Log Event por ID

```http
  GET /api/v1/logevent/${id}
```

- Resposta

```
{
    "id": 3,
    "descriptionEvent": "evento de teste 03",
    "logEvent": "http://linkdoarquivo.com",
    "origin": "windows",
    "date": "2022-01-22 19:39",
    "quantity": 1,
    "levelType": {
        "id": 2,
        "levelName": "warning"
    }
}
```

#### Filtra Log Event

```http
  GET /api/v1/logevent/filter
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `descriptionEvent` | `string` | Passar parte da descrição em que queira filtrar |
| `logEvent` | `string` | Passar nome do evento |
| `origin` | `string` | Passar pĺataforma que deseja filtrar |
| `date` | `string` | Passar a data o evento |
| `levelName` | `string` | Passar o level que deseja filtrar |

## Autores

- [@JSouza27](https://github.com/JSouza27)
- [@gustavofds](https://github.com/gustavofds)
- [@Marcelofcdantas](https://github.com/Marcelofcdantas)


