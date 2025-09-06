package com.vinisnzy.api_rest_crud.repository;

import com.vinisnzy.api_rest_crud.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findByPhone(String phone);
    Optional<Contact> findByNameIgnoreCase(String name);
    Optional<Contact> findByLastNameIgnoreCase(String lastName);
}
