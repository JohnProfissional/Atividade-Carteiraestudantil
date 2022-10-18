package br.edu.ifbaiano.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.edu.ifbaiano.teste.helper.DBHelper;

public class CadastroActivity extends AppCompatActivity {

    DBHelper mydb;
    private EditText username;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mydb = new DBHelper(CadastroActivity.this);

        getSupportActionBar().hide();

        username = (EditText) findViewById(R.id.idUsername);
        email = (EditText) findViewById(R.id.idEmail);
        password = (EditText) findViewById(R.id.idSenha);

        Button salvar = findViewById(R.id.idButton);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().length() == 0){
                    username.setError("Preencher campo!");
                }
                if(email.getText().length() == 0){
                    email.setError("Preencher campo!");
                }
                if(password.getText().length() == 0){
                    password.setError("Preencher campo!");
                } else {
                    SharedPreferences prefs = getSharedPreferences("preferencias",
                            Context.MODE_PRIVATE);
                    SharedPreferences.Editor ed = prefs.edit();
                    ed.putString("Usuario", username.getText().toString());
                    ed.putString("Email", email.getText().toString());
                    ed.putString("Senha", password.getText().toString());
                    ed.apply();
                    Toast.makeText(getBaseContext(),"Gravado com sucesso",
                            Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}