package com.androidapp.getsensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

        TextView mTxtSensors;
        SensorManager sensorMgr;
        List<Sensor> sensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtSensors = findViewById(R.id.txtSensors);
        sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensorList = sensorMgr.getSensorList(Sensor.TYPE_ALL);
        mTxtSensors.append("(# Sensors: " + sensorList.size() + ")\n\n");   //센서가 하나만 나오는게 아니고 계속 나오는거기 때문에 append씀

        for(Sensor sensor : sensorList){
            mTxtSensors.append("Sensor name: " + sensor.getName()+ "\n");
            mTxtSensors.append("Sensor type: " + sensor.getType()+ "\n\n");
        }
        // 단순 정보만 조사하므로 onCreate에서 모든 작업 감당
    }
}