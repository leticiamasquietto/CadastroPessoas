package com.example.cadastropessoas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity responsável pela confirmação dos dados.
 */
public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CICLO", "onCreate Confirm");
        setContentView(R.layout.activity_confirm);

        TextView tvDados = findViewById(R.id.tvDados);

        Intent intent = getIntent();

        String nome = intent.getStringExtra("nome");
        String idade = intent.getStringExtra("idade");
        String endereco = intent.getStringExtra("endereco");

        tvDados.setText(nome + "\n" + idade + "\n" + endereco);

        Button btnSim = findViewById(R.id.btnSim);
        Button btnNao = findViewById(R.id.btnNao);

        btnSim.setOnClickListener(v -> {
            Toast.makeText(this, getString(R.string.sucesso), Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        });

        btnNao.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);

            i.putExtra("nome", nome);
            i.putExtra("idade", idade);
            i.putExtra("endereco", endereco);

            startActivity(i);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CICLO", "onStart Confirm");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CICLO", "onDestroy Confirm");
    }
}