package com.challengethree.Swagger.Security;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}
