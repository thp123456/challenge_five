package com.challengethree.Swagger.Security;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
    private String role;
    private long expirationTime;

}
