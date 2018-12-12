package theryhma.sovellus.views.questions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Fragment Collection adapter for question activity
 */
public class QuestionFragmentCollectionAdapter extends FragmentStatePagerAdapter {

    public QuestionFragmentCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == getCount() - 1) {  // last question
            QuestionFragment questionFragment = new QuestionFragment();
            Bundle bundle = new Bundle();

            bundle.putInt("index", i);
            bundle.putBoolean("isLast", true);
            questionFragment.setArguments(bundle);
            return questionFragment;
        } else {    // other questions
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
