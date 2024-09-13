package com.challengethree.Swagger.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challengethree.Swagger.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	boolean existsByCode(String code);
}
