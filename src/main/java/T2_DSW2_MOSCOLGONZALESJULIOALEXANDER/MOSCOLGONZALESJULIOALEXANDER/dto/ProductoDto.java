package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Categorias;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Proveedores;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductoDto {

    private Integer productoid;
    private String nombreproducto;
    private String cantidadporunidad;
    private Double preciounitario;
    private Integer unidadesenstock;
    private Integer unidadesenpedido;
    private Integer nivelreorden;
    private boolean descontinuado;
    @ManyToOne
    @JoinColumn(name = "proveedorid")
    private Proveedores proveedorid;
    @ManyToOne
    @JoinColumn(name = "categoriaid")
    private Categorias categoriaid;
}
