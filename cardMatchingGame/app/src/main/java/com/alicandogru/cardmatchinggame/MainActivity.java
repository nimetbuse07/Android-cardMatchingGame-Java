package com.alicandogru.cardmatchinggame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.alicandogru.cardmatchinggame.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    HashMap<String, Object> userData = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();


    }

    public void girisClick(View view){
        String kAdi = binding.nameText.getText().toString();
        String email = binding.emailText.getText().toString();
        String sifre = binding.sifreText.getText().toString();


        if(email.equals("") || sifre.equals("")){
            Toast.makeText(this, "Lütfen bir email ve şifre giriniz!", Toast.LENGTH_LONG).show();
        }else {
            mAuth.signInWithEmailAndPassword(email,sifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Intent intent = new Intent(MainActivity.this,SecimActivity.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this,e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }

    }

    public void kayitClick(View view){
        String kAdi = binding.nameText.getText().toString();
        String email = binding.emailText.getText().toString();
        String sifre = binding.sifreText.getText().toString();

        HashMap<String, Object> userData = new HashMap<>();
        userData.put("Name",kAdi);
        userData.put("Email",email);
        userData.put("Sifre",sifre);


        if (email.equals("") || sifre.equals("")){
            Toast.makeText(this, "Lütfen bir email ve şifre giriniz!", Toast.LENGTH_LONG).show();
        }else {
            mAuth.createUserWithEmailAndPassword(email,sifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(MainActivity.this,"Kayıt Başarılı",Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this,e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });
            firestore.collection("Users")
                    .document(email)
                    .set(userData).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(MainActivity.this, "fireStore'a Kayıt Yapıldı", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity.this,e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        }

    }
    public void veriyiGuncelle(HashMap<String, Object> userData){
        String email = binding.emailText.getText().toString();
        String guncelSifre = binding.sifreGuncelleText.getText().toString();

        if(email.equals("") || guncelSifre.equals("")){
            Toast.makeText(this, "Lütfen bir email ve güncel şifre giriniz", Toast.LENGTH_LONG).show();
        }else{
        firestore.collection("Users")
                .document(email)
                .update(userData)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            userData.put("Sifre",guncelSifre);
                            Toast.makeText(MainActivity.this, "Guncelleme Basarılı", Toast.LENGTH_LONG).show();
                        }
                    }
                });
        }
    }
    public void sifreGuncelle(View v){
        String guncelSifre = binding.sifreGuncelleText.getText().toString();
        if(!TextUtils.isEmpty(guncelSifre)){
            userData = new HashMap<>();
            userData.put("Sifre",guncelSifre);
            veriyiGuncelle(userData);

        }

    }

    public void guncelleClick(View view){
        String email = binding.emailText.getText().toString();
        sifreGuncelle(view);
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Lütfen e-mail'inizi kontrol ediniz!!", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this,"ERROR:" + task.getException(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}