package com.datatech.dataskill.entity.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTOResponse{
    private Long id;
    private String email;
    private String cargo;
    private String departamento;
}
