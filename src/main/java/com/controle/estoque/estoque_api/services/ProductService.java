package com.controle.estoque.estoque_api.services;

import com.controle.estoque.estoque_api.models.Categoria;
import com.controle.estoque.estoque_api.models.Produto;
import com.controle.estoque.estoque_api.repositories.CategoryRepository;
import com.controle.estoque.estoque_api.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Produto salvar(Produto produto) {
        if (produto.getPreco() == null || produto.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("O preço do produto deve ser maior que zero.");
        }

        if (produto.getQuantidade() == null || produto.getQuantidade() < 0) {
            throw new RuntimeException("A quantidade em estoque não pode ser negativa.");
        }

        if (produto.getCategoria() == null || produto.getCategoria().getId() == null) {
            throw new RuntimeException("A categoria deve ser informada.");
        }

        boolean categoriaExiste = categoryRepository.existsById(produto.getCategoria().getId());

        if (!categoriaExiste) {
            throw new RuntimeException("A categoria informada não existe.");
        }

        return productRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return productRepository.findAll();
    }
}
