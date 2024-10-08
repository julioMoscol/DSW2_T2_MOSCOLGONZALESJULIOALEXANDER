package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
