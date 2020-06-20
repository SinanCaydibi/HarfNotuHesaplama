package com.example.harf_notu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    List<Float> ddliste = new ArrayList<Float>();
    List<Float> dcliste = new ArrayList<Float>();
    List<Float> ccliste = new ArrayList<Float>();
    List<Float> cbliste = new ArrayList<Float>();
    List<Float> bbliste = new ArrayList<Float>();
    List<Float> baliste = new ArrayList<Float>();
    List<Float> ffliste = new ArrayList<Float>();
    List<Float> fdliste = new ArrayList<Float>();
    List<Float> aaliste = new ArrayList<Float>();



    EditText txt_vize;
    EditText txt_final;
    EditText txt_standart_sapma;
    EditText txt_ham_ort;
    ImageView img_hesap;
    float ortalama = 0;


    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = findViewById(R.id.adView);
        MobileAds.initialize(this,"ca-app-pub-3830426928924111~2994943559");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        txt_vize = findViewById(R.id.et_vize);
        txt_final = findViewById(R.id.et_final);
        txt_standart_sapma = findViewById(R.id.et_Standart_Sapma);
        txt_ham_ort = findViewById(R.id.et_hamOrt);
        img_hesap = findViewById(R.id.img_hesapla);
        img_hesap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!txt_vize.getText().toString().isEmpty() &&!txt_final.getText().toString().isEmpty() &&!txt_standart_sapma.getText().toString().isEmpty() &&!txt_ham_ort.getText().toString().isEmpty())
                    hesapla();
                else{
                    Toast.makeText(MainActivity.this, "Boş bırakmayınız..", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    public void hesapla() {

        String svize = txt_vize.getText().toString();
        float vize = Float.parseFloat(svize);
        float finaal = Float.parseFloat(txt_final.getText().toString());
        float ss = Float.parseFloat(txt_standart_sapma.getText().toString());
        float hamort = Float.parseFloat(txt_ham_ort.getText().toString());
        float hbn = 41;
        float z = (ortalama - hbn) / ss;
        float k = (float) ((0.5 * ss) + 5);//cast etmem gerekiyor sebebi nedir ?
        float T = k * z + 60;
        float m = (float) (0.4 * (60.00 - hbn));
        if (T <= (42.99 + m) || finaal < 35 || ortalama < 30) {
            StaticValues.not = "FF";

        }
        else if (T > (43.00 + m) && T < (47.99 + m)) {
            StaticValues.not = "FD";

        }
        else if (T > (48.00 + m) && T < (52.99 + m)) {
            StaticValues.not = "DD";

        }
        else if (T > (53.00 + m) && T < (57.99 + m)) {
            StaticValues.not = "DC";


        }
        else if (T > (58.00 + m) && T < (62.99 + m)) {
            StaticValues.not = "CC";


        }
        else if (T > (63.00 + m) && T < (67.99 + m)) {
            StaticValues.not = "CB";


        }
        else if (T > (68.00 + m) && T < (72.99 + m)) {
            StaticValues.not = "BB";



        }
        else if (T > (73.00 + m) && T < (77.99 + m)) {
            StaticValues.not = "BA";


        }
        else if (T >= 78 + m) {
            StaticValues.not = "AA";


        }

        float i;
        float vv;
        float vf;
        float sapma;
        float ze;
        float ke;
        float Te;
        float me;


        for (i = 35; i < 101; i++) {
            vv = vize;
            vf = (float) ((vv * 0.4) + (i * 0.6));
            sapma = ss;
            ze = (vf - hamort) / sapma;
            ke = (float) ((0.5 * ss) + 5);
            Te = ke * ze + 60;
            me = (float) (0.40 * (60.00 - hamort));
            if (Te > (48.00 + me) && Te < (52.99 + me)) {
                Log.d("---","dd");

                ddliste.add(i);
            }
            else if (Te > (53.00 + me) && Te < (57.99 + me)) {
                Log.d("---","dc");
                dcliste.add(i);
            }
            else if (Te > (58.00 + me) && Te < (62.99 + me)) {
                Log.d("---","cc");
                ccliste.add(i);
            }
            else if (Te > (63.00 + me) && Te < (67.99 + me)) {
                cbliste.add(i);
                Log.d("---","cb");
            }
            else if (Te > (68.00 + me) && Te < (72.99 + me)) {
                Log.d("---","bb");
                bbliste.add(i);
            }
            else if (Te > (73.00 + me) && Te < (77.99 + me)) {
                Log.d("---","ba");

                baliste.add(i);
            }
            else if (Te >= 78 + me) {
                Log.d("---","aa");
                aaliste.add(i);
            }

        }
        if (aaliste.size() > 0) {
            StaticValues.not_sayisal = aaliste.get(0).toString();
                }
        if (baliste.size() > 0) {
            StaticValues.not_sayisal2 = baliste.get(0).toString();
                }
        if (bbliste.size() > 0) {
            StaticValues.not_sayisal3 = bbliste.get(0).toString();
                }
        if (cbliste.size() > 0) {
            StaticValues.not_sayisal4 = cbliste.get(0).toString();
                }
        if (ccliste.size() > 0) {
            StaticValues.not_sayisal5 = ccliste.get(0).toString();
                }
        if (dcliste.size() > 0) {
            StaticValues.not_sayisal6 = dcliste.get(0).toString();
                }
        if (ddliste.size() > 0) {
            StaticValues.not_sayisal7 = ddliste.get(0).toString();
                }
        if (fdliste.size() > 0) {
            StaticValues.not_sayisal8 = fdliste.get(0).toString();
                }
        if (ffliste.size() > 0) {
            StaticValues.not_sayisal9 = ffliste.get(0).toString();
        }
        Intent intent = new Intent(this, not_hesapla_Activity.class);
        startActivity(intent);
        }


    @Override
    protected void onResume() {
        if(mAdView!=null) mAdView.resume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        if(mAdView!=null) mAdView.pause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if(mAdView!=null) mAdView.destroy();
        super.onDestroy();
    }
    }


