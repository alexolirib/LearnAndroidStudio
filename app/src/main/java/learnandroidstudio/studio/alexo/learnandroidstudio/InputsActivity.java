package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InputsActivity extends Activity {

    private Button botaoDialog;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputs);

        botaoDialog = findViewById(R.id.btnDialog);
        botaoDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Criar alert dialog
                dialog = new AlertDialog.Builder(InputsActivity.this);

                //titulo
                dialog.setTitle("Titulo da dialog");

                //mensagem
                dialog.setMessage("Mensagem da dialog");

                //quando clicar fora da dialog não é cancelado
                dialog.setCancelable(false);

                dialog.setIcon(android.R.drawable.ic_delete);

                //botao negativo
                //setNegativeButton(mensagem, ação)
                dialog.setNegativeButton("Não",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),"pressiono não", Toast.LENGTH_SHORT).show();
                            }
                        });

                dialog.setPositiveButton("Sim",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "pressiono sim", Toast.LENGTH_SHORT).show();
                            }
                        });
                dialog.create();
                dialog.show();
            }
        });
    }
}
