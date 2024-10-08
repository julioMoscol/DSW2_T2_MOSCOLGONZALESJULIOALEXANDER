package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.repository;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, Integer> {
    Optional<Proveedores> findByNombreproveedor(String nombreproveedor);
}
