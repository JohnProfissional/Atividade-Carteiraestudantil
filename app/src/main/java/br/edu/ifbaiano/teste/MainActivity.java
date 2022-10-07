package br.edu.ifbaiano.teste;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText campo1;
    private EditText campo2;
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

        campo1= (EditText) findViewById(R.id.idUsuario);
        campo2= (EditText) findViewById(R.id.idSenha2);


    }

    public void entrar(View View){
        if(campo1.getText().length() == 0){
            campo1.setError("Campo obrigatório!");
        }
        if(campo2.getText().length() == 0){
            campo2.setError("Campo obrigatório!");
        }
    }
}
/*private void isLogged(){

}*/
