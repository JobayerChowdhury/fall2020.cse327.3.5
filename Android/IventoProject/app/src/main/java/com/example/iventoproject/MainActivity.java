package com.example.iventoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button dolnaBtn,fviBtn,fviiBtn,fviiiBtn,fvivBtn,hexBtn,lightBtn,outfvBtn,stagehexBtn,stageiiBtn,stageVipBtn,tabChairBtn,vaseBtn,vase2Btn,vipdinnerBtn,pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stageVipBtn = findViewById(R.id.ar1);
       // stageiiBtn = findViewById(R.id.ar2);
        stagehexBtn = findViewById(R.id.ar3);
        vipdinnerBtn = findViewById(R.id.ar4);
        dolnaBtn = findViewById(R.id.ar5);
        tabChairBtn = findViewById(R.id.ar6);
        outfvBtn = findViewById(R.id.ar7);
        fviiiBtn = findViewById(R.id.ar8);
        fviBtn = findViewById(R.id.ar9);
        fvivBtn = findViewById(R.id.ar10);
        fviiBtn = findViewById(R.id.ar11);
        vase2Btn = findViewById(R.id.ar12);
        vaseBtn = findViewById(R.id.ar13);
        //lightBtn = findViewById(R.id.ar14);
        hexBtn = findViewById(R.id.ar15);
        pro = findViewById(R.id.pro);



       dolnaBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getApplicationContext (), MainActivity2.class));

            }

        });

        stageVipBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getApplicationContext (), Stage.class));

            }

        });
       /* stageiiBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getApplicationContext (), Stage2.class));

            }

        });*/
        stagehexBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getApplicationContext (), StageHex.class));

            }

        });
        vipdinnerBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getApplicationContext (), Stagedin.class));

            }

        });

        tabChairBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getApplicationContext (), TabChair.class));

            }

        });
        outfvBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getApplicationContext (), OutFv.class));

            }

        });
        fviiiBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getApplicationContext (), fv3.class));

            }

        });
        fviBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getApplicationContext (), fv1.class));

            }

        });
        fvivBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getApplicationContext (), fv4.class));

            }

        });

        fviiBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getApplicationContext (), fv2.class));

            }

        });
        vase2Btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getApplicationContext (), Vase2.class));

            }

        });
        vaseBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getApplicationContext (), Vase.class));

            }

        });
      /*  lightBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getApplicationContext (), Light.class));

            }

        });*/
        hexBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getApplicationContext (), Hex.class));

            }

        });
        pro.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getApplicationContext (), Profile.class));

            }

        });



    }






}