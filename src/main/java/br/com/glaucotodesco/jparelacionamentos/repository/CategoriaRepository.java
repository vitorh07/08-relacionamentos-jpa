package br.com.glaucotodesco.jparelacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.glaucotodesco.jparelacionamentos.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
