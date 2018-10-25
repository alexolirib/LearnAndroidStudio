package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TaskListActivity extends Activity {
    private EditText txtTarefa;
    private Button btnAdicionar;
    private ListView listTarefa;

    private SQLiteDatabase bd;
    private static final String NOME_BANCO =  "apptarefas";

    private ArrayAdapter<String> itensAdaptador;
    private ArrayList<String> itens;

    //apagar tarefa
    private ArrayList<Integer> ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
 
        try {
            //recuperar componentes
            txtTarefa = findViewById(R.id.txtListTarefa);
            btnAdicionar = findViewById(R.id.btnAdcionarListTarafa);
            listTarefa = findViewById(R.id.lvListTask);

            //Banco dados
            bd = openOrCreateDatabase(NOME_BANCO, MODE_PRIVATE, null);

            //tabela tarefa
            bd.execSQL("CREATE TABLE IF NOT EXISTS tarefas(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "tarefa VARCHAR(30))");

            btnAdicionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String textoDigitado = txtTarefa.getText().toString();
                    salvarTarefa(textoDigitado);
                    recuperarTarefas();
                    txtTarefa.setText("");
                }
            });

            listTarefa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    removerTarefa( ids.get(position));
                }
            });

            //Listar tarefas
            recuperarTarefas();

        } catch (Exception e){
            e.printStackTrace();
        }


    }
    private void salvarTarefa(String txt){
        try{
            if(txt.equals(""))
                Toast.makeText(TaskListActivity.this, "Digite uma tarefa", Toast.LENGTH_SHORT).show();
            else {
                bd.execSQL("insert into tarefas(tarefa) values('" + txt + "')");
                Toast.makeText(TaskListActivity.this, "Tarefa adicionado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private  void recuperarTarefas(){
        try{
            //recupera tarefas
            Cursor cursor = bd.rawQuery("select * from tarefas ORDER BY id DESC", null);
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");
            //criar adaptador

            itens = new ArrayList<String>();
            ids = new ArrayList<Integer>();
            itensAdaptador = new ArrayAdapter<String>(
                    getApplication(),
                    android.R.layout.simple_list_item_2,
                    android.R.id.text1,
                    itens);
            listTarefa.setAdapter(itensAdaptador);
            //listar as tarefas
            cursor.moveToFirst();
            while (cursor != null){

                Log.i("Resultado - ", "Tarefa: " + cursor.getString(indiceColunaTarefa));
                itens.add(cursor.getString(indiceColunaTarefa));
                ids.add( Integer.parseInt(cursor.getString(indiceColunaId)));
                cursor.moveToNext();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private  void  removerTarefa(Integer id){
        try{
            bd.execSQL("DELETE FROM tarefas where id="+ id);
            recuperarTarefas();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
