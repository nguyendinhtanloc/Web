package murach.business;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String dob;
    private String hear;
    private boolean offers;
    private boolean emailOK;
    private String contact;

    public User() {
        firstName = "";
        lastName = "";
        email = "";
        dob = "";
        hear = "";
        offers = false;
        emailOK = false;
        contact = "";
    }

    public User(String firstName, String lastName, String email, String dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getHear() { return hear; }
    public void setHear(String hear) { this.hear = hear; }

    public boolean isOffers() { return offers; }
    public void setOffers(boolean offers) { this.offers = offers; }

    public boolean isEmailOK() { return emailOK; }
    public void setEmailOK(boolean emailOK) { this.emailOK = emailOK; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}
