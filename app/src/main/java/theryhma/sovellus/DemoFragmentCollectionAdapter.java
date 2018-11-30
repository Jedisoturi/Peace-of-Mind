package theryhma.sovellus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class DemoFragmentCollectionAdapter extends FragmentStatePagerAdapter {

    public DemoFragmentCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        i = i + 1;
        if (i==1) {
            DemoFragment demoFragment = new DemoFragment();
            return demoFragment;
        } else {
            ButtonFragment buttonFragment = new ButtonFragment();
            Bundle bundle = new Bundle();
            TipOfTheDay tip = TipOfTheDayGenerator.generate();
            String message = tip.getTitle();
            bundle.putString("message", message);
            buttonFragment.setArguments(bundle);
            return buttonFragment;
        }
    }

    @Override
    public int getCount() {
        return 100;
    }
}
