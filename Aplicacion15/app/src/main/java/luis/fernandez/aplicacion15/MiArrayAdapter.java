package luis.fernandez.aplicacion15;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class MiArrayAdapter<T> extends ArrayAdapter<T> {

    public MiArrayAdapter(@NonNull Context context, List<T> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Obtenindo una instancia del inflador
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Guardar la referencia del view de la fila
        View listItemView = convertView;

        //Comprobando view existe
        if(convertView == null){
            //Si no existe, lo inflamos
            listItemView=inflater.inflate(android.R.layout.two_line_list_item, parent, false);

        }

        TextView titulo = (TextView) listItemView.findViewById(android.R.id.text1);
        TextView subtitulo = (TextView) listItemView.findViewById(android.R.id.text2);

        T item = (T)getItem(position);

        String cadenaBruta;
        String subCadenas [];
        String delimitador = ",";
        cadenaBruta = item.toString();
        subCadenas = cadenaBruta.split(delimitador,2);
        titulo.setText(subCadenas[0]);
        subtitulo.setText(subCadenas[1]);
        return listItemView;
    }
}
