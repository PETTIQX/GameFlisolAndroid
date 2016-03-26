package estudo.android.gameflisolandroid.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by jordy on 26/03/16.
 */
public class TabFragmentPageAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 2;
    private final String[] tabsNames = {"Perguntas","Pontuação"};
    private Context context;

    public TabFragmentPageAdapter(Context context,FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabsNames[position];
    }
}
