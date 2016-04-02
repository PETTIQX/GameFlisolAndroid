package estudo.android.gameflisolandroid.service.parse;

import org.json.JSONException;
import org.json.JSONObject;

import estudo.android.gameflisolandroid.models.Participante;

/**
 * Created by alexsandro on 31/03/16.
 */
public class ParseJsonObject {

    public static Participante participanteJSONToObject(JSONObject json) throws JSONException{

        Participante participante = new Participante();

        if(json.has(Participante.EMAIL) && !json.isNull(Participante.EMAIL)){
            participante.setEmail(json.getString(Participante.EMAIL));
        }

        if(json.has(Participante._ID) && !json.isNull(Participante._ID)){
            participante.set_id(json.getString(Participante._ID));
        }

        if(json.has(Participante.NOME) && !json.isNull(Participante.NOME)){
            participante.setNome(json.getString(Participante.NOME));
        }

        if(json.has(Participante.AUTENTICADO) && !json.isNull(Participante.AUTENTICADO)){
            participante.setAutenticado(json.getBoolean(Participante.AUTENTICADO));
        }

        return participante;

    }


}
