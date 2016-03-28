package estudo.android.gameflisolandroid.models;

import android.support.v4.util.Pair;

import java.util.List;

/**
 * Created by jordy on 26/03/16.
 */
public class Questao {
    private long _id;
    private String enunciado;
    private List<Pair<Long,String>> opcoes;
    private Pair<Long,String> respostaCorreta;
    private int pontuacao;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
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
