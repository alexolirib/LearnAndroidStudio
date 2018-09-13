package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnJogar;
    private TextView lblResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_adivinha);

        btnJogar = findViewById(R.id.btnJogarId);
        lblResult = findViewById(R.id.lblResultId);

        lblResult.setText("troquei o valor");
    }
}
