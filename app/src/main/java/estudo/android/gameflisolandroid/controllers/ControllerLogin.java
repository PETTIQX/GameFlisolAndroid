package estudo.android.gameflisolandroid.controllers;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import estudo.android.gameflisolandroid.exceptions.FalhaServidorException;
import estudo.android.gameflisolandroid.models.Participante;
import estudo.android.gameflisolandroid.service.ServiceLogin;
import estudo.android.gameflisolandroid.util.PreferencesUtil;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by alexsandro on 31/03/16.
 */
public class ControllerLogin {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static final String PARAM_NUMERO_INSCRICAO = "numeroInscricao";

    private ServiceLogin serviceLogin;

    public ControllerLogin(){
        serviceLogin = new ServiceLogin();
    }

    public Participante login(String numeroInscricao, Context context) throws FalhaServidorException {

        if(numeroInscricao == null){
            return null;
        }

        try {

            JSONObject json = new JSONObject();
            json.put(PARAM_NUMERO_INSCRICAO,numeroInscricao);

            RequestBody body = RequestBody.create(JSON, json.toString());

            Participante participante = serviceLogin.login(body);
            if(participante == null){
                return null;
            }
            PreferencesUtil.setString(context, Participante.TOKEN, participante.getToken());

            return participante;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

}
