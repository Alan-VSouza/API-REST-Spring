package com.example.API_rest.controller;

import com.example.API_rest.conserto.Conserto;
import com.example.API_rest.conserto.ConsertoRepository;
import com.example.API_rest.conserto.DadosCadastroConserto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @GetMapping
    public Page<Conserto> listarTodos(Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroConserto dados){
        repository.save(new Conserto(dados));
    }
}
