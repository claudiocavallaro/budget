package com.example.testdb.demodb.service;

import com.example.testdb.demodb.model.PagamentoEffettuato;
import com.example.testdb.demodb.persistence.MetodoDAO;
import com.example.testdb.demodb.persistence.PagamentoDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

@Service
public class PagamentiService {

    private MetodoDAO metodoDAO = MetodoDAO.getInstance();
    private PagamentoDAO pagamentoDAO = PagamentoDAO.getInstance();

    public String get(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(pagamentoDAO.get());
    }

    public String getMonth(String month){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(pagamentoDAO.getMonth(month));
    }

    public String insert(PagamentoEffettuato pagamentoEffettuato){
        String metodo = pagamentoEffettuato.getMetodo();
        Long id = metodoDAO.getId(metodo);
        if (id != null){
            boolean flag = pagamentoDAO.insert(pagamentoEffettuato.getImporto(), pagamentoEffettuato.getNote(), pagamentoEffettuato.getData(), id);
            if (flag){
                return "OK";
            }
        }
        return "NOT INSERTED";
    }

}
