package com.example.lenovo.torchapplication;

import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton tb;
    CameraManager cm;
    String cameraId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb=findViewById(R.id.toggleButton);

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) //class for compound buttons
            {
                /*if(isChecked==true)
                    Toast.makeText(MainActivity.this, "on", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "off", Toast.LENGTH_SHORT).show();
*/
                torch(isChecked);

            }
        });
    }

    public void torch(boolean mode)
    {
        try
        {
            cm= (CameraManager) getSystemService(CAMERA_SERVICE);
            cameraId=cm.getCameraIdList()[0]; //flash at 0 ,change api in gradle
            cm.setTorchMode(cameraId,mode);
        }
        catch(Exception e)
        { }
    }
}
