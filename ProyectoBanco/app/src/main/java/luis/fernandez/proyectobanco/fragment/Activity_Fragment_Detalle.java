package luis.fernandez.proyectobanco.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import luis.fernandez.proyectobanco.R;
import luis.fernandez.proyectobanco.pojo.Cuenta;

public class Activity_Fragment_Detalle extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_detalle, container, false);
    }

    public void mostrarDetalles(final Cuenta a){
        ListView txtDetalles = getView().findViewById(R.id.TxtDetalle);

        ArrayList<String> movimientos_descipcion = new ArrayList<>();

        for (int i=0; i<a.getListaMovimientos().size();i++){
            movimientos_descipcion.add(a.getListaMovimientos().get(i).getDescripcion());
        }

        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(this.getContext(), R.layout.elemento_textview, movimientos_descipcion);

        txtDetalles.setAdapter(arrayAdapter);


    }
}
