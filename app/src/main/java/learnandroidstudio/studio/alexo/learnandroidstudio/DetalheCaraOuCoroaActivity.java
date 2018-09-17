package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        //receber o valor de outra activity
        Bundle extra = getIntent().getExtras();

        //validar o extra
    }


}
