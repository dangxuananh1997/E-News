/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Administrator
 */
public class UpdateProfileAction extends ActionSupport {
    private File profilePicture;
    private String profilePictureContentType;
    private String profilePictureFileName;
    private String email;
    private String fullName;
    private int genderID;
    private String day;
    private String month;
    private String year;
    private String phone;
    private String address;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public UpdateProfileAction() {
    }
    
    public String execute() throws Exception {
        
        //get image string
        BASE64Encoder encoder = new BASE64Encoder(); 
        BufferedImage bi;
        bi = ImageIO.read(profilePicture); 
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
        ImageIO.write(bi, "jpg", baos); 
        byte[] bytes = baos.toByteArray(); 
        String img = encoder.encodeBuffer(bytes).trim(); 
        
        System.out.println(img);
        return SUCCESS;
    }

    public File getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(File profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getProfilePictureContentType() {
        return profilePictureContentType;
    }

    public void setProfilePictureContentType(String profilePictureContentType) {
        this.profilePictureContentType = profilePictureContentType;
    }

    public String getProfilePictureFileName() {
        return profilePictureFileName;
    }

    public void setProfilePictureFileName(String profilePictureFileName) {
        this.profilePictureFileName = profilePictureFileName;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
}
