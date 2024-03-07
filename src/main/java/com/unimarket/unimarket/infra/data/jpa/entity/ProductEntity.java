package com.unimarket.unimarket.infra.data.jpa.entity;

import com.unimarket.unimarket.core.entities.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String productCode;
    private String name;
    private BigDecimal price;
    private String description;
    private Integer amount;
    private String image;

    @ManyToOne
    private CategoryEntity category;
}
