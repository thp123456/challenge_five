package com.challengethree.Swagger.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.challengethree.Swagger.DTO.ProductDTO;
import com.challengethree.Swagger.Exception.CustomException;
import com.challengethree.Swagger.Response.ResponseUtil;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	@SecurityRequirement(name = "bearerAuth")
	@Operation(summary = "All products", description = "All product information will appear here.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lấy danh sách thành công", content = @Content),
			@ApiResponse(responseCode = "201", description = "Tạo thành công", content = @Content),
			@ApiResponse(responseCode = "204", description = "Xóa thành công, không có nội dung trả về", content = @Content),
			@ApiResponse(responseCode = "400", description = "Yêu cầu không hợp lệ", content = @Content),
			@ApiResponse(responseCode = "401", description = "Không được phép", content = @Content),
			@ApiResponse(responseCode = "403", description = "Cấm truy cập", content = @Content),
			@ApiResponse(responseCode = "404", description = "Không tìm thấy", content = @Content),
			@ApiResponse(responseCode = "500", description = "Lỗi máy chủ nội bộ", content = @Content),
			@ApiResponse(responseCode = "502", description = "Lỗi Gateway không hợp lệ", content = @Content),
			@ApiResponse(responseCode = "503", description = "Dịch vụ không khả dụng", content = @Content)
	})
	public ResponseEntity<SuccessRespo> getAllProducts(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			HttpServletRequest request) {

		Pageable pageable = PageRequest.of(page, size);
		Page<Product> productsPage = pro_ser.getAllProducts(pageable);

		Map<String, Object> responseData = new HashMap<>();
		responseData.put("products", productsPage.getContent());
		responseData.put("currentPage", productsPage.getNumber());
		responseData.put("totalItems", productsPage.getTotalElements());
		responseData.put("totalPages", productsPage.getTotalPages());

		return ResponseUtil.createSuccessResponse("Success", "products", responseData, HttpStatus.OK, request);
	}

	@GetMapping("/{id}")
	@SecurityRequirement(name = "bearerAuth")
	@Operation(summary = "Product by ID", description = "Display product by ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lấy danh sách thành công", content = @Content),
			@ApiResponse(responseCode = "201", description = "Tạo thành công", content = @Content),
			@ApiResponse(responseCode = "204", description = "Xóa thành công, không có nội dung trả về", content = @Content),
			@ApiResponse(responseCode = "400", description = "Yêu cầu không hợp lệ", content = @Content),
			@ApiResponse(responseCode = "401", description = "Không được phép", content = @Content),
			@ApiResponse(responseCode = "403", description = "Cấm truy cập", content = @Content),
			@ApiResponse(responseCode = "404", description = "Không tìm thấy", content = @Content),
			@ApiResponse(responseCode = "500", description = "Lỗi máy chủ nội bộ", content = @Content),
			@ApiResponse(responseCode = "502", description = "Lỗi Gateway không hợp lệ", content = @Content),
			@ApiResponse(responseCode = "503", description = "Dịch vụ không khả dụng", content = @Content)
	})
	public ResponseEntity<SuccessRespo> getProductByID(@PathVariable String id, HttpServletRequest request) {
		Product product = pro_ser.getProductByID(id);
		if (product == null) {
			throw new CustomException("id", "Product not found with id " + id);
		}
		return ResponseUtil.createSuccessResponse("Product retrieved successfully", "product", product, HttpStatus.OK, request);
	}


	@PostMapping
	@SecurityRequirement(name = "bearerAuth")
	@Operation(summary = "Create Product", description = "Create a new product with the specified information.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lấy danh sách thành công", content = @Content),
			@ApiResponse(responseCode = "201", description = "Tạo thành công", content = @Content),
			@ApiResponse(responseCode = "204", description = "Xóa thành công, không có nội dung trả về", content = @Content),
			@ApiResponse(responseCode = "400", description = "Yêu cầu không hợp lệ", content = @Content),
			@ApiResponse(responseCode = "401", description = "Không được phép", content = @Content),
			@ApiResponse(responseCode = "403", description = "Cấm truy cập", content = @Content),
			@ApiResponse(responseCode = "404", description = "Không tìm thấy", content = @Content),
			@ApiResponse(responseCode = "500", description = "Lỗi máy chủ nội bộ", content = @Content),
			@ApiResponse(responseCode = "502", description = "Lỗi Gateway không hợp lệ", content = @Content),
			@ApiResponse(responseCode = "503", description = "Dịch vụ không khả dụng", content = @Content)
	})
	public ResponseEntity<SuccessRespo> createProduct(@RequestBody ProductDTO productDTO, HttpServletRequest request) {
		Product product = modelMapper.map(productDTO, Product.class);
		Product createdProduct = pro_ser.createProduct(product);
		return ResponseUtil.createSuccessResponse("Product created successfully", "product", createdProduct, HttpStatus.CREATED, request);
	}

	@PutMapping("/{id}")
	@SecurityRequirement(name = "bearerAuth")
	@Operation(summary = "Update Product", description = "Update product by ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lấy danh sách thành công", content = @Content),
			@ApiResponse(responseCode = "201", description = "Tạo thành công", content = @Content),
			@ApiResponse(responseCode = "204", description = "Xóa thành công, không có nội dung trả về", content = @Content),
			@ApiResponse(responseCode = "400", description = "Yêu cầu không hợp lệ", content = @Content),
			@ApiResponse(responseCode = "401", description = "Không được phép", content = @Content),
			@ApiResponse(responseCode = "403", description = "Cấm truy cập", content = @Content),
			@ApiResponse(responseCode = "404", description = "Không tìm thấy", content = @Content),
			@ApiResponse(responseCode = "500", description = "Lỗi máy chủ nội bộ", content = @Content),
			@ApiResponse(responseCode = "502", description = "Lỗi Gateway không hợp lệ", content = @Content),
			@ApiResponse(responseCode = "503", description = "Dịch vụ không khả dụng", content = @Content)
	})
	public ResponseEntity<SuccessRespo> updateProduct(@PathVariable String id, @RequestBody ProductDTO productDTO, HttpServletRequest request) {
		Product product = modelMapper.map(productDTO, Product.class);
		Product updatedProduct = pro_ser.updateProduct(id, product);
		return ResponseUtil.createSuccessResponse("Product updated successfully", "product", updatedProduct, HttpStatus.OK, request);
	}

	@DeleteMapping("/{id}")
	@SecurityRequirement(name = "bearerAuth")
	@Operation(summary = "Delete Product", description = "Delete product by ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lấy danh sách thành công", content = @Content),
			@ApiResponse(responseCode = "201", description = "Tạo thành công", content = @Content),
			@ApiResponse(responseCode = "204", description = "Xóa thành công, không có nội dung trả về", content = @Content),
			@ApiResponse(responseCode = "400", description = "Yêu cầu không hợp lệ", content = @Content),
			@ApiResponse(responseCode = "401", description = "Không được phép", content = @Content),
			@ApiResponse(responseCode = "403", description = "Cấm truy cập", content = @Content),
			@ApiResponse(responseCode = "404", description = "Không tìm thấy", content = @Content),
			@ApiResponse(responseCode = "500", description = "Lỗi máy chủ nội bộ", content = @Content),
			@ApiResponse(responseCode = "502", description = "Lỗi Gateway không hợp lệ", content = @Content),
			@ApiResponse(responseCode = "503", description = "Dịch vụ không khả dụng", content = @Content)
	})
	public ResponseEntity<SuccessRespo> deleteProduct(@PathVariable String id, HttpServletRequest request) {
		pro_ser.deleteProduct(id);
		return ResponseUtil.createSuccessResponse("Product deleted successfully", "product", null, HttpStatus.OK, request);
	}
}
