package estudo.android.gameflisolandroid.service.parse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import estudo.android.gameflisolandroid.models.Resposta;
import estudo.android.gameflisolandroid.models.RespostaQuestionario;

/**
 * Created by alexsandro on 04/04/16.
 */
public class ParseObjectJson {

    public static String respostaObjectToJson(Resposta resposta) throws JSONException {

        JSONObject objectResposta = new JSONObject();

        if(resposta.get_id() != null && !resposta.get_id().isEmpty()){
            objectResposta.putOpt(Resposta._ID, resposta.get_id());
        }

        objectResposta.put(Resposta.PARTICIPANTE, resposta.getParticipante());

        JSONObject objectRespostaQuestionario = new JSONObject();

        objectRespostaQuestionario.putOpt(Resposta.QUESTIONARIO, resposta.getQuestionario().get_id());

        JSONArray arrayRespostas = new JSONArray();

        for(int i = 0; i < resposta.getRespostas().size(); i++){

            RespostaQuestionario resp = resposta.getRespostas().get(i);

            arrayRespostas.put(respostaQuestionarioObjectToJson(resp));
        }

        objectRespostaQuestionario.put(Resposta.RESPOSTAS, arrayRespostas);

        objectResposta.put(Resposta.RESPOSTA_QUESTIONARIO, objectRespostaQuestionario);

        return objectResposta.toString();
    }

    public static JSONObject respostaQuestionarioObjectToJson(RespostaQuestionario respostaQuestionario) throws JSONException {

        JSONObject jsonObject = new JSONObject();

        if(respostaQuestionario.get_id() != null && !respostaQuestionario.get_id().isEmpty()){
            jsonObject.putOpt(RespostaQuestionario._ID, respostaQuestionario.get_id());
        }

        jsonObject.put(RespostaQuestionario.QUESTAO, respostaQuestionario.getQuestao().get_id());

        jsonObject.put(RespostaQuestionario.RESPOSTA, respostaQuestionario.getResposta());

        jsonObject.put(RespostaQuestionario.CORRETA, respostaQuestionario.isCorreta());

        jsonObject.put(RespostaQuestionario.TEMPO, respostaQuestionario.getTempo());

        return jsonObject;
    }

}
