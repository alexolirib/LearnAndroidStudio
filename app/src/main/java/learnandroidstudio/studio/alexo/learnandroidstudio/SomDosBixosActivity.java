package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

//para poder clicar e não precisar espeficiar o exato
public class SomDosBixosActivity extends Activity implements View.OnClickListener{

    private ImageView imgDog;
    private ImageView imgCat;
    private ImageView imgLion;
    private ImageView imgMonkey;
    private ImageView imgCow;
    private ImageView imgSheep;
    private MediaPlayer somDosBixos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_som_dos_bixos);
        imgDog = findViewById(R.id.imgDogId);
        imgCat = findViewById(R.id.imgCatId);
        imgLion = findViewById(R.id.imgLionId);
        imgMonkey = findViewById(R.id.imgMonkeyId);
        imgCow = findViewById(R.id.imgCowId);
        imgSheep = findViewById(R.id.imgSheepId);

        imgDog.setOnClickListener(this);
        imgCat.setOnClickListener(this);
        imgLion.setOnClickListener(this);
        imgMonkey.setOnClickListener(this);
        imgCow.setOnClickListener(this);
        imgSheep.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //v é o id do botão que foi clicado
        int idClicado = v.getId();
        switch (idClicado){
            case R.id.imgDogId:
                somDosBixos = MediaPlayer.create(SomDosBixosActivity.this, R.raw.cao);
                tocarSom();
                break;
            case R.id.imgCatId:
                somDosBixos = MediaPlayer.create(SomDosBixosActivity.this,R.raw.gato);
                tocarSom();
                break;
            case R.id.imgLionId:
                somDosBixos = MediaPlayer.create(SomDosBixosActivity.this,R.raw.leao);
                tocarSom();
                break;
            case R.id.imgMonkeyId:
                somDosBixos = MediaPlayer.create(SomDosBixosActivity.this, R.raw.macaco);
                tocarSom();
                break;
            case R.id.imgCowId:
                somDosBixos = MediaPlayer.create(SomDosBixosActivity.this,R.raw.vaca);
                tocarSom();
                break;
            case R.id.imgSheepId:
                somDosBixos = MediaPlayer.create(SomDosBixosActivity.this,R.raw.ovelha);
                tocarSom();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        if(somDosBixos !=null){
            somDosBixos.release();
            somDosBixos=null;
        }
        super.onDestroy();
    }

    public void tocarSom(){
        if(somDosBixos != null){
            somDosBixos.start();
        }
    }
}
