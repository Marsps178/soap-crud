package cibertec.pe.service;

import cibertec.pe.dto.ProductoRequest;
import cibertec.pe.dto.ProductoResponse;
import cibertec.pe.entity.Producto;
import cibertec.pe.repository.IProductRepository;
import jakarta.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@WebService
@Component
public class ProductoImplement implements IProductoService {

    private static final Logger log = LoggerFactory.getLogger(ProductoImplement.class);

    private final IProductRepository productRepository;

    public ProductoImplement(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductoResponse> getAllProductos() {
        log.info("Obteniendo todos los productos");
        return productRepository.findAll()
                .stream()
                .map(ProductoMapper::toResponse)
                .toList();
    }

    @Override
    public ProductoResponse getProductoById(Integer id) {
        log.info("Buscando producto por ID: {}", id);
        if (id == null) {
            return ProductoMapper.toErrorResponse("El ID no puede ser nulo");
        }
        return productRepository.findById(id)
                .map(ProductoMapper::toResponse)
                .orElse(ProductoMapper.toErrorResponse("Producto con ID " + id + " no encontrado"));
    }

    @Override
    public ProductoResponse createProducto(ProductoRequest request) {
        log.info("Creando nuevo producto: {}", request != null ? request.getNombre() : "null");
        String error = validarRequest(request);
        if (error != null) {
            return ProductoMapper.toErrorResponse(error);
        }
        Producto entity = ProductoMapper.toEntity(request);
        Producto saved = productRepository.save(entity);
        log.info("Producto creado con ID: {}", saved.getId());
        return ProductoMapper.toResponse(saved, "Producto creado correctamente");
    }

    @Override
    public ProductoResponse updateProducto(Integer id, ProductoRequest request) {
        log.info("Actualizando producto ID: {}", id);
        if (id == null) {
            return ProductoMapper.toErrorResponse("El ID no puede ser nulo");
        }
        String error = validarRequest(request);
        if (error != null) {
            return ProductoMapper.toErrorResponse(error);
        }
        return productRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(request.getNombre());
                    existing.setPrecio(request.getPrecio());
                    Producto saved = productRepository.save(existing);
                    log.info("Producto ID {} actualizado", saved.getId());
                    return ProductoMapper.toResponse(saved, "Producto actualizado correctamente");
                })
                .orElse(ProductoMapper.toErrorResponse("Producto con ID " + id + " no encontrado"));
    }

    @Override
    public ProductoResponse deleteProducto(Integer id) {
        log.info("Eliminando producto ID: {}", id);
        if (id == null) {
            return ProductoMapper.toErrorResponse("El ID no puede ser nulo");
        }
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            log.info("Producto ID {} eliminado", id);
            ProductoResponse response = new ProductoResponse();
            response.setSuccess(true);
            response.setMensaje("Producto eliminado correctamente");
            return response;
        } else {
            return ProductoMapper.toErrorResponse("Producto con ID " + id + " no encontrado");
        }
    }

    private String validarRequest(ProductoRequest request) {
        if (request == null) {
            return "La solicitud no puede ser nula";
        }
        if (request.getNombre() == null || request.getNombre().isBlank()) {
            return "El nombre del producto no puede estar vacío";
        }
        if (request.getPrecio() < 0) {
            return "El precio del producto no puede ser negativo";
        }
        return null;
    }
}
