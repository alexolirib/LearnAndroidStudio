package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends Activity {


    private ListView listaItens;
    private String[] itens = {
            "Angra dos Reis", "Caldas Novas",
            "Campos do Jordão", "Costa do Sauípe",
            "Fortaleza", "Natal", "João Pessoa", "São Paulo",
            "Rio de Janeiro", "Curitiba", "Sobral", "Joazeiro do Norte",
            "Belém", "Tucuruí"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listaItens = findViewById(R.id.lvLugaresId);

        //temos que usar um adaptador do array para o listView exibir
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
               //primeiro context
               getApplicationContext(),
               //layout default
               android.R.layout.simple_list_item_1,
               //faz referencia do parametro anterior
                android.R.id.text1,
                itens
        );

        listaItens.setAdapter(adaptador);
        //poder clicar
        listaItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int index = position;
                String valorClicado = listaItens.getItemAtPosition(index).toString();
                Toast.makeText(getApplicationContext(), valorClicado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
