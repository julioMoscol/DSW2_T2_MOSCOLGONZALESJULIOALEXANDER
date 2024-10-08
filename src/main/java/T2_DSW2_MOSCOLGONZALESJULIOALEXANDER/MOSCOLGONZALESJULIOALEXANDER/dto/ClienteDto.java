package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClienteDto {

    private Integer clienteId;
    private String nombrecliente;
    private String contacto;
    private String direccion;
    private String telefono;
    private String email;
}
