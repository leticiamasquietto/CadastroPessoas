package com.example.cadastropessoas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

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
}