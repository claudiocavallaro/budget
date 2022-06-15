package com.claudiocavallaro.personal.budget.api;

import com.claudiocavallaro.personal.budget.model.Metodo;
import com.claudiocavallaro.personal.budget.service.MetodiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/metodo")
public class MetodoController {

    @Autowired
    private MetodiService metodiService;

    @GetMapping("/get")
    public String selectMetod(){
        return metodiService.get();
    }

    @PostMapping("/add")
    public String add(@RequestBody Metodo metodo){
        return metodiService.insert(metodo);
    }
}
