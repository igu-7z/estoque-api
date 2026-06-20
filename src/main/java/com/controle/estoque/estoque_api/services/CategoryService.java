package com.controle.estoque.estoque_api.services;

import com.controle.estoque.estoque_api.models.Categoria;
import com.controle.estoque.estoque_api.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Categoria salvar(Categoria categoria){
        return categoryRepository.save(categoria);
    }

    public List<Categoria> listarTodas() {
        return categoryRepository.findAll();
    }
}
