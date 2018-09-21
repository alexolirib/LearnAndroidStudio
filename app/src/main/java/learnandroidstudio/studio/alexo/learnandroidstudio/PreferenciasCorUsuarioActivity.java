package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class PreferenciasCorUsuarioActivity extends Activity {

    private RadioGroup rgCores;
    private RadioButton rbSelecionado;
    private Button btnSalvar;
    private ConstraintLayout layout;
    private static final String ARQUIVO_PREFERENCIA = "ArqPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias_cor_usuario);

        rgCores = findViewById(R.id.rgCoresId);
        btnSalvar = findViewById(R.id.btnSalvarCorId);
        layout = findViewById(R.id.layoutAppCorId);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idRadioButtonEscolhido = rgCores.getCheckedRadioButtonId();


                if (idRadioButtonEscolhido > 0) {
                    rbSelecionado = findViewById(idRadioButtonEscolhido);

                    SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    //estamos ativando a edição
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    String corEscolhida = rbSelecionado.getText().toString();
                    editor.putString("corEscolhida", corEscolhida);
                    editor.commit();

                    setBackground(corEscolhida);
                }
            }
        });

        //recuperar cor salva
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if (sharedPreferences.contains("corEscolhida")) {
            String corRecuperada = sharedPreferences.getString("corEscolhida", "Laranja");
            setBackground(corRecuperada);
        }
    }

    private void setBackground(String cor){
        if(cor.equals("Azul")){
            layout.setBackgroundColor(Color.parseColor("#495b7c"));
        }else if(cor.equals("Laranja")){
            layout.setBackgroundColor(Color.parseColor("#ffce26"));

        }else if(cor.equals("Verde")){
            layout.setBackgroundColor(Color.parseColor("#009670"));

        }
    }
}
