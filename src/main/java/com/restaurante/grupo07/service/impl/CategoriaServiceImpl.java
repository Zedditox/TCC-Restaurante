package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.CategoriaDto;
import com.restaurante.grupo07.dto.mapper.CategoriaMapper;
import com.restaurante.grupo07.model.Categoria;
import com.restaurante.grupo07.repository.CategoriaRepository;
import com.restaurante.grupo07.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    @Autowired
    private final CategoriaMapper categoriaMapper;

    @Override
    public CategoriaDto adicionar(CategoriaDto categoriaDto) {
        return categoriaMapper.toDto(categoriaRepository.save(categoriaMapper.toEntity(categoriaDto)));
    }

    @Override
    public CategoriaDto buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .map(entity -> categoriaMapper.toDto(entity))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<CategoriaDto> listarPorNome(String nome) {
        return categoriaRepository.findAllByNomeContainingIgnoreCase(nome)
                .stream()
                .map(entity -> categoriaMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoriaDto> listar() {
        return categoriaRepository.findAll()
                .stream()
                .map(entity -> categoriaMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoriaDto> listarDisponiveis() {
        return categoriaRepository.findByDisponivelTrue()
                .stream()
                .map(entity -> categoriaMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDto atualizar(CategoriaDto categoriaDto) {

        return categoriaRepository.findById(categoriaDto.id())
                .map(entity -> {
                    entity.setNome(categoriaDto.nome());
                    entity.setFoto(categoriaDto.foto());
                    entity.setDisponivel(categoriaDto.disponivel());
                    return categoriaMapper.toDto(categoriaRepository.save(entity));

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public CategoriaDto atualizarStatus(Long id, boolean disponivel) {
        return categoriaRepository.findById(id)
                .map(entity -> {
                    entity.setDisponivel(disponivel);
                    return categoriaMapper.toDto(categoriaRepository.save(entity));
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void excluir(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if (categoria.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        categoriaRepository.deleteById(id);
    }
}
