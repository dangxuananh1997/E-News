package userdetails;

import java.io.Serializable;
import java.sql.Date;

public class UserDetailsDTO implements Serializable {
    private String email;
    private String fullName;
    private int genderID;
    private Date birthDate;
    private String phone;
    private String address;
    private String profilePicture;

    public UserDetailsDTO(String email, String fullName, int genderID, Date birthDate, String phone, String address, String profilePicture) {
        this.email = email;
        this.fullName = fullName;
        this.genderID = genderID;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
        this.profilePicture = profilePicture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGenderID() {
        return genderID;
    }

    public void setGenderID(int genderID) {
        this.genderID = genderID;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Override
    public String toString() {
        return "UserDetailsDTO{" + "email=" + email + ", fullName=" + fullName + ", genderID=" + genderID + ", birthDate=" + birthDate + ", phone=" + phone + ", address=" + address + ", profilePicture=" + profilePicture + '}';
    }

}
