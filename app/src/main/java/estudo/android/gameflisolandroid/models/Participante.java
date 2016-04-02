package estudo.android.gameflisolandroid.models;

/**
 * Created by jordy on 26/03/16.
 */
public class Participante {

    private String _id;
    private String nome;
    private String email;
    private boolean autenticado;
    private String token;

    public static final String _ID = "_id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";
    public static final String AUTENTICADO = "autenticado";
    public static final String TOKEN = "token";


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
