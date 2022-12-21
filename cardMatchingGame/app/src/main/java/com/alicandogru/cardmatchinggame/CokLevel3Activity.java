package com.alicandogru.cardmatchinggame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class CokLevel3Activity extends AppCompatActivity {

    long kalansure;
    double sonSkor=0.0,etki,sonSkor2=0.0;
    String puan1,puan2,puan3,puan4,puan5,puan6,puan7,puan8,puan9,puan0,puan01,puan02,puan03,puan04,puan05,puan06,puan07,puan08;
    double puan11,puan22,puan33,puan44,puan55,puan66,puan77,puan88,puan99,puan00,puan011,puan022,puan033,puan044,puan055,puan066,puan077,puan088;

    TextView sure;
    TextView skor,skor2;
    MediaPlayer oyunMuzik,dogruMuzik,oyunBitti,sureBitti;

    ImageView v101,v102,v103,v104,v105,v106,v107,v108,v109,
            v110,v111,v112,v113,v114,v115,v116,v117,v118,
            v201,v202,v203,v204,v205,v206,v207,v208,v209,
            v210,v211,v212,v213,v214,v215,v216,v217,v218;
    int e1k1,e1k2,e1k3,e1k4,e2k1,e2k2,e2k3,e2k4,
            e3k1,e3k2,e3k3,e3k4,e3k5,e4k1,e4k2,e4k3,e4k4,e4k5;
    int sira =1,donusum;
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    Map<String, Object> data;
    Boolean tik101 = false, tik102 = false,tik103 = false,tik104 = false,
            tik105 = false,tik106 = false,tik107 = false,tik108 = false,
            tik109 = false,tik110 = false,tik111 = false,tik112 = false,
            tik113 = false,tik114 = false,tik115 = false,tik116 = false,
            tik117 = false,tik118 = false,
            tik201= false, tik202= false,tik203= false,tik204= false,
            tik205= false,tik206= false,tik207= false,tik208= false,
            tik209= false, tik210= false,tik211= false,tik212= false,
            tik213= false,tik214= false,tik215= false,tik216= false,
            tik217 = false,tik218 = false;
    ArrayList<Integer> kartlar = new ArrayList<>();
    Switch switchSes;
    boolean muzik;
    String karakter1,karakter2,karakter3,karakter4,karakter5,
            karakter6,karakter7,karakter8,karakter9,karakter10,
            karakter11,karakter12,karakter13,karakter14,karakter15,
            karakter16,karakter17,karakter18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cok_level3);
        switchSes = findViewById(R.id.switchCok3);

        oyunMuzik = MediaPlayer.create(CokLevel3Activity.this,R.raw.oyunmuzik);
        dogruMuzik = MediaPlayer.create(CokLevel3Activity.this,R.raw.dogrumuzik);
        oyunBitti = MediaPlayer.create(CokLevel3Activity.this,R.raw.oyunbitti);
        sureBitti = MediaPlayer.create(CokLevel3Activity.this,R.raw.surebittimuzik);
        switchSes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    muzik = true;
                    oyunMuzik.start();
                }else{
                    muzik = false;
                    oyunMuzik.stop();
                    dogruMuzik.stop();
                    oyunBitti.stop();
                    sureBitti.stop();
                }
            }
        });
        kartlar.add(R.id.v1);
        kartlar.add(R.id.v2);
        kartlar.add(R.id.v3);
        kartlar.add(R.id.v4);
        kartlar.add(R.id.v5);
        kartlar.add(R.id.v6);
        kartlar.add(R.id.v7);
        kartlar.add(R.id.v8);
        kartlar.add(R.id.v9);
        kartlar.add(R.id.v10);
        kartlar.add(R.id.v11);
        kartlar.add(R.id.v12);
        kartlar.add(R.id.v13);
        kartlar.add(R.id.v14);
        kartlar.add(R.id.v15);
        kartlar.add(R.id.v16);
        kartlar.add(R.id.v17);
        kartlar.add(R.id.v18);
        kartlar.add(R.id.v19);
        kartlar.add(R.id.v20);
        kartlar.add(R.id.v21);
        kartlar.add(R.id.v22);
        kartlar.add(R.id.v23);
        kartlar.add(R.id.v24);
        kartlar.add(R.id.v25);
        kartlar.add(R.id.v26);
        kartlar.add(R.id.v27);
        kartlar.add(R.id.v28);
        kartlar.add(R.id.v29);
        kartlar.add(R.id.v30);
        kartlar.add(R.id.v31);
        kartlar.add(R.id.v32);
        kartlar.add(R.id.v33);
        kartlar.add(R.id.v34);
        kartlar.add(R.id.v35);
        kartlar.add(R.id.v36);
        Collections.shuffle(kartlar);

        sure = findViewById(R.id.sure);
        skor = findViewById(R.id.skor);
        skor2 = findViewById(R.id.skor2);
        v101 = (ImageView) findViewById(kartlar.get(0));
        v102 = (ImageView) findViewById(kartlar.get(1));
        v103 = (ImageView) findViewById(kartlar.get(2));
        v104 = (ImageView) findViewById(kartlar.get(3));
        v105 = (ImageView) findViewById(kartlar.get(4));
        v106 = (ImageView) findViewById(kartlar.get(5));
        v107 = (ImageView) findViewById(kartlar.get(6));
        v108 = (ImageView) findViewById(kartlar.get(7));
        v109 = (ImageView) findViewById(kartlar.get(8));
        v110 = (ImageView) findViewById(kartlar.get(9));
        v111 = (ImageView) findViewById(kartlar.get(10));
        v112 = (ImageView) findViewById(kartlar.get(11));
        v113 = (ImageView) findViewById(kartlar.get(12));
        v114 = (ImageView) findViewById(kartlar.get(13));
        v115 = (ImageView) findViewById(kartlar.get(14));
        v116 = (ImageView) findViewById(kartlar.get(15));
        v117 = (ImageView) findViewById(kartlar.get(16));
        v118 = (ImageView) findViewById(kartlar.get(17));
        v201 = (ImageView) findViewById(kartlar.get(18));
        v202 = (ImageView) findViewById(kartlar.get(19));
        v203 = (ImageView) findViewById(kartlar.get(20));
        v204 = (ImageView) findViewById(kartlar.get(21));
        v205 = (ImageView) findViewById(kartlar.get(22));
        v206 = (ImageView) findViewById(kartlar.get(23));
        v207 = (ImageView) findViewById(kartlar.get(24));
        v208 = (ImageView) findViewById(kartlar.get(25));
        v209 = (ImageView) findViewById(kartlar.get(26));
        v210 = (ImageView) findViewById(kartlar.get(27));
        v211 = (ImageView) findViewById(kartlar.get(28));
        v212 = (ImageView) findViewById(kartlar.get(29));
        v213 = (ImageView) findViewById(kartlar.get(30));
        v214 = (ImageView) findViewById(kartlar.get(31));
        v215 = (ImageView) findViewById(kartlar.get(32));
        v216 = (ImageView) findViewById(kartlar.get(33));
        v217 = (ImageView) findViewById(kartlar.get(34));
        v218 = (ImageView) findViewById(kartlar.get(35));

        random();

        v101.setImageResource(R.drawable.arkayuzguncel);
        v102.setImageResource(R.drawable.arkayuzguncel);
        v103.setImageResource(R.drawable.arkayuzguncel);
        v104.setImageResource(R.drawable.arkayuzguncel);
        v105.setImageResource(R.drawable.arkayuzguncel);
        v106.setImageResource(R.drawable.arkayuzguncel);
        v107.setImageResource(R.drawable.arkayuzguncel);
        v108.setImageResource(R.drawable.arkayuzguncel);
        v109.setImageResource(R.drawable.arkayuzguncel);
        v110.setImageResource(R.drawable.arkayuzguncel);
        v111.setImageResource(R.drawable.arkayuzguncel);
        v112.setImageResource(R.drawable.arkayuzguncel);
        v113.setImageResource(R.drawable.arkayuzguncel);
        v114.setImageResource(R.drawable.arkayuzguncel);
        v115.setImageResource(R.drawable.arkayuzguncel);
        v116.setImageResource(R.drawable.arkayuzguncel);
        v201.setImageResource(R.drawable.arkayuzguncel);
        v202.setImageResource(R.drawable.arkayuzguncel);
        v203.setImageResource(R.drawable.arkayuzguncel);
        v204.setImageResource(R.drawable.arkayuzguncel);
        v205.setImageResource(R.drawable.arkayuzguncel);
        v206.setImageResource(R.drawable.arkayuzguncel);
        v207.setImageResource(R.drawable.arkayuzguncel);
        v208.setImageResource(R.drawable.arkayuzguncel);
        v209.setImageResource(R.drawable.arkayuzguncel);
        v210.setImageResource(R.drawable.arkayuzguncel);
        v211.setImageResource(R.drawable.arkayuzguncel);
        v212.setImageResource(R.drawable.arkayuzguncel);
        v213.setImageResource(R.drawable.arkayuzguncel);
        v214.setImageResource(R.drawable.arkayuzguncel);
        v215.setImageResource(R.drawable.arkayuzguncel);
        v216.setImageResource(R.drawable.arkayuzguncel);
        v217.setImageResource(R.drawable.arkayuzguncel);
        v218.setImageResource(R.drawable.arkayuzguncel);

        v101.setEnabled(false);
        v102.setEnabled(false);
        v103.setEnabled(false);
        v104.setEnabled(false);
        v105.setEnabled(false);
        v106.setEnabled(false);
        v107.setEnabled(false);
        v108.setEnabled(false);
        v109.setEnabled(false);
        v110.setEnabled(false);
        v111.setEnabled(false);
        v112.setEnabled(false);
        v113.setEnabled(false);
        v114.setEnabled(false);
        v115.setEnabled(false);
        v116.setEnabled(false);
        v117.setEnabled(false);
        v118.setEnabled(false);
        v201.setEnabled(false);
        v202.setEnabled(false);
        v203.setEnabled(false);
        v204.setEnabled(false);
        v205.setEnabled(false);
        v206.setEnabled(false);
        v207.setEnabled(false);
        v208.setEnabled(false);
        v209.setEnabled(false);
        v210.setEnabled(false);
        v211.setEnabled(false);
        v212.setEnabled(false);
        v213.setEnabled(false);
        v214.setEnabled(false);
        v215.setEnabled(false);
        v216.setEnabled(false);
        v217.setEnabled(false);
        v218.setEnabled(false);
    }
    public void siraYanlis(){
        if(sira == 1){
            sonSkor = sonSkor - etki;
            skor.setText("SKOR:" + sonSkor);
            donusum = 2;
        }if(sira == 2){
            sonSkor2 = sonSkor2 - etki;
            skor2.setText("SKOR:" + sonSkor2);
            donusum = 1;
        }
        sira = donusum;
    }
    public void siraDoğru(){
        if(sira == 1){
            sonSkor = sonSkor + etki;
            skor.setText("SKOR:" + sonSkor);
        }if(sira == 2){
            sonSkor2 = sonSkor2 + etki;
            skor2.setText("SKOR:" + sonSkor2);
        }
    }

    public void kontrol(){
        if (tik101 && tik102) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik102 = false;
                    etki = ((puan11 + puan22) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik103) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik103 = false;
                    etki = ((puan11 + puan33) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik104) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik104 = false;
                    etki = ((puan11 + puan44) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik105) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik105 = false;
                    etki = ((((puan11 + puan55) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik106) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik106 = false;
                    etki = ((((puan11 + puan66) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik107) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik107 = false;
                    etki = ((((puan11 + puan77) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik108) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik108 = false;
                    etki = ((((puan11 + puan88) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik109) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik109 = false;
                    etki = ((((puan11 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik110) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik110 = false;
                    etki = ((((puan11 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik111) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik111 = false;
                    etki = ((((puan11 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik112) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik112 = false;
                    etki = ((((puan11 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik113) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik113 = false;
                    etki = ((((puan11 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik114) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik114 = false;
                    etki = ((((puan11 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik115) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik115 = false;
                    etki = ((((puan11 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik116) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik116 = false;
                    etki = ((((puan11 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik117) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik117 = false;
                    etki = ((((puan11 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik118 = false;
                    etki = ((((puan11 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setVisibility(View.INVISIBLE);
                    v201.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik101 = false;
                    tik201 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    etki = ((4*puan11));
                    siraDoğru();
                }
            },800);
        }
        if (tik101 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik202 = false;
                    etki = ((puan11 + puan22) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik203 = false;
                    etki = ((puan11 + puan33) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik204 = false;
                    etki = ((puan11 + puan44) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik205 = false;
                    etki = ((((puan11 + puan55) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik206 = false;
                    etki = ((((puan11 + puan66) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik207 = false;
                    etki = ((((puan11 + puan77) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik208 = false;
                    etki = ((((puan11 + puan88) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik209 = false;
                    etki = ((((puan11 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik210 = false;
                    etki = ((((puan11 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik211 = false;
                    etki = ((((puan11 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik212 = false;
                    etki = ((((puan11 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik213 = false;
                    etki = ((((puan11 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik214 = false;
                    etki = ((((puan11 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik215 = false;
                    etki = ((((puan11 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik216 = false;
                    etki = ((((puan11 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik217 = false;
                    etki = ((((puan11 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik101 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v101.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik101 = false;
                    tik218 = false;
                    etki = ((((puan11 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik103) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik103 = false;
                    etki = ((puan22 + puan33) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik104) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik104 = false;
                    etki = ((puan22 + puan44) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik105) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik105 = false;
                    etki = ((((puan22 + puan55) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik106) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik106 = false;
                    etki = ((((puan22 + puan66) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik107) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik107 = false;
                    etki = ((((puan22 + puan77) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik108) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik108 = false;
                    etki = ((((puan22 + puan88) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik109) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik109 = false;
                    etki = ((((puan22 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik110) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik110 = false;
                    etki = ((((puan22 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik111) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik111 = false;
                    etki = ((((puan22 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik112) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik112 = false;
                    etki = ((((puan22 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik113) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik113 = false;
                    etki = ((((puan22 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik114) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik114 = false;
                    etki = ((((puan22 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik115) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik115 = false;
                    etki = ((((puan22 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik116) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik116 = false;
                    etki = ((((puan22 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik117) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik117 = false;
                    etki = ((((puan22 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik118 = false;
                    etki = ((((puan22 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik201 = false;
                    etki = ((puan11 + puan22) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setVisibility(View.INVISIBLE);
                    v202.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik102 = false;
                    tik202 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    etki = ((4*puan22));
                    siraDoğru();
                }
            },800);
        }
        if (tik102 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik203 = false;
                    etki = ((puan22 + puan33) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik204 = false;
                    etki = ((puan22 + puan44) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik205 = false;
                    etki = ((((puan22 + puan55) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik206 = false;
                    etki = ((((puan22 + puan66) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik207 = false;
                    etki = ((((puan22 + puan77) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik208 = false;
                    etki = ((((puan22 + puan88) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik209 = false;
                    etki = ((((puan22 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik210 = false;
                    etki = ((((puan22 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik211 = false;
                    etki = ((((puan22 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik212 = false;
                    etki = ((((puan22 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik213 = false;
                    etki = ((((puan22 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik214 = false;
                    etki = ((((puan22 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik215 = false;
                    etki = ((((puan22 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik216 = false;
                    etki = ((((puan22 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik217 = false;
                    etki = ((((puan22 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik102 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v102.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik102 = false;
                    tik218 = false;
                    etki = ((((puan22 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik104) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik104 = false;
                    etki = ((puan33 + puan44) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik105) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik105 = false;
                    etki = ((((puan33 + puan55) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik106) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik106 = false;
                    etki = ((((puan33 + puan66) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik107) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik107 = false;
                    etki = ((((puan33 + puan77) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik108) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik108 = false;
                    etki = ((((puan33 + puan88) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik109) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik109 = false;
                    etki = ((((puan33 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik110) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik110 = false;
                    etki = ((((puan33 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik111) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik111 = false;
                    etki = ((((puan33 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik112) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik112 = false;
                    etki = ((((puan33 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik113) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik113 = false;
                    etki = ((((puan33 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik114) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik114 = false;
                    etki = ((((puan33 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik115) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik115 = false;
                    etki = ((((puan33 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik116) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik116 = false;
                    etki = ((((puan33 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik117) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik117 = false;
                    etki = ((((puan33 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik118 = false;
                    etki = ((((puan33 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik201 = false;
                    etki = ((puan11 + puan33) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik202 = false;
                    etki = ((puan22 + puan33) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setVisibility(View.INVISIBLE);
                    v203.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik103 = false;
                    tik203 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    etki = ((4*puan33));
                    siraDoğru();
                }
            },800);
        }
        if (tik103 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik204 = false;
                    etki = ((puan33 + puan44) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik205 = false;
                    etki = ((((puan33 + puan55) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik206 = false;
                    etki = ((((puan33 + puan66) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik207 = false;
                    etki = ((((puan33 + puan77) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik208 = false;
                    etki = ((((puan33 + puan88) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik209 = false;
                    etki = ((((puan33 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik210 = false;
                    etki = ((((puan33 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik211 = false;
                    etki = ((((puan33 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik212 = false;
                    etki = ((((puan33 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik213 = false;
                    etki = ((((puan33 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik214 = false;
                    etki = ((((puan33 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik215 = false;
                    etki = ((((puan33 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik216 = false;
                    etki = ((((puan33 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik217 = false;
                    etki = ((((puan33 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik103 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v103.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik103 = false;
                    tik218 = false;
                    etki = ((((puan33 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik105) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik105 = false;
                    etki = ((((puan44 + puan55) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik106) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik106 = false;
                    etki = ((((puan44 + puan66) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik107) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik107 = false;
                    etki = ((((puan44 + puan77) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik108) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik108 = false;
                    etki = ((((puan44 + puan88) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik109) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik109 = false;
                    etki = ((((puan44 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik110) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik110 = false;
                    etki = ((((puan44 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik111) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik111 = false;
                    etki = ((((puan44 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik112) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik112 = false;
                    etki = ((((puan44 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik113) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik113 = false;
                    etki = ((((puan44 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik114) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik114 = false;
                    etki = ((((puan44 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik115) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik115 = false;
                    etki = ((((puan44 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik116) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik116 = false;
                    etki = ((((puan44 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik117) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik117 = false;
                    etki = ((((puan44 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik118 = false;
                    etki = ((((puan44 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik201 = false;
                    etki = ((puan11 + puan44) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik202 = false;
                    etki = ((puan22 + puan44) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik203 = false;
                    etki = ((puan33 + puan44) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setVisibility(View.INVISIBLE);
                    v204.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik104 = false;
                    tik204 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    etki = ((4*puan44));
                    siraDoğru();
                }
            },800);
        }
        if (tik104 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik205 = false;
                    etki = ((((puan44 + puan55) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik206 = false;
                    etki = ((((puan44 + puan66) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik207 = false;
                    etki = ((((puan44 + puan77) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik208 = false;
                    etki = ((((puan44 + puan88) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik209 = false;
                    etki = ((((puan44 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik210 = false;
                    etki = ((((puan44 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik211 = false;
                    etki = ((((puan44 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik212 = false;
                    etki = ((((puan44 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik213 = false;
                    etki = ((((puan44 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik214 = false;
                    etki = ((((puan44 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik215 = false;
                    etki = ((((puan44 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik216 = false;
                    etki = ((((puan44 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik217 = false;
                    etki = ((((puan44 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik104 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v104.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik104 = false;
                    tik218 = false;
                    etki = ((((puan44 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik106) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik106 = false;
                    etki = ((puan55 + puan66) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik107) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik107 = false;
                    etki = ((puan55 + puan77) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik108) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik108 = false;
                    etki = ((puan55 + puan88) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik109) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik109 = false;
                    etki = ((((puan55 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik110) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik110 = false;
                    etki = ((((puan55 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik111) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik111 = false;
                    etki = ((((puan55 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik112) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik112 = false;
                    etki = ((((puan55 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik113) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik113 = false;
                    etki = ((((puan55 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik114) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik114 = false;
                    etki = ((((puan55 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik115) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik115 = false;
                    etki = ((((puan55 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik116) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik116 = false;
                    etki = ((((puan55 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik117) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik117 = false;
                    etki = ((((puan55 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik118 = false;
                    etki = ((((puan55 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik201 = false;
                    etki = ((((puan11 + puan55) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik202 = false;
                    etki = ((((puan55 + puan22) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik203 = false;
                    etki = ((((puan55 + puan33) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik204 = false;
                    etki = ((((puan55 + puan44) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setVisibility(View.INVISIBLE);
                    v205.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik105 = false;
                    tik205 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    etki = ((4*puan55));
                    siraDoğru();
                }
            },800);
        }
        if (tik105 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik206 = false;
                    etki = ((puan55 + puan66) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik207 = false;
                    etki = ((puan55 + puan77) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik208 = false;
                    etki = ((puan55 + puan88) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik209 = false;
                    etki = ((((puan55 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik210 = false;
                    etki = ((((puan55 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik211 = false;
                    etki = ((((puan55 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik212 = false;
                    etki = ((((puan55 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik213 = false;
                    etki = ((((puan55 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik214 = false;
                    etki = ((((puan55 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik215 = false;
                    etki = ((((puan55 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik216 = false;
                    etki = ((((puan55 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik217 = false;
                    etki = ((((puan55 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik105 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v105.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik105 = false;
                    tik218 = false;
                    etki = ((((puan55 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik107) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik107 = false;
                    etki = ((puan66 + puan77) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik108) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik108 = false;
                    etki = ((puan66 + puan88) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik109) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik109 = false;
                    etki = ((((puan66 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik110) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik110 = false;
                    etki = ((((puan66 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik111) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik111 = false;
                    etki = ((((puan66 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik112) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik112 = false;
                    etki = ((((puan66 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik113) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik113 = false;
                    etki = ((((puan66 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik114) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik114 = false;
                    etki = ((((puan66 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik115) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik115 = false;
                    etki = ((((puan66 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik116) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik116 = false;
                    etki = ((((puan66 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik117) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik117 = false;
                    etki = ((((puan66 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik118 = false;
                    etki = ((((puan66 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik201 = false;
                    etki = ((((puan11 + puan66) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik202 = false;
                    etki = ((((puan66 + puan22) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik203 = false;
                    etki = ((((puan66 + puan33) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik204 = false;
                    etki = ((((puan66 + puan44) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setVisibility(View.INVISIBLE);
                    v206.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik106 = false;
                    tik206 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    etki = ((4*puan66));
                    siraDoğru();
                }
            },800);
        }
        if (tik106 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik205 = false;
                    etki = ((puan55 + puan66) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik207 = false;
                    etki = ((puan66 + puan77) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik208 = false;
                    etki = ((puan66 + puan88) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik209 = false;
                    etki = ((((puan66 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik210 = false;
                    etki = ((((puan66 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik211 = false;
                    etki = ((((puan66 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik212 = false;
                    etki = ((((puan66 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik213 = false;
                    etki = ((((puan66 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik214 = false;
                    etki = ((((puan66 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik215 = false;
                    etki = ((((puan66 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik216 = false;
                    etki = ((((puan66 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik217 = false;
                    etki = ((((puan66 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik106 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v106.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik106 = false;
                    tik218 = false;
                    etki = ((((puan66 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik108) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik108 = false;
                    etki = ((puan77 + puan88) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik109) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik109 = false;
                    etki = ((((puan77 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik110) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik110 = false;
                    etki = ((((puan77 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik111) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik111 = false;
                    etki = ((((puan77 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik112) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik112 = false;
                    etki = ((((puan77 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik113) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik113 = false;
                    etki = ((((puan77 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik114) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik114 = false;
                    etki = ((((puan77 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik115) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik115 = false;
                    etki = ((((puan77 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik116) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik116 = false;
                    etki = ((((puan77 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik117) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik117 = false;
                    etki = ((((puan77 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik118 = false;
                    etki = ((((puan77 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik201 = false;
                    etki = ((((puan11 + puan77) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik202 = false;
                    etki = ((((puan77 + puan22) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik203 = false;
                    etki = ((((puan77 + puan33) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik204 = false;
                    etki = ((((puan77 + puan44) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik205 = false;
                    etki = ((((puan77 + puan55) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik206 = false;
                    etki = ((puan77 + puan66) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setVisibility(View.INVISIBLE);
                    v207.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik107 = false;
                    tik207 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    etki = ((4*puan77));
                    siraDoğru();
                }
            },800);
        }
        if (tik107 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik208 = false;
                    etki = ((puan77 + puan88) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik209 = false;
                    etki = ((((puan77 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik210 = false;
                    etki = ((((puan77 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik211 = false;
                    etki = ((((puan77 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik212 = false;
                    etki = ((((puan77 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik213 = false;
                    etki = ((((puan77 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik214 = false;
                    etki = ((((puan77 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik215 = false;
                    etki = ((((puan77 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik216 = false;
                    etki = ((((puan77 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik217 = false;
                    etki = ((((puan77 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik107 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v107.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik107 = false;
                    tik218 = false;
                    etki = ((((puan77 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik109) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik109 = false;
                    etki = ((((puan88 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik110) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik110 = false;
                    etki = ((((puan88 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik111) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik111 = false;
                    etki = ((((puan88 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik112) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik112 = false;
                    etki = ((((puan88 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik113) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik113 = false;
                    etki = ((((puan88 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik114) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik114 = false;
                    etki = ((((puan88 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik115) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik115 = false;
                    etki = ((((puan88 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik116) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik116 = false;
                    etki = ((((puan88 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik117) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik117 = false;
                    etki = ((((puan88 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik118 = false;
                    etki = ((((puan88 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik201 = false;
                    etki = ((((puan11 + puan88) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik202 = false;
                    etki = ((((puan88 + puan22) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik203 = false;
                    etki = ((((puan88 + puan33) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik204 = false;
                    etki = ((((puan88 + puan44) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik205 = false;
                    etki = ((((puan88 + puan55) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik206 = false;
                    etki = ((puan88 + puan66) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik207 = false;
                    etki = ((puan77 + puan88) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setVisibility(View.INVISIBLE);
                    v208.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik108 = false;
                    tik208 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    etki = ((4*puan88));
                    siraDoğru();
                }
            },800);
        }
        if (tik108 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik209 = false;
                    etki = ((((puan88 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik210 = false;
                    etki = ((((puan88 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik211 = false;
                    etki = ((((puan88 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik212 = false;
                    etki = ((((puan88 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik213 = false;
                    etki = ((((puan88 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik214 = false;
                    etki = ((((puan88 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik215 = false;
                    etki = ((((puan88 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik216 = false;
                    etki = ((((puan88 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik217 = false;
                    etki = ((((puan88 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik108 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v108.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik108 = false;
                    tik218 = false;
                    etki = ((((puan88 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik110) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik110 = false;
                    etki = ((puan99 + puan00) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik111) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik111 = false;
                    etki = ((puan99 + puan011) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik112) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik112 = false;
                    etki = ((puan99 + puan022) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik113) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik113 = false;
                    etki = ((puan99 + puan033) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik114) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik114 = false;
                    etki = ((((puan99 + puan044) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik115) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik115 = false;
                    etki = ((((puan99 + puan055) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik116) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik116 = false;
                    etki = ((((puan99 + puan066) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik117) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik117 = false;
                    etki = ((((puan99 + puan077) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik118 = false;
                    etki = ((((puan99 + puan088) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik201 = false;
                    etki = ((((puan99 + puan11) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik202 = false;
                    etki = ((((puan99 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik203 = false;
                    etki = ((((puan99 + puan33) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik204 = false;
                    etki = ((((puan99 + puan44) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik205 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan99 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik206 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan99 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik207 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan99 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan99 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v109.setVisibility(View.INVISIBLE);
                    v209.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik109 = false;
                    tik209 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    //evin katsayısı 2 ise
                    etki = ((1*puan99));
                    siraDoğru();
                }
            },800);
        }
        if (tik109 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan99 + puan00) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan99 + puan011) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan99 + puan022) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan99 + puan033) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan99 + puan044) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan99 + puan055) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan99 + puan066) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan99 + puan077) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik109 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v109.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik109 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan99 + puan088) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik111) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik111 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan00 + puan011) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik112) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik112 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan00 + puan022) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik113) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik113 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan00 + puan033) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik114) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik114 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan00 + puan044) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik115) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik115 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan00 + puan055) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik116) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik116 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan00 + puan066) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik117) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik117 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan00 + puan077) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik118 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan00 + puan088) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik201 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan00 + puan11) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik202 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan00 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik203 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan00 + puan33) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik204 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan00 + puan44) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik205 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan00 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik206 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan00 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik207 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan00 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan00 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan99 + puan00) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setVisibility(View.INVISIBLE);
                    v210.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik110 = false;
                    tik210 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    //evin katsayısı 2 ise
                    etki = ((1*puan00));
                    siraDoğru();
                }
            },800);
        }
        if (tik110 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan00 + puan011) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan00 + puan022) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan00 + puan033) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan00 + puan044) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan00 + puan055) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan00 + puan066) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan00 + puan077) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik110 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v110.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik110 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan00 + puan088) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik112) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik112 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan011 + puan022) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik113) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik113 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan011 + puan033) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik114) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik114 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan011 + puan044) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik115) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik115 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan011 + puan055) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik116) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik116 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan011 + puan066) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik117) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik117 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan011 + puan077) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik118 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan011 + puan088) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik201 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan011 + puan11) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik202 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan011 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik203 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan011 + puan33) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik204 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan011 + puan44) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik205 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan011 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik206 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan011 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik207 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan011 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan011 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan99 + puan011) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan00 + puan011) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setVisibility(View.INVISIBLE);
                    v211.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik111 = false;
                    tik211 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    //evin katsayısı 2 ise
                    etki = ((1*puan011));
                    siraDoğru();
                }
            },800);
        }
        if (tik111 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan011 + puan022) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan011 + puan033) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan011 + puan044) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan011 + puan055) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan011 + puan066) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan011 + puan077) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik111 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v111.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik111 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan011 + puan088) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik113) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik113 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan022 + puan033) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik114) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik114 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan022 + puan044) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik115) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik115 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan022 + puan055) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik116) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik116 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan022 + puan066) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik117) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik117 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan022 + puan077) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik118 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan022 + puan088) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik201 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan022 + puan11) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik202 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan022 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik203 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan022 + puan33) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik204 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan022 + puan44) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik205 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan022 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik206 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan022 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik207 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan022 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan022 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan99 + puan022) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan00 + puan022) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan011 + puan022) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setVisibility(View.INVISIBLE);
                    v212.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik112 = false;
                    tik212 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    //evin katsayısı 2 ise
                    etki = ((1*puan022));
                    siraDoğru();
                }
            },800);
        }
        if (tik112 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan022 + puan033) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan022 + puan044) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan022 + puan055) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan022 + puan066) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan022 + puan077) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik112 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v112.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik112 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan022 + puan088) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik114) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik114 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan033 + puan044) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik115) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik115 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan033 + puan055) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik116) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik116 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan033 + puan066) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik117) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik117 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan033 + puan077) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik118 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan033 + puan088) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik201 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan033 + puan11) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik202 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan033 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik203 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan033 + puan33) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik204 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan033 + puan44) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik205 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan033 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik206 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan033 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik207 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan033 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan033 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan99 + puan033) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan00 + puan033) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan011 + puan033) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan022 + puan033) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setVisibility(View.INVISIBLE);
                    v213.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik113 = false;
                    tik213 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    //evin katsayısı 2 ise
                    etki = ((1*puan033));
                    siraDoğru();
                }
            },800);
        }
        if (tik113 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan033 + puan044) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan033 + puan055) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan033 + puan066) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan033 + puan077) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik113 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v113.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik113 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan033 + puan088) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik115) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik115 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan044 + puan055) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik116) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik116 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan044 + puan066) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik117) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik117 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan044 + puan077) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik118 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan044 + puan088) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik201 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan044 + puan11) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik202 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan044 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik203 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan044 + puan33) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik204 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan044 + puan44) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik205 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan044 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik206 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan044 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik207 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan044 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan044 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan044 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan044 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan044 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan044 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan044 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setVisibility(View.INVISIBLE);
                    v214.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik114 = false;
                    tik214 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    //evin katsayısı 2 ise
                    etki = ((1*puan044));
                    siraDoğru();
                }
            },800);
        }
        if (tik114 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan044 + puan055) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan044 + puan066) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan044 + puan077) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik114 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v114.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik114 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan044 + puan088) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik116) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik116 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan055 + puan066) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik117) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik117 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan055 + puan077) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik118 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan055 + puan088) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik201 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan055 + puan11) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik202 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan055 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik203 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan055 + puan33) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik204 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan055 + puan44) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik205 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan055 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik206 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan055 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik207 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan055 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan055 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan055 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan055 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan055 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan055 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan055 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan044 + puan055) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setVisibility(View.INVISIBLE);
                    v215.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik115 = false;
                    tik215 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    //evin katsayısı 2 ise
                    etki = ((1*puan055));
                    siraDoğru();
                }
            },800);
        }
        if (tik115 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan055 + puan066) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan055 + puan077) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik115 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v115.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik115 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan055 + puan088) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik117) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik117 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan066 + puan077) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik118 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan066 + puan088) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik201 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan066 + puan11) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik202 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan066 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik203 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan066 + puan33) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik204 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan066 + puan44) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik205 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan066 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik206 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan066 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik207 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan066 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan066 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan066 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan066 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan066 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan066 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan066 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan044 + puan066) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan055 + puan066) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setVisibility(View.INVISIBLE);
                    v216.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik116 = false;
                    tik216 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    //evin katsayısı 2 ise
                    etki = ((1*puan066));
                    siraDoğru();
                }
            },800);
        }
        if (tik116 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan066 + puan077) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik116 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v116.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik116 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan066 + puan088) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik118) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik118 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan077 + puan088) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik201 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan077 + puan11) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik202 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan077 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik203 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan077 + puan33) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik204 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan077 + puan44) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik205 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan077 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik206 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan077 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik207 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan077 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan077 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan077 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan077 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan077 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan077 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan077 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan044 + puan077) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan055 + puan077) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan066 + puan077) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik117 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setVisibility(View.INVISIBLE);
                    v217.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik117 = false;
                    tik217 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    //evin katsayısı 2 ise
                    etki = ((1*puan077));
                    siraDoğru();
                }
            },800);
        }
        if (tik117 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v117.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik117 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan077 + puan088) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik201) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik201 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan088 + puan11) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik202 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan088 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik203 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan088 + puan33) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik204 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan088 + puan44) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik205 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan088 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik206 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan088 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik207 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan088 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan088 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan088 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan088 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan088 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan088 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan088 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan044 + puan088) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan055 + puan088) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan066 + puan088) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik118 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan077 + puan088) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik118 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v118.setVisibility(View.INVISIBLE);
                    v218.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik118 = false;
                    tik218 = false;
                    if(muzik){
                    oyunMuzik.pause();
                    dogruMuzik.start();
                    dogruMuzik.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            oyunMuzik.start();
                        }
                    });}
                    //evin katsayısı 2 ise
                    etki = ((1*puan088));
                    siraDoğru();
                }
            },800);
        }
        if (tik201 && tik202) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik202 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan11 + puan22) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik201 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik203 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan11 + puan33) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik201 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik204 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan11 + puan44) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik201 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik205 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan11 + puan55) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik201 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik206 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan11 + puan66) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik201 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik207 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan11 + puan77) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik201 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan11 + puan88) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik201 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan11 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik201 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan11 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik201 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan11 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik201 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan11 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik201 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan11 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik201 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan11 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik201 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan11 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik201 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan11 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik201 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan11 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik201 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v201.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik201 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan11 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik202 && tik203) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    tik202 = false;
                    tik203 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan22 + puan33) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik202 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik202 = false;
                    tik204 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan22 + puan44) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik202 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik202 = false;
                    tik205 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan22 + puan55) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik202 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik202 = false;
                    tik206 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan22 + puan66) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik202 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik202 = false;
                    tik207 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan22 + puan77) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik202 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik202 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan22 + puan88) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik202 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik202 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan22 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik202 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik202 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan22 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik202 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik202 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan22 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik202 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik202 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan22 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik202 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik202 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan22 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik202 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik202 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan22 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik202 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik202 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan22 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik202 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik202 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan22 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik202 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik202 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan22 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik202 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v202.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik202 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan22 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik203 && tik204) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    tik203 = false;
                    tik204 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan33 + puan44) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik203 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik203 = false;
                    tik205 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan33 + puan55) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik203 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik203 = false;
                    tik206 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan33 + puan66) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik203 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik203 = false;
                    tik207 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan33 + puan77) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik203 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik203 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan33 + puan88) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik203 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik203 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan33 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik203 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik203 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan33 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik203 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik203 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan33 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik203 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik203 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan33 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik203 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik203 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan33 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik203 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik203 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan33 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik203 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik203 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan33 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik203 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik203 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan33 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik203 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik203 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan33 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik203 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v203.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik203 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan33 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik204 && tik205) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    tik204 = false;
                    tik205 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan44 + puan55) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik204 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik204 = false;
                    tik206 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan44 + puan66) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik204 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik204 = false;
                    tik207 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan44 + puan77) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik204 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik204 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan44 + puan88) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik204 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik204 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan44 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik204 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik204 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan44 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik204 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik204 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan44 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik204 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik204 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan44 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik204 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik204 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan44 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik204 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik204 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan44 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik204 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik204 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan44 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik204 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik204 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan44 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik204 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik204 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan44 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik204 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v204.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik204 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan44 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik205 && tik206) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    tik205 = false;
                    tik206 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan55 + puan66) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik205 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik205 = false;
                    tik207 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan55 + puan77) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik205 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik205 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan55 + puan88) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik205 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik205 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik205 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik205 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik205 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik205 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik205 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik205 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik205 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik205 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik205 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik205 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik205 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik205 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik205 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik205 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik205 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik205 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik205 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v205.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik205 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik206 && tik207) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    tik206 = false;
                    tik207 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan66 + puan77) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik206 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik206 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan66 + puan88) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik206 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik206 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan66 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik206 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik206 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan66 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik206 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik206 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan66 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik206 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik206 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan66 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik206 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik206 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan66 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik206 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik206 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan66 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik206 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik206 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan66 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik206 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik206 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan66 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik206 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik206 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan66 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik206 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v206.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik206 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan66 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik207 && tik208) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    tik207 = false;
                    tik208 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan77 + puan88) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik207 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik207 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan77 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik207 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik207 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan77 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik207 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik207 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan77 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik207 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik207 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan77 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik207 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik207 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan77 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik207 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik207 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan77 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik207 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik207 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan77 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik207 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik207 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan77 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik207 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik207 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan77 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik207 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v207.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik207 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan77 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik208 && tik209) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    tik208 = false;
                    tik209 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan88 + puan99) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik208 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik208 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan88 + puan00) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik208 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik208 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan88 + puan011) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik208 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik208 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan88 + puan022) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik208 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik208 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan88 + puan033) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik208 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik208 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan88 + puan044) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik208 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik208 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan88 + puan055) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik208 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik208 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan88 + puan066) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik208 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik208 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan88 + puan077) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik208 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v208.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik208 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan77 + puan088) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik209 && tik210) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    tik209 = false;
                    tik210 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan99 + puan00) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik209 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik209 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan99 + puan011) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik209 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik209 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan99 + puan022) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik209 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik209 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan99 + puan033) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik209 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik209 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan99 + puan044) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik209 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik209 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan99 + puan055) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik209 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik209 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan99 + puan066) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik209 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik209 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan99 + puan077) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik209 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v209.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik209 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan99 + puan088) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik210 && tik211) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    tik210 = false;
                    tik211 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan00 + puan011) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik210 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik210 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan00 + puan022) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik210 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik210 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan00 + puan033) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik210 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik210 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan00 + puan044) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik210 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik210 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan00 + puan055) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik210 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik210 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan00 + puan066) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik210 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik210 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan00 + puan077) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik210 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v210.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik210 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan00 + puan088) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik211 && tik212) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    tik211 = false;
                    tik212 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan011 + puan022) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik211 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik211 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan011 + puan033) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik211 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik211 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan011 + puan044) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik211 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik211 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan011 + puan055) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik211 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik211 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan011 + puan066) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik211 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik211 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan011 + puan077) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik211 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v211.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik211 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan011 + puan088) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik212 && tik213) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    tik212 = false;
                    tik213 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan022 + puan033) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik212 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik212 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan022 + puan044) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik212 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik212 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan022 + puan055) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik212 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik212 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan022 + puan066) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik212 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik212 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan022 + puan077) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik212 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v212.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik212 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan022 + puan088) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik213 && tik214) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    tik213 = false;
                    tik214 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan033 + puan044) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik213 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik213 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan033 + puan055) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik213 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik213 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan033 + puan066) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik213 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik213 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan033 + puan077) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik213 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v213.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik213 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan033 + puan088) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik214 && tik215) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    tik214 = false;
                    tik215 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan044 + puan055) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik214 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik214 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan044 + puan066) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik214 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik214 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan044 + puan077) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik214 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v214.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik214 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan044 + puan088) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik215 && tik216) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    tik215 = false;
                    tik216 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan055 + puan066) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik215 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik215 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan055 + puan077) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik215 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v215.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik215 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan055 + puan088) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik216 && tik217) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    tik216 = false;
                    tik217 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan066 + puan077) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik216 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v216.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik216 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan066 + puan088) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik217 && tik218) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v217.setImageResource(R.drawable.arkayuzguncel);
                    v218.setImageResource(R.drawable.arkayuzguncel);
                    tik217 = false;
                    tik218 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan077 + puan088) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
    }
    public void kontrol2(){
        if(v101.getVisibility() == View.INVISIBLE
                && v102.getVisibility() == View.INVISIBLE
                && v103.getVisibility() == View.INVISIBLE
                && v104.getVisibility() == View.INVISIBLE
                && v105.getVisibility() == View.INVISIBLE
                && v106.getVisibility() == View.INVISIBLE
                && v107.getVisibility() == View.INVISIBLE
                && v108.getVisibility() == View.INVISIBLE
                && v109.getVisibility() == View.INVISIBLE
                && v110.getVisibility() == View.INVISIBLE
                && v111.getVisibility() == View.INVISIBLE
                && v112.getVisibility() == View.INVISIBLE
                && v113.getVisibility() == View.INVISIBLE
                && v114.getVisibility() == View.INVISIBLE
                && v115.getVisibility() == View.INVISIBLE
                && v116.getVisibility() == View.INVISIBLE
                && v117.getVisibility() == View.INVISIBLE
                && v118.getVisibility() == View.INVISIBLE
                && v201.getVisibility() == View.INVISIBLE
                && v202.getVisibility() == View.INVISIBLE
                && v203.getVisibility() == View.INVISIBLE
                && v204.getVisibility() == View.INVISIBLE
                && v205.getVisibility() == View.INVISIBLE
                && v206.getVisibility() == View.INVISIBLE
                && v207.getVisibility() == View.INVISIBLE
                && v208.getVisibility() == View.INVISIBLE
                && v209.getVisibility() == View.INVISIBLE
                && v210.getVisibility() == View.INVISIBLE
                && v211.getVisibility() == View.INVISIBLE
                && v212.getVisibility() == View.INVISIBLE
                && v213.getVisibility() == View.INVISIBLE
                && v214.getVisibility() == View.INVISIBLE
                && v215.getVisibility() == View.INVISIBLE
                && v216.getVisibility() == View.INVISIBLE
                && v217.getVisibility() == View.INVISIBLE
                && v218.getVisibility() == View.INVISIBLE){
            if(muzik){
            oyunMuzik.pause();
            oyunBitti.start();
            oyunBitti.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    oyunMuzik.start();
                }
            });}
        }
    }
    public void random(){
        e1k1 = (int)(Math.random()*(2));
        e1k2 = (int)(Math.random()*(3)+2);
        e1k3 = (int)(Math.random()*(3)+5);
        e1k4 = (int)(Math.random()*(3)+8);
        e2k1 = (int)(Math.random()*(2));
        e2k2 = (int)(Math.random()*(3)+2);
        e2k3 = (int)(Math.random()*(3)+5);
        e2k4 = (int)(Math.random()*(3)+8);
        e3k1 = (int)(Math.random()*(2));
        e3k2 = (int)(Math.random()*(2)+2);
        e3k3 = (int)(Math.random()*(2)+4);
        e3k4 = (int)(Math.random()*(2)+6);
        e3k5 = (int)(Math.random()*(3)+8);
        e4k1 = (int)(Math.random()*(2));
        e4k2 = (int)(Math.random()*(2)+2);
        e4k3 = (int)(Math.random()*(2)+4);
        e4k4 = (int)(Math.random()*(2)+6);
        e4k5 = (int)(Math.random()*(3)+8);
        if(e1k1==0){karakter1 = "Albus Dumbledore";}
        if(e1k1==1){karakter1 = "Arthur Weasley";}
        if(e1k2==2){karakter2 = "Harry Potter";}
        if(e1k2==3){karakter2 = "Hermione Granger";}
        if(e1k2==4){karakter2 = "Lily Potter";}
        if(e1k3==5){karakter3 = "Minerva McGonagall";}
        if(e1k3==6){karakter3 = "Peter Pettigrew";}
        if(e1k3==7){karakter3 = "Remus Lupin";}
        if(e1k4==8){karakter4 = "Ron Weasley";}
        if(e1k4==9){karakter4 = "Rubeus Hagrid";}
        if(e1k4==10){karakter4 = "Sirius Black";}
        if(e2k1==0){karakter5 = "Andromeda Tonks";}
        if(e2k1==1){karakter5 = "Bellatrix Lestrange";}
        if(e2k2==2){karakter6 = "Dolores Umbridge";}
        if(e2k2==3){karakter6 = "Draco Malfoy";}
        if(e2k2==4){karakter6 = "Evan Rosier";}
        if(e2k3==5){karakter7 = "Horace Slughorn";}
        if(e2k3==6){karakter7 = "Leta Lestrange";}
        if(e2k3==7){karakter7 = "Lucius Malfoy";}
        if(e2k4==8){karakter8 = "Narcissa Malfoy";}
        if(e2k4==9){karakter8 = "Severus Snape";}
        if(e2k4==10){karakter8 = "Tom Riddle";}
        if(e3k1==0){karakter9 = "Cedric Diggory";}
        if(e3k1==1){karakter9 = "Ernest Macmillan";}
        if(e3k2==2){karakter10 = "Fat Friar";}
        if(e3k2==3){karakter10 = "Hannah Abbott";}
        if(e3k3==4){karakter11 = "Helga Hufflepuff";}
        if(e3k3==5){karakter11 = "Leanne";}
        if(e3k4==6){karakter12 = "Newt Scamander";}
        if(e3k4==7){karakter12 = "Nymphadora Tonks";}
        if(e3k5==8){karakter13 = "Pomona Sprout";}
        if(e3k5==9){karakter13 = "Silvanus Kettleburn";}
        if(e3k5==10){karakter13 = "Ted Lupin";}
        if(e4k1==0){karakter14 = "Cho Chang";}
        if(e4k1==1){karakter14 = "Filius Flitwick";}
        if(e4k2==2){karakter15 = "Garrick Ollivander";}
        if(e4k2==3){karakter15 = "Gilderoy Lockhart";}
        if(e4k3==4){karakter16 = "Luna Lovegood";}
        if(e4k3==5){karakter16 = "Marcus Belby";}
        if(e4k4==6){karakter17 = "Myrtle Warren";}
        if(e4k4==7){karakter17 = "Padma Patil";}
        if(e4k5==8){karakter18 = "Quirinus Quirrell";}
        if(e4k5==9){karakter18 = "Rowena Ravenclaw";}
        if(e4k5==10){karakter18 = "Sybill Trelawney";}
    }
    public void baslaClicked(View view){

        v101.setEnabled(true);
        v102.setEnabled(true);
        v103.setEnabled(true);
        v104.setEnabled(true);
        v105.setEnabled(true);
        v106.setEnabled(true);
        v107.setEnabled(true);
        v108.setEnabled(true);
        v109.setEnabled(true);
        v110.setEnabled(true);
        v111.setEnabled(true);
        v112.setEnabled(true);
        v113.setEnabled(true);
        v114.setEnabled(true);
        v115.setEnabled(true);
        v116.setEnabled(true);
        v117.setEnabled(true);
        v118.setEnabled(true);
        v201.setEnabled(true);
        v202.setEnabled(true);
        v203.setEnabled(true);
        v204.setEnabled(true);
        v205.setEnabled(true);
        v206.setEnabled(true);
        v207.setEnabled(true);
        v208.setEnabled(true);
        v209.setEnabled(true);
        v210.setEnabled(true);
        v211.setEnabled(true);
        v212.setEnabled(true);
        v213.setEnabled(true);
        v214.setEnabled(true);
        v215.setEnabled(true);
        v216.setEnabled(true);
        v217.setEnabled(true);
        v218.setEnabled(true);

        v101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek1();
                tik101= true;
                kontrol();
            }
        });
        v102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek1();
                tik102= true;
                kontrol();
            }
        });
        v103.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek1();
                tik103= true;
                kontrol();
            }
        });
        v104.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek1();
                tik104= true;
                kontrol();
            }
        });
        v105.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek2();
                tik105= true;
                kontrol();
            }
        });
        v106.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek2();
                tik106= true;
                kontrol();
            }
        });
        v107.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek2();
                tik107= true;
                kontrol();
            }
        });
        v108.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek2();
                tik108= true;
                kontrol();
            }
        });
        v109.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek3();
                tik109= true;
                kontrol();
            }
        });
        v110.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek3();
                tik110= true;
                kontrol();
            }
        });
        v111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek3();
                tik111= true;
                kontrol();
            }
        });
        v112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek3();
                tik112= true;
                kontrol();
            }
        });
        v113.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek3();
                tik113= true;
                kontrol();
            }
        });
        v114.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek4();
                tik114= true;
                kontrol();
            }
        });
        v115.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek4();
                tik115= true;
                kontrol();
            }
        });
        v116.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek4();
                tik116= true;
                kontrol();
            }
        });
        v117.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek4();
                tik117= true;
                kontrol();
            }
        });
        v118.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek4();
                tik118= true;
                kontrol();
            }
        });
        v201.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek1();
                tik201= true;
                kontrol();
            }
        });
        v202.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek1();
                tik202=true;
                kontrol();

            }
        });
        v203.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek1();
                tik203=true;
                kontrol();

            }
        });
        v204.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek1();
                tik204=true;
                kontrol();

            }
        });
        v205.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek2();
                tik205=true;
                kontrol();

            }
        });
        v206.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek2();
                tik206=true;
                kontrol();

            }
        });
        v207.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek2();
                tik207=true;
                kontrol();

            }
        });
        v208.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek2();
                tik208=true;
                kontrol();

            }
        });
        v209.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek3();
                tik209=true;
                kontrol();

            }
        });
        v210.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek3();
                tik210=true;
                kontrol();

            }
        });
        v211.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek3();
                tik211=true;
                kontrol();

            }
        });
        v212.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek3();
                tik212=true;
                kontrol();

            }
        });
        v213.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek3();
                tik213=true;
                kontrol();

            }
        });
        v214.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek4();
                tik214=true;
                kontrol();

            }
        });
        v215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek4();
                tik215=true;
                kontrol();

            }
        });
        v216.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek4();
                tik216=true;
                kontrol();

            }
        });
        v217.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek4();
                tik217=true;
                kontrol();

            }
        });
        v218.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek4();
                tik218=true;
                kontrol();

            }
        });

        new CountDownTimer(60000,1000){

            @Override
            public void onTick(long l) {
                sure.setText("SÜRE" + l/1000);
                kalansure = (long) (l/1000);

            }

            @Override
            public void onFinish() {
                sure.setText("SÜRE BİTTİ!");
                if(muzik){
                oyunMuzik.stop();
                oyunBitti.stop();
                sureBitti.start();}
                v101.setEnabled(false);
                v102.setEnabled(false);
                v103.setEnabled(false);
                v104.setEnabled(false);
                v105.setEnabled(false);
                v106.setEnabled(false);
                v107.setEnabled(false);
                v108.setEnabled(false);
                v109.setEnabled(false);
                v110.setEnabled(false);
                v111.setEnabled(false);
                v112.setEnabled(false);
                v113.setEnabled(false);
                v114.setEnabled(false);
                v115.setEnabled(false);
                v116.setEnabled(false);
                v117.setEnabled(false);
                v118.setEnabled(false);
                v201.setEnabled(false);
                v202.setEnabled(false);
                v203.setEnabled(false);
                v204.setEnabled(false);
                v205.setEnabled(false);
                v206.setEnabled(false);
                v207.setEnabled(false);
                v208.setEnabled(false);
                v209.setEnabled(false);
                v210.setEnabled(false);
                v211.setEnabled(false);
                v212.setEnabled(false);
                v213.setEnabled(false);
                v214.setEnabled(false);
                v215.setEnabled(false);
                v216.setEnabled(false);
                v217.setEnabled(false);
                v218.setEnabled(false);
                AlertDialog.Builder alert = new AlertDialog.Builder(CokLevel3Activity.this);
                alert.setTitle("RESTART?");
                alert.setMessage("Tekrardan başlamak için yes seçim ekranı için no butonuna tıklayınız?");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(CokLevel3Activity.this,SecimActivity.class);
                        finish();
                        startActivity(intent);
                    }
                });
                alert.show();
            }
        }.start();
    }
    public void vericek1(){
        firebaseFirestore.collection("Gryffindor")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            int i =0;
                            for (QueryDocumentSnapshot document : task.getResult() ){

                                data = document.getData();
                                String resim = (String) data.get("resim");

                                byte [] decodeString = Base64.decode(resim,Base64.DEFAULT);
                                Bitmap decoded = BitmapFactory.decodeByteArray(decodeString, 0,decodeString.length);
                                if(i == e1k1){
                                    puan1 = (String) data.get("puan");
                                    puan11 = Double.parseDouble(puan1);
                                    if(tik101){
                                        v101.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter1 +" "+puan1+" Gryffindor", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik201){
                                        v201.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter1 +" "+puan1+" Gryffindor", Toast.LENGTH_SHORT).show();
                                    }

                                }if(i == e1k2) {
                                    puan2 = (String) data.get("puan");
                                    puan22 = Double.parseDouble(puan2);
                                    if (tik102) {
                                        v102.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter2 +" "+puan2+" Gryffindor", Toast.LENGTH_SHORT).show();
                                    }
                                    if (tik202) {
                                        v202.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter2 +" "+puan2+" Gryffindor", Toast.LENGTH_SHORT).show();
                                    }
                                }if(i == e1k3){
                                    puan3 = (String) data.get("puan");
                                    puan33 = Double.parseDouble(puan3);
                                    if(tik103){
                                        v103.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter3 +" "+puan3+" Gryffindor", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik203){
                                        v203.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter3 +" "+puan3+" Gryffindor", Toast.LENGTH_SHORT).show();
                                    }
                                }if(i == e1k4){
                                    puan4 = (String) data.get("puan");
                                    puan44 = Double.parseDouble(puan4);
                                    if(tik104){
                                        v104.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter4 +" "+puan4+" Gryffindor", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik204){
                                        v204.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter4 +" "+puan4+" Gryffindor", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                i +=1;
                            }
                        }else {
                            Log.w(TAG, "error", task.getException());
                        }
                    }
                });
    }
    public void vericek2(){
        firebaseFirestore.collection("Slytherin")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            int i =0;
                            for (QueryDocumentSnapshot document : task.getResult() ){

                                data = document.getData();
                                String resim = (String) data.get("resim");

                                byte [] decodeString = Base64.decode(resim,Base64.DEFAULT);
                                Bitmap decoded = BitmapFactory.decodeByteArray(decodeString, 0,decodeString.length);
                                if(i == e2k1){
                                    puan5 = (String) data.get("puan");
                                    puan55 = Double.parseDouble(puan5);
                                    if(tik105){
                                        v105.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter5 +" "+puan5+" Slytherin", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik205){
                                        v205.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter5 +" "+puan5+" Slytherin", Toast.LENGTH_SHORT).show();
                                    }

                                }if(i == e2k2){
                                    puan6 = (String) data.get("puan");
                                    puan66 = Double.parseDouble(puan6);
                                    if(tik106){
                                        v106.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter6 +" "+puan6+" Slytherin", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik206){
                                        v206.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter6 +" "+puan6+" Slytherin", Toast.LENGTH_SHORT).show();
                                    }
                                }if(i == e2k3){
                                    puan7 = (String) data.get("puan");
                                    puan77 = Double.parseDouble(puan7);
                                    if(tik107){
                                        v107.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter7 +" "+puan7+" Slytherin", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik207){
                                        v207.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter7 +" "+puan7+" Slytherin", Toast.LENGTH_SHORT).show();
                                    }
                                }if(i == e2k4){
                                    puan8 = (String) data.get("puan");
                                    puan88 = Double.parseDouble(puan8);
                                    if(tik108){
                                        v108.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter8 +" "+puan8+" Slytherin", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik208){
                                        v208.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter8 +" "+puan8+" Slytherin", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                i +=1;
                            }
                        }else {
                            Log.w(TAG, "error", task.getException());
                        }
                    }
                });
    }
    public void vericek3(){
        firebaseFirestore.collection("Hufflepuff")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            int i =0;
                            for (QueryDocumentSnapshot document : task.getResult() ){

                                data = document.getData();
                                String resim = (String) data.get("resim");

                                byte [] decodeString = Base64.decode(resim,Base64.DEFAULT);
                                Bitmap decoded = BitmapFactory.decodeByteArray(decodeString, 0,decodeString.length);
                                if(i == e3k1){
                                    puan9 = (String) data.get("puan");
                                    puan99 = Double.parseDouble(puan9);
                                    if(tik109){
                                        v109.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter9 +" "+puan9+" Hufflepuff", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik209){
                                        v209.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter9 +" "+puan9+" Hufflepuff", Toast.LENGTH_SHORT).show();
                                    }

                                }if(i == e3k2){
                                    puan0 = (String) data.get("puan");
                                    puan00 = Double.parseDouble(puan0);
                                    if(tik110){
                                        v110.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter10 +" "+puan0+" Hufflepuff", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik210){
                                        v210.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter10 +" "+puan0+" Hufflepuff", Toast.LENGTH_SHORT).show();
                                    }
                                }if(i == e3k3){
                                    puan01 = (String) data.get("puan");
                                    puan011 = Double.parseDouble(puan01);
                                    if(tik111){
                                        v111.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter11 +" "+puan01+" Hufflepuff", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik211){
                                        v211.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter11 +" "+puan01+" Hufflepuff", Toast.LENGTH_SHORT).show();
                                    }
                                }if(i == e3k4){
                                    puan02 = (String) data.get("puan");
                                    puan022 = Double.parseDouble(puan02);
                                    if(tik112){
                                        v112.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter12 +" "+puan02+" Hufflepuff", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik212){
                                        v212.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter12 +" "+puan02+" Hufflepuff", Toast.LENGTH_SHORT).show();
                                    }
                                }if(i == e3k5){
                                    puan03 = (String) data.get("puan");
                                    puan033 = Double.parseDouble(puan03);
                                    if(tik113){
                                        v113.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter13 +" "+puan03+" Hufflepuff", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik213){
                                        v213.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter13 +" "+puan03+" Hufflepuff", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                i +=1;
                            }
                        }else {
                            Log.w(TAG, "error", task.getException());
                        }
                    }
                });
    }
    public void vericek4(){
        firebaseFirestore.collection("Ravenclaw")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            int i =0;
                            for (QueryDocumentSnapshot document : task.getResult() ){

                                data = document.getData();
                                String resim = (String) data.get("resim");

                                byte [] decodeString = Base64.decode(resim,Base64.DEFAULT);
                                Bitmap decoded = BitmapFactory.decodeByteArray(decodeString, 0,decodeString.length);
                                if(i == e4k1){
                                    puan04 = (String) data.get("puan");
                                    puan044 = Double.parseDouble(puan04);
                                    if(tik114){
                                        v114.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter14 +" "+puan04+" Ravenclaw", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik214){
                                        v214.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter14 +" "+puan04+" Ravenclaw", Toast.LENGTH_SHORT).show();
                                    }
                                }if(i == e4k2){
                                    puan05 = (String) data.get("puan");
                                    puan055 = Double.parseDouble(puan05);
                                    if(tik115){
                                        v115.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter15 +" "+puan05+" Ravenclaw", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik215){
                                        v215.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter15 +" "+puan05+" Ravenclaw", Toast.LENGTH_SHORT).show();
                                    }
                                }if(i == e4k3){
                                    puan06 = (String) data.get("puan");
                                    puan066 = Double.parseDouble(puan06);
                                    if(tik116){
                                        v116.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter16 +" "+puan06+" Ravenclaw", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik216){
                                        v216.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter16 +" "+puan06+" Ravenclaw", Toast.LENGTH_SHORT).show();
                                    }
                                }if(i == e4k4){
                                    puan07 = (String) data.get("puan");
                                    puan077 = Double.parseDouble(puan07);
                                    if(tik117){
                                        v117.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter17 +" "+puan07+" Ravenclaw", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik217){
                                        v217.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter17 +" "+puan07+" Ravenclaw", Toast.LENGTH_SHORT).show();
                                    }
                                }if(i == e4k5){
                                    puan08 = (String) data.get("puan");
                                    puan088 = Double.parseDouble(puan08);
                                    if(tik118){
                                        v118.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter18 +" "+puan08+" Ravenclaw", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik218){
                                        v218.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel3Activity.this,karakter18 +" "+puan08+" Ravenclaw", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                i +=1;
                            }
                        }else {
                            Log.w(TAG, "error", task.getException());
                        }
                    }
                });
    }
}