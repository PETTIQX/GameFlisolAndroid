package estudo.android.gameflisolandroid.service.parse;

import android.support.v4.util.Pair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import estudo.android.gameflisolandroid.models.Participante;
import estudo.android.gameflisolandroid.models.Questao;
import estudo.android.gameflisolandroid.models.Questionario;
import estudo.android.gameflisolandroid.models.RespostaQuestionario;

/**
 * Created by alexsandro on 31/03/16.
 */
public class ParseJsonObject {

    public static Questionario questionarioJsonToObject(JSONObject jsonObject) throws JSONException{

        Questionario questionario = new Questionario();

        if(jsonObject.has(Questionario._ID) && !jsonObject.isNull(Questionario._ID)){
            questionario.set_id(jsonObject.getString(Questionario._ID));
        }

        if(jsonObject.has(Questionario.SALA) && !jsonObject.isNull(Questionario.SALA)){
            questionario.setSala(jsonObject.getString(Questionario.SALA));
        }

        if(jsonObject.has(Questionario.SENHA) && !jsonObject.isNull(Questionario.SENHA)){
            questionario.setSenha(jsonObject.getString(Questionario.SENHA));
        }

        if(jsonObject.has(Questionario.SLOT_HORARIO) && !jsonObject.isNull(Questionario.SLOT_HORARIO)){

            JSONArray arrayHorarios = jsonObject.getJSONArray(Questionario.SLOT_HORARIO);

            List<Integer> horarios = new ArrayList<>();

            for (int i = 0; i < arrayHorarios.length(); i++){
                horarios.add(arrayHorarios.getInt(i));
            }

            questionario.setSlotHorario(horarios);
        }

        if(jsonObject.has(Questionario.QUESTOES) && !jsonObject.isNull(Questionario.QUESTOES)){

            List<Questao> questoes = new ArrayList<>();

            JSONArray arrayQuestoes = jsonObject.getJSONArray(Questionario.QUESTOES);

            for(int i = 0; i < arrayQuestoes.length(); i++){

                Questao questao = questaoJSONtoObject(arrayQuestoes.getJSONObject(i));

                questoes.add(questao);
            }

            questionario.setQuestoes(questoes);

        }

        return questionario;
    }

    public static Questao questaoJSONtoObject(JSONObject jsonObject) throws JSONException {

        Questao questao = new Questao();

        if(jsonObject.has(Questao._ID) && !jsonObject.isNull(Questao._ID)){
            questao.set_id(jsonObject.getString(Questao._ID));
        }

        if(jsonObject.has(Questao.ENUNCIADO) && !jsonObject.isNull(Questao.ENUNCIADO)){
            questao.setEnunciado(jsonObject.getString(Questao.ENUNCIADO));
        }

        if(jsonObject.has(Questao.PONTUACAO) && !jsonObject.isNull(Questao.PONTUACAO)){
            questao.setPontuacao(jsonObject.getInt(Questao.PONTUACAO));
        }

        if(jsonObject.has(Questao.OPCOES) && !jsonObject.isNull(Questao.OPCOES)){

            JSONArray arrayOpcoes = jsonObject.getJSONArray(Questao.OPCOES);
            List<Pair<Long,String>> opcoes = new ArrayList<>();
            for(int i = 0; i < arrayOpcoes.length(); i++){
                JSONObject jsonOpcao = arrayOpcoes.getJSONObject(i);
                Pair<Long,String> opcao =
                        new Pair<>(
                                jsonOpcao.getLong(Questao.OPCAO_ID),
                                jsonOpcao.getString(Questao.OPCAO_DESCRICAO));
                opcoes.add(opcao);
            }
            questao.setOpcoes(opcoes);
        }

        if(jsonObject.has(Questao.RESPOSTA_CORRETA) && !jsonObject.isNull(Questao.RESPOSTA_CORRETA)){

            JSONObject jsonRespostaCorreta = jsonObject.getJSONObject(Questao.RESPOSTA_CORRETA);

            Pair<Long,String> respostaCorreta =
                    new Pair<>(
                            jsonRespostaCorreta.getLong(Questao.OPCAO_ID),
                            jsonRespostaCorreta.getString(Questao.OPCAO_DESCRICAO));

            questao.setRespostaCorreta(respostaCorreta);
        }

        return questao;
    }

    public static Participante participanteJSONToObject(JSONObject jsonObject) throws JSONException{

        Participante participante = new Participante();

        if(jsonObject.has(Participante.EMAIL) && !jsonObject.isNull(Participante.EMAIL)){
            participante.setEmail(jsonObject.getString(Participante.EMAIL));
        }

        if(jsonObject.has(Participante._ID) && !jsonObject.isNull(Participante._ID)){
            participante.set_id(jsonObject.getString(Participante._ID));
        }

        if(jsonObject.has(Participante.NOME) && !jsonObject.isNull(Participante.NOME)){
            participante.setNome(jsonObject.getString(Participante.NOME));
        }

        if(jsonObject.has(Participante.AUTENTICADO) && !jsonObject.isNull(Participante.AUTENTICADO)){
            participante.setAutenticado(jsonObject.getBoolean(Participante.AUTENTICADO));
        }

        return participante;

    }

}
