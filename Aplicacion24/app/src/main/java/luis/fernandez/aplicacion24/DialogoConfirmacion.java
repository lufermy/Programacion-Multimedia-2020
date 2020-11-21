package luis.fernandez.aplicacion24;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoConfirmacion extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Confirmas?")
                .setTitle("Confirmamelo")
                .setPositiveButton("Confirmo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("Dialogos","Accion aceptada");
                        dialogInterface.cancel();
                    }
                })
                .setNegativeButton("No confirmo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("Dialogos","Accion aceptada");
                        dialogInterface.cancel();
                    }
        });

        return builder.create();

    }
}
