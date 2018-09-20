package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends Activity {

    private Button btnAbrirInputs;
    private Button btnAbrirSomAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnAbrirInputs = findViewById(R.id.btnAbrirInputId);
        btnAbrirSomAnimal = findViewById(R.id.btnAbrirSomAnimalId);

        btnAbrirInputs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, InputsActivity.class));
            }
        });

        btnAbrirSomAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, SomDosBixosActivity.class));
            }
        });
    }
}
