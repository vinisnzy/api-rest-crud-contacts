package com.vinisnzy.api_rest_crud.service;

import com.vinisnzy.api_rest_crud.dto.ContactRequestDTO;
import com.vinisnzy.api_rest_crud.dto.ContactResponseDTO;
import com.vinisnzy.api_rest_crud.model.Contact;
import com.vinisnzy.api_rest_crud.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository repository;

    public ContactResponseDTO createContact(ContactRequestDTO data) {
        Contact contact = new Contact(data);
        repository.save(contact);
        return new ContactResponseDTO(contact);
    }

    public List<ContactResponseDTO> getAllContacts() {
        return repository.findAll().stream().map(ContactResponseDTO::new).toList();
    }

    public ContactResponseDTO getContactById(Long id) {
        return new ContactResponseDTO(findById(id));
    }

    public ContactResponseDTO getContactByPhone(String phone) {
        Contact contact = repository.findByPhone(phone).orElseThrow(() -> new RuntimeException("Contact not found with phone: " + phone));
        return new ContactResponseDTO(contact);
    }

    public ContactResponseDTO getContactByName(String name) {
        Contact contact = repository.findByNameIgnoreCase(name).orElseThrow(() -> new RuntimeException("Contact not found with name: " + name));
        return new ContactResponseDTO(contact);
    }

    public ContactResponseDTO getContactByLastName(String lastName) {
        Contact contact = repository.findByLastNameIgnoreCase(lastName).orElseThrow(() -> new RuntimeException("Contact not found with last name: " + lastName));
        return new ContactResponseDTO(contact);
    }

    public ContactResponseDTO updateContact(Long id, ContactRequestDTO data) {
        Contact contact = findById(id);
        contact.updateData(data);
        repository.save(contact);
        return new ContactResponseDTO(contact);
    }

    public void deleteContactById(Long id) {
        Contact contact = findById(id);
        repository.delete(contact);
    }

    private Contact findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
    }
}
