package studio.emcorp.hafizhafizah.Adapter;

/**
 * Created by ASUS on 02/06/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import studio.emcorp.hafizhafizah.R;

public class CustomGrid extends BaseAdapter{
    private Context mContext;
    private final String[] web;

    public CustomGrid(Context c,String[] web) {
        mContext = c;
        this.web = web;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View v;
        if(convertView==null)
        {
            LayoutInflater li = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.grid_single, null);
        }else{
            v = convertView;
        }
        TextView textView = (TextView) v.findViewById(R.id.grid_text);
        textView.setText(web[position]);
        return v;
//        View grid;
//        LayoutInflater inflater = (LayoutInflater) mContext
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        if (convertView == null) {
//
//            grid = new View(mContext);
//            grid = inflater.inflate(R.layout.grid_single, null);
//            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
//            textView.setText(web[position]);
//        } else {
//            grid = (View) convertView;
//        }
//
//        return grid;
    }
}