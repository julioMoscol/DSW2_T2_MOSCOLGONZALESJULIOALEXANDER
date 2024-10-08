package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Clientes {

    @Id
    private Integer clienteid;
    private String nombrecliente;
    private String contacto;
    private String direccion;
    private String telefono;
    private String email;
}
