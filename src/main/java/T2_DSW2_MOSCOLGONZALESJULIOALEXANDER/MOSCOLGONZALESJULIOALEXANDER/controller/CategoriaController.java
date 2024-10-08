package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.controller;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.exception.ResourceNotFoundException;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Categorias;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service.ICategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/categoria")
public class CategoriaController {

    private final ICategoriaService categoriaService;

    @GetMapping("")
    public ResponseEntity<List<Categorias>> listarCategorias(){
        List<Categorias> categoriasList = categoriaService.obtenerCategorias();
        if(categoriasList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoriasList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorias> obtenerCategoriaXid(@PathVariable Integer id){
        Categorias categorias = categoriaService.obtenerCategorias(id).orElseThrow(() -> new ResourceNotFoundException("La categoria con el id: " + id+ " no existe"));
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Categorias> obtenerCategoriaxNombre(@RequestParam String categoryName){
        Categorias categorias = categoriaService.obtenerCategoriaXNombre(categoryName).orElseThrow(() -> new ResourceNotFoundException("La categoria con el nombre: " + categoryName+ " no existe"));
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Categorias> registrarCategoria(@RequestBody Categorias categorias){
        return new ResponseEntity<>(categoriaService.guardarCategoria(categorias), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorias> actualizarCategoria(@PathVariable Integer id, @RequestBody Categorias categorias){
        Categorias currentCategoria = categoriaService.obtenerCategorias(id).orElseThrow(() -> new ResourceNotFoundException("La categoria con el ID: "+id+" no existe."));
        currentCategoria.setNombrecategoria(categorias.getNombrecategoria());
        currentCategoria.setDescripcion(categorias.getDescripcion());
        return new ResponseEntity<>(categoriaService.guardarCategoria(currentCategoria), HttpStatus.ACCEPTED);
    }
}
