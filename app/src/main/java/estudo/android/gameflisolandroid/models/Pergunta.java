package estudo.android.gameflisolandroid.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jordy on 26/03/16.
 */
public class Pergunta implements Parcelable {
    protected Pergunta(Parcel in) {
    }

    public static final Creator<Pergunta> CREATOR = new Creator<Pergunta>() {
        @Override
        public Pergunta createFromParcel(Parcel in) {
            return new Pergunta(in);
        }

        @Override
        public Pergunta[] newArray(int size) {
            return new Pergunta[size];
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
