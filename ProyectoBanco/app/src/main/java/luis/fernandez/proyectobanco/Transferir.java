package luis.fernandez.proyectobanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Transferir extends AppCompatActivity {


    GridView cuentasOrigen;
    RadioGroup grpOpciones;
    Spinner cuentasPropia;
    EditText cuentaAjena;
    CheckBox justificante;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferir);

        cuentasOrigen=(GridView) findViewById(R.id.grupoOperaciones);
        grpOpciones=(RadioGroup) findViewById(R.id.grpRadio);
        cuentasPropia = (Spinner) findViewById(R.id.grpSpinner);
        cuentaAjena = (EditText) findViewById(R.id.tvcuentaAjena);
        justificante = (CheckBox) findViewById(R.id.checkBoxJustificante);

        String[] datos = new String[4];
        datos[0]="E13579";
        datos[1]="E12345";
        datos[2]="E67890";
        datos[3]="E02468";

        final ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.elemento_lista, datos);
        grpOpciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged (RadioGroup group,int checkedId){

                if (grpOpciones.getCheckedRadioButtonId() == R.id.cuentaMia) {
                    cuentasPropia.setAdapter(adaptador);
                    cuentasPropia.setEnabled(true);
                    cuentaAjena.setEnabled(false);
                }
                else if (grpOpciones.getCheckedRadioButtonId() == R.id.cuentaAjena) {
                    cuentasPropia.setEnabled(false);
                    cuentaAjena.setEnabled(true);
                }
            }
        });

        cuentasOrigen.setAdapter(adaptador);

        cuentasOrigen.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent,
                                            android.view.View v, int position, long id) {
                        item= (String) parent.getItemAtPosition(position);
                    }
                });



    }

    public void pulsarOk(View view) {
        String sincon="";
        String cuentaString="";
        if (justificante.isChecked()){
            sincon="con";
        }else{
            sincon="sin";
        }

        if(cuentaAjena.isEnabled()){
            cuentaString=cuentaAjena.getText().toString();
        }
        else if (cuentasPropia.isEnabled()){
            cuentaString= cuentasPropia.getSelectedItem().toString();

        }
        Toast.makeText(getApplicationContext(),"Opción seleccionada: " + item + " a la cuenta: " + cuentaString +" "+ sincon + " justificante"  ,
                Toast.LENGTH_SHORT).show();
    }
    public void pulsarCancelar(View view){
        Intent intent = getIntent();
        finish();
        startActivity(intent);

    }

}
