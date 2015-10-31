package javaant.com.consuming_restful.dto;

/**
 * Created by Nirmal Dhara on 29-10-2015.
 */
public class LoginResponse {
    private String status;
    private LoginResponseData data;

    LoginResponse() {

    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public LoginResponseData getData() {
        return data;
    }

    public void setData(LoginResponseData data) {
        this.data = data;
    }
}