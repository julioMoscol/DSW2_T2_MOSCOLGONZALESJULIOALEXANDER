package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.repository;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductosRepository extends JpaRepository<Productos, Integer> {

    @Query("SELECT c FROM Productos c WHERE c.descontinuado = false AND c.unidadesenstock > 10")
    List<Productos> buscarProductoNoDescontinuadosConStockMayorADiez();

    @Query("SELECT c FROM Productos c WHERE c.preciounitario > 100 ORDER BY c.preciounitario DESC")
    List<Productos> buscarProductosConPrecioMayorA100Ordenado();
}
