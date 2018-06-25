package studio.emcorp.hafizhafizah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class KarakterActivity extends AppCompatActivity {
    ImageButton btnCowok, btnCewek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karakter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        btnCewek = (ImageButton)findViewById(R.id.btnCewek);
        btnCowok = (ImageButton)findViewById(R.id.btnCowok);

        btnCewek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KarakterActivity.this,SuratActivity.class);
                i.putExtra("KARAKTER","CEWEK");
                startActivity(i);
                finish();
            }
        });
        btnCowok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KarakterActivity.this,SuratActivity.class);
                i.putExtra("KARAKTER","COWOK");
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(KarakterActivity.this, MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(KarakterActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
