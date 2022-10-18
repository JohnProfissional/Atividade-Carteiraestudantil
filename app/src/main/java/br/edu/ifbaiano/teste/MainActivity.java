package br.edu.ifbaiano.teste;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import br.edu.ifbaiano.teste.helper.DBHelper;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    TextView tvCadastrar;

    DBHelper myDB;

    /*
     * Primeiro método a ser executado quando uma Activity (tela) é chamada.
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.telalogin);
        //Método responsável por pegar em tempo de execução o objeto ActionBar e posteriormente ocultá-lo.
        getSupportActionBar().hide();

        tvCadastrar = findViewById(R.id.idCadastrar);
                tvCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(it);
            }
        });

        username= (EditText) findViewById(R.id.idUsuario);
        password= (EditText) findViewById(R.id.idSenha2);

    }

    public void entrar(View View){
        if(username.getText().length() == 0){
            username.setError("Campo obrigatório!");
        }
        if(password.getText().length() == 0){
            password.setError("Campo obrigatório!");
        }
    }
}
/*private void isLogged(){

}*/
