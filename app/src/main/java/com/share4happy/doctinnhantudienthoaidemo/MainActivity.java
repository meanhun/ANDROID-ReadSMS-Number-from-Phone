package com.share4happy.doctinnhantudienthoaidemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CONTACTS_ASK_PERMISSIONS = 1001;
    private static final int REQUEST_SMS_ASK_PERMISSIONS = 1002;
    Button btnDanhBa,btnTinNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();

    }
    private void addEvents() {
        btnDanhBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyMoManHinhDanhBa();
            }
        });
        btnTinNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyMoManHinhTinNhan();
            }
        });
    }

    private void xuLyMoManHinhTinNhan() {
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{"" +
                    "android.permission.READ_SMS"}, REQUEST_SMS_ASK_PERMISSIONS);

        }else   {
            Intent intent = new Intent(MainActivity.this,DocTinNhanActivity.class);
            intent.setClassName("com.share4happy.doctinnhantudienthoaidemo",
                    "com.share4happy.doctinnhantudienthoaidemo.DocTinNhanActivity");
            startActivity(intent);
        }
    }

    private void xuLyMoManHinhDanhBa() {

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_CONTACTS"},
                    REQUEST_SMS_ASK_PERMISSIONS);

        }else   {
            Intent intent = new Intent(MainActivity.this,DanhBaActivity.class);
            intent.setClassName("com.share4happy.doctinnhantudienthoaidemo",
                    "com.share4happy.doctinnhantudienthoaidemo.DanhBaActivity");
            startActivity(intent);
        }

    }

    private void addControls() {
        btnDanhBa = (Button) findViewById(R.id.btnDocDanhBa);
        btnTinNhan = (Button) findViewById(R.id.btnDocTinNhan);
    }
}