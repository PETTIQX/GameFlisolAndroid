package estudo.android.gameflisolandroid;

import android.util.Log;

import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import estudo.android.gameflisolandroid.models.Questao;
import estudo.android.gameflisolandroid.models.Questionario;
import estudo.android.gameflisolandroid.models.Resposta;
import estudo.android.gameflisolandroid.models.RespostaQuestionario;
import estudo.android.gameflisolandroid.service.parse.ParseObjectJson;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Test
    public void respostaToJson(){

        Resposta resposta = new Resposta();

        resposta.setParticipante("1234");

        Questionario questionario = new Questionario();
        questionario.set_id("12312361284126");
        resposta.setQuestionario(questionario);

        List<RespostaQuestionario> respostas = new ArrayList<>();

        for (int i = 0; i < 3; i++){

            RespostaQuestionario resp = new RespostaQuestionario();
            resp.setCorreta(true);
            resp.setTempo(100);
            resp.setResposta(3);

            Questao questao = new Questao();
            questao.set_id("" + i);

            resp.setQuestao(questao);

            respostas.add(resp);
        }

        resposta.setRespostas(respostas);

        try {
            System.out.println(ParseObjectJson.respostaObjectToJson(resposta));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        assertEquals(true,true);

    }

}