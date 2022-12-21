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

public class CokLevel2Activity extends AppCompatActivity {

    long kalansure;
    double sonSkor=0.0,sonSkor2=0.0,etki;
    String puan1,puan2,puan3,puan4,puan5,puan6,puan7,puan8;
    double puan11,puan22,puan33,puan44,puan55,puan66,puan77,puan88;
    TextView sure;
    TextView skor,skor2;
    MediaPlayer oyunMuzik,dogruMuzik,oyunBitti,sureBitti;
    ImageView v11,v12,v13,v14,v15,v16,v17,v18,
            v21,v22,v23,v24,v25,v26,v27,v28;
    int e1k1,e1k2,e2k1,e2k2,e3k1,e3k2,e4k1,e4k2;
    int sira =1,donusum;
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    Map<String, Object> data;
    Boolean tik11 = false, tik12 = false,tik13 = false,tik14 = false,
            tik15 = false,tik16 = false,tik17 = false,tik18 = false,
            tik21= false, tik22= false,tik23= false,tik24= false,
            tik25= false,tik26= false,tik27= false,tik28= false;
    ArrayList<Integer> kartlar = new ArrayList<>();
    Switch switchSes;
    boolean muzik;
    String karakter1,karakter2,karakter3,karakter4,karakter5,karakter6,
            karakter7,karakter8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cok_level2);
        switchSes = findViewById(R.id.switchCok2);

        oyunMuzik = MediaPlayer.create(CokLevel2Activity.this,R.raw.oyunmuzik);
        dogruMuzik = MediaPlayer.create(CokLevel2Activity.this,R.raw.dogrumuzik);
        oyunBitti = MediaPlayer.create(CokLevel2Activity.this,R.raw.oyunbitti);
        sureBitti = MediaPlayer.create(CokLevel2Activity.this,R.raw.surebittimuzik);
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
        Collections.shuffle(kartlar);


        sure = findViewById(R.id.sure);
        skor = findViewById(R.id.skor);
        skor2 = findViewById(R.id.skor2);
        v11 = (ImageView) findViewById(kartlar.get(0));
        v12 = (ImageView) findViewById(kartlar.get(1));
        v13 = (ImageView) findViewById(kartlar.get(2));
        v14 = (ImageView) findViewById(kartlar.get(3));
        v15 = (ImageView) findViewById(kartlar.get(4));
        v16 = (ImageView) findViewById(kartlar.get(5));
        v17 = (ImageView) findViewById(kartlar.get(6));
        v18 = (ImageView) findViewById(kartlar.get(7));
        v21 = (ImageView) findViewById(kartlar.get(8));
        v22 = (ImageView) findViewById(kartlar.get(9));
        v23 = (ImageView) findViewById(kartlar.get(10));
        v24 = (ImageView) findViewById(kartlar.get(11));
        v25 = (ImageView) findViewById(kartlar.get(12));
        v26 = (ImageView) findViewById(kartlar.get(13));
        v27 = (ImageView) findViewById(kartlar.get(14));
        v28 = (ImageView) findViewById(kartlar.get(15));



        random();

        v11.setImageResource(R.drawable.arkayuzguncel);
        v12.setImageResource(R.drawable.arkayuzguncel);
        v13.setImageResource(R.drawable.arkayuzguncel);
        v14.setImageResource(R.drawable.arkayuzguncel);
        v15.setImageResource(R.drawable.arkayuzguncel);
        v16.setImageResource(R.drawable.arkayuzguncel);
        v17.setImageResource(R.drawable.arkayuzguncel);
        v18.setImageResource(R.drawable.arkayuzguncel);
        v21.setImageResource(R.drawable.arkayuzguncel);
        v22.setImageResource(R.drawable.arkayuzguncel);
        v23.setImageResource(R.drawable.arkayuzguncel);
        v24.setImageResource(R.drawable.arkayuzguncel);
        v25.setImageResource(R.drawable.arkayuzguncel);
        v26.setImageResource(R.drawable.arkayuzguncel);
        v27.setImageResource(R.drawable.arkayuzguncel);
        v28.setImageResource(R.drawable.arkayuzguncel);

        v11.setEnabled(false);
        v12.setEnabled(false);
        v13.setEnabled(false);
        v14.setEnabled(false);
        v15.setEnabled(false);
        v16.setEnabled(false);
        v17.setEnabled(false);
        v18.setEnabled(false);
        v21.setEnabled(false);
        v22.setEnabled(false);
        v23.setEnabled(false);
        v24.setEnabled(false);
        v25.setEnabled(false);
        v26.setEnabled(false);
        v27.setEnabled(false);
        v28.setEnabled(false);
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
    public void kontrol() {
        if (tik11 && tik12) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v11.setImageResource(R.drawable.arkayuzguncel);
                    v12.setImageResource(R.drawable.arkayuzguncel);
                    tik11 = false;
                    tik12 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan11 + puan22) / 2.0);
                    siraYanlis();
                }
            }, 800);
        }
        if (tik11 && tik13) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v11.setImageResource(R.drawable.arkayuzguncel);
                    v13.setImageResource(R.drawable.arkayuzguncel);
                    tik11 = false;
                    tik13 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan11 + puan33) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik11 && tik14) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v11.setImageResource(R.drawable.arkayuzguncel);
                    v14.setImageResource(R.drawable.arkayuzguncel);
                    tik11 = false;
                    tik14 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan11 + puan44) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik11 && tik15) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v11.setImageResource(R.drawable.arkayuzguncel);
                    v15.setImageResource(R.drawable.arkayuzguncel);
                    tik11 = false;
                    tik15 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan11 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik11 && tik16) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v11.setImageResource(R.drawable.arkayuzguncel);
                    v16.setImageResource(R.drawable.arkayuzguncel);
                    tik11 = false;
                    tik16 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 1 ikinci evin 2 katsayılı olma durumu
                    etki = ((((puan11 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik11 && tik17) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v11.setImageResource(R.drawable.arkayuzguncel);
                    v17.setImageResource(R.drawable.arkayuzguncel);
                    tik11 = false;
                    tik17 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 1 ikinci evin 2 katsayılı olma durumu
                    etki = ((((puan11 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik11 && tik18) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v11.setImageResource(R.drawable.arkayuzguncel);
                    v18.setImageResource(R.drawable.arkayuzguncel);
                    tik11 = false;
                    tik18 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 1 ikinci evin 2 katsayılı olma durumu
                    etki = ((((puan11 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik11 && tik21) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v11.setVisibility(View.INVISIBLE);
                    v21.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik11 = false;
                    tik21 = false;
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
                    etki = ((4*puan11));
                    siraDoğru();
                }
            },800);
        }
        if (tik11 && tik22) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v11.setImageResource(R.drawable.arkayuzguncel);
                    v22.setImageResource(R.drawable.arkayuzguncel);
                    tik11 = false;
                    tik22 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan11 + puan22) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik11 && tik23) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v11.setImageResource(R.drawable.arkayuzguncel);
                    v23.setImageResource(R.drawable.arkayuzguncel);
                    tik11 = false;
                    tik23 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan11 + puan33) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik11 && tik24) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v11.setImageResource(R.drawable.arkayuzguncel);
                    v24.setImageResource(R.drawable.arkayuzguncel);
                    tik11 = false;
                    tik24 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan11 + puan44) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik11 && tik25) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v11.setImageResource(R.drawable.arkayuzguncel);
                    v25.setImageResource(R.drawable.arkayuzguncel);
                    tik11 = false;
                    tik25 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan11 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik11 && tik26) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v11.setImageResource(R.drawable.arkayuzguncel);
                    v26.setImageResource(R.drawable.arkayuzguncel);
                    tik11 = false;
                    tik26 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan11 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik11 && tik27) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v11.setImageResource(R.drawable.arkayuzguncel);
                    v27.setImageResource(R.drawable.arkayuzguncel);
                    tik11 = false;
                    tik27 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan11 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik11 && tik28) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v11.setImageResource(R.drawable.arkayuzguncel);
                    v28.setImageResource(R.drawable.arkayuzguncel);
                    tik11 = false;
                    tik28 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan11 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }

        if (tik12 && tik13) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v12.setImageResource(R.drawable.arkayuzguncel);
                    v13.setImageResource(R.drawable.arkayuzguncel);
                    tik12 = false;
                    tik13 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan33 + puan22) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik12 && tik14) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v12.setImageResource(R.drawable.arkayuzguncel);
                    v14.setImageResource(R.drawable.arkayuzguncel);
                    tik12 = false;
                    tik14 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan44 + puan22) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik12 && tik15) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v12.setImageResource(R.drawable.arkayuzguncel);
                    v15.setImageResource(R.drawable.arkayuzguncel);
                    tik12 = false;
                    tik15 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik12 && tik16) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v12.setImageResource(R.drawable.arkayuzguncel);
                    v16.setImageResource(R.drawable.arkayuzguncel);
                    tik12 = false;
                    tik16 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 1 ikinci evin 2 katsayılı olma durumu
                    etki = ((((puan66 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik12 && tik17) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v12.setImageResource(R.drawable.arkayuzguncel);
                    v17.setImageResource(R.drawable.arkayuzguncel);
                    tik12 = false;
                    tik17 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 1 ikinci evin 2 katsayılı olma durumu
                    etki = ((((puan77 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik12 && tik18) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v12.setImageResource(R.drawable.arkayuzguncel);
                    v18.setImageResource(R.drawable.arkayuzguncel);
                    tik12 = false;
                    tik18 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 1 ikinci evin 2 katsayılı olma durumu
                    etki = ((((puan88 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik12 && tik22) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v12.setVisibility(View.INVISIBLE);
                    v22.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik12 = false;
                    tik22 = false;
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
                    etki = ((4*puan22));
                    siraDoğru();
                }
            },800);
        }
        if (tik12 && tik21) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v12.setImageResource(R.drawable.arkayuzguncel);
                    v21.setImageResource(R.drawable.arkayuzguncel);
                    tik12 = false;
                    tik21 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan11 + puan22) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik12 && tik23) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v12.setImageResource(R.drawable.arkayuzguncel);
                    v23.setImageResource(R.drawable.arkayuzguncel);
                    tik12 = false;
                    tik23 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan33 + puan22) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik12 && tik24) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v12.setImageResource(R.drawable.arkayuzguncel);
                    v24.setImageResource(R.drawable.arkayuzguncel);
                    tik12 = false;
                    tik24 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan44 + puan22) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik12 && tik25) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v12.setImageResource(R.drawable.arkayuzguncel);
                    v25.setImageResource(R.drawable.arkayuzguncel);
                    tik12 = false;
                    tik25 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik12 && tik26) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v12.setImageResource(R.drawable.arkayuzguncel);
                    v26.setImageResource(R.drawable.arkayuzguncel);
                    tik12 = false;
                    tik26 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan66 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik12 && tik27) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v12.setImageResource(R.drawable.arkayuzguncel);
                    v27.setImageResource(R.drawable.arkayuzguncel);
                    tik12 = false;
                    tik27 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan77 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik12 && tik28) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v12.setImageResource(R.drawable.arkayuzguncel);
                    v28.setImageResource(R.drawable.arkayuzguncel);
                    tik12 = false;
                    tik28 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan88 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik13 && tik14) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v13.setImageResource(R.drawable.arkayuzguncel);
                    v14.setImageResource(R.drawable.arkayuzguncel);
                    tik13 = false;
                    tik14 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan33 + puan44) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik13 && tik15) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v13.setImageResource(R.drawable.arkayuzguncel);
                    v15.setImageResource(R.drawable.arkayuzguncel);
                    tik13 = false;
                    tik15 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan33 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik13 && tik16) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v13.setImageResource(R.drawable.arkayuzguncel);
                    v16.setImageResource(R.drawable.arkayuzguncel);
                    tik13 = false;
                    tik16 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 1 ikinci evin 2 katsayılı olma durumu
                    etki = ((((puan33 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik13 && tik17) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v13.setImageResource(R.drawable.arkayuzguncel);
                    v17.setImageResource(R.drawable.arkayuzguncel);
                    tik13 = false;
                    tik17 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 1 ikinci evin 2 katsayılı olma durumu
                    etki = ((((puan33 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik13 && tik18) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v13.setImageResource(R.drawable.arkayuzguncel);
                    v18.setImageResource(R.drawable.arkayuzguncel);
                    tik13 = false;
                    tik18 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 1 ikinci evin 2 katsayılı olma durumu
                    etki = ((((puan33 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik13 && tik21) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v13.setImageResource(R.drawable.arkayuzguncel);
                    v21.setImageResource(R.drawable.arkayuzguncel);
                    tik13 = false;
                    tik21 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan11 + puan33) / 2.0)*4) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik13 && tik22) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v13.setImageResource(R.drawable.arkayuzguncel);
                    v22.setImageResource(R.drawable.arkayuzguncel);
                    tik13 = false;
                    tik22 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan33 + puan22) / 2.0)*4) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik13 && tik23) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v13.setVisibility(View.INVISIBLE);
                    v23.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik13 = false;
                    tik23 = false;
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
                    etki = ((4*puan33));
                    siraDoğru();
                }
            },800);
        }
        if (tik13 && tik24) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v13.setImageResource(R.drawable.arkayuzguncel);
                    v24.setImageResource(R.drawable.arkayuzguncel);
                    tik13 = false;
                    tik24 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan33 + puan44) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik13 && tik25) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v13.setImageResource(R.drawable.arkayuzguncel);
                    v25.setImageResource(R.drawable.arkayuzguncel);
                    tik13 = false;
                    tik25 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan33 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik13 && tik26) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v13.setImageResource(R.drawable.arkayuzguncel);
                    v26.setImageResource(R.drawable.arkayuzguncel);
                    tik13 = false;
                    tik26 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan33 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik13 && tik27) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v13.setImageResource(R.drawable.arkayuzguncel);
                    v27.setImageResource(R.drawable.arkayuzguncel);
                    tik13 = false;
                    tik27 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan33 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik13 && tik28) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v13.setImageResource(R.drawable.arkayuzguncel);
                    v28.setImageResource(R.drawable.arkayuzguncel);
                    tik13 = false;
                    tik28 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan33 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik14 && tik15) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v14.setImageResource(R.drawable.arkayuzguncel);
                    v15.setImageResource(R.drawable.arkayuzguncel);
                    tik14 = false;
                    tik15 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan44 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik14 && tik16) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v14.setImageResource(R.drawable.arkayuzguncel);
                    v16.setImageResource(R.drawable.arkayuzguncel);
                    tik14 = false;
                    tik16 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 1 ikinci evin 2 katsayılı olma durumu
                    etki = ((((puan44 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik14 && tik17) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v14.setImageResource(R.drawable.arkayuzguncel);
                    v17.setImageResource(R.drawable.arkayuzguncel);
                    tik14 = false;
                    tik17 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //birinci evin 1 ikinci evin 2 katsayılı olma durumu
                    etki = ((((puan44 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik14 && tik18) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v14.setImageResource(R.drawable.arkayuzguncel);
                    v18.setImageResource(R.drawable.arkayuzguncel);
                    tik14 = false;
                    tik18 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 1 ikinci evin 2 katsayılı olma durumu
                    etki = ((((puan44 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik14 && tik21) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v14.setImageResource(R.drawable.arkayuzguncel);
                    v21.setImageResource(R.drawable.arkayuzguncel);
                    tik14 = false;
                    tik21 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan11 + puan44) / 2.0)*4) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik14 && tik22) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v14.setImageResource(R.drawable.arkayuzguncel);
                    v22.setImageResource(R.drawable.arkayuzguncel);
                    tik14 = false;
                    tik22 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan44 + puan22) / 2.0)*4) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik14 && tik23) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v14.setImageResource(R.drawable.arkayuzguncel);
                    v23.setImageResource(R.drawable.arkayuzguncel);
                    tik14 = false;
                    tik23 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan44 + puan33) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik14 && tik24) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v14.setVisibility(View.INVISIBLE);
                    v24.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik14 = false;
                    tik24 = false;
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
                    etki = ((4*puan44));
                    siraDoğru();
                }
            },800);
        }
        if (tik14 && tik25) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v14.setImageResource(R.drawable.arkayuzguncel);
                    v25.setImageResource(R.drawable.arkayuzguncel);
                    tik14 = false;
                    tik25 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan44 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik14 && tik26) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v14.setImageResource(R.drawable.arkayuzguncel);
                    v26.setImageResource(R.drawable.arkayuzguncel);
                    tik14 = false;
                    tik26 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan44 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik14 && tik27) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v14.setImageResource(R.drawable.arkayuzguncel);
                    v27.setImageResource(R.drawable.arkayuzguncel);
                    tik14 = false;
                    tik27 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan44 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik14 && tik28) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v14.setImageResource(R.drawable.arkayuzguncel);
                    v28.setImageResource(R.drawable.arkayuzguncel);
                    tik14 = false;
                    tik28 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan44 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik15 && tik16) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v15.setImageResource(R.drawable.arkayuzguncel);
                    v16.setImageResource(R.drawable.arkayuzguncel);
                    tik15 = false;
                    tik16 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan55 + puan66) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik15 && tik17) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v15.setImageResource(R.drawable.arkayuzguncel);
                    v17.setImageResource(R.drawable.arkayuzguncel);
                    tik15 = false;
                    tik17 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan55 + puan77) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik15 && tik18) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v15.setImageResource(R.drawable.arkayuzguncel);
                    v18.setImageResource(R.drawable.arkayuzguncel);
                    tik15 = false;
                    tik18 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan55 + puan88) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik15 && tik21) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v15.setImageResource(R.drawable.arkayuzguncel);
                    v21.setImageResource(R.drawable.arkayuzguncel);
                    tik15 = false;
                    tik21 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan11) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik15 && tik22) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v15.setImageResource(R.drawable.arkayuzguncel);
                    v22.setImageResource(R.drawable.arkayuzguncel);
                    tik15 = false;
                    tik22 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik15 && tik23) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v15.setImageResource(R.drawable.arkayuzguncel);
                    v23.setImageResource(R.drawable.arkayuzguncel);
                    tik15 = false;
                    tik23 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan33) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik15 && tik24) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v15.setImageResource(R.drawable.arkayuzguncel);
                    v24.setImageResource(R.drawable.arkayuzguncel);
                    tik15 = false;
                    tik24 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan44) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik15 && tik25) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v15.setVisibility(View.INVISIBLE);
                    v25.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik15 = false;
                    tik25 = false;
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
                    etki = ((1*puan55));
                    siraDoğru();
                }
            },800);
        }
        if (tik15 && tik26) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v15.setImageResource(R.drawable.arkayuzguncel);
                    v26.setImageResource(R.drawable.arkayuzguncel);
                    tik15 = false;
                    tik26 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan55 + puan66) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik15 && tik27) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v15.setImageResource(R.drawable.arkayuzguncel);
                    v27.setImageResource(R.drawable.arkayuzguncel);
                    tik15 = false;
                    tik27 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan55 + puan77) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik15 && tik28) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v15.setImageResource(R.drawable.arkayuzguncel);
                    v28.setImageResource(R.drawable.arkayuzguncel);
                    tik15 = false;
                    tik28 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan55 + puan88) / 2.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik16 && tik17) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v16.setImageResource(R.drawable.arkayuzguncel);
                    v17.setImageResource(R.drawable.arkayuzguncel);
                    tik16 = false;
                    tik17 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan66 + puan77) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik16 && tik18) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v16.setImageResource(R.drawable.arkayuzguncel);
                    v18.setImageResource(R.drawable.arkayuzguncel);
                    tik16 = false;
                    tik18 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //yanlış eşleştirmede kartların farklı evlerden olma durumu
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan66 + puan88) / 2) * 1) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik16 && tik21) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v16.setImageResource(R.drawable.arkayuzguncel);
                    v21.setImageResource(R.drawable.arkayuzguncel);
                    tik16 = false;
                    tik21 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan66 + puan11) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik16 && tik22) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v16.setImageResource(R.drawable.arkayuzguncel);
                    v22.setImageResource(R.drawable.arkayuzguncel);
                    tik16 = false;
                    tik22 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan66 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik16 && tik23) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v16.setImageResource(R.drawable.arkayuzguncel);
                    v23.setImageResource(R.drawable.arkayuzguncel);
                    tik16 = false;
                    tik23 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan66 + puan33) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik16 && tik24) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v16.setImageResource(R.drawable.arkayuzguncel);
                    v24.setImageResource(R.drawable.arkayuzguncel);
                    tik16 = false;
                    tik24 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan66 + puan44) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik16 && tik25) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v16.setImageResource(R.drawable.arkayuzguncel);
                    v25.setImageResource(R.drawable.arkayuzguncel);
                    tik16 = false;
                    tik25 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan66 + puan55) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik16 && tik26) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v16.setVisibility(View.INVISIBLE);
                    v26.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik16 = false;
                    tik26 = false;
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
                    etki = ((1*puan66));
                    siraDoğru();
                }
            },800);
        }
        if (tik16 && tik27) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v16.setImageResource(R.drawable.arkayuzguncel);
                    v27.setImageResource(R.drawable.arkayuzguncel);
                    tik16 = false;
                    tik27 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan66 + puan77) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik16 && tik28) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v16.setImageResource(R.drawable.arkayuzguncel);
                    v28.setImageResource(R.drawable.arkayuzguncel);
                    tik16 = false;
                    tik28 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan66 + puan88) / 2.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik17 && tik18) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v17.setImageResource(R.drawable.arkayuzguncel);
                    v18.setImageResource(R.drawable.arkayuzguncel);
                    tik17 = false;
                    tik18 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan77 + puan88) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik17 && tik21) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v17.setImageResource(R.drawable.arkayuzguncel);
                    v21.setImageResource(R.drawable.arkayuzguncel);
                    tik17 = false;
                    tik21 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan11 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik17 && tik22) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v17.setImageResource(R.drawable.arkayuzguncel);
                    v22.setImageResource(R.drawable.arkayuzguncel);
                    tik17 = false;
                    tik22 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan77 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik17 && tik23) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v17.setImageResource(R.drawable.arkayuzguncel);
                    v23.setImageResource(R.drawable.arkayuzguncel);
                    tik17 = false;
                    tik23 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan77 + puan33) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik17 && tik24) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v17.setImageResource(R.drawable.arkayuzguncel);
                    v24.setImageResource(R.drawable.arkayuzguncel);
                    tik17 = false;
                    tik24 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan77 + puan44) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik17 && tik25) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v17.setImageResource(R.drawable.arkayuzguncel);
                    v25.setImageResource(R.drawable.arkayuzguncel);
                    tik17 = false;
                    tik25 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan77 + puan55) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik17 && tik26) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v17.setImageResource(R.drawable.arkayuzguncel);
                    v26.setImageResource(R.drawable.arkayuzguncel);
                    tik17 = false;
                    tik26 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan77 + puan66) / 2.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik17 && tik27) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v17.setVisibility(View.INVISIBLE);
                    v27.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik17 = false;
                    tik27 = false;
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
                    etki = ((1*puan77));
                    siraDoğru();
                }
            },800);
        }
        if (tik17 && tik28) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v17.setImageResource(R.drawable.arkayuzguncel);
                    v28.setImageResource(R.drawable.arkayuzguncel);
                    tik17 = false;
                    tik28 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan77 + puan88) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik18 && tik21) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v18.setImageResource(R.drawable.arkayuzguncel);
                    v21.setImageResource(R.drawable.arkayuzguncel);
                    tik18 = false;
                    tik21 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan11 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik18 && tik22) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v18.setImageResource(R.drawable.arkayuzguncel);
                    v22.setImageResource(R.drawable.arkayuzguncel);
                    tik18 = false;
                    tik22 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan88 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik18 && tik23) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v18.setImageResource(R.drawable.arkayuzguncel);
                    v23.setImageResource(R.drawable.arkayuzguncel);
                    tik18 = false;
                    tik23 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan88 + puan33) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik18 && tik24) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v18.setImageResource(R.drawable.arkayuzguncel);
                    v24.setImageResource(R.drawable.arkayuzguncel);
                    tik18 = false;
                    tik24 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan88 + puan44) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik18 && tik25) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v18.setImageResource(R.drawable.arkayuzguncel);
                    v25.setImageResource(R.drawable.arkayuzguncel);
                    tik18 = false;
                    tik25 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan88 + puan55) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik18 && tik26) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v18.setImageResource(R.drawable.arkayuzguncel);
                    v26.setImageResource(R.drawable.arkayuzguncel);
                    tik18 = false;
                    tik26 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan88 + puan66) / 2.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik18 && tik27) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v18.setImageResource(R.drawable.arkayuzguncel);
                    v27.setImageResource(R.drawable.arkayuzguncel);
                    tik18 = false;
                    tik27 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan88 + puan77) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik18 && tik28) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v18.setVisibility(View.INVISIBLE);
                    v28.setVisibility(View.INVISIBLE);
                    kontrol2();
                    tik18 = false;
                    tik28 = false;
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
                    etki = ((1*puan88));
                    siraDoğru();
                }
            },800);
        }
        if (tik21 && tik22) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v21.setImageResource(R.drawable.arkayuzguncel);
                    v22.setImageResource(R.drawable.arkayuzguncel);
                    tik21 = false;
                    tik22 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan11 + puan22) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik21 && tik23) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v21.setImageResource(R.drawable.arkayuzguncel);
                    v23.setImageResource(R.drawable.arkayuzguncel);
                    tik21 = false;
                    tik23 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan11 + puan33) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik21 && tik24) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v21.setImageResource(R.drawable.arkayuzguncel);
                    v24.setImageResource(R.drawable.arkayuzguncel);
                    tik21 = false;
                    tik24 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan11 + puan44) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik21 && tik25) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v21.setImageResource(R.drawable.arkayuzguncel);
                    v25.setImageResource(R.drawable.arkayuzguncel);
                    tik21 = false;
                    tik25 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan11 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik21 && tik26) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v21.setImageResource(R.drawable.arkayuzguncel);
                    v26.setImageResource(R.drawable.arkayuzguncel);
                    tik21 = false;
                    tik26 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan11 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik21 && tik27) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v21.setImageResource(R.drawable.arkayuzguncel);
                    v27.setImageResource(R.drawable.arkayuzguncel);
                    tik21 = false;
                    tik27 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan11 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik21 && tik28) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v21.setImageResource(R.drawable.arkayuzguncel);
                    v28.setImageResource(R.drawable.arkayuzguncel);
                    tik21 = false;
                    tik28 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan11 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik22 && tik23) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v22.setImageResource(R.drawable.arkayuzguncel);
                    v23.setImageResource(R.drawable.arkayuzguncel);
                    tik22 = false;
                    tik23 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan33 + puan22) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik22 && tik24) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v22.setImageResource(R.drawable.arkayuzguncel);
                    v24.setImageResource(R.drawable.arkayuzguncel);
                    tik22 = false;
                    tik24 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //iki evin katsayısının 2 2 olma durumu
                    etki = ((((puan44 + puan22) / 2) * 4) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik22 && tik25) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v22.setImageResource(R.drawable.arkayuzguncel);
                    v25.setImageResource(R.drawable.arkayuzguncel);
                    tik22 = false;
                    tik25 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan55 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik22 && tik26) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v22.setImageResource(R.drawable.arkayuzguncel);
                    v26.setImageResource(R.drawable.arkayuzguncel);
                    tik22 = false;
                    tik26 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan66 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik22 && tik27) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v22.setImageResource(R.drawable.arkayuzguncel);
                    v27.setImageResource(R.drawable.arkayuzguncel);
                    tik22 = false;
                    tik27 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan77 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik22 && tik28) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v22.setImageResource(R.drawable.arkayuzguncel);
                    v28.setImageResource(R.drawable.arkayuzguncel);
                    tik22 = false;
                    tik28 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan88 + puan22) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik23 && tik24) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v23.setImageResource(R.drawable.arkayuzguncel);
                    v24.setImageResource(R.drawable.arkayuzguncel);
                    tik23 = false;
                    tik24 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //ev katsayısının 2 olma durumu
                    etki = ((puan33 + puan44) / 2.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik23 && tik25) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v23.setImageResource(R.drawable.arkayuzguncel);
                    v25.setImageResource(R.drawable.arkayuzguncel);
                    tik23 = false;
                    tik25 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan33 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik23 && tik26) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v23.setImageResource(R.drawable.arkayuzguncel);
                    v26.setImageResource(R.drawable.arkayuzguncel);
                    tik23 = false;
                    tik26 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan33 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik23 && tik27) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v23.setImageResource(R.drawable.arkayuzguncel);
                    v27.setImageResource(R.drawable.arkayuzguncel);
                    tik23 = false;
                    tik27 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan33 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik23 && tik28) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v23.setImageResource(R.drawable.arkayuzguncel);
                    v28.setImageResource(R.drawable.arkayuzguncel);
                    tik23 = false;
                    tik28 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan33 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik24 && tik25) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v24.setImageResource(R.drawable.arkayuzguncel);
                    v25.setImageResource(R.drawable.arkayuzguncel);
                    tik24 = false;
                    tik25 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //birinci evin 2 ikinci evin 1 katsayılı olma durumu
                    etki = ((((puan44 + puan55) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik24 && tik26) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v24.setImageResource(R.drawable.arkayuzguncel);
                    v26.setImageResource(R.drawable.arkayuzguncel);
                    tik24 = false;
                    tik26 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan44 + puan66) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik24 && tik27) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v24.setImageResource(R.drawable.arkayuzguncel);
                    v27.setImageResource(R.drawable.arkayuzguncel);
                    tik24 = false;
                    tik27 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan44 + puan77) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik24 && tik28) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v24.setImageResource(R.drawable.arkayuzguncel);
                    v28.setImageResource(R.drawable.arkayuzguncel);
                    tik24 = false;
                    tik28 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    etki = ((((puan44 + puan88) / 2) * 2) );
                    siraYanlis();
                }
            }, 800);
        }
        if (tik25 && tik26) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v25.setImageResource(R.drawable.arkayuzguncel);
                    v26.setImageResource(R.drawable.arkayuzguncel);
                    tik25 = false;
                    tik26 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan55 + puan66) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik25 && tik27) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v25.setImageResource(R.drawable.arkayuzguncel);
                    v27.setImageResource(R.drawable.arkayuzguncel);
                    tik25 = false;
                    tik27 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan55 + puan77) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik25 && tik28) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v25.setImageResource(R.drawable.arkayuzguncel);
                    v28.setImageResource(R.drawable.arkayuzguncel);
                    tik25 = false;
                    tik28 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan55 + puan88) / 2.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik26 && tik27) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v26.setImageResource(R.drawable.arkayuzguncel);
                    v27.setImageResource(R.drawable.arkayuzguncel);
                    tik26 = false;
                    tik27 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan66 + puan77) / 1.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik26 && tik28) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v26.setImageResource(R.drawable.arkayuzguncel);
                    v28.setImageResource(R.drawable.arkayuzguncel);
                    tik26 = false;
                    tik28 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = (((puan66 + puan88) / 2.0)*1) ;
                    siraYanlis();
                }
            }, 800);
        }
        if (tik27 && tik28) {
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Seçilen görüntünün eşit olup olmadığını anlamak için bir method
                    v27.setImageResource(R.drawable.arkayuzguncel);
                    v28.setImageResource(R.drawable.arkayuzguncel);
                    tik27 = false;
                    tik28 = false;
                    //kartlar yanlış evleri kontrol edip puan hesaplaması yapılabilir.
                    //evler aynı ise
                    //ev katsayısının 2 olma durumu
                    etki = ((puan77 + puan88) / 1.0) ;
                    siraYanlis();
                }
            }, 800);
        }
    }
    public void kontrol2(){
        if(v11.getVisibility() == View.INVISIBLE
                && v12.getVisibility() == View.INVISIBLE
                && v13.getVisibility() == View.INVISIBLE
                && v14.getVisibility() == View.INVISIBLE
                && v15.getVisibility() == View.INVISIBLE
                && v16.getVisibility() == View.INVISIBLE
                && v17.getVisibility() == View.INVISIBLE
                && v18.getVisibility() == View.INVISIBLE
                && v21.getVisibility() == View.INVISIBLE
                && v22.getVisibility() == View.INVISIBLE
                && v23.getVisibility() == View.INVISIBLE
                && v24.getVisibility() == View.INVISIBLE
                && v25.getVisibility() == View.INVISIBLE
                && v26.getVisibility() == View.INVISIBLE
                && v27.getVisibility() == View.INVISIBLE
                && v28.getVisibility() == View.INVISIBLE){
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
        e1k1 = (int)(Math.random()*(5));
        e1k2 = (int)(Math.random()*(6)+5);
        e2k1 = (int)(Math.random()*(5));
        e2k2 = (int)(Math.random()*(6)+5);
        e3k1 = (int)(Math.random()*(5));
        e3k2 = (int)(Math.random()*(6)+5);
        e4k1 = (int)(Math.random()*(5));
        e4k2 = (int)(Math.random()*(6)+5);
        if(e1k1==0){karakter1 = "Albus Dumbledore";}
        if(e1k1==1){karakter1 = "Arthur Weasley";}
        if(e1k1==2){karakter1 = "Harry Potter";}
        if(e1k1==3){karakter1 = "Hermione Granger";}
        if(e1k1==4){karakter1 = "Lily Potter";}
        if(e1k2==5){karakter2 = "Minerva McGonagall";}
        if(e1k2==6){karakter2 = "Peter Pettigrew";}
        if(e1k2==7){karakter2 = "Remus Lupin";}
        if(e1k2==8){karakter2 = "Ron Weasley";}
        if(e1k2==9){karakter2 = "Rubeus Hagrid";}
        if(e1k2==10){karakter2 = "Sirius Black";}
        if(e2k1==0){karakter3 = "Andromeda Tonks";}
        if(e2k1==1){karakter3 = "Bellatrix Lestrange";}
        if(e2k1==2){karakter3 = "Dolores Umbridge";}
        if(e2k1==3){karakter3 = "Draco Malfoy";}
        if(e2k1==4){karakter3 = "Evan Rosier";}
        if(e2k2==5){karakter4 = "Horace Slughorn";}
        if(e2k2==6){karakter4 = "Leta Lestrange";}
        if(e2k2==7){karakter4 = "Lucius Malfoy";}
        if(e2k2==8){karakter4 = "Narcissa Malfoy";}
        if(e2k2==9){karakter4 = "Severus Snape";}
        if(e2k2==10){karakter4 = "Tom Riddle";}
        if(e3k1==0){karakter5 = "Cedric Diggory";}
        if(e3k1==1){karakter5 = "Ernest Macmillan";}
        if(e3k1==2){karakter5 = "Fat Friar";}
        if(e3k1==3){karakter5 = "Hannah Abbott";}
        if(e3k1==4){karakter5 = "Helga Hufflepuff";}
        if(e3k2==5){karakter6 = "Leanne";}
        if(e3k2==6){karakter6 = "Newt Scamander";}
        if(e3k2==7){karakter6 = "Nymphadora Tonks";}
        if(e3k2==8){karakter6 = "Pomona Sprout";}
        if(e3k2==9){karakter6 = "Silvanus Kettleburn";}
        if(e3k2==10){karakter6 = "Ted Lupin";}
        if(e4k1==0){karakter7 = "Cho Chang";}
        if(e4k1==1){karakter7 = "Filius Flitwick";}
        if(e4k1==2){karakter7 = "Garrick Ollivander";}
        if(e4k1==3){karakter7 = "Gilderoy Lockhart";}
        if(e4k1==4){karakter7 = "Luna Lovegood";}
        if(e4k2==5){karakter8 = "Marcus Belby";}
        if(e4k2==6){karakter8 = "Myrtle Warren";}
        if(e4k2==7){karakter8 = "Padma Patil";}
        if(e4k2==8){karakter8 = "Quirinus Quirrell";}
        if(e4k2==9){karakter8 = "Rowena Ravenclaw";}
        if(e4k2==10){karakter8 = "Sybill Trelawney";}
    }
    public void baslaClicked(View view){

        v11.setEnabled(true);
        v12.setEnabled(true);
        v13.setEnabled(true);
        v14.setEnabled(true);
        v15.setEnabled(true);
        v16.setEnabled(true);
        v17.setEnabled(true);
        v18.setEnabled(true);
        v21.setEnabled(true);
        v22.setEnabled(true);
        v23.setEnabled(true);
        v24.setEnabled(true);
        v25.setEnabled(true);
        v26.setEnabled(true);
        v27.setEnabled(true);
        v28.setEnabled(true);

        v11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek1();
                tik11= true;
                kontrol();
            }
        });
        v12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek1();
                tik12= true;
                kontrol();
            }
        });
        v13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek2();
                tik13= true;
                kontrol();
            }
        });
        v14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek2();
                tik14= true;
                kontrol();
            }
        });
        v15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek3();
                tik15= true;
                kontrol();
            }
        });
        v16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek3();
                tik16= true;
                kontrol();
            }
        });
        v17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek4();
                tik17= true;
                kontrol();
            }
        });
        v18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek4();
                tik18= true;
                kontrol();
            }
        });
        v21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek1();
                tik21= true;
                kontrol();
            }
        });
        v22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek1();
                tik22=true;
                kontrol();

            }
        });
        v23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek2();
                tik23=true;
                kontrol();

            }
        });
        v24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek2();
                tik24=true;
                kontrol();

            }
        });
        v25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek3();
                tik25=true;
                kontrol();

            }
        });
        v26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek3();
                tik26=true;
                kontrol();

            }
        });
        v27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek4();
                tik27=true;
                kontrol();

            }
        });
        v28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vericek4();
                tik28=true;
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
                v11.setEnabled(false);
                v12.setEnabled(false);
                v13.setEnabled(false);
                v14.setEnabled(false);
                v15.setEnabled(false);
                v16.setEnabled(false);
                v17.setEnabled(false);
                v18.setEnabled(false);
                v21.setEnabled(false);
                v22.setEnabled(false);
                v23.setEnabled(false);
                v24.setEnabled(false);
                v25.setEnabled(false);
                v26.setEnabled(false);
                v27.setEnabled(false);
                v28.setEnabled(false);
                AlertDialog.Builder alert = new AlertDialog.Builder(CokLevel2Activity.this);
                alert.setTitle("RESTART?");
                alert.setMessage("Tekrardan başlamak için yes sonraki seviye için no butonuna tıklayınız?");
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
                        Intent intent = new Intent(CokLevel2Activity.this,CokLevel3Activity.class);
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
                                    if(tik11){
                                        v11.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel2Activity.this,karakter1 +" "+puan1+" Gryffindor", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik21){
                                        v21.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel2Activity.this,karakter1 +" "+puan1+" Gryffindor", Toast.LENGTH_SHORT).show();
                                    }

                                }if(i == e1k2){
                                    puan2 = (String) data.get("puan");
                                    puan22 = Double.parseDouble(puan2);
                                    if(tik12){
                                        v12.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel2Activity.this,karakter2 +" "+puan2+" Gryffindor", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik22){
                                        v22.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel2Activity.this,karakter2 +" "+puan2+" Gryffindor", Toast.LENGTH_SHORT).show();
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
                                    puan3 = (String) data.get("puan");
                                    puan33 = Double.parseDouble(puan3);
                                    if(tik13){
                                        v13.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel2Activity.this,karakter3 +" "+puan3+" Slytherin", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik23){
                                        v23.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel2Activity.this,karakter3 +" "+puan3+" Slytherin", Toast.LENGTH_SHORT).show();
                                    }

                                }if(i == e2k2){
                                    puan4 = (String) data.get("puan");
                                    puan44 = Double.parseDouble(puan4);
                                    if(tik14){
                                        v14.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel2Activity.this,karakter4 +" "+puan4+" Slytherin", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik24){
                                        v24.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel2Activity.this,karakter4 +" "+puan4+" Slytherin", Toast.LENGTH_SHORT).show();
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
                                    puan5 = (String) data.get("puan");
                                    puan55 = Double.parseDouble(puan5);
                                    if(tik15){
                                        v15.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel2Activity.this,karakter5 +" "+puan5+" Hufflepuff", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik25){
                                        v25.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel2Activity.this,karakter5 +" "+puan5+" Hufflepuff", Toast.LENGTH_SHORT).show();
                                    }

                                }if(i == e3k2){
                                    puan6 = (String) data.get("puan");
                                    puan66 = Double.parseDouble(puan6);
                                    if(tik16){
                                        v16.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel2Activity.this,karakter6 +" "+puan6+" Hufflepuff", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik26){
                                        v26.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel2Activity.this,karakter6 +" "+puan6+" Hufflepuff", Toast.LENGTH_SHORT).show();
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
                                    puan7 = (String) data.get("puan");
                                    puan77 = Double.parseDouble(puan7);
                                    if(tik17){
                                        v17.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel2Activity.this,karakter7 +" "+puan7+" Ravenclaw", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik27){
                                        v27.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel2Activity.this,karakter7 +" "+puan7+" Ravenclaw", Toast.LENGTH_SHORT).show();
                                    }

                                }if(i == e4k2){
                                    puan8 = (String) data.get("puan");
                                    puan88 = Double.parseDouble(puan8);
                                    if(tik18){
                                        v18.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel2Activity.this,karakter8 +" "+puan8+" Ravenclaw", Toast.LENGTH_SHORT).show();
                                    }
                                    if(tik28){
                                        v28.setImageBitmap(decoded);
                                        Toast.makeText(CokLevel2Activity.this,karakter8 +" "+puan8+" Ravenclaw", Toast.LENGTH_SHORT).show();
                                    }}
                                i +=1;}}else {
                            Log.w(TAG, "error", task.getException());
                        }}});}
}