package com.challengethree.Swagger.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challengethree.Swagger.Entity.Product;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
	boolean existsByCode(String code);
}
