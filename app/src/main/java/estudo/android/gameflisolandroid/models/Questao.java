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

}
