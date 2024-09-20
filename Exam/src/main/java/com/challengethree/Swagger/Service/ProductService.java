package com.challengethree.Swagger.Service;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.challengethree.Swagger.Entity.Product;
import com.challengethree.Swagger.Exception.CustomException;
import com.challengethree.Swagger.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository pro_re;

	public Page<Product> getAllProducts(Pageable pageable) {
		Page<Product> products = pro_re.findAll(pageable);
		return products;
	}

	public Product getProductByID(String id) {
		Product pr = pro_re.findById(id).orElseThrow(() -> new CustomException("id", "Product not found"));
		return pr;
	}

	public Product createProduct(Product pro) {
		if (pro_re.existsByCode(pro.getCode())) {
			throw new CustomException("code", "Product code already exists");
		}
		if (pro.getId() == null) {
			pro.setId(UUID.randomUUID().toString());
		}
		return pro_re.save(pro);
	}

	public Product updateProduct(String id, Product pro) {
		Product product = pro_re.findById(id).orElseThrow(() -> new CustomException("id", "Product not found"));
		product.setCode(pro.getCode());
		product.setName(pro.getName());
		product.setCategory(pro.getCategory());
		product.setBrand(pro.getBrand());
		product.setType(pro.getType());
		product.setDescription(pro.getDescription());
		Product updateProduct = pro_re.save(product);
		return updateProduct;
	}

	public void deleteProduct(String id) {
		Product product = pro_re.findById(id).orElseThrow(() -> new CustomException("id", "Product not found"));
		pro_re.delete(product);
	}
}

