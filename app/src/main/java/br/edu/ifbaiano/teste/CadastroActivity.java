package br.edu.ifbaiano.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifbaiano.teste.helper.DBHelper;

public class CadastroActivity extends AppCompatActivity {

    DBHelper mydb;
    EditText username, email, password;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mydb = new DBHelper(CadastroActivity.this);

        getSupportActionBar().hide();

        username = findViewById(R.id.idUsername);
        email = findViewById(R.id.idEmail);
        password = findViewById(R.id.idSenha);
        btnCadastrar = findViewById(R.id.idButton);

        //O método getIntent retorna o objeto do tipo Intent, sendo possível assim,
        // obter as informações extras que foram passadas da activity anterior.

        Intent it = getIntent();

        username.setText(it.getStringExtra("user").toString());


        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("")){
                    username.setError("Preencher campo!");
                }
                if(email.getText().toString().equals("")){
                    email.setError("Preencher campo!");
                }
                if(password.getText().toString().equals("")){
                    password.setError("Preencher campo!");
                }

                boolean isCadastrado = mydb.usuarioExistente(email.getText().toString());
                if (isCadastrado){
                    Toast.makeText(CadastroActivity.this, "Já existe usuário cadastrado com este email", Toast.LENGTH_LONG).show();
                }else{
                    boolean insert = mydb.cadastrarUsuario(username.getText().toString(), email.getText().toString(),
                            password.getText().toString());

                    if (insert){
                        Intent it = new Intent(CadastroActivity.this, HomeActivity.class);
                        it.putExtra("user",username.getText().toString());
                        startActivity(it);
                    }else{
                        Toast.makeText(CadastroActivity.this, "Erro ao cadastrar usuário", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}