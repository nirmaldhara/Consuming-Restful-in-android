package javaant.com.consuming_restful.dto;

/**
 * Created by Nirmal Dhara on 26-01-2015.
 */
public class LoginResponseData {

    private String userId;
    private String image;
    private String userName;
    private String ValidUser;
    private String code;
    private String Email_id;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getValidUser() {
        return ValidUser;
    }

    public void setValidUser(String validUser) {
        ValidUser = validUser;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail_id() {
        return Email_id;
    }

    public void setEmail_id(String email_id) {
        Email_id = email_id;
    }
}
