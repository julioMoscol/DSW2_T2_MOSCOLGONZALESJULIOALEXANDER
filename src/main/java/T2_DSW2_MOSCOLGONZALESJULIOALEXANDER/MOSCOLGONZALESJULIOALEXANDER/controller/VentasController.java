package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.controller;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto.GenericResponseDto;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto.VentasDto;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Ventas;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service.IVentasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/ventas")
public class VentasController {

    private final IVentasService ventasService;

    @PostMapping
    public ResponseEntity<GenericResponseDto<String>> registrarNuevaVenta(@RequestBody VentasDto ventasDto){
        try {
            ventasService.registrarNuevaVenta(ventasDto);
            return new ResponseEntity<>(GenericResponseDto
                    .<String>builder().correcto(true)
                    .mensaje("Ventana registrada correctamente")
                    .build(), HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(GenericResponseDto
                    .<String>builder().correcto(false)
                    .mensaje("Venta NO registrada")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{ventaid}")
    public ResponseEntity<GenericResponseDto<String>> actualizarProductoVenta(
            @PathVariable int ventaid,
            @RequestBody VentasDto ventasDto) {
        try {
            ventasService.actualizarProductoVenta(ventaid, ventasDto.getCantidad());
            return new ResponseEntity<>(GenericResponseDto
                    .<String>builder().correcto(true)
                    .mensaje("Venta actualizada correctamente")
                    .build(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(GenericResponseDto
                    .<String>builder().correcto(false)
                    .mensaje("Venta NO actualizada")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
