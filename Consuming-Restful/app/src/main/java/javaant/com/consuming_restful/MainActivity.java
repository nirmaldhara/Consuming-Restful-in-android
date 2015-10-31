package javaant.com.consuming_restful;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javaant.com.consuming_restful.dto.LoginRequest;
import javaant.com.consuming_restful.dto.LoginResponse;
import javaant.com.consuming_restful.dto.LoginResponseData;
import javaant.com.consuming_restful.restclient.RestFulPost;
import javaant.com.consuming_restful.restclient.RestFulResult;
import javaant.com.consuming_restful.util.Util;
public class MainActivity extends Activity implements RestFulResult, View.OnClickListener {
    EditText userId = null;
    EditText password = null;
    Button logingButton = null;
    Context appContext;
    TextView msg=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appContext = this;
        userId = (EditText) findViewById(R.id.txtUserIdLogin);
        password = (EditText) findViewById(R.id.txtPassword);
        logingButton = (Button) findViewById(R.id.btnLogin);
        msg= (TextView) findViewById(R.id.txtmsg);
        logingButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserId(userId.getText().toString());
        loginRequest.setPassword(password.getText().toString());
        msg.setText("");
        Map<String, Object> loginMap = new HashMap<String, Object>();
        try {
            loginMap.put("url", Util.getProperty("login_url", appContext));
        } catch (IOException e) {
            e.printStackTrace();
        }
        loginMap.put("data", loginRequest);

        RestFulPost restFulPost = new RestFulPost(this, appContext, "Please Wait", "Login");
        restFulPost.execute(loginMap);
    }

    @Override
    public void onResfulResponse(String result, String responseFor) {
        Gson gson = new Gson();
        LoginResponse response = gson.fromJson(result, LoginResponse.class);
        LoginResponseData data=response.getData();
        if(data.getValidUser().equalsIgnoreCase("yes")){
            msg.setText("Valid user id and password");
            msg.setTextColor(Color.GREEN);
            Intent welcome = new Intent(this, welcome.class);
            startActivity(welcome);
        }
        else{
            msg.setText("Invalid User id and password");
            msg.setTextColor(Color.RED);
        }
        Log.d("login", "login resonse " + result);
    }
}
