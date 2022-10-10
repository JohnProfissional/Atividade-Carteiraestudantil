package br.edu.ifbaiano.teste;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText usuario;
    private EditText senha;
    TextView tvCadastrar;

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

        usuario= (EditText) findViewById(R.id.idUsuario);
        senha= (EditText) findViewById(R.id.idSenha2);

    }

    public void entrar(View View){
        if(usuario.getText().length() == 0){
            usuario.setError("Campo obrigatório!");
        }
        if(senha.getText().length() == 0){
            senha.setError("Campo obrigatório!");
        }
    }
}
/*private void isLogged(){

}*/
