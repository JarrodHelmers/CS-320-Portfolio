package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;

    // Initialize a new ContactService before each test
    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    // Test for adding a new contact
    @Test
    public void testAddContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertTrue(contactService.addContact(contact));
        assertNotNull(contactService.getContact("1"));
    }

    // Test for adding a duplicate contact ID
    @Test
    public void testAddDuplicateContact() {
        Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1", "Jane", "Doe", "0987654321", "456 Johnson Ave");
        assertTrue(contactService.addContact(contact1));
        assertFalse(contactService.addContact(contact2));
    }

    // Test for deleting a contact
    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertTrue(contactService.deleteContact("1"));
        assertNull(contactService.getContact("1"));
    }

    // Test for deleting a non-existent contact
    @Test
    public void testDeleteNonexistentContact() {
        assertFalse(contactService.deleteContact("2"));
    }

    // Test for updating a contact's information
    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertTrue(contactService.updateContact("1", "Jane", "Smith", "0987654321", "456 Johnson Ave"));
        Contact updatedContact = contactService.getContact("1");
        assertAll("updated contact",
            () -> assertEquals("Jane", updatedContact.getFirstName()),
            () -> assertEquals("Smith", updatedContact.getLastName()),
            () -> assertEquals("0987654321", updatedContact.getPhone()),
            () -> assertEquals("456 Elm St", updatedContact.getAddress())
        );
    }

    // Test for updating a non-existent contact
    @Test
    public void testUpdateNonexistentContact() {
        assertFalse(contactService.updateContact("2", "Jane", "Smith", "0987654321", "456 Johsnon Ave"));
    }
}