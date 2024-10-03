package com.example.API_rest.controller;

import com.example.API_rest.conserto.Conserto;
import com.example.API_rest.conserto.ConsertoRepository;
import com.example.API_rest.conserto.DadosCadastroConserto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroConserto dados){
        repository.save(new Conserto(dados));
    }
}
