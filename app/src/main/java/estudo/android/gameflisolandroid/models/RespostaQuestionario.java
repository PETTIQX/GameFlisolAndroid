package estudo.android.gameflisolandroid.models;

/**
 * Created by alexsandro on 03/04/16.
 */
public class RespostaQuestionario {

    public static final String _ID = "_id";
    public static final String QUESTAO = "idQuestao";
    public static final String RESPOSTA = "resposta";
    public static final String CORRETA = "correta";
    public static final String TEMPO = "tempo";

    private String _id;
    private Questao questao;
    private int resposta;
    private boolean correta;

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
