package cibertec.pe;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.jws.WebService;

@WebService
@Component
public class ProductoImplements implements IProductoService{

    private final IProductoRepository prodRepo;

    public ProductoImplements(IProductoRepository prodRepo){
        this.prodRepo = prodRepo;
    }

    @Override
    public List<Producto> getAllProducts() {
        return prodRepo.findAll();
    }

    @Override
    public Producto createProduct(Producto producto) {
        return prodRepo.save(producto);
    }

    @Override
    public Producto findProducto(int codigo) {
        return prodRepo.findById(codigo).orElse(null);
    }

    @Override
    public String updateProducto(int codigo, Producto producto) {
        Producto prod = prodRepo.findById(codigo).get();
        if(prod != null){
            prod.setNombre(producto.getNombre());
            prod.setPrecio(producto.getPrecio());
            prod.setCantidad(producto.getCantidad());

            prodRepo.save(prod);
            return "Producto Actualizado";
        } return "Error";
    }

    @Override
    public String deleteProducto(int codigo) {
        if (prodRepo.existsById(codigo)) {
            prodRepo.deleteById(codigo);
            return "Producto eliminado";
        }else return "Error: Producto no encontrado";
    }



}
