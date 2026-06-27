package com.controle.estoque.estoque_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tb_produto")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotBlank(message = "O nome do produto é obrigatório e não pode ficar em branco.")
    private String nome;
    @Positive(message = "O preço do produto deve ser maior do que zero.")
    private BigDecimal preco;
    @PositiveOrZero(message = "A quantidade do produto não pode ficar negativa.")
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
