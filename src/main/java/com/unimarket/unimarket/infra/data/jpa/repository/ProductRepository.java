package com.unimarket.unimarket.infra.data.jpa.repository;

import com.unimarket.unimarket.infra.data.jpa.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findByProductCode(String productCode);

    boolean existsByProductCodeIgnoreCase(String productCode);

    @Query(value = "SELECT * FROM product WHERE LOWER(name) LIKE LOWER(CONCAT('%', :keyword, '%'))" +
            " OR LOWER(price) LIKE LOWER(CONCAT('%', :keyword, '%'))" +
            " OR LOWER(description) LIKE LOWER(CONCAT('%', :keyword, '%'))" +
            " OR LOWER(category.name) LIKE LOWER(CONCAT('%', :keyword, '%'))", nativeQuery = true)
    List<ProductEntity> searchByKeyword(String keyword);
}
