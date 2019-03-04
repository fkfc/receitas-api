package com.fkfc.receitasapi.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceitasRestController {
    @CrossOrigin
    @RequestMapping("/")
    public String root() {
        return "REST controller is running";
    }

}
