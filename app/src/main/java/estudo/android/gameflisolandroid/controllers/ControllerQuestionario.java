package estudo.android.gameflisolandroid.controllers;

import android.content.Context;
import android.support.v4.util.Pair;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import estudo.android.gameflisolandroid.exceptions.FalhaServidorException;
import estudo.android.gameflisolandroid.models.Participante;
import estudo.android.gameflisolandroid.models.Questionario;
import estudo.android.gameflisolandroid.service.ServiceLogin;
import estudo.android.gameflisolandroid.service.ServiceQuestionario;
import estudo.android.gameflisolandroid.util.PreferencesUtil;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by alexsandro on 03/04/16.
 */
public class ControllerQuestionario {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static final String X_AUTH= "X-Auth";

    private ServiceQuestionario serviceQuestionario;

    public ControllerQuestionario(){
        this.serviceQuestionario = new ServiceQuestionario();
    }

    public List<Questionario> getQuestionariosPorSlot(int numeroSlot, Context context) throws FalhaServidorException {

        try {
            JSONObject json = new JSONObject();
            json.put(Questionario.SLOT_HORARIO, numeroSlot);

            RequestBody body = RequestBody.create(JSON, json.toString());

            String token = PreferencesUtil.getString(context,Participante.TOKEN);

            Pair<String, String> headerAuth = new Pair<>(X_AUTH, token);

            List<Questionario> questionarios = serviceQuestionario.getQuestionarios(body, headerAuth);

            return questionarios;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


}
