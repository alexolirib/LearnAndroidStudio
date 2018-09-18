package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DetalheCaraOuCoroaActivity extends AppCompatActivity {

    private ImageView imagem;
    private ImageView btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cara_ou_coroa);

        imagem = findViewById(R.id.imgModeadaId);
        btnVoltar = findViewById(R.id.imgVoltarCaraOuCoroa);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetalheCaraOuCoroaActivity.this, CaraOuCoroaActivity.class));
            }
        });

        //receber o valor de outra activity
        Bundle extra = getIntent().getExtras();

        //validar o extra
        if(extra != null){
            String opcaoEscolhida = extra.getString("opcao");

            if(opcaoEscolhida.equals("cara")){
                imagem.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.moeda_cara));
            } else{
                imagem.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.moeda_coroa));
            }
        }
    }


}
