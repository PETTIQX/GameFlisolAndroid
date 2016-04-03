package estudo.android.gameflisolandroid.activities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import estudo.android.gameflisolandroid.R;
import estudo.android.gameflisolandroid.controllers.ControllerLogin;
import estudo.android.gameflisolandroid.models.Participante;
import estudo.android.gameflisolandroid.util.PreferencesUtil;

public class LoginActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etNumeroInscricao;
    private Button btSignIn;
    private AsyncTaskLogin taskLogin;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        etName = (EditText) findViewById(R.id.name);

        etNumeroInscricao = (EditText) findViewById(R.id.registration_nbr);

        btSignIn = (Button) findViewById(R.id.sign_in_button);

        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String numeroInscricao = etNumeroInscricao.getText().toString().trim();

                View focusView = null;

                if(etName.getText().toString().isEmpty()){
                    etName.setError("Campo obrigatório");
                    focusView = etName;
                }

                if(etNumeroInscricao.getText().toString().isEmpty()){
                    etNumeroInscricao.setError("Campo obrigatório");
                    focusView = etNumeroInscricao;
                }

                if(focusView == null) {
                    taskLogin = new AsyncTaskLogin();
                    taskLogin.execute(numeroInscricao);
                }else{
                    focusView.requestFocus();
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        isSigned();
    }

    private class AsyncTaskLogin extends AsyncTask<String,Void,Participante>{

        private ControllerLogin controllerLogin;

        @Override
        protected void onPreExecute() {
            controllerLogin = new ControllerLogin();
            progressBar.setVisibility(View.VISIBLE);
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
            if(participante != null) {
                //Toast.makeText(LoginActivity.this, participante.getEmail(), Toast.LENGTH_SHORT).show();
                isSigned();
            }else{
                Toast.makeText(LoginActivity.this, "Número de inscrição inexistente!", Toast.LENGTH_SHORT).show();
            }

            progressBar.setVisibility(View.GONE);

        }

    }

    public void isSigned(){

        String token = PreferencesUtil.getString(getBaseContext(), Participante.TOKEN);

        if(token == null || token.isEmpty()){
            return;
        }

        finish();
        startActivity(new Intent(getBaseContext(), MenuPrincipal.class));

    }

}
