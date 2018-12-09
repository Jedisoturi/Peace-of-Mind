package theryhma.sovellus.views.questions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class QuestionFragmentCollectionAdapter extends FragmentStatePagerAdapter {

    public QuestionFragmentCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == getCount() - 1) {
            QuestionFragment questionFragment = new QuestionFragment();
            Bundle bundle = new Bundle();

            bundle.putInt("index", i);
            bundle.putBoolean("isLast", true);
            questionFragment.setArguments(bundle);
            return questionFragment;
        } else {
            QuestionFragment questionFragment = new QuestionFragment();
            Bundle bundle = new Bundle();

            bundle.putInt("index", i);
            bundle.putBoolean("isLast", false);
            questionFragment.setArguments(bundle);
            return questionFragment;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
