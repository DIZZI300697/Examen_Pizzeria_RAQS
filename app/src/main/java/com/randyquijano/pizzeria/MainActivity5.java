package com.randyquijano.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    TextView textoPedido;
    TextView totalAPagar;
    Button enviarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        textoPedido = findViewById(R.id.textoPedido);
        totalAPagar = findViewById(R.id.totalAPagar);
        enviarPedido = findViewById(R.id.enviarPedido);

        Intent intent = getIntent();
        int cantidadPeperoni = intent.getIntExtra("cantidadPeperoni", 0);
        int cantidadItaliana = intent.getIntExtra("cantidadItaliana", 0);
        int cantidadMexicana = intent.getIntExtra("cantidadMexicana", 0);
        int cantidadRefrescoNormal = intent.getIntExtra("cantidadRefrescoNormal", 0);
        int cantidadRefrescoGrande = intent.getIntExtra("cantidadRefrescoGrande", 0);
        int cantidadRefrescoExtraGrande = intent.getIntExtra("cantidadRefrescoExtraGrande", 0);
        double total = intent.getDoubleExtra("total", 0.0);

        StringBuilder resumenPedido = new StringBuilder("Resumen del pedido:\n");
        if (cantidadPeperoni > 0) {
            resumenPedido.append("Pizza Peperoni (x").append(cantidadPeperoni).append("): $").append(cantidadPeperoni * 10.0).append("\n");
        }
        if (cantidadItaliana > 0) {
            resumenPedido.append("Pizza Italiana (x").append(cantidadItaliana).append("): $").append(cantidadItaliana * 15.0).append("\n");
        }
        if (cantidadMexicana > 0) {
            resumenPedido.append("Pizza Mexicana (x").append(cantidadMexicana).append("): $").append(cantidadMexicana * 20.0).append("\n");
        }
        if (cantidadRefrescoNormal > 0) {
            resumenPedido.append("Refresco Normal (x").append(cantidadRefrescoNormal).append("): $").append(cantidadRefrescoNormal * 3.0).append("\n");
        }
        if (cantidadRefrescoGrande > 0) {
            resumenPedido.append("Refresco Grande (x").append(cantidadRefrescoGrande).append("): $").append(cantidadRefrescoGrande * 5.0).append("\n");
        }
        if (cantidadRefrescoExtraGrande > 0) {
            resumenPedido.append("Refresco Extra Grande (x").append(cantidadRefrescoExtraGrande).append("): $").append(cantidadRefrescoExtraGrande * 7.0).append("\n");
        }
        resumenPedido.append("\nTotal a pagar: $").append(total);
        textoPedido.setText(resumenPedido.toString());

        totalAPagar.setText("Total a pagar: $" + total);

        enviarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cantidadPeperoni == 0 && cantidadItaliana == 0 && cantidadMexicana == 0 && cantidadRefrescoNormal == 0 && cantidadRefrescoGrande == 0 && cantidadRefrescoExtraGrande == 0) {

                    Toast.makeText(MainActivity5.this, "Debe seleccionar al menos un producto", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(MainActivity5.this, "Gracias por utilizar la app de vitoLuigini. Su pedido fue recibido en breve se enviará.", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
}
