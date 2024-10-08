package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service.impl;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Proveedores;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.repository.ProveedoresRepository;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service.IProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProveedorService implements IProveedorService {

    private final ProveedoresRepository proveedoresRepository;


    @Override
    public Proveedores guardarProveedores(Proveedores proveedores) {
        return proveedoresRepository.save(proveedores);
    }

    @Override
    public List<Proveedores> obtenerProveedores() {
        return proveedoresRepository.findAll();
    }

    @Override
    public Optional<Proveedores> obtenerProveedores(Integer id) {
        return proveedoresRepository.findById(id);
    }

    @Override
    public Optional<Proveedores> obtenerProveedoresXNombre(String nombreProveedores) {
        return proveedoresRepository.findByNombreproveedor(nombreProveedores);
    }
}
