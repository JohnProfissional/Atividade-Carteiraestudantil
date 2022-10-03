package br.edu.ifbaiano.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    EditText edt_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //getSupportActionBar().hide();
        edt_user = findViewById(R.id.idUsername);

        //O método getIntent retorna o objeto do tipo Intent, sendo possível assim,
        // obter as informações extras que foram passadas da activity anterior.

        Intent it = getIntent();

        edt_user.setText(it.getStringExtra("user").toString());
    }
}