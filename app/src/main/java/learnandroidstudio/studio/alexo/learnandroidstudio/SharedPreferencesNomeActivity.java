package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPreferencesNomeActivity extends Activity {

    private EditText txtNomeShared;
    private Button btnSalvarShared;
    private TextView lblExibicao;

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_nome);

        txtNomeShared = findViewById(R.id.txtSharedId);
        btnSalvarShared = findViewById(R.id.btnSalvarSharedId);
        lblExibicao = findViewById(R.id.lblTextSharedId);

        btnSalvarShared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //modo = 0 - Privado só pode ser lido usando a aplicação
                //aqui é feito a estrutura para salvar o que for escrito até depois do else
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if (txtNomeShared.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Por favor, preencher o nome", Toast.LENGTH_SHORT).show();
                } else {
                    //primeiro parametro é a chave que estou salvando minha informações
                    editor.putString("nome", txtNomeShared.getText().toString());
                    editor.commit();
                    lblExibicao.setText("Olá, " + txtNomeShared.getText().toString());
                }
            }
        });

        //Recuperar os dados salvos
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if (sharedPreferences.contains("nome")) {
            // sharedPreferences.getString(coloca a chave, se não encontrado  é colocado auqi um valor default)
            String nomeUsuario = sharedPreferences.getString("nome", "usuário não definido");
            lblExibicao.setText("Olá, " + nomeUsuario);
        } else {
            lblExibicao.setText("Olá, usuário não definido.");
        }

    }
}
