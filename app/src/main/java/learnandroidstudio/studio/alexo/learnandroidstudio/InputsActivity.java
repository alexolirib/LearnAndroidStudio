package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class InputsActivity extends Activity {

    private Button botaoDialog;
    private AlertDialog.Builder dialog;

    //checkbox
    private CheckBox cbCao;
    private CheckBox cbGato;
    private CheckBox cbPapagaio;

    private Button btnMostrar;
    private AlertDialog.Builder dialogMostrar;

    //seekBar
    private SeekBar seekBar;
    private TextView lblExibirSeekBar;

    //radiobutton
    private RadioGroup radioGroup;
    private RadioButton radioButtonEscolhido;
    private Button btnEscolhidoRb;
    private AlertDialog.Builder dialogRb;

    //toggleButton
    private ToggleButton toggleButton;
    private TextView lblToggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputs);

        //toggleButton
        toggleButton = findViewById(R.id.tgbButtonId);
        lblToggleButton = findViewById(R.id.lblToggleButtonId);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //isChecked se ta ligado ou não
                lblToggleButton.setText("");
                if(isChecked){
                    lblToggleButton.setText("Clicado");
                }
            }
        });

        //radiobutton
        radioGroup = findViewById(R.id.rgAnimais);
        btnEscolhidoRb = findViewById(R.id.btnMostraRb);

        btnEscolhidoRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();
                //verificar se for clicado
                if(idRadioButtonEscolhido > 0) {
                    dialogRb = new AlertDialog.Builder(InputsActivity.this);
                    dialogRb.setTitle("Animais");

                    radioButtonEscolhido = findViewById(idRadioButtonEscolhido);
                    dialogRb.setMessage(radioButtonEscolhido.getText());
                    dialogRb.create();
                    dialogRb.show();
                }

            }
        });

        //resto

        cbCao = findViewById(R.id.cbCao);
        cbGato = findViewById(R.id.cbGatoId);
        cbPapagaio = findViewById(R.id.cbPapagaioId);

        btnMostrar = findViewById(R.id.btnMostrarId);


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

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String itensSelecionados = "";
                itensSelecionados += "Item: " + cbCao.getText().toString()+" Status: " + cbCao.isChecked() + "\n";
                itensSelecionados += "Item: " + cbGato.getText().toString()+" Status: " + cbGato.isChecked() + "\n";
                itensSelecionados += "Item: " + cbPapagaio.getText().toString()+" Status: " + cbPapagaio.isChecked() + "\n";

                dialogMostrar = new AlertDialog.Builder(InputsActivity.this);
                dialogMostrar.setTitle("Animais");
                dialogMostrar.setMessage(itensSelecionados);
                dialogMostrar.setIcon(android.R.drawable.ic_input_add);


                dialogMostrar.create();
                dialogMostrar.show();
            }
        });
        //seekbar

        seekBar = findViewById(R.id.seekBarId);
        lblExibirSeekBar = findViewById(R.id.lblSeekBarId);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //cada vez que alterar o seekbar este método é chamado
                lblExibirSeekBar.setText("Progresso: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //pressiona seekbar
                Toast.makeText(getApplicationContext(), "Selecionou o seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //solta o seekbar
                Toast.makeText(getApplicationContext(),"Soltou o seekbar ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
