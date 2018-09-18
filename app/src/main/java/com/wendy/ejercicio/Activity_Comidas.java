package com.wendy.ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;

public class Activity_Comidas extends AppCompatActivity {
    //declaracion  de variables
    private ArrayList<CheckBox> lstcheckbox;
    private Button btnguardar;
    private ArrayList<String> lstcomida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__comidas);
        //inicializamos las variables
        lstcomida = new ArrayList<>();
        lstcheckbox = new ArrayList<>();
        lstcheckbox.add((CheckBox) findViewById(R.id.chkcarnes));
        lstcheckbox.add((CheckBox) findViewById(R.id.chkensaladas));
        lstcheckbox.add((CheckBox) findViewById(R.id.chkpastas));
        this.btnguardar = findViewById(R.id.btnGuardar);
        for(final CheckBox chk:lstcheckbox){
            chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        lstcomida.add(buttonView.getText().toString());
                    }
                }
            });
        }

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent comidaresultado = new Intent();
                //se envia la lista de comidas
                comidaresultado.putStringArrayListExtra("COMIDA",lstcomida);
                setResult(MainActivity.GUARDADOCOMIDA,comidaresultado);
                finish();
            }
        });
    }
}
