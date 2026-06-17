package com.controle.estoque.estoque_api.models;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "tb_categoria")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
}
