package com.example.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Jahongir
 * @project jwt
 * @Email 'jakhongirsherjonov@gmail.com'
 * @Date 2/8/2023
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest {
    //
    private String username;
    private String password;
}
