package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.EnderecoDto;
import com.restaurante.grupo07.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

    public EnderecoDto toDto(Endereco endereco) {
        return new EnderecoDto(
                endereco.getId(),
                endereco.getRua(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getUf()
        );
    }

    public Endereco toEntity(EnderecoDto enderecoDto) {
        return new Endereco(
                enderecoDto.rua(),
                enderecoDto.bairro(),
                enderecoDto.cidade(),
                enderecoDto.uf()
        );
    }
}
