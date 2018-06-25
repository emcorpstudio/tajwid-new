package studio.emcorp.hafizhafizah;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import studio.emcorp.hafizhafizah.Adapter.CustomGrid;

public class SuratActivity extends AppCompatActivity {

    String[] listSurat = {
            "Al-Fatihah",
            "An-Naba'",
            "An-Nazi'at",
            "'Abasa",
            "At-Takwir",
            "AL-Infithar",
            "Al-Muthafifin",
            "Al-Insyiqaq",
            "Al-Buruuj",
            "Ath-Thariq",
            "Al-A'la",
            "AL-Ghasiyah",
            "AL-Fajr",
            "Al-Balad",
            "Asy-Syams",
            "Al-Lail",
            "Adh-Dhuha",
            "Alam Nashrah",
            "At-Tiin",
            "Al-'Alaq",
            "Al-Qadr",
            "Al-Bayyinah",
            "Al-Zalzalah",
            "AL-'Adhiyat",
            "Al-Qari'a",
            "At-Takatsur",
            "Al-'Ashr",
            "Al-Humazah",
            "Al-Fil",
            "AL-Quraisy",
            "Al-Ma'u",
            "Al-Kautsar",
            "Al-Kafirun",
            "An-Nashr",
            "Al-Lahab",
            "Al-Ikhlas",
            "Al-Falaq",
            "An-Nas "
    } ;
    String karakter = "";
    GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surat);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            karakter = extras.getString("KARAKTER");
            if(karakter.equals("COWOK")){
                karakter = "HAFIZ";
            }else{
                karakter = "HAFIZAH";
            }
            getSupportActionBar().setTitle(karakter);
        }
        //https://islamdownload.net/123862-download-murottal-muhammad-thoha-al-junaid.html
        //https://www.youtube.com/watch?v=JwmLzLyH1p4
        grid=(GridView)findViewById(R.id.grid);
        CustomGrid adapter = new CustomGrid(SuratActivity.this, listSurat);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(SuratActivity.this, "You Clicked at " +listSurat[position], Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SuratActivity.this,IsiSuratActivity.class);
                i.putExtra("KARAKTER",karakter);
                i.putExtra("SURAT",String.valueOf(position));
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(SuratActivity.this, KarakterActivity.class);
                startActivity(i);
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(SuratActivity.this, KarakterActivity.class);
        startActivity(i);
        finish();
    }
}
