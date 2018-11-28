package com.example.reproductorinteligenteacelerometro;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
SensorManager sensorManager;
MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);

        sensorManager.registerListener((SensorEventListener) this,sensorManager.getDefaultSensor
                (Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);

        mediaPlayer=MediaPlayer.create(this,R.raw.cancion);



    }

    @Override
    public void onSensorChanged(SensorEvent event) {


        //values[0]: Acceleration minus Gx on the x-axis
        //values[1]: Acceleration minus Gy on the y-axis
        //values[2]: Acceleration minus Gz on the z-axis

        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER) {
            if (event.values[2] < 0) {
                mediaPlayer.start();
            } else {
                mediaPlayer.pause();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
