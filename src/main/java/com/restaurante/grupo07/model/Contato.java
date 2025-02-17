package com.restaurante.grupo07.model;

import ch.qos.logback.classic.spi.LoggingEventVO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Atributo email é obrigatório!")
    @Email(message = "Atributo email deverá ser um email válido!")
    private String email;

    @NotBlank(message = "Atributo telefone é obrigatório!")
    private String telefone;

    public Contato(String email, String telefone) {
        this.email = email;
        this.telefone = telefone;
    }
}
