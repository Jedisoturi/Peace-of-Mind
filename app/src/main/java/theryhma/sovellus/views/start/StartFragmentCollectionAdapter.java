package theryhma.sovellus.views.start;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.Menu;

import theryhma.sovellus.views.ButtonFragment;
import theryhma.sovellus.views.DemoFragment;

public class StartFragmentCollectionAdapter extends FragmentStatePagerAdapter {

    public StartFragmentCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            GifFragment gifFragment = new GifFragment();
            return gifFragment;
        } else {
            MenuFragment menuFragment = new MenuFragment();
            return menuFragment;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
