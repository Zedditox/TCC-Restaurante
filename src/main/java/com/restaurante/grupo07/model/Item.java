package com.restaurante.grupo07.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Atributo produto é obrigatório!")
    @OneToOne(fetch = FetchType.LAZY)
    private Produto produto;

    @NotNull(message = "Atributo quantidade é obrigatório!")
    @Min(1)
    private int quantidade;

    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("item")
    private Pedido pedido;

    public Item(Produto produto, int quantidade, String observacao, Pedido pedido){
        this.produto = produto;
        this.quantidade = quantidade;
        this.observacao = observacao;
        this.pedido = pedido;
    }
}
