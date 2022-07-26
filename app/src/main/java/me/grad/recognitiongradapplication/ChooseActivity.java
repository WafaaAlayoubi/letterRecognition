package me.grad.recognitiongradapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ChooseActivity extends AppCompatActivity {

    ImageView lettersBtn;
    ImageView wordsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Bundle extras = getIntent().getExtras();

        lettersBtn = (ImageView) findViewById(R.id.letters);
        wordsBtn = (ImageView) findViewById(R.id.words);
        String ext = extras.getString("Categ");
        if(ext.equals("Numbers")){
            lettersBtn.setImageResource(R.drawable.learnadd);
            wordsBtn.setImageResource(R.drawable.learnsub);
            lettersBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ChooseActivity.this, RecognitionActivity.class);
                    intent.putExtra("Categ","add");
                    startActivity(intent);
                }
            });
            wordsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ChooseActivity.this, RecognitionActivity.class);
                    intent.putExtra("Categ", "sub");
                    startActivity(intent);
                }
            });
        }else {
            lettersBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ChooseActivity.this, GridActivity.class);
                    intent.putExtra("Categ", extras.getString("Categ"));
                    startActivity(intent);
                }
            });
            wordsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ChooseActivity.this, RecognitionActivity.class);
                    intent.putExtra("Categ", extras.getString("Categ"));
                    startActivity(intent);
                }
            });
        }
    }
}