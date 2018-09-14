package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnJogar;
    private TextView lblResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_adivinha);

        btnJogar = findViewById(R.id.btnJogarId);
        lblResult = findViewById(R.id.lblResultId);

//        lblResult.setText("troquei o valor");
        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gerar numero randomico

                Random randomico = new Random();
                int numeroAleatorio = randomico.nextInt(10);
                lblResult.setText("Número escolhido: " + numeroAleatorio);
                //lblResult.setText("Texto alterado");
            }
        });
    }
}
