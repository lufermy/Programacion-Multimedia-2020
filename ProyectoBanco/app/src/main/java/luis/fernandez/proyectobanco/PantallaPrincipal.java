package luis.fernandez.proyectobanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import luis.fernandez.proyectobanco.pojo.Cliente;

public class PantallaPrincipal extends AppCompatActivity {

    TextView tvnombre;
    Cliente cliente;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
        Cliente cliente=(Cliente) getIntent().getSerializableExtra("cliente");
        tvnombre=(TextView) findViewById(R.id.tvnombre);
        tvnombre.setText("Bienvenido, "+cliente.getNombre());
    }
    /*
public void cambiarClave(View view){
    Intent intent = new Intent(PantallaPrincipal.this, CambiarClave.class);
    Cliente cliente=(Cliente) getIntent().getSerializableExtra("cuenta");
    intent.putExtra("cuenta",cliente);
    startActivity(intent);
}
public void transferir(View view){
    Intent intent = new Intent(PantallaPrincipal.this, Transferir.class);
    startActivity(intent);
}
 */
    public void opcion(View view){

        String botonTag=view.getTag().toString();

        switch (botonTag){
            case "posicionglobal":
                Intent intentposicion = new Intent(PantallaPrincipal.this, PosicionActivity.class);
                intentposicion.putExtra("cliente", cliente);
                startActivity(intentposicion);
                break;
            case "ingresos":
                break;
            case "transferencias":
                Intent initransf = new Intent(PantallaPrincipal.this, TransferenciasActivity.class);
                initransf.putExtra("cliente", cliente);
                startActivity(initransf);
                break;
            case "cambiarclave":
                Intent cambiarclave = new Intent(PantallaPrincipal.this, CambiarClave.class);
                cambiarclave.putExtra("cliente", cliente);
                startActivity(cambiarclave);
                break;
            case "promociones":
                /* PROCSIMAMENTE */
                break;
            case "cajeros":
                /* PROCSIMAMENTE */
                break;
        }
    }
}