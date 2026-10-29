package br.com.glaucotodesco.jparelacionamentos.service;

import br.com.glaucotodesco.jparelacionamentos.dto.CategoriaRequest;
import br.com.glaucotodesco.jparelacionamentos.dto.CategoriaResponse;
import br.com.glaucotodesco.jparelacionamentos.model.Categoria;
import br.com.glaucotodesco.jparelacionamentos.repository.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public CategoriaResponse criar(CategoriaRequest request) {
        var categoria = new Categoria();
        categoria.setNome(request.nome());

        return CategoriaResponse.from(categoriaRepository.save(categoria));
    }

    @Transactional(readOnly = true)
    public List<CategoriaResponse> listar() {
        return categoriaRepository.findAll().stream()
                .sorted(Comparator.comparing(Categoria::getId))
                .map(CategoriaResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public CategoriaResponse buscar(Long id) {
        return CategoriaResponse.from(buscarEntidade(id));
    }

    private Categoria buscarEntidade(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Categoria não encontrada: " + id
                ));
    }
}
