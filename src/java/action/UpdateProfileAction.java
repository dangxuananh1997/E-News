/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.imageio.ImageIO;
import sun.misc.BASE64Encoder;
import userdetails.UserDetailsDAO;
import userdetails.UserDetailsDTO;

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
    private int day;
    private int month;
    private int year;
    private String phone;
    private String address;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public UpdateProfileAction() {
    }

    public String execute() throws Exception {
        String url = FAIL;
        //get image string
        BASE64Encoder encoder = new BASE64Encoder();
        BufferedImage bi;
        bi = ImageIO.read(profilePicture);  //error
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "jpg", baos);
        byte[] bytes = baos.toByteArray();
        String img = encoder.encodeBuffer(bytes).trim();
        Map session = ActionContext.getContext().getSession();
        
        UserDetailsDTO member = (UserDetailsDTO) session.get("USERDETAILS");
        email = member.getEmail();  //get email from session
        
        //get birthdate
        java.sql.Date date = new java.sql.Date(year, month, day);
        UserDetailsDAO dao = new UserDetailsDAO();
        boolean result = dao.updateProfile(email, fullName, genderID, date, phone, address, img);
        if (result) {
            url = SUCCESS;
            member = dao.getUserDetails(email);
            session.put("USERDETAILS", member); //set new member details to attribute
        }
        return url;
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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
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
