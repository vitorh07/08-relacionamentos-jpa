package br.com.glaucotodesco.jparelacionamentos.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequest(
        @NotBlank String nome
) {
}
