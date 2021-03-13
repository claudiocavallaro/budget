package com.example.testdb.demodb.api;

import com.example.testdb.demodb.model.Metodo;
import com.example.testdb.demodb.service.MetodiService;
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
