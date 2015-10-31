package javaant.com.consuming_restful.madenum;

/**
 * Created by Nirmal Dhara on 29-10-2015.
 */
public enum MessageEnum {

    ///not found
    msg_404("{\"status\":\"fail\",\"data\":{\"message\":\"Service not available\",\"code\":\"404\"}}"),
    msg_500("{\"status\":\"fail\",\"data\":{\"message\":\"Internal Server Error\",\"code\":\"500\"}}");
    private final String msg;

    private MessageEnum(String msg) {
        this.msg = msg;
    }

    public String msg() {
        return msg;
    }
}
