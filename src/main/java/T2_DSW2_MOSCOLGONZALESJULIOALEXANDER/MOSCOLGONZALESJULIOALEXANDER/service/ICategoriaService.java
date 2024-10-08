package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Categorias;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
    Categorias guardarCategoria(Categorias categorias);
    List<Categorias> obtenerCategorias();
    Optional<Categorias> obtenerCategorias(Integer id);
    Optional<Categorias> obtenerCategoriaXNombre(String categoryName);
}
