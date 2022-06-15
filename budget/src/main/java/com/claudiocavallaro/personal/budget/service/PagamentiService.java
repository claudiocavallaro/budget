package com.claudiocavallaro.personal.budget.service;

import com.claudiocavallaro.personal.budget.model.PagamentoEffettuato;
import com.claudiocavallaro.personal.budget.persistence.MetodoDAO;
import com.claudiocavallaro.personal.budget.persistence.PagamentoDAO;
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
            if (!pagamentoEffettuato.isRecurring()){
                boolean flag = pagamentoDAO.insert(pagamentoEffettuato.getImporto(), pagamentoEffettuato.getNote(), pagamentoEffettuato.getData(), id, pagamentoEffettuato.isRecurring());
                if (flag){
                    return "OK";
                }
            } else {
                if (pagamentoEffettuato.getRecurringType() == null || pagamentoEffettuato.getRecurringType().isEmpty()){
                    //default
                    pagamentoEffettuato.setRecurringType("mensile");
                }
                boolean flag = pagamentoDAO.insertWithRecurring(pagamentoEffettuato.getImporto(), pagamentoEffettuato.getNote(), pagamentoEffettuato.getData(), id, pagamentoEffettuato.isRecurring(), pagamentoEffettuato.getRecurringType());
                if (flag){
                    return "OK";
                }
            }
        }
        return "NOT INSERTED! PROBLEMS WITH PAYMENT METHOD";
    }

}
