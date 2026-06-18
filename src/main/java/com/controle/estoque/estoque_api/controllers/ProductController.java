package com.controle.estoque.estoque_api.controllers;

import com.controle.estoque.estoque_api.models.Categoria;
import com.controle.estoque.estoque_api.models.Produto;
import com.controle.estoque.estoque_api.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
        Produto produtoSalvo = productService.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }
}
