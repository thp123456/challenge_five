package com.challengethree.Swagger.Controller;

import com.challengethree.Swagger.Exception.CustomException;
import com.challengethree.Swagger.Response.ResponseUtil;
import com.challengethree.Swagger.Security.AuthenticationRequest;
import com.challengethree.Swagger.Security.AuthenticationResponse;
import com.challengethree.Swagger.Security.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Product_Controller")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    @SecurityRequirement(name = "")
    @Operation(summary = "Sign in Account", description = "Sign in with an existing account", security = {})
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
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletRequest request) {
        try {
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            final String jwt = jwtUtil.generateToken(userDetails);
            final String role = userDetails.getAuthorities().iterator().next().getAuthority();
            final long expirationTime = jwtUtil.extractExpiration(jwt).getTime();

            AuthenticationResponse response = new AuthenticationResponse(jwt, role, expirationTime);
            return ResponseUtil.createSuccessResponse("Success", "authentication", response, HttpStatus.OK, request);
        } catch (Exception e) {
            throw new CustomException("username and password", "Invalid username or password");
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException | BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
