package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.repository;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Clientes;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.repository.projection.ConteoClientePorTelefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

    List<Clientes> findByTelefono(String telefono);

    @Query("SELECT c FROM Clientes c WHERE c.contacto = :contacto AND c.direccion = :direccion")
    List<Clientes> buscarClientePorContactoYDireccion(@Param("contacto") String contacto, @Param("direccion") String direccion);

    @Query("SELECT c.telefono AS telefono, COUNT(c) AS clienteConteo FROM Clientes c GROUP BY c.telefono")
    List<ConteoClientePorTelefono> contarClientesAgrupadosPorTelefono();

}
