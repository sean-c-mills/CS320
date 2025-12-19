package contactservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Author: Sean Mills
// JUnit tests for the Contact class 
class ContactTest {

	// Tests the creation of a valid contact
    @Test
    void testValidContactCreation() {
        Contact c = new Contact("MOD3C1", "Sean", "Mills", "9895553021", "313 Detroit St");
        assertEquals("Sean", c.getFirstName());
        assertEquals("Mills", c.getLastName());
        assertEquals("9895553021", c.getPhone());
        assertEquals("313 Detroit St", c.getAddress());
    }

    // Tests that creating a contact with a null contact ID will throw an exception
    @Test
    void testNullContactIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Sean", "Mills", "9895553021", "313 Detroit St"));
    }

    // Tests that creating a contact with a contact ID of over 10 characters will throw an exception
    @Test
    void testLongContactIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("This-ID-is-way-too-long555", "Sean", "Mills", "9895553021", "313 Detroit St"));
    }

    // Tests that a null first name will throw an exception
    @Test
    void testNullFirstNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("MOD3C2", null, "Mills", "9895553021", "313 Detroit St"));
    }
    
    // Tests that a first name that is too long will throw an exception
    @Test
    void testLongFirstNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("MOD3C3", "SeanMillsTooLong", "Mills", "9895553021", "313 Detroit St"));
    }

    // Tests that a null last name will throw an exception
    @Test
    void testNullLastNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("MOD3C4", "Sean", null, "9895553021", "313 Detroit St"));
    }

    // Tests that a last name that is too long will throw an exception
    @Test
    void testLongLastNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("MOD3C5", "Sean", "ThisIsWayTooManyLetters", "9895553021", "313 Detroit St"));
    }

    // Tests that a null phone number will throw an exception
    @Test
    void testNullPhoneThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("MOD3C6", "Sean", "Mills", null, "313 Detroit St"));
    }

    // Tests that a phone number that is too short will throw an exception
    @Test
    void testInvalidPhoneLengthThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("MOD3C7", "Sean", "Mills", "98955", "313 Detroit St"));
    }

    // Tests that a phone number that contains letters will throw an exception
    @Test
    void testPhoneWithLettersThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("MOD3C8", "Sean", "Mills", "989555Four", "313 Detroit St"));
    }

    // Tests that a null address will throw an exception
    @Test
    void testNullAddressThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("MOD3C9", "Sean", "Mills", "9895553021", null));
    }

    // Tests that adding an address thats too long will throw an exception
    @Test
    void testLongAddressThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("MOD3C10", "Sean", "Mills", "9895553021", "201 Midland Road Lane Drive Apartment 777 Too Long Lane"));
    }

    // Tests setting a valid first name
    @Test
    void testSetFirstNameValid() {
        Contact c = new Contact("MOD3C11", "Sean", "Mills", "9895553021", "313 Detroit St");
        c.setFirstName("Ryan");
        assertEquals("Ryan", c.getFirstName());
    }

    // Tests setting an invalid first name by invalid length or is null
    @Test
    void testSetFirstNameInvalid() {
        Contact c = new Contact("MOD3C12", "Sean", "Mills", "9895553021", "313 Detroit St");
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("ThisNameIsTooLongMills"));
    }

    // Tests setting a valid last name
    @Test
    void testSetLastNameValid() {
        Contact c = new Contact("MOD3C13", "Sean", "Mills", "9895553021", "313 Detroit St");
        c.setLastName("Richard");
        assertEquals("Richard", c.getLastName());
    }

    // Tests setting an invalid last name by invalid length or is null
    @Test
    void testSetLastNameInvalid() {
        Contact c = new Contact("MOD3C14", "Sean", "Mills", "9895553021", "313 Detroit St");
        assertThrows(IllegalArgumentException.class, () -> c.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setLastName("ThisIsLongerThanTen"));
    }

    // Tests setting a valid phone number
    @Test
    void testSetPhoneValid() {
        Contact c = new Contact("MOD3C15", "Sean", "Mills", "9895553021", "313 Detroit St");
        c.setPhone("9895557105");
        assertEquals("9895557105", c.getPhone());
    }

    // Tests setting an invalid phone number by having letters or is null
    @Test
    void testSetPhoneInvalid() {
        Contact c = new Contact("MOD3C16", "Sean", "Mills", "9895553021", "313 Detroit St");
        assertThrows(IllegalArgumentException.class, () -> c.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("989555Four"));
    }
    
    // Tests setting a valid address
    @Test
    void testSetAddressValid() {
        Contact c = new Contact("MOD3C17", "Sean", "Mills", "9895553021", "313 Detroit St");
        c.setAddress("3071 Bay City Dr");
        assertEquals("3071 Bay City Dr", c.getAddress());
    }

    // Tests setting an invalid address by invalid length or is null
    @Test
    void testSetAddressInvalid() {
        Contact c = new Contact("MOD3C18", "Sean", "Mills", "9895553021", "313 Detroit St");
        assertThrows(IllegalArgumentException.class, () -> c.setAddress(null));
        assertThrows(IllegalArgumentException.class, () -> c.setAddress("This address is way too long to and needs to be shorter"));
    }
}