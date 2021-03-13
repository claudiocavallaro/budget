package com.example.testdb.demodb.service;

import com.example.testdb.demodb.model.Metodo;
import com.example.testdb.demodb.persistence.MetodoDAO;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class MetodiService {

    private MetodoDAO metodoDAO = MetodoDAO.getInstance();

    public String get(){
        return new Gson().toJson(metodoDAO.get());
    }

    public String insert(Metodo metodo){
        return new Gson().toJson(metodoDAO.insert(metodo.getTipo()));
    }
}
