package com.example.sairam.speechtotext;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private TextView txtSpeechInput;
    private ImageButton btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT =100;
    Button search;
    String s1;
    ProgressDialog pd;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts=new TextToSpeech(MainActivity.this,this);
        search=(Button) findViewById(R.id.search);
        pd=new ProgressDialog(MainActivity.this);
        txtSpeechInput=(EditText)findViewById(R.id.txtSpeechInput);
        pd.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pd.cancel();
                if(s1.contentEquals(cs. "camera")) {
                    Intent i=new Intent("android.media.action.IMAGE_CAPTURE");
                    startActivity(i);
                    }else if(s1.contentEquals(cs:"call") || s1.contentEquals(cs."call")){
                    Intent i =new Intent(Intent.ACTION_DIAL);
                    startActivity(i);
            } else if(s1.contentEquals(cs:"gallery")|| s1.contentEquals
                Intent intent=new Intent();

                intent=new Intent(Intent.ACTION_VIEW,Uri.parse("content://media/internal/images/media"));
                startActivity(intent);
            }else if(s1.contentEquals(cs: "google")||s1.contentEquals(cs:"")


                tts.speak("Here There is no Data thank you".TextToSpeech.QUEUE_ADD, null);
            }
            }
        }, 2000);


    }
     break;

}

             }
             }
             }