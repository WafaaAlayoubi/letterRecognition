package me.grad.recognitiongradapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class ShowActivity extends AppCompatActivity {

    TextView showLetter;
    ImageView showPic;
    ImageView showBack;
    ImageView showSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Bundle extras = getIntent().getExtras();

        showLetter = (TextView) findViewById(R.id.showLetter);
        showPic = (ImageView) findViewById(R.id.showPic);
        showBack = (ImageView) findViewById(R.id.showBack);
        showSound = (ImageView) findViewById(R.id.showSound);

        ArrayList <String> english = new ArrayList<>(Arrays.asList("A", "B", "C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
        String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
        ArrayList <String> arabic = new ArrayList<>(Arrays.asList("أ", "ب","ت","ث","ج","ح","خ","د","ذ","ر","ز","س","ش","ص","ض","ط","ظ","ع","غ","ف","ق","ك","ل","م","ن","ه","و","ي"));

        String index = (extras.getString("letter"));
        showLetter.setText(index);
        String letter = index.toLowerCase(Locale.ROOT);
        if(extras.getString("Categ").equals("English")){
             letter += "i";
        }else{

            if(arabic.indexOf(letter) == 26)
                letter = "zz";
            else if (arabic.indexOf(letter) == 27)
                letter = "zzz";
            else{
                letter = english.get(arabic.indexOf(letter)).toLowerCase(Locale.ROOT);
            }
        }

        showBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        showPic.setImageResource(getImageId(this, letter));

        showSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sound = index.toLowerCase(Locale.ROOT);
                if(extras.getString("Categ").equals("English")){
                    sound += "s";
                }else{

                    if(arabic.indexOf(sound) == 26)
                        sound = "zz";
                    else if (arabic.indexOf(sound) == 27)
                        sound = "zzz";
                    else{
                        sound = english.get(arabic.indexOf(sound)).toLowerCase(Locale.ROOT);
                    }
                }

                MediaPlayer music = MediaPlayer.create(ShowActivity.this, getSoundId(ShowActivity.this,sound));
                music.start();
            }
        });

    }
    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }
    public static int getSoundId(Context context, String soundName) {
        return context.getResources().getIdentifier("raw/" + soundName, null, context.getPackageName());
    }
}