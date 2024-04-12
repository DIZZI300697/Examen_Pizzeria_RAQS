package com.randyquijano.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    Button agregarAlCarro;
    ImageButton Atras;
    TextView cantidad;
    TextView cantidad2;
    TextView cantidad3;
    TextView pago;
    double aguaPrice = 151.0;
    double redColaPrice = 251.0;
    double frescaPrice = 201.0;
    double total = 0.0;

    int cantidadActual = 0;
    int cantidadActual2 = 0;
    int cantidadActual3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        agregarAlCarro = findViewById(R.id.finalizarPedido);
        Atras = findViewById(R.id.atras);
        cantidad = findViewById(R.id.cantidad1);
        cantidad2 = findViewById(R.id.cantidad2);
        cantidad3 = findViewById(R.id.cantidad3);
        pago = findViewById(R.id.pago);

        Atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cerrar MainActivity4 y regresar a MainActivity2
            }
        });

        agregarAlCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                intent.putExtra("cantidadAgua", cantidadActual);
                intent.putExtra("cantidadRedCola", cantidadActual2);
                intent.putExtra("cantidadFresca", cantidadActual3);
                intent.putExtra("total", total);
                startActivity(intent);
            }
        });

        Button suma = findViewById(R.id.suma);
        Button suma2 = findViewById(R.id.suma2);
        Button suma3 = findViewById(R.id.suma3);
        Button resta = findViewById(R.id.resta);
        Button resta2 = findViewById(R.id.resta2);
        Button resta3 = findViewById(R.id.resta3);

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidadActual++;
                actualizarCantidad();
            }
        });

        suma2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidadActual2++;
                actualizarCantidad2();
            }
        });

        suma3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidadActual3++;
                actualizarCantidad3();
            }
        });

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cantidadActual > 0) {
                    cantidadActual--;
                    actualizarCantidad();
                }
            }
        });

        resta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cantidadActual2 > 0) {
                    cantidadActual2--;
                    actualizarCantidad2();
                }
            }
        });

        resta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cantidadActual3 > 0) {
                    cantidadActual3--;
                    actualizarCantidad3();
                }
            }
        });
    }

    private void actualizarCantidad() {
        cantidad.setText(String.valueOf(cantidadActual));
        total = cantidadActual * aguaPrice + cantidadActual2 * redColaPrice + cantidadActual3 * frescaPrice;
        mostrarTotal();
    }

    private void actualizarCantidad2() {
        cantidad2.setText(String.valueOf(cantidadActual2));
        total = cantidadActual * aguaPrice + cantidadActual2 * redColaPrice + cantidadActual3 * frescaPrice;
        mostrarTotal();
    }

    private void actualizarCantidad3() {
        cantidad3.setText(String.valueOf(cantidadActual3));
        total = cantidadActual * aguaPrice + cantidadActual2 * redColaPrice + cantidadActual3 * frescaPrice;
        mostrarTotal();
    }

    private void mostrarTotal() {
        pago.setText("Total a pagar: $" + total);
    }
}
