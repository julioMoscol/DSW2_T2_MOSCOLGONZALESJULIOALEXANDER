package T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.service;

import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.dto.ProductoDto;
import T2_DSW2_MOSCOLGONZALESJULIOALEXANDER.MOSCOLGONZALESJULIOALEXANDER.model.Productos;

import java.util.List;

public interface IProductoService {

    List<ProductoDto> buscarProductoNoDescontinuadosConStockMayorADiez();

    List<ProductoDto> buscarProductosConPrecioMayorA100Ordenado();
}
