package contactservice;

// Author: Sean Mills
// The Contact class represents a single contact in the contact service
class Contact {
    private final String contactId;  // Unique ID
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor with validation for all the fields
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validates the contact ID, needs to be not null and 10 characters or less.
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("The contact ID cannot be null and must be 10 characters or less.");
        }
        // Validates the first name
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("The first name cannot be null and must be 10 characters or less.");
        }
        // Validates the last name
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("The last name cannot be null and must be 10 characters or less.");
        }
        // Validates the phone number
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("The phone number cannot be null and must be exactly 10 numbers.");
        }
        // Validates the address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("The address cannot be null and must be 30 characters or less.");
        }

        // Sets the values after passing the validations
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    /* Setters with validation. Allows for updates to the fields 
    / Note: There is no setter for contactID per the instructions: "The contact service shall be able to add contacts with a unique ID." */
    void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("The first name cannot be null and must be 10 characters or less.");
        }
        this.firstName = firstName;
    }

    void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("The last name cannot be null and must be 10 characters or less.");
        }
        this.lastName = lastName;
    }

    void setPhone(String phone) {
    	if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("The phone number cannot be null and must be exactly 10 numbers.");
        }
        this.phone = phone;
    }

    void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("The address cannot be null and must be 30 characters or less.");
        }
        this.address = address;
    }
}