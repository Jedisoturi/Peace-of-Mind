package theryhma.sovellus.views.start;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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
