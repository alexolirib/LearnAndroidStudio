package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button btnAbrirGasolinaOuAlcool;
    private Button btnAbrirCachorro;
    private Button btnAbrirFraseDoDia;
    private Button btnAbrirAdivinha;
    private Button btnAbrirAtmConsultoria;
    private Button btnAbrirCaraOuCoroa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //makeText(contexto(onde será exibido), mensagem, duração)
        Toast.makeText(getApplicationContext(), "onCreate metodo chamado", Toast.LENGTH_SHORT).show();

        btnAbrirGasolinaOuAlcool = findViewById(R.id.btnAbrirAlcoolId);
        btnAbrirCachorro = findViewById(R.id.btnAbrirCachorroId);
        btnAbrirFraseDoDia = findViewById(R.id.btnAbrirFraseId);
        btnAbrirAdivinha = findViewById(R.id.btnAbrirAdivinha);
        btnAbrirAtmConsultoria = findViewById(R.id.btnAbrirAtmConsultoriaId);
        btnAbrirCaraOuCoroa  = findViewById(R.id.btnAbrirCaraOuCoroaId);

        btnAbrirGasolinaOuAlcool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //serve ir para um Activity para outro(primeiro de onde vou e o outro onde quero ir)
                startActivity(new Intent(MainActivity.this, AlcoolOuGasolinaActivity.class));
            }
        });

        btnAbrirCachorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, IdadeCachorroActivity.class));
            }
        });

        btnAbrirFraseDoDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FrasesDoDiaActivity.class));
            }
        });

        btnAbrirAdivinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdivinhaNumActivity.class));
            }
        });

        btnAbrirAtmConsultoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AtmEmpresaConsultoriaActivity.class));
            }
        });

        btnAbrirCaraOuCoroa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CaraOuCoroaActivity.class));
            }
        });


    }

    /*@Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart metodo chamado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart metodo chamado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume metodo chamado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause metodo chamado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy metodo chamado", Toast.LENGTH_SHORT).show();
    }*/
}
