package luis.fernandez.proyectobanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import luis.fernandez.proyectobanco.bd.MiBancoOperacional;
import luis.fernandez.proyectobanco.pojo.Cliente;
import luis.fernandez.proyectobanco.pojo.Cuenta;
import luis.fernandez.proyectobanco.pojo.Movimiento;

public class  Login extends AppCompatActivity {

    EditText nombre,contrasena;
    MiBancoOperacional mbo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        contrasena=(EditText)findViewById(R.id.loginContrasena);
        nombre=(EditText)findViewById(R.id.loginNombre);


    }

    public void acceder(View view){

        if(nombre.getText().toString().trim().equalsIgnoreCase("") && contrasena.getText().toString().trim().equalsIgnoreCase("") ){
            String msg = "Error, ambos campos estan vacios";
            Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
        }
        else if(contrasena.getText().toString().trim().equalsIgnoreCase("")){
            String msg = "Introduce una contraseña";
            Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
        }
        else if(nombre.getText().toString().trim().equalsIgnoreCase("")){
            String msg = "Introduce un nombre";
            Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
        }
        else {

            mbo = MiBancoOperacional.getInstance(this);

            Cliente a = new Cliente();
            a.setNif(nombre.getText().toString());
            a.setClaveSeguridad(contrasena.getText().toString());

            // logueamos al cliente
            a = mbo.login(a);

            if (a==null){
                String msg = "Esta cuenta no existe";
                Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
            }
            else{

                ArrayList<Cuenta> listaCuentas = mbo.getCuentas(a);


                a.setListaCuentas(listaCuentas);

                for(int i=0;i<a.getListaCuentas().size();i++){
                    ArrayList<Movimiento> listaMovimientos = mbo.getMovimientos(listaCuentas.get(i));
                    a.getListaCuentas().get(i).setListaMovimientos(listaMovimientos);

                }

                Intent intent = new Intent(Login.this, PantallaPrincipal.class);
                intent.putExtra("cliente", a);
                startActivity(intent);
            }

        }

    }
}