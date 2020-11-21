package luis.fernandez.proyectobanco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import luis.fernandez.proyectobanco.pojo.Cliente;

public class CambiarClave extends AppCompatActivity {
    String value;
    TextView tvnombre,tvusuario,etviejacontra,etnuevacontra,etnuevacontraVER;
    Cliente cliente;
    String msgcontrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_clave);
        tvnombre=(TextView) findViewById(R.id.tvNombre);
        tvusuario=(TextView) findViewById(R.id.tvUsuario);
        cliente=(Cliente) getIntent().getSerializableExtra("cliente");
        tvnombre.setText(cliente.getNombre());
        tvusuario.setText(cliente.getNif());
    }

    public void cambiarlaContrasena(View view){
        etnuevacontra=(TextView) findViewById(R.id.etnuevacontra);
        etnuevacontraVER=(TextView) findViewById(R.id.etnuevacontraVER);
        etviejacontra=(TextView) findViewById(R.id.etviejacontra);

        //Verifica que la primera contraseña antigua sea la correcta
        if(cliente.getClaveSeguridad().equals(etviejacontra.getText().toString())){
        //Verifica que las dos contraseñas coincidan, entonces procede
            if(etnuevacontra.getText().toString().equals(etnuevacontraVER.getText().toString())){
                if(!etnuevacontra.getText().toString().equals(etviejacontra.getText().toString())){
                    cliente.setClaveSeguridad(etnuevacontra.getText().toString());
                    String msgcontrasena = "Contraseña cambiada correctamente";
                    Toast.makeText(this,msgcontrasena, Toast.LENGTH_LONG).show();
                }else{
                    String msgcontrasena = "La nueva contraseña no puede ser la misma que la anterior!";
                    Toast.makeText(this,msgcontrasena, Toast.LENGTH_LONG).show();
                }

            }else{
                String msgcontrasena = "Las contraseñas no coinciden";
                Toast.makeText(this,msgcontrasena, Toast.LENGTH_LONG).show();
            }
        }else{
            String msgcontrasena = "Contraseña actual incorrecta";
            Toast.makeText(this,msgcontrasena, Toast.LENGTH_LONG).show();
        }
    }
}