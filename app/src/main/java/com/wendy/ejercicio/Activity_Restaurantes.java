package com.wendy.ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_Restaurantes extends AppCompatActivity {
    //declarar variables
    private AutoCompleteTextView txtrestaurantes;
    private Button btnadd;
    private Button btnGuardar;
    private ArrayAdapter adapter;
    private ArrayList<String> lstrestaurantes;
    private String[] RESTAURANTES = {"LA PAMPA","RESTAURANTE AGAPE","LA CASONA","CHICKEN STEAK","CHINO JOE","MULTISABOR"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__restaurantes);
        //inicializar variables
        lstrestaurantes = new ArrayList<>();
        this.txtrestaurantes = findViewById(R.id.txtrestaurantes);
        this.btnadd = findViewById(R.id.btnAdd);
        this.btnGuardar = findViewById(R.id.btnguardarRes);

        this.adapter = new ArrayAdapter(Activity_Restaurantes.this,android.R.layout.simple_dropdown_item_1line,RESTAURANTES);

        //apartir de cuantos caracteres se mostraran las sugerencias
        txtrestaurantes.setThreshold(1);
        txtrestaurantes.setAdapter(adapter);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtrestaurantes.getText().toString().isEmpty()){
                    Toast.makeText(Activity_Restaurantes.this,"No deje el campo vacio",Toast.LENGTH_SHORT).show();
                }else{
                    lstrestaurantes.add(txtrestaurantes.getText().toString());
                    txtrestaurantes.setText("");
                    Toast.makeText(Activity_Restaurantes.this,"Se agrego a la lista",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restauranteresultado = new Intent();
                //se envia la lista de restaurantes
                restauranteresultado.putStringArrayListExtra("RESTAURANTE",lstrestaurantes);
                setResult(MainActivity.GUARDADORESTAURANTE,restauranteresultado);
                finish();
            }
        });
    }
}
