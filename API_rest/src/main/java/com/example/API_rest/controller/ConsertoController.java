package com.example.API_rest.controller;

import com.example.API_rest.conserto.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @GetMapping
    public ResponseEntity listarTodos(Pageable paginacao) {
        return ResponseEntity.ok(repository.findAll(paginacao));
    }

    @GetMapping("algunsdados")
    public ResponseEntity listarAlgunsDados() {
        return ResponseEntity.ok(repository.findAllByAtivoTrue().stream().map(DadosListagemConserto::new).toList());
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConserto dados, UriComponentsBuilder uriBuilder){
        var conserto = new Conserto(dados);
        repository.save(conserto);

        var uri = uriBuilder.path("/conserto/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemConserto(conserto));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {

        Conserto conserto = repository.getReferenceById( dados.id() );
        conserto.atualizarInformacoes(dados);

        return ResponseEntity.ok( new DadosDetalhamentoConserto(conserto) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conserto> getConsertoById(@PathVariable Long id) {
        Optional<Conserto> consertoOptional = repository.findById(id);
        return consertoOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();

        return ResponseEntity.noContent().build();
    }
}
