package com.challengethree.Swagger.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challengethree.Swagger.Entity.Product;
import com.challengethree.Swagger.Response.SuccessRespo;
import com.challengethree.Swagger.Service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product_Controller")
public class ProductController {
	@Autowired
	ProductService pro_ser;

	@GetMapping
	@Operation(summary = "All Products", description = "All product information will appear here.")
	public ResponseEntity<SuccessRespo> getAllProducts(HttpServletRequest request) {
		List<Product> getall = pro_ser.getAllProducts();
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("product", getall);

		SuccessRespo successResponse = new SuccessRespo();
		successResponse.setMessage("Success");
		successResponse.setResponseData(responseData);
		successResponse.setSuccess(true);
		successResponse.setStatus(HttpStatus.OK.value());
		successResponse.setViolations(null);
		successResponse.setPath(request.getRequestURI());
		successResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(successResponse, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Product by ID", description = "Display product by ID.")
	public ResponseEntity<SuccessRespo> getProductByID(@PathVariable int id, HttpServletRequest request) {
		Product pro = pro_ser.getProductByID(id);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("product", pro);

		SuccessRespo successResponse = new SuccessRespo();
		successResponse.setMessage("Success");
		successResponse.setResponseData(responseData);
		successResponse.setSuccess(true);
		successResponse.setStatus(HttpStatus.OK.value());
		successResponse.setViolations(null);
		successResponse.setPath(request.getRequestURI());
		successResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(successResponse, HttpStatus.OK);
	}

	@PostMapping
	@Operation(summary = "Create Product", description = "Create a new product with the specified information.")
	public ResponseEntity<SuccessRespo> createProduct(@RequestBody Product pro, HttpServletRequest request) {
		Product product = pro_ser.createProduct(pro);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("product", product);

		SuccessRespo successResponse = new SuccessRespo();
		successResponse.setMessage("Success");
		successResponse.setResponseData(responseData);
		successResponse.setSuccess(true);
		successResponse.setStatus(HttpStatus.CREATED.value());
		successResponse.setViolations(null);
		successResponse.setPath(request.getRequestURI());
		successResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update Product", description = "Update product by ID.")
	public ResponseEntity<SuccessRespo> updateProduct(@PathVariable int id, @RequestBody Product product,
			HttpServletRequest request) {
		Product pro = pro_ser.updateProduct(id, product);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("product", pro);

		SuccessRespo successResponse = new SuccessRespo();
		successResponse.setMessage("Success");
		successResponse.setResponseData(responseData);
		successResponse.setSuccess(true);
		successResponse.setStatus(HttpStatus.OK.value());
		successResponse.setViolations(null);
		successResponse.setPath(request.getRequestURI());
		successResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(successResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete Product", description = "Delete product by ID.")
	public ResponseEntity<SuccessRespo> deleteProduct(@PathVariable int id, HttpServletRequest request) {
		pro_ser.deleteProduct(id);

		SuccessRespo successResponse = new SuccessRespo();
		successResponse.setMessage("Success");
		successResponse.setResponseData(null);
		successResponse.setSuccess(true);
		successResponse.setStatus(HttpStatus.NO_CONTENT.value());
		successResponse.setViolations(null);
		successResponse.setPath(request.getRequestURI());
		successResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(successResponse, HttpStatus.OK);
	}
}
