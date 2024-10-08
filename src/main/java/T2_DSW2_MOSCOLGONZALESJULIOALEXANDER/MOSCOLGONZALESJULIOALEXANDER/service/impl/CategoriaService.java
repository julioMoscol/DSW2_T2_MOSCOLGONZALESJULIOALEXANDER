package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service.impl;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Categorias;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.repository.CategoriaRepository;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service.ICategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService implements ICategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public Categorias guardarCategoria(Categorias categorias) {
        return categoriaRepository.save(categorias);
    }

    @Override
    public List<Categorias> obtenerCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categorias> obtenerCategorias(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Optional<Categorias> obtenerCategoriaXNombre(String categoryName) {
        return categoriaRepository.findByNombrecategoria(categoryName);
    }
}
