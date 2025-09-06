package com.vinisnzy.api_rest_crud.controller;

import com.vinisnzy.api_rest_crud.dto.ContactRequestDTO;
import com.vinisnzy.api_rest_crud.dto.ContactResponseDTO;
import com.vinisnzy.api_rest_crud.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService service;

    @PostMapping
    public ResponseEntity<ContactResponseDTO> createContact(@RequestBody ContactRequestDTO data) {
        ContactResponseDTO contact = service.createContact(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
    }

    @GetMapping
    public ResponseEntity<List<ContactResponseDTO>> getAllContacts() {
        return ResponseEntity.ok(service.getAllContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactResponseDTO> getContactById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getContactById(id));
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<ContactResponseDTO> getContactByPhone(@PathVariable String phone) {
        return ResponseEntity.ok().body(service.getContactByPhone(phone));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ContactResponseDTO> getContactByName(@PathVariable String name) {
        return ResponseEntity.ok().body(service.getContactByName(name));
    }

    @GetMapping("/last-name/{lastName}")
    public ResponseEntity<ContactResponseDTO> getContactByLastName(@PathVariable String lastName) {
        return ResponseEntity.ok().body(service.getContactByLastName(lastName));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactResponseDTO> updateContact(@PathVariable Long id, @RequestBody ContactRequestDTO data) {
        return ResponseEntity.ok().body(service.updateContact(id, data));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        service.deleteContactById(id);
        return ResponseEntity.noContent().build();
    }
}
