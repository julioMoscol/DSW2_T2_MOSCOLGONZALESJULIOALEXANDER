package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.utils.convert;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto.VentasDto;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Ventas;
import org.springframework.stereotype.Component;

@Component
public class VentasConvert {

    public VentasDto convertirObjectoADto(Ventas ventas){
        return VentasDto.builder()
                .cantidad(ventas.getCantidad())
                .fechaventa(ventas.getFechaventa())
                .total(ventas.getTotal())
                .clienteid(ventas.getClienteid().getClienteid())
                .productoid(ventas.getProductoid().getProductoid())
                .build();
    }
}
