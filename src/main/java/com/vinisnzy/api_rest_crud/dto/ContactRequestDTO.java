package com.vinisnzy.api_rest_crud.dto;

public record ContactRequestDTO(
        String phone,
        String name,
        String lastName
) {
}
