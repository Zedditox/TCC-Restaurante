package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.ProdutoDto;
import com.restaurante.grupo07.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoDto toDto(Produto produto) {
        return new ProdutoDto(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getFoto(),
                produto.getValor(),
                produto.isDisponivel(),
                produto.getCategoria()
        );
    }

    public Produto toEntity(ProdutoDto produtoDto) {
        return new Produto(
                produtoDto.nome(),
                produtoDto.descricao(),
                produtoDto.foto(),
                produtoDto.valor(),
                produtoDto.disponivel(),
                produtoDto.categoria()
        );
    }
}
