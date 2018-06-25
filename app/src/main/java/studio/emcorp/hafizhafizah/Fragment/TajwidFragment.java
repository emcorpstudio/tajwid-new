package studio.emcorp.hafizhafizah.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import studio.emcorp.hafizhafizah.Adapter.CustomGrid;
import studio.emcorp.hafizhafizah.R;


public class TajwidFragment extends Fragment {
    String[] dataTajwid = {
            "NUN MATI / TANWIN",
            "MIM MATI",
            "HUKUM IDGHAM",
            "HUKUM MAD",
            "HUKUM RA'",
            "HUKUM LAM",
            "NUN / MIM TASYDID",
            "QALQALAH",
            "TANDA-TANDA WAQAF",
            "BACAAN KHUSUS"
    } ;
    String[][] dataIsiTajwid = new String [][]{
            {"NUN MATI / TANWIN", "IZHAR", "izhar"},
            {"NUN MATI / TANWIN", "IDGHAM", "idgham"},
            {"NUN MATI / TANWIN", "IKHFA", "ikhfa"},
            {"NUN MATI / TANWIN", "IQLAB", "iqlab"},
            {"MIM MATI", "IKHFA SYAFAWI", "ikhfasyafawi"},
            {"MIM MATI", "IDGHAM MISLAIN", "idghammislain"},
            {"MIM MATI", "IZHAR SYAFAWI", "izharsyafawi"},
            {"HUKUM IDGHAM", "IDGHAM MUTAMATSILAIN", "idghammutamatsilain"},
            {"HUKUM IDGHAM", "IDGHAM MUTAJANISAIN", "idghammutajanisain"},
            {"HUKUM IDGHAM", "IDGHAM MUTAQARIBAIN", "idghammutaqaribain"},
            {"HUKUM MAD", "MAD ASLI / MAD THOBI'I", "madasli"},
            {"HUKUM MAD", "MAD WAJIB MUTTASIL", "madwajib"},
            {"HUKUM MAD", "MAD JA'IZ MUNFASIL", "madjaiz"},
            {"HUKUM MAD", "MAD LIN", "madlin"},
            {"HUKUM MAD", "MAD BADAL", "madbadal"},
            {"HUKUM MAD", "MAD TAMKIN", "madtamkin"},
            {"HUKUM MAD", "MAD 'IWADH'", "madiwad"},
            {"HUKUM MAD", "MAD ARID LISSUKUN", "madarid"},
            {"HUKUM MAD", "MAD FARQ", "madfarq"},
            {"HUKUM MAD", "MAD SILAH QASIRAH", "madsilahqasirah"},
            {"HUKUM MAD", "MAD SILAH TAWILAH", "madsilahtawilah"},
            {"HUKUM MAD", "MAD LAZIM MUTHAQQAL KALIMI", "madlazimmuthaqqal"},
            {"HUKUM MAD", "MAD LAZIM MUKHAFFAF KALIMI", "madlazimmukhaffafkalimi"},
            {"HUKUM MAD", "MAD LZAIM MUTHAQQAL HARFI", "madlazimmuthaqqalharfi"},
            {"HUKUM MAD", "MAD LAZIM MUKHAFFAF HARFI", "madlazimmukhaffafharfi"},
            {"HUKUM RA'", "RA' TAFKHIM", "ratafkhim"},
            {"HUKUM RA'", "RA' TARQIQ", "ratarqiq"},
            {"HUKUM RA'", "RA' JAWAJUL WAHJAIN", "rajawajul"},
            {"HUKUM LAM", "LAM TA'RIF", "lamtarif"},
            {"HUKUM LAM", "LAFAZ AL-JAZALAH", "lafaz"},
            {"NUN / MIM TASYDID", "NUN DAN MIM TASYDID", "nundanmim"},
            {"QALQALAH", "QALQALAH", "qalqalah"},
            {"TANDA-TANDA WAQAF", "TANDA-TANDA WAQAF", "tandawaqaf"},
            {"BACAAN KHUSUS", "HAMZAH WASAL", "hamzah"},
            {"BACAAN KHUSUS", "NUN 'IWAD", "nuniwad"},
            {"BACAAN KHUSUS", "ISYMAM", "isymam"},
            {"BACAAN KHUSUS", "IMALAH", "imalah"},
    };
    GridView grid;
    List<String> listTajwid = new ArrayList<String>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tajwid, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        grid=(GridView)view.findViewById(R.id.grid);
        CustomGrid adapter = new CustomGrid(getActivity(), dataTajwid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                Toast.makeText(getActivity(), "You Clicked at " +dataTajwid[position], Toast.LENGTH_SHORT).show();
                dialogTajwid(dataTajwid[position]);
            }
        });
        return view;
    }

    public void dialogTajwid(String tajwid){
        listTajwid.clear();
        for(int i=0;i<dataIsiTajwid.length;i++){
            if(dataIsiTajwid[i][0].equals(tajwid)){
                listTajwid.add(dataIsiTajwid[i][1]);
            }
        }
        final String[] data = new String[listTajwid.size()];
        for(int i=0;i<listTajwid.size();i++){
            data[i] = listTajwid.get(i);
        }
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_detail_tajwid);
        dialog.setTitle(null);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(lp);

        ImageView imgClose = (ImageView) dialog.findViewById(R.id.imgClose);
        TextView tvJudul = (TextView) dialog.findViewById(R.id.tvJudul);
        GridView gridTajwid = (GridView)dialog.findViewById(R.id.grid);
        tvJudul.setText(tajwid);
        CustomGrid adapter = new CustomGrid(getActivity(), data);
        gridTajwid.setAdapter(adapter);
        gridTajwid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                Toast.makeText(getActivity(), "You Clicked at " +data[position], Toast.LENGTH_SHORT).show();
                dialogDetailTajwid(data[position]);
            }
        });

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void dialogDetailTajwid(String tajwid){
        int pos = -1;
        for(int i=0;i<dataIsiTajwid.length;i++){
            if(dataIsiTajwid[i][1].equals(tajwid)){
                pos = i;
                break;
            }
        }
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_penjelasan_tajwid);
        dialog.setTitle(null);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(lp);

        ImageView imgClose = (ImageView) dialog.findViewById(R.id.imgClose);
        ImageView img = (ImageView) dialog.findViewById(R.id.img);
        TextView tvJudul = (TextView) dialog.findViewById(R.id.tvJudul);
        tvJudul.setText(tajwid);
        int resIdTajwid = getResources().getIdentifier(dataIsiTajwid[pos][2], "drawable", getActivity().getPackageName());
        img.setImageResource(resIdTajwid);

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
