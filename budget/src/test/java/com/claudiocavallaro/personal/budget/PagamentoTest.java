package com.claudiocavallaro.personal.budget;

import com.claudiocavallaro.personal.budget.model.PagamentoEffettuato;
import com.claudiocavallaro.personal.budget.persistence.DBManager;
import com.claudiocavallaro.personal.budget.persistence.MetodoDAO;
import com.claudiocavallaro.personal.budget.persistence.PagamentoDAO;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PagamentoTest {

    private static MetodoDAO metodoDAO;
    private static PagamentoDAO pagamentoDAO;

    private static String DELETE = "delete from budget.pagamento_effettuato;";

    @Before
    public void setup() {
        metodoDAO = MetodoDAO.getInstance();
        pagamentoDAO = PagamentoDAO.getInstance();
    }

    @Test
    public void testInsert(){
        //----- Pagamento ------
        BigDecimal importo = new BigDecimal("10.0000");
        String note = "Ricarica telefonica";
        String data = "2021-03-28";
        String metodo = "Contanti";
        Long idMetodo = metodoDAO.getId(metodo);
        //----------------------

        if (idMetodo != null){
            pagamentoDAO.insert(importo, note, data, idMetodo, false);
            List<PagamentoEffettuato> lista = pagamentoDAO.get();
            assertTrue(!lista.isEmpty());
            PagamentoEffettuato p1 = lista.get(0);
            assertTrue(p1.getData().equals("2021-03-28"));
            assertTrue(p1.getMetodo().equals("Contanti"));
            assertTrue(p1.getNote().equals("Ricarica telefonica"));
            assertEquals(p1.getImporto(), importo);
        }
    }

    @Test
    public void getMonth(){
        //----- Pagamento ------
        BigDecimal importo = new BigDecimal("10.0000");
        String note = "Ricarica telefonica";
        String data = "2021-04-28";
        String metodo = "Contanti";
        Long idMetodo = metodoDAO.getId(metodo);
        //----------------------

        if (idMetodo != null){
            pagamentoDAO.insert(importo, note, data, idMetodo, false);
            List<PagamentoEffettuato> lista = pagamentoDAO.getMonth("3");
            assertTrue(!lista.isEmpty());
            PagamentoEffettuato p1 = lista.get(0);
            assertTrue(p1.getData().equals("2021-03-28"));
            assertTrue(p1.getMetodo().equals("Contanti"));
            assertTrue(p1.getNote().equals("Ricarica telefonica"));
            assertEquals(p1.getImporto(), importo);
        }
    }

    @AfterClass
    public static void tearDown(){
        try (final Connection conn = DBManager.createConnection();
             final PreparedStatement statement = conn.prepareStatement(DELETE);) {
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
