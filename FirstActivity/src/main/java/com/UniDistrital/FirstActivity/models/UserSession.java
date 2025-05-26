package com.UniDistrital.FirstActivity.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSession {
    private int userId;       
    private String token;     
    private String username;  

    
}
