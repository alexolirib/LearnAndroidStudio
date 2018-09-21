package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MinhaAnotacaoActivity extends Activity {

    private EditText txtAnotacao;
    private ImageView btnSalvar;
    private static final String NOME_ARQUIVO = "anotacao.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minha_anotacao);

        txtAnotacao = findViewById(R.id.txtAnotacaoId);
        btnSalvar = findViewById(R.id.btnSalvarAnotacaoId);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoDigitado = txtAnotacao.getText().toString();
                gravarNoPhone(textoDigitado);
                Toast.makeText(getApplicationContext(), "Anotação salva com sucesso", Toast.LENGTH_SHORT).show();
            }
        });

        //recuperar que foi gravado
        if(lerArquivo() != null){
            txtAnotacao.setText(lerArquivo());
        }
    }

    private void gravarNoPhone(String txt){
        try{
            //openFileOutput("anotacao.txt" ,Context.MODE_PRIVATE = só minha aplicacao poderá ler)
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput( NOME_ARQUIVO,Context.MODE_PRIVATE));
            outputStreamWriter.write(txt);
            outputStreamWriter.close();
        }catch (IOException e){
            //Log.v("de onde está vindo", obter o erro);
            Log.v("MinhaAnotacaoActivity", e.toString());
        }
    }

    private String lerArquivo(){
        String resultado = "";

        try{
            //ABRE ARQUIVO
            InputStream arquivo = openFileInput(NOME_ARQUIVO);

            if(arquivo != null){

                //ler arquivo
                InputStreamReader inputStreamReader = new InputStreamReader(arquivo);

                //gerar buffer do arquivo
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                //REcuperar textos do arquivo
                //ler linha a linha e asism recupera - bufferedReader.readLine()
                //irá armazenadar cada linha do arquivo
                String linhaArquivo="";
                while((linhaArquivo = bufferedReader.readLine()) != null){
                    resultado += linhaArquivo;
                }
            }
            arquivo.close();
        }catch (IOException e){
            Log.v("MinhaAnotacaoActivity", e.toString());

        }
        return resultado;
    }
}
