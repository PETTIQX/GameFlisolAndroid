package estudo.android.gameflisolandroid.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by jordy on 26/03/16.
 */
public class Questionario{

    public static final String _ID = "_id";
    public static final String SALA = "sala";
    public static final String SENHA = "senha";
    public static final String QUESTOES = "questoes";
    public static final String SLOT_HORARIO = "slotHorario";

    private String _id;
    private String sala;
    private String senha;
    private List<Questao> questoes;
    private List<Integer> slotHorario;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public List<Integer> getSlotHorario() {
        return slotHorario;
    }

    public void setSlotHorario(List<Integer> slotHorario) {
        this.slotHorario = slotHorario;
    }
}
