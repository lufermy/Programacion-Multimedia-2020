package luis.fernandez.aplicacion24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnAlerta;
    private Button btnConfirmacion;
    private Button btnSeleccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlerta = (Button) findViewById(R.id.btnAlerta);
        btnAlerta.setOnClickListener(this);
        btnConfirmacion = (Button)findViewById(R.id.btnConfirmacion);
        btnConfirmacion.setOnClickListener(this);
        btnSeleccion = (Button) findViewById(R.id.btnSeleccion);
        btnSeleccion.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch(view.getId()) {
            case R.id.btnAlerta:
                DialogoAlerta dialogoAlerta = new DialogoAlerta();
                dialogoAlerta.show((fragmentManager), "tagAlerta");
                break;
            case R.id.btnConfirmacion:
                DialogoConfirmacion dialogoConfirmacion = new DialogoConfirmacion();
                dialogoConfirmacion.show((fragmentManager), "tagConfirmacion");
                break;
            case R.id.btnSeleccion:
                DialogoSeleccion dialogoSeleccion =new DialogoSeleccion();
                dialogoSeleccion.show(fragmentManager,"tagSeleccion");
                break;

        }
    }
}
