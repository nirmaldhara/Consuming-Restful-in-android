package javaant.com.consuming_restful.restclient;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import java.util.Map;
import javaant.com.consuming_restful.util.Util;
/**
 * Created by Nirmal Dhara on 29-10-2015.
 */
public class RestFulPost extends AsyncTask<Map, Void, String> {
    RestFulResult restFulResult = null;
    ProgressDialog Asycdialog;
    String msg;
    String task;

    public RestFulPost(RestFulResult restFulResult, Context context, String msg,String task) {
        this.restFulResult = restFulResult;
        this.task=task;
        this.msg = msg;
        Asycdialog = new ProgressDialog(context);
    }

    @Override
    protected String doInBackground(Map... params) {
        String responseStr = null;
        Object dataMap = null;
        HttpPost httpost = new HttpPost(params[0].get("url").toString());

        try {
            dataMap = (Object) params[0].get("data");
            Gson gson = new Gson();
            Log.d("data  map", "data map------" + gson.toJson(dataMap));
            httpost.setEntity(new StringEntity(gson.toJson(dataMap)));
            httpost.setHeader("Accept", "application/json");
            httpost.setHeader("Content-type", "application/json");
            DefaultHttpClient httpclient= Util.getClient();
            HttpResponse response = httpclient.execute(httpost);
            int statusCode = response.getStatusLine().getStatusCode();
            Log.d("resonse code", "----------------" + statusCode);

            if (statusCode == 200)
                responseStr = EntityUtils.toString(response.getEntity());
            if (statusCode == 404) {
                responseStr = "{\n" +
                        "\"status\":\"fail\",\n" +
                        " \"data\":{\n" +
                        "\"ValidUser\":\"Service not available\",\n" +
                        "\"code\":\"404\"\n" +
                        "}\n" +
                        "}";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseStr;
    }

    @Override
    protected void onPreExecute() {
        Asycdialog.setMessage(msg);
        //show dialog
        Asycdialog.show();
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        Asycdialog.dismiss();
        restFulResult.onResfulResponse(s,task);
    }


}
