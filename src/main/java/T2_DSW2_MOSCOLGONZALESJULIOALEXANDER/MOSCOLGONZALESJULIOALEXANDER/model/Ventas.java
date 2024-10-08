package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ventaid;
    private Integer cantidad;
    private Date fechaventa;
    private Double total;
    @ManyToOne
    @JoinColumn(name = "clienteid")
    private Clientes clienteid;
    @ManyToOne
    @JoinColumn(name = "productoid")
    private Productos productoid;
}
