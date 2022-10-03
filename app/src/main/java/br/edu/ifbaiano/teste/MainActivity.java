package br.edu.ifbaiano.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;
//import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
//import android.widget.ProgressBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText edtUser;
    Button btnLogin;

    TextView tvCadastrar;


    /*
     * Primeiro método a ser executado quando uma Activity (tela) é chamada.
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Método responsável pela ligação da activity com o layout produzido.
        setContentView(R.layout.telalogin);

        //Método responsável por pegar em tempo de execução o objeto ActionBar e posteriormente ocultá-lo.
        getSupportActionBar().hide();

        //Ação necessária para obter em tempo de execução a view (componente) correspondente.
        tvCadastrar = findViewById(R.id.idCadastrar);
        edtUser = findViewById(R.id.idUsername);
        btnLogin = findViewById(R.id.idButtonentrar);

        /*
         * Ao definir um listener a um botão, o mesmo fica monitorando o componente que caso seja clicado,
         * automaticamente executa o método onClick.
         * */
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edtUser.getText().toString().isEmpty()) {
                    edtUser.setError("Campo obrigatório!");
                }else{
                    Toast.makeText(MainActivity.this, "Usuário não cadastrado",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProgressDialog pg = new ProgressDialog(MainActivity.this);
                pg.setTitle("Redirecionando...");
                pg.show();

                /*
                 * Intent é a forma como o Android gerencia a comunicação entre activitys e outras aplicações.
                 * É necessário ao chamar uma nova activity, os parâmetros, Activity atual (contexto) e a nova activity a ser acessada.
                 * */
                Intent it = new Intent(MainActivity.this, CadastroActivity.class);

                //O método putExtra é responsável por adicionar informações que serão passadas para a nova activity.
                it.putExtra("user", edtUser.getText().toString());

                startActivity(it);


            }
        });



    }
}