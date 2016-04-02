package estudo.android.gameflisolandroid.service;

import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by alexsandro on 31/03/16.
 */
public class HttpClient {

    private OkHttpClient client;
    private static final int OK_CODE = 200;

    public HttpClient(){
        client = new OkHttpClient();
    }

    public String postRequest(HttpUrl url, RequestBody params) {

        String userAgent = System.getProperty("http.agent");

        if(url == null){
            return null;
        }

        Request.Builder builder = new Request.Builder().url(url).addHeader("User-Agent", userAgent);
        if(params != null){
            builder = builder.post(params);
        }

        Request request = builder.build();

        return callResultado(request);
    }

    public String getRequest(HttpUrl httpUrl){

        String userAgent = System.getProperty("http.agent");

        if(httpUrl == null){
            return null;
        }

        Request request = new Request.Builder()
                .url(httpUrl)
                .addHeader("User-Agent", userAgent)
                .build();

        return callResultado(request);
    }

    private String callResultado(Request request){

        Response response;

        try{
            response = client.newCall(request).execute();
            if(response != null){
                int codeResp = response.code();
                Log.i("teste", "Code Received: " + codeResp);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        if(response.isSuccessful()){

            String responseBody;

            try {
                responseBody = response.body().string().trim();
            } catch (IOException e) {
                e.printStackTrace();
                responseBody = null;
            }

            return responseBody;
        }else{
            return null;
        }

    }

}
