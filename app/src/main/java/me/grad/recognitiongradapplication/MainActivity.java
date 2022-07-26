package me.grad.recognitiongradapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    ImageView arabicBtn;
    ImageView englishBtn;
    ImageView numbersBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        arabicBtn = (ImageView) findViewById(R.id.arabic_lang);
        englishBtn = (ImageView) findViewById(R.id.english_lang);
        numbersBtn = (ImageView) findViewById(R.id.numbers);

        englishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChooseActivity.class);
                intent.putExtra("Categ","English");
                startActivity(intent);
            }
        });
        arabicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChooseActivity.class);
                intent.putExtra("Categ","Arabic");
                startActivity(intent);
            }
        });
        numbersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChooseActivity.class);
                intent.putExtra("Categ","Numbers");
                startActivity(intent);
            }
        });

    }

}
