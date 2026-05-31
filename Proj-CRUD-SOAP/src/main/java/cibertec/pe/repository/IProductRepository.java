package cibertec.pe.repository;

import cibertec.pe.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Producto, Integer> {
}
