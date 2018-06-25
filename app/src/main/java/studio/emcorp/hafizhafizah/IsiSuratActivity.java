package studio.emcorp.hafizhafizah;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class IsiSuratActivity extends AppCompatActivity {
    String[][] dataSurat = new String [][] {
            {"Al-Fatihah","alfatihah","alfatihah_full","alfatihah","alfatihah_female"},
            {"An-Naba'","annaba","annaba_full","annaba","annaba_female"},
            {"An-Nazi'at","annaziat","annaziat_full","annaziat","annaziat_female"},
            {"'Abasa","abasa","abasa_full","abasa","abasa_female"},
            {"At-Takwir","attakwir","attakwir_full","attakwir","attakwir_female"},
            {"AL-Infithar","alinfithar","alinfithar_full","alinfithar","alinfithar_female"},
            {"Al-Muthafifin","almuthafifin","almuthafifin_full","almuthafifin","almuthafifin_female"},
            {"Al-Insyiqaq","alinsyiqaq","alinsyiqaq_full","alinsyiqaq","alinsyiqaq_female"},
            {"Al-Buruuj","alburuuj","alburuuj_full","alburuuj","alburuuj_female"},
            {"Ath-Thariq","aththariq","aththariq_full","aththariq","aththariq_female"},
            {"Al-A'la","alala","alala_full","alala","alala_female"},
            {"AL-Ghasiyah","alghasiyah","alghasiyah_full","alghasiyah","alghasiyah_female"},
            {"AL-Fajr","alfajr","alfajr_full","alfajr","alfajr_female"},
            {"Al-Balad","albalad","albalad_full","albalad","albalad_female"},
            {"Asy-Syams","asysyams","asysyams_full","asysyams","asysyams_female"},
            {"Al-Lail","allail","allail_full","allail","allail_female"},
            {"Adh-Dhuha","adhdhuha","adhdhuha_full","adhdhuha","adhdhuha_female"},
            {"Alam Nashrah","alamnashrah","alamnashrah_full","alamnashrah","alamnashrah_female"},
            {"At-Tiin","attiin","attiin_full","attiin","attiin_female"},
            {"Al-'Alaq","alalaq","alalaq_full","alalaq","alalaq_female"},
            {"Al-Qadr","alqadr","alqadr_full","alqadr","alqadr_female"},
            {"Al-Bayyinah","albayyinah","albayyinah_full","albayyinah","albayyinah_female"},
            {"Al-Zalzalah","alzalzalah","alzalzalah_full","alzalzalah","alzalzalah_female"},
            {"AL-'Adhiyat","aladhiyat","aladhiyat_full","aladhiyat","aladhiyat_female"},
            {"Al-Qari'ah","alqariah","alqariah_full","alqariah","alqariah_female"},
            {"At-Takatsur","attakatsur","attakatsur_full","attakatsur","attakatsur_female"},
            {"Al-'Ashr","alashr","alashr_full","alashr","alashr_female"},
            {"Al-Humazah","alhumazah","alhumazah_full","alhumazah","alhumazah_female"},
            {"Al-Fil","alfil","alfil_full","alfil","alfil_female"},
            {"AL-Quraisy","alquraisy","alquraisy_full","alquraisy","alquraisy_female"},
            {"Al-Ma'un","almaun","almaun_full","almaun","almaun_female"},
            {"Al-Kautsar","alkautsar","alkautsar_full","alkautsar","alkautsar_female"},
            {"Al-Kafirun","alkafirun","alkafirun_full","alkafirun","alkafirun_female"},
            {"An-Nashr","annashr","annashr_full","annashr","annashr_female"},
            {"Al-Lahab","allahab","allahab_full","allahab","allahab_female"},
            {"Al-Ikhlas","alikhlas","alikhlas_full","alikhlas","alikhlas_female"},
            {"Al-Falaq","alfalaq","alfalaq_full","alfalaq","alfalaq_female"},
            {"An-Nas ","annas","annas_full","annas","annas_female"},
    };
    String surat = "", karakter = "";
    ImageView imgFull, imgTajwid;
    Button btnFull, btnTajwid;
    ScrollView loFull, loTajwid;
    FloatingActionButton btnPlay;
//    MediaPlayer mediaPlayer;
    boolean playMusic = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_surat);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);Bundle extras = getIntent().getExtras();
        imgFull = (ImageView)findViewById(R.id.imgFull);
        imgTajwid = (ImageView)findViewById(R.id.imgTajwid);
//        btnFull = (Button) findViewById(R.id.btnFull);
        loFull = (ScrollView) findViewById(R.id.loFull);
        loTajwid = (ScrollView) findViewById(R.id.loTajwid);
        btnTajwid = (Button) findViewById(R.id.btnTajwid);
        btnFull = (Button) findViewById(R.id.btnFull);
        btnPlay = (FloatingActionButton) findViewById(R.id.btnPlay);


        if (extras != null) {
            karakter = extras.getString("KARAKTER");
            surat = extras.getString("SURAT");
            getSupportActionBar().setTitle(dataSurat[Integer.valueOf(surat)][0]);
            int resIdFull = getResources().getIdentifier(dataSurat[Integer.valueOf(surat)][2], "drawable", getPackageName());
            int resIdTajwid = getResources().getIdentifier(dataSurat[Integer.valueOf(surat)][1], "drawable", getPackageName());
            imgFull.setImageResource(resIdFull);
            imgTajwid.setImageResource(resIdTajwid);
            int resID = 0;
            if(karakter.equals("HAFIZAH")){
//                resID = getResources().getIdentifier(dataSurat[Integer.valueOf(surat)][4], "raw", getPackageName());
            }else{
//                resID = getResources().getIdentifier(dataSurat[Integer.valueOf(surat)][3], "raw", getPackageName());
            }
//            mediaPlayer = MediaPlayer.create(IsiSuratActivity.this, resID);
//            mediaPlayer.start();
        }

        btnFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                playSound();
                loFull.setVisibility(View.VISIBLE);
                loTajwid.setVisibility(View.GONE);
            }
        });
        btnTajwid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                playSound();
                loFull.setVisibility(View.GONE);
                loTajwid.setVisibility(View.VISIBLE);
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(playMusic){
                    playMusic = false;
                    btnPlay.setImageResource(R.drawable.ic_play);
                }else{
                    playMusic = true;
                    btnPlay.setImageResource(R.drawable.ic_pause);
                }
            }
        });
    }

    public void playSound(){
        int resID = 0;
        if(karakter.equals("HAFIZAH")){
            resID = getResources().getIdentifier(dataSurat[Integer.valueOf(surat)][4], "raw", getPackageName());
        }else{
            resID = getResources().getIdentifier(dataSurat[Integer.valueOf(surat)][3], "raw", getPackageName());
        }
//        mediaPlayer.stop();
//        mediaPlayer = MediaPlayer.create(IsiSuratActivity.this, resID);
//        mediaPlayer.start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(IsiSuratActivity.this, SuratActivity.class);
                i.putExtra("KARAKTER",karakter);
                i.putExtra("SURAT",surat);
                startActivity(i);
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        menuExit();
    }

    public void menuExit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(IsiSuratActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.drawable.ic_logo);
        builder.setMessage("Anda yakin ingin keluar?");
        builder.setPositiveButton("Cancel",
                new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        dialog.cancel();
                    }
                });

        builder.setNegativeButton("Keluar",
                new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        System.exit(0);
                        finish();
                    }
                });

        builder.show();
    }

    @Override
    public void onPause() {
//        mediaPlayer.stop();
        super.onPause();
    }
}
