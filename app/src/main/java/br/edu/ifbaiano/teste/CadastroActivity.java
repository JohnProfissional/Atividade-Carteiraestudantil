package br.edu.ifbaiano.teste;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
//import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {
    private EditText username;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        getSupportActionBar().hide();

        username = (EditText) findViewById(R.id.idUsername);
        email = (EditText) findViewById(R.id.idEmail);
        password = (EditText) findViewById(R.id.idSenha);

    }

    public void cadastrar(View View){
        if(username.getText().length() == 0){
             username.setError("Preencher campo!");
        }
        if(email.getText().length() == 0){
                email.setError("Preencher campo!");
        }
        if(password.getText().length() == 0){
                password.setError("Preencher campo!");
        }
    }
}