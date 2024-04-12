package com.randyquijano.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    Button suma;
    Button suma2;
    Button suma3;
    Button resta;
    Button resta2;
    Button resta3;
    ImageButton Atras;
    TextView cantidad;
    TextView cantidad2;
    TextView cantidad3;
    TextView pago;
    double pizzaPeperoniPrice = 101.0;
    double pizzaItalianaPrice = 151.0;
    double pizzaMexicanaPrice = 201.0;
    double total = 0.0;

    int cantidadActual = 0;
    int cantidadActual2 = 0;
    int cantidadActual3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        suma = findViewById(R.id.suma);
        resta = findViewById(R.id.resta);
        cantidad = findViewById(R.id.cantidad1);
        suma2 = findViewById(R.id.suma2);
        resta2 = findViewById(R.id.resta2);
        cantidad2 = findViewById(R.id.cantidad2);
        suma3 = findViewById(R.id.suma3);
        resta3 = findViewById(R.id.resta3);
        cantidad3 = findViewById(R.id.cantidad3);
        Atras = findViewById(R.id.atras);
        pago = findViewById(R.id.pago);

        Atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cerrar MainActivity3 y regresar a la actividad anterior
            }
        });

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidadActual++;
                actualizarCantidad();
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

        suma2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidadActual2++;
                actualizarCantidad2();
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

        suma3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidadActual3++;
                actualizarCantidad3();
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

        // Agregar el botón "Agregar al Carro"
        Button agregarAlCarro = findViewById(R.id.agregarAlCarro);
        agregarAlCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes agregar lógica para guardar el pedido en el carro
            }
        });

        // Agregar el botón "Finalizar Pedido"
        Button finalizarPedido = findViewById(R.id.finalizarPedido);
        finalizarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity5.class);
                intent.putExtra("cantidadPeperoni", cantidadActual);
                intent.putExtra("cantidadItaliana", cantidadActual2);
                intent.putExtra("cantidadMexicana", cantidadActual3);
                intent.putExtra("total", total);
                startActivity(intent);
            }
        });
    }

    // Actualiza el TextView de cantidad y calcula el total
    private void actualizarCantidad() {
        cantidad.setText(String.valueOf(cantidadActual));
        total = cantidadActual * pizzaPeperoniPrice + cantidadActual2 * pizzaItalianaPrice + cantidadActual3 * pizzaMexicanaPrice;
        mostrarTotal();
    }

    private void actualizarCantidad2() {
        cantidad2.setText(String.valueOf(cantidadActual2));
        total = cantidadActual * pizzaPeperoniPrice + cantidadActual2 * pizzaItalianaPrice + cantidadActual3 * pizzaMexicanaPrice;
        mostrarTotal();
    }

    private void actualizarCantidad3() {
        cantidad3.setText(String.valueOf(cantidadActual3));
        total = cantidadActual * pizzaPeperoniPrice + cantidadActual2 * pizzaItalianaPrice + cantidadActual3 * pizzaMexicanaPrice;
        mostrarTotal();
    }

    // Muestra el total en el TextView de pago
    private void mostrarTotal() {
        pago.setText("Total a pagar: $" + total);
    }
}
