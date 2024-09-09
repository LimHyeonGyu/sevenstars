package deu.ex.sevenstars.repository;

import deu.ex.sevenstars.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
