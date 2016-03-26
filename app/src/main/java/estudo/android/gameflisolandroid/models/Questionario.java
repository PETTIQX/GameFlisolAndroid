package estudo.android.gameflisolandroid.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by jordy on 26/03/16.
 */
public class Questionario implements Parcelable {

    private String enuciado;
    private String sala;
    private String senha;
    private List<Questao> questoes;

    protected Questionario(Parcel in) {
    }

    public static final Creator<Questionario> CREATOR = new Creator<Questionario>() {
        @Override
        public Questionario createFromParcel(Parcel in) {
            return new Questionario(in);
        }

        @Override
        public Questionario[] newArray(int size) {
            return new Questionario[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
