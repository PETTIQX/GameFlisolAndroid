package estudo.android.gameflisolandroid.models;

import android.support.v4.util.Pair;

import java.util.List;

/**
 * Created by jordy on 26/03/16.
 */
public class Questao {

    public static final String _ID = "_id";
    public static final String ENUNCIADO = "enunciado";
    public static final String OPCOES = "opcoes";
    public static final String OPCAO_ID = "idOpcao";
    public static final String OPCAO_DESCRICAO = "descricao";
    public static final String RESPOSTA_CORRETA = "respostaCorreta";
    public static final String PONTUACAO = "pontuacao";


    private String _id;
    private String enunciado;
    private List<Pair<Long,String>> opcoes;
    private Pair<Long,String> respostaCorreta;
    private int pontuacao;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<Pair<Long, String>> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<Pair<Long, String>> opcoes) {
        this.opcoes = opcoes;
    }

    public Pair<Long, String> getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(Pair<Long, String> respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
