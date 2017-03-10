package br.iesb.contatos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastroActivity extends AppCompatActivity {

    private Intent intentMandarDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btn_SalvarFormulario = (Button) findViewById(R.id.btn_SalvarFormulario);
        btn_SalvarFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentMandarDados = new Intent();

                EditText txtNome = (EditText) findViewById(R.id.txtNomeCadastro);
                String Nome = txtNome.getText().toString();
                intentMandarDados.putExtra("Nome", Nome);

                EditText txtEmail = (EditText) findViewById(R.id.txtEmailCadastro);
                String Email = txtEmail.getText().toString();
                intentMandarDados.putExtra("Email", Email);

                EditText txtTelefone = (EditText) findViewById(R.id.txtTelefoneCadastro);
                String Telefone = txtTelefone.getText().toString();
                intentMandarDados.putExtra("Telefone", Telefone);

                EditText txtEndereco = (EditText) findViewById(R.id.txtEnderecoCadastro);
                String Endereco = txtEndereco.getText().toString();
                intentMandarDados.putExtra("Endereco", Endereco);

                EditText txtSenha = (EditText) findViewById(R.id.txtSenhaCadastro);
                String Senha = txtSenha.getText().toString();
                intentMandarDados.putExtra("Senha", Senha);


                setResult(RESULT_OK, intentMandarDados);
                adicionaUsuario(intentMandarDados);


                finish();
            }
        });

        Button btn_CancelarFormulario = (Button) findViewById(R.id.btn_CancelarFormulario);
        btn_CancelarFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


    }

    private void adicionaUsuario(Intent intentMandarDados) {

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("nome", intentMandarDados.getStringExtra("Nome"));
        values.put("email", intentMandarDados.getStringExtra("Email"));
        values.put("telefone", intentMandarDados.getStringExtra("Telefone"));
        values.put("endereco", intentMandarDados.getStringExtra("Endereco"));
        values.put("senha", intentMandarDados.getStringExtra("Senha"));

        long result = db.insert("usuario", null, values);

        if(result != -1){
            Toast.makeText(this, "sucesso", Toast.LENGTH_SHORT);
        }



    }

}


