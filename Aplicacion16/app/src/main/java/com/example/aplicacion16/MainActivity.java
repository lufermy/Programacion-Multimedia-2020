package com.example.aplicacion16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    MiArrayAdapter<Tarea> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.lista);

        //Creamos un array de String
        String[] data = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"};
        adaptador = new MiArrayAdapter<Tarea>(this, DatosTarea.TAREAS);
        lista.setAdapter(adaptador);
    }
}