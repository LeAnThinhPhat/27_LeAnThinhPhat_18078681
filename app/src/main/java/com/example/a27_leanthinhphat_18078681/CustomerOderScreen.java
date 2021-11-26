package com.example.a27_leanthinhphat_18078681;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomerOderScreen extends AppCompatActivity {
    TextView tenBan;
    String mtenBan;
    Button xemBill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_oder_screen);

        tenBan = findViewById(R.id.txtBan);
        xemBill = findViewById(R.id.btn_tinhtien);

        mtenBan = (String) getIntent().getSerializableExtra("object_song");
        if(mtenBan != null){
            tenBan.setText(mtenBan);
        }

        xemBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerOderScreen.this, Number3Screen.class);

                startActivity(intent);
            }
        });
    }
}