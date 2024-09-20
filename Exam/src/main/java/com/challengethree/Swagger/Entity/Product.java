package com.challengethree.Swagger.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {
	@Id
	@Schema(description = "ID của mặt hàng", example = "a9cc854d-769c-11ef-9714-0242ac110002")
	private String id;

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

	@CreationTimestamp
	@Column(name = "created_at", updatable = false, insertable = false)
	private LocalDateTime created_at;

	@Column(name = "updated_at", insertable = false)
	@UpdateTimestamp
	private LocalDateTime updated_at;
}
