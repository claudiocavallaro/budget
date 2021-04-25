package com.example.testdb.demodb;

import com.example.testdb.demodb.model.Metodo;
import com.example.testdb.demodb.persistence.MetodoDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetodoTest {

    private static MetodoDAO metodoDAO;

    @Before
    public void setup() {
        metodoDAO = MetodoDAO.getInstance();
    }

    @Test
    public void testGet(){
        List<Metodo> metodi = metodoDAO.get();
        assertTrue(!metodi.isEmpty());
    }

    @Test
    public void testAdd(){
        List<Metodo> metodi = metodoDAO.get();
        int sizeBefore = metodi.size();

        metodoDAO.insert("Revolut");

        assertNotEquals(sizeBefore, metodoDAO.get().size());
    }
}
