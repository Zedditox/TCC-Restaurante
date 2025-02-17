package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.ContatoDto;
import com.restaurante.grupo07.service.ContatoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
@RequiredArgsConstructor
public class ContatoResource {

    @Autowired
    private final ContatoService contatoService;

    @PostMapping
    @Transactional
    public ContatoDto adicionar(@Valid @RequestBody ContatoDto contatoDto) {
        return contatoService.adicionar(contatoDto);
    }

    @GetMapping("/{id}")
    public ContatoDto buscarPorId(@PathVariable("id") @NotNull Long id) {
        return contatoService.buscarPorId(id);
    }

    @GetMapping("/listar")
    public List<ContatoDto> listar() {
        return contatoService.listar();
    }

    @PutMapping
    @Transactional
    public ContatoDto atualizar(@Valid @RequestBody ContatoDto contatoDto) {
        return contatoService.atualizar(contatoDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        contatoService.excluir(id);
    }
}
