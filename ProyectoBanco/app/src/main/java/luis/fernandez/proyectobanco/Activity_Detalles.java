package luis.fernandez.proyectobanco;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import luis.fernandez.proyectobanco.fragment.Activity_Fragment_Detalle;
import luis.fernandez.proyectobanco.pojo.Cuenta;


public class Activity_Detalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_detalles);

        Activity_Fragment_Detalle detalle = (Activity_Fragment_Detalle)getSupportFragmentManager().findFragmentById(R.id.FrgDetalle);

        detalle.mostrarDetalles((Cuenta) getIntent().getSerializableExtra("TextoDetalle"));
    }
}