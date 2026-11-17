package com.example.mototallerapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        EditText etCliente = findViewById(R.id.etCliente);
        EditText etMoto = findViewById(R.id.etMoto);
        RadioButton rb2T = findViewById(R.id.rb2T);
        CheckBox cbUrgente = findViewById(R.id.cbUrgente);
        Button btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(v -> {
            String cliente = etCliente.getText().toString().trim();
            String moto = etMoto.getText().toString().trim();

            if (cliente.isEmpty() || moto.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            String tipoMotor = rb2T.isChecked() ? "2 Tiempos" : "4 Tiempos";
            String prioridad = cbUrgente.isChecked() ? "Sí (Urgente)" : "Normal";

            Intent intent = new Intent(RegistroActivity.this, ConfirmacionActivity.class);
            intent.putExtra("CLIENTE", cliente);
            intent.putExtra("MOTO", moto);
            intent.putExtra("MOTOR", tipoMotor);
            intent.putExtra("PRIORIDAD", prioridad);
            startActivity(intent);
        });
    }
}