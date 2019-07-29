package com.example.proximate_sensor;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Second extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor proximitySensor;
    SensorEventListener proximitySensorListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (proximitySensor == null) {
            Toast.makeText(this, "proximity sensor not available", Toast.LENGTH_SHORT).show();
            finish();//close app
        }
        proximitySensorListener=new SensorEventListener() { @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            if(sensorEvent.values[0]<proximitySensor.getMaximumRange()) {
                Intent i = new Intent(MainActivity.this, Second.class);
                startActivity(i);
                Toast.makeText(MainActivity.this, "this is my second page", Toast.LENGTH_SHORT).show();
                getWindow().getDecorView().setBackgroundColor(Color.RED);
            }
            else{

    }

