package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.ItemDto;
import com.restaurante.grupo07.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDto toDto(Item item) {
        return new ItemDto(
            item.getId(),
            item.getProduto(),
            item.getQuantidade(),
            item.getObservacao(),
            item.getPedido()
        );
    }

    public Item toEntity(ItemDto itemDto) {
        return new Item(
            itemDto.produto(),
            itemDto.quantidade(),
            itemDto.observacao(),
            itemDto.pedido()
        );
    }
} 