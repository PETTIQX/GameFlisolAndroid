package estudo.android.gameflisolandroid.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabFragmentPageAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 3;
    private final String[] tabsNames = {"Perguntas","Pontuação","Ranking Geral"};
    private Context context;

    public TabFragmentPageAdapter(Context context,FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position);
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
