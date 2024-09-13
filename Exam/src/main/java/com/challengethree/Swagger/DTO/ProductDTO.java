package com.challengethree.Swagger.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {
    @Schema(description = "Code của mặt hàng", example = "P017")
    private String code;

    @Schema(description = "Tên của mặt hàng", example = "Sony Xperia")
    private String name;

    @Schema(description = "Hạng mục của mặt hàng", example = "Mobile")
    private String category;

    @Schema(description = "Thương hiệu của mặt hàng", example = "Sony")
    private String brand;

    @Schema(description = "Loại của mặt hàng", example = "Mobile Phone")
    private String type;

    @Schema(description = "Mô tả của mặt hàng", example = "Sony Xperia XZ 2 64GB")
    private String description;
}
