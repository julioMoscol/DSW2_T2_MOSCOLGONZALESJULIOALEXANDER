package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.controller;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto.GenericResponseDto;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto.ProductoDto;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/productos")
public class ProductoController {

    private final IProductoService productoService;

    @GetMapping("/stock-disponible/")
    public ResponseEntity<GenericResponseDto<List<ProductoDto>>> buscarProductosNoDescontinuadosConStockMayorADiez() {
        List<ProductoDto> productoDtos = productoService.buscarProductoNoDescontinuadosConStockMayorADiez();
        if(productoDtos.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<ProductoDto>>builder()
                    .correcto(false)
                    .mensaje("No hay productos con stock mayor a 10").build(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(GenericResponseDto.<List<ProductoDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de productos con stock mayor a 10")
                    .respuesta(productoDtos).build(), HttpStatus.OK);
        }
    }

    @GetMapping("/precio-mayor-100/")
    public ResponseEntity<GenericResponseDto<List<ProductoDto>>> buscarProductosConPrecioMayorA100Ordenado() {
        List<ProductoDto> productoDtoList = productoService.buscarProductosConPrecioMayorA100Ordenado();
        if(productoDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<ProductoDto>>builder()
                    .correcto(false)
                    .mensaje("No hay productos con precio mayor a 100").build(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(GenericResponseDto.<List<ProductoDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de productos con precio mayor a 100")
                    .respuesta(productoDtoList).build(), HttpStatus.OK);
        }
    }
}
