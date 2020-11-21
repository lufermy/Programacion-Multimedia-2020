package luis.fernandez.proyectobanco;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import luis.fernandez.proyectobanco.bd.MiBancoOperacional;
import luis.fernandez.proyectobanco.fragment.Activity_Fragment_Detalle;
import luis.fernandez.proyectobanco.fragment.Activity_Fragment_Lista;
import luis.fernandez.proyectobanco.fragment.CuentaListener;
import luis.fernandez.proyectobanco.pojo.Cuenta;

public class PosicionActivity extends AppCompatActivity implements CuentaListener {

    ListView listaCuentas;
    TextView titulo;
    ArrayList<Cuenta> cuentas;
    ArrayAdapter<String> adaptador;
    MiBancoOperacional mbo;
    ListView listaMovimientos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_principal);

        Activity_Fragment_Lista frgLista=(Activity_Fragment_Lista)getSupportFragmentManager().findFragmentById(R.id.FrgListado);

        frgLista.setCuentaLister(this);

    }

    @Override
    public void onCuentaSeleccionada(Cuenta c) {
        boolean hayDetalle = (getSupportFragmentManager().findFragmentById(R.id.FrgDetalle)!=null);

        if(hayDetalle){
            ((Activity_Fragment_Detalle)getSupportFragmentManager().findFragmentById(R.id.FrgDetalle)).mostrarDetalles(c);

        }
        else{
            Intent i = new Intent(this, Activity_Detalles.class);
            i.putExtra("TextoDetalle", c);
            startActivity(i);
        }
    }
}