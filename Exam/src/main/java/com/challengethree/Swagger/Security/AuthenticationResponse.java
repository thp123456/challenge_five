package com.challengethree.Swagger.Security;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String jwt;
}
