package com.controle.estoque.estoque_api.repositories;


import com.controle.estoque.estoque_api.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categoria, Long> {
}
