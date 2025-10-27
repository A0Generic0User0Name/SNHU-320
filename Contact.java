package ContactService;

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        this.contactId = validateInput(contactId, 10, "Contact ID");
        this.firstName = validateInput(firstName, 10, "First Name");
        this.lastName = validateInput(lastName, 10, "Last Name");
        this.phone = validatePhone(phone);
        this.address = validateInput(address, 30, "Address");
    }

    private String validateInput(String input, int maxLength, String fieldName) {
        if (input == null) {
            throw new IllegalArgumentException(fieldName + " cannot be null.");
        }
        if (input.length() > maxLength) {
            throw new IllegalArgumentException(fieldName + " cannot exceed " + maxLength + " characters.");
        }
        return input;
    }

    private String validatePhone(String phone) {
        if (phone == null) {
            throw new IllegalArgumentException("Phone number cannot be null.");
        }
        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
        return phone;
    }

    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    public void setFirstName(String firstName) {
        this.firstName = validateInput(firstName, 10, "First Name");
    }
    public void setLastName(String lastName) {
        this.lastName = validateInput(lastName, 10, "Last Name");
    }
    public void setPhone(String phone) {
        this.phone = validatePhone(phone);
    }
    public void setAddress(String address) {
        this.address = validateInput(address, 30, "Address");
    }
}