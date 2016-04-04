package estudo.android.gameflisolandroid.models;

import java.util.List;

/**
 * Created by jordy on 26/03/16.
 */
public class Resposta {

    public static final String _ID = "_id";
    public static final String PARTICIPANTE = "participante";
    public static final String RESPOSTA_QUESTIONARIO = "respostaQuestionario";
    public static final String QUESTIONARIO = "questionario";
    public static final String RESPOSTAS = "respostas";

    private String _id;
    private String participante; //Numero de inscricao
    private List<RespostaQuestionario> respostas;
    private Questionario questionario;

    public List<RespostaQuestionario> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostaQuestionario> respostas) {
        this.respostas = respostas;
    }

    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }
}
