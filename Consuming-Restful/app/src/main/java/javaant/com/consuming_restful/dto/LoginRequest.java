package javaant.com.consuming_restful.dto;

/**
 * Created by Nirmal Dhara on 29-10-2015.
 */
public class LoginRequest {
    private String userId;
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
