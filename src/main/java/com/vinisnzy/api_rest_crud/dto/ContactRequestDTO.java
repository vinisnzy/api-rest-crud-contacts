package com.vinisnzy.api_rest_crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContactRequestDTO(

        @NotBlank(message = "Phone cannot be blank")
        @Size(min = 11, max = 17, message = "Phone size must be between 11 and 17") // 11: just numbers, 17: with spaces and -
        String phone,

        @NotBlank(message = "Name cannot be blank")
        String name,

        @NotBlank(message = "Last name cannot be blank")
        String lastName
) {
}
