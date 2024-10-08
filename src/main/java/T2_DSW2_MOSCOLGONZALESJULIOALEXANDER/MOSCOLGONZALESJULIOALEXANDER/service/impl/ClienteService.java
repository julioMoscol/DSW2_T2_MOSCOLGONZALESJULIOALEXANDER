package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service.impl;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto.ClienteDto;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Clientes;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.repository.ClientesRepository;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.repository.projection.ConteoClientePorTelefono;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service.IClienteService;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.utils.convert.ClienteConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService {

    private final ClientesRepository clientesRepository;
    private final ClienteConvert clienteConvert;

    @Override
    public List<ClienteDto> findByTelefono(String telefono) {
        List<ClienteDto> clienteDtos = new ArrayList<>();
        for(Clientes clientes : clientesRepository.findByTelefono(telefono)){
            clienteDtos.add(clienteConvert.convertirObjectoADto(clientes));
        }
        return clienteDtos;
    }

    @Override
    public List<ClienteDto> buscarClientePorContactoYDireccion(String contacto, String direccion) {
        List<ClienteDto> clienteDtos = new ArrayList<>();
        for (Clientes clientes : clientesRepository.buscarClientePorContactoYDireccion(contacto, direccion)){
            clienteDtos.add(clienteConvert.convertirObjectoADto(clientes));
        };
        return clienteDtos;
    }

    @Override
    public List<ConteoClientePorTelefono> contarClientesAgrupadosPorTelefono() {
        return clientesRepository.contarClientesAgrupadosPorTelefono();
    }
}
