package javaant.com.consuming_restful.util;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.util.Base64;
import android.view.Gravity;
import android.widget.Toast;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * Created by Nirmal Dhara on 29-10-2015.
 */
public class Util {
    static String sessionGroup = "javaant";

    public static void setSession(Context context, String key, String value) {
        SharedPreferences pref = context.getSharedPreferences(sessionGroup, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value); // Storing string
        editor.commit();
    }

    public static String getSession(Context context, String key) {

        SharedPreferences prefs = context.getSharedPreferences(sessionGroup, Context.MODE_PRIVATE);
        return prefs.getString(key, null);
    }

    public static void removeSession(Context context, String key) {
        SharedPreferences.Editor editor = context.getSharedPreferences(sessionGroup, Context.MODE_PRIVATE).edit();
        editor.remove(key);
        editor.commit();
    }

    public static String getAuthorizationString() {

        return "Basic " + Base64.encodeToString(("javamad" + ":" + "p35IcFXA").getBytes(), Base64.DEFAULT);
    }

    public static DefaultHttpClient getClient() {
        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, 30000);
        HttpConnectionParams.setSoTimeout(httpParameters, 30000);
        DefaultHttpClient httpclient = new DefaultHttpClient(httpParameters);
        Credentials credentials = new UsernamePasswordCredentials("javamad", "p35IcFXA");
        httpclient.getCredentialsProvider().setCredentials(AuthScope.ANY, credentials);
        return httpclient;
    }

    public static String getProperty(String key, Context context) throws IOException {
        Properties properties = new Properties();
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = assetManager.open("config.properties");
        properties.load(inputStream);
        return properties.getProperty(key);

    }



    public static void showToast(Context context,String text){
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 0);
        toast.show();
    }




}
