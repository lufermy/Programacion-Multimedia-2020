package luis.fernandez.proyectobanco.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import luis.fernandez.proyectobanco.R;
import luis.fernandez.proyectobanco.adaptador.AdaptadorCuenta;
import luis.fernandez.proyectobanco.pojo.Cliente;
import luis.fernandez.proyectobanco.pojo.Cuenta;
import luis.fernandez.proyectobanco.pojo.Movimiento;


public class Activity_Fragment_Lista extends Fragment implements AdapterView.OnItemClickListener {
    private ArrayList<Cuenta> datos = new ArrayList<Cuenta>();
    private ListView lstListado;
    private CuentaListener listener;
    private Cliente cliente;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_lista, container, false);
    }
    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        lstListado = (ListView) getView().findViewById(R.id.LstListado);

        cliente= (Cliente) getActivity().getIntent().getSerializableExtra("cliente");

        for (Cuenta cuenta: cliente.getListaCuentas()){
            Log.i("cuentas", "\n" + cuenta.toString() + "\n");
            for(Movimiento mov : cuenta.getListaMovimientos()){
                Log.i("movimientos", "\n" + mov.toString() + "\n");
            }
        }

        for(Cuenta clien : cliente.getListaCuentas()){
            datos.add(clien);
        }

        lstListado.setAdapter(new AdaptadorCuenta(this, datos));
        lstListado.setOnItemClickListener(this);
    }

    public void setCuentaLister(CuentaListener cuentaListener) {
        this.listener = cuentaListener;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
        if (listener != null) {
            listener.onCuentaSeleccionada(
                    (Cuenta) lstListado.getAdapter().getItem(pos));
        }
    }
}