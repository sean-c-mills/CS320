package contactservice;

import java.util.HashMap;
import java.util.Map;

// Author: Sean Mills
// ContactService class, which manages adding, deleting, and updating contacts. 
class ContactService {
	
    // Stores contact objects bu using contactID as the key
    private Map<String, Contact> contactMap = new HashMap<>();

    // Adds a new contact and makes sure that the ID is unique
    void addContact(Contact contact) {
        if (contactMap.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("This contact ID already exists.");
        }
        contactMap.put(contact.getContactId(), contact);
    }

    // Removes a contact by its unique ID
    void deleteContact(String contactId) {
        if (!contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("This contact ID cannot be found.");
        }
        contactMap.remove(contactId);
    }

    // Updates the first name by contact ID
    void updateFirstName(String contactId, String newFirstName) {
        Contact contact = contactMap.get(contactId);
        if (contact != null) {
            contact.setFirstName(newFirstName);
        } else {
            throw new IllegalArgumentException("This contact cannot be found.");
        }
    }

    // Updates the last name by contact ID
    void updateLastName(String contactId, String newLastName) {
        Contact contact = contactMap.get(contactId);
        if (contact != null) {
            contact.setLastName(newLastName);
        } else {
            throw new IllegalArgumentException("This contact cannot be found.");
        }
    }

    // Updates the phone number by contact ID
    void updatePhone(String contactId, String newPhone) {
        Contact contact = contactMap.get(contactId);
        if (contact != null) {
            contact.setPhone(newPhone);
        } else {
            throw new IllegalArgumentException("This contact cannot be found.");
        }
    }

    // Updates the address by contact ID
    void updateAddress(String contactId, String newAddress) {
        Contact contact = contactMap.get(contactId);
        if (contact != null) {
            contact.setAddress(newAddress);
        } else {
            throw new IllegalArgumentException("This contact cannot be found.");
        }
    }

    // A helper for testing that returns contact by ID
    public Contact getContact(String contactId) {
        return contactMap.get(contactId);
    }
}