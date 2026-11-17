package com.example.mototallerapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        TextView tvResumen = findViewById(R.id.tvResumen);
        Button btnSalir = findViewById(R.id.btnSalir);

        String cliente = getIntent().getStringExtra("CLIENTE");
        String moto = getIntent().getStringExtra("MOTO");
        String motor = getIntent().getStringExtra("MOTOR");
        String prioridad = getIntent().getStringExtra("PRIORIDAD");

        String textoFinal = "Propietario: " + cliente + "\n\n" +
                "Motocicleta: " + moto + "\n\n" +
                "Tipo de Motor: " + motor + "\n\n" +
                "Prioridad: " + prioridad;

        tvResumen.setText(textoFinal);

        btnSalir.setOnClickListener(v -> {
            finishAffinity(); // Cierra todas las pantallas de la app
            System.exit(0);   // Detiene el proceso por completo
        });
    }
}