package com.controle.estoque.estoque_api.models;

import jakarta.persistence.*;
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
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
