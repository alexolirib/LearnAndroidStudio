package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AtmEmpresaConsultoriaActivity extends Activity {

    private ImageView btnEmpresa;
    private ImageView btnServico;
    private ImageView btnContato;
    private ImageView btnCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atm_empresa_consultoria);

        btnEmpresa = findViewById(R.id.imgAtmEmpresaId);
        btnServico = findViewById(R.id.imgAtmServicosId);
        btnContato = findViewById(R.id.imgAtmContatoId);
        btnCliente = findViewById(R.id.imgAtmClientesId);

        btnEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AtmEmpresaConsultoriaActivity.this, EmpresaActivity.class));
            }
        });

        btnServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AtmEmpresaConsultoriaActivity.this, ServicoActivity.class ));
            }
        });

        btnContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AtmEmpresaConsultoriaActivity.this, ContatoActivity.class ));
            }
        });

        btnCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AtmEmpresaConsultoriaActivity.this, ClienteActivity.class ));
            }
        });
    }
}
