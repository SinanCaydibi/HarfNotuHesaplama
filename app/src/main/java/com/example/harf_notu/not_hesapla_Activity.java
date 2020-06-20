package com.example.harf_notu;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class not_hesapla_Activity extends AppCompatActivity  {
    TextView txt_harf_aa;
    TextView txt_harf_ba;
    TextView txt_harf_cb;
    TextView txt_harf_bb;
    TextView txt_harf_cc;
    TextView txt_harf_dc;
    TextView txt_harf_dd;
    TextView txt_harf_fd;
    TextView txt_harf_ff;
//    TextView txt_not;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_hesapla_);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        AdView mAdView = findViewById(R.id.adView);
        MobileAds.initialize(this,"ca-app-pub-3830426928924111~2994943559");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

//        txt_not=findViewById(R.id.not);
        txt_harf_aa=findViewById(R.id.harf_AA);
        txt_harf_ba=findViewById(R.id.harf_BA);
        txt_harf_bb=findViewById(R.id.harf_BB);
        txt_harf_cb=findViewById(R.id.harf_CB);
        txt_harf_cc=findViewById(R.id.harf_CC);
        txt_harf_dc=findViewById(R.id.harf_DC);
        txt_harf_dd=findViewById(R.id.harf_DD);
        txt_harf_fd=findViewById(R.id.harf_FD);
        txt_harf_ff=findViewById(R.id.harf_FF);
//        txt_not.setText("Notunuz:"+StaticValues.not);

        txt_harf_aa.setText("AA alma ihtimaliniz yok");
        txt_harf_ba.setText("BA alma ihtimaliniz yok");
        txt_harf_bb.setText("BB alma ihtimaliniz yok");
        txt_harf_cb.setText("CB alma ihtimaliniz yok");
        txt_harf_cc.setText("CC alma ihtimaliniz yok");
        txt_harf_dd.setText("DD alma ihtimaliniz yok");
        txt_harf_dc.setText("DC alma ihtimaliniz yok");
        txt_harf_fd.setText("FD alma ihtimaliniz yok");
        txt_harf_ff.setText("FF alma ihtimaliniz yok");

        if(StaticValues.not_sayisal!=null)
            txt_harf_aa.setText("AA için almanız gereken Not:"+StaticValues.not_sayisal);
        if(StaticValues.not_sayisal2!=null)
            txt_harf_ba.setText("BA için almanız gereken Not:"+StaticValues.not_sayisal2);
        if(StaticValues.not_sayisal3!=null)
            txt_harf_bb.setText("BB için almanız gereken Not:"+StaticValues.not_sayisal3);
        if(StaticValues.not_sayisal4!=null)
            txt_harf_cb.setText("CB için almanız gereken Not:"+StaticValues.not_sayisal4);
        if(StaticValues.not_sayisal5!=null)
            txt_harf_cc.setText("CC için almanız gereken Not:"+StaticValues.not_sayisal5);
        if(StaticValues.not_sayisal6!=null)
            txt_harf_dc.setText("DC için almanız gereken Not:"+StaticValues.not_sayisal6);
        if(StaticValues.not_sayisal7!=null)
            txt_harf_dd.setText("DD için almanız gereken Not:"+StaticValues.not_sayisal7);
        if(StaticValues.not_sayisal8!=null)
            txt_harf_fd.setText("FD için almanız gereken Not:"+StaticValues.not_sayisal8);
        if(StaticValues.not_sayisal9!=null)
            txt_harf_ff.setText("FF için almanız gereken Not:"+StaticValues.not_sayisal9);


      }
}
