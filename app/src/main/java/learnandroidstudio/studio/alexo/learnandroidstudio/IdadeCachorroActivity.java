package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IdadeCachorroActivity extends Activity {

    private EditText txtIdadeCachorro;
    private Button btnCalcularIdade;
    private TextView resultadoIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idadecachorro);

        txtIdadeCachorro = findViewById(R.id.txtIdadeCachorroId);
        btnCalcularIdade = findViewById(R.id.btnDescobrirIdadeId);
        resultadoIdade = findViewById(R.id.lblIdadeHumanoId);

        btnCalcularIdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //recuperar que foi digitado
                String idadeCachorro = txtIdadeCachorro.getText().toString();

                if(idadeCachorro.isEmpty()){
                    //string vazia(Erro)
                    resultadoIdade.setText("nenhuma texto digitado");
                }else{
                    int valorDigitado = Integer.parseInt(idadeCachorro);
                    resultadoIdade.setText("Idade do cachorro em anos humanos é: " + valorDigitado*7 + " anos" );
                    txtIdadeCachorro.setText("");
                }

            }
        });

    }
}
