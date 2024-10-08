package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto.VentasDto;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Ventas;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVentasService {

    void registrarNuevaVenta(VentasDto ventasDto);
    void actualizarProductoVenta(int ventaid, int cantidad);
}
