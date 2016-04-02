package estudo.android.gameflisolandroid.service;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import estudo.android.gameflisolandroid.models.Participante;
import estudo.android.gameflisolandroid.service.parse.ParseJsonObject;
import okhttp3.RequestBody;

/**
 * Created by alexsandro on 31/03/16.
 */
public class ServiceLogin {

    private static final String FIELD_PARTICIPANTE = "participante";
    private static final String FIELD_TOKEN = "token";
    private HttpClient httpClient;

    public static final String SERVER_URL = "";
    public static final String SERVER_URL_LOGIN = "";

    public ServiceLogin(){
        this.httpClient = new HttpClient();
    }

    public Participante login(RequestBody params){

        String resposta = httpClient.postRequest(SERVER_URL_LOGIN, params);

        if(resposta == null){
            return null;
        }

        try {
            JSONObject objResposta = new JSONObject(resposta);

            String token = objResposta.getString(FIELD_TOKEN);

            JSONObject objParticipante = objResposta.getJSONObject(FIELD_PARTICIPANTE);

            Participante participante = ParseJsonObject.participanteJSONToObject(objParticipante);

            participante.setToken(token);

            return participante;
        } catch (JSONException ex) {
            return null;
        }
    }

}
