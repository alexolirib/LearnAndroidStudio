package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SignosActivity extends Activity {

    private ListView listaSignos;

    private String[] signos = {
            "Áries", "Touro", "Gêmeos", "Cancer", "Leão", "Virgem",
            "Libra", "Escorpião", "Sagitário", "Capricónio", "Aquário",
            "Peixe"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signos);

        listaSignos = findViewById(R.id.lvSignosId);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                signos
        );

        listaSignos.setAdapter(adaptador);

        listaSignos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clicado = listaSignos.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),clicado,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
