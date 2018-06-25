package studio.emcorp.hafizhafizah;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnPilihKarakter, btnTentang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        btnTentang = (Button)findViewById(R.id.btnTentang);
        btnPilihKarakter = (Button)findViewById(R.id.btnPilihKarakter);

        btnPilihKarakter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,KarakterActivity.class);
                startActivity(i);
                finish();
            }
        });
        btnTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,TentangActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void menuExit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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
    public void onBackPressed() {
        menuExit();
    }


}
