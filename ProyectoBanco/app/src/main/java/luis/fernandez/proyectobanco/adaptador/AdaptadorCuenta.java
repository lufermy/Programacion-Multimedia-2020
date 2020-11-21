package luis.fernandez.proyectobanco.adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import luis.fernandez.proyectobanco.R;
import luis.fernandez.proyectobanco.pojo.Cuenta;

public class AdaptadorCuenta extends ArrayAdapter<Cuenta> {
    Activity context;
    ArrayList<Cuenta> datos;

    public AdaptadorCuenta(Fragment context, ArrayList<Cuenta> datos) {
        super(context.getActivity(), R.layout.elemento_lista, datos);
        this.context = context.getActivity();
        this.datos = datos;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.elemento_lista, null);
        TextView lblDe = (TextView) item.findViewById(R.id.tv_lista);
        lblDe.setText(datos.get(position).getNumeroCuenta());
        return (item);
    }
}