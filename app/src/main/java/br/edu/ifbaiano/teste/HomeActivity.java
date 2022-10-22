package br.edu.ifbaiano.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.edu.ifbaiano.teste.helper.DBHelper;
import br.edu.ifbaiano.teste.DAO.User;

public class HomeActivity extends AppCompatActivity{
    DBHelper mydb;
    User userDao;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv = findViewById(R.id.txtLinkCadastro2);

        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        String user = bundle.getString("user");

        mydb = new DBHelper(HomeActivity.this);

        userDao = mydb.obterUsuarioPorUser(user);

        tv.setText(userDao.getUsername());
    }
}
