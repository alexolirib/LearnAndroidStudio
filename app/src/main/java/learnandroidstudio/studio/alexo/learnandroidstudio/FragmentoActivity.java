package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentoActivity extends AppCompatActivity {

    private Button btnLogar;
    private boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmento);

        btnLogar = findViewById(R.id.fragmentoBtnLogarId);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();

                //deixa preparado para edição
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if(status) {
                    //fragmento que vou utilizar
                    LoginFragment loginFragment = new LoginFragment();

                    fragmentTransaction.add(R.id.fragmentoCLContainerFragmento, loginFragment);
                    fragmentTransaction.commit();
                    btnLogar.setText("Cadastre-se");
                    status = false;
                } else{
                    CadastroFragment cadastroFragment = new CadastroFragment();
                    fragmentTransaction.add(R.id.fragmentoCLContainerFragmento, cadastroFragment);
                    fragmentTransaction.commit();
                    btnLogar.setText("Logar");
                    status = true;
                }

            }
        });
    }
}
