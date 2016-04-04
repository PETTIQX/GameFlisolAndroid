package estudo.android.gameflisolandroid.service;

import android.support.v4.util.Pair;
import android.util.Log;

import java.io.IOException;

import estudo.android.gameflisolandroid.exceptions.FalhaServidorException;
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

    public String postRequest(HttpUrl url, RequestBody params, Pair<String,String> ... headers) throws FalhaServidorException {

        String userAgent = System.getProperty("http.agent");

        if(url == null){
            return null;
        }


        Request.Builder builder = new Request.Builder().url(url).addHeader("User-Agent", userAgent);
        if(params != null){
            builder = builder.post(params);
        }

        if(headers != null){
            for (int i = 0; i < headers.length; i++){
                Pair<String,String> header = headers[i];
                builder.addHeader(header.first,header.second);
            }
        }

        Request request = builder.build();

        return callResultado(request);
    }

    public String getRequest(HttpUrl httpUrl) throws FalhaServidorException {

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

    private String callResultado(Request request) throws FalhaServidorException{

        Response response;
        int codeResp;
        try{
            response = client.newCall(request).execute();
            if(response != null){
                codeResp = response.code();
                Log.i(HttpClient.class.toString(), "Code Received: " + codeResp);
            }else{
                throw new FalhaServidorException("Resposta inexistente", 404);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new FalhaServidorException(e.toString(), 404);
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
            String responseBody = "";

            try {
                responseBody = response.body().string().trim();
            } catch (IOException e) {
                e.printStackTrace();
            }

            throw new FalhaServidorException(responseBody,500);
        }

    }

}
