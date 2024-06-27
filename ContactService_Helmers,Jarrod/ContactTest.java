package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    // Test for successful contact creation
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertAll("contact",
            () -> assertEquals("1", contact.getContactId()),
            () -> assertEquals("John", contact.getFirstName()),
            () -> assertEquals("Doe", contact.getLastName()),
            () -> assertEquals("1234567890", contact.getPhone()),
            () -> assertEquals("123 Main St", contact.getAddress())
        );
    }

    // Test for invalid contact ID
    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    // Test for invalid first name
    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", null, "Doe", "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "JohnJohnJohn", "Doe", "1234567890", "123 Main St");
        });
    }

    // Test for invalid last name
    @Test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", null, "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St");
        });
    }

    // Test for invalid phone number
    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", null, "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "12345678901", "123 Main St");
        });
    }

    // Test for invalid address
    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "1234567890", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "1234567890", "123 Main St, An Incredibly Long City Name That Exceeds Thirty Characters");
        });
    }
}