package com.example.testdb.demodb.api;

import com.example.testdb.demodb.model.PagamentoEffettuato;
import com.example.testdb.demodb.service.PagamentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentiService service;

    @GetMapping("/get")
    public String selectMetod(){
        return service.get();
    }

    @GetMapping("/getMonth")
    public String selectByMonth(@RequestParam String month){
        return service.getMonth(month);
    }

    @PostMapping("/add")
    public String add(@RequestBody PagamentoEffettuato pagamentoEffettuato){
        return service.insert(pagamentoEffettuato);
    }
}
