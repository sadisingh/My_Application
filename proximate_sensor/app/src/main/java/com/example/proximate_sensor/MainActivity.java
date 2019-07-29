package com.example.proximate_sensor;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    SensorManager sensorManager;
    Sensor proximitySensor;
    SensorEventListener proximitySensorListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (proximitySensor == null) {
            Toast.makeText(this, "proximity sensor not available", Toast.LENGTH_SHORT).show();
            finish();//close app
        }
        proximitySensorListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.values[0]<proximitySensor.getMaximumRange()) {
                    Intent i = new Intent(MainActivity.this, Second.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this, "this is my second page", Toast.LENGTH_SHORT).show();
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                }
                else
                {
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);

                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

    }



    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(proximitySensorListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(proximitySensorListener,proximitySensor,2*1000*1000);
    }
}


//create Listener




