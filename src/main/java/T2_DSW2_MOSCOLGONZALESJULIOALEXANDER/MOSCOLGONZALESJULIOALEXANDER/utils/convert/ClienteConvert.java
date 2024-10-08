package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.utils.convert;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto.ClienteDto;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Clientes;
import org.springframework.stereotype.Component;

@Component
public class ClienteConvert {

    public ClienteDto convertirObjectoADto(Clientes clientes){
        return ClienteDto.builder().nombrecliente(clientes.getNombrecliente()).contacto(clientes.getContacto()).direccion(clientes.getDireccion()).telefono(clientes.getTelefono()).email(clientes.getEmail()).build();

    }
}
