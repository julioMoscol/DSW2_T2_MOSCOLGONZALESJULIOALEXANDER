package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.repository;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface VentasRepository extends JpaRepository<Ventas, Integer> {


    @Transactional
    @Modifying
    @Procedure(procedureName = "registrarNuevaVenta")
    void registrarNuevaVenta(@Param("cantidad") int cantidad,
                             @Param("fechaventa") Date fechaventa,
                             @Param("total") double total,
                             @Param("clienteid") int clienteid,
                             @Param("productoid") int productoid);

    @Transactional
    @Modifying
    @Procedure(procedureName = "actualizarProductoVenta")
    void actualizarProductoVenta(@Param("ventaid") int ventaid,
                                 @Param("cantidad") int cantidad);

}
