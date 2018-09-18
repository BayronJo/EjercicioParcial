package com.wendy.ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //crear las variables
    private Button btnencuesta;
    private Button btncomidas;
    private Button btnrestaurantes;
    private ArrayList<String> lstcomida;
    private ArrayList<String> lstrestaurantes;
    private ArrayList<Encuestado> lstencuesta;
    public static final int GUARDADOENCUESTA =1;
    public static final int GUARDADOCOMIDA =2;
    public static final int GUARDADORESTAURANTE =3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inicializando las variables declaradas
        this.btnencuesta = findViewById(R.id.btnencuesta);
        this.btncomidas = findViewById(R.id.btncomidas);
        this.btnrestaurantes = findViewById(R.id.btnrestaurantes);
        lstencuesta = new ArrayList<>();
        lstcomida = new ArrayList<>();
        lstrestaurantes = new ArrayList<>();

        btnencuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //para hacer una llamada a otra pantalla se crea un intent
                Intent encuesta = new Intent(MainActivity.this,Activity_Encuesta.class);
                startActivityForResult(encuesta,GUARDADOENCUESTA);
            }
        });

        btncomidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent comida = new Intent(MainActivity.this,Activity_Comidas.class);
                startActivityForResult(comida,GUARDADOCOMIDA);
            }
        });

        btnrestaurantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restaurantes = new Intent(MainActivity.this,Activity_Restaurantes.class);
                startActivityForResult(restaurantes,GUARDADORESTAURANTE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case GUARDADOENCUESTA:
                if(data==null)return;
                Encuestado encuestado = new Encuestado(data.getExtras().getString("NOMBRE"),data.getExtras().getString("APELLIDO"),data.getExtras().getString("EDAD"));
                lstencuesta.add(encuestado);

                for(final Encuestado e:lstencuesta){
                    Toast.makeText(MainActivity.this,"Nombres : "+ e.nombres+"\n"+"Apellidos : "+ e.Apellidos+"\n"+"Edad : "+ e.Edad+"\n",Toast.LENGTH_SHORT ).show();
                }
                break;
            case GUARDADOCOMIDA:
                if(data==null)return;
                lstcomida = data.getExtras().getStringArrayList("COMIDA");
                for(final String comida: lstcomida ){
                    Toast.makeText(MainActivity.this,"Comidas Seleccionadas : \n" +comida.toString(),Toast.LENGTH_SHORT ).show();
                }
                break;
            case GUARDADORESTAURANTE:
                if(data==null)return;
                lstrestaurantes = data.getExtras().getStringArrayList("RESTAURANTE");
                for(final String restaurante: lstrestaurantes ){
                    Toast.makeText(MainActivity.this,"Restaurantes Seleccionados : \n" +restaurante.toString(),Toast.LENGTH_SHORT ).show();
                }
                break;
        }
    }
}
