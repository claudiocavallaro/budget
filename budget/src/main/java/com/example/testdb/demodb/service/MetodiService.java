package com.example.testdb.demodb.service;

import com.example.testdb.demodb.model.Metodo;
import com.example.testdb.demodb.persistence.MetodoDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

@Service
public class MetodiService {

    private MetodoDAO metodoDAO = MetodoDAO.getInstance();

    public String get(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(metodoDAO.get());
    }

    public String insert(Metodo metodo){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(metodoDAO.insert(metodo.getTipo()));
    }
}
