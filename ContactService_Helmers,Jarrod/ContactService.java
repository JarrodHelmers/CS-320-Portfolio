import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // Map to store contacts with contact ID as the key
    private final Map<String, Contact> contacts = new HashMap<>();

    // Method to add a contact
    public boolean addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            return false; // Contact ID must be unique
        }
        contacts.put(contact.getContactId(), contact);
        return true;
    }

    // Method to delete a contact by ID
    public boolean deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            return false; // Contact ID must exist to be deleted
        }
        contacts.remove(contactId);
        return true;
    }

    // Method to update a contact by ID
    public boolean updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (!contacts.containsKey(contactId)) {
            return false; // Contact ID must exist to be updated
        }
        Contact contact = contacts.get(contactId);
        if (firstName != null && firstName.length() <= 10) {
            contact.setFirstName(firstName);
        }
        if (lastName != null && lastName.length() <= 10) {
            contact.setLastName(lastName);
        }
        if (phone != null && phone.length() == 10) {
            contact.setPhone(phone);
        }
        if (address != null && address.length() <= 30) {
            contact.setAddress(address);
        }
        return true;
    }

    // Method to retrieve a contact by ID
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}