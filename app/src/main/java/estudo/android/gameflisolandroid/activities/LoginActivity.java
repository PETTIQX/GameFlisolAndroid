package estudo.android.gameflisolandroid.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import estudo.android.gameflisolandroid.R;
import estudo.android.gameflisolandroid.controllers.ControllerLogin;
import estudo.android.gameflisolandroid.models.Participante;

public class LoginActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etNumeroInscricao;
    private Button btSignIn;
    private AsyncTaskLogin taskLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = (EditText) findViewById(R.id.name);

        etNumeroInscricao = (EditText) findViewById(R.id.registration_nbr);

        btSignIn = (Button) findViewById(R.id.sign_in_button);

        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String numeroInscricao = etNumeroInscricao.getText().toString().trim();

                //todo validate
                taskLogin = new AsyncTaskLogin();
                taskLogin.execute(numeroInscricao);

            }
        });

    }

    private class AsyncTaskLogin extends AsyncTask<String,Void,Participante>{

        private ControllerLogin controllerLogin;

        @Override
        protected void onPreExecute() {
            controllerLogin = new ControllerLogin();
            //todo show progressbar
        }

        @Override
        protected Participante doInBackground(String... params) {
            if(params == null || params.length == 0){
                return null;
            }

            Participante participante = controllerLogin.login(params[0], getBaseContext());

            return participante;
        }

        @Override
        protected void onPostExecute(Participante participante) {
            //todo hide progressbar
            //todo next activity
            if(participante != null) {
                Toast.makeText(LoginActivity.this, participante.getEmail(), Toast.LENGTH_SHORT).show();
            }
        }

    }

}
