package com.fkfc.receitasapi.service;

import com.fkfc.receitasapi.dto.Receita;
import com.fkfc.receitasapi.dto.ReceitaFilter;
import com.fkfc.receitasapi.handler.FilterReceitaHandler;
import com.fkfc.receitasapi.handler.GetReceitaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador com os métodos GET
 */
@RestController
public class ReceitasGetController {

    @Autowired
    FilterReceitaHandler filterReceitaHandler;

    @Autowired
    GetReceitaHandler getReceitaHandler;

    public ReceitasGetController(FilterReceitaHandler filterReceitaHandler, GetReceitaHandler getReceitaHandler) {
        this.filterReceitaHandler = filterReceitaHandler;
        this.getReceitaHandler = getReceitaHandler;
    }

    /**
     * Endpoint ROOT para verificar se o serviço está em execução
     * @return String "Receitas-API está em execução"
     */
    @CrossOrigin
    @RequestMapping("/")
    public String root() {
        return "Receitas-API está em execução";
    }

    /**
     * Recupera uma receita a partir de um ID
     * @param id ID da receita a ser buscada
     * @return Instância da receita
     */
    @CrossOrigin
    @RequestMapping(value = "/get/{id}", method = {RequestMethod.GET})
    public Receita getReceitaById(@PathVariable("id") Integer id) {
        return getReceitaHandler.handleGetReceitaById(id);
    }

    /**
     * Busca receitas a partir de um filtro. Um ou mais campos podem ser utilizados simultaneamente
     * @param nome Nome da receita a ser buscada
     * @param categorias Lista de categorias desejadas
     * @param ingredientes Lista de ingredientes utilizados na receita
     * @return Lista de receitas que satisfazem as condições da busca
     */
    @CrossOrigin
    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    public List<Receita> getReceita(
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "categorias", required = false) List<String> categorias,
            @RequestParam(value = "ingredientes", required = false) List<String> ingredientes
    ) {
        ReceitaFilter filter = new ReceitaFilter(nome, ingredientes, categorias);
        return filterReceitaHandler.handleGetReceita(filter);
    }


}
