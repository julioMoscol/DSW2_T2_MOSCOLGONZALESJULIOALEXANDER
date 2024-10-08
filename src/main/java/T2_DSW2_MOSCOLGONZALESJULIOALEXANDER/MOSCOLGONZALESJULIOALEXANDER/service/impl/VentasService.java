package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service.impl;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto.VentasDto;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.repository.VentasRepository;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service.IVentasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VentasService implements IVentasService {

    private final VentasRepository ventasRepository;

    @Override
    public void registrarNuevaVenta(VentasDto ventasDto) {
        ventasRepository.registrarNuevaVenta(
                ventasDto.getCantidad(),
                ventasDto.getFechaventa(),
                ventasDto.getTotal(),
                ventasDto.getClienteid(),
                ventasDto.getProductoid()
        );
    }

    @Override
    public void actualizarProductoVenta(int ventaid, int cantidad) {
        ventasRepository.actualizarProductoVenta(ventaid, cantidad);
    }
}
