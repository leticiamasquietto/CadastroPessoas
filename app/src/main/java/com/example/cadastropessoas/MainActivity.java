package com.example.cadastropessoas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity principal responsável pelo cadastro de pessoas.
 */
public class MainActivity extends AppCompatActivity {

    private EditText etNome, etIdade, etEndereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CICLO", "onCreate Main");
        setContentView(R.layout.activity_main);

        etNome = findViewById(R.id.etNome);
        etIdade = findViewById(R.id.etIdade);
        etEndereco = findViewById(R.id.etEndereco);

        Button btnSalvar = findViewById(R.id.btnSalvar);

        Intent intentRecebida = getIntent();
        if(intentRecebida.hasExtra("nome")){
            etNome.setText(intentRecebida.getStringExtra("nome"));
            etIdade.setText(intentRecebida.getStringExtra("idade"));
            etEndereco.setText(intentRecebida.getStringExtra("endereco"));
        }

        btnSalvar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);

            intent.putExtra("nome", etNome.getText().toString());
            intent.putExtra("idade", etIdade.getText().toString());
            intent.putExtra("endereco", etEndereco.getText().toString());

            startActivity(intent);
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CICLO", "onStart Main");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CICLO", "onResume Main");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CICLO", "onPause Main");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CICLO", "onStop Main");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CICLO", "onDestroy Main");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("MENU", "Criando menu");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_sobre) {
            Intent intent = new Intent(MainActivity.this, SobreActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}