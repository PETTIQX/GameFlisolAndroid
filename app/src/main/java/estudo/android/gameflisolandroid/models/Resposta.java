package estudo.android.gameflisolandroid.models;

import java.util.List;

/**
 * Created by jordy on 26/03/16.
 */
public class Resposta {
    private String participante; //Numero de inscricao
    private List<RespostaQuestionario> respostas;



    class RespostaQuestionario
    {
        private Questao questao;
        private int resposta;
        private boolean correta;
    }
}
