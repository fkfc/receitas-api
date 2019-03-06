# receitas-api
API CRUD de Receitas. Projeto Java utilizando Maven

## Documentação Interna
- Documentação gerada pelo Javadoc se encontra no diretório **/doc**.

## Configurações
- Verificar as configurações no arquivo application.properties, em especial o endereço, nome de usuário e senha do banco de dados
- As classes de banco de dados (JOOQ) são geradas automaticamente ao executar *maven install*
- Criar executável JAR:
	- maven clean
	- maven install
	- maven package


## Exemplos de uso

POST
-------
*Insere uma nova receita*\

**URL**: localhost:3000/post\
**Body do POST**:\
```json
{
    "nome": "receita",
    "categorias": ["categoria1","categoria2"],
    "ingredientes": [
        {"ordem": 0, "nome": "ingrediente1", "quantidade": "1 colher" },
        {"ordem": 1, "nome": "ingrediente2", "quantidade": "2 copos" }
    ],
    "metadados": [
        {"nome": "tempo de preparo", "valor": "20 minutos"},
        {"nome": "rendimento", "valor": "5 porções"}
    ],
    "modoPreparo": "Instruções de preparo"
}
```

GET - Filtro
--------------
*Recupera uma lista de receitas filtradas por um mais campos.*\
**URL:** localhost:3000/get?nome=receita&categorias=categoria1,categoria2&ingredientes=ingrediente3\
**Campos:**\

|Nome do campo  | Descrição                                                                              |
| --------------------- | ------------------------------------------------------------ |
| nome                       | Nome da receita                                                                   |
| categorias            | Uma ou mais categoria que deve fazer parte       |
| ingredientes       | Um ou mais ingrediente que deve ser utilizado |

GET - Único item
---------------------
*Recupera um único item identificado pelo ID especificado na URL.*\
**URL:**  localhost:3000/get/3\




PATCH
---------
*Altera campos específicos de uma receita já cadastrada. O ID da receita é especificado na URL.*\
**URL:** localhost:3000/patch/3\
**Body do PATCH:**\
```json
{
	"nome":"novoNome",
	"categorias": ["categoria3", "categoria4"]
}
```

PUT
------
*Substitui todos os campos de uma receita já cadastrada. O ID da receita é especificado na URL.*\
**URL**: localhost:3000/put/3\
**Body do PUT:**
```json
{
    "nome": "outraReceita",
    "categorias": ["categoria5","categoria6"],
    "ingredientes": [
        {"ordem": 0, "nome": "ingrediente1", "quantidade": "1 colher" },
        {"ordem": 1, "nome": "ingrediente3", "quantidade": "1 xícara" }
    ],
    "metadados": [
        {"nome": "tempo de preparo", "valor": "20 minutos"},
        {"nome": "rendimento", "valor": "6 porções"}
    ],
    "modoPreparo": "Instruções de preparo"
}
```

DELETE
----------
*Exclui uma receita especificada pelo ID na URL.*\
**URL:** localhost:3000/delete/3
