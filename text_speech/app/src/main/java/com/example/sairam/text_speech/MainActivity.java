package com.example.sairam.text_speech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    EditText e1;
    Button b1;
    TextToSpeech tts;
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts = new TextToSpeech(MainActivity.this, this);
        e1 = findViewById(R.id.edit);
        b1 = findViewById(R.id.speak);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             s1=e1.getText().toString();
             tts.speak(s1,TextToSpeech.QUEUE_ADD,null);
            }
        });
    }
    @Override
    public void onInit(int i) {
       tts.setLanguage(Locale.ENGLISH);
       tts.setSpeechRate(0.8f);
    }
}
