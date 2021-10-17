package com.example.springsqs.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientDto {

    private String name;
    private String email;
}
