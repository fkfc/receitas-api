# receitas-api

#Exemplos

#POST:
Body do POST:

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


#PATCH:
url: localhost:3000/patch/3

body:

{
"nome":"novoNome",
"categorias": ["categoria3", "categoria4"]
}

#PUT
url: localhost:3000/put/3

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
