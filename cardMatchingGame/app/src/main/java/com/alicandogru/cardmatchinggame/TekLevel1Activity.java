package com.alicandogru.cardmatchinggame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import static android.content.ContentValues.TAG;
import java.lang.Math;
import androidx.annotation.NonNull;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

public class TekLevel1Activity extends AppCompatActivity {

    long kalansure;
    double sonSkor=0.0,etki,puan11,puan22;
    String puan1,puan2;
    TextView sure,skor;
    MediaPlayer oyunMuzik,dogruMuzik,oyunBitti,sureBitti;
    ImageView v11,v12,v21,v22;
    int k1,e1,k2,e2;
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    Map<String, Object> data;
    Boolean tik11 = false, tik12 = false, tik21= false, tik22= false;
    ArrayList<Integer> kartlar = new ArrayList<>();
    Switch switchSes;
    boolean muzik;
    String karakter1,karakter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tek_level1);

        switchSes = findViewById(R.id.switchTek1);

        oyunMuzik = MediaPlayer.create(TekLevel1Activity.this,R.raw.oyunmuzik);
        dogruMuzik = MediaPlayer.create(TekLevel1Activity.this,R.raw.dogrumuzik);
        oyunBitti = MediaPlayer.create(TekLevel1Activity.this,R.raw.oyunbitti);
        sureBitti = MediaPlayer.create(TekLevel1Activity.this,R.raw.surebittimuzik);
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

        random();
        kartlar.add(R.id.v1);
        kartlar.add(R.id.v2);
        kartlar.add(R.id.v3);
        kartlar.add(R.id.v4);
        Collections.shuffle(kartlar);
        sure = findViewById(R.id.sure);
        skor = findViewById(R.id.skor);
        v11 = (ImageView) findViewById(kartlar.get(0));
        v12 = (ImageView) findViewById(kartlar.get(1));
        v21 = (ImageView) findViewById(kartlar.get(2));
        v22 = (ImageView) findViewById(kartlar.get(3));
        v11.setImageResource(R.drawable.arkayuzguncel);
        v21.setImageResource(R.drawable.arkayuzguncel);
        v12.setImageResource(R.drawable.arkayuzguncel);
        v12.setImageResource(R.drawable.arkayuzguncel);
        v11.setEnabled(false);
        v12.setEnabled(false);
        v21.setEnabled(false);
        v22.setEnabled(false);
    }
    public void kontrol(){
        if(tik11 && tik12){
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    tik11 = false;
                    tik12 = false;
                    etki = ((((puan11 + puan22)/2)*4) * ((45.0 - kalansure)/10.0));
                    sonSkor = sonSkor - etki;
                    skor.setText("SKOR:" + sonSkor);
                    v11.setImageResource(R.drawable.arkayuzguncel);
                    v12.setImageResource(R.drawable.arkayuzguncel);
                }
            },800);

        }if(tik11 && tik21){
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
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
                    etki = ((4*puan11)*(kalansure/10.0));
                    sonSkor = sonSkor + etki;
                    skor.setText("SKOR:" + sonSkor);
                }
            },800);

        }if(tik11 && tik22){
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    tik11 = false;
                    tik22 = false;
                    etki = ((((puan11 + puan22)/2)*4) * ((45.0 - kalansure)/10.0));
                    sonSkor = sonSkor - etki;
                    skor.setText("SKOR:" + sonSkor);
                    v11.setImageResource(R.drawable.arkayuzguncel);
                    v22.setImageResource(R.drawable.arkayuzguncel);
                }
            },800);

        }if(tik12 && tik21){
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    tik12 = false;
                    tik21 = false;
                    etki = ((((puan11 + puan22)/2)*4) * ((45.0 - kalansure)/10.0));
                    sonSkor = sonSkor - etki;
                    skor.setText("SKOR:" + sonSkor);
                    v12.setImageResource(R.drawable.arkayuzguncel);
                    v21.setImageResource(R.drawable.arkayuzguncel);
                }
            },800);

        }if(tik12 && tik22){
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
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
                    etki = ((4*puan22)*(kalansure/10.0));
                    sonSkor = sonSkor + etki;
                    skor.setText("SKOR:" + sonSkor);
                }
            },800);
        }if(tik21 && tik22){
            Handler handeler = new Handler();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    tik21 = false;
                    tik22 = false;
                    etki = ((((puan11 + puan22)/2)*4) * ((45.0 - kalansure)/10.0));
                    sonSkor = sonSkor - etki;
                    skor.setText("SKOR:" + sonSkor);
                    v21.setImageResource(R.drawable.arkayuzguncel);
                    v22.setImageResource(R.drawable.arkayuzguncel);
                }
            },800);
        }
    }
    public void kontrol2(){
        if(v11.getVisibility() == View.INVISIBLE
                && v12.getVisibility() == View.INVISIBLE
                && v21.getVisibility() == View.INVISIBLE
                && v22.getVisibility() == View.INVISIBLE){
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
        k1 = (int)(Math.random()*(11));
        k2 = (int)(Math.random()*(11));
        if(k1==0){karakter1 = "Albus Dumbledore";}
        if(k1==1){karakter1 = "Arthur Weasley";}
        if(k1==2){karakter1 = "Harry Potter";}
        if(k1==3){karakter1 = "Hermione Granger";}
        if(k1==4){karakter1 = "Lily Potter";}
        if(k1==5){karakter1 = "Minerva McGonagall";}
        if(k1==6){karakter1 = "Peter Pettigrew";}
        if(k1==7){karakter1 = "Remus Lupin";}
        if(k1==8){karakter1 = "Ron Weasley";}
        if(k1==9){karakter1 = "Rubeus Hagrid";}
        if(k1==10){karakter1 = "Sirius Black";}
        if(k2==0){karakter2 = "Andromeda Tonks";}
        if(k2==1){karakter2 = "Bellatrix Lestrange";}
        if(k2==2){karakter2 = "Dolores Umbridge";}
        if(k2==3){karakter2 = "Draco Malfoy";}
        if(k2==4){karakter2 = "Evan Rosier";}
        if(k2==5){karakter2 = "Horace Slughorn";}
        if(k2==6){karakter2 = "Leta Lestrange";}
        if(k2==7){karakter2 = "Lucius Malfoy";}
        if(k2==8){karakter2 = "Narcissa Malfoy";}
        if(k2==9){karakter2 = "Severus Snape";}
        if(k2==10){karakter2 = "Tom Riddle";}
    }
    public void baslaClicked(View view){
        v11.setEnabled(true);
        v12.setEnabled(true);
        v21.setEnabled(true);
        v22.setEnabled(true);

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
                vericek2();
                tik12= true;
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
                vericek2();
                tik22=true;
                kontrol();
            }
        });
        new CountDownTimer(45000,1000){
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
                v21.setEnabled(false);
                v22.setEnabled(false);
                AlertDialog.Builder alert = new AlertDialog.Builder(TekLevel1Activity.this);
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
                        Intent intent = new Intent(TekLevel1Activity.this,TekLevel2Activity.class);
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
                                if(i == k1){
                                    puan1 = (String) data.get("puan");
                                    puan11 = Double.parseDouble(puan1);
                                    Toast.makeText(TekLevel1Activity.this,karakter1 +" "+puan1+" Gryffindor", Toast.LENGTH_SHORT).show();
                                    if(tik11){
                                        v11.setImageBitmap(decoded);
                                    }
                                    if(tik21){
                                        v21.setImageBitmap(decoded);
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
                                if(i == k2){
                                    puan2 = (String) data.get("puan");
                                    puan22 = Double.parseDouble(puan2);
                                    Toast.makeText(TekLevel1Activity.this,karakter2+" "+puan2+" Slytherin", Toast.LENGTH_SHORT).show();
                                    if(tik12){
                                        v12.setImageBitmap(decoded);
                                    }
                                    if(tik22){
                                        v22.setImageBitmap(decoded);
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