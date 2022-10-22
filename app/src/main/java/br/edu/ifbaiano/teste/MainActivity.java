package br.edu.ifbaiano.teste;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.prefs.Preferences;

import br.edu.ifbaiano.teste.helper.DBHelper;

public class MainActivity extends AppCompatActivity {
    EditText usuario, senha;
    Button btnEntrar;
    TextView tvCadastrar;

    DBHelper myDB;

    /*
     * Primeiro método a ser executado quando uma Activity (tela) é chamada.
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //isLogged();

        myDB = new DBHelper(MainActivity.this);

        //Método responsável pela ligação da activity com o layout produzido.
        setContentView(R.layout.telalogin);

        //Método responsável por pegar em tempo de execução o objeto ActionBar e posteriormente ocultá-lo.
        getSupportActionBar().hide();

        //Ação necessária para obter em tempo de execução a view (componente) correspondente.
        tvCadastrar = findViewById(R.id.idCadastrar);
        usuario = findViewById(R.id.idUsuario);
        senha = findViewById(R.id.idSenha2);
        btnEntrar = findViewById(R.id.idButtonentrar);

        /*
         * Ao definir um listener a um botão, o mesmo fica monitorando o componente que caso seja clicado,
         * automaticamente executa o método onClick.
         * */
        btnEntrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(usuario.getText().toString().isEmpty()){
                    usuario.setError("Campo obrigatório!");
                }if (senha.getText().toString().isEmpty()){
                    senha.setError("Campo obrigatório!");
                }

                Boolean login = myDB.validarLoginSenha(usuario.getText().toString(),
                        senha.getText().toString());

                        if (login){
                            Toast.makeText(MainActivity.this, "Login com sucesso", Toast.LENGTH_LONG).show();

                            SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                            SharedPreferences.Editor myEditor = myPreferences.edit();
                            myEditor.putString("USUARIO", usuario.getText().toString());
                            myEditor.commit();

                            Intent it = new Intent(MainActivity.this, HomeActivity.class);
                            it.putExtra("usuario", usuario.getText().toString());
                            startActivity(it);
                        }else{
                            Toast.makeText(MainActivity.this, "Login incorreto", Toast.LENGTH_LONG).show();
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
                it.putExtra("usuario", usuario.getText().toString());

                startActivity(it);

            }
        });


    }

    private void isLogged(){

        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String user = myPreferences.getString("USER", "");

        if (user.equals("")){
            return;
        }else{
            Intent it = new Intent(getApplicationContext(), HomeActivity.class);
            it.putExtra("user", user);
            startActivity(it);
        }

}
    @Override
    protected void onResume() {

        super.onResume();

                // progressBar,dismiss();

        Log.d("TAG", "onResume: ");
        /* if(getSupportActionBar() != null){
            getSupportActionBar().show();
        }
        Toast.makeText(MainActivity.this, "passou resume", Toast.LENGTH_SHORT).show();*/
    }


}

