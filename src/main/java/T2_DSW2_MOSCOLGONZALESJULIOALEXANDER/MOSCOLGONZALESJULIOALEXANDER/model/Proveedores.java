package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proveedores")
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer proveedorid;
    private String nombreproveedor;
    private String contacto;
    private String direccion;
    private String telefono;
    private String email;
}
