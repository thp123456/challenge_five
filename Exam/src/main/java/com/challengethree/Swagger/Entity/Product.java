package com.challengethree.Swagger.Entity;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "ID của mặt hàng", example = "1")
	private int id;

	@Column(name = "code", nullable = false, unique = true)
	@Schema(description = "Code của mặt hàng", example = "P017")
	private String code;

	@Column(name = "name", nullable = false)
	@Schema(description = "Tên của mặt hàng", example = "Sony Xperia")
	private String name;

	@Column(name = "category", nullable = false)
	@Schema(description = "Hạng mục của mặt hàng", example = "Mobile")
	private String category;

	@Column(name = "brand")
	@Schema(description = "Thương hiệu của mặt hàng", example = "Sony")
	private String brand;

	@Column(name = "type")
	@Schema(description = "Loại của mặt hàng", example = "Mobile Phone")
	private String type;

	@Column(name = "description")
	@Schema(description = "Mô tả của mặt hàng", example = "Sony Xperia XZ 2 64GB")
	private String description;

	@Column(name = "created_at", updatable = false, insertable = false)
	private LocalDateTime created_at;

	@Column(name = "updated_at", insertable = false)
	private LocalDateTime updated_at;

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getCode() {
//		return code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}
//
//	public String getBrand() {
//		return brand;
//	}
//
//	public void setBrand(String brand) {
//		this.brand = brand;
//	}
//
//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public LocalDateTime getCreated_at() {
//		return created_at;
//	}
//
//	public void setCreated_at(LocalDateTime created_at) {
//		this.created_at = created_at;
//	}
//
//	public LocalDateTime getUpdated_at() {
//		return updated_at;
//	}
//
//	public void setUpdated_at(LocalDateTime updated_at) {
//		this.updated_at = updated_at;
//	}

//	public Product(int id, String code, String name, String category, String brand, String type, String description,
//			LocalDateTime created_at, LocalDateTime updated_at) {
//		super();
//		this.id = id;
//		this.code = code;
//		this.name = name;
//		this.category = category;
//		this.brand = brand;
//		this.type = type;
//		this.description = description;
//		this.created_at = created_at;
//		this.updated_at = updated_at;
//	}
}
