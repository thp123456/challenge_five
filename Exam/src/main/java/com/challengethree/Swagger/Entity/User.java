package com.challengethree.Swagger.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID của người dùng", example = "1")
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    @Schema(description = "Tên tài khoản", example = "user_name")
    private String username;

    @Column(name = "password", nullable = false)
    @Schema(description = "Mật khẩu tài khoản", example = "password")
    private String password;

    @Column(name = "role", nullable = false)
    @Schema(description = "Quyền truy cập tài khoản", example = "USER")
    private String role;
}
