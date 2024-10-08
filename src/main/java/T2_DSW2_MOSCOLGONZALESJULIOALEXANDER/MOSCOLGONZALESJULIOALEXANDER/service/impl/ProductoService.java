package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service.impl;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto.ProductoDto;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Productos;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.repository.ProductosRepository;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service.IProductoService;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.utils.convert.ProductoConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService implements IProductoService {

    private final ProductosRepository productosRepository;
    private final ProductoConvert productoConvert;

    @Override
    public List<ProductoDto> buscarProductoNoDescontinuadosConStockMayorADiez() {
        List<ProductoDto> productoDtos = new ArrayList<>();
        for (Productos productos : productosRepository.buscarProductoNoDescontinuadosConStockMayorADiez()){
            productoDtos.add(productoConvert.convertirObjectoADto(productos));
        }
        return productoDtos;
    }

    @Override
    public List<ProductoDto> buscarProductosConPrecioMayorA100Ordenado() {
        List<ProductoDto> productoDtos = new ArrayList<>();
        for (Productos productos : productosRepository.buscarProductosConPrecioMayorA100Ordenado()) {
            productoDtos.add(productoConvert.convertirObjectoADto(productos));
        }
        return productoDtos;
    }
}
