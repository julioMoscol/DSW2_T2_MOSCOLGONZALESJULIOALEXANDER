package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.controller;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto.ClienteDto;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto.GenericResponseDto;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/clientes")
public class ClienteController {
    private final IClienteService clienteService;

    @GetMapping("/")
    public ResponseEntity<GenericResponseDto<List<ClienteDto>>> obtenerClientesXTelefono(
            @RequestParam("telefono") String telefono
    ){
        List<ClienteDto> clienteDtoList = clienteService.findByTelefono(telefono);
        if(clienteDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<ClienteDto>>builder()
                    .correcto(false)
                    .mensaje("No existe clientes").build(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ClienteDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de clientes por telefono")
                    .respuesta(clienteDtoList).build(), HttpStatus.OK);
        }
    }

    @GetMapping("/contacto-direccion/")
    public ResponseEntity<GenericResponseDto<List<ClienteDto>>> buscarClienteXContactoDireccion(@RequestParam("contacto") String contacto, @RequestParam("direccion") String direccion){
        List<ClienteDto> clienteDtoList = clienteService.buscarClientePorContactoYDireccion(contacto,direccion);
        if(clienteDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<ClienteDto>>builder()
                    .correcto(false)
                    .mensaje("No existe clientes").build(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(GenericResponseDto.<List<ClienteDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de clientes por nombre y direccion")
                    .respuesta(clienteDtoList).build(), HttpStatus.OK);
        }
    }
}
