package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

//    private Button btnJogar;
//    private TextView lblResult;

    //nova frase dia
    private TextView lblNovaFrase;
    private Button botaoNovaFrase;
    private String[] frases = {
            "Você pode, você é capaz",
            "Se você traçar metas absurdamente altas e falhar, seu fracasso será muito melhor que o sucesso de todos\" – James Cameron, cineasta",
            "O sucesso normalmente vem para quem está ocupado demais para procurar por ele",
            "A vida é melhor para aqueles que fazem o possível para ter o melhor",
            "Os empreendedores falham, em média, 3,8 vezes antes do sucesso final. O que separa os bem-sucedidos dos outros é a persistência"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
       // setContentView(R.layout.activity_adivinha);
        setContentView(R.layout.activity_frasedodia);

        //adivinha
//
//        btnJogar = findViewById(R.id.btnJogarId);
//        lblResult = findViewById(R.id.lblResultId);

//        lblResult.setText("troquei o valor");
       /* btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gerar numero randomico

                Random randomico = new Random();
                int numeroAleatorio = randomico.nextInt(10);
                lblResult.setText("Número escolhido: " + numeroAleatorio);
                //lblResult.setText("Texto alterado");
            }
        });*/

        //nova frase do dia
        lblNovaFrase = findViewById(R.id.textoNovaFraseId);
        botaoNovaFrase = findViewById(R.id.btnNovaFraseId);

        botaoNovaFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomico = new Random();
                int numAleatorio = randomico.nextInt(frases.length);
                lblNovaFrase.setText(frases[numAleatorio]);
            }
        });
    }
}
