package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.utils.convert;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto.ProductoDto;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Productos;
import org.springframework.stereotype.Component;

@Component
public class ProductoConvert {

    public ProductoDto convertirObjectoADto(Productos producto) {
        return ProductoDto.builder()
                .nombreproducto(producto.getNombreproducto())
                .cantidadporunidad(producto.getCantidadporunidad())
                .preciounitario(producto.getPreciounitario())
                .unidadesenstock(producto.getUnidadesenstock())
                .unidadesenpedido(producto.getUnidadesenpedido())
                .nivelreorden(producto.getNivelreorden())
                .descontinuado(producto.isDescontinuado())
                .proveedorid(producto.getProveedorid())
                .categoriaid(producto.getCategoriaid())
                .build();
    }
}
