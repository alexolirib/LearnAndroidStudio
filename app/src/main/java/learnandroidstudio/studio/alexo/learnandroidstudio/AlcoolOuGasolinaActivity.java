package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AlcoolOuGasolinaActivity extends Activity {

    //preço gasolina ou alcool

   private EditText txtAlcool;
   private EditText txtGasolina;
   private Button btnVerificaPreco;
   private TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasolinaoualcool);

          //preço gasolina ou alcool
        txtAlcool = findViewById(R.id.txtPrecoAlcoolId);
        txtGasolina = findViewById(R.id.txtPrecoGasolinaId);
        btnVerificaPreco = findViewById(R.id.btnVerificaPrecoId);
        lblResultado = findViewById(R.id.lblResultadoPrecoId);

        btnVerificaPreco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoAlcool = txtAlcool.getText().toString();
                String textoGasolina = txtGasolina.getText().toString();

                Double valorAlcool = Double.parseDouble(textoAlcool);
                Double valorGasolina = Double.parseDouble(textoGasolina);

                //verifica alcool / gasolina
                double resultado = valorAlcool / valorGasolina;
                // + 0.7 gasolina
                if(resultado >= 0.7){
                    lblResultado.setText("É melhor usar gasolina");
                }else{
                    lblResultado.setText("É melhor usar Alcool");
                }

            }
        });
    }
}
