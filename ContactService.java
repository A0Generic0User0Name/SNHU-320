package ContactService;
import java.util.HashMap;

public class ContactService {
    private HashMap<String, Contact> contactMap = new HashMap<>();

    public void addContact(Contact contact) {
        if (contactMap.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contactMap.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        if (contactMap.remove(contactId) == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
    }

    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contactToUpdate = contactMap.get(contactId);
        if (contactToUpdate == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contactToUpdate.setFirstName(firstName);
        contactToUpdate.setLastName(lastName);
        contactToUpdate.setPhone(phone);
        contactToUpdate.setAddress(address);
    }
    
    // Helper method for testing
    public Contact getContact(String contactId) {
        return contactMap.get(contactId);
    }
}