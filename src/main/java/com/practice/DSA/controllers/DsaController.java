package com.practice.DSA.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.DSA.services.DsaService;


@RestController
@RequestMapping("/api/dsa")
public class DsaController {
    private final DsaService dsaService;

    public DsaController(DsaService dsaService) {
        this.dsaService = dsaService;
    }

    @GetMapping("/hello")
    public String hello() {
        return dsaService.getMessage();
    }
    
}
