package com.unimarket.unimarket.infra.data.jpa.entity;

import com.unimarket.unimarket.core.entities.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_category")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String categoryName;
}
