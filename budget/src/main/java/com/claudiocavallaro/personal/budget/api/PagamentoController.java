package com.claudiocavallaro.personal.budget.api;

import com.claudiocavallaro.personal.budget.model.PagamentoEffettuato;
import com.claudiocavallaro.personal.budget.service.PagamentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentiService service;

    //Get all payment
    @GetMapping("/get")
    public String selectMetod(){
        return service.get();
    }

    //Get Month payment
    @GetMapping("/getMonth")
    public String selectByMonth(@RequestParam String month){
        return service.getMonth(month);
    }

    //Add Payment
    @PostMapping("/add")
    public String add(@RequestBody PagamentoEffettuato pagamentoEffettuato){
        return service.insert(pagamentoEffettuato);
    }
}
