package studio.emcorp.hafizhafizah.Adapter;

/**
 * Created by ASUS on 21/09/2015.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import studio.emcorp.hafizhafizah.Fragment.CaraFragment;
import studio.emcorp.hafizhafizah.Fragment.TajwidFragment;
import studio.emcorp.hafizhafizah.Fragment.TentangFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TentangFragment tab1 = new TentangFragment();
                return tab1;
            case 1:
                CaraFragment tab2 = new CaraFragment();
                return tab2;
            case 2:
                TajwidFragment tab3 = new TajwidFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
