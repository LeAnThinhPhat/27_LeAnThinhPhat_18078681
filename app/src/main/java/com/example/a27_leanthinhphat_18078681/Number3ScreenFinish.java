package com.example.a27_leanthinhphat_18078681;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Number3ScreenFinish extends AppCompatActivity {
    TextView tongTien;
    String tien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number3_screen_finish);

        tongTien = findViewById(R.id.txtTongTien);
        tien = (String) getIntent().getSerializableExtra("tongtien");
        if(tien != null){
            tongTien.setText(tien);
        }
    }
}