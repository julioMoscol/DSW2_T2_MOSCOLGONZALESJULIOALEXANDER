package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto.ClienteDto;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Clientes;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.repository.projection.ConteoClientePorTelefono;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IClienteService {

    List<ClienteDto> findByTelefono(String telefono);
    List<ClienteDto> buscarClientePorContactoYDireccion(String contacto, String direccion);
    List<ConteoClientePorTelefono> contarClientesAgrupadosPorTelefono();
}
