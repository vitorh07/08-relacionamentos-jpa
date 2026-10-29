package br.com.glaucotodesco.jparelacionamentos.dto;

import br.com.glaucotodesco.jparelacionamentos.model.Categoria;

public record CategoriaResponse(
        Long id,
        String nome
) {
    public static CategoriaResponse from(Categoria categoria) {
        return new CategoriaResponse(
                categoria.getId(),
                categoria.getNome()
        );
    }
}
