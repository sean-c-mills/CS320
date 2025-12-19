package contactservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Author: Sean Mills
// JUnit tests for the ContactService class 
class ContactServiceTest {

    private ContactService service;
    private Contact contact1;
    private Contact contact2;

    // Sets up a new ContactService and sample contacts before each test
    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact1 = new Contact("MOD3C1", "Sean", "Mills", "9895553021", "313 Detroit St");
        contact2 = new Contact("MOD3C2", "Brooke", "Richard", "9895557105", "307 Louis St");
    }

    // Tests that adding a single contact will be successfull
    @Test
    void testAddingSingleContact() {
        service.addContact(contact1);
        assertEquals("Sean", service.getContact("MOD3C1").getFirstName());
    }

    // Tests that adding multiple contacts will be successful
    @Test
    void testAddingMultipleContacts() {
        service.addContact(contact1);
        service.addContact(contact2);
        assertEquals("Richard", service.getContact("MOD3C2").getLastName());
    }

    // Tests that adding a duplicate contact ID will throw an exception
    @Test
    void testDuplicateContactIdThrowsException() {
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact1));
    }

    // Tests retrieving a contact after its been added
    @Test
    void testGetContactAfterAdding() {
        service.addContact(contact1);
        Contact retrieved = service.getContact("MOD3C1");
        assertNotNull(retrieved);
        assertEquals("313 Detroit St", retrieved.getAddress());
    }

    // Tests updating a contact's first name
    @Test
    void testUpdateFirstName() {
        service.addContact(contact1);
        service.updateFirstName("MOD3C1", "Darin");
        assertEquals("Darin", service.getContact("MOD3C1").getFirstName());
    }

    // Tests updating a contact's last name
    @Test
    void testUpdateLastName() {
        service.addContact(contact1);
        service.updateLastName("MOD3C1", "Knochel");
        assertEquals("Knochel", service.getContact("MOD3C1").getLastName());
    }

    // Tests updating a contact's phone number
    @Test
    void testUpdatePhone() {
        service.addContact(contact1);
        service.updatePhone("MOD3C1", "9895554107");
        assertEquals("9895554107", service.getContact("MOD3C1").getPhone());
    }

    // Tests updating a contact's address
    @Test
    void testUpdateAddress() {
        service.addContact(contact1);
        service.updateAddress("MOD3C1", "710 9 Mile Rd");
        assertEquals("710 9 Mile Rd", service.getContact("MOD3C1").getAddress());
    }

    // Tests that deleting a contact will be successful
    @Test
    void testDeletingContact() {
        service.addContact(contact2);
        service.deleteContact("MOD3C2");
        assertNull(service.getContact("MOD3C2"));
    }

    // Tests that updating a non-existent contact will throw an exception
    @Test
    void testUpdatingNonExistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("MOD3C999", "Fake"));
    }

    // Tests that deleting a contact with an ID that doesn't exist will throw an exception
    @Test
    void testDeletingNonExistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("MOD3C999"));
    }
   
    // Tests that updating the last name for a contact that doesn't exist will throw an exception
    @Test
    void testUpdateLastNameForNonExistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("MOD3C999", "Fake"));
    }

    // Tests that updating the phone number for a contact that doesn't exist will throw an exception
    @Test
    void testUpdatePhoneForNonExistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("MOD3C999", "0000000000"));
    }

    // Tests that updating the address for a contact that doesn't exist will throw an exception
    @Test
    void testUpdateAddressForNonExistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("MOD3C999", "No Address"));
    }
    
 	// Tests that retrieving a contact ID that doesnt exist will return null
    @Test
    void testGetNonExistentContactReturnsNull() {
        assertNull(service.getContact("MOD3C999"));
    }
}