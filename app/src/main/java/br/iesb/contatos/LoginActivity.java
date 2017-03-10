package br.iesb.contatos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper dbHelper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button btnLogin = (Button) findViewById(R.id.btn_Login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText txtEmail = (EditText) findViewById(R.id.txtEmailCadastro);
                String Email = txtEmail.getText().toString();
                EditText txtSenha = (EditText) findViewById(R.id.txtSenhaCadastro);
                String Senha = txtSenha.getText().toString();

                if(Email != null || Senha != null){

                    Toast.makeText(LoginActivity.this, "Nao ta vazio", Toast.LENGTH_SHORT).show();

                }

            }
        });

        Button btn = (Button) findViewById(R.id.btn_cadastrar);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentChamaCadastro = new Intent (LoginActivity.this, cadastroActivity.class);
                startActivityForResult(intentChamaCadastro, 9999);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            String Email = data.getExtras().getString("Email");
            EditText txtEmailLogin = (EditText) findViewById(R.id.txtEmailLogin);
            txtEmailLogin.setText(Email);
        }

    }

    private void ValidaLogin(String Email, String Senha){
        SQLiteDatabase db = dbHelper.getReadableDatabase();


    }
}
