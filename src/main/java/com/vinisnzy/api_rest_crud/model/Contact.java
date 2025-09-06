package com.vinisnzy.api_rest_crud.model;

import com.vinisnzy.api_rest_crud.dto.ContactRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    public Contact(ContactRequestDTO data) {
        this.phone = data.phone();
        this.name = data.name();
        this.lastName = data.lastName();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

}
