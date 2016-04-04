package estudo.android.gameflisolandroid.controllers;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import estudo.android.gameflisolandroid.exceptions.FalhaServidorException;
import estudo.android.gameflisolandroid.models.Questionario;
import estudo.android.gameflisolandroid.service.ServiceLogin;
import estudo.android.gameflisolandroid.service.ServiceQuestionario;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by alexsandro on 03/04/16.
 */
public class ControllerQuestionario {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private ServiceQuestionario serviceQuestionario;

    public ControllerQuestionario(){
        this.serviceQuestionario = new ServiceQuestionario();
    }

    public List<Questionario> getQuestionariosPorSlot(int numeroSlot) throws FalhaServidorException {

        try {
            JSONObject json = new JSONObject();
            json.put(Questionario.SLOT_HORARIO, numeroSlot);

            RequestBody body = RequestBody.create(JSON, json.toString());

            List<Questionario> questionarios = serviceQuestionario.getQuestionarios(body);

            return questionarios;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


}
