package com.controle.estoque.estoque_api.repositories;

import com.controle.estoque.estoque_api.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Produto, Long> {
}
