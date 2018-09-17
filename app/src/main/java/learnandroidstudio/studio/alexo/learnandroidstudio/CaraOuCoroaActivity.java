package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class CaraOuCoroaActivity extends AppCompatActivity {

    private ImageView btnJogar;
    private String[] opcao = {"cara", "coroa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cara_ou_coroa);

        btnJogar = findViewById(R.id.imgJogarCaraOuCoroaId);

        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomico = new Random();
                // 0 -  cara ou 1 - coroa
                int numAleatorio = randomico.nextInt(2);

                Intent intent = new Intent(CaraOuCoroaActivity.this, DetalheCaraOuCoroaActivity.class);
                //aqui será para passar valor para outra activity
                //.putExtra(identifica , valor passassado)
                intent.putExtra("opcao", opcao[numAleatorio]);

                startActivity(intent);
            }
        });
    }
}
