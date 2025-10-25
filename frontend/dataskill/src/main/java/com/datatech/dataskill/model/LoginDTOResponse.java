package com.datatech.dataskill.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginDTOResponse {
    private Long id;
    private String email;
    private String cargo;
    private String departamento;

}
