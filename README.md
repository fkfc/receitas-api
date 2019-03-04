# receitas-api

#Exemplo de post:
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
