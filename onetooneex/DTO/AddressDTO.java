package com.example.onetooneex.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;
    @NotEmpty(message = "area cannot be null")
    private String area;
    @NotEmpty(message = "street cannot be null")
    private String street;
    @NotNull(message = "building number cannot be null")
    private Integer buildingnum;

}
