package estudo.android.gameflisolandroid.service;

import android.support.v4.util.Pair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import estudo.android.gameflisolandroid.exceptions.FalhaServidorException;
import estudo.android.gameflisolandroid.models.Questionario;
import estudo.android.gameflisolandroid.service.parse.ParseJsonObject;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;

/**
 * Created by alexsandro on 03/04/16.
 */
public class ServiceQuestionario {

    private static final String FIELD_PARTICIPANTE = "participante";
    private static final String FIELD_TOKEN = "token";
    private HttpClient httpClient;

    public static final String SERVER_URL = "itapipoca.quixada.ufc.br";
    public static final String SCHEME = "http";
    public static final int SERVER_PORT = 6008;

    public static final String SERVER_URL_QUESTIONARIO = "private/questionario";

    public ServiceQuestionario(){
        this.httpClient = new HttpClient();
    }

    public List<Questionario> getQuestionarios(RequestBody params, Pair<String,String> headerAuth) throws FalhaServidorException {

        HttpUrl httpUrl = new HttpUrl.Builder().host(SERVER_URL).scheme(SCHEME).
                port(SERVER_PORT).addPathSegments(SERVER_URL_QUESTIONARIO).build();

        String resposta = httpClient.postRequest(httpUrl, params, headerAuth);

        if(resposta == null){
            return null;
        }

        try{

            JSONArray arrayResposta = new JSONArray(resposta);

            List<Questionario> questionarios = new ArrayList<>();

            for (int i = 0; i < arrayResposta.length(); i++){
                questionarios.add(ParseJsonObject.questionarioJsonToObject(arrayResposta.getJSONObject(i)));
            }

            return questionarios;
        }catch (JSONException ex){
            ex.printStackTrace();
            return null;
        }

    }


}