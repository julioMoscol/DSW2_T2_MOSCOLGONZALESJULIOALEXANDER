package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Proveedores;

import java.util.List;
import java.util.Optional;

public interface IProveedorService {
    Proveedores guardarProveedores(Proveedores proveedores);
    List<Proveedores> obtenerProveedores();
    Optional<Proveedores> obtenerProveedores(Integer id);
    Optional<Proveedores> obtenerProveedoresXNombre(String nombreProveedores);
}
