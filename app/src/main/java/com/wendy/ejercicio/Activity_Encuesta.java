package com.wendy.ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Encuesta extends AppCompatActivity {
    //declaracion de variables
    private EditText txtnombres;
    private EditText txtapellidos;
    private EditText txtedad;
    private Button btnguardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__encuesta);
        //inicializar las variables
        this.txtnombres = findViewById(R.id.txtnombre);
        this.txtapellidos = findViewById(R.id.txtapellidos);
        this.txtedad = findViewById(R.id.txtedad);
        this.btnguardar = findViewById(R.id.btnguardar);


        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //recibir parametros escritos en los EditText
                String nombre = txtnombres.getText().toString();
                String apellidos = txtapellidos.getText().toString();
                String edad =  txtedad.getText().toString();
                if(nombre.isEmpty() && apellidos.isEmpty()&&edad.isEmpty()){
                    Toast.makeText(Activity_Encuesta.this,"Por favor llene todos los campos",Toast.LENGTH_SHORT).show();
                }else{
                    Intent resultado = new Intent();
                    resultado.putExtra("NOMBRE",nombre);
                    resultado.putExtra("APELLIDO",apellidos);
                    resultado.putExtra("EDAD",edad);
                    setResult(MainActivity.GUARDADOENCUESTA,resultado);
                    finish();
                }
            }
        });
    }
}
