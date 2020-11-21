package luis.fernandez.aplicacion15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    ArrayAdapter<String> adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista.findViewById(R.id.lista);
        //Creamos un array de Strings
        String[] data = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"};
        new MiArrayAdapter<String>(this, DatosTareas.TAREAS);
        lista.setAdapter(adaptador);
    }

}