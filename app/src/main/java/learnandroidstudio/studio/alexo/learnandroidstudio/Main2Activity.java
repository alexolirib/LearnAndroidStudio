package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends Activity implements View.OnClickListener {

    private Button btnAbrirInputs;
    private Button btnAbrirSomAnimal;
    private Button btnAbrirSharedPreference;
    private Button btnAbrirCorEscolhida;
    private Button btnAbrirAnotacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnAbrirInputs = findViewById(R.id.btnAbrirInputId);
        btnAbrirSomAnimal = findViewById(R.id.btnAbrirSomAnimalId);
        btnAbrirSharedPreference = findViewById(R.id.btnAbrirSharedPreferenceId);
        btnAbrirCorEscolhida = findViewById(R.id.btnAbrirCorEscolhidaId);
        btnAbrirAnotacoes = findViewById(R.id.btnAbrirAnotacoesId);

        btnAbrirInputs.setOnClickListener(this);
        btnAbrirSomAnimal.setOnClickListener(this);
        btnAbrirSharedPreference.setOnClickListener(this);
        btnAbrirCorEscolhida.setOnClickListener(this);
        btnAbrirAnotacoes.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnAbrirInputId:
                startActivity(new Intent(Main2Activity.this, InputsActivity.class));
                break;
            case R.id.btnAbrirSomAnimalId:
                startActivity(new Intent(Main2Activity.this, SomDosBixosActivity.class));
                break;
            case R.id.btnAbrirSharedPreferenceId:
                startActivity(new Intent(Main2Activity.this, SharedPreferencesNomeActivity.class));
                break;
            case R.id.btnAbrirCorEscolhidaId:
                startActivity(new Intent(Main2Activity.this, PreferenciasCorUsuarioActivity.class));
                break;
            case R.id.btnAbrirAnotacoesId:
                startActivity(new Intent(Main2Activity.this, MinhaAnotacaoActivity.class));
                break;


        }
    }
}
