package com.controle.estoque.estoque_api.services;

import com.controle.estoque.estoque_api.models.Categoria;
import com.controle.estoque.estoque_api.models.Produto;
import com.controle.estoque.estoque_api.repositories.CategoryRepository;
import com.controle.estoque.estoque_api.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
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

    public Produto atualizar(Long id, Produto dadosAtualizados) {
        Produto produtoExistentes = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (dadosAtualizados.getNome() != null) {
            produtoExistentes.setNome(dadosAtualizados.getNome());
        }
        if (dadosAtualizados.getPreco() != null) {
            produtoExistentes.setPreco(dadosAtualizados.getPreco());
        }
        if (dadosAtualizados.getQuantidade() != null) {
            produtoExistentes.setQuantidade(dadosAtualizados.getQuantidade());
        }

        if (dadosAtualizados.getCategoria() != null && dadosAtualizados.getCategoria().getId() != null) {
            boolean categoriaExiste = categoryRepository.existsById(dadosAtualizados.getCategoria().getId());

            if (!categoriaExiste) {
                throw new RuntimeException("A nova categoria informada não existe.");
            }

            produtoExistentes.setCategoria(dadosAtualizados.getCategoria());
        }

        return productRepository.save(produtoExistentes);
    }

    public void deletar(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado para exclusão");
        }

        productRepository.deleteById(id);
    }
}
