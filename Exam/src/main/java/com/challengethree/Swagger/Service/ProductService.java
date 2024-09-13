package com.challengethree.Swagger.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challengethree.Swagger.Entity.Product;
import com.challengethree.Swagger.Exception.CustomException;
import com.challengethree.Swagger.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository pro_re;

	public List<Product> getAllProducts() {
		List<Product> pr = pro_re.findAll();
		return pr;
	}

	public Product getProductByID(int id) {
		Product pr = pro_re.findById(id).orElseThrow(() -> new CustomException("id", "Product not found"));
		return pr;
	}

	public Product createProduct(Product pro) {
		if (pro_re.existsByCode(pro.getCode())) {
			throw new CustomException("code", "Product code already exists");
		}else{
		return pro_re.save(pro);
		}
	}

	public Product updateProduct(int id, Product pro) {
		Product product = pro_re.findById(id).orElseThrow(() -> new CustomException("id", "Product not found"));
		product.setCode(pro.getCode());
		product.setName(pro.getName());
		product.setCategory(pro.getCategory());
		product.setBrand(pro.getBrand());
		product.setType(pro.getType());
		product.setDescription(pro.getDescription());
		product.setCreated_at(pro.getCreated_at());
		product.setUpdated_at(pro.getUpdated_at());
		Product updateProduct = pro_re.save(product);
		return updateProduct;
	}

	public void deleteProduct(int id) {
		Product product = pro_re.findById(id).orElseThrow(() -> new CustomException("id", "Product not found"));
		pro_re.delete(product);
	}
}
