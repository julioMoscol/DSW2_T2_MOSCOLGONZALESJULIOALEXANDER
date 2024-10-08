package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.controller;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.exception.ResourceNotFoundException;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Categorias;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Proveedores;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service.IProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/proveedor")
public class ProveedorController {

    private final IProveedorService proveedorService;

    @GetMapping("")
    public ResponseEntity<List<Proveedores>> listarProveedores(){
        List<Proveedores> proveedoresList = proveedorService.obtenerProveedores();
        if(proveedoresList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(proveedoresList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedores> obtenerProveedoresXid(@PathVariable Integer id){
        Proveedores proveedor = proveedorService.obtenerProveedores(id).orElseThrow(() -> new ResourceNotFoundException("El Proveedor con el id: " + id+ " no existe"));
        return new ResponseEntity<>(proveedor, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Proveedores> obtenerProveedorxNombre(@RequestParam String proveedorName){
        Proveedores proveedor = proveedorService.obtenerProveedoresXNombre(proveedorName).orElseThrow(() -> new ResourceNotFoundException("El Proveedor con el nombre: " + proveedorName+ " no existe"));
        return new ResponseEntity<>(proveedor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Proveedores> registrarProveedor(@RequestBody Proveedores proveedores){
        return new ResponseEntity<>(proveedorService.guardarProveedores(proveedores), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedores> actualizarProveedor(@PathVariable Integer id, @RequestBody Proveedores proveedores){
        Proveedores currentProveedor = proveedorService.obtenerProveedores(id).orElseThrow(() -> new ResourceNotFoundException("El Proveedor con el ID: "+id+" no existe."));
        currentProveedor.setNombreproveedor(proveedores.getNombreproveedor());
        currentProveedor.setContacto(proveedores.getContacto());
        currentProveedor.setDireccion(proveedores.getDireccion());
        currentProveedor.setTelefono(proveedores.getTelefono());
        currentProveedor.setEmail(proveedores.getEmail());
        return new ResponseEntity<>(proveedorService.guardarProveedores(currentProveedor), HttpStatus.ACCEPTED);
    }
}
