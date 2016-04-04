package estudo.android.gameflisolandroid.exceptions;

/**
 * Created by alexsandro on 03/04/16.
 */
public class FalhaServidorException extends Exception{

    //500 falha servidor
    //

    private String error;
    private int code;

    public FalhaServidorException(String error, int code){
        super(error);
        this.error = error;
        this.code = code;
    }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
