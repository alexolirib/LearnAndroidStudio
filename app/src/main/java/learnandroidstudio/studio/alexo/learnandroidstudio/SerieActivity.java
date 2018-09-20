package learnandroidstudio.studio.alexo.learnandroidstudio;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class SerieActivity extends Activity {

    private SeekBar sbProgress;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie);

        sbProgress = findViewById(R.id.sbProgressSerieId);
        image = findViewById(R.id.imgEmoticonId);

        sbProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress == 0){
                    image.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.pouco));
                } else if(progress == 1){
                    image.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.medio));
                } else if(progress == 2){
                    image.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.muito));
                } else {
                    image.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.susto));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
