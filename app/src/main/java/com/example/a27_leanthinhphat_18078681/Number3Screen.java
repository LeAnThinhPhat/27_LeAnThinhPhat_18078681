package com.example.a27_leanthinhphat_18078681;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Number3Screen extends AppCompatActivity {
    TextView tenBan;
    String mtenBan, tongTien;
    TextView tien1,tien2, tien3, tien4;
    Button btnTinhTien;
    Double a, b, c, d;
    private MyService myService;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {
            MyService.MyBinder binder = (MyService.MyBinder) iBinder;
            myService = binder.getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number3_screen);

        tenBan = findViewById(R.id.txtBan);
        tien1 = findViewById(R.id.txtGia1);
        tien2 = findViewById(R.id.txtGia2);
        tien3 = findViewById(R.id.txtGia3);
        tien4 = findViewById(R.id.txtGia4);
        btnTinhTien = findViewById(R.id.btn_tinhtien);

        mtenBan = (String) getIntent().getSerializableExtra("tenban");
        if(mtenBan != null){
            tenBan.setText(mtenBan);
        }
        Intent intent = new Intent(Number3Screen.this, MyService.class);
        bindService(intent, mConnection, BIND_AUTO_CREATE);
        btnTinhTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Number3Screen.this, Number3ScreenFinish.class);
                Bundle bundle = new Bundle();

                a = Double.parseDouble(tien1.getText().toString());
                b = Double.parseDouble(tien2.getText().toString());
                c = Double.parseDouble(tien3.getText().toString());
                d = Double.parseDouble(tien4.getText().toString());
                tongTien = myService.TinhTien(a,b,c,d)+"";


                bundle.putSerializable("tongtien",tongTien);
                intent1.putExtras(bundle);

                startActivity(intent1);
            }
        });
    }
}