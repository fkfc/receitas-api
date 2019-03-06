package com.fkfc.receitasapi;

import com.fkfc.receitasapi.dao.ReceitaRepository;
import com.fkfc.receitasapi.dto.Receita;
import com.fkfc.receitasapi.handler.CreateReceitaHandler;
import com.fkfc.receitasapi.handler.FilterReceitaHandler;
import com.fkfc.receitasapi.handler.GetReceitaHandler;
import com.fkfc.receitasapi.service.ReceitasGetController;
import com.fkfc.receitasapi.service.ReceitasPostController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    Receita createMockedReceita(Integer gen) {
        Receita receita = new Receita();

        receita.setId(gen);
        receita.setNome("Receita"+gen);
        receita.setModoPreparo("ModoPreparo");

        return receita;
    }

    @Test
    public void insertTest() {
        //Cria uma receita mock
        Receita receita = createMockedReceita(0);

        //Mocka o método de criação de uma nova receita no repositório
        ReceitaRepository receitaRepository = mock(ReceitaRepository.class);
        doNothing().when(receitaRepository).saveReceita(isA(Receita.class));

        //Instancia o handler com o repositório mockado
        CreateReceitaHandler createReceitaHandler = new CreateReceitaHandler(receitaRepository);

        //Instancia o controlador com o handler criado anteriormente
        ReceitasPostController receitasPostController = new ReceitasPostController(createReceitaHandler);

        //Verifica o resultado
        assert receitasPostController.postReceita(receita).equals("OK");
    }

    @Test
    public void retrieveTest() {
        //Cria uma receita mock
        Receita receita = createMockedReceita(0);

        //Mocka o método de get do repositório de receita
        ReceitaRepository receitaRepository = mock(ReceitaRepository.class);
        when(receitaRepository.getById(isA(Integer.class))).thenReturn(receita);

        //Cria os handlers com o repositório mockado
        GetReceitaHandler getReceitaHandler = new GetReceitaHandler(receitaRepository);
        FilterReceitaHandler filterReceitaHandler = new FilterReceitaHandler(receitaRepository);

        //Instancia o controller com os handlers criados anteriormente
        ReceitasGetController receitasGetController = new ReceitasGetController(filterReceitaHandler, getReceitaHandler);

        //Simula uma requisição no rest
        Receita receitaRetrieved = receitasGetController.getReceitaById(0);

        //Verifica o resultado
        assert receitaRetrieved.getNome().equals(receita.getNome());
        assert receitaRetrieved.getModoPreparo().equals(receita.getModoPreparo());
    }

}
