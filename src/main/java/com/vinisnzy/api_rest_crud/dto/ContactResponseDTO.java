package com.vinisnzy.api_rest_crud.dto;

import com.vinisnzy.api_rest_crud.model.Contact;

public record ContactResponseDTO(
        Long id,
        String phone,
        String name,
        String lastName
) {
    public ContactResponseDTO(Contact contact) {
        this(contact.getId(), contact.getPhone(), contact.getName(), contact.getLastName());
    }
}
