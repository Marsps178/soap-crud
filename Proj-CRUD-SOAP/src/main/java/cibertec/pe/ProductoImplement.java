package cibertec.pe;

import org.springframework.stereotype.Component;

import jakarta.jws.WebService;

@WebService
@Component
public class ProductoImplement implements IProductoService {

    private final IProductRepository productRepository;

    public ProductoImplement(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public java.util.List<Producto> getAllProductos() {
        return productRepository.findAll();
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productRepository.save(producto);
    }

    @Override
    public Producto getProductoById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public String updateProducto(Integer id, Producto producto) {
        if (productRepository.existsById(id)) {
            producto.setId(id);
            productRepository.save(producto);
            return "Producto actualizado correctamente.";
        } else {
            return "Producto no encontrado.";
        }
    }

    @Override
    public String deleteProducto(Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "Producto eliminado correctamente.";
        } else {
            return "Producto no encontrado.";
        }
    }

}
