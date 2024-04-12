package com.randyquijano.pizzeria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {
    ImageButton Pizza;
    ImageButton Refrescos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Recuperar el nombre de usuario pasado desde MainActivity
        String username = getIntent().getStringExtra("username");

        // Mostrar el saludo personalizado en un cuadro de diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("¡Bienvenido, " + username + "!")
                .setMessage("¿Qué te podemos llevar hasta tu casa este día?")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Cerrar el diálogo cuando se presiona el botón Aceptar
                    }
                })
                .show();

        Pizza = findViewById(R.id.Pizza);
        Refrescos = findViewById(R.id.Refrescos);

        Pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPizza = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intentPizza);
            }
        });

        Refrescos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRefrescos = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(intentRefrescos);
            }
        });
    }
}
